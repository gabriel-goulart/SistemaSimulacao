
package InterfaceGrafica;
/**
* import das libs utilizadas
*/
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * import das classes utilizadas
 */
import Simulacao.SimuladorControle;
/**
 *
 * @author gabrielgoulart
 */
public class InterfaceGrafica {
    
    private JFrame framePrincipal;
    private TelaInicial painelInicial;
    private SimuladorControle simuladorControle;
    
    public InterfaceGrafica(SimuladorControle sc){
        this.simuladorControle = sc;
    }
    
    public void start(){
        this.framePrincipal = new JFrame("Simulação");
        this.framePrincipal.setSize(600, 600);
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
