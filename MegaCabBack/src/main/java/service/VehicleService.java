/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DBUtils;
import db.Vehicle;
import com.google.gson.Gson;
import db.Booking;
import db.Vehicle;
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
@Path("/vehicles")
public class VehicleService {
    private DBUtils utils = new DBUtils();
    private Gson gson = new Gson();

    // Endpoint to get all vehicles
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehicles() {
        try {
            List<Vehicle> vehicles = utils.getVehicles();
            if (vehicles.isEmpty()) {
                return Response.status(404).entity("{\"message\": \"No vehicles found\"}").build();
            }
            return Response.status(200).entity(gson.toJson(vehicles)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Failed to fetch vehicles\"}").build();
        }
    }

    // Endpoint to add a new vehicle
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVehicle(String json) {
        try {
            Vehicle vehicle = gson.fromJson(json, Vehicle.class);
            
            // Validate vehicle data
            if (vehicle.getVehicleType() == null || vehicle.getVehicleType().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Vehicle type is required\"}").build();
            }

            if (vehicle.getPlateNo() == null || vehicle.getPlateNo().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Plate number is required\"}").build();
            }

            if (vehicle.getSeats() <= 0) {
                return Response.status(400).entity("{\"message\": \"Seats must be a positive number\"}").build();
            }

            if (utils.addVehicle(vehicle)) {
                return Response.status(201).entity("{\"message\": \"Vehicle added successfully\"}").build();
            } else {
                return Response.status(500).entity("{\"message\": \"Failed to add vehicle\"}").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Error adding vehicle\"}").build();
        }
    }
}
