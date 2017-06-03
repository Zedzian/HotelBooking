package mat.hotel.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by m.zedzian on 03-06-2017.
 */

@Entity
public class ReservedRooms implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    @JsonBackReference(value = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID")
    @JsonBackReference(value = "reservation_id")
    private Reservation reservation;

    public ReservedRooms() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
