package datas;

public class PlageTest {

	public static void main(String[] args) {
		//------------------Tests du constructeur-------------------------------------------------------------------------
		System.out.println("==========================Test du constructeur===============================================");
		testConstructeur();
		
		//-----------------Tests des accesseurs---------------------------------------------------------------------------
		System.out.println("==========================Test accesseur getLaDuree===============================================");
		testGetLaDuree();
		
		System.out.println("==========================Test accesseur getLeTitre===============================================");
		testGetLeTitre();
		
		System.out.println("==========================Test accesseur getLInterprete===============================================");
		testGetLInterprete();
		
		System.out.println("==========================Test accesseur getFicheComplete===============================================");
		testGetFicheComplete();
		
		System.out.println("==========================Test accesseur toString===============================================");
		testToString();
	}
	
	public static void testConstructeur() {
		System.out.println("Test cas normal");
		
		Duree laDuree= new Duree(200);
		Plage plage1 = new Plage(laDuree, "Plage 1", "Interprète 1");
		
		if(plage1.getLaDuree() == laDuree && plage1.getLeTitre() == "Plage 1" && plage1.getLInterprete() == "Interprète 1") 
			System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur: création d'une plage avec durée négative.\nTest ok si affichage du message d'erreur");
		
		laDuree= new Duree(-200);
		plage1= new Plage(laDuree, "Plage 1", "Interprète 1");	
	}
	
	//Tests des accesseurs
	
	//Test getLaDuree
	public static void testGetLaDuree() {
		System.out.println("Test cas normal");
	
		Plage plage1 = new Plage(new Duree(7000), "Plage 1", "Interprète 1");
		
		if(plage1.getLaDuree() instanceof Duree) System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur, durée négative: Ok si le message d'erreur est affiché");
		
		plage1= new Plage(new Duree(-7000), "Plage 1", "Interprète 1");
	}
	
	//Test getLeTitre
	public static void testGetLeTitre() {
		Plage plage1= new Plage(new Duree(0, 3, 0), "Titre 1", "Interprète 1");
		
		System.out.println("Test accesseur getLeTitre, cas normal");
		if(plage1.getLeTitre() == "Titre 1") System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur: le titre n'est pas une chaîne de caractères");
		boolean testErreur= plage1.getLeTitre() instanceof String;
		if(testErreur) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	//Test getLInterprete
	public static void testGetLInterprete() {
		Plage plage1= new Plage(new Duree(0, 3, 0), "Titre 1", "Interprète 1");
		
		System.out.println("Test accesseur getLInterprete, cas normal");
		if(plage1.getLInterprete() == "Interprète 1") System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur: l'interprète n'est pas une chaîne de caractères");
		boolean testErreur= plage1.getLInterprete() instanceof String;
		if(testErreur) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	//Test getFicheComplete
	public static void testGetFicheComplete() {
		Plage plage1= new Plage(new Duree(70000), "Titre", "Interprète");
		
		System.out.println("Test accesseur getFicheComplete, cas normal");
		if(plage1.getFicheComplete() instanceof String) System.out.println("Test réussi");
		else System.out.println("Echec du test");		
	}
	
	//Test toString
	public static void testToString() {
		Plage plage1 = new Plage(new Duree(2000), "Titre 1", "Interprète 1");
		
		System.out.println("Test toString en cas normal");
		if(plage1.toString().equals("Titre 1 - Interprète 1 - (2.0 sec)")) System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur: la valeur n'est pas une chaîne de caractères");
		boolean testErreur= plage1.toString() instanceof String;
		if(testErreur) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
}
