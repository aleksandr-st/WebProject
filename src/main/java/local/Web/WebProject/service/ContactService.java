package local.Web.WebProject.service;

import java.util.List;
import java.util.Set;

import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Hobby;
import local.Web.WebProject.model.Message;
import local.Web.WebProject.model.Place;

import org.joda.time.DateTime;

public interface ContactService {
	
	Contact createContact(String firstName, String lastName, DateTime birthDate);
	
	Hobby addHobby(String title, String description);
	
	Place addPlace(String title, String description, Double longitude, Double latitude);
	
	void addFriendship(Contact contact, Contact contactFriend);
	
	Set<Contact> getFriendList(Contact contact);
	
	List<Message> getConversation(Contact contactSernder, Contact contactRecipient);
	
	Contact findById(Long id);
	
	List<Contact> findAll();
	
	Contact addOrUpdate(Contact contact);

}
