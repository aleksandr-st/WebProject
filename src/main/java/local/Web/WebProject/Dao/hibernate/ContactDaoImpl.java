package local.Web.WebProject.dao.hibernate;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import local.Web.WebProject.dao.ContactDao;
import local.Web.WebProject.model.Contact;

@Service("contactDao")
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
	public void addContact(Contact contact){
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}
	public void deleteContact(Contact contact){
		sessionFactory.getCurrentSession().delete(contact);
	}
	public void addFriendship(Contact contact1, Contact contact2){
		//����� ���� ����� �� �� �������� ������� � ������� �� ��� ������
		//��������� �������(����� ��� ���� �� ��, ����� ����� ����� � ����)
		//� ����� �������� �������������� ����� ����������
	}
	public void removeFriendship(Contact contact1, Contact contact2){
		
	}

}
