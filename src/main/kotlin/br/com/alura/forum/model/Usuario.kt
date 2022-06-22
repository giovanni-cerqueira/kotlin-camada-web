package br.com.alura.forum.model

import javax.persistence.*

@Entity
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val nome: String,
    @Column
    val email: String
) {

}
