package com.naren.kundera;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

@Service
public class SpringExampleDao
{
    EntityManagerFactory entityManagerFactory;
    public SimpleComment addComment(int id, String userName, String commentText)
    {
        SimpleComment simpleComment = new SimpleComment(id, userName, commentText);        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(simpleComment);
        entityManager.close();
        return simpleComment;
    }

    public SimpleComment getCommentById(int i)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SimpleComment simpleComment = entityManager.find(SimpleComment.class, i);
        return simpleComment;
    }

    public List<SimpleComment> getAllComments()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c.commentText from SimpleComment c order by id");
        List<SimpleComment> list = query.getResultList();
        return list;
    }

    public EntityManagerFactory getEntityManagerFactory()
    {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
    {
        this.entityManagerFactory = entityManagerFactory;
    }
}