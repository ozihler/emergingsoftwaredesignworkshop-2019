package com.zihler.moviestore;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/library")
public class Library {

    @GetMapping("/books")
    public List<String[]> getBooks() throws IOException {
        final InputStream movieStream = Library.class.getResourceAsStream("/movies.csv");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        final List<String[]> movies = new ArrayList<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] movie = line.split(";");
            movies.add(movie);

        }
        return movies;
    }
}

