package hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Dairy.class);
        SessionFactory sf =con.buildSessionFactory();

        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();

        System.out.println("*********************** using get() fetch the student ****************");
        Student03 student1=  session.get(Student03.class,1002);
        System.out.println(student1);

        System.out.println("*********************** using get() fetch the Dairy ****************");

        Dairy dairy1= session.get(Dairy.class,101);
        System.out.println(dairy1);
        System.out.println("*********************** using get() fetch the student from dairy ****************");
        System.out.println(dairy1.getStudent());



        tx.commit();
        session.close();
        sf.close();
    }
}
