package datas;

public class CDTest {

	public static void main(String[] args) {
		//------------------Tests des constructeurs-------------------------------------------------------------------------
				
		//Test du constructeur 1
		System.out.println("====================Test constructeur d'un CD====================");
		testConstructeurCD();
		
		//-----------------Tests du / des accesseurs----------------------------------------------------------------------

		//Test de l'accesseur getNbrePlages
		System.out.println("====================Test méthode getNbrePlages====================");
		testGetNbrePlages();
		
		//Test de l'accesseur getLeTitreCD
		System.out.println("====================Test méthode getLeTitreCD====================");
		testGetLeTitreCD();
		
		//Test de l'accesseur getLInterpreteCD
		System.out.println("====================Test méthode getLInterpreteCD====================");
		testGetLInterpreteCD();
	    
		//Test de l'accesseur getDureeTotale
		System.out.println("====================Test méthode getDureeTotale====================");
		testGetDureeTotale();
		
		//Test de l'accesseur getUnePlage
		System.out.println("====================Test méthode getUnePlage====================");
		testGetUnePlage();

	}
	
	//Tests des constructeurs
	public static void testConstructeurCD() {
		System.out.println("Test du constructeur d'un CD, cas normal");
		CD cd1 = new CD("Interprete CD1", "Titre CD1");
		
		if(cd1.getNbrePlages() == 7 && cd1.getLInterpreteCD()  == "Interprete CD1" && cd1.getLeTitreCD() == "Titre CD1") 
			System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	//Tests des accesseurs
	public static void testGetNbrePlages() {
		System.out.println("Test de l'accesseur getNbrePlages, cas normal");
		CD cd = new CD("Interprete CD1", "Titre CD1");
		
		if(cd.getNbrePlages() == 7) System.out.println("Test réussi");
		else System.out.println("Echec du test");		
	}
	
	public static void testGetLeTitreCD() {
		System.out.println("Test de l'accesseur getLeTitreCD, cas normal");
		CD cd = new CD("Interprete CD1", "Titre CD1");
		
		if(cd.getLeTitreCD() == "Titre CD1") System.out.println("Test réussi");
		else System.out.println("Echec du test");		
	}
	
	public static void testGetLInterpreteCD() {
		System.out.println("Test de l'accesseur getLInterpreteCD, cas normal");
		CD cd = new CD("Interprete CD1", "Titre CD1");
		
		if(cd.getLInterpreteCD() == "Interprete CD1") System.out.println("Test réussi");
		else System.out.println("Echec du test");		
	}
	
	public static void testGetDureeTotale() {
		System.out.println("Test de l'accesseur getDureeTotale, cas normal");
		CD cd = new CD("Interprete CD1", "Titre CD1");
		
		if(cd.getDureeTotale() instanceof Duree) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	public static void testGetUnePlage() {
		System.out.println("Test de l'accesseur getUnePlage, cas normal");
		CD cd = new CD("Interprete 1", "Titre 1");
		
		Plage laPlage= cd.getUnePlage(2);
		if(laPlage.getLeTitre() == "Plage 2 du CD" 
				&& laPlage.getLInterprete() == "Interprète 2 et 3 du CD")
					System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur: Ok si le message d'erreur s'affiche");
		laPlage= cd.getUnePlage(-2);
	}
	
}
