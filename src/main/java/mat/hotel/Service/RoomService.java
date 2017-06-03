package mat.hotel.Service;

import mat.hotel.DAO.RoomDAO;
import mat.hotel.Model.Room;
import mat.hotel.Model.ReservedRooms;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class RoomService {
    @Autowired
    private RoomDAO roomDAO;

    public void addEntity(Room room) throws Exception {
        roomDAO.create(room);
    }

    public Room getEntityById(Long id) throws Exception {
        return roomDAO.getEntityById(id);
    }

    public void update(Room room) throws Exception {
        roomDAO.update(room);
    }

    public void delete(Long id) throws Exception {
        roomDAO.delete(id);
    }

    public List<ReservedRooms> reservedRoomsList() {
        return roomDAO.reservedRoomsList();
    }
}
