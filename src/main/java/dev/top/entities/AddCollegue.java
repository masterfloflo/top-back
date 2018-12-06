package dev.top.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddCollegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String matricule;
	private String pseudo;
	private String imageUrl;
	
	public AddCollegue(String matricule, String pseudo, String imageUrl) {
		super();
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
	}
	
	public AddCollegue() {}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String uRLimage) {
		imageUrl = uRLimage;
	}
	
	
	

}
