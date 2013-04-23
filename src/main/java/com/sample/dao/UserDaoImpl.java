package com.sample.dao;

import com.sample.entities.UserDetail;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    @Transactional
    public void createUser(UserDetail userDetail) {
	entityManager.persist(userDetail);
    }

    public List<String> getAllUserNames() {
	return entityManager.createQuery("Select s.userName from UserDetail s")
		.getResultList();
    }
    @Transactional
    public void deleteUser(UserDetail userDetail) {
	entityManager.remove(userDetail);
    }
}
