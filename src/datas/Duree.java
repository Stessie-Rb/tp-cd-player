package datas;

/**
 * Classe qui indique la durée d'une plage de Cd
 */
public class Duree {

	private long leTemps;
	
	
	//Constructeurs 
	
	/**
	 * Constructeur avec une duree en millisecondes en paramètre
	 * @param millisec Duree en millisecondes
	 */
	public Duree(long millisec) {
		
		if ( millisec >= 0 ) this.leTemps= millisec;
		
		else System.out.println("Erreur: Le temps doit être >= 0");
	}
	
	/**
	 * Constructeur qui demande un objet Duree en paramètre 
	 * @param autreDuree Objet Duree à dupliquer 
	 */
	public Duree(Duree autreDuree) {
		if(autreDuree.getLeTemps() >= 0) this.leTemps= autreDuree.getLeTemps();
		
		else System.out.println("Erreur: Le temps doit être >= 0");
	}
	
	/**
	 * Constructeur qui se base sur des données en heures, minutes et secondes
	 * @param heures Entier représentant nombre d'heures 
	 * @param minutes Entier représentant le nombre de minutes 
	 * @param secondes Entier représentant le nombre de secondes
	 */
	public Duree(int heures, int minutes, int secondes) {
		if(heures >= 0 && minutes >= 0 && secondes >= 0) {
			long nbHeures = (long) heures * 3600000;
			long nbMinutes = (long) minutes * 60000;
			long nbSecondes= (long) secondes * 1000;
			
			this.leTemps = nbHeures + nbMinutes + nbSecondes;
		}
		else {
			System.out.println("Erreur: les paramètres doivent être des entiers >= 0");
		}
	}
	
	
	
	//Méthodes

	/**
	 * Accesseur qui retourne une durée
	 * @return Retourne une duree en millisecondes
	 */
	public long getLeTemps() {
		return leTemps;
	}
	
	
	/**
	 * Méthode de comparaison de la durée courrante avec un objet Duree passé en paramètre
	 *@return Retourne un entier en fonction du résultat de la comparaison:
	 * <ul>
	 * <li>-1: si la durée actuelle est inférieure à celle passée en paramètre</li>
	 * <li>0: si la durée actuelle est égale à celle passée en paramètre</li>
	 * <li>1: si la durée actuelle est supérieure à celle passée en paramètre</li>
	 * </ul>
	 * @param autreDuree La durée à comparer strictement supérieure à 0
	 */
	public int compareA(Duree autreDuree) {
		long autreDureeTps= autreDuree.getLeTemps();
		int resultComparaison = 0;
		
		if(autreDureeTps >= 0){
			
			if(autreDureeTps > this.getLeTemps()){
				resultComparaison=  -1;
			}
			else if(autreDureeTps < this.getLeTemps()){
				resultComparaison= 1;
			}
			else if(autreDureeTps == this.getLeTemps()){
				resultComparaison= 0;
			}
		}
		else System.out.println("Erreur: La durée à ajouter doit être strictement positive");
		
		return resultComparaison;
	}
	

    /**
     * Méthode qui permet d'ajouter une durée à la durée courrante
     * @param autreDuree La durée à ajouter strictement positive
     */
	public void ajoute(Duree autreDuree) {
		this.leTemps = this.leTemps + autreDuree.getLeTemps();
	}
	
	
	/**
	 * Méthode qui renvoie la durée courrante en chaîne de caractère
	 * @return Une chaîne de caractère
	 * @param mode Mode utilisé pour déterminer le format de la chaîne de caractères ('J', 'H', 'S' ou 'M')
	 */
	public String enTexte(char mode) {
		String enTexte="";
		int[] dureeCourrante= enJHMS();
		
		if(mode == 'J') enTexte= dureeCourrante[0] + " jours " + dureeCourrante[1] + " h";
		
		else if(mode == 'H') enTexte= (dureeCourrante[1] + dureeCourrante[0] * 24) + ":" + dureeCourrante[2] + ":" + dureeCourrante[3];
		
		else if(mode == 'S') enTexte= dureeCourrante[3] + "." + dureeCourrante[4];
		
		else if(mode == 'M') enTexte= dureeCourrante[4] + " millisec";
		
		else System.out.println("Erreur: le mode doit être un des caractères suivants: J, H, S ou M");
		
		return enTexte; 
		
	}
	
	
	/**
	 * Méthode interne à la classe utilisée pour découper la durée courrante en jours, heures, minutes, secondes, millisecondes.
	 * @return Tableau d'entiers constitué comme suit: 
	 * <ul>
	 * <li>ret[0]= nbr de jours</li>
	 * <li>ret[1]= nbr d'heures (inf à 24)</li>
	 * <li>ret[2]= nbr de minutes(inf à 60)</li>
	 * <li>ret[3]= nbr de secondes (inf à 60)</li>
	 * <li>ret[4]= nbr de millisecondes( inf à 1000)</li>
	 * </ul>
	 */
	private int[] enJHMS() {
		int[] jmhs= new int[5]; 
		int nbrJrs= 86400000;
		int nbrHeures= 3600000;
		int nbrMinutes= 60000;
		int nbrSecondes= 1000;
		int reste;
		
		jmhs[0]= (int) leTemps / 86400000;
		reste = (int) leTemps % nbrJrs;
			
		jmhs[1]= reste / 3600000;
		reste= reste % nbrHeures;
		
		jmhs[2]= reste / 60000;
		reste= reste % nbrMinutes;
		
		jmhs[3]= reste / 1000;
		reste= reste % nbrSecondes;
		
		jmhs[4] = reste;
		
		if(leTemps <= 1000) jmhs[4] = (int) leTemps;
		
		return jmhs;	
	}
}
