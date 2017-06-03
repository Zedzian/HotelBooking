package mat.hotel.Service;

import mat.hotel.DAO.VisitorDAO;
import mat.hotel.Model.Visitor;
import mat.hotel.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class VisitorService {

    @Autowired
    private VisitorDAO visitorDAO;
    public void addEntity(Visitor visitor) throws Exception {
        visitorDAO.create(visitor);
    }

    public Visitor getEntityById(Long id) throws Exception {
        return visitorDAO.getEntityById(id);
    }

    public void update(Visitor visitor) throws Exception{
        visitorDAO.update(visitor);
    }

    public void delete(Long id) throws Exception {
        visitorDAO.delete(id);
    }

    public List<Reservation> reservationList() {
        return visitorDAO.reservationList();
    }
}
