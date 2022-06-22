package br.com.alura.forum.model

import javax.persistence.Entity

@Entity
data class Usuario(
    val id: Long? = null,
    val nome: String,
    val email: String
) {

}
