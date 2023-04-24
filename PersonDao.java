package OneToOne.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToOne.dto.Pancard;
import OneToOne.dto.Person;

public class PersonDao 
{
	public void savePerson(Person person)   // Create
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yogesh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Pancard pancard = person.getPancard();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(pancard);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void updatePerson(int id ,Person person)  // Update
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yogesh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Pancard pancard2 = person.getPancard();
		Person person2 = entityManager.find(Person.class, id);
		System.out.println(pancard2);
		System.out.println(person2);
		
		if(person2!=null && pancard2!=null)
		{
			entityTransaction.begin();
			person.setId(id);
			entityManager.merge(pancard2);
			entityManager.merge(person);
			entityTransaction.commit();
			
		}
		else
		{
			System.out.println("please check your id may be its wrong id to update");
		}
	}
	
	public void removePersonById(int id)   // Delete
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yogesh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		Pancard pancard = person.getPancard();
		entityTransaction.begin();
		entityManager.remove(pancard);
		entityManager.remove(person);
		entityTransaction.commit();
	}
	
	public void findPersonById(int id)  // Read
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yogesh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Person person = entityManager.find(Person.class, id);
//		PanCard panCard = person.getPancard();
		System.out.println(person);
//		System.out.println(panCard);
	}
	
	public void removePanCardById(int id)   // Delete
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yogesh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Pancard panCard = entityManager.find(Pancard.class, id);
		entityTransaction.begin();
		entityManager.remove(panCard);
		entityTransaction.commit();
	}
}
