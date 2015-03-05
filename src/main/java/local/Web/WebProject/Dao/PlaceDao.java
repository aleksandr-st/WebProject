package local.Web.WebProject.Dao;

import java.util.List;

import local.Web.WebProject.controller.*;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Place;

public interface PlaceDao {
	void addPlace(Place place);
	
	List<Contact> getAllContactsForPlace(Place place);

}
