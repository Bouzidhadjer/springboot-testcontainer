package bzd.springboot.springboot;

import bzd.springboot.springboot.entity.Student;
import bzd.springboot.springboot.repository.StudentRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class SpringbootTestcontainersDemoApplicationTests  extends  AbstractContainerBaseTest{


	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private MockMvc mockMvc;

	// given /when/then format - BDD style
	@Test
	public void  givenStudents_whenGetAllStudents_thenListOfStudents() throws Exception {

		// given -setup or precondition

		List<Student> students = List.of(Student.builder().firstName("Hadjer").lastName("Bouzid")
				.email("bouzidhadjer34@gmail.com").build(),
				Student.builder().firstName("Hadjer1").lastName("Bouzid1")
						.email("bouzidhadjer134@gmail.com").build()
				);
		studentRepository.saveAll(students);

	   // when -action
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/students"));

	 // then - verify the output

		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(students.size())));

	}

}
