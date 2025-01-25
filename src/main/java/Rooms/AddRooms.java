package Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRooms {

    String roomId;
    int roomNo;
    int capacity;
    int availableRoom;

    public AddRooms(String roomId, int roomNo, int capacity, int availableRoom) throws SQLException {
        this.roomId = roomId;
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.availableRoom = availableRoom;
    }


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableRoom() {
        return availableRoom;
    }

    public void setAvailableRoom(int availableRoom) {
        this.availableRoom = availableRoom;
    }

    public String addHostel(String id, int capacity, int noOfRoom,int available) {
        String sql = "INSERT INTO hostel (hosId,name,hosNoOfRoom )VALUES (?,?,?)";
        Connection conn;
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);) {

            preparedStatement.setString(1, id);
            preparedStatement.setInt(2, capacity);
            preparedStatement.setInt(3, noOfRoom);
            preparedStatement.setInt(3, available);

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
        }