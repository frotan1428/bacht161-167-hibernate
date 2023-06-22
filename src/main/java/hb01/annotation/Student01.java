package hb01.annotation;

import javax.persistence.*;

@Entity//this class will mapped to table

@Table(name = "tbl_student")
public class Student01 {//default name of the table wil be "student01"

    @Id// the field inder @id will be primary key in to table
    private  int id;

    @Column(name = "std_name" ,length = 100,nullable = false,unique = true)
    private String name;//by default variable name will be column name

   // @Transient//this field will not added to the table
    private int grade;

//    @Lob//large object
//    private byte[] image;

    //getter and setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //to string method


    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
