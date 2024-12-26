package coolpotatoes.coolpotatoes_backend.repository;

import coolpotatoes.coolpotatoes_backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long> {

}
