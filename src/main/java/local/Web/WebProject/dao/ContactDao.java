package local.Web.WebProject.dao;

import java.util.List;

import local.Web.WebProject.model.Contact;

public interface ContactDao {

	public List<Contact> findAll();
	
	public Contact findById(Long id);
	
	public Contact addContact(Contact contact);
	
	public void deleteContact(Contact contact);
	
	public Contact addFriendship(Contact contact1, Contact contact2);
	
	public Contact removeFriendship(Contact contact1, Contact contact2);
	
}
