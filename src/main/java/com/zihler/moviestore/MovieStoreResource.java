package com.zihler.moviestore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/moviestore")
public class MovieStoreResource {

    @GetMapping("/movies")
    public Map<Integer, String[]> movies() throws IOException {
        // read movies from file
        final InputStream movieStream = Main.class.getResourceAsStream("/movies.csv");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        final Map<Integer, String[]> movies = new HashMap<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] movie = line.split(";");
            movies.put(Integer.parseInt(movie[0]), movie);

        }
        return movies;
    }
}

