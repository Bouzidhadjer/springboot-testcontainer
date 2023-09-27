package bzd.springboot.springboot.controller;

import bzd.springboot.springboot.entity.Student;
import bzd.springboot.springboot.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private StudentRepository studentRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
