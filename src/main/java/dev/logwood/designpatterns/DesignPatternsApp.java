package dev.logwood.designpatterns;

import dev.logwood.designpatterns.types.structural.proxy.image.Image;
import dev.logwood.designpatterns.types.structural.proxy.image.ProxyImage;

class ProxyPatternDemo {

    public static void exerciseProxyPattern() {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}

public class DesignPatternsApp {
    public static void main(String[] args) {
        ProxyPatternDemo.exerciseProxyPattern();
    }
}
