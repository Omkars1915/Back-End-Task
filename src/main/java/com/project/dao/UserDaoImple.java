package com.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.User;
@Repository
public class UserDaoImple implements UserDao {
	
	@Autowired
	private SessionFactory factory;
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public String registerUser(User user) {
		Session session=null;
		try {
			session=factory.openSession();
			session.save(user);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return "Register Successfully";
	}

	@Override
	public User loginUser(String username, String password) {
		try {
            String query = "SELECT u FROM User u WHERE u.username = :username AND u.user_password = :password";
            return entityManager.createQuery(query, User.class)
                                .setParameter("username", username)
                                .setParameter("password", password)
                                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
		 
	}

	@Override
	public User getUserById(long id) {
		Session session=null;
		try {
			session=factory.openSession();
			User user = session.get(User.class, id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return null;
	}

}
