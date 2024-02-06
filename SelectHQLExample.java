import org.hibernate.*;
import org.hibernate.cfg.*;

import java.util.*;

public class SelectHQLExample 
{

  public static void main(String[] args) 
  {
     Session session = null;

    try
    {
   
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	session =sessionFactory.openSession();
        String SQL_QUERY ="from contact";
        Query query = session.createQuery(SQL_QUERY);
       for(Iterator it=query.iterate();it.hasNext();)
       {
             contact ct=(contact)it.next();
             System.out.println("Name: " + ct.getName());
             System.out.println("Id: " + ct.getId());
 }
 
  session.close();
}
    catch(Exception e)
    {
  System.out.println(e.getMessage());
}
    finally
    {
  }

  }  
}
