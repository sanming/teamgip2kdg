package be.kdg.kandoe.backend.dom;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * This is the card object that represents a possible choice of answers for a theme
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

    @Override
    public Integer getId() {
        return cardId;
    }
}
