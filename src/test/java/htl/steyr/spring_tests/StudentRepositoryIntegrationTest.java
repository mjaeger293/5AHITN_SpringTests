package htl.steyr.spring_tests;

import htl.steyr.spring_tests.models.SchoolClass;
import htl.steyr.spring_tests.models.Student;
import htl.steyr.spring_tests.models.repositories.SchoolClassRepository;
import htl.steyr.spring_tests.models.repositories.StudentRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest(classes = SpringTestsApplication.class)
@TestPropertySource(locations = "classpath:test.properties")
@ImportResource({"classpath*:application-context.xml"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryIntegrationTest {
    @Autowired
    SchoolClassRepository schoolClassRepository;

    @Autowired
    StudentRepository studentRepository;

    Student testStudent = null;

    @Test
    @Order(1)
    public void insertStudent() {
        Assertions.assertDoesNotThrow(() -> {
            SchoolClass schoolClass = new SchoolClass("3AHITN");
            testStudent = new Student("c", "b", new Date(), schoolClass);

            //schoolClassRepository.save(schoolClass);
            //studentRepository.save(testStudent);
        });
    }

    @Test
    @Order(2)
    public void getStudent() {
        Student student = studentRepository.findStudentByFirstnameAndLastname("c", "b");
        Assertions.assertEquals(testStudent.toString(), student.toString());
    }
}
