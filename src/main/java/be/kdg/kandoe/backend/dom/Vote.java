package be.kdg.kandoe.backend.dom;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by J.P on 16/02/2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Vote")
public class Vote implements Serializable,Identifiable<Integer>{

    @Id
    @Column(name = "VoteId",nullable = false)
    @GeneratedValue
    private Integer voteId;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne(targetEntity = Card.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CardId")
    private Card card;

    @Column(name = "Round", nullable = false)
    private int round;

    @Column(name = "Timestamp", nullable = false)
    private LocalDateTime timestamp;

    public Vote() {
    }

    public Vote(User user, Card card, int round) {
        this.user = user;
        this.card = card;
        this.round = round;
        timestamp = LocalDateTime.now();
    }

    @Override
    public Integer getId() {
        return voteId;
    }
}
