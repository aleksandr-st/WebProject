package local.Web.WebProject.controller;

import java.util.*;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

import local.Web.WebProject.dao.ContactDao;
import local.Web.WebProject.dao.HobbyDao;
import local.Web.WebProject.dao.PlaceDao;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Hobby;
import local.Web.WebProject.model.Message;
import local.Web.WebProject.model.Place;

public class JavaContactService {
	private ContactDao contactDao;
	private HobbyDao hobbyDao;
	private PlaceDao placeDao;
	
	public ContactDao getContactDao() {
		return this.contactDao;
	}
	@Resource(name="contactDao")
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	public HobbyDao getHobbyDao() {
		return this.hobbyDao;
	}
	@Resource(name="hobbyDao")
	public void setHobbyDao(HobbyDao hobbyDao) {
		this.hobbyDao = hobbyDao;
	}
	public PlaceDao getPlaceDao() {
		return this.placeDao;
	}
	@Resource(name="placeDao")
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}
	public void createContact(String firstName, String lastName, DateTime birthDate){
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
	public Set<Contact> getFriendList(Contact contact){
		Set<Contact> contactSet = null;
		
		return contactSet;
	}
	public List<Message> getConversation(Contact contact1, Contact contact2){
		List<Message> messageList = null;
		
		return messageList;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:data-source.xml");
		ctx.refresh();
		
		JavaContactService contactService = new JavaContactService();
		contactService.setContactDao(ctx.getBean("contactDao", ContactDao.class));
		DateTime dateTime = new DateTime(2000,2,10,0,0);
		contactService.createContact("Alex", "Gameson", dateTime);
	}

}
