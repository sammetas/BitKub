package com.bitkub.service.BitKub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/bitkub")

public class BitkubTickerRestController {
    HashMap<String ,Coin> coinMap= new HashMap<>();
    @Autowired
    private  BitkubTickerService service;


    @RequestMapping("/ticker/{coin}")
    public HashMap getAllCoinsDetails(@PathVariable("coin") String coin){
        System.out.println("coin---------------->"+coin);

        BitkubCoins bitkubCoins=this.service.getBitkubTickerDetails(coin);
        if(bitkubCoins.getCoins().size()>0)
           coinMap.put(coin,bitkubCoins.getCoins().get(0));

       return coinMap               ;

    }



}
