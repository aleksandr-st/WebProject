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
	
	public void addHobby(Hobby hobby){
		sessionFactory.getCurrentSession().saveOrUpdate(hobby);
	}
	@Transactional(readOnly=true)
	public List<Contact> getAllContactsWithHobby(Hobby hobby){
		return sessionFactory.getCurrentSession().getNamedQuery("Hobby.findAllWithHoby").setParameter("hobbyId", hobby).list();
	}

}
