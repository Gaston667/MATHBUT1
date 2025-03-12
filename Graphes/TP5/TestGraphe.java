public class TestGraphe{


	public static void main(String[] args) {

	//Graphe de la france et ses voisins :
	/*
	0:France
	1:Espagne
	2:Portugal
	3:Italie
	4:Suisse
	5:Allemagne
	6:Belgique
	7:Luxembourg
	8:Pays-Bas
	*/
/*------------------------ Exemple avec un graphe non orienter -----------------------*/
	/*Graphe europe=new Graphe(9,false);
	europe.ajoutArete(0,1);
	europe.ajoutArete(0,3);
	europe.ajoutArete(0,4);
	europe.ajoutArete(0,5);
	europe.ajoutArete(0,6);
	europe.ajoutArete(0,7);
	europe.ajoutArete(1,2);
	europe.ajoutArete(3,4);
	europe.ajoutArete(4,5);
	europe.ajoutArete(5,6);
	europe.ajoutArete(5,7);
	europe.ajoutArete(5,8);
	europe.ajoutArete(6,7);
	europe.ajoutArete(6,8);	
	System.out.println(europe);

	europe.voisinage(0);
	int t=europe.sommeVoisins();
	System.out.println(t==14*2);*/

	/*JGraphe gno=new JGraphe(europe);
	gno.affiche(500);*/
	/*System.out.println(europe.nombreDeChemins(2));
	System.out.println("Voici les voisins de 0: "+europe.getVoisins(0));
	System.out.println();*/
	//System.out.println("EXO3----\n");
	//europe.parcoursLargeur(7);

	/*int[]tab = europe.tableauDegre();
	for (int i =0; i<tab.length; i++) {
		System.out.print(tab[i]+);

	}*/

	/*--- Graphe Value non Oriente---*/
	GrapheValues europeValue=new GrapheValues(9,false);
	europeValue.ajoutArete(0,1,2);
	europeValue.ajoutArete(0,3,3);
	europeValue.ajoutArete(0,4,5);
	europeValue.ajoutArete(0,5,6);
	europeValue.ajoutArete(0,6,5);
	europeValue.ajoutArete(0,7,5);
	europeValue.ajoutArete(1,2,3);
	europeValue.ajoutArete(3,4,9);
	europeValue.ajoutArete(4,5,2);
	europeValue.ajoutArete(5,6,68);
	europeValue.ajoutArete(5,7,9);
	europeValue.ajoutArete(5,8,97);
	europeValue.ajoutArete(6,7,1);
	europeValue.ajoutArete(6,8,7);	
	
	System.out.println(europeValue);// Details sur le Graphes;
	System.out.println("La Value est: "+europeValue.getAreteVal(6,5));


/*----------------------- Exemple de graphe oriente. --------------------------*/

	/*	Graphe g=new Graphe(5,true);
		g.ajoutArete(0,2);
		g.ajoutArete(0,4);
		g.ajoutArete(1,0);
		g.ajoutArete(1,3);
		g.ajoutArete(2,3);
		g.ajoutArete(3,1);
		g.ajoutArete(3,4);
		g.ajoutArete(4,0);
	g.voisinage(1);
	System.out.println(g.sommeVoisins()==8);*/

	/*JGraphe go=new JGraphe(g);
	go.affiche(500);
	System.out.println(g.nombreDeChemins(2));
	System.out.println("Voici les voisins de 0: "+g.getVoisins(0));
	*/


}
}