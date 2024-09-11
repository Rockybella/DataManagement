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
import com.example.funfit.model.Batch;

/**
 * Servlet implementation class AddBatchServlet
 */
public class AddBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBatchServlet() {
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

        // Create a Batch object
        Batch batch = new Batch();

        // Set form data in the Batch object
        batch.setBatchName(request.getParameter("batchName"));
        batch.setInstructor(request.getParameter("instructor"));

        // Use the database singleton instance
        Database db = Database.getInstance();
        Connection connection = null;
        PreparedStatement ps = null;

        // Ensure SQL column names match the table schema
        String insertBatchSql = "INSERT INTO Batch (batchName, instructor) VALUES (?, ?)";

        try {
            // Get database connection
            connection = db.getConnection();
            ps = connection.prepareStatement(insertBatchSql);

            // Set parameters for the batch insertion
            ps.setString(1, batch.getBatchName());
            ps.setString(2, batch.getInstructor());

            // Execute the update and get the result
            int result = ps.executeUpdate();

            if (result > 0) {
                request.setAttribute("successMessage", "Batch added successfully!");
                request.setAttribute("batchName", batch.getBatchName());
                request.setAttribute("instructor", batch.getInstructor());
                // Forward the request to the JSP for rendering the view
                RequestDispatcher dispatcher = request.getRequestDispatcher("/add-batch.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Failed to add batch.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/add-batch.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add-batch.jsp");
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
