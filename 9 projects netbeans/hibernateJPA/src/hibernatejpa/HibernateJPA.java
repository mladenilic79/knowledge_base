package hibernatejpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.HibernateException;

public class HibernateJPA {

    public static void main(String[] args) {
        
        try{
            
            Userlist prijavljeniKorisnik = null;
            String ime = "sima";
            String loz = "sima";
            int id = 22;
            String poruka = "porukabre";

            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "basicdb" );
            EntityManager em = emfactory.createEntityManager( );
            // or
//            EntityManager em = Persistence.createEntityManagerFactory("basicdb").createEntityManager();
            em.getTransaction( ).begin( );


            // login
            Query query1 = em.createNamedQuery("Userlist.findByUserlistUsername");
            query1.setParameter("userlistUsername", ime);
            try {
                Userlist user = (Userlist) query1.getSingleResult();
                if (user == null) {
                    System.out.println("nepostojeci korisnik");
                }
                if (user.getUserlistPassword().equals(loz)) {
                    prijavljeniKorisnik = user;
                    System.out.println("uspesna prijava");
                } else {
                    System.out.println("neispravna lozinka");
                }
            } catch (NoResultException nre) {
                System.out.println("nepostojeci korisnik");
            }


            // insert
            Advancedcrud poruka2 = new Advancedcrud();
            poruka2.setAdvRandomdata(poruka);
            poruka2.setAdvFkUsernameId(prijavljeniKorisnik);
            em.persist(poruka2);
            

            // select by id
            // transaction begin & commit are not needed for selecting/finding
            Advancedcrud poruka3 = (Advancedcrud) em.find(Advancedcrud.class, id);
            System.out.println(poruka3.getAdvRandomdata());
        
            
            // update by id
            Advancedcrud poruka4 = (Advancedcrud) em.find(Advancedcrud.class, id);
            poruka4.setAdvRandomdata(poruka);
            poruka4.setAdvFkUsernameId(prijavljeniKorisnik);
      
            
            // delete by id
            Advancedcrud poruka5 = em.find( Advancedcrud.class, id );
            em.remove( poruka5 );
        
            
            /*
            JPQL (java persistance query language)
            SELECT ... FROM ...
            [WHERE ...] (beetween, and, like.. inside where)
            [GROUP BY ... [HAVING ...]]
            [ORDER BY ...]

            DELETE FROM ... [WHERE ...] (beetween, and, like.. inside where)
 
            UPDATE ... SET ... [WHERE ...] (beetween, and, like.. inside where)
            */

          
            // select all (named query)
            // cast upfront
            Query query6 = em.createNamedQuery("Advancedcrud.findAll");
            List<Advancedcrud> poruke6 = (List<Advancedcrud>) query6.getResultList();
            for (Advancedcrud poruka6 : poruke6) {
                System.out.println("named cast" + poruka6.getAdvRandomdata());
            }


            // select all (regular query)
            // cast during iteration
            // must use aliases
            Query query7 = em.createQuery("select ac from Advancedcrud ac");
            List lista = query7.getResultList();
            for (Object obj : lista) {
                Advancedcrud poruka7 = (Advancedcrud) obj;
                System.out.println("aliases iteration" + poruka7.getAdvRandomdata());
            }

        
            // update
            Query query8 = em.createQuery("update Advancedcrud ac set ac.advRandomdata "
                    + "= 'nova poruka' where ac.id = 22");
            int numOfRows = query8.executeUpdate();

            
            // delete
            Query query9 = em.createNamedQuery("Advancedcrud.findById");
            query9.setParameter("id", id);
            Advancedcrud poruka9 = (Advancedcrud) query9.getSingleResult();
            em.remove(poruka9);


            em.getTransaction().commit();
            em.close( );
            emfactory.close( );
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            System.exit(0);
        }

    }

}
