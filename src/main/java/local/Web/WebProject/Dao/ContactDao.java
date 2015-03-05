package local.Web.WebProject.Dao;

import local.Web.WebProject.model.Contact;

public interface ContactDao {

	public void addContact(Contact contact);
	
	public void deleteContact(Contact contact);
	
	public void addFriendship(Contact contact1, Contact contact2);
	
	public void removeFriendship(Contact contact1, Contact contact2);
	
}
