package htl.steyr.spring_tests.models.repositories;

import htl.steyr.spring_tests.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
