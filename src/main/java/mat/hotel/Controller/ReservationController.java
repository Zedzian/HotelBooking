package mat.hotel.Controller;

import mat.hotel.Model.Reservation;
import mat.hotel.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class ReservationController {
    @Autowired
    private ReservationService reservationServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Reservation createReservation(@RequestBody Reservation reservation) {
        try {
            reservationServices.addEntity(reservation);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return reservation;
    }

    @RequestMapping(value = "/retrieve/{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    Reservation getReservation(@PathVariable("id") Long id) {
        Reservation reservation = null;
        try {
            reservation = reservationServices.getEntityById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return reservation;
    }

    @RequestMapping(value = "/update", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    Reservation updateAuto(@RequestBody Reservation reservation) {
        try {
            reservationServices.update(reservation);
        } catch (Exception e) {
            e.printStackTrace();
            return reservation;
        }
        return reservation;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id) {
        try {
            reservationServices.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

