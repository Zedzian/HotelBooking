package mat.hotel.Service;

import mat.hotel.DAO.ReservedRoomsDAO;
import mat.hotel.Model.ReservedRooms;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by m.zedzian on 03-06-2017.
 */
public class ReservedRoomsService {
    
    @Autowired
    private ReservedRoomsDAO reservedRoomsDAO;

    public void addEntity(ReservedRooms reservedRooms) throws Exception {
        reservedRoomsDAO.create(reservedRooms);
    }

    public ReservedRooms getEntityById(Long id) throws Exception {
        return reservedRoomsDAO.getEntityById(id);
    }

    public void update(ReservedRooms reservedRooms) throws Exception {
        reservedRoomsDAO.update(reservedRooms);
    }

    public void delete(Long id) throws Exception {
        reservedRoomsDAO.delete(id);
    }
}