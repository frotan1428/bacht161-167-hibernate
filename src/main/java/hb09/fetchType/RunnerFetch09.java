package hb09.fetchType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //get students using get method ()


        Student09 student1=    session.get(Student09.class,1001);
       // System.out.println(student1);


        //get book using get method ()

//          Book09 book1=   session.get(Book09.class,102);
////            for (Book09 book2: student1.getBookList()){
////                System.out.println(book2);
////            }



        tx.commit();
        session.close();

        for (Book09 book3: student1.getBookList()){
            System.out.println(book3);
        }
        sessionFactory.close();
    }
}
