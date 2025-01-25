package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hostel {

    String id;
    String name;
    int noOfRoom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfRoom() {
        return noOfRoom;
    }

    public void setNoOfRoom(int noOfRoom) {
        this.noOfRoom = noOfRoom;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    Connection conn;

    public Hostel(String id, String name, int noOfRoom) {
        this.id = id;
        this.name = name;
        this.noOfRoom = noOfRoom;

    }

    public String addHostel(String id, String name, int noOfRoom) {
        String sql = "INSERT INTO hostel (hosId,name,hosNoOfRoom )VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, noOfRoom);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res > 0) {
                return "Successfully added the record of the Hostel Id: " + id;
            } else {
                return "Registering hostel is unsuccessful!";
            }
        } catch (SQLException e) {
            return "Registering hostel is unsuccessful! Reason: " + e.getMessage();
        }
    }


    //
    public String viewHostel(String id, Connection conn) {
        String sql = "SELECT * FROM hmsystem WHERE hosId = ?;";
        StringBuilder result = new StringBuilder();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, id);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                String hosId = res.getString("hosId");
                String name = res.getString("name");
                int age = res.getInt("age");
                String department = res.getString("department");
                return String.format("ID: %s, Name: %s, NoOfRooms: %d", id, name,noOfRoom);

            } else {
                return "hostel records are empty!";
            }
        } catch (SQLException e) {
            return "Retrieving hostel is unsuccessful! Reason: " + e.getSQLState();
        }
    }


    //update hostel detailes
    public String updateHostel(String id, String attribute, Object value,Connection conn){

        String sql = "UPDATE hostels SET " + noOfRoom + " = ? WHERE hosId = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            if (!attribute.equals("noOfRoom")) {
                preparedStatement.setString(1, value.toString());
            } else {
                preparedStatement.setInt(1, Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2, id);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res > 0) {
                return "Successfully updated the record of the hostel Id: " + id;
            } else {
                return "Updating hostel is unsuccessful!";
            }
        } catch (SQLException e) {
            return "Updating hostel is unsuccessful! Reason: " + e.getMessage();
        }


    }
}
