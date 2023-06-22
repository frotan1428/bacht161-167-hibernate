package hb04.bi_onetoone;


import hb03.uni_onetoone.Dairy;

import javax.persistence.*;

@Entity
@Table(name = "tbl_student04")
public class Student04 {

    @Id
    private int id;

    @Column(name = "std_name",length = 100,nullable = false)
    private String name;

    private int grade;

    /*
     Student04 class has a @OneToOne annotation with the mappedBy attribute,
    which refers to the student attribute in the Dairy04 class.
    This establishes the bidirectional relationship, where the Student04 class is the inverse side.
     */

    @OneToOne(mappedBy = "student")//mappedBy attributes will not create any column in student
    //instead it will use the column from dairy class which name as "student"
    private Dairy04 dairy;

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

    public Dairy04 getDairy() {
        return dairy;
    }

    public void setDairy(Dairy04 dairy) {
        this.dairy = dairy;
    }

    //To string method

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//                ", dairy=" + dairy +// delete comment to avoid stack overFlow
                '}';
    }

    /*
Note: To avoid a stack overflow error in the toString() method of the Student04 class,
it's recommended to remove the dairy attribute from the string representation

 */
}
