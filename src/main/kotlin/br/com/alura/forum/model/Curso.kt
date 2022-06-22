package br.com.alura.forum.model

import javax.persistence.*

@Entity
data class Curso(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val nome: String,
    @Column
    val categoria: String
) {

}
