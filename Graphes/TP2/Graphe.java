/**
 * Classe definissant des graphes au sens mathematiques
 * @author Luc Dartois
 * @version 1.0
*/

public class Graphe{
/**
 * Le nombre de sommets du graphe, numerotes de 0 a ordre-1
 */
private int ordre;
/**
 * Ses aretes donnees sous forme de matrice carre d'adjacence (voir classe MatriceCarre)
 */
private MatriceCarre adj;
/**
 * Indique si le graphe est oriente ou non
 */
private boolean oriente;

/**
 * Construit un graphe vide
 *@param ord indique l'ordre du graphe
 *@param o indique s'il est oriente
 */
public Graphe(int ord,boolean o){
	this.ordre=ord;
	this.adj=new MatriceCarre(ord);
	this.oriente=o;
}
/**
 * Getter pour l'ordre
 *@return L'ordre du graphe
 */
public int getOrdre(){
	return this.ordre;
}
/**
 * Renvoit vrai s'il y a une arete de i a j
 *@param i,j Deux sommets du graphe
 *@return Vrai si le graphe possede une arete de i a j
 */
public boolean getArete(int i,int j){
	return this.adj.getCoeff(i,j)==1;
}
/**
 * Ajoute une arete de i a j
 *@param i,j Deux sommets du graphe
 */
public void ajoutArete(int i,int j){
	if(i>=this.ordre||j>=this.ordre||i<0||j<0){
		throw new IllegalArgumentException("Erreur : Sommet inexistant.");
	}
	this.adj.setCoeff(i,j,1);
	if(!this.oriente){
	this.adj.setCoeff(j,i,1);
	}
}
/**
 * Affiche la liste des voisins de i
 *@param i Un sommet du graphe
 */
public void voisinage(int i){
	if(!this.oriente){
		System.out.print("Voisins de "+i+" : ");
		for(int j=0;j<this.ordre;j++){
		if(this.adj.getCoeff(i,j)==1){
			System.out.print(j+", ");
		}
		}
	System.out.println();
	}
	else{
		System.out.print("Voisins sortants de "+i+" : ");
		for(int j=0;j<this.ordre;j++){
		if(this.adj.getCoeff(i,j)==1){
			System.out.print(j+", ");
		}
		}
	System.out.println();
			System.out.print("Voisins entrants de "+i+" : ");
		for(int j=0;j<this.ordre;j++){
		if(this.adj.getCoeff(j,i)==1){
			System.out.print(j+", ");
		}
		}
	System.out.println();

	}
}
/**
 * Calcule la somme du nombre de voisins de tous les sommets
 *@return Un entier representant la somme de tous les voisins.
 */
public int sommeVoisins(){
int s=0;
	for(int i=0;i<this.ordre;i++){
		for(int j=0;j<this.ordre;j++){
			s+=this.adj.getCoeff(i,j);
		}
	}
	return s;
}

public String toString(){
	String s="Graphe ";
	if(!this.oriente){
		s+="non ";
	}
	s+="oriente de taille : "+this.ordre+".\n";

	return s;
}


public boolean equals(Graphe g){
	if(this.ordre!=g.ordre)
		return false;
	if(this.oriente!=g.oriente)
		return false;
	if(!this.adj.equals(g.adj))
		return false;
	return true;
}


// Fonction qui permet de calculer la matrice contenant les chemins d'une longeur donnee 

public MatriceCarre nombreDeChemins(int longeur ){
	MatriceCarre res = this.adj;
	for (int i = 0; i < longeur-1; i++) {
		res = adj.multiplication(res);
	}
	return res;
}



public boolean estConnexe(){
	boolean res = false; 
	for (int i = 1; i <= this.ordre; i++) {
		
	}
}

}