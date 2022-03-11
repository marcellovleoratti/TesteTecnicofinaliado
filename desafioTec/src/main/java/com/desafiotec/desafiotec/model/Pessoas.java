package com.desafiotec.desafiotec.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa")
    @NotNull
    private Long idPESSOA;

    @NotNull
    private String NOME;

    @NotNull
    @JoinColumn(name = "idDEPARTAMENTO")
    private Long idDEPARTAMENTO;

    public Long getIdPESSOA() {
        return idPESSOA;
    }

    public void setIdPESSOA(Long idPESSOA) {
        this.idPESSOA = idPESSOA;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public Long getIdDEPARTAMENTO() {
        return idDEPARTAMENTO;
    }

    public void setIdDEPARTAMENTO(Long idDEPARTAMENTO) {
        this.idDEPARTAMENTO = idDEPARTAMENTO;
    }
}