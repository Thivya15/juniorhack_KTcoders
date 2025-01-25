package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

    public String addStudent(String id, String name, int age, String department, Connection conn) {
        String sql = "INSERT INTO employees (employee_id,name,age,department )VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, department);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res > 0) {
                return "Successfully added the record of the employee Id: " + id;
            } else {
                return "Registering employee is unsuccessful!";
            }
        } catch (SQLException e) {
            return "Registering employee is unsuccessful! Reason: " + e.getMessage();
        }
    }

    public String viewStudent(String id, Connection conn){
        String sql = "SELECT * FROM employees WHERE employee_id = ?;";
        StringBuilder result = new StringBuilder();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,id);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){
                String empId = res.getString("employee_id");
                String name = res.getString("name");
                int age = res.getInt("age");
                String department = res.getString("department");
                return String.format("ID: %s, Name: %s, Age: %d, Department: %s\n", id, name, age, department);

            } else {
                return "employee records are empty!";
            }
        }
        catch (SQLException e){
            return "Retrieving employee is unsuccessful! Reason: "+ e.getSQLState();
        }
    }


}



