/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulacao;

import java.util.Comparator;

/**
 *
 * @author gabrielgoulart
 */
public class ComparadorDeEventos implements Comparator<Evento> {
    
    public int compare(Evento ev1, Evento ev2){
        if(ev1.getTempo() < ev2.getTempo()) return +1;
        else return -1;
    }
}
