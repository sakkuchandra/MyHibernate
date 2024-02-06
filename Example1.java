import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Example1 
{
	
	  SessionFactory factory;
	  Session session;
	  Transaction transaction;
	  String name;
	  int id; 
	  
	  
	  public void MakeConnection()
	  {
	   try
	   {
		     factory=new Configuration().configure().buildSessionFactory();
		     session=factory.openSession();
		     transaction=session.beginTransaction();
		     //contact cona=(contact)session.load(contact.class,new Integer(10));
		     contact cona=(contact)session.get(contact.class,new Integer(10));
		     System.out.println(cona.getName());
		     System.out.print(cona.getId());
		 	 transaction.commit();
		 	 session.close();
	   }
	   catch(Exception ex)
	   {
	    System.out.print(ex.getMessage());
	   }
	  }
	  public static void main(String argv[])
	  {
	   Example1 ex=new Example1();
	   ex.MakeConnection();
	  }

}
