package local.Web.WebProject.controller;

import java.util.*;

import org.joda.time.DateTime;

import local.Web.WebProject.Dao.ContactDaoImpl;
import local.Web.WebProject.Dao.HobbyDaoImpl;
import local.Web.WebProject.Dao.PlaceDaoImpl;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Hobby;
import local.Web.WebProject.model.Message;
import local.Web.WebProject.model.Place;

public class JavaContactService {
	static private ContactDaoImpl contactDao = new ContactDaoImpl();
	static private HobbyDaoImpl hobbyDao = new HobbyDaoImpl();
	static private PlaceDaoImpl placeDao = new PlaceDaoImpl();
	
	public void createContact(String firstName, String lastName, DateTime birthDate){
		System.out.println("235");
		Contact newContact = new Contact(firstName, lastName, birthDate);
		contactDao.addContact(newContact);
		System.out.println(newContact.toString());
	}
	public void addHobby(String title, String description){
		hobbyDao.addHobby(new Hobby(title, description));
	}
	public void addPlace(String title, String description, Double longitude, Double latitude){
		placeDao.addPlace(new Place(title, description, longitude, latitude));
	}
	public void addFriendship(Contact contact1, Contact contact2){
		contactDao.addFriendship(contact1, contact2);
	}
	public TreeSet<Contact> getFriendList(Contact contact){
		TreeSet<Contact> contactSet = null;
		
		return contactSet;
	}
	public ArrayList<Message> getConversation(Contact contact1, Contact contact2){
		ArrayList<Message> messageList = null;
		
		return messageList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaContactService contactService = new JavaContactService(); 
		contactService.createContact("Alex", "Gameson", new DateTime(2000, 11, 5, 0, 0));
	}

}
