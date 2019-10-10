package datas;

/**
 * Classe qui représente et caractérise les plages d'un CD. Une plage comporte un titre et un ou plusieurs interprètes. 
 */
public class Plage {
	
	private Duree laDuree;
	private String leTitre;
	private String lInterprete;
	
	//Constructeur
	
	/**Céation de la plage d'un morceau de musique
	 * @param duree objet de type Duree qui représente la duréee de la plage
	 * @param titre Le titre du morceau de musique
	 * @param interprete Le ou les interprètes du morceau de musique
	 */
	public Plage(Duree duree, String titre, String interprete) {
		this.laDuree = duree;
		this.leTitre = titre;
		this.lInterprete= interprete;
	}
	
	
	//Méthodes
	
	/**
	 * Méthode d'accession à la durée de la plage
	 * @return Retourne un objet de type Duree
	 */
	public Duree getLaDuree() {
		return laDuree;
	}
	
	/**
	 * Méthode d'accession au titre de la plage
	 * @return le titre de la plage
	 */
	public String getLeTitre() {
		return leTitre;
	}
	
	/**
	 * Méthode d'accession à l'(ou les) interprètes
	 * @return Retourne l'interprète de la plage
	 */
	public String getLInterprete() {
		return lInterprete; 
	}
	
	/**
	 * Méthode d'accession qui renvoie une fiche descriptive complète de la plage sous la forme:
	 * Description de la plage de musique:
	 * <ul>
	 * <li>Titre :</li>
	 * <li>Interprètes(s) :</li>
	 * <li>Durée : HHH:MM:SS
	 * </ul>
	 * @return la description de la plage sous forme de texte
	 */
	public String getFicheComplete() {
		String ficheComplete= "";
		String titre = this.getLeTitre();
		String interprete= this.getLInterprete();
		String duree= laDuree.enTexte('H');
		
		ficheComplete += "Description de la plage de musique \n" + "Titre : " + titre + "\n" + "Interprète : " + interprete + "\n" + "Duréee : " + duree;
		
		return ficheComplete;
	}
	
	/**
	 * Méthode d'accession à un résumé de la plage suivant le modèle: titre - interprète - durée (SSS.MMM sec)
	 * @return Résumé textuel sous forme de chaîne de caractère
	 */
	@Override
	public String toString() {
		String toString= "";
		String titre= this.getLeTitre();
		String interprete= this.getLInterprete();
		String duree= this.laDuree.enTexte('H');
		
		toString += titre + " - " + interprete + " - " + "(" + duree + " sec)";
		return toString;
	}
}
