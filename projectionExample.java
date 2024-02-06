import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class projectionExample 
{

  public static void main(String[] args) 
  {
  
  
  Session sess = null;
  try
  {
  SessionFactory sfact = new 
  Configuration().configure().buildSessionFactory();
  sess=sfact.openSession();
  Criteria crit = sess.createCriteria(contact.class);
  ProjectionList proList = Projections.projectionList();
  proList.add(Projections.property("name"));
  proList.add(Projections.property("id"));
  crit.setProjection(proList);
  List list = crit.list();
  Iterator it = list.iterator();
  if(!it.hasNext()){
  System.out.println("No any data!");
  }
  else
  {
     while(it.hasNext()){
     Object[] row = (Object[])it.next();
     for(int i = 0; i < row.length;i++){
     System.out.print(row[i]);
     System.out.println();
  }
  }
  }
  sess.close();
  }
  catch(Exception e)
  {
     System.out.println(e.getMessage());
  }

  }

}