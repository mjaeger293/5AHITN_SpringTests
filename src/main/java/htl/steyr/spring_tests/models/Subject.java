package htl.steyr.spring_tests.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subject_id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private Set<Exam> exams;

    public Subject(String title) {
        this.title = title;
    }

    public Subject() {
    }

    public long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(long subject_id) {
        this.subject_id = subject_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
}
