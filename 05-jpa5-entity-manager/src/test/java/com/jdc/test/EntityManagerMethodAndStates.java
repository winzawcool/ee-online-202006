package com.jdc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.em.entity.Course;

class EntityManagerMethodAndStates {
	
	static EntityManagerFactory EMF;
	EntityManager em;
	
//	@Test
	void test1() {
		
		Course c = new Course();
		c.setName("Java SE");
		
		// New -> Managed
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		// Managed -> Ignore
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		// Detach -> PersistentObjectException
//		em.getTransaction().begin();
//		em.detach(c);	// detach
//		em.persist(c);
//		em.getTransaction().commit();
		
		// Removed -> Ignore
		em.getTransaction().begin();
		em.remove(c);
		em.persist(c);
		em.getTransaction().commit();
		
//		Course c2 = em.find(Course.class, 1);
		
		// Delete -> PersistentObjectException
//		em.getTransaction().begin();
//		em.remove(c);
//		em.getTransaction().commit();
//		em.getTransaction().begin();
//		em.persist(c);
//		em.getTransaction().commit();
	}
	
//	@Test
	void test2() {
		
		Course c = new Course();
		c.setName("Java EE");
		
		// New -> Managed 
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
//		System.out.println(c.getId());
		System.out.println(em.contains(c));
		
		// Managed State
		Course c2 = em.find(Course.class, 1);
		
//		System.out.println(c2.getName());
//		System.out.println(c2.getId());
		
		// New ->  
		em.getTransaction().begin();
		em.merge(c2);
		em.getTransaction().commit();
		
		// Removed -> ObjectDeletedException
//		em.getTransaction().begin();
//		em.remove(c2);
//		em.merge(c2);
//		em.getTransaction().commit();
		
		// Delete -> Detach (Insert)
		em.getTransaction().begin();
		em.remove(c2);
		em.getTransaction().commit();
		em.getTransaction().begin();
		em.merge(c2);
		em.getTransaction().commit();
		
		System.out.println(em.contains(c2));
	}
	
//	@Test
	void test3() {
		
		Course c = new Course();
		c.setName("Java EE");
		
		em.getTransaction().begin();
		em.persist(c);	// managed state
		em.detach(c);	// detached state
		em.getTransaction().commit();
		
		// Detach -> Ignore
		em.detach(c);
		
		// new -> Ignore
		Course c1 = new Course();
		em.detach(c1);
		
		// removed -> IllegealArgumentException
//		em.getTransaction().begin();
//		em.merge(c);	// managed state
//		em.remove(c);	// removed state
//		em.detach(c);	// detached state
//		em.getTransaction().commit();
		
		// deleted -> IllegealArgumentException
//		em.getTransaction().begin();
//		em.merge(c);	// manage
//		em.remove(c);	// remove
//		em.getTransaction().commit();
//		em.detach(c);
	}
	
	@Test
	void test4() {
		
		Course c = new Course();
		c.setName("Java EE");
		
		em.getTransaction().begin();
		em.persist(c);	// managed state
		em.detach(c);	// detach
		em.getTransaction().commit();
		
		// remove -> IllegalArgumentExecption
//		em.remove(c);
		
		Course c1 = new Course();
		em.remove(c1);
		
//		em.getTransaction().begin();
//		em.remove(c);
//		em.remove(c);
//		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.remove(c);
		
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa5");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = EMF.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

}
