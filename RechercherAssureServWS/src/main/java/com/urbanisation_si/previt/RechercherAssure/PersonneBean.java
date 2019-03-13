package com.urbanisation_si.previt.RechercherAssure;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Patrice
 *
 */
@Component
@Scope
public class PersonneBean {
	
    private Personne personne;
 
    private PersonneService personneService;
    
    private String test="Bonjour";
 
    public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public PersonneBean() {
    }
 
    public String ajouterPersonne() {
    	personneService.ajouterPersonne(personne);
        return "rechercherAssure";
    }
 
    public void supprimerPersonne(ActionEvent event) {
    	personneService.supprimerPersonne(personne);
    }
 
    public String modifierPersonne(){
        return "new_person";
    }
 
    public String newPersonne(){
        reinit();
        return "new_personr";
    }
    
    public void reinit() {
    	personne = new Personne();
    }
        
    public List<Personne> getPersonnes() {
        return personneService.getPersonnes();
    }
 
    public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public PersonneService getPersonneService() {
		return personneService;
	}

	@Autowired
	public void setPersonneService(PersonneService personneService) {
		this.personneService = personneService;
	}
 
}
