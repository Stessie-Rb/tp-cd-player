package datas;

import java.util.ArrayList;

/**
 * Classe pour construire un CD à partir d'une liste de plages. Le CD est vierge à l'instanciation. 
 * Son remplissage se fait au fur et à mesure de la gravure. 
 */
public class CD {
	private ArrayList<Plage> lesPlages;
	private String leTitreCD;
	private String lInterpreteCD;
	
	//Constructeurs
	
	/**
	 * Construction d'un CD
	 * @param interpreteCD L'interprète du CD
	 * @param titreCD Le titre du CD
	 */
	public CD(String interpreteCD, String titreCD) {
		this.lesPlages= new ArrayList<Plage>();
		this.lInterpreteCD = interpreteCD;
		this.leTitreCD= titreCD;
		graverCD();
	}
	
	//Accesseurs 
	
	/**
	 * Méthode d'accession au nombre de plages qui constituent le CD
	 * @return Un entier qui correspond au nombre total de plages
	 */
	public int getNbrePlages() {
		int nbrePlages = this.lesPlages.size();
		
		return nbrePlages;
	}
	
	/**
	 * Méthode d'accession au titre du CD
	 * @return Renvoie le titre du CD
	 */
	public String getLeTitreCD() {
		return leTitreCD;
	}
	
	/**
	 * Méthode d'accession qui renvoie l'interprète du CD 
	 * @return Renvoie l'interprète du CD
	 */
	public String getLInterpreteCD() {
		return lInterpreteCD;
	}
	
	/**
	 * Méthode qui calcule et renvoie la durée totale du CD
	 * @return La durée totale du CD
	 */
	public Duree getDureeTotale() {
		Duree duree= new Duree(0);
		
		if(this.lesPlages.size() > 0) {
			for(int i = 0; i < this.lesPlages.size(); i++) {
				duree.ajoute(this.lesPlages.get(i).getLaDuree());
			}
		}
		else System.out.println("Erreur: le CD ne comporte aucune plage");
		
		Duree dureeTotale= new Duree(duree);
		return dureeTotale;
	}
	
	public Plage getUnePlage(int index) {
		Plage plageSelect= null;
		
		if(this.lesPlages.size() > 0) {
			if(index > 0 && index <= this.getNbrePlages()) plageSelect = this.lesPlages.get(index -1);	
			else System.out.println("Erreur: L'index doit être positif et inférieur ou égal au nombre de plages composant le CD");
		}
		else System.out.println("Erreur: Le CD ne comporte aucune plage");
		
		return plageSelect;
	}

	//Méthodes
	
	/**
	 * Méthode privée simplifiée utilisée pour graver des plages sur le CD. Les plages sont ajoutées manuellement dans cette version
	 */
	private void graverCD() {
		Plage plage1 = new Plage(new Duree(0, 3, 0), "Plage 1 du CD", "Interprète 1 du CD");
		Plage plage2 = new Plage(new Duree(0, 5, 7), "Plage 2 du CD", "Interprète 2 et 3 du CD");
		Plage plage3 = new Plage(new Duree(0, 4, 47), "Plage 3 du CD", "Interprète 2 du CD");
		Plage plage4 = new Plage(new Duree(0, 3, 57), "Plage 4 du CD", "Interprète 4 du CD");
		Plage plage5 = new Plage(new Duree(0, 4, 7), "Plage 5 du CD", "Interprète 1 et 2 du CD");
		Plage plage6 = new Plage(new Duree(1, 7, 7), "Plage 6 du CD", "Interprète 5 du CD");
		Plage plage7 = new Plage(new Duree(0, 3, 27), "Plage 7 du CD", "Interprète 6 du CD"); 
		
		this.lesPlages.add(plage1);
		this.lesPlages.add(plage2);
		this.lesPlages.add(plage3);
		this.lesPlages.add(plage4);
		this.lesPlages.add(plage5);
		this.lesPlages.add(plage6);
		this.lesPlages.add(plage7);	
	}

}

