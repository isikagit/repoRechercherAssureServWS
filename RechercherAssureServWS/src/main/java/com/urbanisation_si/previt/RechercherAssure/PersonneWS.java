package com.urbanisation_si.previt.RechercherAssure;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface PersonneWS {
	
	@WebMethod
	public String getPersonnebyNomEtPrenom(
			@WebParam(name="pnom") String pnom, 
			@WebParam(name="pprenom") String pprenom);
}
