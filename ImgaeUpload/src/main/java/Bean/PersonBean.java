/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Bean;

import Client.UploadClient;
import Entity.Person;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@Named(value = "personBean")
@RequestScoped
public class PersonBean {

    @Inject
    private ServletContext servletContext;
    Response rs;
    UploadClient ul;
    Collection<Person> person;
    GenericType<Collection<Person>> gperson;
    private Person p = new Person();

    private String pname, pimage;
    private Part file;

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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Collection<Person> getPerson() {
        rs = ul.getallperson(Response.class);
        person = rs.readEntity(gperson);
        return person;
    }
    public String insertp() {
        try (InputStream input = file.getInputStream()) {
            String fileName = file.getSubmittedFileName();
            String realPath = servletContext.getRealPath("/");
            String uploadDirectory = realPath + File.separator + "uploads";
            String filePath = uploadDirectory + File.separator + fileName;

            // Create the upload directory if it doesn't exist
            File directory = new File(uploadDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            Files.copy(input, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

            this.p.setPname(pname);
            this.p.setPimage(filePath);
            ul.addPerson(this.p);

        } catch (Exception e) {
            System.out.println(e);
        }
        return "Person.xhtml";
    }

    public boolean isImageAvailable() {
        return file != null && file.getContentType().startsWith("image");

    }

    public String getImageUrl() {
        if (isImageAvailable()) {
            String fileName = file.getSubmittedFileName();
            String relativePath = "uploads" + File.separator + fileName;
            return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/" + relativePath;
        }
        return "";
    }
}
