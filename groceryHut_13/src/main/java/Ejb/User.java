package Ejb;

import Entity.Addressmaster;
import Entity.Cart;
import Entity.Getintouch;
import Entity.Managecategory;
import Entity.Manageproduct;
import Entity.Orderdeatails;
import Entity.Ordermaster;
import Entity.Payment;
import Entity.Productreview;
import Entity.Registermaster;
import Entity.Rolemaster;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

@Stateless
public class User implements UserLocal {
    
    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare pbc;
    
    @PersistenceContext(unitName = "GroceryhutPU")
    EntityManager em;
    
    @Override
    public boolean Register(String Name, String email, String password, String username) {
        try {
            
            if (Name == null || email == null || password == null || username == null) {
                throw new IllegalArgumentException("Please Enter All Filed");
            } else {
                
                Rolemaster ro = em.find(Rolemaster.class, username);
                if (ro == null) {
                    ro = new Rolemaster();
                    ro.setUserName(username);
                    ro.setRole("User");
                    em.persist(ro);
                }
                //Hashing password
                pb = new Pbkdf2PasswordHashImpl();
                pbc = new PasswordHashCompare();
                
                String enc = pb.generate(password.toCharArray());
                // Create Registermaster
                Registermaster user = new Registermaster();
                user.setName(Name);
                user.setEmail(email);
                user.setPassword(enc);
                user.setUserName(ro);

                // Update relationships
                Collection<Registermaster> reg = ro.getRegistermasterCollection();
                reg.add(user);
                ro.setRegistermasterCollection(reg);

                // Persist entities
                em.persist(user);
                em.merge(ro);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    @Override
    public Integer getIdByusername(String Username) {
        String jpql = "SELECT r.regId FROM Registermaster r JOIN r.userName u WHERE u.userName = :username";
        
        TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
        query.setParameter("username", Username);
        
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            // Handle exceptions (e.g., NoResultException if no user found)
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean resetpass(Integer regId, String username, String password) {
        Rolemaster ro = em.find(Rolemaster.class, username);
        Collection<Registermaster> reg = ro.getRegistermasterCollection();
        Registermaster user = em.find(Registermaster.class, regId);
        if (reg.contains(user)) {
            //Hashing password
            pb = new Pbkdf2PasswordHashImpl();
            pbc = new PasswordHashCompare();
            
            String enc = pb.generate(password.toCharArray());
            user.setPassword(enc);
            em.merge(user);
        }
        return true;
    }
    
    @Override
    public boolean Update(Integer regId, String Name, String email, String username) {
        Rolemaster ro = em.find(Rolemaster.class, username);
        Collection<Registermaster> reg = ro.getRegistermasterCollection();
        Registermaster user = em.find(Registermaster.class, regId);
        if (reg.contains(user)) {
            user.setName(Name);
            user.setEmail(email);
            em.merge(user);
        }
        return true;
    }
    
    @Override
    public boolean inReview(String review, Integer regId, Integer pId) {
        try {
            if (review == null || regId == null || pId == null) {
                throw new IllegalArgumentException("Please Enter All Field");
            } else {
                Date date = new Date();
                Manageproduct p = em.find(Manageproduct.class, pId);
                Collection<Productreview> preview = p.getProductreviewCollection();
                Registermaster reg = em.find(Registermaster.class, regId);
                Collection<Productreview> rreview = reg.getProductreviewCollection();
                Productreview pre = new Productreview();
                pre.setReview(review);
                pre.setRegId(reg);
                pre.setPId(p);
                pre.setDate(date);
                preview.add(pre);
                rreview.add(pre);
                p.setProductreviewCollection(preview);
                reg.setProductreviewCollection(rreview);
                em.persist(pre);
                em.merge(p);
                em.merge(reg);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Collection<Productreview> getByPid(Integer pId) {
        Manageproduct p = em.find(Manageproduct.class, pId);
        Collection<Productreview> review = p.getProductreviewCollection();
        return review;
    }
    
    @Override
    public Collection<Manageproduct> getallProduct() {
        Collection<Manageproduct> p = em.createNamedQuery("Manageproduct.findAll").getResultList();
        return p;
    }
    
    @Override
    public Manageproduct getById(Integer pid) {
        Manageproduct p = em.find(Manageproduct.class, pid);
        return p;
    }
    
    @Override
    public boolean addPayment(Integer oId, Integer regId, String paymentMode, String upiId, Integer amt) {
        try {
            if (oId == null || regId == null || amt == null) {
                throw new IllegalArgumentException("Please Enter All Field");
            } else {
                Ordermaster o = em.find(Ordermaster.class, oId);
                Collection<Payment> order = o.getPaymentCollection();
                Registermaster r = em.find(Registermaster.class, regId);
                Collection<Payment> uPayment = r.getPaymentCollection();
                Payment p = new Payment();
                p.setPaymentMode(paymentMode);
                p.setUpiId(upiId);
                p.setAmt(amt);
                p.setOId(o);
                p.setRegId(r);
                order.add(p);
                uPayment.add(p);
                o.setPaymentCollection(order);
                r.setPaymentCollection(uPayment);
                em.persist(p);
                em.merge(o);
                em.merge(r);
                
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    @Override
    public Collection<Payment> getPayByUser(Integer regId) {
        Registermaster r = em.find(Registermaster.class, regId);
        Collection<Payment> p = r.getPaymentCollection();
        return p;
    }
    
    @Override
    public boolean addgit(Integer regId, String que) {
        try {
            if (regId == null || que == null) {
                throw new IllegalArgumentException("Please Enter All field");
            } else {
                
                Registermaster r = em.find(Registermaster.class, regId);
                Collection<Getintouch> git = r.getGetintouchCollection();
                Getintouch g = new Getintouch();
                g.setQuery(que);
                g.setRegId(r);
                git.add(g);
                r.setGetintouchCollection(git);
                em.persist(g);
                em.merge(r);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    @Override
    public Collection<Getintouch> getgitByUser(Integer regId) {
        Registermaster r = em.find(Registermaster.class, regId);
        Collection<Getintouch> get = r.getGetintouchCollection();
        return get;
    }
    
    @Override
    public boolean inAddress(Integer phoneNo, Integer atlPhoneNo, String address, String altAddress, Integer regId) {
        try {
            if (phoneNo == null || address == null) {
                throw new IllegalArgumentException("Please Enter all Field");
            } else {
                Registermaster r = em.find(Registermaster.class, regId);
                Collection<Addressmaster> addr = r.getAddressmasterCollection();
                Addressmaster ad = new Addressmaster();
                ad.setPhoneNo(phoneNo);
                ad.setAtlPhoneNo(atlPhoneNo);
                ad.setAddress(address);
                ad.setAltAddress(altAddress);
                ad.setRegId(r);
                addr.add(ad);
                r.setAddressmasterCollection(addr);
                em.persist(ad);
                em.merge(r);
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    @Override
    public boolean delAddress(Integer addId, Integer regId) {
        try {
            if (addId == null || regId == null) {
                throw new IllegalArgumentException("Please Enter id");
            }
            Addressmaster ad = em.find(Addressmaster.class, addId);
            Registermaster r = em.find(Registermaster.class, regId);
            Collection<Addressmaster> addr = r.getAddressmasterCollection();
            if (addr.contains(ad)) {
                em.remove(ad);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean upAddress(Integer addId, Integer phoneNo, Integer altPhoneNo, String address, String altAddress, Integer regId) {
        try {
            if (addId == null || phoneNo == null || address == null) {
                throw new IllegalArgumentException("Please Enter all Field");
            } else {
                Addressmaster ad = em.find(Addressmaster.class, addId);
                Registermaster r = em.find(Registermaster.class, regId);
                Collection<Addressmaster> addr = r.getAddressmasterCollection();
                if (addr.contains(ad)) {
                    ad.setPhoneNo(phoneNo);
                    ad.setAtlPhoneNo(altPhoneNo);
                    ad.setAddress(address);
                    ad.setAltAddress(altAddress);
                    em.merge(ad);
                }
            }
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Collection<Addressmaster> getByUid(Integer regId) {
        
        Registermaster r = em.find(Registermaster.class, regId);
        Collection<Addressmaster> addr = r.getAddressmasterCollection();
        return addr;
        
    }
    
    @Override
    public boolean addProductToCart(Integer regId, Integer pId, Integer quantity) {
        try {
            Manageproduct pro = em.find(Manageproduct.class, pId);
            Registermaster reg = em.find(Registermaster.class, regId);
            
            if (pro != null && pro.getStock() >= quantity && reg != null) {
                Cart cart = new Cart();
                cart.setPId(pro);
                cart.setRegId(reg);
                cart.setQuantity(quantity);
                cart.setPrice((int) (quantity * pro.getTotalDiscount()));
                em.persist(cart);
                
            } else {
                System.err.println("Eather Email,Productid or Quantity is null");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean removeProductFromCart(Integer regId, Integer pId) {
        try {
            Registermaster user = em.find(Registermaster.class, regId);
            Manageproduct product = em.find(Manageproduct.class, pId);
            
            if (user == null) {
                throw new IllegalArgumentException("User Not Found!!!");
            } else {
                TypedQuery<Cart> query = em.createQuery(
                        "SELECT c FROM Cart c WHERE c.regId = :user AND c.pId = :productid", Cart.class);
                query.setParameter("user", user);
                query.setParameter("productid", product);
                
                List<Cart> carts = query.getResultList();
                
                if (!carts.isEmpty()) {
                    Cart productInCart = carts.get(0);
                    em.remove(productInCart);
                    System.out.println("Product removed from the user's cart.");
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Collection<Cart> viewCart(Integer regId) {
        try {
            if (regId == null) {
                throw new IllegalArgumentException("Invalid ID!!!");
            }
            
            Registermaster registermaster = em.find(Registermaster.class, regId);
            if (registermaster == null) {
                throw new IllegalArgumentException("Registermaster with ID " + regId + " not found!");
            }
            
            TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c WHERE c.regId = :registermaster", Cart.class);
            query.setParameter("registermaster", registermaster);
            Collection<Cart> result = query.getResultList();
            
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Collection<Manageproduct> getallProductByCat(Integer cid) {
        Managecategory cat = em.find(Managecategory.class, cid);
        Collection<Manageproduct> pro = cat.getManageproductCollection();
        return pro;
    }
    
    @Override
    public boolean placeOrder(Integer regId, Integer addid) {
        try {
            Registermaster registermaster = em.find(Registermaster.class, regId);
            TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c WHERE c.regId = :registermaster", Cart.class);
            query.setParameter("registermaster", registermaster);
            Collection<Cart> cartItems = query.getResultList();
            double totalAmount = 0;
            System.out.println("after get carts");
            
            if (!cartItems.isEmpty()) {
                Date odate = new Date();
                Addressmaster ad = em.find(Addressmaster.class, addid);
               
                Ordermaster order = new Ordermaster();
                order.setRegId(registermaster);
                
                for (Cart cartItem : cartItems) {
                    Manageproduct product = em.find(Manageproduct.class, cartItem.getPId().getPId());
                    System.out.println(cartItem.getPId());
                    if (product != null) {
                        double productTotal = cartItem.getPrice() * cartItem.getQuantity();
                        int stock = product.getStock() - cartItem.getQuantity();
                        product.setStock(stock);
                        Orderdeatails orderDetails = new Orderdeatails();
                        orderDetails.setRegId(registermaster);
                        orderDetails.setPId(product);
                        orderDetails.setPName(cartItem.getPId().getPName());
                        orderDetails.setPQty(cartItem.getQuantity());
                        orderDetails.setAmt(productTotal);
                        orderDetails.setOdate(odate);
                        orderDetails.setAddid(ad);
                        // Calculate tax and gst amounts for the current product
                        double taxAmount = productTotal * (product.getTax() / 100);
                        double gstAmount = productTotal * (product.getGst() / 100);
                        double sgstAmount = productTotal * (product.getSgst() / 100);
                        orderDetails.setTaxAmt(taxAmount);
                        orderDetails.setGstAmt(gstAmount);
                        orderDetails.setSgstAmt(sgstAmount);
                        // Update the totalAmount with tax and gst for each product
                        totalAmount += productTotal + taxAmount + gstAmount + gstAmount;
                        
                        orderDetails.setOId(order);
//                        removeProductFromCart(registermaster.getRegId(), product.getPId());

                        em.persist(orderDetails);
                        em.merge(product);
                    } else {
                        System.out.println("Product null");
                    }
                }
                
                order.setGrandTotal(totalAmount);
                
                em.persist(order);
            } else {
                System.out.println("Cart is getting Null!!!");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    @Override
    public Collection<Orderdeatails> getOrderDetailsById(Integer regId) {
        Registermaster reg = em.find(Registermaster.class, regId);
        Collection<Orderdeatails> or = reg.getOrderdeatailsCollection();
        return or;
    }
    
   
    
}
