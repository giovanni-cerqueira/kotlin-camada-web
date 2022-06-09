package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(
    private var topicos: List<Topico>
) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                1,
                "Kotlin",
                "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Giovanni Cerqueira",
                email = "giovanni@email.com"
            )
        ),

        val topico2 = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                1,
                "Kotlin",
                "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Giovanni Cerqueira",
                email = "giovanni@email.com"
            )
        ),

        val topico3 = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis no Kotlin",
            curso = Curso(
                1,
                "Kotlin",
                "Programacao"
            ),
            autor = Usuario(
                id = 1,
                nome = "Giovanni Cerqueira",
                email = "giovanni@email.com"
            )
        )

        topicos =  Arrays.asList(topico, topico, topico)
    }

    fun listar(): List<Topico> {

    }
}