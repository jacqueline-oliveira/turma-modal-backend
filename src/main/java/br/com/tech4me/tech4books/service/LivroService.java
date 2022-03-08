package br.com.tech4me.tech4books.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.dto.LivroDTO;
import br.com.tech4me.tech4books.model.Livro;

public interface LivroService {
    List<LivroDTO> obterTodosOsLivros();

    Optional<Livro> obterLivroPorId(String id);

    Livro armazenarLivro(Livro livro);

    void excluirLivroPorId(String id);

    Livro atualizarLivro(String id, Livro livro);
}
