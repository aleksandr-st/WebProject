package local.Web.WebProject.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

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
	private JavaContactService contactService;
	
	
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
		contactService.setContactDao(contactService.getContactDao());
		ReflectionTestUtils.setField(contactService, "hobbyDao", hobbyDao);
		contactService.setHobbyDao(contactService.getHobbyDao());
		ReflectionTestUtils.setField(contactService, "placeDao", placeDao);
		contactService.setPlaceDao(contactService.getPlaceDao());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateContact() {
		String firstName = "Kim";
		String lastName = "Chen";
		DateTime birthDate = new DateTime(1980,5,4,0,0);
		final Contact testContact = new Contact(firstName, lastName, birthDate);
		when(contactDao.addContact((Contact)anyObject())).thenReturn(testContact);
		Contact newContact = new Contact();
		newContact = contactService.createContact(firstName, lastName, birthDate);
		assertNotNull(newContact);
		verify(contactDao, times(1)).addContact((Contact)anyObject());
		assertEquals(testContact.getFirstName(), newContact.getFirstName());
		assertEquals(testContact.getLastName(), newContact.getLastName());
		assertEquals(testContact.getBirthDate(), newContact.getBirthDate());
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
