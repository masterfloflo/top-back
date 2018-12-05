package dev.top.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@RestController()
@CrossOrigin
@RequestMapping("/collegue")
public class CollegueCtrl {
	
	@Autowired CollegueRepo corep;
	
	
	@GetMapping
	public List<Collegue> findAll() {
		return this.corep.findAll();
	}

	/*
	@PatchMapping("{/pseudo}") 
	public Collegue majCollegue(@PathVariable String nom, Avis action) {		
	}
	*/
	
	@PatchMapping("{/pseudo}")
    public Collegue patch(@PathVariable String pseudo, Map<String, String> vote) {

        String resultat = vote.get("actions");

		Collegue coco = this.corep.findByPseudo(pseudo);

        int ancienScore = coco.getScore();

        int nouveauScore;
        if(resultat.equals("AIMER")) {
            nouveauScore = ancienScore + 100;
        } else {
            nouveauScore = ancienScore - 50;
        }
        coco.setScore(nouveauScore);

        corep.save(coco);
        return coco;

    }
	
	
}
