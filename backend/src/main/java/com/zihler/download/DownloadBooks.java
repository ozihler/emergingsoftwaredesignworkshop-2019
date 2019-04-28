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

public class DownloadBooks {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> queries = Arrays.asList(
                "refactoring"
                , "clean%20code",
                "extreme%20programming",
                "scrum",
                "agile",
                "lean"
        );
        for (String query : queries) {
            GoogleApiBooks booksFromQuery = query(query);
            appendToFile(booksFromQuery);
        }

    }

    private static void appendToFile(GoogleApiBooks booksFromQuery) throws IOException, URISyntaxException {
        Path path = Paths.get(DownloadBooks.class.getResource("/books.csv").toURI());

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
            return "unknown";
        }
        return String.join(",", authors);
    }

    private static GoogleApiBooks query(String query) {
        return new RestTemplate()
                .getForEntity(String.format("%s?q=%s", "https://www.googleapis.com/books/v1/volumes", query), GoogleApiBooks.class)
                .getBody();
    }
}
