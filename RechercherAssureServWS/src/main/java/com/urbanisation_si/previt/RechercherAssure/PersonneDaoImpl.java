package com.urbanisation_si.previt.RechercherAssure;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Patrice
 *
 */
@Repository("personneDao")
@Transactional
public class PersonneDaoImpl implements PersonneDao {
	
	private SessionFactory sessionFactory;
	private Session session ;
	 
    public void setSessionFactory(SessionFactory factory){
        sessionFactory=factory;
    }

	public void ajouterPersonne(Personne e) {
		sessionFactory.getCurrentSession().merge(e);
		
	}

	public void modifierPersonne(Personne e) {
		// TODO Auto-generated method stub
		
	}

	public void supprimerPersonne(Personne e) {
		sessionFactory.getCurrentSession().delete(e);
		
	}

	public Personne getById(int id) {
		return (Personne) sessionFactory.getCurrentSession().get(Personne.class, id);
	}

	public List<Personne> getPersonnes() {
//		Attention createCriteria est deprecated
//		return sessionFactory.getCurrentSession().createCriteria(Person.class).list();
		Session session = sessionFactory.openSession();

        // create Criteria
        CriteriaQuery<Personne> criteriaQuery = session.getCriteriaBuilder().createQuery(Personne.class);
        criteriaQuery.from(Personne.class);

        List<Personne> personnes = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return personnes;
	}
	
	@Transactional
	public List<Personne> getPersonnebyNomEtPrenom(String pnom, String pprenom) {
		try 
		{
		    //Step-2: Implementation
		    session = sessionFactory.getCurrentSession();
		} 
		catch (HibernateException e) 
		{
		    //Step-3: Implementation
		    session = sessionFactory.openSession();
		}
		String hql = "from Personne p WHERE p.nom=:nom and p.prenom=:prenom";
		List<Personne> personnes = 
				session.createQuery(hql).setParameter("nom", pnom).setParameter("prenom", pprenom).list();
		return personnes;
    }

}
