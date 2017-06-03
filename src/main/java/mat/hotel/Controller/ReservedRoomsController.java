package mat.hotel.Controller;

import mat.hotel.Model.ReservedRooms;
import mat.hotel.Service.ReservedRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class ReservedRoomsController {
    @Autowired
    private ReservedRoomsService reservedRoomsServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ReservedRooms createReservedRooms(@RequestBody ReservedRooms reservedRooms) {
        try {
            reservedRoomsServices.addEntity(reservedRooms);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return reservedRooms;
    }

    @RequestMapping(value = "/retrieve/{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    ReservedRooms getReservedRooms(@PathVariable("id") Long id) {
        ReservedRooms reservedRooms = null;
        try {
            reservedRooms = reservedRoomsServices.getEntityById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return reservedRooms;
    }

    @RequestMapping(value = "/update", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    ReservedRooms updateAuto(@RequestBody ReservedRooms reservedRooms) {
        try {
            reservedRoomsServices.update(reservedRooms);
        } catch (Exception e) {
            e.printStackTrace();
            return reservedRooms;
        }
        return reservedRooms;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservedRooms(@PathVariable("id") Long id) {
        try {
            reservedRoomsServices.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
