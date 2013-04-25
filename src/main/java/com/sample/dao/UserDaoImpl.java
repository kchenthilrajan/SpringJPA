package com.sample.dao;

import com.sample.entities.UserDetail;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext private EntityManager em;
    @Transactional
    public void createUser(UserDetail userDetail) {
    em.persist(userDetail);
    em.flush();
    }

    public List<String> getAllUserNames() {
    return em.createQuery("Select s.userName from UserDetail s")
        .getResultList();
    }
    @Transactional
    public void deleteUser(UserDetail userDetail) {
    em.remove(userDetail);
    }
}
