package htl.steyr.spring_tests.models;

import javax.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long grade_id;

    @Column(name = "grade", nullable = false)
    private int grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Grade(int grade, Student student, Exam exam) {
        this.grade = grade;
        this.student = student;
        this.exam = exam;
    }

    public Grade() {
    }

    public long getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(long grade_id) {
        this.grade_id = grade_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
