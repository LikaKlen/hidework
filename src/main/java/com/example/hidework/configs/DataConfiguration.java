package com.example.hidework.configs;

import com.example.hidework.dal.DataAccessLayer;
import com.example.hidework.models.User;
import com.example.hidework.security.TokenFilter;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataConfiguration(EntityManager entityManager) {
        Session session = entityManager.unwrap(Session.class);
        this.sessionFactory = session.getSessionFactory();
    }

    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public DataAccessLayer dataAccessLayer() {
        return new DataAccessLayer(sessionFactory);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}