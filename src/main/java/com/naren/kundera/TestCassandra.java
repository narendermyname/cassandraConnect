/**
 * 
 */
package com.naren.kundera;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author narender
 *
 */
public class TestCassandra {

	/**
	 * 
	 */
	public TestCassandra() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("context.xml"));
		SpringExampleDao dao = (SpringExampleDao) beanFactory.getBean("springExampleDao"); 
		UserDao useDao=(UserDao)beanFactory.getBean("userDao");
		User user=new User("1","Narender3","Singh3","");
		useDao.addUser(user);
		System.out.println(useDao.getAllUser());
		int a=-1;
		while(a>=0){
			long ff=System.currentTimeMillis();
			//Add simple comment
			for(int i=300;i<500;i++){
				//dao.addComment(i, "f"+i, "fd"+i);
			}
			//Find a simple comment
			System.out.println(dao.getCommentById(1));

			//Get all comments
			System.out.println(dao.getAllComments().size());
			for(SimpleComment comment:dao.getAllComments()){
				System.out.println(comment);
			}
			System.out.println("Time Diff"+(ff-System.currentTimeMillis()));
			a--;
		}
	}

}
