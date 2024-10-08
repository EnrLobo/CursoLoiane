/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enrique.estruturadados.vetor;

import java.util.Arrays;

/**
 *
 * @author Quiqu
 */
public class Vetor {
    private String[] elementos;
    private int tamanho;
    
    public Vetor(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }
    
    /*public void adiciona(String elemento){
        for(int i = 0; i<this.elementos.length; i++){
            if(this.elementos[i] == null){
                this.elementos[i] = elemento;
                break;
            }*/
    
    /*public void adiciona(String elemento) throws Exception{
        if(this.tamanho < this.elementos.length){
            this.elementos[this.tamanho]  = elemento;
            this.tamanho++;
         }else{
                   throw new Exception("Vetor cheio, nao e possivel adicionar elementos");
            }
        }*/
    
    public boolean adiciona(String elemento){
        this.aumentaCapacidade();
        if(this.tamanho < this.elementos.length){
            this.elementos[this.tamanho]  = elemento;
            this.tamanho++;
            return true;
         }
                   return false;
        }
     
    public boolean adiciona(int posicao, String elemento){
        this.aumentaCapacidade();
        if(!(posicao>=0 && posicao<tamanho)){
            throw new IllegalArgumentException("Posicao Invalida");
        }
        
        for(int i=this.tamanho-1;i>=posicao;i--){
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        tamanho++;
        
        return true;
    }
    
    private void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            String[] elementosNovos = new String[this.elementos.length*2];
            for(int i=0; i<this.tamanho;i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
    
    public String busca(int posicao){
        if(!(posicao>=0 && posicao<tamanho)){
            throw new IllegalArgumentException("Posicao Invalida");
        }
        return this.elementos[posicao];
    }
    
    /*public boolean  busca(String elemento){ Esse é o modo que verifica se um elemento existe no vetor usando boolean
        for(int i=0; i<this.tamanho;i++){
            if(this.elementos[i].equals(elemento)){
                return true;
            }
        }
        return false;
    }*/
    
    public int busca(String elemento){ //Esse é o modo que verifica se um elemento existe no vetor usando int, ou seja, retornando a posição do elemento.
        for(int i=0; i<this.tamanho;i++){
            if(this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }
    
    public void remove(int posicao){
        if(!(posicao>=0 && posicao<tamanho)){
            throw new IllegalArgumentException("Posicao Invalida");
        }
        for(int i = posicao;i<tamanho-1;i++){
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }
    
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("[");
        
        for(int i=0;i<this.tamanho-1;i++){
            s.append(this.elementos[i]);
            s.append(",");
        }
        if(this.tamanho>0){
            s.append(this.elementos[this.tamanho-1]);
        }
        
        s.append("]");
        
        return s.toString();
    }
    
}
