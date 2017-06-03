package mat.hotel.Controller;

import mat.hotel.Model.Room;
import mat.hotel.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class RoomController {
    @Autowired
    private RoomService roomServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Room createRoom(@RequestBody Room room) {
        try {
            roomServices.addEntity(room);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return room;
    }

    @RequestMapping(value = "/retrieve/{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    Room getRoom(@PathVariable("id") Long id) {
        Room room = null;
        try {
            room = roomServices.getEntityById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return room;
    }

    @RequestMapping(value = "/update", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    Room updateAuto(@RequestBody Room room) {
        try {
            roomServices.update(room);
        } catch (Exception e) {
            e.printStackTrace();
            return room;
        }
        return room;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") Long id) {
        try {
            roomServices.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
