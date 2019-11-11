
package hibernatexml;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class HibernateXML {

    public static void main(String[] args) {
        
        try {
            Scanner scStr = new Scanner(System.in);
            Scanner scInt = new Scanner(System.in);
            
            Userlist prijavljeniKorisnik = null;
            String ime = "sima";
            String lozinka = "sima";
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            // or session.beginTransaction();
            

            // login (retrieve user objects)
            Query query = session.createQuery("from Userlist where userlistUsername = :user");
            query.setParameter("user", ime);
            List result = query.list();
            Userlist user = (Userlist) result.get(0);
            if (user.getUserlistPassword().equals(lozinka)) {
                prijavljeniKorisnik = user;
            }
            System.out.println("prosao login " + user.getUserlistUsername() + " je " + user.getUserlistSex() + prijavljeniKorisnik.getUserlistUsername() + prijavljeniKorisnik.getUserlistSex());
            System.out.println("");


            // select elements
            Query query1 = session.createQuery("select advRandomdata from Advancedcrud");
            List result1 = query1.list();
            for (Object obj : result1) {
                System.out.println(obj);
            }

            
            // select objects
            Query query2 = session.createQuery("from Advancedcrud");
            List result2 = query2.list();
            for (Object object : result2) {
                if (object instanceof Advancedcrud) {
                    Advancedcrud message = (Advancedcrud)object;
                    System.out.println(message.getAdvRandomdata());
                }
            }
            

            // select lists of objects
            Query query3 = session.createQuery("from City");
            List result3 = query3.list();
            for (Object object : result3) {
                City city = (City)object;
                System.out.println(city.getCityName());
                for(Object element : city.getUserlists()) {
                    Userlist user1 = (Userlist)element;
                    System.out.println("   user: " + user1.getUserlistUsername());
                }
            }


            // select by id
            // get object on specified id, returns null if doesn't exists
            Advancedcrud message1 = (Advancedcrud) session.get(Advancedcrud.class, 20);
            // get object on specified id, returns exception if doesn't exists
            Advancedcrud message2 = (Advancedcrud) session.load(Advancedcrud.class, 21);

            
            // insert
            Advancedcrud newMessage = new Advancedcrud();
            newMessage.setAdvRandomdata("nova poruka");
            newMessage.setUserlist(prijavljeniKorisnik);
            session.save(newMessage);
            // or
//            session.persist(newMessage);


            // update single entry
            Advancedcrud updateMessage = (Advancedcrud) session.get(Advancedcrud.class, 20);
            updateMessage.setAdvRandomdata("mirodjija");
            session.update(updateMessage);
            
            
            // delete
            Advancedcrud deleteMessage = (Advancedcrud) session.get(Advancedcrud.class, 55);
            session.delete(deleteMessage);


            // sql select
            SQLQuery sqlQuery = session.createSQLQuery("select * from Advancedcrud");
            List<Object[]> resultset = sqlQuery.list();
            for (int i=0; i<resultset.size(); i++) {
                for (int j=0; j<resultset.get(i).length; j++) {
                    System.out.println(resultset.get(i)[j] + " ");
                }
                System.out.println("kraj");
            }
        

            /*
            // for testing
            // update
            Query query8 = session.createQuery("update City set City.city_name = 'beograd' where City.id = 45");
            int broj = query8.executeUpdate();
            // delete
            Query query = session.createQuery("delete from Book book where book.id = 3");
            int brojObrisanih = query.executeUpdate();
            */

            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            System.exit(0);
        }
        
    }
    
}
