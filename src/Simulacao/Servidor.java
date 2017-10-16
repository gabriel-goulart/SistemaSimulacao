/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulacao;

import java.util.ArrayList;

/**
 *
 * @author gabrielgoulart
 */
public class Servidor {
    
    private int tipo;
    private boolean ocupado;
    private Entidade entidadeEmExecucao;
    private ArrayList<Entidade> fila;
    public Servidor(int tipo){
        this.tipo = tipo;
    }
    
    public boolean executa(Entidade ent){
        
        if(!this.ocupado){
            this.ocupado = true;
            this.entidadeEmExecucao = ent;
            if(!this.fila.isEmpty()) this.fila.remove(0);
           return true; 
        }else{
            this.fila.add(ent);
           return false; 
        }
    }
    
    public void setOcupado(boolean ocupado)
    {
        this.ocupado = ocupado;
    }
    
    public Entidade getEntidade(){
        return this.entidadeEmExecucao;
    }
    
    public double getTempoUltimoFila(){
        if(this.fila.isEmpty()){
            return this.entidadeEmExecucao.getTempoSaida();
        }else{
            return this.fila.get(this.fila.size()-1).getTempoSaida();
        }
    }
}
