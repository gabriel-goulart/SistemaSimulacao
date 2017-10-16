package InterfaceGrafica;
/**
 * import das libs utilizadas
 */
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
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
    
    private void init(){
        this.setLayout(new GridLayout(3,1));
        this.add(this.configs());
        this.add(this.server1());
        this.add(this.server2());
    }
    
    private JPanel configs(){
        JPanel config_panel = new JPanel();
        config_panel.setBorder(BorderFactory.createTitledBorder("Configurações Gerais"));
        config_panel.setLayout(new GridLayout(3,2));
        config_panel.add(new JLabel("Servidor 1 texto"));
        
        return config_panel;
    }
    private JPanel server1(){
        JPanel server1_panel = new JPanel();
        server1_panel.setBorder(BorderFactory.createTitledBorder("Servido 1"));
        server1_panel.setLayout(new GridLayout(3,2));
        server1_panel.add(new JLabel("Servidor 1 texto"));
        
        return server1_panel;
    }
    
    private JPanel server2(){
        JPanel server2_panel = new JPanel();
        server2_panel.setBorder(BorderFactory.createTitledBorder("Servido 2"));
        server2_panel.setLayout(new GridLayout(3,2));
        server2_panel.add(new JLabel("Servidor 2 texto"));
        
        return server2_panel;
    }
}
