package com.desafiotec.desafiotec.controller;

import com.desafiotec.desafiotec.controller.Repositories.TarefasRepositories;
import com.desafiotec.desafiotec.model.Pessoas;
import com.desafiotec.desafiotec.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefasController {

    @Autowired
    TarefasRepositories rp;

    @PostMapping(value="/post/tarefas")
    public Tarefa gravar(@RequestBody Tarefa nova){
        rp.save(nova);
        return nova;
    }

    @PutMapping("/put/tarefas/alocar/{id})")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable(value = "id") Long Id,
                                               @Validated @RequestBody Tarefa tarefa)  {

        rp.SalvarPesoaTarefa(Id);
        final Tarefa updatedProd = rp.save(tarefa);
        return ResponseEntity.ok(updatedProd);
    }

    @PutMapping("/put/tarefas/finalizar/{id})")
    public List<Tarefa> updateUser(@PathVariable(value = "id") Long Id){
        return rp.FinalizarTarefa(Id);
    }

    @GetMapping(value="/get/pessoas/{id}")
    public List<Tarefa> getById(@PathVariable Long id) {
        return rp.findByIdAndTAREFAAndNomeAndIdDEPARTAMENTOAndDURACAO(id);
    }

    @GetMapping(value="/get/pessoas/gastos/{nome,periodo}")
    public List<Tarefa> getByIdTarefas(@PathVariable String nome, LocalDate periodo) {
        return rp.findBuscarPessoasPeriodoHoras(nome, periodo);
    }
    @GetMapping(value="/get/tarefas/pendentes/{id}")
    public List<Tarefa> getByIdTarefaDURACAOMIN(@PathVariable Long id) {
        return rp.FindByidTarefaPrazoAntigo(id);
    }

    @GetMapping(value="/get/tarefas/pendentes/{id}")
    public List<Tarefa> getByDepartamento(@PathVariable Long id) {
        return rp.FindByidTarefaPrazoAntigo(id);
    }

    @GetMapping(value="/get/departamentos/{id}")
    public List<Tarefa> getByDeptoPorTarefaPessoa(@PathVariable Long id) {
        return rp.FindByTarefaDepto(id);
    }
}
