package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.AddCollegue;
import dev.top.entities.Avis;
import dev.top.entities.Avis.Action;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@RestController()
@CrossOrigin
@RequestMapping("/collegue")
public class CollegueCtrl {
	
	@Autowired private CollegueRepo corep;
	
	@GetMapping
	public List<Collegue> findAll() {
		return this.corep.findAll();
	}

	
	@PatchMapping("/{pseudo}")
    public Collegue patch(@PathVariable String pseudo,@RequestBody Avis avis) {

		Collegue coco = this.corep.findByPseudo(pseudo);

        int ancienScore = coco.getScore();

        int nouveauScore;
        if(avis.getAction().equals(Action.AIMER)) {
            nouveauScore = ancienScore + 100;
        } else {
            nouveauScore = ancienScore - 100;
        }

        coco.setScore(nouveauScore);
        this.corep.save(coco);
        return coco;

    }
	
	@GetMapping("/{pseudo}")

	public Collegue trouvercol(@PathVariable String pseudo) {
		Collegue coco = this.corep.findByPseudo(pseudo);
		return coco;
	}
	
	
	@PostMapping
	public Collegue ajoutCol(@RequestBody AddCollegue add ) {
		Collegue addColl = new Collegue();
		addColl.setPseudo(add.getPseudo());
		addColl.setImageUrl(add.getImageUrl());
				this.corep.save(addColl);
		return addColl;
	}
	
}
