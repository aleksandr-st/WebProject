package local.Web.WebProject.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="contact")
@NamedQueries({
	@NamedQuery(name="Contact.findById",
			query="select distinct c from Contact c left join fetch c.hobbies h "
					+ "left join fetch c.places p left join fetch c.friends f "
					+ "left join fetch c.contactDetails d where c.id = :id")
})
public class Contact implements Serializable{
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")
	private Long id;
	@Version
	@Column(name="VERSION")
	private int version;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name="BIRTH_DATE")
	private DateTime birthDate;
	@ManyToMany
	@JoinTable(name="contact_hobby",
		joinColumns=@JoinColumn(name="CONTACT_ID"),
		inverseJoinColumns=@JoinColumn(name="HOBBY_ID")
		)
	private Set<Hobby> hobbies;
	@ManyToMany
	@JoinTable(name="contact_place",
		joinColumns=@JoinColumn(name="CONTACT_ID"),
		inverseJoinColumns=@JoinColumn(name="PLACE_ID")
		)
	private Set<Place> places;
	@ManyToMany
	@JoinTable(name="contact_friendship",
		joinColumns=@JoinColumn(name="CONTACT_ID"),
		inverseJoinColumns=@JoinColumn(name="FRIEND_ID")
		)
	private Set<Contact> friends;
	@OneToMany(mappedBy = "contact", cascade=CascadeType.ALL,
			orphanRemoval=true)
	private Set<ContactDetail> contactDetails;
	
	public Contact(){
	}
	public Contact(String firstName, String lastName, DateTime birthDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return this.version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public DateTime getBirthDate() {
		return this.birthDate;
	}
	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}
	public Set<Hobby> getHobbies() {
		return this.hobbies;
	}
	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	public Set<Place> getPlaces() {
		return this.places;
	}
	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	public Set<Contact> getFriends() {
		return friends;
	}
	public void setFriends(Set<Contact> friends) {
		this.friends = friends;
	}
	public Set<ContactDetail> getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(Set<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}
	@Override
	public String toString(){
		return firstName + "\n" + lastName + "\n" + birthDate;
	}
}
