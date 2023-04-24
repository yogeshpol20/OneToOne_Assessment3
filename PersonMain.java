package OneToOne.controller;

import OneToOne.dao.PersonDao;
import OneToOne.dto.Pancard;
import OneToOne.dto.Person;

public class PersonMain 
{
	public static void main(String[] args) 
	{
		Pancard pancard = new Pancard();
		pancard.setId(101);
		pancard.setName("yogesh pol");
		pancard.setAddress("Kolhapur MH");
		
		Person person = new Person();
		person.setId(1);
		person.setName("yogesh");
		person.setAddress("Kolhapur");
		person.setPancard(pancard);
		
		PersonDao dao = new PersonDao();
		dao.savePerson(person);                 // Create
		
		
//		Pancard pancard = new Pancard();
//		pancard.setId(101);
//		pancard.setName("yogesh pol");
//		pancard.setAddress("Kolhapur MH");
//		
//		Person person = new Person();
//		person.setId(1);
//		person.setName("yogesh");
//		person.setAddress("Pune");
//		person.setPancard(pancard);
//		
//		dao.updatePerson(1, person);              // Update
		
		
//		dao.findPersonById(1);                    // Read
		
		
//		dao.removePersonById(1);                  // Remove  
		
		
		
	}
}
