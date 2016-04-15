/**
 * 
 */
package com.naren.kundera;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author narender
 *
 */
@Entity
@Table(name="SIMPLE_COMMENT", schema="KunderaExamples@cassandra_pu")
@XmlRootElement(name = "SimpleComment")
@Cacheable
public class SimpleComment
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "COMMENT_TEXT")
    private String commentText;

    public SimpleComment() {
    }    
    public SimpleComment(int commentId, String userName, String commentText) {
        this.id = commentId;
        this.userName = userName;
        this.commentText = commentText;
    }      
    public int getId()
    {
        return id;
    }   
    public void setId(int id)
    {
        this.id = id;
    }
    public String getUserName()
    {
        return userName;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getCommentText()
    {
        return commentText;
    }
    public void setCommentText(String commentText)
    {
        this.commentText = commentText;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentText == null) ? 0 : commentText.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		SimpleComment other = (SimpleComment) obj;
		if (commentText == null) {
			if (other.commentText != null)
				return false;
		} else if (!commentText.equals(other.commentText))
			return false;
		if (id != other.id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SimpleComment [id=" + id + ", userName=" + userName
				+ ", commentText=" + commentText + "]";
	}  
    
}
