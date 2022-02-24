package br.com.tech4me.tech4books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4books.model.Livro;
import br.com.tech4me.tech4books.repository.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroRepository repositorio;
    
    @GetMapping
    public ResponseEntity<List<Livro>> obterLivros() {
        return new ResponseEntity<>(repositorio.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Livro> obterLivroPorId(@PathVariable String id){
       Optional<Livro> livro = repositorio.findById(id);

       if (livro.isPresent()) {
        return new ResponseEntity<>(livro.get(), HttpStatus.FOUND);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        return new ResponseEntity<>(repositorio.save(livro), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Livro> atualizarLivro(@RequestBody Livro livro) {
        //Teste com nova branch
        return new ResponseEntity<>(repositorio.save(livro), HttpStatus.CREATED);
    }
}
