package com.biblio.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biblio.entity.Auteur;
import com.biblio.service.IService;



@Path("/auteurs")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component // ou @Service (info :herite de component) : pour prise en charge
			// Spring
public class ServiceAuteurRest implements ServiceRest<Auteur> {

	@Autowired
	private IService<Auteur> serviceAuteur;
	// service interne ou private IDaoteur daoAuteur; // dao interne

	@Override
	@GET
	@Path("/{id}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/1
	// o� service est configur� dans web.xml et rest dans restSpringConf.xml
	public Auteur rechercher(@PathParam("id") int id) {
		return serviceAuteur.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/all
	// o� service est configur� dans web.xml et rest dans restSpringConf.xml
	public List<Auteur> getAll() {
		return serviceAuteur.findAll();
	}

	@Override
	@GET
	@Path("/nomlike/{str}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// o� service est configur� dans web.xml et rest dans restSpringConf.xml
	public List<Auteur> getAll(@PathParam("str") String str) {
		return serviceAuteur.chercherParString(str);
	}

	@Override
	@POST
	@Path("/")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// o� service est configur� dans web.xml et rest dans restSpringConf.xml
	public Response ajouter(Auteur auteur) {
		try {
			serviceAuteur.ajouter(auteur);
			return Response.status(Status.OK).entity(auteur) // partie "donn�e"
																// de la r�ponse
																// renvoy�e
					.build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@Override
	@DELETE
	@Path("/{id}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// o� service est configur� dans web.xml et rest dans restSpringConf.xml
	public Response supprimer(@PathParam("id") int id) {
		try {
			serviceAuteur.supprimer(id);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@Override
	@PUT
	@Path("/{id}")
	// url complete :
	// http://localhost:8080/wsSpringCxfWeb/service/rest/auterus/nom/"vi"
	// o� service est configur� dans web.xml et rest dans restSpringConf.xml
	public Response maj(@PathParam("id") int id, Auteur auteur) {
		try {
			serviceAuteur.maj(auteur);;
			return Response.status(Status.OK).entity(auteur).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}

}
