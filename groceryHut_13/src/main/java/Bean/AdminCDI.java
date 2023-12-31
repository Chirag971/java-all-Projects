/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Bean;

import Entity.Getintouch;
import Entity.Managebrand;
import Entity.Managecategory;
import Entity.Manageproduct;
import Entity.Orderdeatails;
import Entity.Registermaster;
import client.adminClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dell
 */
@Named(value = "adminCDI")
@RequestScoped
public class AdminCDI {

    Response rs;
    adminClient ad;

//    category
    GenericType<Collection<Managecategory>> gcategory;
    Managecategory cat = new Managecategory();
    String cname;
    Integer cid;
    Part cimage;
//    Brand
    private String bname;
    private Integer bid;
    GenericType<Collection<Managebrand>> gbrand;
    Managebrand brand = new Managebrand();
//Product
    String pname, description, dimage, pid;
    Integer unit, stock;
    Double ammount, discount, tax, gst, sgst, discountedprice, totaldiscount;
    Part pimage;
    Manageproduct prod = new Manageproduct();
    GenericType<Collection<Manageproduct>> gprod;
//    Orders

    GenericType<Collection<Orderdeatails>> gorder;
    
//    users
    Collection<Registermaster> user;
    GenericType<Collection<Registermaster>> guser;

//    getintouch
    GenericType<Collection<Getintouch>> ggit;
    Getintouch gt = new Getintouch();
    String response,getid,regid;
    
    public AdminCDI() {
        ad = new adminClient();
        gcategory = new GenericType<Collection<Managecategory>>() {
        };
        gbrand = new GenericType<Collection<Managebrand>>() {
        };
        gprod = new GenericType<Collection<Manageproduct>>() {
        };
        gorder = new GenericType<Collection<Orderdeatails>>() {
        };

        user = new ArrayList<>();
        guser = new GenericType<Collection<Registermaster>>() {
        };
        
        ggit = new GenericType<Collection<Getintouch>>() {
        };

    }

//    category ----------------------------------------
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Part getCimage() {
        return cimage;
    }

    public void setCimage(Part cimage) {
        this.cimage = cimage;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Managecategory getCat() {
        return cat;
    }

    public void setCat(Managecategory cat) {
        this.cat = cat;
    }

    public void emptyCat() {
        this.cname = "";
        this.cimage = null;
    }

    public Collection<Managecategory> getAllCategory() {
        return ad.getallcategory(Response.class).readEntity(gcategory);
    }

    public void deleteCat(String CId) {

        rs = ad.delcat(CId);
        if (rs != null) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
// return "Categoy.jsf?faces-redirect=true";
    }

    public void insertCat() {
        if (cimage != null) {
            try {
                String fileName = cimage.getSubmittedFileName();
                // Specify the directory where you want to store the files
                String uploadDirectory = "E:\\JAVA\\groceryHut_13\\src\\main\\webapp\\images\\category";
                File uploadDir = new File(uploadDirectory);
                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);
                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = cimage.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                this.cat.setCName(cname);
                this.cat.setCImage(fileName);
                rs = ad.incat(cat);

                emptyCat();
                if (rs != null) {
                    System.out.println("success");
                } else {
                    System.out.println("error");
                }
                // You can use standard Java I/O operations to handle the file.
            } catch (IOException | ClientErrorException e) {
            }
        } else {
            System.out.println("File is null");
        }
        System.out.println("success");
    }

    public String getByID(String id) {
        rs = ad.getbyId(Response.class, id);
        GenericType<Managecategory> cat = new GenericType<Managecategory>() {
        };
        Managecategory c = rs.readEntity(cat);
        this.setCid(Integer.parseInt(id));
        this.setCname(c.getCName());
        return "UpdateCat.jsf";
    }

    public String UpdateC(String id) {
        System.out.println(id);
        this.cat.setCName(cname);
        System.out.println(cat.getCName());
        rs = ad.upcat(this.cat, id);
        if (rs != null) {
            return "Category.jsf?faces-redirect=true";
        } else {
            return "Something went wrong";
        }

    }

//    Brand-------------------------------
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Managebrand getBrand() {
        return brand;
    }

    public void setBrand(Managebrand brand) {
        this.brand = brand;
    }

    public void emptyBrand() {
        this.bname = "";
    }

    public void insertBrand() {
        this.brand.setBName(bname);
        rs = ad.addBrand(this.brand);
        this.emptyBrand();
    }

    public Collection<Managebrand> getAllBrands() {
        return ad.getallbrand(Response.class).readEntity(gbrand);
    }

