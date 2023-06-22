package hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {

    public static void main(String[] args) {


        //introducing configuration file and entity class to hibernate
        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);
        SessionFactory sf= con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

         /*
            Inorder to fetch data from DB, there are 3 ways
                1. get();
                2. SQL query
                3. HQL query
         */

        //===============1st way : get() ================
/*
        Student01 student1= session.get(Student01.class,1001);
        Student01 student2= session.get(Student01.class,1002);
        Student01 student3= session.get(Student01.class,1003);
        Student01 student4= session.get(Student01.class,1004);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

 */

        //===============2nd  way : SQL Query  ================

        String sqlQuery="SELECT * FROM tbl_student";
        List<Object[]>  resultList1 = session.createSQLQuery(sqlQuery).getResultList();

        for (Object[] std:resultList1) {
            System.out.println(Arrays.toString(std));
        }

        System.out.println("---------------------------------------------");

        //===============3th  way : HQL Query  ================

        String hqlQuery="FROM Student01";

       List<Student01>   resultList2 = session.createQuery(hqlQuery, Student01.class).getResultList();

        for (Student01 std: resultList2) {
            System.out.println(std);

        }

        System.out.println("---------------------------------------------");

        // if you want to fetch some unique data using sql
        //get student name from table Where name "ALi"

        String sqlQuery2="SELECT * FROM tbl_student WHERE std_name = 'Ali' "; // LIKE laso can be use.
        Object[] studentAli   = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(studentAli));
        System.out.println("---------------------------------------------");
        System.out.println(studentAli[0]+ " "+studentAli[1] +" " +studentAli[2]);



        System.out.println("---------------------------------------------");
        // if you want to fetch some unique data using hql

        String hqlQuery2= "FROM Student01 s WHERE s.name ='Ali' ";
        Student01 std= session.createQuery(hqlQuery2,Student01.class).uniqueResult();
        System.out.println(std);

        //if you want to fetch students whose id is less 1003 using hql
        System.out.println("---------------------------------------------");

        String hqlQuery3= "SELECT s.name , s.id FROM  Student01 s WHERE s.id<1003";
        List<Object[]>  resultList3 =  session.createQuery(hqlQuery3).getResultList();
        resultList3.forEach(x-> System.out.println(Arrays.toString(x)));



        tx.commit();//without this commit() data will not sent to Db
        session.close();
        sf.close();

    }
}
