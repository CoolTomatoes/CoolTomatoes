package coolpotatoes.coolpotatoes_backend.repository;

import coolpotatoes.coolpotatoes_backend.entity.DailySubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailySubjectRepository extends JpaRepository<DailySubject, Long> {

}
