package datas;

public class LecteurCDTest {
	
	public static void main (String[] args) {
		
		//------------------Tests du constructeur-------------------------------------------------------------------------------------
		
		System.out.println("====================Test du constructeur====================");
		testConstructeur();
		
		//------------------Tests des accesseurs--------------------------------------------------------------------------------------
		System.out.println("==========================Test accesseur getTempsTotal===============================================");
		testGetTempsTotal();

		System.out.println("==========================Test accesseur getNbrePlages===============================================");
		testGetNbrePlages();
		
		System.out.println("==========================Test accesseur getIndexCourant===============================================");
		testGetIndexCourant();
		
		System.out.println("==========================Test accesseur getPlageCourante===============================================");
		testGetPlageCourante();
		
		System.out.println("==========================Test accesseur estCharge===============================================");
		testEstCharge();
		
		System.out.println("==========================Test accesseur getCD===============================================");
		testGetCD();
		
		//------------------Tests des modificateurs----------------------------------------------------------------------------------

		System.out.println("==========================Test modificateur setDecharger===============================================");
		testSetDecharger();
		
		System.out.println("==========================Test modificateur stop===============================================");
		testStop();
		
		System.out.println("==========================Test modificateur play===============================================");
		testPlay();
		
		System.out.println("==========================Test modificateur next===============================================");
		testNext();
		
		System.out.println("==========================Test modificateur previous===============================================");
		testPrevious();
		
		//------------------Tests des méthodes---------------------------------------------------------------------------------------
		
		System.out.println("==========================Test méthode chargerUnCD===============================================");
		testChargerUnCD();	
		
	}
	
	
	//Tests du constructeur
	public static void testConstructeur() {	
		System.out.println("Test constructeur, cas normal");
		
		LecteurCD lecteur= new LecteurCD();
		
		if(lecteur.estCharge() == true && lecteur.getIndexCourant() == 0 && lecteur.getCD() != null) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	//Tests des accesseurs 
	
	//Test getTempsTotal
	public static void testGetTempsTotal() {
		System.out.println("Test getTempsTotal, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		String tempsTotal= lecteur.getTempsTotal();
		
		if(tempsTotal != null && tempsTotal instanceof String) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	//Test getNbrePlages
	public static void testGetNbrePlages() {
		System.out.println("Test getNbrePlages, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		if(lecteur.getNbrePlages() >  0 || lecteur.getNbrePlages() == -1) System.out.println("Test réussi");
		else System.out.println("Echec du test");	
	}
	
	//Test getIndexCourant
	public static void testGetIndexCourant() {
		System.out.println("Test getIndexCourant, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		if(lecteur.getCD() != null) {
			if(lecteur.getIndexCourant() > 0 && lecteur.getIndexCourant() < lecteur.getNbrePlages()) System.out.println("Test réussi");
			else System.out.println("Echec du test");
		}
		else if(lecteur.getCD() == null) {
			if(lecteur.getIndexCourant() == 0) System.out.println("Test réussi");
			else System.out.println("Echec du test");
		}
	}
	
	//Test getPlageCourante
	public static void testGetPlageCourante() {
		System.out.println("Test getPlageCourante, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		if(lecteur.getCD() != null && lecteur.getIndexCourant() > 0) {
			if(lecteur.getPlageCourante() instanceof Plage) System.out.println("Test réussi");
			else System.out.println("Echec du test");
		}else if(lecteur.getCD() == null) {
			if(lecteur.getPlageCourante() == null) System.out.println("Test réussi");
			else System.out.println("Echec du test");
		}else if(lecteur.getCD() != null && lecteur.getIndexCourant() == 0) {
			if(lecteur.getPlageCourante() == null) System.out.println("Test réussi");
			else System.out.println("Echec du test");
		}
	}
	
	//Test estCharge
	public static void testEstCharge() {
		System.out.println("Test estCharge, cas normal");
		
		LecteurCD lecteur= new LecteurCD();
		
		if(lecteur.getCD() != null && lecteur.estCharge() == true) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	//Test getCD
	public static void testGetCD() {
		System.out.println("Test getCD");
		
		LecteurCD lecteur= new LecteurCD();
		
		if(lecteur.estCharge() == true) {
			if(lecteur.getCD() instanceof CD) System.out.println("Test réussi");
			else System.out.println("Echec du test");
		}
		else if(lecteur.estCharge() == false) {
			if(lecteur.getCD() == null) System.out.println("Test réussi");
			else System.out.println("Echec du test");
		}	
	}
	
	//Test setDecharger
	public static void testSetDecharger() {
		System.out.println("Test setDecharger, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		lecteur.setDecharger();
		
		if(lecteur.getCD() == null && lecteur.estCharge() == false) System.out.println("Test réussi");
		else System.out.println("Echec du test");
	}
	
	//Test chargerUnCd
	public static void testChargerUnCD() {
		System.out.println("Test chargerUnCD, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		lecteur.chargerUnCD();
		
		if(lecteur.getCD() != null && lecteur.estCharge() == true) System.out.println("Test réussi");
		else System.out.println("Echec du test");	
	}
	
	//Test stop
	public static void testStop() {
		System.out.println("Test Stop, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		lecteur.stop();
		
		if(lecteur.getCD() != null) {
			if(lecteur.getIndexCourant() == 1) System.out.println("Test réussi");
			else System.out.println("Echec du test");	
		}
		
	}
	
	//Test play
	public static void testPlay() {
		System.out.println("Test Play, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		lecteur.play();
		
		if(lecteur.getCD() != null) {
			if(lecteur.getIndexCourant() == 1) System.out.println("Test réussi");
			else System.out.println("Echec du test");	
		}
	}
	
	//Test next
	public static void testNext() {
		System.out.println("Test Next, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		int prevIndex = lecteur.getIndexCourant();
		
		lecteur.next();
		
		if(lecteur.getCD() != null) {
			if(lecteur.getIndexCourant() > prevIndex) System.out.println("Test réussi");
			else System.out.println("Echec du test");	
		}
	}
	
	//Test Previous
	public static void testPrevious() {
		System.out.println("Test previous, cas normal");
		
		LecteurCD lecteur = new LecteurCD();
		
		int prevIndex = lecteur.getIndexCourant();
		
		lecteur.previous();
		
		if(lecteur.getCD() != null) {
			if(lecteur.getIndexCourant() < prevIndex) System.out.println("Test réussi");
			else System.out.println("Echec du test");	
		}
	}
}

