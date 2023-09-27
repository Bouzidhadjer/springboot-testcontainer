package bzd.springboot.springboot.repository;

import bzd.springboot.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
}