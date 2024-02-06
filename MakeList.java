import java.io.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class MakeList
{
   SessionFactory sessionfactory;
   Session session;
   Criteria criteria;
   Transaction transaction;
   contact contact;
   List list;
   Iterator iterator;
   
   public void MakeConnection()
   {
      try
	  {
	      sessionfactory=new Configuration().configure().buildSessionFactory();
		  session=sessionfactory.openSession();
		  transaction=session.beginTransaction();
		  criteria=session.createCriteria(contact.class);
		  list=criteria.list();
		  iterator=list.iterator();
		  while(iterator.hasNext())
		  {
		     contact=(contact)iterator.next();
			 System.out.println(contact.getName()+"  "+contact.getId());
			 //System.out.println(contact.getId());
		  }
	  }
	  catch(Exception ex)
	  { 
	       System.out.print(ex.getMessage());
	  }
   }
   public static void main(String argv[])
   {
      MakeList ml=new MakeList();
	  ml.MakeConnection();
   }
}