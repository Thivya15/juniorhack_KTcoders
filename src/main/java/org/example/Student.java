package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

    String id;
    String name;
    int age;
    String department;


    public String addStudent(String id, String name, int age, String department, Connection conn) {
        String sql = "INSERT INTO student (id,name,age,department )VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, department);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res > 0) {
                return "Successfully added the record of the student Id: " + id;
            } else {
                return "Registering student is unsuccessful!";
            }
        } catch (SQLException e) {
            return "Registering student is unsuccessful! Reason: " + e.getMessage();
        }
    }

    public String viewStudent(String id, Connection conn){
        String sql = "SELECT * FROM student WHERE student_id = ?;";
        StringBuilder result = new StringBuilder();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,id);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()){
                String empId = res.getString("student_id");
                String name = res.getString("name");
                int age = res.getInt("age");
                String department = res.getString("department");
                return String.format("ID: %s, Name: %s, Age: %d, Department: %s\n", id, name, age, department);

            } else {
                return "student records are empty!";
            }
        }
        catch (SQLException e){
            return "Retrieving student is unsuccessful! Reason: "+ e.getSQLState();
        }
    }

    public String updateStudent(String id, String attribute, Object value,Connection conn){
        String sql = "UPDATE student SET " + attribute + " = ? WHERE student_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            if(!attribute.equals("age")) {
                preparedStatement.setString(1, value.toString());
            }else{
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,id);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res>0) {
                return "Successfully updated the record of the student Id: " + id;
            } else {
                return "Updating student is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Updating student is unsuccessful! Reason: "+ e.getMessage();
        }
    }

    public String deleteStudent(String id, Connection conn){
        String sql = "DELETE FROM student WHERE student_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1,id);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return "Successfully deleted the record of the student Id: " + id;
            }
            else if (row == 0) {
                return "Given student is not found!";
            }
            else{
                return "Deleting student is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Deleting student is unsuccessful! Reason: "+ e.getMessage();
        }
    }






}



