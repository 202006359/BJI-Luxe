package edu.comillas.icai.pat.ejemplopat.util;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UrlToBlob {
    public static void main(String[] args) {
        String imageUrl = "https://galagarcianovias.com/wp-content/uploads/2020/10/vestidodefiesta2020_4U133_AIRE_BARCELONA_FIESTA_2.jpg";

        try{
        
        URL url = new URL(imageUrl);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        byte[] photoBytes = outputStream.toByteArray();
        //byte[] photoBytes = readImage(imageUrl);



        String foto = bytesToHex(photoBytes);
        //System.out.println(foto);

        //saveToFile(foto,"ficheroHexFoto.txt");

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void saveToFile(String content, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("String saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readImage(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    

    
}










