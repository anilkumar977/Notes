package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Anil");
	
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction et = em.getTransaction();
	
			public void saveAndUpdateUser(User user) {
				
				et.begin();
				em.merge(user);
				et.commit();
			
		}
		
		public void fetchUserById(int id){
			
			
			User user = em.find(User.class, id);
			
		}
		
		public User fetchUserByEmailAndPassword(String email,String password) {
			
			
			
			Query query = em.createQuery("select s from User s where s.email=?1 and s.password=?2");
				
				query.setParameter(1, email);
				query.setParameter(2, password);
			
			List <User> users = query.getResultList();
			if(users.isEmpty())
				return null;
//			for(User u : users) {
//			
//				u.getId();
//				u.getName();
//				u.getAge();
//				u.getEmail();
//				u.getPassword();
			return users.get(0);
			}
		}
