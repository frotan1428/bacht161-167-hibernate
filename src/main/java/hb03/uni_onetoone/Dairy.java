package hb03.uni_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "tbl_dairy")
public class Dairy {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn//in my dairy Table new column be added with default name "student_id"
    private Student03 student;//student_id

    /*
       @JoinColumn(): This annotation is used to specify the foreign key column
       that will be used to join the Dairy entity with the associated Student03 entity.
     */

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }


    //to string method()


    @Override
    public String toString() {
        return "Dairy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
