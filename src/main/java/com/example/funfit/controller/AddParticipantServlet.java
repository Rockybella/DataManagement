package com.example.funfit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.funfit.database.Database;
import com.example.funfit.model.Participant;

/**
 * Servlet implementation class AddParticipantServlet
 */
public class AddParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddParticipantServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a Participant object
        Participant sendToMySqlP1 = new Participant();

        // Set form data in the Participant object
        sendToMySqlP1.setName(request.getParameter("name"));
        sendToMySqlP1.setPhone(request.getParameter("phone"));
        sendToMySqlP1.setEmail(request.getParameter("email"));
        int bidToInteger = Integer.parseInt(request.getParameter("bid"));
        sendToMySqlP1.setBid(bidToInteger);

        // Use the database singleton instance
        Database db = Database.getInstance();
        Connection connection = null;
        PreparedStatement ps = null;

        String insertParticipantSql = "INSERT INTO Participant (name, phone, email, bid) VALUES (?, ?, ?, ?)";

        try {
            // Get database connection
            connection = db.getConnection();
            ps = connection.prepareStatement(insertParticipantSql);

            // Set parameters for the participant insertion
            ps.setString(1, sendToMySqlP1.getName());
            ps.setString(2, sendToMySqlP1.getPhone());
            ps.setString(3, sendToMySqlP1.getEmail());
            ps.setInt(4, sendToMySqlP1.getBid());

            // Execute the update and get the result
            int result = ps.executeUpdate();

            if (result > 0) {
                request.setAttribute("successMessage", "Participant added successfully!");
                request.setAttribute("participantName", sendToMySqlP1.getName());
                request.setAttribute("participantPhone", sendToMySqlP1.getPhone());
                request.setAttribute("participantEmail", sendToMySqlP1.getEmail());
                request.setAttribute("participantBID", sendToMySqlP1.getBid());
                // Forward the request to the JSP for rendering the view
                RequestDispatcher dispatcher = request.getRequestDispatcher("/add-participant.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Failed to add participant.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/add-participant.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add-participant.jsp");
            dispatcher.forward(request, response);
        } finally {
            // Close resources
            if (ps != null) {
                try { ps.close(); } catch (SQLException ignored) {}
            }
            if (connection != null) {
                db.closeConnection();
            }
        }
    }
}
