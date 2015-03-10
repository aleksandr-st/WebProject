package local.Web.WebProject.controller;

import java.util.*;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import local.Web.WebProject.dao.ContactDao;
import local.Web.WebProject.dao.HobbyDao;
import local.Web.WebProject.dao.PlaceDao;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Hobby;
import local.Web.WebProject.model.Message;
import local.Web.WebProject.model.Place;

@Controller
public class JavaContactService {
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

	@RequestMapping("/showall")
	public ModelAndView showMessage() {
		System.out.println("in controller");
		
		List<Contact> contacts = contactDao.findAll();
		for(Contact contact: contacts){
			System.out.println(contact);
		}
				
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("contacts", contacts);
		mv.addObject("contact1", contacts.get(1));
		return mv;
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
}

}
