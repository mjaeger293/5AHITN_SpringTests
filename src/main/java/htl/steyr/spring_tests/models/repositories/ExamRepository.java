package htl.steyr.spring_tests.models.repositories;

import htl.steyr.spring_tests.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
