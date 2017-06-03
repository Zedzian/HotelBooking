package mat.hotel.Service;

import mat.hotel.DAO.HotelDAO;
import mat.hotel.Model.Hotel;
import mat.hotel.Model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
@Service
public class HotelService
{
    @Autowired
    private HotelDAO hotelDAO;
    public void addEntity(Hotel hotel) throws Exception {
        hotelDAO.create(hotel);
    }

    public Hotel getEntityById(Long id) throws Exception {
        return hotelDAO.getEntityById(id);
    }

    public void update(Hotel hotel) throws Exception{
        hotelDAO.update(hotel);
    }

    public void delete(Long id) throws Exception {
        hotelDAO.delete(id);
    }

    public List<Room> roomList() {
        return hotelDAO.roomList();
    }
}
