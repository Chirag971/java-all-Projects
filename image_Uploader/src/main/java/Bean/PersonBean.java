/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Bean;

import Client.UploadClient;
import Entity.Person;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@Named(value = "personBean")
@RequestScoped
public class PersonBean {

    Response rs;
    UploadClient ul;
    Collection<Person> person;
    GenericType<Collection<Person>> gperson;
    private Person p = new Person();

    private String pname;

    private Part pimage;

    public PersonBean() {
        ul = new UploadClient();
        person = new ArrayList<>();
        gperson = new GenericType<Collection<Person>>() {
        };
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Part getPimage() {
        return pimage;
    }

    public void setPimage(Part pimage) {
        this.pimage = pimage;
    }

    public String savePerson() {
         if (pimage != null) {
            try {
                String fileName = pimage.getSubmittedFileName();

                // Specify the directory where you want to store the files
                String uploadDirectory = "E:\\JAVA\\image_Uploader\\src\\main\\webapp\\images";
                File uploadDir = new File(uploadDirectory);

                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);

                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = pimage.getInputStream();
                     FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                
                this.p.setPname(pname);
                this.p.setPimage(fileName);
                rs = ul.addPerson(p);
                if (rs != null) {
                    System.out.println("success"); 
                } else {
                    System.out.println("error");
                }
                // You can use standard Java I/O operations to handle the file.
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }
return "Person.xhtml";
    }
    
    public Collection<Person> getAllPerson(){
        rs = ul.getallperson(Response.class);
        person = rs.readEntity(gperson);
        return person;
    }
    
    public String delete(String id){
        ul.del(id);
        return "Person.xhtml";
    }
}
