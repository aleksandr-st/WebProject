package local.Web.WebProject.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class TestContact {

	private Contact contact;

	@Before
	public void setUp() throws Exception {
		contact = new Contact();
		assertNotNull(contact);
	}

	@Test
	public void testSetGetId() {
		contact.setId(1l);
		assertEquals((Long)1l, contact.getId());
	}

	@Test
	public void testSetGetVersion() {
		contact.setVersion(2);
		assertEquals(2, contact.getVersion());
	}

	@Test
	public void testSetGetFirstName() {
		contact.setFirstName("Kim");
		assertEquals("Kim", contact.getFirstName());
	}

	@Test
	public void testSetGetLastName() {
		contact.setLastName("Chen");
		assertEquals("Chen", contact.getLastName());
	}

	@Test
	public void testSetGetBirthDate() {
		DateTime dateTime = new DateTime(2000,2,10,0,0);
		contact.setBirthDate(dateTime);
		assertEquals(dateTime, contact.getBirthDate());
	}

	@Test
	public void testSetGetHobbies() {
		Set<Hobby> hobbies = new HashSet<Hobby>();
		hobbies.add(new Hobby("swimming","swimming"));
		hobbies.add(new Hobby("chess","chess"));
		contact.setHobbies(hobbies);
		assertNotNull(contact.getHobbies());
		assertEquals(2, contact.getHobbies().size());
	}

	@Test
	public void testSetGetPlaces() {
		Set<Place> places = new HashSet<Place>();
		places.add(new Place("home","home",0.,0.));
		places.add(new Place("work","work",0.,0.));
		contact.setPlaces(places);
		assertNotNull(contact.getPlaces());
		assertEquals(2, contact.getPlaces().size());
	}

	@Test
	public void testGetFriends() {
		Set<Contact> friends = new HashSet<Contact>();
		friends.add(new Contact("Kim", "Chen", new DateTime(2000,5,1,0,0)));
		contact.setFriends(friends);
		assertNotNull(contact.getFriends());
		assertEquals(1, contact.getFriends().size());
	}

}
