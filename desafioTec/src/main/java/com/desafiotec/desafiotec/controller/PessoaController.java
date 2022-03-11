package com.desafiotec.desafiotec.controller;


import com.desafiotec.desafiotec.controller.Repositories.PessoaRespositories;
import com.desafiotec.desafiotec.model.Pessoas;
import com.desafiotec.desafiotec.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    @Autowired
    PessoaRespositories rp;

    @PostMapping(value = "/post/pessoas")
    public Pessoas gravar(@RequestBody Pessoas pessoas){
        rp.save(pessoas);
        return pessoas;
    }


    @PutMapping("/put/pessoas/{id}")
    public ResponseEntity<Pessoas> updateUser(@PathVariable(value = "id") Long Id,
                                              @Validated @RequestBody Pessoas Pessoas) throws ResourceNotFoundException {
        Pessoas p = rp.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa Não Encontrada no BD:: "+ Pessoas));

        final Pessoas updatedProd = rp.save(p);
        return ResponseEntity.ok(updatedProd);
    }

    @DeleteMapping(value="/delete/pessoas/{id}")
    public void apagarPessoas(@PathVariable Long id){
        Pessoas pessoas = new Pessoas();
        rp.deleteById(id);
    }



}
