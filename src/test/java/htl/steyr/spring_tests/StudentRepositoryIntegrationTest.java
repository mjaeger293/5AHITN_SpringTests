package htl.steyr.spring_tests;

import htl.steyr.spring_tests.models.Student;
import htl.steyr.spring_tests.models.repositories.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = SpringTestsApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:test.properties")
public class StudentRepositoryIntegrationTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void findStudentsByFirstnameAndLastnameTest() {
        Student student = new Student("Fabian", "Höfler", new Date(), null);
        student = studentRepository.save(student);

        Assertions.assertEquals(student, studentRepository.findById(student.getStudent_id()));
    }
}
