package com.zihler.download;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DownloadBooks {
    public static void main(String[] args) throws IOException {
        List<String> queries = Arrays.asList("refactoring", "clean%20code", "extreme%20programming", "scrum", "agile", "lean");
        for (String query : queries) {
            GoogleApiBooks booksFromQuery = query(query);
            appendToFile(booksFromQuery);
        }

    }

    private static void appendToFile(GoogleApiBooks booksFromQuery) throws IOException {
        Path path = Paths.get("C:/Users/olzi/Downloads/template-master/src/main/resources/books.csv");

        int idCounter = Files.readAllLines(path).size();
        for (Item item : booksFromQuery.getItems()) {
            String thingsToSave = (idCounter++) + ";"
                    + item.getVolumeInfo().getTitle()
                    + ";" + join(item)
                    + ";" + item.getSaleInfo().getSaleability()
                    + ";" + imageLink(item)
                    + "\n";
            Files.write(path, thingsToSave.getBytes(), StandardOpenOption.APPEND);  //Append mode
        }

    }

    private static String imageLink(Item item) {
        VolumeInfo volumeInfo = item.getVolumeInfo();
        String assetsLink = "/assets/images/sample-book.png";
        if (volumeInfo == null) {
            return assetsLink;
        }
        ImageLinks imageLinks = volumeInfo.getImageLinks();

        if (imageLinks == null) {
            return assetsLink;
        }
        return imageLinks.getThumbnail();
    }

    private static String join(Item item) {
        List<String> authors = item.getVolumeInfo().getAuthors();
        if (authors == null) {
            return "";
        }
        return authors.stream().collect(Collectors.joining(","));
    }

    private static GoogleApiBooks query(String query) {
        return new RestTemplate()
                .getForEntity(String.format("%s?q=%s", "https://www.googleapis.com/books/v1/volumes", query), GoogleApiBooks.class)
                .getBody();
    }
}
