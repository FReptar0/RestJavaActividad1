package com.example.controller.pendientes;

import java.util.List;

import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.usuarios.DaoPendiente;
import com.example.utils.Response;

@Path("/api")
public class ServicePendientes {

    @GET
    @Path("/pendientes/{fk}")
    @Produces(value = { "application/json" })
    public Response<List> getAll(@PathParam("fk") Long id) {
        return new DaoPendiente().findAll(id);
    }

    @GET
    @Path("/pendientes/{fk}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanPendiente> getOne(@PathParam("fk") Long fk, @PathParam("id") Long id) {
        return new DaoPendiente().findOne(id);
    }

    @POST
    @Path("/pendientes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanPendiente> save(@WebParam BeanPendiente pendientes) {
        return new DaoPendiente().save(pendientes);

    }

    @PUT
    @Path("/pendientes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response<BeanPendiente> update(@WebParam BeanPendiente pendientes, @PathParam("id") Long id) {
        return new DaoPendiente().update(pendientes, id);
    }

    @DELETE
    @Path("/pendientes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanPendiente> delete(@PathParam("id") Long id) {
        return new DaoPendiente().delete(id);
    }

}
