package com.desafiotec.desafiotec.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTAREFA;

    @NotNull
    private String TITULO;

    private String DESCRICAO;

    private LocalDate PRAZO;

    @Column(name = "idDEPARTAMENTO")
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="idDEPARTAMENTO")
    private List<Departamento> idDEPARTAMENTO;

    private Integer DURACAO;

    @Column(name = "idPESSOA")
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="idPESSOA")
    private List<Pessoas> idPESSOA = new ArrayList<>();

    private Boolean FINALIZADO;

    public Long getIdTAREFA() {
        return idTAREFA;
    }

    public void setIdTAREFA(Long idTAREFA) {
        this.idTAREFA = idTAREFA;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public LocalDate getPRAZO() {
        return PRAZO;
    }

    public void setPRAZO(LocalDate PRAZO) {
        this.PRAZO = PRAZO;
    }

    public List<Departamento> getIdDEPARTAMENTO() {
        return idDEPARTAMENTO;
    }

    public void setIdDEPARTAMENTO(List<Departamento> idDEPARTAMENTO) {
        this.idDEPARTAMENTO = idDEPARTAMENTO;
    }

    public Integer getDURACAO() {
        return DURACAO;
    }

    public void setDURACAO(Integer DURACAO) {
        this.DURACAO = DURACAO;
    }

    public List<Pessoas> getIdPESSOA() {
        return idPESSOA;
    }

    public void setIdPESSOA(List<Pessoas> idPESSOA) {
        this.idPESSOA = idPESSOA;
    }

    public Boolean getFINALIZADO() {
        return FINALIZADO;
    }

    public void setFINALIZADO(Boolean FINALIZADO) {
        this.FINALIZADO = FINALIZADO;
    }
}
