package hb02.embadable;

import javax.persistence.*;

@Entity
@Table(name = "tbl_student02")
public class Student02 {

    @Id
    private int id;

    @Column(name = "student_name",length = 100,nullable = false,unique = true)
    private String name;

    private int grade;

    @Embedded// this is optional
    private Address address;



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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // to String method

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//                ", address=" + address +
                '}';
    }

}
