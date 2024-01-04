package com.dajungdagam.dg.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
public class Wishlist {
    @Id
    @GeneratedValue
    @Column(name = "wishlist_id")
    private Long id;


    @OneToMany
    @Setter
    @Getter
    @JsonManagedReference
    private List<TradePost> tradePosts;

    @Column
    private LocalDateTime createdTime;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="user_id")

    private User user;


    public void addTradePost(TradePost tradePost){
        tradePosts.add(tradePost);
    }

    @Builder
    public Wishlist(Long id, List<TradePost> tradePosts, LocalDateTime createdTime, User user) {
        this.id = id;
        this.tradePosts = tradePosts;
        this.createdTime = createdTime;
        this.user = user;
    }

    public Wishlist(User user) {
        this.user = user;
    }

    public Wishlist() {

    }
}
