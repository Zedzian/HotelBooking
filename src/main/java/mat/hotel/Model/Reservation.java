package mat.hotel.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */
@Entity
public class Reservation  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Date checkInDate;
    private Date checkOutDate;
    private Float price;
    private int adults;
    private int children;
    private int rooms;

    @ManyToOne
    @JoinColumn(name = "VISITOR_ID")
    @JsonBackReference(value = "visitor_id")
    private Visitor visitor;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("reservation_id")
    private List<ReservedRooms> reservedRooms = new ArrayList<>();

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public List<ReservedRooms> getReservedRooms() {
        return reservedRooms;
    }

    public void setReservedRooms(List<ReservedRooms> reservedRooms) {
        this.reservedRooms = reservedRooms;
    }
}
