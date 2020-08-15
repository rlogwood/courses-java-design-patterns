package dev.logwood.designpatterns.types.structural.proxy.image;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    @Inject
    public ProxyImage(@Named("ImageFilename") String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
