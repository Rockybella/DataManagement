package com.example.funfit.controller;

import com.example.funfit.database.ParticipantDAO;
import com.example.funfit.model.Participant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-participants")
public class ViewParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ParticipantDAO participantDAO = new ParticipantDAO();
//        List<Participant> participants = participantDAO.getAllParticipants();
//        request.setAttribute("participants", participants);
//        request.getRequestDispatcher("/view-participants.jsp").forward(request, response);
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ParticipantDAO participantDAO = new ParticipantDAO();
        List<Participant> participants = participantDAO.getAllParticipants();
        
        System.out.println("print participants: " + participants);

        // Convert participants list to JSON using Gson (or any other JSON library)
        //Gson gson = new Gson();
        // Create a Gson instance with pretty printing enabled
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonParticipants = gson.toJson(participants);
        
        System.out.println(jsonParticipants);

        // Set response type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Write the JSON to the response
//        response.getWriter().write("{\"participants\": " + jsonParticipants + "}");
        // Write the JSON to the response
        response.getWriter().write(jsonParticipants);
    }
}
