package htl.steyr.spring_tests;

import htl.steyr.spring_tests.models.SchoolClass;
import htl.steyr.spring_tests.models.Student;
import htl.steyr.spring_tests.models.repositories.SchoolClassRepository;
import htl.steyr.spring_tests.models.repositories.StudentRepository;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryIntegrationTest {
    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Autowired
    StudentRepository studentRepository;

    Student testStudent = null;

    @Order(1)
    @Test
    public void insertStudent() {
        Assertions.assertDoesNotThrow(() -> {
            SchoolClass schoolClass = new SchoolClass("3AHITN");
            testStudent = new Student("Daniel", "Lehrling", new Date(), schoolClass);

            schoolClassRepository.save(schoolClass);
            studentRepository.save(testStudent);
        });
    }

    @Order(2)
    @Test
    public void getStudent() {
        Student student = studentRepository.findStudentByFirstnameAndLastname("Daniel", "Lehrling");
        Assertions.assertEquals(testStudent.toString(), student.toString());
    }
}
