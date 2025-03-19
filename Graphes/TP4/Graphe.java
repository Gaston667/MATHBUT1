import java.util.*;
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

/*-------------------------------- TP 2 ------------------------------------------*/

// Fonction qui permet de calculer la matrice contenant les chemins d'une longeur donnee 

public MatriceCarre nombreDeChemins(int longeur ){
	MatriceCarre res = this.adj;
	for (int i = 0; i < longeur-1; i++) {
		res = adj.multiplication(res);
	}
	return res;
}



/*public boolean estConnexe(){
	boolean res = false; 
	for (int i = 1; i <= this.ordre; i++) {
		
	}
}*/

/*-------------------------------- TP 3 ------------------------------------------*/
public LinkedList<Integer> getVoisins(int i){
	LinkedList<Integer> res =new LinkedList<Integer>();

	for (int l=0;l<this.ordre; l++) {
		if (this.adj.getCoeff(i,l) == 1) {
			res.offer(l);
		}
	}
	return res;
}


//Fonction effectuant le parcours en largeur d'un graphe g a partir d'un sommet v.
public void parcoursLargeur(int v){
	LinkedList<Integer> file =new LinkedList<Integer>();
	LinkedList<Integer> voisins =new LinkedList<Integer>();
	file.offer(v);
	int i = 0;
	int x = 0;

	// Gesttion de la sortie(alpha,dist) et on les initialise
	int[][] alpha =new int[2][this.ordre];
	for (int ligne=0;ligne<2;ligne++ ) {
		for (int col=0; col<this.ordre;col++) {
			alpha[ligne][col]=0;
		}
	}

	while(!file.isEmpty()){
		x = file.remove();
		voisins = this.getVoisins(x);
		for (int voisin : voisins) {
			if (alpha[0][voisin]==0){
				i+=1;
				alpha[0][voisin] = i; // j'ai enlever i j'ai mis x
				alpha[1][voisin] = alpha[1][x]+1;
				file.offer(voisin);
			}
		}
	}

	for (int ligne=0;ligne<2;ligne++ ) {
		for (int col=0; col<this.ordre;col++) {
			System.out.print(alpha[ligne][col]+" ");
		}
		System.out.println("");
	}



}
/*-------- Exercice 2 -----*/

/*-------- Exercice 3 ----*/

public int[] tableauDegre(){

	/* Attention fonctionne sur du non oriente:
		Cette fontion prend un graphes en arguments(G) et renvoie un tableau 
		la case i de ce tableau contient le degre du sommet i.*/

	int[] res =new int[this.ordre];
	int compteur=0;
	for (int ligne=0; ligne < this.ordre; ligne++) {
		compteur=0;
		for (int col=0; col < this.ordre; ordre++) {
			if (this.adj.getCoeff(ligne,col) == 1){
				compteur++;
			}
		}
		res[ligne] = compteur;
	}
	return res;
}

private int indicemax(int[] tab){
	int max = 0;
	int valeur =0;
	for (int i=0;i<tab.length; i++) {
		if (tab[i]>= max) {
			max = tab[i];
		}
	}
}

/*------------------------------TP 4 suite de TP 3---------------------------------------*/

}



