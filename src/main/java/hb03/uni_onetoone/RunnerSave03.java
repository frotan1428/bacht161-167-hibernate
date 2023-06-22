package hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {


        //create student object

        Student03 student1  = new Student03();
        student1.setId(1001);
        student1.setName("ALi");
        student1.setGrade(95);

        Student03 student2  = new Student03();
        student2.setId(1002);
        student2.setName("Naci");
        student2.setGrade(96);


        Student03 student3  = new Student03();
        student3.setId(1003);
        student3.setName("Serhan");
        student3.setGrade(80);

        //create a new Dairy Instance

        Dairy dairy1= new Dairy();
        dairy1.setId(101);
        dairy1.setName("Ali's Dairy");

        Dairy dairy2= new Dairy();
        dairy2.setId(102);
        dairy2.setName("Naci's Dairy");

        Dairy dairy3= new Dairy();
        dairy3.setId(103);
        dairy3.setName("Serhan 's Dairy");

        //set the student for the dairy

        dairy1.setStudent(student1);
        dairy2.setStudent(student2);
        dairy3.setStudent(student3);

        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Dairy.class);
        SessionFactory sf =con.buildSessionFactory();

        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();

        //save student object

        session.save(student1);
        session.save(student2);
        session.save(student3);

        //save dairy object
        
        session.save(dairy1);
        session.save(dairy2);
        session.save(dairy3);



        tx.commit();
        session.close();
        sf.close();





    }
}
