package br.com.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "topico")
data class Topico(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    var titulo: String,
    @Column
    var mensagem: String,
    @Column
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @Column
    @ManyToOne
    val curso: Curso,
    @Column
    @ManyToOne
    val autor: Usuario,
    @Column
    @Enumerated(EnumType.STRING)
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    @Column
    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()
)