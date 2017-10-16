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
public class Servidor {
    
    private int tipo;
    private boolean ocupado;
    private Entidade entidade;
    public Servidor(int tipo){
        this.tipo = tipo;
    }
    
    public boolean executa(Entidade ent){
        
        if(!this.ocupado){
            this.ocupado = true;
            this.entidade = ent;
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
        return this.entidade;
    }
}
