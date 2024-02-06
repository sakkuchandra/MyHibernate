import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import java.util.Iterator;

public class criteria 
{
	Session session;
	Transaction transaction;
	SessionFactory sessionfactory;
	Criteria criteria;
	
	
	 public void MakeConnection()
	  {
	   try
	   {
		     sessionfactory=new Configuration().configure().buildSessionFactory();
		     session=sessionfactory.openSession();
		     transaction=session.beginTransaction();
		     
		     criteria=session.createCriteria(contact.class);
		     criteria.add(Restrictions.eq("id",new Integer(1002)));
	  	     List list=criteria.list();
	  	     Iterator ir=list.iterator();
	         while(ir.hasNext())
	         {
	    	   contact cn=(contact)ir.next();
	    	   System.out.println(cn.getId());
	    	   System.out.println(cn.getName());
	  	   }


	  }
	  catch(Exception ex)
	  {
	   System.out.print(ex.getMessage());
	  }
	  }
	  public static void main(String argv[])
	  {
	   criteria cr=new criteria();
	   cr.MakeConnection();
	  }

}