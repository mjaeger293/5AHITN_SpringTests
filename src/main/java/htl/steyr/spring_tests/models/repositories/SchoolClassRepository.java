package htl.steyr.spring_tests.models.repositories;

import htl.steyr.spring_tests.models.SchoolClass;
import htl.steyr.spring_tests.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    @Query("SELECT DISTINCT s FROM SchoolClass sc " +
            "INNER JOIN Student s ON s.schoolClass = sc " +
            "INNER JOIN Grade g ON s = g.student " +
            "WHERE g.grade = 5 AND sc = ?1")
    List<Student> findAllStudentsWithFailedExams(SchoolClass sc);

    // Error with mapping
    /*@Query(value = "SELECT DISTINCT s.* FROM school_class sc " +
            "INNER JOIN student s ON (sc.school_class_id = s.schoolclass_id) " +
            "INNER JOIN grade g ON (s.student_id = g.student_id) " +
            "WHERE g.grade >= 5 AND sc.school_class_id = ?1", nativeQuery = true)
    List<Student> getFailedStudentsByClassId(long classId);*/

    SchoolClass getSchoolClassByTitle(String title);
}
