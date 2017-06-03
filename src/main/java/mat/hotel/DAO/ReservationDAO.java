package mat.hotel.DAO;

import mat.hotel.Model.Reservation;
import mat.hotel.Model.Reservation;
import mat.hotel.Model.ReservedRooms;
import mat.hotel.Util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class ReservationDAO {

    private Session session = null;
    private Transaction transaction = null;

    public  void create(Reservation reservation){
        session = SessionUtil.getSession();
        transaction = session.getTransaction();
        session.save(reservation);
        if (!transaction.wasCommitted())
            transaction.commit();
        session.close();
    }

    public Reservation getEntityById(Long id) throws Exception{
        session = SessionUtil.getSession();
        Reservation reservation = (Reservation) session.get(Reservation.class, new Long(id));
        transaction = session.getTransaction();
        session.beginTransaction();
        if (!transaction.wasCommitted())
            transaction.commit();
        return reservation;
    }

    public void update(Reservation updateEntity){
        session = SessionUtil.getSession();
        transaction = session.getTransaction();
        session.update(updateEntity);
        if (!transaction.wasCommitted())
            transaction.commit();
        session.close();
    }

    public void delete(Long id){
        session = SessionUtil.getSession();
        transaction = session.beginTransaction();
        Reservation reservation = (Reservation) session.load(Reservation.class, new Long(id));
        session.delete(reservation);
        if (!transaction.wasCommitted())
            transaction.commit();
    }

    public List<ReservedRooms> reservedRoomsList() {
        session = SessionUtil.getSession();
        List<ReservedRooms> reservedRoomsList = session.createQuery("from reservedRooms").list();
        return reservedRoomsList;
    }
}
