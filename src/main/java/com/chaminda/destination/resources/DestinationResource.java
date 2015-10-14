package com.chaminda.destination.resources;

import com.chaminda.destination.core.Destination;
import com.chaminda.destination.db.DestinationDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@Path("/destinations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DestinationResource {

    private DestinationDao destinationDao ;

    public DestinationResource(DestinationDao destinationDao){
        this.destinationDao = destinationDao;

    }

    @GET
    public List<Destination> getAll(){
        return destinationDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Destination get(@PathParam("id") int id){
        return destinationDao.findById(id);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @ResponseWrapper()
    public Destination create(Destination destination){
        int id = destinationDao.insert(destination);
        destination.setId(id);
        return destination;
    }

    @Path("{id}")
    @DELETE
    public void delete( @PathParam("id") int id ){
        destinationDao.deleteById(id);
    }
}
