/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfBeans;

import Client.RestAdmin;
import Entity.Contactus;
import Entity.Ordermaster;
import Entity.Productcategory;
import Entity.Products;
import Entity.Userregister;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.constraints.Email;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author This PC
 */
@Named(value = "adminBean")
@RequestScoped
public class AdminBean {

    RestAdmin ra = new RestAdmin();
    Response rs;

    // Category
    String categoryName, categoryid;
    private List<Productcategory> categories;
    private Productcategory selectedCategory = new Productcategory();
    Collection<Productcategory> allcategories;
    GenericType<Collection<Productcategory>> gallcategories;

    //Products
    String productid, productName, price, quantity, tax, gst, description, image;
    private Part file;
    Collection<Products> allproducts;
    GenericType<Collection<Products>> gallproducts;

    //Users
    String email, username, password, phone, city, state, pincode;
    Collection<Userregister> allUsers;
    GenericType<Collection<Userregister>> gAllUsers;
    Userregister loggedUSer;

    //Orders
    Collection<Ordermaster> allorders;
    GenericType<Collection<Ordermaster>> gallOrders;
    String orderid, orderdate, status, totalamount;
    private boolean orderStatusChanged;
    private String newOrderStatus;

    //Contact
    String contactid, query;
    Collection<Contactus> allcontact;
    GenericType<Collection<Contactus>> gallcontact;

    public AdminBean() {
        ra = new RestAdmin();
        selectedCategory = new Productcategory();
        refreshCategories();
        allcategories = new ArrayList<>();
        gallcategories = new GenericType<Collection<Productcategory>>() {
        };

        allproducts = new ArrayList<>();
        gallproducts = new GenericType<Collection<Products>>() {
        };

        allUsers = new ArrayList<>();
        gAllUsers = new GenericType<Collection<Userregister>>() {
        };

        allorders = new ArrayList<>();
        gallOrders = new GenericType<Collection<Ordermaster>>() {
        };

        allcontact = new ArrayList<>();
        gallcontact = new GenericType<Collection<Contactus>>() {
        };
    }

    public void refreshCategories() {
        categories = ra.getAllProductcategorys(List.class);
    }

    public String addCategory() {
        try {
            ra.addCategory(categoryName);
            System.out.println("Category Added Successfully!");
            return "addCategory.jsf?faces-redirect=true";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error Occured";
        }
    }

    public String deleteCategory(int categoryid) {
        try {
            ra.deleteCategory(categoryid + "");
            System.out.println("Category deleted successfully!");
            return "addCategory.jsf?faces-redirect=true";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error Accured!!!";
        }
    }

    public String updateCategory(int categoryid, String catagoryName) {
        ra.updateCategory(categoryid + "", categoryName);
        return "addCategory.jsf?faces-redirect=true";
    }

    public Collection<Productcategory> getAllCategories() {
        rs = ra.getAllProductcategorys(Response.class);
        allcategories = rs.readEntity(gallcategories);
        return allcategories;
    }

