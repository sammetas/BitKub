package com.bitkub.service.BitKub;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BitkubCoins {

    List<Coin> coins= new ArrayList<>();

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public  void  addCoin(Coin coin) {
        this.coins.add(coin);
    }


}


