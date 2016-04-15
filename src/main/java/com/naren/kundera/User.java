/**
 * 
 */
package com.naren.kundera;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author narender
 *
 */
@Entity
@Table(name="User", schema="nstanwar@cassandra_pu")
@XmlRootElement(name = "User")
@Cacheable
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3890464399424065119L;
	@Id
	private String id;
	private String first;
	private String last;
	private String age;
	/**
	 * 
	 */
	public User() {
	}
	public User(String id,String first,String last,String age) {
		this.id=id;
		this.first=first;
		this.last=last;
		this.age=age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age.hashCode();
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + id.hashCode();
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (id != other.id)
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", first=" + first + ", last=" + last
				+ ", age=" + age + "]";
	}

	
}
