/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.abrea_final_project;

/**
 *
 * @author fritz
 */
import java.sql.*;

public final class DBHelper {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    // Constructor
    public DBHelper() {
        try {
            connectdb();
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
    
    public void connectdb() {
    try {
        MySQLConnection connection = new MySQLConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
        con = connection.getConnection();
        System.out.println("Connected to database.");
    } catch (SQLException e) {
        System.err.println(e.toString());
    }
}

    
    public void insertRecord(String name, int age, String section, String birthday) {
    String query = "INSERT INTO table VALUES ('" + name + "', '" + age + "', '" + section + "', '" + birthday + "')";
    try {
        stmt.executeUpdate(query);
        System.out.println("Record added.");
    } catch (SQLException e) {
        System.err.println(e.toString());
    }
}

    
    public ResultSet displayAllRecords() {
        String query = "SELECT * FROM students";
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return rs;
    }
    
    public ResultSet displayRecordsByProgram(String program) {
        String query = "SELECT * FROM students WHERE program='" + program + "'";
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return rs;
    }

    void insert(String name, int age, String section, String birthday) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

