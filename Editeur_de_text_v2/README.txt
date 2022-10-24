Editeur de Texte

On se base sur un JFrame, une fenetre qui va contenir toutes les composantes de l'editeur:

- Un JLabel qui va servir a stocker la chaine de caractere representant le texte entre au clavier
- Un Buffer qui va prendre notre JLabel en parametre, pour pouvoir faire des manipulations dessus
- Un menu qui va avoir des boutons relies aux commandes de notre editeur

Fonctionnement:

On ecrit dans la zone de la fenetre, le curseur est represente par le caractere surligne en bleu.
Si on appuie sur MAJ on passe en mode selection donc on utilise plus que les fleches de droite et gauche, si on veut copier la zone selectionee on appuie sur CTRL.
A tout moment on peut coller le presse papier au niveau du curseur avec la touche ALT.

Curseur: On se base sur un index du tableau qu'on fait varier pour savoir sur quel caractere on se situe.

Zone de selection: Delimitee par les caracteres surlignes en bleu, est determinee par tous les caracteres de la liste situes entre la position du curseur et l'index selection.