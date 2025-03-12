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

	public int d(int i, int j){
		return i+j
	}

	public void Djikstra(int sommentDepart){
		if (sommentDepart >=this.ordre || sommentDepart < 0) {
			throw new IllegalArgumentException("Erreur : Sommet De Départ inexistant.");
		}

		boolean[] traite =new boolean[this.ordre];
		int[] sortie =new int[2][this.ordre];
		for(int i=0; i<this.ordre; i++){
			sortie[0][i] = -1;
			boolean[i] = false;
		}

		sortie[0][sommentDepart] = d(0,0);

		while(!traite)


	}
		

}