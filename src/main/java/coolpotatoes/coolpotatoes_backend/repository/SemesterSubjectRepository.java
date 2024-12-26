package coolpotatoes.coolpotatoes_backend.repository;

import coolpotatoes.coolpotatoes_backend.entity.SemesterSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterSubjectRepository extends JpaRepository<SemesterSubject, Long> {

}
