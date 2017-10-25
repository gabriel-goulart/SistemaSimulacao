package Simulacao;

/**
 * Import das libs utilizadas
 */
import java.util.ArrayList;
import java.util.Random;
/**
 * import das classes utilizadas 
 */
import InterfaceGrafica.InterfaceGrafica;
import java.util.Collections;
/**
 *
 * @author gabrielgoulart
 */
public class SimuladorControle {
    
    private InterfaceGrafica interfaceGrafica;
    private ArrayList<Evento> listaEventos;
    private Servidor[] servidores = new Servidor [2];
    private double tempoSistema;
    private double tempoDeSimulacao;
    
    public SimuladorControle(){
        this.listaEventos = new ArrayList();
        this.servidores[0] = new Servidor(1);
        this.servidores[1] = new Servidor(2);
        this.tempoSistema = 0;
        this.tempoDeSimulacao = 1000;
    }
    
    public void start(){
       // this.interfaceGrafica = new InterfaceGrafica(this);
       // this.interfaceGrafica.start();
       this.startSimulacao();
    }
    
    public void startSimulacao(){
        Entidade ent1 = this.gerarEntidade(1);
        double tempoChegada = this.gerarTEC(ent1.getTipo());
        this.gerarEvento("Entrada",tempoChegada , ent1);
        ent1.setTempoChegada(tempoChegada);
        
        Entidade ent2 = this.gerarEntidade(2);
        tempoChegada = this.gerarTEC(ent2.getTipo());
        this.gerarEvento("Entrada",tempoChegada , ent2);
        ent2.setTempoChegada(tempoChegada);
        
        double tempoSaida,tempoServico,tempoInicio;
        while(this.tempoSistema <= this.tempoDeSimulacao)
        {
            Evento evento = this.pegarEvento();
            this.tempoSistema = evento.getTempo();            
            switch(evento.getTipo()){
                
                case "Entrada" : //entrada no sistema
                                tempoServico = this.gerarTES(evento.getEntidade().getTipo());
                                evento.getEntidade().setTempoServico(tempoServico);
                                // tentar executar no servidor
                                
                                if(this.servidores[evento.getEntidade().getTipo() -1].executa(evento.getEntidade())){
                                    // servidor não está ocupado 
                                    tempoSaida = this.tempoSistema + tempoServico;
                                    evento.getEntidade().setTempoSaida(tempoSaida);
                                    this.gerarEvento("Saida", tempoSaida , evento.getEntidade());
                                }else{
                                    // servidor está ocupado
                                    tempoInicio = this.servidores[evento.getEntidade().getTipo() -1].getTempoUltimoFila(evento.getEntidade()); //+ tempoServico;
                                    evento.getEntidade().setTempoServico(tempoInicio + tempoServico);
                                    evento.getEntidade().setTempoInicio(tempoInicio);
                                    evento.getEntidade().setTempoSaida(tempoInicio + tempoServico);
                                    this.gerarEvento("Fila", tempoInicio , evento.getEntidade());                                    
                                }
                                
                                //gerar nova entrada
                                Entidade ent = this.gerarEntidade(evento.getEntidade().getTipo());
                                tempoChegada = this.gerarTEC(ent.getTipo()) + this.tempoSistema;
                                this.gerarEvento("Entrada",tempoChegada , ent);
                                ent.setTempoChegada(tempoChegada);
                                
                                break;
                                
                case "Saida" : //saida do sistema
                                this.servidores[evento.getEntidade().getTipo() -1].setOcupado(false);
                                break;
                
                case "Fila"  : // evento na fila
                                this.servidores[evento.getEntidade().getTipo()-1].executa(evento.getEntidade());
                                //tempoSaida = this.tempoSistema + evento.getEntidade().getTempoServico();
                                //evento.getEntidade().setTempoSaida(tempoSaida);
                                this.gerarEvento("Saida", evento.getEntidade().getTempoSaida() , evento.getEntidade());
                                break;
            }
           //System.out.println("Evento tipo : " + evento.getTipo() + "Evento tempo entrada : " + evento.getTempo());
          // this.imprimeListaEventos();
        }
    }
    
    public void setTempoDeSimulacao(double tempoDeSimulacao){
        this.tempoDeSimulacao  = tempoDeSimulacao;
    }
    
    private void gerarEvento(String tipo, double tempo, Entidade entidade){
       this.adicionarEventoNaLista(new Evento(tipo,tempo,entidade));
    }
    
    private Entidade gerarEntidade(int tipo){
        return new Entidade(tipo);
    }
    
    private void adicionarEventoNaLista(Evento evento){
        this.listaEventos.add(evento);
        Collections.sort(this.listaEventos, new ComparadorDeEventos());
    }
    
    private double gerarTEC(int EntidadeTipo){
        Random g = new Random();
        return g.nextInt(50);
    }
    
    private double gerarTES(int EntidadeTipo){
         Random g = new Random();
        return g.nextInt(50);
    }
    
    private void removerEventoDaLista(int index){
        this.listaEventos.remove(index);
    }
    
    private Evento pegarEvento(){
        Evento evento = this.listaEventos.get(0);
        this.listaEventos.remove(0);
        return evento;
    }
    
    private void imprimeListaEventos(){
        for(Evento evento : this.listaEventos){
            System.out.println("Evento :" + evento.getTipo() + " Entidade : " + evento.getEntidade().getTipo() + " Tempo : " + evento.getTempo());
        }
    }
    
    
}
