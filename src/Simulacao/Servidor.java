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
        this.ocupado = false;
        this.fila = new ArrayList();
    }
    
    public boolean executa(Entidade ent){
        
        if(!this.ocupado){
            this.ocupado = true;
            this.entidadeEmExecucao = ent;            
            if(!this.fila.isEmpty()) {this.fila.remove(0); System.out.println("Removeu entidade da fila");}
           return true; 
        }else{            
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
    
    public double getTempoUltimoFila(Entidade ent){
        System.out.println("Tamanho fila :"+ this.fila.size());
        if(this.fila.isEmpty()){
            System.out.println("Fila vazia "+this.entidadeEmExecucao.getTempoSaida());
            double valor = this.entidadeEmExecucao.getTempoSaida();
            this.fila.add(ent);
            return valor;
        }else{
            System.out.println("Fila com entidade "+this.fila.get(this.fila.size()-1).getTempoSaida());
            double valor = this.fila.get(this.fila.size()-1).getTempoSaida();
            this.fila.add(ent);
            return valor;
        }
    }
}
