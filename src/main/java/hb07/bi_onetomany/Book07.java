package hb07.bi_onetomany;


import javax.persistence.*;

@Entity
@Table(name = "tbl_book07")
public class Book07 {


    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "std_id")
    private Student07 student;


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

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    //to String  Method


    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", student=" + student +
                '}';
    }


    public Book07(int id, String name ) {
        this.id = id;
        this.name = name;
    }

    public Book07() {
    }
}
