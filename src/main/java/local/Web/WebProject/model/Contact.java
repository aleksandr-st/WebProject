package local.Web.WebProject.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="contact")
public class Contact implements Serializable{
	private Long id;
	private int version;
	private String firstName;
	private String lastName;
	private DateTime birthDate;
	private TreeSet<Hobby> hobbies;
	private TreeSet<Place> places;
	
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
	@Column(name="BIRTH_DATE")
	@Type(type="org.joda.time.contrib.hibernate.PersistenDateTime")
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
	public TreeSet<Hobby> getHobbies() {
		return this.hobbies;
	}
	public void setHobbies(TreeSet<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	@ManyToMany
	@JoinTable(name="contact_place",
		joinColumns=@JoinColumn(name="CONTACT_ID"),
		inverseJoinColumns=@JoinColumn(name="PLACE_ID")
		)
	public TreeSet<Place> getPlaces() {
		return this.places;
	}
	public void setPlaces(TreeSet<Place> places) {
		this.places = places;
	}
	public String toString(){
		String str = ""; //super();
		return str + "\n" + firstName + "\n" + lastName + "\n" + birthDate;
	}
}