    public void deleteBrand(String bId) {
        rs = ad.delbrand(bId);
        if (rs != null) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    public String getBByID(String id) {
        rs = ad.getbrandbyId(Response.class, id);
        GenericType<Managebrand> brand = new GenericType<Managebrand>() {
        };
        Managebrand b = rs.readEntity(brand);
        this.setBid(Integer.parseInt(id));
        this.setBname(b.getBName());
        return "UpdateBrand.jsf";
    }

    public String UpdateB(String id) {
        System.out.println(id);
        this.brand.setBName(bname);
        System.out.println(brand.getBName());
        rs = ad.upbrand(brand, id);
        if (rs != null) {
            return "Brand.jsf?faces-redirect=true";
        } else {
            return "Something went wrong";
        }

    }

//    Product 
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getGst() {
        return gst;
    }

    public void setGst(Double gst) {
        this.gst = gst;
    }

    public Double getSgst() {
        return sgst;
    }

    public void setSgst(Double sgst) {
        this.sgst = sgst;
    }

    public Manageproduct getProd() {
        return prod;
    }

    public void setProd(Manageproduct prod) {
        this.prod = prod;
    }

    public Part getPimage() {
        return pimage;
    }

    public void setPimage(Part pimage) {
        this.pimage = pimage;
    }

    public String getDimage() {
        return dimage;
    }

    public void setDimage(String dimage) {
        this.dimage = dimage;
    }

    public Double getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(Double discountedprice) {
        this.discountedprice = discountedprice;
    }

    public Double getTotaldiscount() {
        return totaldiscount;
    }

    public void setTotaldiscount(Double totaldiscount) {
        this.totaldiscount = totaldiscount;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void emptypro() {
        this.pname = null;
        this.pimage = null;
        this.ammount = null;
        this.description = null;
        this.unit = null;
        this.stock = null;
        this.discount = null;
        this.tax = null;
        this.gst = null;
        this.sgst = null;

    }

    public Collection<Manageproduct> getAllProduct() {
        return ad.getAllProducts(Response.class).readEntity(gprod);
    }

    public void insertporduct(String cid, String bid) {
        if (pimage != null) {
            try {
                String fileName = pimage.getSubmittedFileName();
                // Specify the directory where you want to store the files
                String uploadDirectory = "E:\\JAVA\\groceryHut_13\\src\\main\\webapp\\images\\product";
                File uploadDir = new File(uploadDirectory);
                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);
                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = pimage.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                this.prod.setPName(pname);
                this.prod.setPImage(fileName);
                this.prod.setAmmount(ammount);
                this.prod.setDescription(description);
                this.prod.setUnit(unit);
                this.prod.setStock(stock);
                this.prod.setDiscount(discount);
                this.prod.setTax(tax);
                this.prod.setGst(gst);
                this.prod.setSgst(sgst);

                rs = ad.addProduct(prod, cid, bid);
                this.emptypro();
                if (rs != null) {
                    System.out.println("success");
                } else {
                    System.out.println("error");
                }
                // You can use standard Java I/O operations to handle the file.
            } catch (IOException | ClientErrorException e) {
            }
        } else {
            System.out.println("File is null");
        }
        System.out.println("success");

    }

    public void deleteProduct(String pid, String catid, String bid) {
        rs = ad.deleteProduct(pid, catid, bid);
        if (rs != null) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    public void loaddetails() {
        GenericType<Manageproduct> pro = new GenericType<Manageproduct>() {
        };
        rs = ad.getProductById(Response.class, pid);

        if (rs != null && rs.getStatus() == 200) { // Check if the response is successful
            Manageproduct p = rs.readEntity(pro);

            if (p != null) {
                this.setPname(p.getPName());
                this.setDimage(p.getPImage());
                this.setDescription(p.getDescription());
                this.setAmmount(p.getAmmount());
                this.setDiscount(p.getDiscount());
                this.setDiscountedprice(p.getDiscountedPrice());
                this.setCname(p.getCId().getCName());
                this.setBname(p.getBId().getBName());
                this.setUnit(p.getUnit());
                this.setStock(p.getStock());
                this.setTotaldiscount(p.getTotalDiscount());
            } else {
                // Handle the case when the response does not contain a valid Manageproduct object
                System.out.println("Error: Invalid response data");
            }
        } else {
            // Handle the case when the response is not successful
            System.out.println("Error: Unable to retrieve product details");
        }
    }

    public Collection<Orderdeatails> getAllOrder() {
        return ad.getAllOrders(Response.class).readEntity(gorder);
    }

    public Collection<Registermaster> getAllUser() {
        rs = ad.getAllUser(Response.class);
        user = rs.readEntity(guser);
        return user;
    }

    public String getByIdPro(String id) {
        rs = ad.getProductById(Response.class, id);
        GenericType<Manageproduct> pro = new GenericType<Manageproduct>() {
        };
        Manageproduct p = rs.readEntity(pro);
        this.setPid(p.getPId().toString());
        this.setPname(p.getPName());
        this.setAmmount(p.getAmmount());
        this.setDescription(p.getDescription());
        this.setUnit(p.getUnit());
        this.setStock(p.getStock());
        this.setDiscount(p.getDiscount());
        this.setTax(p.getTax());
        this.setGst(p.getGst());
        this.setSgst(p.getSgst());
        this.setCid(p.getCId().getCId());
        this.setBid(p.getBId().getBId());

        return "UpdateProduct.jsf";
    }

    public String UpProduct(String id, String cid, String bid) {
        this.prod.setPName(pname);
        this.prod.setAmmount(ammount);
        this.prod.setDescription(description);
        this.prod.setUnit(unit);
        this.prod.setStock(stock);
        this.prod.setDiscount(discount);
        this.prod.setTax(tax);
        this.prod.setGst(gst);
        this.prod.setSgst(sgst);

        rs = ad.updateProduct(prod, id, cid, bid);
        if (rs != null) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        return "Product.jsf?faces-redirect=true";
    }
    
    
//    git

    public Getintouch getGt() {
        return gt;
    }

    public void setGt(Getintouch gt) {
        this.gt = gt;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getGetid() {
        return getid;
    }

    public void setGetid(String getid) {
        this.getid = getid;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }
    
    
    
    public Collection<Getintouch> getAllgit(){
        return ad.getAllQueries(Response.class).readEntity(ggit);
    }
    
  public String ResponseGit(){
      this.gt.setResponse(response);
      System.out.println(getid);
      System.out.println(regid);
      System.out.println(gt.getResponse());
        rs = ad.respondToQuery(gt, getid, regid);
        if (rs != null) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        return "GetInTouch.jsf?faces-redirect=true";
  }
    
    
}
