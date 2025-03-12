/**
 * Une classe definissant une matrice carree
 * @author Luc Dartois
 * @version 1.0
 */
public class MatriceCarre{
	private int n; //taille de la matrice
	private int[][] m; //La matrice

/**
 * Constructeur creant une matrice vide
 *@param t La taille de la matrice
 */
	public MatriceCarre(int t){
		this.n=t;
		this.m=new int[t][t];
	}
/**
 * Constructeur copiant une matrice donnee dans une nouvelle matrice
 *@param a La matrice a copier
 */	
	public MatriceCarre(MatriceCarre a){
		this.n=a.n;
		this.m=new int[this.n][this.n];
		for(int i=0;i<this.n;i++){
			for(int j=0;j<this.n;j++){
				this.m[i][j]=a.m[i][j];
			}
		}
	}	
/**
 * Methode permettant de definir le coefficient d'une matrice
 *@param i Le coefficient de ligne
 *@param j Le coefficient de colonne
 *@param val La valeur du coefficient
 */
	public void setCoeff(int i,int j,int val){
	if(i>=this.n||j>=this.n||i<0||j<0){
		throw new IllegalArgumentException("Erreur : Hors limites de la matrice.");
	}
		this.m[i][j]=val;
	}
/**
 * Methode permettant de recuperer le coefficient d'une matrice
 *@param i Le coefficient de ligne
 *@param j Le coefficient de colonne
 *@return Le coefficient
 */
	public int getCoeff(int i,int j){
	if(i>=this.n||j>=this.n||i<0||j<0){
		throw new IllegalArgumentException("Erreur : Hors limites de la matrice.");
	}
	return this.m[i][j];		
	}

	public String toString(){
		String 	s="  ";
	for(int j=0;j<this.n;j++){
			s+="| "+j;
	}
	s+="|\n";
	for(int i=0;i<this.n;i++){
		s+=i+" | ";
		for(int j=0;j<this.n;j++){
			s+=this.m[i][j]+"| ";
		}
		s+="\n";
	}
	return s;
	}

	public boolean equals(MatriceCarre a){
		if(this.n!=a.n)
			return false;

		for(int i=0;i<this.n;i++){
			for(int j=0;j<this.n;j++){
				if(this.m[i][j]!=a.m[i][j])
				return false;
			}
		}
		return true;
	}

	public MatriceCarre multiplication(MatriceCarre a){
  		if(this.n!=a.n)
    		throw new IllegalArgumentException("multiplication de matrices de tailles differentes");
 		MatriceCarre res=new MatriceCarre(this.n);
  		int i,j,k;
  		for(i=0;i<this.n;i++){
        	for(j=0;j<this.n;j++){
          		for(k=0;k<this.n;k++){
            		res.m[i][j]+=this.m[i][k]*a.m[k][j];
         		}
       		}
   		}
    return res;
}

    public MatriceCarre addittion(MatriceCarre a ){
 		MatriceCarre res = new MatriceCarre(this.n);
  		int i,j;
  		for(i=0;i<this.n;i++){
        	for(j=0;j<this.n;j++){
          		res.m[i][j]= this.m[i][j] + a.m[i][j];
       		}
   		}

   		return res;
   	}
}


