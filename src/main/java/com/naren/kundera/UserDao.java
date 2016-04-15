/**
 * 
 */
package com.naren.kundera;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * @author narender
 *
 */
public class UserDao {

	EntityManagerFactory entityManagerFactory;
	/**
	 * 
	 */
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public EntityManagerFactory getEntityManagerFactory()
	{
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
	}
	
	public List<User> getAllUser(){
		EntityManager manager=entityManagerFactory.createEntityManager();
		return manager.createQuery("Select c from User c").getResultList();
	}
	public User getUserById(int id){
		EntityManager manager=entityManagerFactory.createEntityManager();
		return manager.find(User.class, id);
	}
	/**
	 * 
	 * @param user
	 */
	public void addUser(User user){
		EntityManager manager=entityManagerFactory.createEntityManager();
		manager.persist(user);
	}
	
	
}
