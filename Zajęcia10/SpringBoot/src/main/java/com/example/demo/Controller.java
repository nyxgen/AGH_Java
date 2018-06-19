package com.example.demo;

import net.minidev.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class Controller {

    @RequestMapping(value = "/hello", method = RequestMethod.GET) // maps our method to a specific path, in our case our API path will be ‘/hello’
    public String sayHello(@RequestParam(value = "name") String name) { //this API will have one request parameter which is ‘name’.
        return "Hello " + name + "!";
    }

    @RequestMapping(value = "/gallery/pictures", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) // convert you request param to path varriable
    public ResponseEntity<Object> getDimensions() throws IOException {
       JSONObject pictures =  PictureController.getPictureData();
        return new ResponseEntity<Object>(pictures, HttpStatus.OK);
    }

    @RequestMapping(value = "/gallery/pictures", method = RequestMethod.POST)
    public ResponseEntity<Object> addImage(HttpServletRequest requestEntity) throws Exception {
        JSONObject toReturn = new JSONObject();
        String msg = PictureController.setImage(requestEntity.getInputStream());
        if(msg == "False")
        {
            toReturn.put("Result", false);
        }
        else
        {
            toReturn.put("Result", true);
        }
        return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/gallery/pictures/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getCroppedImage(@PathVariable("id") String id) throws IOException {
        return new ResponseEntity<byte[]>(PictureController.getImage(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/gallery/pictures/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteImage(HttpServletRequest requestEntity, @PathVariable("id") String id) throws Exception {
        boolean isDeleted = PictureController.deleteImage(requestEntity.getInputStream(), id);
        JSONObject toReturn = new JSONObject();
        toReturn.put("Deleted ", isDeleted);
        return new ResponseEntity<Object>(toReturn, HttpStatus.OK);
    }


}
