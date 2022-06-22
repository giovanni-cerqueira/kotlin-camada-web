package br.com.alura.forum.model

import javax.persistence.*

@Entity(name = "usuario")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String
) {

}
