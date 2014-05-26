package fr.iutvalence.java.tp.puissance4;



import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Tâche gérant l'IHM (création, affichage)
 * 
 */
public class TacheDAffichageDeFenetreAvecBouton implements Runnable,
		ActionListener, KeyListener {
	private JSplitPane splitPaneGauche;
	private JFrame fenetre;
	private JButton Demarrer;
	private JButton Redemarrer;
	private JButton Aleatoire;
	private JButton Rien;
	private JButton Quitter;
	private JButton Ici1;
	private JButton Ici2;
	private JButton Ici3;
	private JButton Ici4;
	private JButton Ici5;
	private JButton Ici6;
	private JButton Ici7;

	private void initialiserLInterfaceGraphique() {
		this.fenetre = new JFrame();

		this.Demarrer = new JButton("Demarrer");
		this.Demarrer.addActionListener(this);

		this.Redemarrer = new JButton("Redemarrer");
		this.Redemarrer.addActionListener(this);

		this.Aleatoire = new JButton("Aleatoire");
		this.Aleatoire.addActionListener(this);

		this.Rien = new JButton("?");
		this.Rien.addActionListener(this);

		this.Quitter = new JButton("Quitter");
		this.Quitter.addActionListener(this);

		this.fenetre.setTitle("Puissance4");
		this.fenetre.setSize(1000, 600);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.Ici1 = new JButton((new ImageIcon("images/fleche.png")));
		this.Ici1.addActionListener(this);
		this.Ici2 = new JButton((new ImageIcon("images/fleche.png")));
		this.Ici2.addActionListener(this);
		this.Ici3 = new JButton((new ImageIcon("images/fleche.png")));
		this.Ici3.addActionListener(this);
		this.Ici4 = new JButton((new ImageIcon("images/fleche.png")));
		this.Ici4.addActionListener(this);
		this.Ici5 = new JButton((new ImageIcon("images/fleche.png")));
		this.Ici5.addActionListener(this);
		this.Ici6 = new JButton((new ImageIcon("images/fleche.png")));
		this.Ici6.addActionListener(this);
		this.Ici7 = new JButton((new ImageIcon("images/fleche.png")));
		this.Ici7.addActionListener(this);

		// Instanciation d'un objet JPanel
		JPanel pan = new JPanel();
		// Définition de sa couleur de fond
		pan.setBackground(Color.GRAY);
		pan.add(this.Demarrer);
		pan.add(this.Aleatoire);
		pan.add(this.Redemarrer);
		pan.add(this.Rien);
		pan.add(this.Quitter);
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		Quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
			}
		});

		// Instanciation d'un objet JPanel
		JPanel pan2 = new JPanel();
		// Définition de sa couleur de fond
		pan2.setBackground(Color.RED);
		pan2.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < 6 * 7; i++) {
			pan2.add(new JButton(new ImageIcon("images/trou.png")));

			// Instanciation d'un objet JPanel
			JPanel pan3 = new JPanel();
			// Définition de sa couleur de fond
			pan3.setBackground(Color.RED);
			pan3.add(this.Ici1);
			pan3.add(this.Ici2);
			pan3.add(this.Ici3);
			pan3.add(this.Ici4);
			pan3.add(this.Ici5);
			pan3.add(this.Ici6);
			pan3.add(this.Ici7);

			JSplitPane splitPaneBas = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			splitPaneBas.setTopComponent(pan3);
			splitPaneBas.setBottomComponent(pan2);
			splitPaneBas.setEnabled(false);
			splitPaneBas.setBorder(null);
			splitPaneBas.setResizeWeight(0.1);
			splitPaneBas.setDividerSize(0);

			// Verouillage des dimensions de la fenêtre
			this.fenetre.setResizable(false);

			JSplitPane splitPaneIntermediaire = new JSplitPane(
					JSplitPane.HORIZONTAL_SPLIT);
			splitPaneIntermediaire.add(pan);
			splitPaneIntermediaire.add(splitPaneBas);
			splitPaneIntermediaire.setEnabled(false);
			splitPaneIntermediaire.setBorder(null);
			splitPaneIntermediaire.setDividerSize(0);

			this.fenetre.setContentPane(splitPaneIntermediaire);
			this.fenetre.setVisible(true);
			this.fenetre.setResizable(true);
		}
	}

	public void run() {
		this.initialiserLInterfaceGraphique();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	 @Override
	 public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub}
	 }
}