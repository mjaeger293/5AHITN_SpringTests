package htl.steyr.spring_tests.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "school_class")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long schoolClass_id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    private Set<Student> students;

    public SchoolClass(String title) {
        this.title = title;
    }

    public SchoolClass() {
    }

    public long getSchoolClass_id() {
        return schoolClass_id;
    }

    public void setSchoolClass_id(long schoolClass_id) {
        this.schoolClass_id = schoolClass_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return title;
    }
}
