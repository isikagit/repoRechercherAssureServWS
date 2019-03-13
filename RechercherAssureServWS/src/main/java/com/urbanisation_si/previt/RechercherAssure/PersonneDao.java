package com.urbanisation_si.previt.RechercherAssure;

import java.util.List;

/**
 * 
 * @author Patrice
 *
 */
public interface PersonneDao {
	 
	public void ajouterPersonne(Personne e);
	
	public void modifierPersonne(Personne e);
	
	public void supprimerPersonne(Personne e);
	
	public Personne getById(int id);
	
	public List<Personne> getPersonnes();
	
	public List getPersonnebyNomEtPrenom(String pnom, String pprenom);
		
}
