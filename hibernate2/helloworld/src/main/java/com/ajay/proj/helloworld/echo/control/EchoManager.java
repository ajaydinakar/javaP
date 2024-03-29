package com.ajay.proj.helloworld.echo.control;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ajay.proj.helloworld.echo.entity.Echo;

public class EchoManager {
    @PersistenceContext
    EntityManager em;

    public Echo find(String message) {
        return em.find(Echo.class, message);
    }

    public void insert(Echo echo) {
        em.persist(echo);
    }
}
