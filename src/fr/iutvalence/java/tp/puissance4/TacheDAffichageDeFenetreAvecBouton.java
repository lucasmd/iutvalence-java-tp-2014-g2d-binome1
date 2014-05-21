package fr.iutvalence.java.tp.puissance4;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JSplitPane;


import javax.swing.JButton;
import javax.swing.JFrame;
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
public class TacheDAffichageDeFenetreAvecBouton implements Runnable,ActionListener, KeyListener 
{
	private JSplitPane splitPaneGauche;
	private JFrame fenetre;
	private JButton Demarrer;
	private JButton Redemarrer;
	private JButton Aleatoire;
	private JButton Rien;
	private JButton Quitter;


	
	private void initialiserLInterfaceGraphique()
	{
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
	this.fenetre.setSize(1000, 800);
	this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	
	//Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.GRAY);
    pan.add(this.Demarrer);
    pan.add(this.Aleatoire);
    pan.add(this.Redemarrer);
    pan.add(this.Rien);
    pan.add(this.Quitter);
    
    //Instanciation d'un objet JPanel
    JPanel pan2 = new JPanel();
    //Définition de sa couleur de fond
    pan2.setBackground(Color.BLUE);
   
	
	
	// Verouillage des dimensions de la fenêtre
	this.fenetre.setResizable(false);

	JSplitPane splitPaneIntermediaire = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	splitPaneIntermediaire.add(pan);
	splitPaneIntermediaire.add(new JButton("Test"));
	splitPaneIntermediaire.setEnabled(false);
	splitPaneIntermediaire.setBorder(null);
	splitPaneIntermediaire.setDividerSize(0);
	
    this.fenetre.setContentPane(splitPaneIntermediaire);   
	this.fenetre.setVisible(true);
	}
	
	public void run()
	{
		this.initialiserLInterfaceGraphique();
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
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}