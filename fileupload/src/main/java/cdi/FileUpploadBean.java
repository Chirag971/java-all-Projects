/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.servlet.http.Part;

/**
 *
 * @author SHYAM
 */
@Named(value = "fileUpploadBean")
@SessionScoped
public class FileUpploadBean implements Serializable {

   private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String uploadFile() {
       if (file != null) {
            try {
                String fileName = file.getSubmittedFileName();

                // Specify the directory where you want to store the files
                String uploadDirectory = "F:\\Project Practice\\fileupload\\src\\main\\webapp\\images";
                File uploadDir = new File(uploadDirectory);

                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);

                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = file.getInputStream();
                     FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                // You can use standard Java I/O operations to handle the file.
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }

        return "Success.xhtml"; // Navigate to a success page
    }
    
}
