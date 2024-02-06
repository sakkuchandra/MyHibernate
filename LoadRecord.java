import java.io.*;
import org.hibernate.cfg.*;
import org.hibernate.*;

public class LoadRecord
{
   SessionFactory sessionfactory;
   Session session;
   Criteria criteria;
   contact contact;
   Transaction transaction;
   
   
   public void CreateConnection()
   {
      try
	  {
	      sessionfactory=new Configuration().configure().buildSessionFactory();
		  session=sessionfactory.openSession();
		  transaction=session.beginTransaction();
		  try
		  {
		    contact=(contact)session.load(contact.class,new Integer(10));
			}
			catch(NullPointerException ex)
			{
			   //System.out.print("No Record Found in the database");
			   System.out.print(ex.getMessage());
			}   
		 
		  transaction.commit();
		  System.out.print("Name is :"+contact.getName());
		  System.out.print("Id is :"+contact.getId());
		     
		 //}
		  
          		 
	  }
	  catch(Exception exception)
	  {
	      //exception.printStackTrace();
		  }
   }
   public static void main(String argv[])
   {
       LoadRecord lr=new LoadRecord();
	   lr.CreateConnection();
   }
}