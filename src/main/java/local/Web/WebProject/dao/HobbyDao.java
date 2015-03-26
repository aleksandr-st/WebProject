package local.Web.WebProject.dao;

import java.util.List;

import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Hobby;

public interface HobbyDao {
	public Hobby addHobby(Hobby hobby);
	
	public List<Contact> getAllContactsWithHobby(Hobby hobby);
}
