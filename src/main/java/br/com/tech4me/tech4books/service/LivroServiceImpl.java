package br.com.tech4me.tech4books.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.dto.LivroDTO;
import br.com.tech4me.tech4books.model.Livro;
import br.com.tech4me.tech4books.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private LivroRepository repositorio;

    @Override
    public List<LivroDTO> obterTodosOsLivros() {
        List<Livro> livros = repositorio.findAll();
        
        return livros.stream()
                .map(l -> mapper.map(l, LivroDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LivroDTO> obterLivroPorId(String id) {
        Optional<Livro> livro = repositorio.findById(id);

        if(livro.isPresent()) {
            return Optional.of(mapper.map(livro.get(), LivroDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public LivroDTO armazenarLivro(LivroDTO livro) {
        Livro livroGravar = mapper.map(livro, Livro.class);
        livroGravar = repositorio.save(livroGravar);
        
        return mapper.map(livroGravar, LivroDTO.class);
    }

    @Override
    public void excluirLivroPorId(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public LivroDTO atualizarLivro(String id, LivroDTO livro) {
        Livro livroAtualizar = mapper.map(livro, Livro.class);
        livroAtualizar.setId(id);
        livroAtualizar = repositorio.save(livroAtualizar);

        return mapper.map(livroAtualizar, LivroDTO.class);
    }
    
}
