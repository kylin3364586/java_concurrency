package com.rchz.spring.proxy.stat;

public class Proxy implements Rant {

    private Rant rant;

    public Proxy() {

    }
    public Proxy(Rant rant) {
        this.rant = rant;
    }


    public void rant() {
        rant.rant();
    }
}
