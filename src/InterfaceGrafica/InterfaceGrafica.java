/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
/**
 *
 * @author gabrielgoulart
 */
public class InterfaceGrafica {
    
    private JFrame framePrincipal;
    private TelaInicial painelInicial;
    public InterfaceGrafica(){
        
    }
    
    public void start(){
        this.framePrincipal = new JFrame("Simulação");
        this.framePrincipal.setSize(300, 300);
        this.carregaTelaInicial();
        this.framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.framePrincipal.pack();
        this.framePrincipal.setVisible(true);

    }
    
    public void carregaTelaInicial(){
        this.painelInicial = new TelaInicial();
        this.framePrincipal.add(this.painelInicial);
    }
    
}
