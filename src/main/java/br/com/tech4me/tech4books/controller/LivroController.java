package br.com.tech4me.tech4books.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.dto.LivroDTO;
import br.com.tech4me.tech4books.model.Livro;
import br.com.tech4me.tech4books.service.LivroService;
import br.com.tech4me.tech4books.view.model.LivroResponseDTO;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService servico;
    
    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> obterLivros() {
        List<LivroDTO> dto = servico.obterTodosOsLivros();

        ModelMapper mapper = new ModelMapper();
        
        List<LivroResponseDTO> livros = dto.stream()
           .map(l -> mapper.map(l, LivroResponseDTO.class))
           .collect(Collectors.toList());

        return new ResponseEntity<>(livros, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Livro> obterLivroPorId(@PathVariable String id){
       Optional<Livro> livro = servico.obterLivroPorId(id);

       if (livro.isPresent()) {
        return new ResponseEntity<>(livro.get(), HttpStatus.FOUND);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        return new ResponseEntity<>(servico.armazenarLivro(livro), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable String id) {
        servico.excluirLivroPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable String id, @RequestBody Livro livro) {
        return new ResponseEntity<>(servico.atualizarLivro(id, livro), HttpStatus.ACCEPTED);
    }

}
