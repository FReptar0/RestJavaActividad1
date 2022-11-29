package com.example.controller.usuarios;

import java.util.List;

import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.model.usuarios.BeanUsuarios;
import com.example.model.usuarios.DaoUsuarios;
import com.example.utils.Response;

@Path("/api")
public class ServiceUsuarios {

    @GET
    @Path("/employee")
    @Produces(value = { "application/json" })
    public Response<List> getAll() {
        return new DaoUsuarios().findAll();
    }

    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanUsuarios> getOne(@PathParam("id") Long id) {
        return new DaoUsuarios().findOne(id);
    }

    @POST
    @Path("/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanUsuarios> save(@WebParam BeanUsuarios employee) {
        return new DaoUsuarios().save(employee);

    }

}
