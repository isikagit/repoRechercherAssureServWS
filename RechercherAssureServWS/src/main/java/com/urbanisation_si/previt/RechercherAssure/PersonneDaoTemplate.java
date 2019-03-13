package com.urbanisation_si.previt.RechercherAssure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class PersonneDaoTemplate {
	private HibernateTemplate template;   
	
	//on doit ajouter une méthode set pour le conteneur Spring 
	// qui puisse connaitre l’objet lors de la création d’objet et l’injection de dépendance.  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	} 
	
	//methode pour ajouter Personne  
	public void ajouterPersonne(Personne e){  
	    template.save(e);  
	}  
	
	// methode pour  modifier Personne  
	public void modifierPersonne(Personne e){  
	    template.update(e);  
	} 
	
	// methode pour Supprimer Personne  
	public void supprimerPersonne(Personne e){  
	    template.delete(e);  
	}  
	
	// methode pour selectionner une personne en utilisant l’id 
	public Personne getById(int id){  
	    Personne e=(Personne)template.get(Personne.class,id);  
	    return e;  
	}  
	
	//methode pour afficher toutes les personnes
	public List<Personne> getPersonnes(){  
	    List<Personne> list=new ArrayList<Personne>();  
	    list=template.loadAll(Personne.class);  
	    return list;  
	}  
	
}
