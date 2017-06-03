package mat.hotel.Controller;

import mat.hotel.Model.Visitor;
import mat.hotel.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by m.zedzian on 03-06-2017.
 */
public class VisitorController {
    @Autowired
    private VisitorService visitorServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Visitor createVisitor(@RequestBody Visitor visitor) {
        try {
            visitorServices.addEntity(visitor);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return visitor;
    }

    @RequestMapping(value = "/retrieve/{id}", produces = "application/json", method = RequestMethod.GET)
    public @ResponseBody
    Visitor getVisitor(@PathVariable("id") Long id) {
        Visitor visitor = null;
        try {
            visitor = visitorServices.getEntityById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return visitor;
    }

    @RequestMapping(value = "/update", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    Visitor updateAuto(@RequestBody Visitor visitor) {
        try {
            visitorServices.update(visitor);
        } catch (Exception e) {
            e.printStackTrace();
            return visitor;
        }
        return visitor;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVisitor(@PathVariable("id") Long id) {
        try {
            visitorServices.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
