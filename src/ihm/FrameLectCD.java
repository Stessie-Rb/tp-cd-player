package ihm;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import control.Ecouteurs;

public class FrameLectCD extends JFrame{
	
	//Attributs = les widgets
	
	//Infos dans le header
	private JButton bOn;
	private JTextField jtfTpsTotal;
	private JLabel labelTpsTotal;
	private JTextField jtfNbrDePlages;
	private JLabel labelNbrPlages;
	
	//Infos sur la plage en cours
	private JTextField jtfNumPlageCourante;
	private JTextField jtfDescriptionPlageCourante;
	private JTextField jtfDureePlageCourante;
	
	//Boutons 
	private JButton bPlay;
	private JButton bStop;
	private JButton bNext;
	private JButton bPrevious;
	
	
	//Constructeur
	public FrameLectCD(String titre){
		miseEnPlaceDuDecor();
		attacherEcouteurs();
		this.setSize(1000, 500);
		this.setTitle(titre);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Accesseurs
	public JButton getBplay() {
		return bPlay;
	}
	
	public JButton getBStop() {
		return bStop;
	}
	
	public JButton getBNext() {
		return bNext;
	}
	
	public JButton getBPrevious() {
		return bPrevious;
	}
	
	public JButton getBOn() {
		return bOn;
	}
	
	public JTextField getJtfTpsTotal() {
		return jtfTpsTotal;
	}
	
	public JTextField getJtfNbrPlages() {
		return jtfNbrDePlages;
	}
	
	public JTextField getJtfNumPlageCourante() {
		return jtfNumPlageCourante;
	}
	
	public JTextField getJtfdescriPlageCourante() {
		return jtfDescriptionPlageCourante;
	}
	
	public JTextField getJtfDureePlageCourante() {
		return jtfDureePlageCourante;
	}
	
	
	//Méthodes
	public void miseEnPlaceDuDecor() {
		
		this.setLayout(new GridLayout(1, 2));
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(4,1));
		
		JPanel imageContainer = new JPanel();
		
		this.add(content);
		this.add(imageContainer);
		
		//Construction des boutons
		bPlay = new JButton("Play");
		bStop = new JButton("Stop");
		bNext = new JButton("Next");
		bPrevious = new JButton("Previous");
		bOn = new JButton("Charger CD- On");
		
		//Construction des TextField et des JLabel du header
		jtfTpsTotal = new JTextField();
		jtfTpsTotal.setEnabled(false);
		labelTpsTotal = new JLabel("Temps total");
		jtfNbrDePlages = new JTextField();
		jtfNbrDePlages.setEnabled(false);
		labelNbrPlages = new JLabel("Nombre de plages");

		//Construction des JTextField qui affichent les infos de laplage courante
		jtfNumPlageCourante = new JTextField(5);
		jtfNumPlageCourante.setEnabled(false);
		jtfDescriptionPlageCourante = new JTextField();
		jtfDescriptionPlageCourante.setEnabled(false);
		jtfDureePlageCourante = new JTextField(5);
		jtfDureePlageCourante.setEnabled(false);
		
		//Pochette de l'album (version simplifiée car l'url de l'image est entrée en dur dans le code et elle ne change pas selon l'album
		ImageIcon imageAlbum = new ImageIcon("ws/pochette-album.jpg");

		JLabel pochetteAlbum = new JLabel(imageAlbum);
		imageContainer.add(pochetteAlbum);
	
		//Construction des différentes parties du lecteur CD et de leur layout
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(2,2));
		
		JPanel tools = new JPanel();
		tools.setLayout(new GridLayout(1,2));
		
		JPanel infosCD = new JPanel();
		infosCD.setLayout(new BorderLayout(5, 0));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,4)); 
		
		//Ajout des éléments dans leurs containers respectifs
		
		//placement des boutons
		buttons.add(bPlay);
		buttons.add(bStop);
		buttons.add(bNext);
		buttons.add(bPrevious);
		
		tools.add(bOn);
		
		//Placement des JTextField et des JLabels du header
		header.add(labelTpsTotal);
		header.add(jtfTpsTotal);
		header.add(labelNbrPlages);
		header.add(jtfNbrDePlages);
		
		//Placement des infos de la plage courante au centre du lecteur 
		infosCD.add(jtfNumPlageCourante, BorderLayout.WEST);
		infosCD.add(jtfDescriptionPlageCourante, BorderLayout.CENTER);
		infosCD.add(jtfDureePlageCourante, BorderLayout.EAST);
		
		//Ajout des différents container à la JFrame
		content.add(tools);
		content.add(header);
		content.add(infosCD);
		content.add(buttons);
		
	}
	
	public void attacherEcouteurs() {
		
		bPlay.addActionListener(new Ecouteurs(this));
		bStop.addActionListener(new Ecouteurs(this));
		bNext.addActionListener(new Ecouteurs(this));
		bPrevious.addActionListener(new Ecouteurs(this));
		bOn.addActionListener(new Ecouteurs(this));
	
	}
	
	//Lanceur
	public static void main (String[] args) {
		FrameLectCD myF= new FrameLectCD("Lecteur CD");
	}
}

