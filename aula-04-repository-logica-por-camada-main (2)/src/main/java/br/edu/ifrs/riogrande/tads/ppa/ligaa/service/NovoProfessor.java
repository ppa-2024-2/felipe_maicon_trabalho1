package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

// Data Transfer Object
// JavaBean

public class NovoProfessor {
    // CoC: Convention over Configuration
    // Convenção antes de Configuração

    private String nome;
    private String formacao;
    private String siape;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    @Override
    public String toString() {
        return "NovoProfessor [nome=" + nome + ", formacao=" + formacao + ", siape=" + siape + "]";
    }
}