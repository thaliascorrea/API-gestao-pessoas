package com.thaliascorrea.pessoasapi.controller;

import com.thaliascorrea.pessoasapi.model.Pessoa;
import com.thaliascorrea.pessoasapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> encontrarPorId(@PathVariable Long id){
        return pessoaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Pessoa atualizarPorId(@PathVariable Long id, @RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id){
        pessoaRepository.deleteById(id);
    }
}
