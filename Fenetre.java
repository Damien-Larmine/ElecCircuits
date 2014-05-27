package simulation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
  
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


public class Fenetre extends JFrame implements Runnable {
	
	/* Le menu */ 
	
	 private JMenuBar menuBar = new JMenuBar();
	    JMenu   fichier = new JMenu("Fichier"),
	            aide = new JMenu("Aide"),
	    		Composants = new JMenu("Composants") ;
	    
	    JMenuItem nouveau = new JMenuItem("Effacer"),
                quitter = new JMenuItem("Quitter"),
                charger = new JMenuItem("Charger"),
                sauvegarder = new JMenuItem("Sauvegarder"),
                lancer = new JMenuItem("Lancer"),
                and = new JMenuItem("AND"),
                or = new JMenuItem("OR"),
                xor = new JMenuItem("XOR"),
                no = new JMenuItem("NO");
	    
	    /* Les écouteurs */ 
	    
	    private Stoplistener sListener = new StopListener(); 
	    
	    /* les boutons pour ajouter les composants */
	    
	    JButton or1 = new JButton(new ImageIcon("image/or.jpg")),
	            and1 = new JButton(new ImageIcon("image/et.png")),
	            xor1 = new JButton(new ImageIcon("image/xor.png")),
	            no1 = new JButton(new ImageIcon("image/no.png"))
	    		liaison = new JButton(new ImageIcon("image/"));

	    
	    public Fenetre() {
	    	
	        this.setSize(1000, 1000);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         
	        /*On initialise le menu*/
	        this.initMenu();
	        
	    }
	    
	    
	    

	    }
        public static void main(String[] args){
        Fenetre fen = new Fenetre(); 
		}
  

}
