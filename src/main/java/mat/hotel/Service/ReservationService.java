package mat.hotel.Service;

import mat.hotel.DAO.ReservationDAO;
import mat.hotel.Model.Reservation;
import mat.hotel.Model.ReservedRooms;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    public void addEntity(Reservation reservation) throws Exception {
        reservationDAO.create(reservation);
    }

    public Reservation getEntityById(Long id) throws Exception {
        return reservationDAO.getEntityById(id);
    }

    public void update(Reservation reservation) throws Exception {
        reservationDAO.update(reservation);
    }

    public void delete(Long id) throws Exception {
        reservationDAO.delete(id);
    }

    public List<ReservedRooms> reservedRoomsList() {
        return reservationDAO.reservedRoomsList();
    }
}
