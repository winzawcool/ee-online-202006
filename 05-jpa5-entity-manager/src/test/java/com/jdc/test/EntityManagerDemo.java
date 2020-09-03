package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.em.entity.Course;

class EntityManagerDemo {
	
	@Test
	void test1() {
		
		// create course
		Course c = new Course();	// new state (or) transient state
		c.setName("Java SE");
		c.setFees(200000);
		c.setDuration(3);
		
		// start transaction
		em.getTransaction().begin();
		
		// insert into db
		em.persist(c);		// managed state

		c.setDuration(4);
		
		em.detach(c);	// detach state
		
		// commit transaction
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		em.merge(c);	// managed state
		
		em.getTransaction().commit();
		
		// check
		assertEquals(1, c.getId());
	}
	
	@Test
	void test2() {
		
		Course c = em.find(Course.class, 1);	// managed state
		
		assertEquals(4, c.getDuration());
	}
	
	@Test
	void test3() {
	
		Course c = em.find(Course.class, 1);	// managed state
		
		em.getTransaction().begin();
		em.remove(c);	// removed state
		em.getTransaction().commit();	// delete from database
		
		assertNull(em.find(Course.class, 1));
	}
	
	static EntityManagerFactory EMF;
	EntityManager em;

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
