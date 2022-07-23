package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {
    override fun map(topico: Topico): TopicoView {
        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao,
            dataAlteracao = topico.dataAlteracao
        )
    }
}