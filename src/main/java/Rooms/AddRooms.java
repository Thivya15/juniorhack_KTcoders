package Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRooms(String roomId, int roomNo, int capacity, int availableRoom, Connection conn) {

        String sql = "INSERT INTO employees (roomId,roomNo,capacity,availableRoom )VALUES (?,?,?,?)";
        try(
    private Connection conn;
    PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

        String roomId = null;
        int roomNo=null;
        int capacity = null;
        int availableRoom = null;
        preparedStatement.setString(1,roomId);
            preparedStatement.setInt(2,roomNo);
            preparedStatement.setInt(3,capacity);
            preparedStatement.setInt(4,availableRoom);

            int res = preparedStatement.executeUpdate(); // can use  preparedStatement.executeUpdate();

            if (res>0) {
                String id;
                return "Successfully added the record of the room Id: " + id;
            } else {
                return "Registering room is unsuccessful!";
            }
        }
        catch (SQLException e){
            return "Registering room is unsuccessful! Reason: "+ e.getMessage();
        }

    public AddRooms() throws SQLException {
    }
}



}
