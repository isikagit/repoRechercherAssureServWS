package com.urbanisation_si.previt.RechercherAssure;

import java.util.List;

import javax.jws.WebService;

/**
 * 
 * @author Patrice
 *
 */
@WebService(
	    endpointInterface = "com.urbanisation_si.previt.RechercherAssure.PersonneWS",
	    serviceName = "personneWS")
public class PersonneWSImpl implements PersonneWS {
	
	private PersonneServiceImpl personneService;

	public PersonneServiceImpl getPersonneService() {
		return personneService;
	}

	public void setPersonneService(PersonneServiceImpl personneService) {
		this.personneService = personneService;
	}
	
	public String getPersonnebyNomEtPrenom(String pnom, String pprenom) {
		List<Personne> l = personneService.getPersonnebyNomEtPrenom(pnom, pprenom);
		StringBuffer sb = new StringBuffer();
		for (Personne p : l) {
			sb.append(p.getNom() + " " + p.getPrenom() + "\n");
		}
		return sb.toString();
	}

}
