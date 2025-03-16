/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import db.DBUtils;
import db.User;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Administrator
 */
@Path("user")
public class UserService {
    private DBUtils utils = new DBUtils();
    private Gson gson = new Gson();

    // Endpoint to get all users
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        try {
            List<User> users = utils.getUsers();
            if (users.isEmpty()) {
                return Response.status(404).entity("{\"message\": \"No users found\"}").build();
            }
            return Response.status(200).entity(gson.toJson(users)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Failed to fetch users\"}").build();
        }
    }

    // Endpoint to add a new user
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(String json) {
        try {
            User user = gson.fromJson(json, User.class);
            
            
            // Validate user data
            if (user.getNic() == 0) {
                return Response.status(400).entity("{\"message\": \"NIC is required\"}").build();
            }

            if (user.getName() == null || user.getName().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Name is required\"}").build();
            }

            if (user.getUserType() == null || user.getUserType().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"UserType is required\"}").build();
            }

            if (user.getUsername() == null || user.getUsername().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Username is required\"}").build();
            }

            if (user.getPassword() == 0) {
                return Response.status(400).entity("{\"message\": \"Password is required\"}").build();
            }

            if (utils.addUser(user)) {
                return Response.status(201).entity("{\"message\": \"User added successfully\"}").build();
            } else {
                return Response.status(500).entity("{\"message\": \"Failed to add user\"}").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Error adding user\"}").build();
        }
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(String json) {
        try {
            // Parse the input JSON to get username and password
            User loginUser = gson.fromJson(json, User.class);
            String username = loginUser.getUsername();
            int password = loginUser.getPassword();

            // Validate login using DBUtils
            boolean isValid = utils.validateUserLogin(username, password);
            
            if (isValid) {
                // Get the userType from the database
                String userType = utils.getUserType(username);

                // Check user type and return appropriate response
                if ("admin".equalsIgnoreCase(userType)) {
                    return Response.status(200).entity("{\"message\": \"Login successful\", \"redirect\": \"adminDashboard.html\"}").build();
                } else if ("driver".equalsIgnoreCase(userType)) {
                    return Response.status(200).entity("{\"message\": \"Login successful\", \"redirect\": \"driverDashboard.html\"}").build();
                } else if ("customer".equalsIgnoreCase(userType)) {
                    return Response.status(200).entity("{\"message\": \"Login successful\", \"redirect\": \"customerHome.html\"}").build();
                } else {
                    return Response.status(401).entity("{\"message\": \"Invalid user type\"}").build();
                }
            } else {
                return Response.status(401).entity("{\"message\": \"Invalid username or password\"}").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Error during login\"}").build();
        }
    }
}
