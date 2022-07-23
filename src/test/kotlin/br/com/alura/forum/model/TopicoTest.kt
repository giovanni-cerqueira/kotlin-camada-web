package br.com.alura.forum.model

object TopicoTest {
    fun build() = Topico(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Como declarar variavel?",
        curso = CursoTest.build(),
        autor = UsuarioTest.build()
    )
}