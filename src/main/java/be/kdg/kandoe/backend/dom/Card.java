package be.kdg.kandoe.backend.dom;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * This is the card object that represents a possible choise of anwsers for a theme
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Card")
public class Card implements Serializable, Identifiable<Integer>{

    @Column(name = "CardId", nullable = false)
    @Id
    @GeneratedValue
    private Integer cardId;

    @Column(name = "CardName",nullable = false, length = 20)
    private String cardName;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "ImageUrl", nullable = true)
    private String imageUrl;

    @Column(name = "Score",nullable = false)
    private int score;

    @OneToMany(targetEntity = Vote.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "card")
    private List<Vote> votes;

    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Theme.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ThemeId")
    private Theme theme;

    @ManyToOne(targetEntity = Circle.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "CirleId")
    private Theme circle;

    public Card() {
    }

    public Card(String cardName, String description) {
        this.cardName = cardName;
        this.description = description;
        score = 0;
    }

    public Card(String cardName, String description, String imageUrl) {
        this.cardName = cardName;
        this.description = description;
        this.imageUrl = imageUrl;
        score = 0;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Theme getCircle() {
        return circle;
    }

    public void setCircle(Theme circle) {
        this.circle = circle;
    }

    @Override
    public Integer getId() {
        return cardId;
    }
}
