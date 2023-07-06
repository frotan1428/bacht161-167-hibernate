package hb08.manytomany;

import hb07.bi_onetomany.Book07;
import hb07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {
    public static void main(String[] args) {

        //create student object

        Student08 student1= new Student08();
        student1.setId(1001);
        student1.setName("Naci");
        student1.setGrade(95);

        Student08 student2= new Student08();
        student2.setId(1002);
        student2.setName("Ali");
        student2.setGrade(96);

        Student08 student3= new Student08();
        student3.setId(1003);
        student3.setName("Serhan");
        student3.setGrade(80);


        //create book Object

        Book08 book1= new Book08();
        book1.setId(101);
        book1.setName("Math Book");

        Book08 book2= new Book08();
        book2.setId(102);
        book2.setName("Chemistry Book");

        Book08 book3= new Book08();
        book3.setId(103);
        book3.setName("Java Book");

        Book08 book4= new Book08();
        book4.setId(104);
        book4.setName("Hibernate  Book");

        Book08 book5= new Book08();
        book5.setId(105);
        book5.setName("Jdbc  Book");


        //set books for Students

        student1.getBookList().add(book1);
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);
        student2.getBookList().add(book4);

        student3.getBookList().add(book5);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).
                addAnnotatedClass(Book08.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //save students
        session.save(student1);
        session.save(student2);
        session.save(student3);

        //save books

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);





        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
