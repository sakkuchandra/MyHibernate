import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HQLUpdate 
{
	public static void main(String[] args) 
	{
	  	Session session = null;

	       try
	       {
	    	   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    	   session =sessionFactory.openSession();
	    	   
	    	   
	     	   String hql="update contact c set c.name=:name where c.id=:id";
	     	   Transaction t=session.beginTransaction();
	    	   Query query = session.createQuery("update contact c set c.name= :name where c.id= :id");
	     	   
	     	   //Query query = session.createQuery(hql);
	    	   query.setParameter("name","laxmi");
	    	   query.setParameter("id",new Integer(1004));
	    	
	    	   int result=query.executeUpate();
	    	   t.commit();
	    	   System.out.println("Rows affected: " + result);
	    	   //session.save();
	    	   
		 	 session.close();
	 }
	 

	  
	  
	  catch(Exception e)
	  {
	    System.out.println(e.getMessage());
	  }  
	  }
	

}
