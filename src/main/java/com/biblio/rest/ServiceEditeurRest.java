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

import com.biblio.entity.Editeur;
import com.biblio.service.IService;
@Path("/editeurs")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component // ou @Service (info :herite de component) : pour prise en charge  Spring
public class ServiceEditeurRest implements ServiceRest<Editeur> {

	@Autowired
	private IService<Editeur> serviceEditeur;
	
	@Override
	@GET
	@Path("/{id}")
	public Editeur rechercher(@PathParam("id") int id) {
		return serviceEditeur.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	public List<Editeur> getAll() {
		// TODO Auto-generated method stub
		return serviceEditeur.findAll();
	}

	@Override
	@GET
	@Path("/nomlike/{str}")
	public List<Editeur> getAll(@PathParam("str") String str) {
		return serviceEditeur.chercherParString(str);
	}

	@Override
	@POST
	@Path("/")
	public Response ajouter(Editeur editeur) {
		try {
			serviceEditeur.ajouter(editeur);
			return Response.status(Status.OK).entity(editeur) // partie "donn�e"
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
	public Response supprimer(@PathParam("id")int id) {
		try {
			serviceEditeur.supprimer(id);
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
	public Response maj(int id, Editeur editeur) {
		try {
			serviceEditeur.maj(editeur);;
			return Response.status(Status.OK).entity(editeur).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}


}
