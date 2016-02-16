package be.kdg.kandoe.backend.persistence.impl;

import be.kdg.kandoe.backend.persistence.api.CardRepository;
import be.kdg.kandoe.backend.persistence.api.CardRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Gobius on 16/02/2016.
 */


@Repository("cardRepository")
public class CardRepositoryImpl implements CardRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
}
