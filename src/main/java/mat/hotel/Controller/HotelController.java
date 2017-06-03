package mat.hotel.Controller;

import mat.hotel.Model.Hotel;
import mat.hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by m.zedzian on 03-06-2017.
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Hotel createHotel(@RequestBody Hotel hotel) {
        try {
            hotelServices.addEntity(hotel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return hotel;
    }

    @RequestMapping(value = "/retrieve/{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody Hotel getHotel(@PathVariable("id") Long id) {
        Hotel hotel = null;
        try {
            hotel = hotelServices.getEntityById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return hotel;
    }

    @RequestMapping(value = "/update", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    Hotel updateAuto(@RequestBody Hotel hotel){
        try {
            hotelServices.update(hotel);
        } catch (Exception e) {
            e.printStackTrace();
            return hotel;
        }
        return hotel;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") Long id){
        try {
            hotelServices.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
