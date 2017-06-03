package mat.hotel.DAO;

import mat.hotel.Model.ReservedRooms;
import mat.hotel.Model.Room;
import mat.hotel.Util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class RoomDAO {
    private Session session = null;
    private Transaction transaction = null;

    public void create(Room room) {
        session = SessionUtil.getSession();
        transaction = session.getTransaction();
        session.save(room);
        if (!transaction.wasCommitted())
            transaction.commit();
        session.close();
    }

    public Room getEntityById(Long id) throws Exception {
        session = SessionUtil.getSession();
        Room room = (Room) session.get(Room.class, new Long(id));
        transaction = session.getTransaction();
        session.beginTransaction();
        if (!transaction.wasCommitted())
            transaction.commit();
        return room;
    }

    public void update(Room updateEntity) {
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
        Room room = (Room) session.load(Room.class, new Long(id));
        session.delete(room);
        if (!transaction.wasCommitted())
            transaction.commit();
    }

    public List<ReservedRooms> reservedRoomsList() {
        session = SessionUtil.getSession();
        List<ReservedRooms> reservedRoomsList = session.createQuery("from reservedRooms").list();
        return reservedRoomsList;
    }
}
