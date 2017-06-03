package mat.hotel.DAO;

import mat.hotel.Model.ReservedRooms;
import mat.hotel.Model.ReservedRooms;
import mat.hotel.Util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class ReservedRoomsDAO {

    private Session session = null;
    private Transaction transaction = null;

    public void create(ReservedRooms reservedRooms) {
        session = SessionUtil.getSession();
        transaction = session.getTransaction();
        session.save(reservedRooms);
        if (!transaction.wasCommitted())
        transaction.commit();
        session.close();
    }

    public ReservedRooms getEntityById(Long id) throws Exception {
        session = SessionUtil.getSession();
        ReservedRooms reservedRooms = (ReservedRooms) session.get(ReservedRooms.class, new Long(id));
        transaction = session.getTransaction();
        session.beginTransaction();
        if (!transaction.wasCommitted())
        transaction.commit();
        return reservedRooms;
    }

    public void update(ReservedRooms updateEntity) {
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
        ReservedRooms reservedRooms = (ReservedRooms) session.load(ReservedRooms.class, new Long(id));
        session.delete(reservedRooms);
        if (!transaction.wasCommitted())
        transaction.commit();
    }
}
