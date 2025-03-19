public class GrapheValues extends Graphe{
	public GrapheValues(int ord, boolean o){
		super(ord, o);
	}

	//On ne met pas de @Override car c'est pas la meme valeur de retour
	// et aussi on doit change le nom de la methodes sinon il va penser qu'il y'a un override

	public int getAreteVal(int i, int j){
		return this.adj.getCoeff(i,j);
	}

	//On ne met pas de @Override car c'est pas les meme arguments
	// On a pas besoin de changer le nom car deja les arguments susfisent
	public void ajoutArete(int i, int j, int v){
		// Pour obtenir le this.odre de Graphe j'ai change les droit j'ai remplacer par un protected
		if (i>=this.ordre||j>=this.ordre||i<0||j<0) {
			throw new IllegalArgumentException("Erreur : Sommet inexistant.");
		}
		// Pour obtenir le this.adj de Graphe j'ai change les droits j'ai remplacer par un protected
		this.adj.setCoeff(i, j, v);
		// Pour obtenir le this.oriente de Graphe j'ai change les droits j'ai remplacer par un protected
		if (!this.oriente) {
			this.adj.setCoeff(j,i,v);
		}
	}

	/*public int d(int i, int j){
<<<<<<< HEAD
		return i+j;
=======
		return i+j
>>>>>>> 2a1a36258c10b1d3504875d98a1367599f9b00f6
	}*/

	public void Djikstra(int sommentDepart){
		if (sommentDepart >=this.ordre || sommentDepart < 0) {
			throw new IllegalArgumentException("Erreur : Sommet De Départ inexistant.");
		}

<<<<<<< HEAD
		// Initialisation a Tableau a deux demension. et le tableau des boulenan pour les traite
		int[][] sortie =new int[2][this.ordre];
		boolean[] traite_Vue =new boolean[this.ordre];

		// Initialisation des tableau
		for(int i=0; i<this.ordre; i++){
			sortie[0][i] = -1;
			traite_Vue[i] = false;
		}
		for(int i=0; i<this.ordre; i++){
			sortie[1][i] = -1;
			if(i == sommentDepart){
				sortie[1][sommentDepart] = 0;
			}
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < this.ordre; j++) {
				System.out.println(sortie[i][j]);
			}
			System.err.println("");
		}


		//while(!traite)
=======
		// Creation et initialisation des variables
		boolean[] traite =new boolean[this.ordre];
		int[][] sortie =new int[2][this.ordre];
		for(int i=0; i<this.ordre; i++){
			sortie[0][i] = -1;
			sortie[1][i] = Integer.MAX_VALUE;
			traite[i] = false;
		}

		// Initialisons le sommet de depart a à 0
		sortie[1][sommentDepart] = 0;

		// Tanqu'il reste de sommet a traiter 
		int ctp = 0;
		while(ctp < this.ordre) {
			int minSommet = -1;
			int minDistance = Integer.MAX_VALUE;
>>>>>>> 2a1a36258c10b1d3504875d98a1367599f9b00f6

			// Trouvons le sommet non traité avec la plus petite distance
			for (int i=0; i<this.ordre; i++) {
				if (!traite[i] && sortie[1][i] < minDistance) {
					minSommet = i; // Le sommet le plus petit c i
					minDistance = sortie[1][i]; // La distance la plus petit est celle de i
				}
			}

			// On verifie si tout les sommet ont deja ete traite si oui on stop la boucle 
			if (minSommet == -1) {
				System.out.println("Je passe dans le break");
				break; // Ou  que le sommet est inateganble 
			}
			traite[minSommet] = true;
			ctp++;

			// On va mettre a jour les distances des voisins  
			for (int voisin=0; voisin < this.ordre; voisin++) {
				if(!traite[voisin]){ // On verifie que le voisin n'a pas été traiter 
					// On recupere le poid de l'arrete entre voisin et sommet
					int poid = getAreteVal(minSommet, voisin);

					if (poid > 0) { //si il existe une arrete entre le sommet et minsommet
						int nouvelleDistance = sortie[1][minSommet] + poid;

						//Si un chemin plus court est trouve, on met a jour
						if(nouvelleDistance < sortie[1][voisin]){
							sortie[1][voisin] = nouvelleDistance; // on met a jour la distance
							sortie[0][voisin] = minSommet; // On met a jour le sommet
						}
					}
				}
			}
		}
		// Gestion de l'afichage 
		System.out.println(" Sommet | Distance | Pere ");
		for (int i=0; i<this.ordre; i++) {
			System.out.println(i+"       |"+sortie[1][i]+"     |"+sortie[0][i]);
		}
	}
		

}