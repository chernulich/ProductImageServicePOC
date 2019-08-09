package com.productimageservicepoc;

import com.productimageservicepoc.entity.ImageTest;
import com.productimageservicepoc.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void run(String... args) throws Exception {

        File file = new File("src/main/resources/images/beans-brown-coffee.jpg");
        File file1 = new File("src/main/resources/images/art-blur-cappuccino-302899.jpg");
        File file2 = new File("src/main/resources/images/beverage-brewed-coffee-caffeine-374885.jpg");

        List<ImageTest> images = getImageTests(file, file1, file2);

        imageRepository.saveAll(images);
    }

    private List<ImageTest> getImageTests(File file, File file1, File file2) {
        return Arrays.asList(file, file1, file2)
                .stream()
                .map(item -> {
                    ImageTest imageTest = new ImageTest();
                    byte[] image = new byte[(int) item.length()];
                    InputStream stream = null;
                    try {
                        stream = new FileInputStream(item);
                        stream.read(image);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageTest.setImage(image);
                    return imageTest;
                }).collect(Collectors.toList());
    }
}
