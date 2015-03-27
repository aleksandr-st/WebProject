package local.Web.WebProject.service;

import java.util.List;
import java.util.Set;

import local.Web.WebProject.dao.ContactDao;
import local.Web.WebProject.dao.HobbyDao;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.ContactDetail;
import local.Web.WebProject.model.Hobby;

import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ServiceApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:data-source.xml");
		ctx.refresh();
		
		JavaContactService contactService = new JavaContactService();
		contactService.setContactDao(ctx.getBean("contactDao", ContactDao.class));
		contactService.setHobbyDao(ctx.getBean("hobbyDao", HobbyDao.class));
		DateTime dateTime = new DateTime(2000,2,10,0,0);
		contactService.createContact("Alex", "Gameson", dateTime);

		List<Contact> contacts = contactService.getContactDao().findAll();
		for(Contact contact: contacts){
			System.out.println(contact);
		}
		
		Contact contact = contactService.getContactDao().findById(1l);
		System.out.println("Contact friends:");
		for (Contact c_friend: contact.getFriends()){
			System.out.println("  f: " + c_friend.getFirstName());
		}
		System.out.println("Contact details:");
		for (ContactDetail c_detail: contact.getContactDetails()){
			System.out.println("  d: " + c_detail);
		}
		Contact friend = contactService.getContactDao().findById(2l);
		ContactDetail contactDetail = new ContactDetail("tel.","0356654666",contact);
		Set<ContactDetail> contactDetails = contact.getContactDetails();
		contactDetails.add(contactDetail);
		contact.setContactDetails(contactDetails);
		contactService.addFriendship(contact, friend);
		System.out.println("Contact friends after add:");
		for (Contact c_friend: contact.getFriends()){
			System.out.println("  f: " + c_friend.getFirstName());
		}
		contactService.getContactDao().removeFriendship(contact, friend);
		System.out.println("Contact friends after remove:");
		for (Contact c_friend: contact.getFriends()){
			System.out.println("  f: " + c_friend.getFirstName());
		}
		System.out.println("Contact hobbies:");
		for (Hobby c_hobby: contact.getHobbies()){
			System.out.println("  h: " + c_hobby.getTitle());
		}
		Hobby hobby = contactService.getHobbyDao().findById("Programming");
		contactService.getHobbyDao().removeHobby(hobby);
		contact = contactService.getContactDao().findById(1l);
		System.out.println("Contact hobbies after remove one:");
		for (Hobby c_hobby: contact.getHobbies()){
			System.out.println("  h: " + c_hobby.getTitle());
		}
		System.out.println("Contact details after add one:");
		for (ContactDetail c_detail: contact.getContactDetails()){
			System.out.println("  d: " + c_detail);
		}
		
		System.out.println(contact);
}

}
