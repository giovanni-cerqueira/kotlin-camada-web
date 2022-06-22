package br.com.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column
    val mensagem: String,
    @Column
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @Column
    @ManyToOne
    val autor: Usuario,
    @Column
    @ManyToOne
    val topico: Topico,
    @Column
    val solucao: Boolean

)
