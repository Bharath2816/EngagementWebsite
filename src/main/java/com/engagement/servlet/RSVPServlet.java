
package com.engagement.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.engagement.db.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitRSVP")
public class RSVPServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from RSVP form
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String guests = request.getParameter("guests");
        String attendance = request.getParameter("attendance");
        String message = request.getParameter("message");

        String sql = "INSERT INTO rsvp " +
                     "(name, phone, guests, attendance, message) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setInt(3, Integer.parseInt(guests));
            statement.setString(4, attendance);
            statement.setString(5, message);

            int result = statement.executeUpdate();

            if (result > 0) {
                response.sendRedirect("success.html");
            }

          
        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("===== RSVP ERROR =====");
            System.out.println("Error Message: " + e.getMessage());
            e.printStackTrace();
            System.out.println("======================");

            response.setContentType("text/html");

            response.getWriter().println(
                "<h2>Something went wrong!</h2>"
            );
        }
        

    }
}

