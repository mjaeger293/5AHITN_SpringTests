package htl.steyr.spring_tests.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exam_id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    /*
    @ManyToMany(mappedBy = "exams")
    Set<Student> students;
    */

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    private Set<Grade> grades;

    public Exam(String title, Subject subject) {
        this.title = title;
        this.subject = subject;
    }

    public Exam() {
    }

    public long getExam_id() {
        return exam_id;
    }

    public void setExam_id(long exam_id) {
        this.exam_id = exam_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
