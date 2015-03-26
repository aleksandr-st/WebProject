package local.Web.WebProject.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import local.Web.WebProject.dao.ContactDao;
import local.Web.WebProject.model.Contact;

@Repository("contactDao")
@Transactional
public class ContactDaoImpl implements ContactDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public Contact addContact(Contact contact){
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
		return contact;
	}
	public void deleteContact(Contact contact){
		sessionFactory.getCurrentSession().delete(contact);
	}
	public void addFriendship(Contact contact1, Contact contact2){
		//Думаю надо найти по Ид основной контакт и удалить из его друзей
		//указанный контакт(найдя его тоже по Ид, чтобы точно найти в сете)
		//и затем обновить первоначальный путем сохранения
	}
	public void removeFriendship(Contact contact1, Contact contact2){
		
	}
	@Transactional(readOnly=true)
	public List<Contact> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
	}
	@Transactional(readOnly=true)
	public Contact findById(Long id) {
		return (Contact)sessionFactory.getCurrentSession().getNamedQuery("Contact.findById").setParameter("id", id) .uniqueResult();
	}

}
