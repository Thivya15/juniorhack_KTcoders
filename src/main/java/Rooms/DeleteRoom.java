package Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteRoom(String id, Connection conn) {
   // public String deleteEmployee(String id, Connection conn){
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try(
    PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1,id);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return "Successfully deleted the record of the employee Id: " + id;
            }
            else if (row == 0) {
                return "Given employee is not found!";
            }
            else{
                return "Deleting employee is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Deleting employee is unsuccessful! Reason: "+ e.getMessage();
        }
    }


}
