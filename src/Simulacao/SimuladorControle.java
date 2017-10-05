package Simulacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import InterfaceGrafica.InterfaceGrafica;
/**
 *
 * @author gabrielgoulart
 */
public class SimuladorControle {
    
    private InterfaceGrafica interfaceGrafica;
    
    public SimuladorControle(){
        
    }
    
    public void start(){
        this.interfaceGrafica = new InterfaceGrafica();
        this.interfaceGrafica.start();
    }
}
