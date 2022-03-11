package com.desafiotec.desafiotec.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departamento {

    @Column(name = "idDEPARTAMENTO")
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="idDEPARTAMENTO")
    private List<Departamento> idDEPARTAMENTO = new ArrayList<>();

    @NotNull
    private String TITULO;

    public List<Departamento> getIdDEPARTAMENTO() {
        return idDEPARTAMENTO;
    }

    public void setIdDEPARTAMENTO(List<Departamento> idDEPARTAMENTO) {
        this.idDEPARTAMENTO = idDEPARTAMENTO;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }
}
