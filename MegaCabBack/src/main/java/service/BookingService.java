/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import db.DBUtils;
import db.User;
import com.google.gson.Gson;
import db.Booking;
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
@Path("/bookings")
public class BookingService {
     private DBUtils utils = new DBUtils();
    private Gson gson = new Gson();

    // Endpoint to get all bookings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookings() {
        try {
            List<Booking> bookings = utils.getBookings();
            if (bookings.isEmpty()) {
                return Response.status(404).entity("{\"message\": \"No bookings found\"}").build();
            }
            return Response.status(200).entity(gson.toJson(bookings)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Failed to fetch bookings\"}").build();
        }
    }

    // Endpoint to add a new booking
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBooking(String json) {
        try {
            Booking booking = gson.fromJson(json, Booking.class);

            // Validate booking data
            if (booking.getVehicleType() == null || booking.getVehicleType().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Vehicle Type is required\"}").build();
            }

            if (booking.getPickup() == null || booking.getPickup().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Pickup is required\"}").build();
            }

            if (booking.getDropOff() == null || booking.getDropOff().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"DropOff is required\"}").build();
            }

            if (booking.getContactNo() == 0) {
                return Response.status(400).entity("{\"message\": \"Contact number is required\"}").build();
            }

            if (utils.addBooking(booking)) {
                return Response.status(201).entity("{\"message\": \"Booking added successfully\"}").build();
            } else {
                return Response.status(500).entity("{\"message\": \"Failed to add booking\"}").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Error adding booking\"}").build();
        }
    }
}
