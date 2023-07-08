package hb013.getandloadMethod;

import hb012.cashing.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {


    Student13 student1= new Student13();
    student1.setName("Tuba");
    student1.setGrade(96);

    Student13 student2= new Student13();
    student2.setName("Yasar");
    student2.setGrade(90);

    Student13 student3= new Student13();
    student3.setName("Tajala");
    student3.setGrade(98);




        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();
    }
}
