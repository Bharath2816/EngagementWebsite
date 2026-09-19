package com.engagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.engagement.db.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminRSVP")
public class RSVPAdminServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String sql = "SELECT * FROM rsvp ORDER BY id DESC";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String name =
                        resultSet.getString("name");

                String phone =
                        resultSet.getString("phone");

                int guests =
                        resultSet.getInt("guests");

                String attendance =
                        resultSet.getString("attendance");

                String message =
                        resultSet.getString("message");

                String createdAt =
                        resultSet.getString("created_at");

                out.println("<tr>");

                out.println("<td>" + id + "</td>");

                out.println("<td>" + name + "</td>");

                out.println("<td>" + phone + "</td>");

                out.println("<td>" + guests + "</td>");

                out.println("<td>" + attendance + "</td>");

                out.println("<td>" + message + "</td>");

                out.println("<td>" + createdAt + "</td>");

                out.println("</tr>");
            }

        } catch (Exception e) {

            e.printStackTrace();

            out.println(
                "<tr><td colspan='7'>" +
                "Error loading RSVP data" +
                "</td></tr>"
            );
        }
    }
}

