package mat.hotel.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by m.zedzian on 03-06-2017.
 */

@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    @JsonBackReference(value = "hotel_id")
    private Hotel hotel;

    private int adults;
    private int children;
    private float price;


    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference("room_id")
    private List<ReservedRooms> reservedRooms = new ArrayList<>();

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<ReservedRooms> getReservedRooms() {
        return reservedRooms;
    }

    public void setReservedRooms(List<ReservedRooms> reservedRooms) {
        this.reservedRooms = reservedRooms;
    }
}
