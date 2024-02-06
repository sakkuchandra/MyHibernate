import java.io.*;
import java.util.*;
//import java.util.Iterator;
//import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Restrictions;

public class Example 
{
  SessionFactory factory;
  Session session;
  Transaction transaction;
  Criteria criteria;
  BufferedReader buffered;   
  InputStreamReader i;
  String name;
  int id; 
  
  public void MakeConnection()
  {
   try
   {
     //i=new InputStreamReader(System.in); 
     //buffered=new BufferedReader(i);
	 Scanner s=new Scanner(System.in);
     System.out.println("Enter the name");
     name=s.nextLine(); 
     System.out.println("Enter the id");
     id=s.nextInt(); 
     contact cont=new contact();
	 cont.setName(name);
     cont.setId(id);
     /*hibernate code started here*/
	 factory=new Configuration().configure().buildSessionFactory();
     session=factory.openSession();
     transaction=session.beginTransaction();
     session.save(cont);
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
   Example ex=new Example();
   ex.MakeConnection();
  }
}
