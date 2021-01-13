package com.bitkub.service.BitKub;

class Coin{

    private  int id;
    private  double last;
    private double change;
    private  String coin;
    private double high24hr;
    private double low24hr;
    private double prevClose;
    private double prevOpen;
    private double baseVolume;
    private double lowestAsk;
    private double highestBid;

    public void setId(int id) {
        this.id = id;
    }

    public double getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(double high24hr) {
        this.high24hr = high24hr;
    }

    public double getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(double low24hr) {
        this.low24hr = low24hr;
    }

    public double getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(double prevClose) {
        this.prevClose = prevClose;
    }

    public double getPrevOpen() {
        return prevOpen;
    }

    public void setPrevOpen(double prevOpen) {
        this.prevOpen = prevOpen;
    }

    public double getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(double baseVolume) {
        this.baseVolume = baseVolume;
    }

    public double getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(double lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }







    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }




    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }





}