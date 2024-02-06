import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;


public class HQLDelete 
{
	public static void main(String[] args) 
	{
	  	Session session = null;

	       try
	       {
	    	   SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    	   session =sessionFactory.openSession();
	           Transaction t=session.beginTransaction();
	           
	    	   	String hql="DELETE FROM contact c WHERE c.id = :id";
	    	
	    	Query query = session.createQuery(hql);
	    	query.setParameter(new String("id"),new Integer(1004));
	    	
	    	//int result=query.executeUpdate();
	    	int result=query.executeUpate();
	    	t.commit();
	    	System.out.println("Rows affected: " + result);
	    	   
		 	 session.close();
	 }
	 

	  
	  
	  catch(Exception e)
	  {
	    System.out.println("Message:"+e.getMessage());
	  }  
	  }
	

}
