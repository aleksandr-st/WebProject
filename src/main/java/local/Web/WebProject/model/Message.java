package local.Web.WebProject.model;

import java.util.*;

public class Message {
	
	private Calendar date = null;
	private Contact from = null;
	private Contact to = null;
	private String content = null;
	
	public Message(Calendar date, Contact from, Contact to, String content){
		this.date = date;
		this.from = from;
		this.to = to;
		this.content = content;	
	}
	
	public void setDate(Calendar date){
		this.date = date;
	}
	public Calendar getDate(){
		return date;
	}
	public void setFrom(Contact from){
		this.from = from;
	}
	public Contact getFrom(){
		return from;
	}
	public void setTo(Contact to){
		this.to = to;
	}
	public Contact getTo(){
		return to;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return content;
	}

}
