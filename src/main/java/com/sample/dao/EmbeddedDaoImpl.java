package com.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sample.entities.Environment;

@Component
public class EmbeddedDaoImpl implements EmbeddedDao {

    @PersistenceContext private EntityManager em;

    @Transactional
    public void saveEnvironment(Environment env) {
    em.persist(env);
    em.flush();
    }

    @Override
    public List<Environment> getAllEnvironments() {
    return em.createQuery("Select E from Environment E")
        .getResultList();
    }

}
