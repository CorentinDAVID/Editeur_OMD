Editeur de Texte

On se base sur un JFrame, une fenetre qui va contenir toutes les composantes de l'editeur:

- Un JLabel qui va servir a stocker la chaine de caractere representant le texte entre au clavier
- Un Buffer qui va prendre notre JLabel en parametre, pour pouvoir faire des manipulations dessus
- Un menu qui va avoir des boutons relies aux commandes de notre editeur

Fonctionnement:

Classes principales:

- Interface: elle représente l'IHM du programme, avec l'initialisation et l'implementation de toutes les composantes du projet, de plus c'est ici qu'on recupere les entrees de l'utilisateur
- Buffer: elle va contenir la partie modification du projet avec l'edition et la selection du texte, sans oublier les commandes
- Commandes: cette interface va lier toutes les commandes par un héritage, faisant d'elles des classes filles
- Main: la classe depuis laquelle on va lancer le programme, qui va juste initialiser une interface

On ecrit dans la zone de la fenetre, le curseur est represente par le caractere surligne en bleu, et on peut le deplacer avec les fleches droite et gauche.
Si on appuie sur MAJ on passe en mode selection donc on utilise plus que les fleches de droite et gauche, si on veut copier la zone selectionee on appuie sur le bouton copy.
A tout moment on peut coller le presse papier au niveau du curseur avec le bouton paste. Et couper la zone avec le bouton cut.
On peut supprimer des caracteres avec la touche BACK_SPACE.

Detection du clavier avec KeyListener.
Detection des boutons avec ActionListener.

Saisie: une liste de chaine de caracteres qui va contenir les caracteres entres au clavier

Curseur: On se base sur un index du tableau qu'on fait varier pour savoir sur quel caractere on se situe.

Zone de selection: Delimitee par les caracteres surlignes en bleu, est determinee par tous les caracteres de la liste situes entre la position du curseur et l'index selection.

Sauvegarde: une liste de chaine de caracteres qui va contenir les elements de la saisie entre la position et la selection

Etat: un booleen qui est true si on est en mode selection

Commandes: Copier - Coller - Couper - PositionDroit - PositionGauche - SelectionDroit - SelectionGauche - Remove

v2

Dans cette deuxième version on ajoute deux fonctionnalitées, la sauvegarde de fichier et le retour en arriere.
Si on appuie sur le bouton save, le texte saisie est enregistré dans un fichier sauvegarde.txt mis dans la racine du projet.
Si on appuie sur la touche CTRL, on effectue un retour en arriere comme un CTRL+Z.

Tab_saisie: une liste de toutes les saisies depuis le debut du lancement du programme

Tab_position: une liste de toutes les positions pour chaque saisies depuis le debut du lancement du programme

Position_saisie: un pointeur sur la valeur de la liste de saisies sur laquelle on est rendu

Back: un booleen pour savoir si on vient de faire un retour en arriere

Modification: un booleen pour savoir si on vient de modifier la saisie

Class Fichier: cette classe va nous permettre de creer le fichier de sauvegarde avec pour contenu la saisie courante de l'editeur de texte, on utilise la bibliotheque file de java

Commandes: Save - BackTrack