    public String uploadImage() {
        String imageName = null;
        if (file != null) {
            try {
                String fileName = file.getSubmittedFileName();

                String uploadDirectory = "D:\\Project Netbeans\\HomeDecor_New\\src\\main\\webapp\\ProductImages";
                File uploadDir = new File(uploadDirectory);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File uploadedFile = new File(uploadDirectory, fileName);

                try (InputStream in = file.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                imageName = fileName;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }
        return imageName;
    }

    public String addProduct() {
        try {
            String imageName = uploadImage();
            System.out.println(imageName);

            ra.addProduct(productName, price, quantity, tax, gst, categoryid, description, imageName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Productform.jsf?faces-redirect=true";
    }

//    public Collection<Products> getAllProducts() {
//        rs = ra.getAllProducts(Response.class);
//        allproducts = rs.readEntity(gallproducts);
//        System.out.println(allproducts);
//        return allproducts;
//    }
    public String deleteProduct(int productid) {
        try {
            System.out.println(productid);
            ra.deleteProduct(productid + "");
            System.out.println("Product deleted successfully!");
            return "Products.jsf?faces-redirect=true";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error Accured!!!";
        }
    }

    public Collection<Userregister> getAllUsers() {
        rs = ra.getAllUserRegister(Response.class);
        allUsers = rs.readEntity(gAllUsers);
        return allUsers;
    }

    public Collection<Ordermaster> viewOrders() {
        rs = ra.viewAllOrders(Response.class);
        allorders = rs.readEntity(gallOrders);
        return allorders;
    }

    public void tryCall(){
        System.out.println("Calling");
    }
    public void updateOrderStatus(String newStatus, int orderId) {
        try {
            System.out.println("Order is: " + orderId);
            System.out.println("Order Status: " + newStatus);

            // Additional log for debugging
            System.out.println("Before update - Current Order Status in Database: " + ra.getOrderStatus(orderId + ""));

            // Update order status in your backend
            ra.updateOrderStatus(orderId + "", newStatus);

            // Additional log for debugging
            System.out.println("After update - Current Order Status in Database: " + ra.getOrderStatus(orderId + ""));

            System.out.println("Order Status Updated!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Collection<Contactus> allContactus() {
        rs = ra.getAllContactuses(Response.class);
        allcontact = rs.readEntity(gallcontact);
        return allcontact;
    }
    
    

//     public String checkEmail()
//    {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        ExternalContext externalContext = facesContext.getExternalContext();
//        HttpSession session = (HttpSession) externalContext.getSession(false);
//
//         username = (String) session.getAttribute("1");
//        if (username == null) {
//            // Redirect to the login page
//            try {
//                externalContext.redirect(externalContext.getRequestContextPath() + "/Login.jsf");
//            } catch (Exception e) {
//                e.printStackTrace(); // Handle the exception as needed
//            }
//            return "/Login.jsf?faces-redirect=true";
//        }
//         return "successOutcome";
//    }
//    
    
    public RestAdmin getRa() {
        return ra;
    }

    public void setRa(RestAdmin ra) {
        this.ra = ra;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public List<Productcategory> getCategories() {
        return categories;
    }

    public void setCategories(List<Productcategory> categories) {
        this.categories = categories;
    }

    public Productcategory getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Productcategory selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public Collection<Productcategory> getAllcategories() {
        return allcategories;
    }

    public void setAllcategories(Collection<Productcategory> allcategories) {
        this.allcategories = allcategories;
    }

    public GenericType<Collection<Productcategory>> getGallcategories() {
        return gallcategories;
    }

    public void setGallcategories(GenericType<Collection<Productcategory>> gallcategories) {
        this.gallcategories = gallcategories;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Collection<Products> getAllproducts() {
        rs = ra.getAllProducts(Response.class);
        allproducts = rs.readEntity(gallproducts);
        System.out.println(allproducts);
        return allproducts;
    }

    public void setAllproducts(Collection<Products> allproducts) {
        this.allproducts = allproducts;
    }

    public GenericType<Collection<Products>> getGallproducts() {
        return gallproducts;
    }

    public void setGallproducts(GenericType<Collection<Products>> gallproducts) {
        this.gallproducts = gallproducts;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public GenericType<Collection<Userregister>> getgAllUsers() {
        return gAllUsers;
    }

    public void setgAllUsers(GenericType<Collection<Userregister>> gAllUsers) {
        this.gAllUsers = gAllUsers;
    }

    public Collection<Ordermaster> getAllorders() {
        return allorders;
    }

    public void setAllorders(Collection<Ordermaster> allorders) {
        this.allorders = allorders;
    }

    public GenericType<Collection<Ordermaster>> getGallOrders() {
        return gallOrders;
    }

    public void setGallOrders(GenericType<Collection<Ordermaster>> gallOrders) {
        this.gallOrders = gallOrders;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getContactid() {
        return contactid;
    }

    public void setContactid(String contactid) {
        this.contactid = contactid;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Collection<Contactus> getAllcontact() {
        return allcontact;
    }

    public void setAllcontact(Collection<Contactus> allcontact) {
        this.allcontact = allcontact;
    }

    public GenericType<Collection<Contactus>> getGallcontact() {
        return gallcontact;
    }

    public void setGallcontact(GenericType<Collection<Contactus>> gallcontact) {
        this.gallcontact = gallcontact;
    }

    public boolean isOrderStatusChanged() {
        return orderStatusChanged;
    }

    public void setOrderStatusChanged(boolean orderStatusChanged) {
        this.orderStatusChanged = orderStatusChanged;
    }

    public String getNewOrderStatus() {
        return newOrderStatus;
    }

    public void setNewOrderStatus(String newOrderStatus) {
        this.newOrderStatus = newOrderStatus;
    }

    public Userregister getLoggedUSer() {
        return loggedUSer;
    }

    public void setLoggedUSer(Userregister loggedUSer) {
        this.loggedUSer = loggedUSer;
    }
    
    

}
