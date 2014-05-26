package fr.iutvalence.java.tp.puissance4;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
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
public class TacheDAffichagePuissance4 implements Runnable, ActionListener, KeyListener
{
	private JSplitPane splitPaneGauche;
	private JFrame fenetre;
	private JButton Demarrer;
	private JButton Redemarrer;
	private JButton Aleatoire;
	private JButton Question;
	private JButton Quitter;
	private JButton Ici1;
	private JButton Ici2;
	private JButton Ici3;
	private JButton Ici4;
	private JButton Ici5;
	private JButton Ici6;
	private JButton Ici7;
	private JButton SelectionJoueur1;
	private JButton SelectionJoueur2;

	private void initialiserLInterfaceGraphique()
	{
		this.fenetre = new JFrame();

		this.Demarrer = new JButton("Demarrer");
		this.Demarrer.addActionListener(this);

		this.Redemarrer = new JButton("Redemarrer");
		this.Redemarrer.addActionListener(this);

		this.Aleatoire = new JButton("Aleatoire");
		this.Aleatoire.addActionListener(this);

		this.Question = new JButton("?");
		this.Question.addActionListener(this);

		this.Quitter = new JButton("Quitter");
		this.Quitter.addActionListener(this);

		this.fenetre.setTitle("Puissance4");
		this.fenetre.setSize(525, 450);
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

		this.SelectionJoueur1 = new JButton("Joueur 1");
		this.SelectionJoueur1.addActionListener(this);
		this.SelectionJoueur2 = new JButton("Joueur 2");
		this.SelectionJoueur2.addActionListener(this);

		JSplitPane panneauLateral = new JSplitPane(SwingConstants.HORIZONTAL);
		panneauLateral.setBorder(null);
		panneauLateral.setEnabled(false);
		panneauLateral.setBorder(null);
		panneauLateral.setDividerSize(0);
		// Instanciation d'un objet JPanel
		JPanel panneauDesOptions = new JPanel();
		// Définition de sa couleur de fond
		panneauDesOptions.setLayout(new GridLayout(5, 1));
		panneauDesOptions.setBorder(null);
		panneauDesOptions.add(this.Demarrer);
		panneauDesOptions.add(this.Aleatoire);
		panneauDesOptions.add(this.Redemarrer);
		panneauDesOptions.add(this.Question);
		panneauDesOptions.add(this.Quitter);

		panneauLateral.add(panneauDesOptions);
		panneauLateral.add(new JLabel(new ImageIcon("images/menu2.png")));
		panneauLateral.setResizeWeight(1.0);
		Quitter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fenetre.dispose();
			}
		});

		// Instanciation d'un objet JPanel
		JPanel panneauDeLaGrille = new JPanel();
		// Définition de sa couleur de fond
		// panneauDeLaGrille.setBackground(Color.RED);
		panneauDeLaGrille.setBorder(null);
		panneauDeLaGrille.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < 6 * 7; i++)
		{
			panneauDeLaGrille.add(new JLabel(new ImageIcon("images/trou.png")));
		}

		// Instanciation d'un objet JPanel
		JPanel panneauDesBoutonsDeDepot = new JPanel();
		// Définition de sa couleur de fond
		// panneauDesBoutonsDeDepot.setBackground(Color.RED);
		panneauDesBoutonsDeDepot.setLayout(new GridLayout(1, 7));
		panneauDesBoutonsDeDepot.add(this.Ici1);
		panneauDesBoutonsDeDepot.add(this.Ici2);
		panneauDesBoutonsDeDepot.add(this.Ici3);
		panneauDesBoutonsDeDepot.add(this.Ici4);
		panneauDesBoutonsDeDepot.add(this.Ici5);
		panneauDesBoutonsDeDepot.add(this.Ici6);
		panneauDesBoutonsDeDepot.add(this.Ici7);
		panneauDesBoutonsDeDepot.setBorder(null);

		JSplitPane splitPaneBas = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneBas.setTopComponent(panneauDesBoutonsDeDepot);
		splitPaneBas.setBottomComponent(panneauDeLaGrille);
		splitPaneBas.setEnabled(false);
		splitPaneBas.setBorder(null);
		splitPaneBas.setResizeWeight(0.1);
		splitPaneBas.setDividerSize(0);

		JSplitPane splitPaneIntermediaire = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneIntermediaire.add(panneauLateral);
		splitPaneIntermediaire.add(splitPaneBas);
		splitPaneIntermediaire.setEnabled(false);
		splitPaneIntermediaire.setBorder(null);
		splitPaneIntermediaire.setDividerSize(0);

		this.fenetre.setContentPane(splitPaneIntermediaire);

		this.fenetre.setResizable(true);

		this.fenetre.setVisible(true);
	}

	public void run()
	{
		this.initialiserLInterfaceGraphique();
		// Verouillage des dimensions de la fenêtre
		this.fenetre.setResizable(false);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		// Identification de l'item sélectionné, source de l'événement
		JButton itemSelectionne = (JButton) event.getSource();

		if (itemSelectionne == this.Question)
		{
			// Affichage d'un boite de dialogue délivrant un simple message
			JOptionPane.showMessageDialog(this.fenetre, "Vous devez aligner 4 pions d'une meme couleur !",
					"Comment Jouer", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (itemSelectionne == this.Question)
		{
			// new Joueur[] {new JoueurAleatoire(Couleur.ROUGE), new
			// JoueurAleatoire(Couleur.JAUNE)};
			return;
		}

		if (itemSelectionne == this.Redemarrer)
		{
			int n =JOptionPane.showConfirmDialog(null, "Voulez vous les pions JAUNE ?", "Choix"
					+ " de la couleur",
					JOptionPane.YES_NO_OPTION);

			if (n==JOptionPane.OK_OPTION)
			{
				JOptionPane.showMessageDialog(null, "Bonne Chance!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Vous auriez gagner");
			}
		}

	}
}