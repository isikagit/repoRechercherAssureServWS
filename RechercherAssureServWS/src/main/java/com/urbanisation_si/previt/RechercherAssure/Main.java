package com.urbanisation_si.previt.RechercherAssure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author Patrice
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Modif test Git modif 3
		Personne p = new Personne();
        p.setId(10);
		p.setNom("fofo");
		p.setPrenom("toto");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		PersonneDaoTemplate pdao = context.getBean("daoTemplate", PersonneDaoTemplate.class);
//		pdoa. ajouterPersonne(p); 
		Personne pe = pdao.getById(1);
		System.out.println(
				pe.getId() + " " + 
				pe.getNom() + " " + 
				pe.getPrenom() + " " +
				pe.getCodepostal() + " " +
				pe.getDate_naissance());
		
		List<Personne> liste=new ArrayList<Personne>();
		liste = pdao.getPersonnes();
		for (Personne personne : liste) {
			System.out.println(
					personne.getId() + " " + 
					personne.getNom() + " " + 
					personne.getPrenom() + " " +
					personne.getCodepostal() + " " +
					personne.getDate_naissance());
		}
		
		

		PersonneServiceImpl personneService = context.getBean("personneService", PersonneServiceImpl.class);
		liste = personneService.getPersonnebyNomEtPrenom("Dupont", "Paul");
		for (Personne personne : liste) {
			System.out.println(
					personne.getId() + " " + 
					personne.getNom() + " " + 
					personne.getPrenom() + " " +
					personne.getCodepostal() + " " +
					personne.getDate_naissance());
		}
		
	}

}
