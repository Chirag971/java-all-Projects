package Ejb;

import Entity.Getintouch;
import Entity.Managebrand;
import Entity.Managecategory;
import Entity.Manageproduct;
import Entity.Orderdeatails;
import Entity.Ordermaster;
import Entity.Payment;
import Entity.Productreview;
import Entity.Registermaster;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface AdminLocal {

    Collection<Productreview> getallreview();

    Collection<Manageproduct> getallProduct();

    boolean inProduct(String pname, String pimage, Double amt, String desc, Integer unit, Integer stock, Double dis, Double tax, Double gst, Double sgst, Integer cid, Integer bid);

    boolean delProduct(Integer pid, Integer cid, Integer bid);

    boolean upProduct(Integer pid, String pname,  Double amt, String desc, Integer unit, Integer stock, Double dis, Double tax, Double gst, Double sgst,  Integer cid, Integer bid);

    Manageproduct getById(Integer pid);

    Collection<Payment> getAllPayment();

    Collection<Getintouch> getall();

    boolean resgit(Integer getId, Integer regId, String reply);

    boolean addCategoryies(String cName,String cImage);

    boolean deleteCategory(Integer cid);

    boolean UpdateCategory(Integer cid, String cName);

    Collection<Managecategory> getallCategory();

    Managecategory getCatByid(Integer cid);

    Collection<Managebrand> getallBrand();

    boolean inBrand(String bname);

    boolean delBrand(Integer bid);

    boolean upBrand(Integer bid, String bname);

    Managebrand getBById(Integer bid);

    Collection<Orderdeatails> getAllOrders();
    Collection<Registermaster> getallUsers();
}
