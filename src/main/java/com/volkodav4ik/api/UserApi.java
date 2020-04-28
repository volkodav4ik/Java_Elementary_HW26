package com.volkodav4ik.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volkodav4ik.dao.UserDao;
import com.volkodav4ik.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class UserApi {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<User> users = UserDao.getInstance().getAll();
        String json = gson.toJson(users);
        return Response
                .status(Response.Status.OK)
                .entity(json)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addUser(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName) {
        UserDao.getInstance().addUser(new User(firstName, lastName));
        return Response
                .status(Response.Status.OK)
                .entity("User added")
                .build();
    }

}
