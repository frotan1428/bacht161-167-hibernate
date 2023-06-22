package hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class)
                .addAnnotatedClass(Dairy04.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //get student and dairy by id using get() method ..

        System.out.println("********************** get student and Dairy by Id using get() method ******************");

        Student04 student1 =  session.get(Student04.class,1001);
        System.out.println(student1);

        System.out.println("-------------------------------");
        Dairy04 dairy1 = session.get(Dairy04.class,101);
        System.out.println(dairy1);

        System.out.println("********************** get dairy object over student  ******************");
        System.out.println(student1.getDairy());

        System.out.println("********************** get student  object over dairy  ******************");
        System.out.println(dairy1.getStudent());

        System.out.println("********************** get student name  through dairy object  ******************");
        System.out.println(dairy1.getStudent().getName());





        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();
    }
}
