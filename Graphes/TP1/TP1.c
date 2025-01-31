#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <graph.h>

struct graphe{
  int ordre; // l'ordre du graphe
  int** adj; // la matrice d'adjacence, donnÃ©e par un double tableau dynamique
  int oriente; // vaut 0 si le graphe est non orientÃ©, 1 sinon
};

typedef struct graphe graphe;

graphe creergraphe(int ord,int or){
	graphe g;

	g.ordre = ord;
	g.oriente = or;

	g.adj = calloc(ord, sizeof(int*));
	for (int i = 0; i < ord ; ++i)
	{
		g.adj[i] = calloc(ord, sizeof(int));

		for (int j = 0; j < ord; ++j)
		{
			g.adj[i][j] = 0;
		}
	}


	return g;
}

void ajoutArete(graphe g,int v,int w){
	if (g.oriente == 1)
	{
		g.adj[v][w] = 1;
	}else{
		g.adj[v][w] = 1;
		g.adj[w][v] = 1;
	}
}

void affche_graphe(graphe g){
	for (int i = 0; i < g.ordre ; ++i)
	{
		for (int j = 0; j < g.ordre; ++j)
		{
			printf(" %d", g.adj[i][j]); 
		}
		printf("\n");
	}
}

void affche_voisin(graphe g, int s){
	printf("les voisin de %d sont: ", s);
	for (int i = 0; i < g.ordre; ++i)
	{
		if (g.adj[i][s] == 1 && g.oriente == 0){
			printf("%d ", i);
		}
		if (g.adj[s][i] == 1 && g.oriente == 1){
			printf("%d ", i);
		}
	}
	printf("\n");
}

int competeur_voisin(graphe g, int s){
	int compteur = 0;

	for (int i = 0; i < g.ordre; ++i)
	{
		if (g.adj[i][s] == 1 && g.oriente == 0){
			compteur++;
		}
		if (g.adj[s][i] == 1 && g.oriente == 1){
			compteur++;
		}
	}

	return compteur;
}

void visuelGraphe(graphe g){
	int taille=700;
    int origine=taille/2;
    int distance=4*origine/5;
    int tailleVert=taille/20;
	    InitialiserGraphique();
    CreerFenetre(10,10,taille,taille);

    int i,j;
    int x,y;
    char* nV=malloc(2);
    *nV='0';
    *(nV+1)='\0';
    int* cX=calloc(g.ordre,sizeof(int));
    int* cY=calloc(g.ordre,sizeof(int));
    for(i=0;i<g.ordre;i++){
    	x=(int) origine+distance*cos(2*M_PI*i/g.ordre);
    	y=(int) origine+distance*sin(2*M_PI*i/g.ordre);
    	cX[i]=x+tailleVert/2;
    	cY[i]=y+tailleVert/2;
    	RemplirArc(x,y,tailleVert,tailleVert,0,360); 
    	EcrireTexte(x,y,nV,2);
    	(*nV)++;

    }

    for(i=0;i<g.ordre;i++){
    	    for(j=0;j<g.ordre;j++){
    	    	if(g.adj[i][j]!=0){
    	    		DessinerSegment(cX[i],cY[i],cX[j],cY[j]);
    	    	}
    	    }
    	}
    Touche();
    FermerGraphique();

}

int main(int argc, char const *argv[])
{

	graphe mon_graphe = creergraphe(10, 0);

	// France 
	ajoutArete(mon_graphe, 0, 1);
	ajoutArete(mon_graphe, 0, 2);
	ajoutArete(mon_graphe, 0, 3);
	ajoutArete(mon_graphe, 0, 4);
	ajoutArete(mon_graphe, 0, 5);
	ajoutArete(mon_graphe, 0, 6);
	ajoutArete(mon_graphe, 0, 7);

	ajoutArete(mon_graphe, 1, 8);
	ajoutArete(mon_graphe, 1, 2);
	ajoutArete(mon_graphe, 1, 3);

	ajoutArete(mon_graphe, 2, 3);
	
	// Allemagne 
	ajoutArete(mon_graphe, 3, 8);
	ajoutArete(mon_graphe, 3, 6);
	ajoutArete(mon_graphe, 3, 4);
	ajoutArete(mon_graphe, 3, 7);
	ajoutArete(mon_graphe, 3, 5);

	// Pologne - Russi
	ajoutArete(mon_graphe, 8, 9);

	affche_voisin(mon_graphe, 9);
	printf("Le nombre de voisin de %d est: %d\n", 9, competeur_voisin(mon_graphe, 9));
	affche_graphe(mon_graphe);

	// Visualisation 
	visuelGraphe(mon_graphe);
	
	return 0;
}	