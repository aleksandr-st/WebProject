package local.Web.WebProject.dao.hibernate;

import java.util.*;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import local.Web.WebProject.dao.HobbyDao;
import local.Web.WebProject.model.Contact;
import local.Web.WebProject.model.Hobby;

@Repository("hobbyDao")
@Transactional
public class HobbyDaoImpl implements HobbyDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Hobby addHobby(Hobby hobby){
		sessionFactory.getCurrentSession().saveOrUpdate(hobby);
		return hobby;
	}
	public void removeHobby(Hobby hobby){
		sessionFactory.getCurrentSession().delete(hobby);
	}
	@Transactional(readOnly=true)
	public List<Contact> getAllContactsWithHobby(Hobby hobby){
		return sessionFactory.getCurrentSession().getNamedQuery("Hobby.findAllWithHoby").setParameter("hobbyId", hobby).list();
	}
	@Transactional(readOnly=true)
	public Hobby findById(String id){
		return (Hobby)sessionFactory.getCurrentSession().getNamedQuery("Hobby.findById").setParameter("id", id).uniqueResult();
	}
	@Transactional(readOnly=true)
	public List<Hobby> findAll(){
		return sessionFactory.getCurrentSession().createQuery("from Hobby h").list();
	}
	@Override
	@Transactional(readOnly=true)
	public List<Hobby> findAllUnusedForContact(Contact contact) {
		List<Hobby> allHobbies = findAll();
		if (contact == null){
			return allHobbies;
		}
		if (contact.getHobbies() == null){
			return allHobbies;
		}
		for (Hobby hobby: contact.getHobbies()){
			allHobbies.remove(hobby);
		};
		return allHobbies;
	}

}
