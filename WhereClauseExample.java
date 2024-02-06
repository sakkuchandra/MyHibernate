import org.hibernate.Session;
import org.hibernate.*;
import org.hibernate.cfg.*;

import java.util.*;

public class WhereClauseExample 
 {
  public static void main(String[] args) 
  {
  	Session session = null;

       try
       {
    	   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	   session =sessionFactory.openSession();
 
    	   System.out.println("*******************************");
    	   System.out.println("Query using Hibernate Query Language");

	 
    	   String hql="FROM contact c WHERE c.id = :id";
    	   Query query = session.createQuery(hql);
    	   query.setParameter("id",new Integer(1002));
    	   List results = query.list();
    	   Iterator it=results.iterator();
	 
    	   while(it.hasNext())
    	   {
    		   contact c=(contact)it.next();
    		   System.out.println(c.getName());
    		   System.out.println(c.getId());
    	   }
	 
    	   session.close();
 }
 

  
  
  catch(Exception e)
  {
    System.out.println(e.getMessage());
  }  
  }
}