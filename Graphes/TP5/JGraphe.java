import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Un objet JGraphe est un JComponent Swing permettant d'afficher dans une fenetre un graphe donne.
 * @author Luc Dartois
 * @version 1.0
 */
public class JGraphe extends JComponent{
	private Graphe g;


/**
 * Constructeur
 *@param gr Le graphe a afficher
 */
	public JGraphe(Graphe gr){
		super();
		this.g=gr;
		Dimension dim=new Dimension(100*this.g.getOrdre(),100*this.g.getOrdre());

		this.setSize(dim);

	}

/**
 * Cree une fenetre carree pour afficher le graphe
 * @param taille taille de la fenetre a creer
 */
	public void affiche(int taille){
			JFrame fenetre=new JFrame();
			fenetre.setSize(taille,taille);
			fenetre.setLocation(100,100);
		    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetre.add(this);
	
			fenetre.setVisible(true);
	}
/**
 * Definit comment le graphe est affiche
 *@param pinceau L'outil permettant de dessiner
 */
	@Override
	public void paintComponent(Graphics pinceau){
		int n=this.g.getOrdre();
		int taille = this.getWidth();
		int r=taille/20;
		int origine=taille/2;
	    int distance=4*origine/5;
	    int x,y;
	    int co,si;
	    int[] pointsX=new int[n];
	    int[] pointsY=new int[n];	    
		for(int i=0;i<n;i++){
			co=(int) Math.round(distance*Math.cos(2*Math.PI*i/n));
			si=(int) Math.round(distance*Math.sin(2*Math.PI*i/n));
			x=origine+co ;
    		y=origine+si ;
    		pinceau.fillOval(x-r/2,y-r/2,r,r);
    		pinceau.drawString(""+i,x+co*r/distance,y+si*r/distance);
    		pointsX[i]=x;
    		pointsY[i]=y;
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
			if(this.g.getArete(i,j)){
			pinceau.drawLine(pointsX[i],pointsY[i],pointsX[j],pointsY[j]);
			}

			}
		}

	}
}