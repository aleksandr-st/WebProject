package local.Web.WebProject.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import local.Web.WebProject.model.Contact;
import local.Web.WebProject.service.ContactService;

import org.hsqldb.error.Error;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.context.MessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

public class TestContactController {
	
	private final List<Contact> contacts = new ArrayList<Contact>();
	
	private ContactService contactService;
	
	private MessageSource messageSource;

	@Before
	public void setUp() throws Exception {
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("Kim");
		contact.setLastName("Chen");
		contact.setBirthDate(new DateTime(2000, 1, 2, 0, 0));
		contacts.add(contact);
		contactService = mock(ContactService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowList() {
		when(contactService.findAll()).thenReturn(contacts);
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = contactController.showList(uiModel);
		assertNotNull(result);
		assertEquals("contacts/list", result);
		@SuppressWarnings("unchecked")
		List<Contact> modelContacts = (List<Contact>) uiModel.get("contacts");
		assertEquals(1, modelContacts.size());
	}

	@Test
	public void testShow() {
		when(contactService. findById(1l)).thenReturn(contacts.get(0));
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = contactController.show(1l, uiModel);
		assertNotNull(result);
		assertEquals("contacts/show", result);
		Contact modelContact = (Contact) uiModel.get("contact");
		assertEquals((Long) 1l, modelContact.getId());
	}

	@Test
	public void testUpdate() {
		final Contact contact = contacts.get(0); 
		when(contactService.findById(1l)).thenReturn(contact);
		when(contactService.addOrUpdate(contact)).thenAnswer(new Answer<Contact>(){
			public Contact answer(InvocationOnMock invocation) throws Throwable{
				contact.setLastName("Chen");
				contact.setVersion(2);
				return contact;
			}
		});
		messageSource = mock(MessageSource.class);
		when(messageSource.getMessage("save_contact_success", new Object[] {}, Locale.ENGLISH)).thenReturn("success");
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ReflectionTestUtils.setField(contactController, "messageSource", messageSource);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		BindingResult bindingResult = new BeanPropertyBindingResult(contact, "contact");
		HttpServletRequest httpServletRequest = new MockHttpServletRequest();
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		Locale locale = Locale.ENGLISH;
		
		String result = contactController.update(contact, bindingResult, uiModel, httpServletRequest, 
				redirectAttributes, locale);
		assertNotNull(result);
		assertEquals("redirect:/contacts/1", result);
		assertEquals(1, contacts.size());
		assertEquals(2, contacts.get(0).getVersion());
		assertEquals("Chen", contacts.get(0).getLastName());
	}

	@Test
	public void testUpdateHasError() {
		final Contact contact = contacts.get(0); 
		messageSource = mock(MessageSource.class);
		when(messageSource.getMessage("save_contact_fail", new Object[] {}, Locale.ENGLISH)).thenReturn("fail");
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ReflectionTestUtils.setField(contactController, "messageSource", messageSource);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		BindingResult bindingResult = new BeanPropertyBindingResult(contact, "contact");
		bindingResult. addError(new FieldError("contact","lastName","error"));
		HttpServletRequest httpServletRequest = new MockHttpServletRequest();
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		Locale locale = Locale.ENGLISH;
		
		String result = contactController.update(contact, bindingResult, uiModel, httpServletRequest, 
				redirectAttributes, locale);
		assertNotNull(result);
		assertEquals("contacts/update", result);
		assertEquals(1, contacts.size());
	}

	@Test
	public void testUpdateForm() {
		when(contactService. findById(1l)).thenReturn(contacts.get(0));
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = contactController.updateForm(1l, uiModel);
		assertNotNull(result);
		assertEquals("contacts/update", result);
		Contact modelContact = (Contact) uiModel.get("contact");
		assertEquals((Long) 1l, modelContact.getId());
	}

	@Test
	public void testCreate() {
		final Contact newContact = new Contact();
		newContact.setId(90l);
		newContact.setFirstName("Jet");
		newContact.setLastName("Lee");
		newContact.setBirthDate(new DateTime(1990, 10, 12, 0, 0));
		when(contactService.addOrUpdate(newContact)).thenAnswer(new Answer<Contact>(){
			public Contact answer(InvocationOnMock invocation) throws Throwable{
				contacts.add(newContact);
				return newContact;
			}
		});
		messageSource = mock(MessageSource.class);
		when(messageSource.getMessage("save_contact_success", new Object[] {}, Locale.ENGLISH)).thenReturn("success");
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ReflectionTestUtils.setField(contactController, "messageSource", messageSource);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		BindingResult bindingResult = new BeanPropertyBindingResult(newContact, "contact");
		HttpServletRequest httpServletRequest = new MockHttpServletRequest();
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		Locale locale = Locale.ENGLISH;
		
		String result = contactController.create(newContact, bindingResult, uiModel, httpServletRequest, 
				redirectAttributes, locale);
		assertNotNull(result);
		assertEquals("redirect:/contacts/90", result);
		assertEquals(2, contacts.size());
	}

	@Test
	public void testCreateHasErrors() {
		final Contact newContact = new Contact();
		messageSource = mock(MessageSource.class);
		when(messageSource.getMessage("save_contact_fail", new Object[] {}, Locale.ENGLISH)).thenReturn("fail");
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ReflectionTestUtils.setField(contactController, "messageSource", messageSource);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		BindingResult bindingResult = new BeanPropertyBindingResult(newContact, "contact");
		bindingResult. addError(new FieldError("contact","lastName","error"));
		HttpServletRequest httpServletRequest = new MockHttpServletRequest();
		RedirectAttributes redirectAttributes = new RedirectAttributesModelMap();
		Locale locale = Locale.ENGLISH;
		
		String result = contactController.create(newContact, bindingResult, uiModel, httpServletRequest, 
				redirectAttributes, locale);
		assertNotNull(result);
		assertEquals("contacts/update", result);
		assertEquals(1, contacts.size());
	}

	@Test
	public void testCreateForm() {
		contactService = mock(ContactService.class);
		ContactController contactController = new ContactController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = contactController.createForm(uiModel);
		assertNotNull(result);
		assertEquals("contacts/create", result);
		Contact modelContact = (Contact) uiModel.get("contact");
		assertNotNull(modelContact);
		assertNull(modelContact.getId());
	}

}
