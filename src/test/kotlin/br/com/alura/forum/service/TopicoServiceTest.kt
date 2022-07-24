package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.TopicoTest
import br.com.alura.forum.model.TopicoViewTest
import br.com.alura.forum.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*
import javax.persistence.EntityManager

class TopicoServiceTest {

    val slot = slot<Topico>() //para garantir que o objeto Topico seja retornado corretamente antes de ser convertido para TopicoView

    val topicos = PageImpl(listOf(TopicoTest.build()))

    val paginacao: Pageable = mockk()

    val topicoRepository: TopicoRepository = mockk {
        every { findByCursoNome(any(), any()) } returns topicos
        every { findAll(paginacao) } returns topicos
    }

    val topicoViewMapper: TopicoViewMapper = mockk{
        every { map(capture(slot)) } returns TopicoViewTest.build()
    }
    val topicoFormMapper: TopicoFormMapper = mockk()
    private val entityManager: EntityManager = mockk()

    val topicoService = TopicoService(
        topicoRepository, topicoViewMapper, topicoFormMapper,
        notFoundMessage = "Topico nao encontrado!",
        em = entityManager
    )

    @Test
    fun `deve listar topicos a partir do nome do curso`(){

        topicoService.listar("Kotlin Avançado", paginacao)
        val topico = TopicoTest.build()
        assertThat(slot.captured.titulo).isEqualTo(topico.titulo)
        assertThat(slot.captured.mensagem).isEqualTo(topico.mensagem)
        assertThat(slot.captured.status).isEqualTo(topico.status)
        //Uma vez que temos o capture, podemos utilizar o AssertJ e fazer asserções para garantir que o objeto estava correto

        verify(exactly = 1) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoViewMapper.map(any())}
        verify(exactly = 0) { topicoRepository.findAll(paginacao) }
    }

    @Test
    fun `deve listar topicos quando nome do curso for nulo`(){

        topicoService.listar(null, paginacao)

        verify(exactly = 0) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoViewMapper.map(any())}
        verify(exactly = 1) { topicoRepository.findAll(paginacao) }
    }

    @Test
    fun `deve listar not found exception quando topico nao for encontrado`(){
        every { topicoRepository.findById(any()) } returns Optional.empty()

        val atual = assertThrows<NotFoundException> { topicoService.buscarPorId(1) }

        assertThat(atual.message).isEqualTo("Topico nao encontrado!")

    }


}