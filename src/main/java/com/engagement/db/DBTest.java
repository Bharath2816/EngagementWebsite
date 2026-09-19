package com.engagement.db;

import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("SUCCESS: MySQL connected!");
        } else {
            System.out.println("FAILED: MySQL not connected!");
        }
    }
}

