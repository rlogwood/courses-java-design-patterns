package dev.logwood.designpatterns.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import dev.logwood.designpatterns.types.structural.proxy.image.Image;
import dev.logwood.designpatterns.types.structural.proxy.image.ProxyImage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PatternsModule extends AbstractModule {
    private static final String testPropertiesFilename = "test.properties";
    //@Provides
    //@Named("ImageFilename")
    public static String provideImageFilename() {
        return "MyImageFile.png";
    }

    @Override
    protected void configure() {

        Properties properties = new Properties();
        try {
            InputStream propStream = getClass()
                    .getClassLoader().getResourceAsStream(testPropertiesFilename);

            //properties.load(new FileReader(testPropertiesFilename));
            properties.load(propStream);
            Names.bindProperties(binder(), properties);
        } catch (FileNotFoundException e) {
            System.out.format("Can't find test properties file (%s)\n",testPropertiesFilename);
        } catch (IOException e) {
            System.out.format("I/O erro loading test configuration (%s)\n%s",testPropertiesFilename,e.getLocalizedMessage());
        }


        bind(Image.class).to(ProxyImage.class);
    }
}
