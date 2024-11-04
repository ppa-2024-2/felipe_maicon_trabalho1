package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;

// Data Transfer Object
// JavaBean

public class NovoDisciplina {
    // CoC: Convention over Configuration
    // Convenção antes de Configuração

    private String nome;
    private String codigo;
    private String ementa;
    private int cargaHoraria;
    private ArrayList<Disciplina> pre_requisitos;
    private int aulasSemanais;

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<Disciplina> getPre_requisitos() {
        return pre_requisitos;
    }

    public void setPre_requisitos(ArrayList<Disciplina> pre_requisitos) {
        this.pre_requisitos = pre_requisitos;
    }

    public int getAulasSemanais() {
        return aulasSemanais;
    }

    public void setAulasSemanais(int aulasSemanais) {
        this.aulasSemanais = aulasSemanais;
    }

    @Override
    public String toString() {
        return "NovoDisciplina [nome=" + nome + ", codigo=" + codigo + ", ementa=" + ementa + ", cargaHoraria="
                + cargaHoraria + ", pre_requisitos=" + pre_requisitos + ", aulasSemanais=" + aulasSemanais + "]";
    }  
}