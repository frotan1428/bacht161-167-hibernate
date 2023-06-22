package hb01.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//this class is used to store objects to database
public class RunnerSave01 {

    public static void main(String[] args) {

        //create some object from Student01  to store in to table

        Student01 student1= new Student01();
        student1.setId(1001);
        student1.setName("Ali");
        student1.setGrade(90);

        Student01 student2= new Student01();
        student2.setId(1002);
        student2.setName("Serhan");
        student2.setGrade(95);

        Student01 student3= new Student01();
        student3.setId(1003);
        student3.setName("Tuba");
        student3.setGrade(86);

        Student01 student4= new Student01();
        student4.setId(1004);
        student4.setName("Enes");
        student4.setGrade(86);



        //introducing configuration file and entity class to hibernate
        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);
       SessionFactory sf= con.buildSessionFactory();
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();

           session.save(student1);
           session.save(student2);
           session.save(student3);
           session.save(student4);




        tx.commit();//without this commit() data will not sent to Db
        session.close();
        sf.close();
    }
}
