package control;

import ihm.FrameLectCD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import datas.LecteurCD;

public class Ecouteurs implements ActionListener {
	
	private FrameLectCD frameLect;
	private LecteurCD lecteurCD;
	
		//Constructeur
		public Ecouteurs(FrameLectCD theL){
			this.frameLect = theL;
			this.lecteurCD = new LecteurCD();
		}
		
		public void actionPerformed(ActionEvent e){
		
			if(e.getSource() == frameLect.getBOn()) {
				lecteurCD = new LecteurCD();
				setTextJtfHeader();
				setTextJtfInfosCD();		
			}
			else if(e.getSource() == frameLect.getBplay()) {
				lecteurCD.play();
				setTextJtfInfosCD();
			}
			else if(e.getSource() == frameLect.getBStop()) {
				lecteurCD.stop();
				setTextJtfInfosCD();
			}
			else if(e.getSource() == frameLect.getBNext()) {
				lecteurCD.next();
				setTextJtfInfosCD();
			}
			else if(e.getSource() == frameLect.getBPrevious()) {
				lecteurCD.previous();
				setTextJtfInfosCD();
			}
		}
		
		public void setTextJtfHeader() {
			frameLect.getJtfTpsTotal().setText(lecteurCD.getTempsTotal());
			frameLect.getJtfNbrPlages().setText(String.valueOf(lecteurCD.getNbrePlages()));
		}
		
		public void setTextJtfInfosCD() {
			if(lecteurCD.getPlageCourante() != null) {
				frameLect.getJtfNumPlageCourante().setText(String.valueOf(lecteurCD.getIndexCourant()));
				frameLect.getJtfdescriPlageCourante().setText(lecteurCD.getPlageCourante().toString());
				frameLect.getJtfDureePlageCourante().setText(lecteurCD.getPlageCourante().getLaDuree().enTexte('H'));
			}
			else {
				frameLect.getJtfNumPlageCourante().setText("");
				frameLect.getJtfdescriPlageCourante().setText("Aucune plage en cours de lecture");
				frameLect.getJtfDureePlageCourante().setText("");
			}
				
		}
}

