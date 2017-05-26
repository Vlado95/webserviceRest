package com.biblio.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface ICalculateur {
	

	
	double tva(@WebParam(name="ht") double ht, @WebParam(name="tauxPct")  double tauxPct);
	
	String getAuteur();
	
	
	

}
