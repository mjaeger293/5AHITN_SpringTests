package htl.steyr.spring_tests.models.repositories;

import htl.steyr.spring_tests.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
