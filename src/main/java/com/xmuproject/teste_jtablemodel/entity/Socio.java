/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.xmuproject.teste_jtablemodel.entity;

import java.math.BigDecimal;

/**
 *
 * @author muuti
 */
public class Socio {

   private String nome;
   private String endereco;
   private boolean ativo;
   private BigDecimal mensalidade;

    public Socio() {
    }
         

    public Socio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
        
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(BigDecimal mensalidade) {
        this.mensalidade = mensalidade;
    }
}
