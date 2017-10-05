/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author gabrielgoulart
 */
public class TelaInicial extends JPanel{
    
    public TelaInicial(){
        super();
        this.init();
    }
    
    public void init(){
        this.setLayout(new GridLayout(1,2));
        this.add(new JLabel("Tela inicial"));
        this.add(new JLabel("Tela inicial painel 2"));
    }
}
