package local.Web.WebProject.service;

import java.util.*;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import local.Web.WebProject.dao.ContactDao;
import local.Web.WebProject.dao.HobbyDao;
import local.Web.WebProject.dao.PlaceDao;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.ContactDetail;
import local.Web.WebProject.model.Hobby;
import local.Web.WebProject.model.Message;
import local.Web.WebProject.model.Place;

@Service("contactService")
public class JavaContactService implements ContactService{
	@Resource(name="contactDao")
	private ContactDao contactDao;
	@Resource(name="hobbyDao")
	private HobbyDao hobbyDao;
	@Resource(name="placeDao")
	private PlaceDao placeDao;
	
	public JavaContactService(){
	}
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	public void setHobbyDao(HobbyDao hobbyDao) {
		this.hobbyDao = hobbyDao;
	}
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}
	public ContactDao getContactDao() {
		return contactDao;
	}
	public HobbyDao getHobbyDao() {
		return hobbyDao;
	}
	public PlaceDao getPlaceDao() {
		return placeDao;
	}
	public Contact createContact(String firstName, String lastName, DateTime birthDate){
		Contact newContact = new Contact(firstName, lastName, birthDate);
		return contactDao.addContact(newContact);
	}
	public Hobby addHobby(String title, String description){
		return hobbyDao.addHobby(new Hobby(title, description));
	}
	public Place addPlace(String title, String description, Double longitude, Double latitude){
		return placeDao.addPlace(new Place(title, description, longitude, latitude));
	}
	public void addFriendship(Contact contact, Contact contactFriend){
		contactDao.addFriendship(contact, contactFriend);
	}
	public Set<Contact> getFriendList(Contact contact){
		Set<Contact> contactSet = null;
		
		return contactSet;
	}
	public List<Message> getConversation(Contact contactSender, Contact contactRecipient){
		List<Message> messageList = null;
		
		return messageList;
	}
	@Override
	public Contact findById(Long id) {
		return contactDao.findById(id);
	}
	@Override
	public List<Contact> findAll() {
		return contactDao.findAll();
	}
	@Override
	public Contact addOrUpdate(Contact contact) {
		contactDao.addContact(contact);
		return contact;
	}

}
