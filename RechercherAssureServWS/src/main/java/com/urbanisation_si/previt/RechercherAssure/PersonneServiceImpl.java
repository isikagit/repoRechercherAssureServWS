package com.urbanisation_si.previt.RechercherAssure;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Patrice
 *
 */
@Service
@ManagedBean(name="personneService")
@SessionScoped
@Transactional(readOnly = true)
public class PersonneServiceImpl implements PersonneService {
	
	private PersonneDao personneDao;
	 
    public void setPersonneDao(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    @Transactional(readOnly = false)
	public void ajouterPersonne(Personne e) {
    	personneDao.ajouterPersonne(e);
	}

    @Transactional(readOnly = false)
	public void modifierPersonne(Personne e) {
		personneDao.modifierPersonne(e);
	}

    @Transactional(readOnly = false)
	public void supprimerPersonne(Personne e) {
		personneDao.supprimerPersonne(e);
	}

	public Personne getById(int id) {
		return personneDao.getById(id);
	}

	public List<Personne> getPersonnes() {
		return personneDao.getPersonnes();
	}
	
	public List<Personne> getPersonnebyNomEtPrenom(String pnom, String pprenom) {
		return personneDao.getPersonnebyNomEtPrenom(pnom, pprenom);
    }

	
	
}
