package br.edu.ifrs.riogrande.tads.ppa.ligaa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Disciplina {
     // -- campos de controle
     private UUID id;
     private LocalDateTime dataHoraCriacao;
     private LocalDateTime dataHoraAlteracao;
     private boolean desativado; // false
    
     private String nome;
     private String codigo;
     private String ementa;
     private int cargaHoraria;
     private ArrayList<Disciplina> pre_requisitos;
     private int aulasSemanais;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

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

    public ArrayList<Disciplina> getPrerequisitos() {
        return pre_requisitos;
    }

    public void setPrerequisitos(ArrayList<Disciplina> pre_requisitos) {
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
        return "Disciplina [id=" + id + ", dataHoraCriacao=" + dataHoraCriacao + ", dataHoraAlteracao="
                + dataHoraAlteracao + ", desativado=" + desativado + ", nome=" + nome + ", codigo=" + codigo
                + ", ementa=" + ementa + ", cargaHoraria=" + cargaHoraria + ", prerequisitos=" + pre_requisitos
                + ", aulasSemanais=" + aulasSemanais + "]";
    }
}