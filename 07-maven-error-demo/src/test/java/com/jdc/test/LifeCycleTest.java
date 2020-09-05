package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.entity.Student;

class LifeCycleTest {
	
	static EntityManagerFactory EMF;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("test");
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

	@Test
	void test() {
		
		// tx begin
		em.getTransaction().begin();
		
		// persist entity
		Student s = new Student();
		s.setName("Thidar");
//		em.persist(s);
		s = em.merge(s);
		
		// entity must be contained in em
		assertTrue(em.contains(s));
		
		// tx commit
		em.getTransaction().commit();
		
		// detach entity
		em.detach(s);
		
		// entity must not be contained in em
		assertFalse(em.contains(s));

		em.getTransaction().begin();
		// merge entity
		s = em.merge(s);
		
		s.setPhone("09123456789");
		
		// entity must be contained in em
		assertTrue(em.contains(s));
		
		em.getTransaction().commit();
	}

}
