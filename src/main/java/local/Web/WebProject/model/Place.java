package local.Web.WebProject.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="place")
public class Place {
	private String title;
	private String description;
	private Double longitude;
	private Double latitude;
	private Set<Contact> contacts;

	public Place(){
	}
	public Place(String title, String description, Double longitude, Double latitude){
		this.title = title;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	@Id
	@Column(name="TITLE")
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="PLACE_DESCR")
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="PLACE_LONGITUDE")
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	@Column(name="PLACE_LATITUDE")
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	@ManyToMany
	@JoinTable(name="contact_place",
		joinColumns=@JoinColumn(name="PLACE_ID"),
		inverseJoinColumns=@JoinColumn(name="CONTACT_ID")
		)
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public String toString(){
		return "Place Id: " + title + ", Description: " + description;
	}
}
