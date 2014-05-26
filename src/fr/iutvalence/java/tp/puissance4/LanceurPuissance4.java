package fr.iutvalence.java.tp.puissance4;
import javax.swing.SwingUtilities;
/**
 * Permet de lancer une partie de Puissance4
 * 
 * @author vallid
 * 
 */
public class LanceurPuissance4
{
	/**
	 * Creation et démarrage d'une partie de Puissance 4
	 * 
	 * @param args
	 *            les arguments de la ligne de commande (aucun pour l'instant)
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new TacheDAffichageDeFenetreAvecBouton());
		Joueur[] joueurs = new Joueur[] {new JoueurAleatoire(Couleur.ROUGE), new JoueurAleatoire(Couleur.JAUNE)};
		Puissance4 puissance4 = new Puissance4(joueurs, new AffichageConsole());
		puissance4.jouer();
		
	}
}
