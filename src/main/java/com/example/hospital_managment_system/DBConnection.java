package com.example.hospital_managment_system;

import control.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConnection  {

    public static Statement getStatement() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagment", "root", "pubudu");
        Statement stmt = con.createStatement();
        return stmt;

    }
    public static ObservableList<database> getDatausers() throws SQLException {
        Statement stmt= getStatement();
        ObservableList<database> list= FXCollections.observableArrayList();
        try {
            ResultSet rs=stmt.executeQuery("SELECT patient_name,patient_addr,diseases,status from patients");


            while (rs.next()){
                list.add(new database(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
