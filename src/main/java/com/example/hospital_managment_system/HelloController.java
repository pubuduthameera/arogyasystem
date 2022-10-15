package com.example.hospital_managment_system;

import control.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController implements Initializable {

//------------label--------------------
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblNoDoc;
    @FXML
    private Label lblNoPat;
    @FXML
    private Label lblNoEarn;
//---------------button----------------
    @FXML
    private Button repobtn;
    @FXML
    private Button dashbtn;
    @FXML
    private Button appointbtn;
    @FXML
    private Button billbtn;
    @FXML
    private Button docbtn;
  //------------table--------------
    @FXML
    private TableColumn<database, String> addresstb;
    @FXML
    private TableColumn<database, String> disetb;
    @FXML
    private TableColumn<database, String> nametb;
    @FXML
    private TableColumn<database, String> statb;
    @FXML
    private TableView<database> table;

    ObservableList<database> list= FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // nametb.setCellValueFactory(databaseStringCellDataFeatures -> databaseStringCellDataFeatures.getValue().getDiseases());

        DBConnection dbConnection = new DBConnection();
        ObservableList<database> datausers = null;
        try {
            datausers = dbConnection.getDatausers();
            System.out.println(datausers.stream().count());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nametb.setCellValueFactory(new PropertyValueFactory<database,String>("patient_name"));
        addresstb.setCellValueFactory(new PropertyValueFactory<database,String>("patient_addr"));
        disetb.setCellValueFactory(new PropertyValueFactory<database,String>("diseases"));
        statb.setCellValueFactory(new PropertyValueFactory<database,String>("status"));
        for (database user:datausers) {
            list.add(user);
        }
        /*list = getallreco();*/
        table.setItems(list);
        table.refresh();
//        try {
//            listM=DBConnection.getDatausers();
//            table.setItems(listM);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

public static ObservableList<database> getallreco() throws ClassNotFoundException,SQLException{
    String sql="SELECT patient_name,patient_addr,diseases,status from patients";
    try {
        ResultSet rs=DBConnection.getStatement().executeQuery(sql);
        ObservableList<database> list=getpatientlist(rs);
        return list;
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

    private static ObservableList<database> getpatientlist(ResultSet rs) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<database> list=FXCollections.observableArrayList();
            while (rs.next()){
                database da=new database("", "", "", "");
                da.setPatient_name(rs.getString(1));
                da.setPatient_addr(rs.getString(2));
                da.setDiseases(rs.getString(3));
                da.setStatus(rs.getString(4));
                list.add(da);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    @FXML
    protected void handlclicks(ActionEvent event) {
        if (event.getSource() == dashbtn) {
            lblTitle.setText("Dashboard");


        } else if (event.getSource() == docbtn) {
            lblTitle.setText("Doctors");
        } else if (event.getSource() == repobtn) {
            lblTitle.setText("Reports");
        } else if (event.getSource() == appointbtn) {
            lblTitle.setText("Appointment");
        } else if (event.getSource() == billbtn) {
            lblTitle.setText("Billing");
        }
    }
}