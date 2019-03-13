/**
 * 
 */
package com.urbanisation_si.previt.RechercherAssure;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author Patrice
 *
 */
@Entity
@Table(name = "personne")
public class Personne  implements Serializable  {
	private static final long serialVersionUID = 8496087166198616020L;
    private Integer id;
    private String nom;
    private String prenom;
    private String codepostal;
    private Date date_naissance;
    
    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nom", nullable = false)
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column(name = "prenom", nullable = false)
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Column(name = "codepostal", nullable = true)
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	
	@Column(name = "date_naissance", nullable = false)
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
    
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Personne == false) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        final Personne pers = (Personne) obj;
        return new EqualsBuilder().append(id, pers.getId())
        		.append(nom, pers.getNom())
        		.append(prenom, pers.getPrenom())
        		.append(codepostal, pers.getCodepostal())
        		.append(date_naissance, pers.getDate_naissance())
                .isEquals();
    }
    
}
