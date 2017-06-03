package mat.hotel.DAO;

import mat.hotel.Model.Reservation;
import mat.hotel.Model.Visitor;
import mat.hotel.Util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class VisitorDAO {

    private Session session = null;
    private Transaction transaction = null;

    public void create(Visitor visitor) {
        session = SessionUtil.getSession();
        transaction = session.getTransaction();
        session.save(visitor);
        if (!transaction.wasCommitted())
            transaction.commit();
        session.close();
    }

    public Visitor getEntityById(Long id) throws Exception {
        session = SessionUtil.getSession();
        Visitor visitor = (Visitor) session.get(Visitor.class, new Long(id));
        transaction = session.getTransaction();
        session.beginTransaction();
        if (!transaction.wasCommitted())
            transaction.commit();
        return visitor;
    }

    public void update(Visitor updateEntity) {
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
        Visitor visitor = (Visitor) session.load(Visitor.class, new Long(id));
        session.delete(visitor);
        if (!transaction.wasCommitted())
            transaction.commit();
    }

    public List<Reservation> reservationList() {
        session = SessionUtil.getSession();
        List<Reservation> reservationList = session.createQuery("from Reservation").list();
        return reservationList;
    }
}
