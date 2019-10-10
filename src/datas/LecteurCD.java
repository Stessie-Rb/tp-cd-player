package datas;

/**
 * Classe qui représente de manière simplifiée des fonctionnalités d'un lecteur CD. On peut grâce à elle:
 * <ul>
 * <li>Charger un CD</li>
 * <li>Lire un CD entier</li>
 * <li>Arrêter la lecture</li>
 * <li>Passer au morceau suivant</li>
 * <li>Revenir au morceau précédent</li>
 * </ul>
 */
public class LecteurCD {
	
	private boolean estCharge;
	private int indexPlage;
	private CD leCdCourant;
	
	//Constructeur
	
	/**
	 * Construction d'un nouveau lecteur CD, par défaut il est vide: leCdCourant = null. On charge le Cd en appelant la méthode chargerUnCD();
	 */ 
	public LecteurCD(){
		this.estCharge= false;
		this.indexPlage= 0;
		this.leCdCourant= null;
		chargerUnCD();
	}
	
	//Accesseurs
	
	/**
	 * Méthode d'accession à la durée totale du CD qui est chargé dans le lecteur CD.
	 * @return Temps total du CD 
	 */
	public String getTempsTotal(){
		String tempsTotal = "";
		
		if(leCdCourant != null) tempsTotal= this.leCdCourant.getDureeTotale().enTexte('H'); 
		else System.out.println("Erreur: Aucun CD n'est chargé dans le lecteur");
		
		return tempsTotal;
	}
	
	/**
	 * Méthode d'accession qui retourne un entier correspondant au nombre de plages que le CD contient. L'entier retourné est -1 si il n'y a pas de CD chargé
	 * @return Le nombre de plages du CD
	 */
	public int getNbrePlages(){
		int nbreDePlages = 0;
		
		if(this.leCdCourant != null) nbreDePlages = this.leCdCourant.getNbrePlages();
		else nbreDePlages = -1;
		
		return nbreDePlages;
	}
	
	
	/**
	 * Méthode d'accession qui retourne l'index de la plage en cours de lecture sur le CD. La valeur retournée est comprise entre 1 et le nombre de plages que contient le CD.
	 * Zéro est retourné si aucun CD n'est chargé dns le lecteur. 
	 * @return L'index de la plage courante
	 */
	public int getIndexCourant(){
		int indexPlageCourante= 0;
		
		if(this.leCdCourant != null) indexPlageCourante = indexPlage;
		else indexPlageCourante = 0;
		
		return indexPlageCourante;
	}
	
	/**
	 * Méthode qui permet d'accéder à la plage en cours de lecture dans le CD.
	 * @return Soit laPlage courante soit null si aucun CD n'est chargé
	 */
	public Plage getPlageCourante(){
		Plage plageEnLecture = null; 
		
		if(this.leCdCourant != null && this.getIndexCourant() != 0) plageEnLecture = this.leCdCourant.getUnePlage(this.indexPlage);
		else plageEnLecture = null;
		
		return plageEnLecture;
	}
	
	/**
	 * Méthode d'accession qui renvoie vrai si il y a un CD dans le lecteur 
	 * @return vrai si le lecteur est chargé 
	 */
	public boolean estCharge(){
		boolean estCharge = false;
		
		if(this.leCdCourant != null) estCharge = true;
		else estCharge= false;
		
		return estCharge;
	}
	
	/**
	 * Méthode qui renvoie null si aucun CD n'est chargé ou le CD courant si le lecteur est chargé.
	 * @return Le CD courant dans le lecteur
	 */
	public CD getCD(){
		CD cdCourant = null;
		
		if(this.leCdCourant != null) cdCourant = this.leCdCourant;
		else cdCourant = null;
		
		return cdCourant;
	}
	
	//Modificateurs 
	
	/**
	 * Modificateur qui décharge le lecteur en faisant passer le Booléen estCharge sur false et leCdCourant sur null. 
	 */
	public void setDecharger(){
		this.leCdCourant = null;
		this.estCharge = false;
	}
	
	/**
	 * Modificateur utilisé pour charger un CD dans le lecteur. La méthode construit le CD et place le 
	 */
	public void chargerUnCD(){
		CD cdACharger = new CD("Post Malone", "SunFlower");
		this.estCharge = true; 
		this.leCdCourant= cdACharger;
	}
	
	/**
	 * Modificateur utilisé pour simuler l'action de la touche Stop. Il remet l'index indexPlage sur 1. Si le lecteur CD n'est pas chargé, aucune action ne se passe.
	 */
	public void stop(){
		this.indexPlage = 1;
	}
	
	/**
	 * Modificateur utilisé pour simuler l'action de la touche Play. Il remet l'index indexPlage sur 1 et ne fait rien si le lecteur CD n'est pas chargé. 
	 */
	 public void play(){
		this.indexPlage = 1;
	 }
	
	/**
	 * Modificateur utilisé pour simuler l'action de la touche Next. Il incrémente l'index indexPlage. Si aucun CD n'est chargé, aucune action n'est déclenchée.
	 */
	public void next(){
		if(indexPlage >= 0 && indexPlage < getNbrePlages()) indexPlage ++;

		else {
			System.out.println("Le CD est terminé");
			stop();
		}
	}
	
	/**
	 * Modificateur utilisé pour simuler l'action de la touche Previous. Il décrémente l'index indexPlage et ne fait rien si aucun CD n'est chargé
	 */
	 public void previous(){
	 	if(indexPlage >= 0 && indexPlage < getNbrePlages()) indexPlage --;

		else {
			System.out.println("Début du CD");
		}
	 }
}

