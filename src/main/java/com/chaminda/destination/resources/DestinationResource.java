package com.chaminda.destination.resources;

import com.chaminda.destination.core.Destination;
import com.chaminda.destination.db.DestinationDao;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@Path("/destinations")
@Api("/destinations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DestinationResource {

    private DestinationDao destinationDao ;

    public DestinationResource(DestinationDao destinationDao){
        this.destinationDao = destinationDao;

    }

    @GET
    @ApiOperation("Get all destinations")
    public List<Destination> getAll(){
        return destinationDao.getAll();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(
            value = "Get destination by given id",
            notes = "Get destination for the given destination id",
            response = Destination.class
    )
    public Destination get(@PathParam("id") int id){
        return destinationDao.findById(id);
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @ResponseWrapper()
    @ApiOperation(
            value = "Creates destination",
            notes = "Creates new destination with given details",
            response = Destination.class
    )
    public Destination create(Destination destination){
        int id = destinationDao.insert(destination);
        destination.setId(id);
        return destination;
    }

    @Path("{id}")
    @DELETE
    @ApiOperation(
            value = "Deletes existing destination by given id",
            notes = "Delete operation for destination for given destination id"
    )
    public void delete( @PathParam("id") int id ){
        destinationDao.deleteById(id);
    }
}
