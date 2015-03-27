package local.Web.WebProject.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CONTACT_DETAIL")
public class ContactDetail implements Serializable {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="DETAIL_ID")
	private Long id;
	@Column(name="DETAIL_TYPE")
	private String type;
	@Column(name="DETAIL_DATA")
	private String data;
	@ManyToOne
	@JoinColumn(name="CONTACT_ID")
	private Contact contact;
	
	public ContactDetail(){
	}
	public ContactDetail(String type, String data, Contact contact){
		this.type = type;
		this.data = data;
		this.contact = contact;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return " ContactDetail [type=" + type + ", data=" + data + "]";
	};
	
}
