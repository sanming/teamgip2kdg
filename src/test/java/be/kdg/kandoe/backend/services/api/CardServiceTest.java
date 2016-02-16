package be.kdg.kandoe.backend.services.api;

import be.kdg.kandoe.backend.config.BackendContextConfig;
import be.kdg.kandoe.backend.dom.Card;
import be.kdg.kandoe.backend.dom.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
/**
 * Created by claudiu on 15/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BackendContextConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CardServiceTest {

    @Autowired
    private CardService cardService;

    @Autowired
    private UserService userService;

    private User user;
    @Before
    public void before(){
        //user = userService.getAllUsers().get(0);
    }

    @Test
    public void testCreateCard() throws Exception{
        Card c = cardService.createCard(1,"name","description");
        assertThat(cardService.getCards(), hasItem(c));
    }

    @Test
    public void testCreateCSVCard() throws Exception{
        String csv = "kaartnaam,";
        List<Card> cards = cardService.createCardsFromCSV(user.getId(),csv);

        assertThat(cardService.getCards(),contains(cards));
    }

    @Test
    public void testUpdateCard() throws Exception{
        Card c = cardService.createCard(user.getId(),"name","description");

        c.setScore(c.getScore()+1);
        cardService.updateCard(c);
        assertThat(cardService.getCardById(c.getCardId()), equalTo(c));
    }
    public void testDeleteCard() throws Exception{
        Card c = cardService.createCard(user.getId(),"name","description");

    }


}
