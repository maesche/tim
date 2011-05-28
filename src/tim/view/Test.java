package tim.view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;



public class Test extends JFrame  {
	
	public static void main(String[] args){
		Test testApp = new Test();
		testApp.pack();
		testApp.setVisible(true);
		testApp.setSize(400, 200);
		
		//pour fermer l'application
		testApp.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				super.windowClosing(arg0);
				System.exit(0);
			}
			
		});
		
		
		/* 1- Initialisation du container. */
		testApp.setLayout(new GridBagLayout());
		
		/* 2- Cr�ation des �l�ments*/
		JLabel chooseLabel = new JLabel("Choisir un dossier :");
		JLabel folderLabel = new JLabel("Dossier :");
		
		JTextField folderTextField = new JTextField();
		
		JButton makeNewFolderButton = new JButton("Nouveau dossier");
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Annuler");
		
		okButton.setPreferredSize(cancelButton.getPreferredSize());
		okButton.setMinimumSize(cancelButton.getMinimumSize());
		
		JTree folderTree = new JTree();
		JScrollPane scrollPane = new JScrollPane(folderTree);
		
		/* 3- Placement */
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0; // la grille commence en (0, 0)

		gbc.gridwidth = GridBagConstraints.REMAINDER; // seul composant de sa colonne, il est donc le dernier.
		gbc.gridheight = 1; // valeur par d�faut - peut s'�tendre sur une seule ligne.

		gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.

		gbc.insets = new Insets(10, 15, 0, 0); // Marge � gauche de 15 et marge au dessus de 10.
		/* - les attributs ipadx, ipdady, weightx et weighty valent tous 0 (valeur par d�faut).
		 * - l'attribut fill est � NONE, car on ne souhaite pas de redimentionnement pour cette �tiquette. */
		testApp.add(chooseLabel, gbc);
		
		/* r�utilisons le m�me objet <code>gbc</code>. */
		/* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
		gbc.gridx = 0;
		gbc.gridy = 1;

		/* ce qui suit est inutile, nous avions d�j� d�finie des valeurs pareilles pour le composant pr�c�dent.
		 * cependant, il est toujours bon d'avoir toute les �tapes dans un premier exemple. */
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1; // valeur par d�faut.

		/* Nous pouvons le voir sur l'image � r�aliser. Ce composant s'�tend sur tout l'espace qu'il recoit aussi bien
		 * horizontalement que verticalement.
		 * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'�tendre un maximum possible dans 
		 * le container en r�cup�rant l'espace suppl�mentaire.
		 */
		gbc.weightx = 1.;
		gbc.weighty = 1.;

		gbc.fill = GridBagConstraints.BOTH;

		gbc.anchor = GridBagConstraints.LINE_START; // pas WEST.

		/* Marge � gauche de 15 (gardons la m�me que pr�c�demment)
		 * Marge au dessus de 30 et
		 * Marge � droite de 10. */
		gbc.insets = new Insets(30, 15, 0, 10);
		testApp.add(scrollPane, gbc);
		
/* le composant suivant � placer est notre �tiquette.
 * * R�utilisons encore le m�me objet gbc.*/

		gbc.gridx = 0;
		gbc.gridy = 2;
		 /* une seule cellule sera disponible pour ce composant. */
		gbc.gridwidth = 1;
		gbc.gridheight = 1;

		/* Nous devons supprimer les poids que nous avons sp�cifi�s pr�c�demment, et supprimer
		 * le redimentionnement. */
		gbc.weightx = 0.;
		gbc.weighty = 0.;

		gbc.fill = GridBagConstraints.NONE;

		/* Maintenant, nous voyons sur notre interface que le composant n'est pas le seul sur sa ligne.
		 * Un champ de saisie le suit. Pour aligner correctement les �tiquettes et les champs de saisie,
		 * la ligne d'�criture nous facilite le travail. Nous allons l'utiliser ici. */
		gbc.anchor = GridBagConstraints.BASELINE_LEADING; // pas LINE_START ni WEST !!

		/* Une petite marge autour du composant. Attention � toujours indiquer les m�mes marges � gauche, sinon les
		 * composants ne sont plus align�s. */
		gbc.insets = new Insets(10, 15, 0, 0);
		testApp.add(folderLabel, gbc);


/* passons au composant suivant: le champ de saisie. */
		gbc.gridx = 1; /* une position horizontalement � droite de l'�tiquette */
		gbc.gridy = 2; /* sur la m�me ligne que l'�tiquette */

		gbc.gridwidth = GridBagConstraints.REMAINDER; /* il est le dernier composant de sa ligne. */
		gbc.gridheight = 1; /* une seule cellule verticalement suffit */

		/* Le composant peut s'�tendre sur tout l'espace qui lui est attribu� horizontalement. */
		gbc.fill = GridBagConstraints.HORIZONTAL;

		/* Alignons ce composant sur la m�me ligne d'�criture que son �tiquette. */
		gbc.anchor = GridBagConstraints.BASELINE;
		/* Une petite marge autour du composant. Remarquons que nous n'avons pas sp�cifi� de marge au dessus du
		 * composant. Comme nous avons d�cid� d'alginer ce composant sur la m�me ligne d'�criture que l'�tiquette, 
		 * la marge du haut sera calcul�e en interne pour s'aligner correctement avec l'�tiquette. */
		gbc.insets = new Insets(0, 15, 0, 10);
		testApp.add(folderTextField, gbc);
		
/* Nous pouvons pass� aux boutons. */
		gbc.gridy = 3; /* nouvelle ligne */
		gbc.gridx = 0; /* premi�re colonne, nous allons plac� notre bouton "make new folder" */

		/* Reprenons l'image. Nous voyons que le bouton est plus large que l'�tiquette situ�e au dessus de lui et
		 * que le champ de saisie commence avant le bord gauche du bouton. Nous pr�cisons donc deux cellules
		 * horizontalement.
		 */

		gbc.gridwidth = 2;
		gbc.gridheight = 1; /* une seule cellule verticalement suffit */

		/* Nous allons alignerles boutons sur leur ligne d'�criture �galement.*/
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;

		/* Aucun redimentionnement possible. Le bouton garde toujours soit sa taille minimum soit pr�f�r�e. */
		gbc.fill = GridBagConstraints.NONE;
		/* Les attributs weightx, weighty sont tout deux � 0.*/

		/* Une petite marge autour du composant.*/
		gbc.insets = new Insets(10, 15, 10, 10);
		testApp.add(makeNewFolderButton, gbc);

		/* bouton suivant. */
		/* le bouton pr�c�dent peut s'�tendre sur deux cellules horizontalement. Celui-ci commence en 2. */
		gbc.gridx = 2; /* pour les dubitatifs, gridy vaut toujours 3 ;-) */

		gbc.gridwidth = GridBagConstraints.RELATIVE; // le bouton est l'avant dernier composant de sa ligne.

		/* nous allons, sur ce bouton, d�finir un poids pour que celui-ci s'�loigne le plus du bouton pr�c�dent.*/
		gbc.weightx = 1.;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING; // Pas LINE_END, ni EAST.
		gbc.insets = new Insets(0, 0, 0, 0);
		testApp.add(okButton, gbc);

		/* notre dernier bouton. */
		gbc.gridx = 3;
		gbc.weightx = 0.; /* remettons le poids � z�ro. */
		gbc.insets = new Insets(0, 3, 0, 10);
		testApp.add(cancelButton, gbc);
		
		
		
		
		
		
		
	}
	
	public Test(){
		
		
	}

}
