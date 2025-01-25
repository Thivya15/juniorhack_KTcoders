package Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateRooms(String id, String attribute, Object value, Connection conn) {

    private String attribute;
    String sql = "UPDATE employees SET " + attribute + " = ? WHERE roomId = ?";
        try(
    PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            if(!attribute.equals("age")) {
                preparedStatement.setString(1, value.toString());
            }else{
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,id);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();
            if (res>0) {
                return "Successfully updated the record of the employee Id: " + id;
            } else {
                return "Updating employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Updating employee is unsuccessful! Reason: "+ e.getMessage();
        }
    }


}
