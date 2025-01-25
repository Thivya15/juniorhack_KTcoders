package Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public ViewRooms {
    String roomId;
    int roomNo;
    int capacity;
    int availableRoom;

    public String viewRomms(String id, Connection conn){
        String sql = "SELECT * FROM hmsystem WHERE roomId = ?;";
        StringBuilder result = new StringBuilder();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, roomId);
            ResultSet res = preparedStatement.executeQuery();

            if (res.next()) {
                String hosId = res.getString("hosId");
                String name = res.getString("name");
                int age = res.getInt("age");
                String department = res.getString("department");
                return String.format("ID: %s, roomNo: %d, NoOfRooms: %d,available : %d", roomId,capacity,availableRoom,roomNo);

            } else {
                return "hostel records are empty!";
            }
        } catch (SQLException e) {
            return "Retrieving hostel is unsuccessful! Reason: " + e.getSQLState();
        }
    }
}



