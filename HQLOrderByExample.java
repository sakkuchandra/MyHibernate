import org.hibernate.Session;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class HQLOrderByExample 
{
  public static void main(String[] args) 
  {
  	Session session = null;
  try
  {
 	 SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	 session = sessionFactory.openSession();
	  String SQL_QUERY="from contact as c order by c.id";
        Query query=session.createQuery(SQL_QUERY);
	   for (Iterator it= query.iterate(); it.hasNext();)
	   {
	      contact ct = (contact) it.next();
	      System.out.println("ID: " + ct.getId());
	     System.out.println("Name:"+ct.getName());
	  }

	  session.close();
  }

  
  catch (Exception e) 
  {
  System.out.println(e.getMessage());
  } finally {
  }
  }
}
