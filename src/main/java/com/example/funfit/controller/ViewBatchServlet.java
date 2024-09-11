package com.example.funfit.controller;

import com.example.funfit.database.BatchDAO; // Make sure to create this DAO
import com.example.funfit.model.Batch; // Make sure to create this model
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-batches")
public class ViewBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BatchDAO batchDAO = new BatchDAO(); // Replace with actual DAO class
        List<Batch> batches = batchDAO.getAllBatches(); // Replace with actual method to get all batches

        // Convert batches list to JSON using Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonBatches = gson.toJson(batches);

        // Set response type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write the JSON to the response
        response.getWriter().write(jsonBatches);
    }
}
