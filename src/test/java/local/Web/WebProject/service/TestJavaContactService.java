package local.Web.WebProject.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import local.Web.WebProject.dao.ContactDao;
import local.Web.WebProject.dao.HobbyDao;
import local.Web.WebProject.dao.PlaceDao;
import local.Web.WebProject.model.Contact;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class TestJavaContactService {

	private final List<Contact> contacts = new ArrayList<Contact>();

	private ContactDao contactDao;
	private HobbyDao hobbyDao;
	private PlaceDao placeDao;
	private ContactService contactService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		contactDao = mock(ContactDao.class);
		hobbyDao = mock(HobbyDao.class);
		placeDao = mock(PlaceDao.class);
		contactService = new JavaContactService();
		ReflectionTestUtils.setField(contactService, "contactDao", contactDao);
		ReflectionTestUtils.setField(contactService, "hobbyDao", hobbyDao);
		ReflectionTestUtils.setField(contactService, "placeDao", placeDao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateContact() {
		String firstName = "Kim";
		String lastName = "Chen";
		DateTime birthDate = new DateTime(1980,5,4,0,0);
		final Contact contact = new Contact(firstName, lastName, birthDate);
		when(contactDao.addContact(contact)).thenReturn(contact);
		Contact newContact = new Contact();
		newContact = contactService.createContact(firstName, lastName, birthDate);
		verify(contactDao).addContact(newContact);
	}

	@Test
	public void testAddHobby() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPlace() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFriendship() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFriendList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConversation() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOrUpdate() {
		fail("Not yet implemented");
	}

}
