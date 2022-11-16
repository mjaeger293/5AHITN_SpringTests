package htl.steyr.spring_tests.controller;

import htl.steyr.spring_tests.models.SchoolClass;
import htl.steyr.spring_tests.models.Student;
import htl.steyr.spring_tests.models.repositories.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/class")
public class SchoolClassController {

    @Autowired
    SchoolClassRepository classRepository;

    @PostMapping("/students")
    public Set<Student> getByClass(@RequestParam String schoolclass) { // HashMap<String, String> data //data.get("schoolclass")
        return classRepository.getSchoolClassByTitle(schoolclass).getStudents();
    }

    @PostMapping("/create")
    boolean createClass(@RequestParam String title) {
        // get all necessary params and create a new school class!
        SchoolClass schoolClass = new SchoolClass(title);
        classRepository.save(schoolClass);

        return schoolClass != null;
    }

    /**
     * @ToDo
     * Legen Sie eine Schulklasse an, indem Sie die Daten im RequestBody übergeben.
     */
    @PostMapping("/create2")
    boolean createSchoolClass(@RequestBody SchoolClass schoolClass ) {
        boolean success = false;

        schoolClass = classRepository.save(schoolClass);

        success = (schoolClass.getSchoolClass_id() > 0);

        return success;
    }
}
