package com.example.hidework.dal;

import com.example.hidework.models.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.hidework.models.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;
    //USER
    public void addUser(User newUser) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newUser);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public String newUserToDatabase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name = user.getUserName();

        Query query = session
                .createQuery("FROM User where userName = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();

        if (userFrom != null ) {
            return "Выберите другое имя";
        }

        String useremail = user.getEmail();

        query = session
                .createQuery("FROM User where email = :email")
                .setParameter("email", useremail);
        userFrom = (User) query.uniqueResult();

        if (userFrom != null) {
            return "Выберите другую почту";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = md5.digest(user.getPassword().getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02X", b));
        }
        user.setPassword(builder.toString());

//        user.setPassword(userService.hashUserPassword(user.getPassword()));
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Победа)";
    }
    public User getUserFromDatabaseByUsername(String userName){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User where userName = :username")
                .setParameter("username", userName);
        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
    public User getUserId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
        return user;
    }
    public List<User> getUsers(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public  void updateUser(Long id, User updateUser){
        session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        user.setUserId(updateUser.getUserId());
        user.setUserAge(updateUser.getUserAge());
        user.setUserName(updateUser.getUserName());
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        session.merge(user);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public void delUserById(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.remove(user);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    //ROLE
    public void addRole(Role newRole){
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newRole);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public Role getRoleId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Role role=session.get(Role.class,id);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
        return role;
    }
    public List<Role> getRoles(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        query.select(root);
        List<Role> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public  void updateRole(Long id, Role updateRole){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Role role=session.get(Role.class,id);
        role.setRoleId(updateRole.getRoleId());
        role.setRoleName(updateRole.getRoleName());
        session.merge(role);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public void delRoleById(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Role role=session.get(Role.class,id);
        session.remove(role);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
//TUPE PRODUCT
    public void addProductType(ProductType newProductType){
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newProductType);
        session.getTransaction().commit();
        if (session!=null){
            session.close();
        }
    }
    public ProductType getProductTypeId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        ProductType productType=session.get(ProductType.class,id);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
        return productType;
    }
    public List<ProductType> getProductsTypes(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductType> query = builder.createQuery(ProductType.class);
        Root<ProductType> root = query.from(ProductType.class);
        query.select(root);
        List<ProductType> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public  void updateProductTypeId(Long id, ProductType updateProdType){
        session=sessionFactory.openSession();
        session.beginTransaction();
        ProductType productType=session.get(ProductType.class,id);
        productType.setProductTypeId(updateProdType.getProductTypeId());
        productType.setProductTypeName(updateProdType.getProductTypeName());
        session.merge(productType);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public void delProductTypeId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        ProductType productType=session.get(ProductType.class,id);
        session.remove(productType);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    //PRODUCT
    public void addProduct(Product newProduct){
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newProduct);
        session.getTransaction().commit();
        if (session!=null){
            session.close();
        }
    }
    public  void updateProductId(Long id, Product updateProduct){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Product product=session.get(Product.class,id);
        product.setProductId(updateProduct.getProductId());
        product.setName(updateProduct.getName());
        product.setDescription(updateProduct.getDescription());
        product.setMaterial(updateProduct.getMaterial());
        product.setPrice(updateProduct.getPrice());
        product.setCount(product.getCount());
        session.merge(product);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public Product getProductId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Product product=session.get(Product.class,id);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
        return product;
    }
    public List<Product> getProducts(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        List<Product> resultList = session.createQuery(query).getResultList();
        return resultList;
    }

    public void delProductId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        Product product=session.get(Product.class,id);
        session.remove(product);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    //SHOPPING BUG
    public void addShoppingBug(ShoppingBag newShoppingBug){
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newShoppingBug);
        session.getTransaction().commit();
        if (session!=null){
            session.close();
        }
    }
    public ShoppingBag getShoppingBagId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
       ShoppingBag shoppingBag=session.get(ShoppingBag.class,id);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
        return shoppingBag;
    }
    public List<ShoppingBag> getShoppingBag(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ShoppingBag> query = builder.createQuery(ShoppingBag.class);
        Root<ShoppingBag> root = query.from(ShoppingBag.class);
        query.select(root);
        List<ShoppingBag> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public  void updateShoppingBagId(Long id,ShoppingBag updateShoppingBag){
        session=sessionFactory.openSession();
        session.beginTransaction();
        ShoppingBag shoppingBag=session.get(ShoppingBag.class,id);
        shoppingBag.setShoppingBagId(updateShoppingBag.getShoppingBagId());
        shoppingBag.setCount(updateShoppingBag.getCount());
        session.merge(shoppingBag);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public void delShoppingBagId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        ShoppingBag shoppingBag=session.get(ShoppingBag.class,id);
        session.remove(shoppingBag);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }



}
