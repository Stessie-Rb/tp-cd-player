package datas;

public class DureeTest {
	
	public static void main (String[] args) {
		
		//------------------Tests des constructeurs-------------------------------------------------------------------------
		
		//Test du constructeur 1
		System.out.println("====================Test constructeur avec initialisation en millisecondes====================");
		testConstructeurMillisecondes();
		
		//Test du constructeur 2
		System.out.println("====================Test constructeur avec un objet Duree en paramètre====================");
		testConstructeurAvecDuree();
		
		//Test constructeur 3
		System.out.println("====================Test constructeur avec un objet H,M,S en paramètre====================");
		testConstructeurHMS();
		
		//-----------------Tests du / des accesseurs----------------------------------------------------------------------
		
		//Test de l'accesseur getLeTemps
		System.out.println("====================Test méthode getLeTemps====================");
		testGetLeTemps();
		
		//------------------Tests des méthodes-----------------------------------------------------------------------------
		
		//Test de la méthode compareA
		System.out.println("====================Test méthode compareA====================");
		testCompareA();		
		
		//Test de la méthode ajoute
		System.out.println("====================Test méthode ajoute====================");
		testAjoute();
		
		//Test de la méthode enTexte
		System.out.println("====================Test méthode enTexte====================");
		testEnTexte();
	}
	
	//Tests des constructeurs 
	public static void testConstructeurMillisecondes() {	
		System.out.println("Test cas normal, millisec > 0");
		
		Duree d1 = new Duree(1500);
		long temps= d1.getLeTemps();
		
		if(temps == 1500) System.out.println("Test réussi");
	
		else System.out.println("Echec du test");
		
		System.out.println("Test cas de d'erreur : OK si message d'erreur affiché'");
		
		d1 = new Duree ( -10 );
	}
	
	public static void testConstructeurAvecDuree() {
		System.out.println("Test cas normal, Duree > 0");
		
		Duree d= new Duree(2000);
		Duree d2= new Duree(d);
		
		if(d2.getLeTemps() ==2000) System.out.println("Test réussi");
	
		else System.out.println("Echec du test");
		
		System.out.println("Test du cas d'erreur: Ok si le message d'erreur s'affiche");
		
		d= new Duree(-2000);
	}
	
	public static void testConstructeurHMS() {
		System.out.println("Test cas normal, paramètres > 0");
		
		Duree d= new Duree(2, 2, 7);
		if(d.getLeTemps() == 7327000) System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur, paramètres < 0: OK si le message d'erreur s'affiche");
		
		d= new Duree(-2, -2, -7);	
	}
	
	
	//Tests des méthodes
	public static void testGetLeTemps() {
		System.out.println("Test de l'accesseur getLeTemps");
		
		System.out.println("Test avec le constructeur 1");
		Duree duree= new Duree(1500);
		if(duree.getLeTemps() == 1500) System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test avec le constructeur 2");
		duree= new Duree(new Duree(2000));
		if(duree.getLeTemps() == 2000) System.out.println("Test réussi");
		else System.out.println("Echec du test");
		
		System.out.println("Test avec le constructeur 3");
		duree= new Duree(2, 2, 0);
		if(duree.getLeTemps() == 7320000) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	public static void testCompareA() {
		System.out.println("Test de la méthode compareA");
		
		Duree duree1= new Duree(1700);
		Duree duree2= new Duree(2000);
		
		int comparaison= duree1.compareA(duree2);
		
		if(comparaison == 0 || comparaison == 1 || comparaison == -1) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	public static void testAjoute() {
		System.out.println("Test de la méthode ajoute en cas normal");
		
		Duree dureeAAjouter= new Duree(2000);
		Duree dureeAModifier= new Duree(1000);
		
		dureeAModifier.ajoute(dureeAAjouter);
		
		if(dureeAModifier.getLeTemps() > 2000) System.out.println("Test réussi");

		else System.out.println("Echec du test");
		
		System.out.println("Test cas d'erreur: Ok si le message d'erreur s'affiche");
		
		dureeAAjouter= new Duree(-2000);
		dureeAModifier.ajoute(dureeAAjouter);
	}	
	
	public static void testEnTexte() {  
		System.out.println("Test de la méthode en cas normal avec le mode J");
		
		Duree duree= new Duree(49, 0, 0);
		String enTexteJ= duree.enTexte('J');
		System.out.println(enTexteJ);
		System.out.println("Test réussi si affichage de: 2 jours 1 h");
		
		System.out.println("Test de la méthode en cas normal avec le mode H");
		
		duree= new Duree(2, 0, 0);
		String enTexteH= duree.enTexte('H');
		System.out.println(enTexteH); 
		System.out.println("Test réussi si affichage de: 2:0:0");
		
		
		System.out.println("Test de la méthode en cas normal avec mode S");
		
		duree= new Duree(2200);
		String enTexteS= duree.enTexte('S');
		System.out.println(enTexteS);
		System.out.println("Test réussi si affichage de: 2.200");
		
		System.out.println("Test de la méthode en cas normal avec le mode M");
		
		duree= new Duree(1);
		String enTexteM= duree.enTexte('M');
		System.out.println(enTexteM);
		System.out.println("Test réussi si affichage de: 1 millisec");
		
		System.out.println("Test cas d'erreur (erreur de caractère): Ok si le message d'erreur s'affiche");
		
		duree= new Duree(7000);
		String enTexteE= duree.enTexte('E');
	}
	
}
