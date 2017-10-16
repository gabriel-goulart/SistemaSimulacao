/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulacao;

/**
 *
 * @author gabrielgoulart
 */
public class Evento {
    
    private String tipo;
    private double tempo;
    private Entidade entidade;
    
    public Evento(String tipo, double tempo, Entidade entidade){
        this.tipo = tipo;
        this.tempo = tempo;
        this.entidade = entidade;
                
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public double getTempo(){
        return this.tempo;
    }
    
    public Entidade getEntidade(){
        return this.entidade;
    }
}
