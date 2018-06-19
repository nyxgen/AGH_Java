package com.example.demo;


import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class PictureController {

    public static JSONObject getPictureData() throws IOException {
        Properties appProperties = new Properties();
        appProperties.load(new FileInputStream("E:\\Java\\Properties\\app.properties"));
        String masterPath = appProperties.getProperty("path");
        List<JSONObject> list = new ArrayList<JSONObject>();
        File tmp = new File(masterPath);
        File[] files = tmp.listFiles();
        String[] paths = tmp.list();
        int index  = 0;


        for(String path : paths)
        {
            if(path.contains(".png"))
            {
            File toLoad = new File(masterPath + path);
            JSONObject json = new JSONObject();
            json.put("Index", index);
            json.put("Name", toLoad.getName());
            BufferedImage image = ImageIO.read(toLoad);
            json.put("Resolution", Integer.toString(image.getWidth()) + "x" + Integer.toString(image.getHeight()));
            json.put("Size", toLoad.getTotalSpace());
            list.add(json);
            ++index;
          }
        }

        JSONObject picturesData = new JSONObject();
        picturesData.put("pictures", list);
        //  picturesData.put("paths", paths);

       return picturesData;
    }

    public static String setImage(ServletInputStream inputStream) throws IOException
    {
        Properties appProperties = new Properties();
        appProperties.load(new FileInputStream("E:\\Java\\Properties\\app.properties"));
        String masterPath = appProperties.getProperty("path");
        BufferedImage image = ImageIO.read(inputStream);
        if(image == null)
        {
            return "False";
        }
        String fileName = Long.toString(System.currentTimeMillis());
        File toSave = new File(masterPath + fileName +".png");
        ImageIO.write(image, "png", toSave);
        return fileName;
    }

    public static byte[] getImage(String id) throws IOException {
        Properties appProperties = new Properties();
        appProperties.load(new FileInputStream("E:\\Java\\Properties\\app.properties"));
        String masterPath = appProperties.getProperty("path");
        File toRead = new File( masterPath + id +".png");
        BufferedImage image = ImageIO.read(toRead);
        if(image == null)
        {
            return null; //! ERROR 404
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }


    public static boolean deleteImage(ServletInputStream inputStream, String id) throws IOException {
        Properties appProperties = new Properties();
        appProperties.load(new FileInputStream("E:\\Java\\Properties\\app.properties"));
        String masterPath = appProperties.getProperty("path");
        File toRead = new File( masterPath + id +".png");
        if(toRead.exists()) {
            toRead.delete();
            return true;
        }
        return false;
    }
}
