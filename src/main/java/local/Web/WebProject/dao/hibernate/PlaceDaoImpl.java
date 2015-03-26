package local.Web.WebProject.dao.hibernate;

import java.util.*;

import org.springframework.stereotype.Repository;
import local.Web.WebProject.dao.PlaceDao;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Place;

@Repository("placeDao")
public class PlaceDaoImpl implements PlaceDao{
	
	public Place addPlace(Place place){
		return null;
	}
	public List<Contact> getAllContactsForPlace(Place place){
		List<Contact> contactSet = null;
		
		return contactSet;
	}

}
