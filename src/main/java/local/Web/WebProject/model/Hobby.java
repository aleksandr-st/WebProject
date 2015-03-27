package local.Web.WebProject.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="hobby")
@NamedQueries({
	@NamedQuery(name="Hobby.findById",
		query="select h from Hobby h where h.title = :id"),
	@NamedQuery(name="Hobby.findAllWithHobby",
		query="select distinct c from Contact c join fetch c.hobbies h where h.title = :hobbyId"),
})
public class Hobby {
	@Id
	@Column(name="HOBBY_ID")
	private String title;
	@Column(name="HOBBY_DESCR")
	private String description;
	@ManyToMany
	@JoinTable(name="contact_hobby",
		joinColumns=@JoinColumn(name="HOBBY_ID"),
		inverseJoinColumns=@JoinColumn(name="CONTACT_ID")
		)
	private Set<Contact> contacts;
	
	public Hobby(){		
	}
	public Hobby(String title, String description){
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Contact> getContacts() {
		return this.contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString(){
		return "Hobby Id: " + title + ", Description: " + description;
	}
}
