package dev.logwood.designpatterns.types.structural.proxy.image;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dev.logwood.designpatterns.configuration.PatternsModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProxyImageTest {

    Image image;
    private static Injector injector;

    @BeforeAll
    static void initialize() {
        injector = Guice.createInjector(new PatternsModule());
    }

    @BeforeEach
    void setUp() {
         image = injector.getInstance(Image.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void display() {
        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
    }
}