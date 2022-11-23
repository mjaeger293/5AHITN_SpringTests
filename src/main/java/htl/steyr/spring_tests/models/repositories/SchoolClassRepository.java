package htl.steyr.spring_tests.models.repositories;

import htl.steyr.spring_tests.models.SchoolClass;
import htl.steyr.spring_tests.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    SchoolClass getSchoolClassByTitle(String title);
}
