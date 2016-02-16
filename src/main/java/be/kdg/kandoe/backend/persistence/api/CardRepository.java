package be.kdg.kandoe.backend.persistence.api;

import be.kdg.kandoe.backend.dom.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by J.P on 15/02/2016.
 */
public interface CardRepository extends JpaRepository<Card,Integer>, JpaSpecificationExecutor<Card>, CardRepositoryCustom{



}
