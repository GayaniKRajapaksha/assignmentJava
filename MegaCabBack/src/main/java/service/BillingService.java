/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import db.DBUtils;
import db.User;
import db.Bill;
import com.google.gson.Gson;
import db.Booking;
import java.math.BigDecimal;
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
@Path("/bills")
public class BillingService {
    
    private DBUtils utils = new DBUtils();
        private Gson gson = new Gson();


    // Endpoint to get all bills
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBills() {
        try {
            List<Bill> bills = utils.getBills();
            if (bills.isEmpty()) {
                return Response.status(404).entity("{\"message\": \"No bills found\"}").build();
            }
            return Response.status(200).entity(gson.toJson(bills)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Failed to fetch bills\"}").build();
        }
    }

    // Endpoint to add a new bill
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBill(String json) {
        try {
            Bill bill = gson.fromJson(json, Bill.class);

            // Validate bill data
            if (bill.getContactNo() == 0) {
                return Response.status(400).entity("{\"message\": \"Contact number is required\"}").build();
            }

            if (bill.getPickupLocation() == null || bill.getPickupLocation().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Pickup location is required\"}").build();
            }

            if (bill.getDropLocation() == null || bill.getDropLocation().isEmpty()) {
                return Response.status(400).entity("{\"message\": \"Drop location is required\"}").build();
            }

            if (bill.getDistance() == null || bill.getDistance().compareTo(BigDecimal.ZERO) <= 0) {
                return Response.status(400).entity("{\"message\": \"Valid distance is required\"}").build();
            }

            if (bill.getTotal() == null || bill.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
                return Response.status(400).entity("{\"message\": \"Total amount is required\"}").build();
            }

            if (utils.addBill(bill)) {
                return Response.status(201).entity("{\"message\": \"Bill added successfully\"}").build();
            } else {
                return Response.status(500).entity("{\"message\": \"Failed to add bill\"}").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("{\"message\": \"Error adding bill\"}").build();
        }
    }
}
