package com.desafiotec.desafiotec.controller.Repositories;



import com.desafiotec.desafiotec.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TarefasRepositories extends JpaRepository<Tarefa,Long> {

    @Query("Select T from Tarefa T INNER JOIN PESSOAS P ON P.idDEPARTAMENTO=T.idDEPARTAMENTO WHERE T.idTAREFA=idTarefa")
    List<Tarefa> SalvarPesoaTarefa(Long idTarefa);

    @Query("UPDATE TAREFA SET FINALIZADO=TRUE WHERE IdTarefa=id")
    List<Tarefa> FinalizarTarefa(Long id);

    List<Tarefa> findByIdAndTAREFAAndNomeAndIdDEPARTAMENTOAndDURACAO(Long id);

    @Query("Select s.AVG(s.DURACAO) from Tarefa  s INNER JOIN PESSOAS W ON W.idPESSOA = s.idPESSOA INNER JOIN DEPARTAMENTO d on d.idDEPARTAMENTO=s.idDEPARTAMENTO" +
            "where W.NOME=nome AND s.PRAZO=periodo")
    List<Tarefa> findBuscarPessoasPeriodoHoras(String nome, LocalDate periodo );

    @Query("Select TOP 3, X.MIN(X.DURACAO) from Tarefa X INNER JOIN PESSOA y ON Y.idPESSOA = X.idPESSOA GROUP BY X.DURACAO")
    List<Tarefa> FindByidTarefaPrazoAntigo(Long id);

    @Query("select DP.TITULO, count(c.idTAREFA,P.idPessoa) from Tarefa c INNER JOIN PESSOAS P ON P.idPESSOA = C.idPESSOA INNER JOIN Departamento DP ON DP.idDEPARTAMENTO = C.idDEPARTAMENTO GROUP BY C.idTAREFA,P.idPESSOA")
    List<Tarefa> FindByTarefaDepto(Long id);
}
