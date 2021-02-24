package com.bitkub.service.BitKub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
@RefreshScope
public class BitkubTickerService {

   @Autowired
   private RestTemplate restTemplate;
   @Autowired
   private  URLValues urlValues;
   //@Autowired
   //private Configuration urlValues;
   public BitkubCoins getBitkubTickerDetails(String coin){
       BitkubCoins b = new BitkubCoins();
       System.out.println("urlValuesurlValues"+urlValues.getUrl());
       System.out.println("urlValuesurlValues"+urlValues.message);
       ResponseEntity<String> response=getTicker(coin); // bitkut ticker call
       if(response.getStatusCode()== HttpStatus.OK) {

           try {
               b.addCoin(getCoinDetails(coin, response));
           } catch (JsonProcessingException e) {
               e.printStackTrace();
           }


           return b;
       }

       return b;

   }

   private Coin getCoinDetails(String coin, ResponseEntity<String> response) throws JsonProcessingException {
       Coin c= new Coin();
      ObjectMapper mapper = new ObjectMapper();
      JsonNode root = mapper.readTree(response.getBody());

        JsonNode cointDetails = root.get(coin);
         if(!cointDetails.isEmpty()){

             JsonNode lastRate = cointDetails.get(BitConstants.LAST);
             JsonNode change = cointDetails.get(BitConstants.CHANGE);
             JsonNode highestBid = cointDetails.get(BitConstants.HIGH_BID);
             JsonNode lowestAsk = cointDetails.get(BitConstants.LOW_ASK);
             JsonNode baseVolume = cointDetails.get(BitConstants.BASE_VOLUME);
             JsonNode high24hr = cointDetails.get(BitConstants.HIGH_24);
             JsonNode low24hr = cointDetails.get(BitConstants.LOW_24);
             JsonNode prevClose = cointDetails.get(BitConstants.PREV_CLOSE);
             JsonNode prevOpen = cointDetails.get(BitConstants.PREV_OPEN);
             JsonNode id = cointDetails.get(BitConstants.ID);
             c.setId(id.asInt());
             c.setLast(lastRate.asDouble());
             c.setChange(change.asDouble());
             c.setHighestBid(highestBid.asDouble());
             c.setBaseVolume(baseVolume.asDouble());
             c.setLowestAsk(lowestAsk.asDouble());
             c.setHigh24hr(high24hr.asDouble());
              c.setLow24hr(low24hr.asDouble());
              c.setPrevClose(prevClose.asDouble());
              c.setPrevOpen(prevOpen.asDouble());
             if(BitConstants.THB_BTC.equals(coin)){
               c.setCoin(BitConstants.BTC_DESC);}
             else if(BitConstants.THB_BCH.equals(coin)){
                 c.setCoin(BitConstants.BCH_DESC);
             }else if(BitConstants.THB_LTC.equals(coin)){
                 c.setCoin(BitConstants.LTC_DESC);
             }else if(BitConstants.THB_ETH.equals(coin)){
                 c.setCoin(BitConstants.ETH_DESC);
             }
             else if(BitConstants.THB_XRP.equals(coin)){
                 c.setCoin(BitConstants.XRP_DESC);
             }
         }


       System.out.println("coin"+c.getLast());
       return  c;

   }

   private ResponseEntity<String> getTicker(String coin){

       //String urlBit=${"spring.bitkub.ticker"};https://api.bitkub.com/api/market/ticker?sym=THB_ETH&lmt=10
      // urlValues.setUrl(${spring.bitkub.ticker}); //@value failed so using setURL method
      // System.out.println("uri:::::::"+urlValues.getUrl());
     return restTemplate.getForEntity(urlValues.getUrl()+"?"+BitConstants.SYM+"="+coin,String.class);
       //return new RestTemplate().getForEntity(urlValues.getUrl(),String.class);
   }
}

