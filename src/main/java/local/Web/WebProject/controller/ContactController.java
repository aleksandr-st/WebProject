package local.Web.WebProject.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import local.Web.WebProject.form.MessageMS;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.service.ContactService;
import local.Web.WebProject.util.UrlUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/contacts")
@Controller
public class ContactController {

	final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Resource(name="contactService")
	private ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public String showList(Model uiModel) {
		System.out.println("in controller");
		
		List<Contact> contacts = contactService.findAll();
		for(Contact contact: contacts){
			System.out.println(contact);
		}
		
		logger.info("No. of contacts " + contacts.size());
		
		uiModel.addAttribute("contacts", contacts);		
		return "contacts/list";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model uiModel){
		Contact contact = contactService.findById(id);
		uiModel.addAttribute("contact", contact);
		return "contacts/show";
	}
	
	@RequestMapping(value="/{id}", params = "form", method = RequestMethod.POST)
	public String update(Contact contact, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale){
		logger.info("Updating contact");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("message", new MessageMS("error", messageSource.getMessage("contact_save_fail", new Object[]{}, locale)));
			uiModel.addAttribute("contact", contact);
			return "contacts/update";
		}
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute("message", new MessageMS("success", messageSource.getMessage("contact_save_success", 
				new Object[] {}, locale)));
		Contact contactForUpdate;
		if (contact.getId() == null) {
			contactForUpdate = contact;
		} else {
			contactForUpdate = contactService.findById(contact.getId());
			contactForUpdate.setFirstName(contact.getFirstName());
			contactForUpdate.setLastName(contact.getLastName());
			contactForUpdate.setBirthDate(contact.getBirthDate());
			contactForUpdate.setVersion(contact.getVersion());
		}
		contactService.addOrUpdate(contactForUpdate);
		return "redirect:/contacts/"
				+ UrlUtil.encodeUrlPathSegment(contact.getId().toString(), httpServletRequest);
	}

	@RequestMapping(value="/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		uiModel.addAttribute("contact", contactService.findById(id));
		return "contacts/update";		
	}

	@RequestMapping(params = "form", method = RequestMethod.POST)
	public String create(Contact contact, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale){
		logger.info("Creating contact");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("message", new MessageMS("error", messageSource.getMessage("contact_save_fail", new Object[]{}, locale)));
			uiModel.addAttribute("contact", contact);
			return "contacts/update";
		}
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute("message", new MessageMS("success", messageSource.getMessage("contact_save_success", 
				new Object[] {}, locale)));
		
		logger.info("Contact Id: " + contact.getId());
		contactService.addOrUpdate(contact);
		return "redirect:/contacts/"
				+ UrlUtil.encodeUrlPathSegment(contact.getId().toString(), httpServletRequest);
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(Model uiModel) {
		Contact contact = new Contact();
		uiModel.addAttribute("contact", contact);
		return "contacts/create";		
	}
}
