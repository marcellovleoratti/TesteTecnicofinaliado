ALTER TABLE PESSOAS ADD FOREIGN KEY (idDEPARTAMENTO) REFERENCES DEPARTAMENTO(idDEPARTAMENTO);

ALTER TABLE TAREFAS ADD FOREIGN KEY (idDEPARTAMENTO) REFERENCES DEPARTAMENTO(idDEPARTAMENTO);

ALTER TABLE TAREFAS ADD FOREIGN KEY (idPESSOA) REFERENCES PESSOAS(idPESSOA);