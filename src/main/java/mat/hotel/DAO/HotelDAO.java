package mat.hotel.DAO;

import mat.hotel.Model.Hotel;
import mat.hotel.Model.Room;
import mat.hotel.Util.SessionUtil;
import org.apache.catalina.manager.util.SessionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */

@Component
public class HotelDAO {

    private Session session = null;
    private Transaction transaction = null;

    public void create(Hotel hotel) {
        session = SessionUtil.getSession();
        transaction = session.getTransaction();
        session.save(hotel);
        if (!transaction.wasCommitted())
            transaction.commit();
        session.close();
    }

    public Hotel getEntityById(Long id) throws Exception {
        session = SessionUtil.getSession();
        Hotel hotel = (Hotel) session.get(Hotel.class, new Long(id));
        transaction = session.getTransaction();
        session.beginTransaction();
        if (!transaction.wasCommitted())
            transaction.commit();
        return hotel;
    }

    public void update(Hotel updateEntity) {
        session = SessionUtil.getSession();
        transaction = session.getTransaction();
        session.update(updateEntity);
        if (!transaction.wasCommitted())
            transaction.commit();
        session.close();
    }

    public void delete(Long id) {
        session = SessionUtil.getSession();
        transaction = session.beginTransaction();
        Hotel hotel = (Hotel) session.load(Hotel.class, new Long(id));
        session.delete(hotel);
        if (!transaction.wasCommitted())
            transaction.commit();
    }

    public List<Room> roomList() {
        session = SessionUtil.getSession();
        List<Room> roomList = session.createQuery("from Room").list();
        return roomList;
    }
}
