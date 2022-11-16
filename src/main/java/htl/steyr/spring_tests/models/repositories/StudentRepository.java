package htl.steyr.spring_tests.models.repositories;

import htl.steyr.spring_tests.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByFirstnameAndLastname(String firstname, String lastname);

    Student findOneStudentByFirstnameAndLastname(String firstname, String lastname);

    List<Student> findBySchoolClassTitle(String title);
}
