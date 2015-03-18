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
			query="select distinct c from Contact c left join fetch c.hobbies h left join fetch c.places p left join fetch c.friends f where c.id = :id")
})
public class Contact implements Serializable{
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private Set<Hobby> hobbies;
	private Set<Place> places;
	private Set<Contact> friends;
	
	public Contact(){
	}
	public Contact(String firstName, String lastName, DateTime birthDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Version
	@Column(name="VERSION")
	public int getVersion() {
		return this.version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	@Column(name="BIRTH_DATE")
	public DateTime getBirthDate() {
		return this.birthDate;
	}
	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}
	@ManyToMany
	@JoinTable(name="contact_hobby",
		joinColumns=@JoinColumn(name="CONTACT_ID"),
		inverseJoinColumns=@JoinColumn(name="HOBBY_ID")
		)
	public Set<Hobby> getHobbies() {
		return this.hobbies;
	}
	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	@ManyToMany
	@JoinTable(name="contact_place",
		joinColumns=@JoinColumn(name="CONTACT_ID"),
		inverseJoinColumns=@JoinColumn(name="PLACE_ID")
		)
	public Set<Place> getPlaces() {
		return this.places;
	}
	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	@ManyToMany
	@JoinTable(name="contact_friendship",
		joinColumns=@JoinColumn(name="CONTACT_ID"),
		inverseJoinColumns=@JoinColumn(name="FRIEND_ID")
		)
	public Set<Contact> getFriends() {
		return friends;
	}
	public void setFriends(Set<Contact> friends) {
		this.friends = friends;
	}
	@Override
	public String toString(){
		return firstName + "\n" + lastName + "\n" + birthDate;
	}
}
