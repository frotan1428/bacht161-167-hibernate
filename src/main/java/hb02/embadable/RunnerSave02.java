package hb02.embadable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {


        // create student object

        Student02 student1= new Student02();
        student1.setId(1001);
        student1.setName("Ali");
        student1.setGrade(90);

        Student02 student2= new Student02();
        student2.setId(1002);
        student2.setName("Naci");
        student2.setGrade(95);

        Student02 student3= new Student02();
        student3.setId(1003);
        student3.setName("Serhan");
        student3.setGrade(85);

        Student02 student4= new Student02();
        student4.setId(1004);
        student4.setName("Enes");
        student4.setGrade(80);

        //create address object

        Address address1= new Address();
        address1.setCountry("USA");
        address1.setCity("Dallas");
        address1.setStreet("Legacy");
        address1.setZipCOde("45678");

        Address address2= new Address();
        address2.setCountry("Venezuela");
        address2.setCity("Maracaibo");
        address2.setStreet("Rost");
        address2.setZipCOde("75025");

        Address address3= new Address();
        address3.setCountry("Turkiye");
        address3.setCity("istanbul");
        address3.setStreet("kadi koy");
        address3.setZipCOde("345689");

        Address address4= new Address();
        address4.setCountry("Afghanistan");
        address4.setCity("kabul");
        address4.setStreet("city mall");
        address4.setZipCOde("45678");

        //let add address to student

        student1.setAddress(address1);
        student2.setAddress(address2);
        student3.setAddress(address3);
        student4.setAddress(address4);

        //introducing configuration file and entity class to hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class).
                addAnnotatedClass(Address.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        tx.commit(); //without commit() data will not be sent to DB
        session.close();
        sf.close();






    }
}
