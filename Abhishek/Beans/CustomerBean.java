/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Beans;

import Entity.Addressmaster;
import Entity.Cart;
import Entity.Contactus;
import Entity.Feedback;
import Entity.Groupmaster;
import Entity.Orderdetail;
import Entity.Ordermaster;
import Entity.Payment;
import Entity.Productcategory;
import Entity.Products;
import Entity.Userregister;
import java.sql.Timestamp;
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
public class CustomerBean implements CustomerBeanLocal {
    
     Pbkdf2PasswordHashImpl pb;
            PasswordHashCompare ph;

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

//    ======================================= Register Customer
    @Override

    // have to pass gid in paramiter
    public void registerCustomer(String email, String username, String password, int gid, int phone, String city, String state, int pincode) {
        try {
            Userregister newUser = new Userregister();
//            Groupmaster g = em.find(Groupmaster.class,gid);
            newUser.setEmail(email);
            newUser.setUsername(username);

            pb = new Pbkdf2PasswordHashImpl();
            ph = new PasswordHashCompare();
            String enc = pb.generate(password.toCharArray());
            newUser.setPassword(enc);

            System.out.println(gid);
            System.out.println("Before em.find");
            System.out.println("em: " + em); // Add this line for debugging
            Groupmaster g = em.find(Groupmaster.class, gid);
            System.out.println("After em.find");

            if (g != null) {
                newUser.setGroupid(g);
            } else {
                System.out.println("Group id getting null");
            }

            System.out.println(email);
            System.out.println(username);
            System.out.println(phone);
            System.out.println(g);

            newUser.setPhone(phone);
            em.persist(newUser);

            Addressmaster address = new Addressmaster();
            address.setEmail(newUser);
            address.setCity(city);
            address.setState(state);
            address.setPincode(pincode);

            em.persist(address);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addUser(String email, String username, String password, int gid, int phone) {
        Userregister user = new Userregister();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        
        Groupmaster g = em.find(Groupmaster.class, gid);
        user.setGroupid(g);
        user.setPhone(phone);
        
        em.persist(user);
    }

    
    
//    =========================================== Update Customer Profile
    @Override
    public void updateProfile(String email, String username, String password, int phone) {
        try {

            Userregister exsistUser = em.find(Userregister.class, email);
            if (exsistUser != null) {
                exsistUser.setUsername(username);
                exsistUser.setPassword(password);
                exsistUser.setPhone(phone);
                em.merge(exsistUser);
            } else {
                throw new IllegalArgumentException("In Userregister userid Not Found for UpdateProfile!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    ============================================ Update Address
    @Override
    public void manageAddress(int addressid, String email, String city, String state, int pincode) {
        try {
            Addressmaster exsistingAdd = em.find(Addressmaster.class, addressid);

            if (exsistingAdd != null) {
                exsistingAdd.setCity(city);
                exsistingAdd.setState(state);
                exsistingAdd.setPincode(pincode);

                em.merge(exsistingAdd);
            } else {
                throw new IllegalArgumentException("In Addressmaster addressid not found for manageAddress!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void changePassword(String email, String password) {
        Userregister user = em.find(Userregister.class, email);
        if (user != null) {
            user.setPassword(password);
            em.merge(user);
        } else {
            throw new IllegalArgumentException("User is not Found!!!");
        }
    }

//    ============================================== Add New Address
    @Override
    public void addAddress(String email, String city, String state, int pinCode) {
        try {
            Userregister user = em.find(Userregister.class, email);

            if (user != null) {
                Addressmaster add = new Addressmaster();

                add.setEmail(user);
                add.setCity(city);
                add.setState(state);
                add.setPincode(pinCode);
                em.persist(add);
            } else {
                throw new IllegalArgumentException("User email not found for addAddress!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    ================================================ Get All Addresses
    @Override
    public Collection<Addressmaster> getAllAddressesOfUser(String email) {
        try {
            Userregister existingUser = em.find(Userregister.class, email);

            if (existingUser != null) {
                Collection<Addressmaster> addresses = existingUser.getAddressmasterCollection();
                return addresses;
            } else {
                throw new IllegalAccessException("existingUser not found for getAllAddressofUser!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    ============================================= Get All Products User
    @Override
    public Collection<Products> getAllProducts() {
        try {
            Collection<Products> products = em.createNamedQuery("Products.findAll").getResultList();
            return products;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    ============================================= Get Product Details
    @Override
    public Products getProductDetails(int productid) {

        try {
            Products product = em.find(Products.class, productid);

            if (product != null) {
                return product;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Collection<Products> getProductsByCatgegory(int categoryid) {
        try {
            Productcategory cid = em.find(Productcategory.class, categoryid);

            if (cid != null) {
                Collection<Products> products = cid.getProductsCollection();

                for (Products product : products) {
                    product.getProductname();
                    product.getPrice();
                    product.getQuntity();
                    product.getDescription();
                    product.getFeedbackCollection();
                    product.getImage();
                }
                return products;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void submitReview(String email, int productid, String review) {
        try {
            Userregister user = em.find(Userregister.class, email);
            Products product = em.find(Products.class, productid);

            if (user != null && product != null) {
                Feedback feedback = new Feedback();
                feedback.setEmail(user);
                feedback.setProductid(product);
                feedback.setReview(review);
                feedback.setDate(new Date());

                em.persist(feedback);
            } else {
                System.out.println("User or Product not Found !!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Collection<Feedback> getAllFeedbacks(int productid) {
        try {
            System.out.println("Fetching product with ID: " + productid);
            Products product = em.find(Products.class, productid);

            if (product != null) {
                System.out.println("Product found. Number of feedbacks: " + product.getFeedbackCollection().size());
                return product.getFeedbackCollection();
            } else {
                System.err.println("Product Id getting null for getAllFeedbacks");
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void contactUs(String email, String query) {
        try {
            Userregister user = em.find(Userregister.class, email);

            if (user != null) {
                Contactus contact = new Contactus();
                contact.setEmail(user);
                contact.setQuery(query);
                em.persist(contact);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addProductToCart(String email, int productid, int quantity) {
        try {
            Products product = em.find(Products.class, productid);
            Userregister user = em.find(Userregister.class, email);

            if (product != null && product.getQuntity() >= quantity && user != null) {
                Cart cart = new Cart();
                cart.setProductid(product);
                cart.setUserregister(user);
                cart.setQuantity(quantity);
                cart.setPrice((int) (quantity * product.getPrice()));

                em.persist(cart);

            } else {
                System.err.println("Eather Email,Productid or Quantity is null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeProductFromCart(String email, int productid) {
        try {
            Userregister user = em.find(Userregister.class, email);
            Products product = em.find(Products.class, productid);

            if (user == null) {
                throw new IllegalArgumentException("User Not Found!!!");
            } else {
                TypedQuery<Cart> query = em.createQuery(
                        "SELECT c FROM Cart c WHERE c.email = :user AND c.productid = :productid", Cart.class);
                query.setParameter("user", user);
                query.setParameter("productid", product);

                List<Cart> carts = query.getResultList();

                if (!carts.isEmpty()) {
                    Cart productInCart = carts.get(0);
                    em.remove(productInCart);
                    System.out.println("Product removed from the user's cart.");
                } else {
                    System.out.println("Product not found in the user's cart.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Collection<Cart> viewCart(String email) {
        try {
            if (email == null) {
                throw new IllegalArgumentException("Invalid Email!!!");
            }

//            System.out.println("Email: " + email); 
            TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c WHERE c.userregister.email = :email", Cart.class);
            query.setParameter("email", email);
            Collection<Cart> result = query.getResultList();
//            System.out.println("Result Size: " + result.size());  

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void addPayment(int orderId, String email, String paymentMethod) {
        try {
            Ordermaster order = em.find(Ordermaster.class, orderId);

            if (order != null) {
                Payment payment = new Payment();
                payment.setOrderid(order);

                Userregister user = em.find(Userregister.class, email);

                if (user != null) {
                    payment.setEmail(user);

                    payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));
                    payment.setPaymentStatus("Pending");

                    int paymentAmount = 0;
                    for (Orderdetail detail : order.getOrderdetailCollection()) {
                        paymentAmount += detail.getAmount();
                    }

                    payment.setPaymentAmount(paymentAmount);
                    payment.setPaymentMethod(paymentMethod);

                    em.persist(payment);
                } else {
                    System.err.println("User is getting null");
                }
            } else {
                System.err.println("Order is getting Null");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String sayHello(String name) {
        return "<h1>" + name + "</h1>";
    }

    @Override
    public void insertOrderMaster(String email, int productid, Double totalAmount) {
        try {
            if (email == null || totalAmount == null) {
                throw new IllegalArgumentException("Please write email and total amount");
            } else {
                double taxAmount = 0;
                double gstAmount = 0;

                Userregister user = em.find(Userregister.class, email);

                if (user == null) {
                    throw new IllegalArgumentException("User with email " + email + " not found");
                }

                Products product = em.find(Products.class, productid);
                if (product == null) {
                    throw new IllegalArgumentException("Product with ID " + productid + " not found");
                }

                // Calculate tax and gst amounts
                taxAmount = totalAmount * (product.getTax() / 100);
                gstAmount = totalAmount * (product.getGst() / 100);

                // Create Ordermaster entity and set fields
                Ordermaster o = new Ordermaster();
                o.setEmail(user);
                o.setTotalamount(totalAmount + taxAmount + gstAmount);
                o.setTax(taxAmount);
                o.setOrderdate(new Date());
                o.setStatus("Ordered");
                o.setGst(gstAmount);

                // Persist the Ordermaster entity
                em.persist(o);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Collection<Ordermaster> viewUserOrder(String email) {
        try {
            Userregister user = em.find(Userregister.class, email);
            if (user == null) {
                throw new IllegalArgumentException("User not found!!!");
            }

            Collection<Ordermaster> orders = user.getOrdermasterCollection();
            return orders;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    @Override
//    public void updateOrderMaster(int orderid, String email, String status) {
//    
//        try{
//            Ordermaster order = em.find(Ordermaster.class, orderid);
//            
//            if(order != null){
//                
//            }else{
//                throw new IllegalArgumentException("Orderid not found for updateOrder Staus!!!");
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//    
//    }
    @Override
    public void addSingleOrderDetail(int orderid, String email, int productid, int qty) {

        try {

            Ordermaster ordermaster = em.find(Ordermaster.class, orderid);
            if (ordermaster == null) {
                throw new IllegalArgumentException("Invalid Order ID");
            }

            Products product = em.find(Products.class, productid);
            if (product == null) {
                throw new IllegalArgumentException("Invalid Product ID");
            }

            Userregister user = em.find(Userregister.class, email);
            if (user == null) {
                throw new IllegalArgumentException("Invalid User");
            }

            double calculatedTotalAmount = product.getPrice() * qty;

            Orderdetail orderdetail = new Orderdetail();
            orderdetail.setOrdermaster(ordermaster);
            orderdetail.setEmail(user);
            orderdetail.setProductid(product);
            orderdetail.setProductName(product.getProductname());
            orderdetail.setQty(qty);
            orderdetail.setRate(product.getPrice());
            orderdetail.setAmount(calculatedTotalAmount);

            em.persist(orderdetail);

            int currentQuantity = product.getQuntity();
            int updatedQuantity = currentQuantity - qty;
            product.setQuntity(updatedQuantity);
            em.merge(product);

            double currentTotalAmount = ordermaster.getTotalamount();
            double updatedTotalAmount = currentTotalAmount + calculatedTotalAmount;
            ordermaster.setTotalamount(updatedTotalAmount);
            em.merge(ordermaster);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Userregister findemail(String email) {
        Userregister user = em.find(Userregister.class, email);
        return user;
    }

    @Override
    public Cart addToCart(Cart cart, String email, int productid,int qty) {
        Userregister r = em.find(Userregister.class, email);
        Products p = em.find(Products.class, productid);
        
        cart.setUserregister(r);
        cart.setProductid(p);
        cart.setPrice((int) (qty * p.getPrice()));
        em.persist(cart);
        return cart;
    }
}
