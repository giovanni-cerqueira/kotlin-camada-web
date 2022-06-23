package br.com.alura.forum.repository

import br.com.alura.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface CursoRepository: JpaRepository<Curso, Long> {
}