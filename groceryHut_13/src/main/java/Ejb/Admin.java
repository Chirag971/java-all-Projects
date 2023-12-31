package Ejb;

import Entity.Getintouch;
import Entity.Managebrand;
import Entity.Managecategory;
import Entity.Manageproduct;
import Entity.Orderdeatails;
import Entity.Payment;
import Entity.Productreview;
import Entity.Registermaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Admin implements AdminLocal {

    @PersistenceContext(unitName = "GroceryhutPU")
    EntityManager em;

    @Override
    public Collection<Productreview> getallreview() {
        Collection<Productreview> pr = em.createNamedQuery("Productreview.findAll").getResultList();
        return pr;
    }

    @Override
    public Collection<Manageproduct> getallProduct() {
        Collection<Manageproduct> p = em.createNamedQuery("Manageproduct.findAll").getResultList();
        return p;
    }

    @Override
    public boolean inProduct(String pname, String pimage, Double amt, String desc, Integer unit, Integer stock, Double dis, Double tax, Double gst, Double sgst, Integer cid, Integer bid) {
        try {
            if (pname == null || pimage == null || amt == null || desc == null || desc == null || unit == null || stock == null || dis == null || cid == null || bid == null) {
                throw new IllegalArgumentException("Please Enter All Field");
            } else {

                double discountAmount = (dis / 100) * amt;
                double totalDiscoutPrice = amt - discountAmount;
                Managecategory c = em.find(Managecategory.class, cid);
                Collection<Manageproduct> productc = c.getManageproductCollection();
                Managebrand b = em.find(Managebrand.class, bid);
                Collection<Manageproduct> productb = b.getManageproductCollection();

                Manageproduct p = new Manageproduct();
                p.setPName(pname);
                p.setPImage(pimage);
                p.setAmmount(amt);
                p.setDescription(desc);
                p.setUnit(unit);
                p.setStock(stock);
                p.setDiscount(dis);
                p.setDiscountedPrice(discountAmount);
                p.setTax(tax);
                p.setGst(gst);
                p.setSgst(sgst);
                p.setTotalDiscount(totalDiscoutPrice);
                p.setCId(c);
                p.setBId(b);
                productc.add(p);
                productb.add(p);
                c.setManageproductCollection(productc);
                b.setManageproductCollection(productb);
                em.persist(p);
                em.merge(c);
                em.merge(b);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delProduct(Integer pid, Integer cid, Integer bid) {
        try {
            if (pid == null || cid == null || bid == null) {
                throw new IllegalArgumentException("Please Enter Brand Name and Image");
            } else {

                Manageproduct p = em.find(Manageproduct.class, pid);
                Managecategory c = em.find(Managecategory.class, cid);
                Collection<Manageproduct> productc = c.getManageproductCollection();
                Managebrand b = em.find(Managebrand.class, bid);
                Collection<Manageproduct> productb = b.getManageproductCollection();

                if (productc.contains(p) && productb.contains(p)) {
                    em.remove(p);
                }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean upProduct(Integer pid, String pname, Double amt, String desc, Integer unit, Integer stock, Double dis, Double tax, Double gst, Double sgst, Integer cid, Integer bid) {
        try {
            if (pid == null || pname == null || amt == null || desc == null || unit == null || stock == null || dis == null || cid == null || bid == null) {
                throw new IllegalArgumentException("Please Enter Brand Name and Image");
            } else {
                System.out.println(cid);
                System.out.println(bid);
                double discountAmount = (dis / 100) * amt;
                double totalDiscoutPrice = amt - discountAmount;
                Manageproduct p = em.find(Manageproduct.class, pid);
               
                    p.setPName(pname);
                    p.setAmmount(amt);
                    p.setDescription(desc);
                    p.setUnit(unit);
                    p.setStock(stock);
                    p.setDiscount(dis);
                    p.setDiscountedPrice(discountAmount);
                    p.setTax(tax);
                    p.setGst(gst);
                    p.setSgst(sgst);
                    p.setCId(em.find(Managecategory.class, cid));
                    p.setBId(em.find(Managebrand.class, bid));
                    p.setTotalDiscount(totalDiscoutPrice);
                    em.merge(p);
                
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Manageproduct getById(Integer pid) {
        Manageproduct p = em.find(Manageproduct.class, pid);
        return p;
    }

    @Override
    public Collection<Payment> getAllPayment() {
        Collection<Payment> p = em.createNamedQuery("Payment.findAll").getResultList();
        return p;
    }

    @Override
    public Collection<Getintouch> getall() {
        Collection<Getintouch> g = em.createNamedQuery("Getintouch.findAll").getResultList();
        return g;
    }

    @Override
    public boolean resgit(Integer getId, Integer regId, String reply) {
        try {
            if (getId == null || regId == null || reply == null) {
                throw new IllegalArgumentException("Please Enter All Field");

            } else {
                Getintouch g = em.find(Getintouch.class, getId);
                Registermaster r = em.find(Registermaster.class, regId);
                Collection<Getintouch> git = r.getGetintouchCollection();
                if (git.contains(g)) {
                    g.setResponse(reply);
                    em.merge(g);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addCategoryies(String cName, String cImage) {
        try {
            if (cName == null) {
                throw new IllegalArgumentException("Please Enter Category Name");
            }
            Managecategory cat = new Managecategory();
            cat.setCName(cName);
            cat.setCImage(cImage);
            em.persist(cat);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Integer cid) {
        try {
            if (cid == null) {
                throw new IllegalArgumentException("Please Enter Category ID");
            } else {
                Managecategory cat = em.find(Managecategory.class, cid);
                em.remove(cat);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean UpdateCategory(Integer cid, String cName) {
        try {
            if (cid == null) {
                throw new IllegalArgumentException("Please Enter Category ID and Category Name");
            } else {
                Managecategory cat = em.find(Managecategory.class, cid);
                if (cat == null) {
                    System.out.println("Category not found with ID: " + cid);
                    return false;
                }
                cat.setCName(cName);
                em.merge(cat);

            }

            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Collection<Managecategory> getallCategory() {
        Collection<Managecategory> cat = em.createNamedQuery("Managecategory.findAll").getResultList();
        return cat;
    }

    @Override
    public Managecategory getCatByid(Integer cid) {
        Managecategory cat = em.find(Managecategory.class, cid);
        return cat;
    }

    @Override
    public Collection<Managebrand> getallBrand() {
        Collection<Managebrand> b = em.createNamedQuery("Managebrand.findAll").getResultList();
        return b;
    }

    @Override
    public boolean inBrand(String bname) {
        try {
            if (bname == null) {
                throw new IllegalArgumentException("Please Enter Brand Name and Image");
            } else {

                Managebrand b = new Managebrand();
                b.setBName(bname);

                em.persist(b);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delBrand(Integer bid) {
        try {
            if (bid == null) {
                throw new IllegalArgumentException("Please Enter Brand ID");

            } else {
                Managebrand b = em.find(Managebrand.class, bid);
                em.remove(b);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean upBrand(Integer bid, String bname) {
        try {
            if (bid == null || bname == null) {
                throw new IllegalArgumentException("Please Enter Brand Name and Image");
            } else {
                Managebrand b = em.find(Managebrand.class, bid);
                b.setBName(bname);
                em.merge(b);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Managebrand getBById(Integer bid) {
        Managebrand b = em.find(Managebrand.class, bid);
        return b;
    }

    @Override
    public Collection<Orderdeatails> getAllOrders() {
        Collection<Orderdeatails> order = em.createNamedQuery("Orderdeatails.findAll").getResultList();
        return order;
    }

    @Override
    public Collection<Registermaster> getallUsers() {
        Collection<Registermaster> user = em.createNamedQuery("Registermaster.findAll").getResultList();
        return user;
    }

}
