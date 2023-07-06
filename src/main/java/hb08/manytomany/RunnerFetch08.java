package hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //get student by id   with get method

        Student08 student1 = session.get(Student08.class,1002);
        System.out.println(student1);

        System.out.println(student1.getBookList());

        //get book by id with get method

         System.out.println("--------------------------------");

         Book08 book1=  session.get(Book08.class,103);
         System.out.println(book1);
         System.out.println(book1.getStudents());






        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
