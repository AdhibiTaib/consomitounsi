package tn.esprit.consomitounsi.api;

//import java.util.ArrayList;
//import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;



import tn.esprit.consomitounsi.entities.Collection;
import tn.esprit.consomitounsi.services.intrf.CollectionServiceRemote;



@Path("/Collection")
public class CollectionResource {
	
	@EJB
    CollectionServiceRemote cols;
	
	
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addcollection(Collection col) {
    	cols.addCollection(col);
        return Response.ok(cols.findAllCollection()).build();
    }
    
    @POST
    @Path("/edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editcollection(Collection col) {
    	cols.updateCollection(col);
        return Response.ok(cols.findCollectionById(col.getIdcollection())).build();
    	//return Response.ok(cols.findAllCollection()).build();
    }
    
    
    @POST
    @Path("/del/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletecollectionby(@PathParam(value ="id") String id) {
    	cols.removeCollection(Integer.parseInt(id));
    	return Response.ok(cols.findAllCollection()).build();
    }
    
    @POST
    @Path("/colby/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findcollectionbyid(@PathParam(value ="id") String id) {
        return Response.ok(cols.findCollectionById(Integer.parseInt(id))).build();
    	//return Response.ok(cols.findAllCollection()).build();
    }
    
    @GET
    @Path("/allcolllections")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findallcollections() {
    	return Response.ok(cols.findAllCollection()).build();
    	
    }
    
    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addCart(Cart cart) {
//        return null;
        
    }