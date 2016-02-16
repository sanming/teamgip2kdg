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
        user = userService.getAllUsers().get(0);
    }

    @Test
    public void testCreateCard() throws Exception{
        Card c = cardService.createCard(user.getId(),"newcard");
        assertThat(cardService.getCards(), hasItem(c));
    }
    @Test
    public void testUpdateCard() throws Exception{
        Card c = cardService.createCard(user.getId(),"newcard");

        c.setScore(c.getScore()+1);
        cardService.updateCard(c);
        assertThat(cardService.getCardById(c.getCardId()), equalTo(c));
    }
    @Test
    public void testGetThemeCards() throws Exception{
        Card c = cardService.createCard(user.getId(),"newcard");

        assertThat(cardService.getCardsByTheme(), hasItem(c));
    }

}
