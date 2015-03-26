package local.Web.WebProject.dao;

import java.util.List;

import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Place;

public interface PlaceDao {
	Place addPlace(Place place);
	
	List<Contact> getAllContactsForPlace(Place place);

}
