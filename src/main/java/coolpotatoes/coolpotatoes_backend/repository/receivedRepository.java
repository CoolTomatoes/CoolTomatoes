package coolpotatoes.coolpotatoes_backend.repository;

import coolpotatoes.coolpotatoes_backend.entity.Received;
import org.springframework.data.jpa.repository.JpaRepository;

public interface receivedRepository extends JpaRepository <Received, Long> {

}
