package Simulacao;

/**
 *
 * @author gabrielgoulart
 */
public class Entidade {
    private int tipo;
    private double tempoChegada;
    private double tempoSaida;
    private double tempoServico;
    private double tempoInicio;
    
    public Entidade(int tipo){
        this.tipo= tipo;
    }
    
    public void setTempoChegada(double t){
        this.tempoChegada = t;
    }
    
    public void setTempoSaida(double t){
        this.tempoSaida = t;
    }
    
    public void setTempoServico(double t){
        this.tempoServico = t;
    }
    
    public void setTempoInicio(double t){
        this.tempoInicio = t;
    }
    
    public int getTipo(){
        return this.tipo;
    }
    
    public double getTempoChegada(){
        return this.tempoChegada;
    }
    
    public double getTempoSaida(){
        return this.tempoSaida;
    }
    
    public double getTempoServico(){
        return this.tempoServico;
    }
    
    public double getTempoInicio(){
        return this.tempoInicio;
    }
    
    
}
