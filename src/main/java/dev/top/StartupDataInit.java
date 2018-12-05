package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;
    @Autowired
    CollegueRepo corep;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Version("v1"));
            this.versionRepo.save(new Version("v2"));
            this.versionRepo.save(new Version("v3"));
            this.versionRepo.save(new Version("v4"));
        }
        
        if(this.corep.count() <= 0) {
        this.corep.save(new Collegue(0, "Norbert", "http://savagehenrymagazine.com/wp-content/uploads/2018/04/3dbac25097f637eb028e628d3927ed45.jpg"));
        this.corep.save(new Collegue(0, "Madame Loïc", "http://www.zoom-cinema.fr/media/photos/celebrites/17359/_thumbs/herve_png_250x250_q95.jpg"));
        this.corep.save(new Collegue(0, "Hervé", "http://2.bp.blogspot.com/-BqPWIsq5r1Q/Ts_uzrtabwI/AAAAAAAAHaE/DzakW16Jz_M/s1600/herve.jpg"));
        }
        /*
         * new Collegue("Hervé", 0, "Seulement 2 arrêts maladies", )),
     new Collegue("Billy", 0, "Seulement 30min de retard tous les matins", [1, 2, 3, 4].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`)),
     new Collegue("Hubert-bonisseur-delabatte", 0, "J'aime me battre", [1, 2, 3, 4].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`)),
     new Collegue("Crouton", 0, "Vieux et moche", [1, 2, 3, 4].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`))
        */
    }
    
    
    
    
}
