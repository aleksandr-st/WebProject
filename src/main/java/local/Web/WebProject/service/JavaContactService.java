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

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:data-source.xml");
		ctx.refresh();
		
		JavaContactService contactService = new JavaContactService();
		contactService.setContactDao(ctx.getBean("contactDao", ContactDao.class));
		DateTime dateTime = new DateTime(2000,2,10,0,0);
		contactService.createContact("Alex", "Gameson", dateTime);

		List<Contact> contacts = contactService.contactDao.findAll();
		for(Contact contact: contacts){
			System.out.println(contact);
		}
		
		Contact contact = contactService.contactDao.findById(1l);
		System.out.println(contact);
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
	public void addOrUpdate(Contact contact) {
		contactDao.addContact(contact);
	}

}
