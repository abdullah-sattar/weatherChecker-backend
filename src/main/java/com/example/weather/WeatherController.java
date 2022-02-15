package com.example.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

    @Autowired
    WeatherRepository repository;

    @GetMapping("/forecasts")
    public ResponseEntity<List<Weather>> getAllForecasts() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/forecasts/{name}")
    public ResponseEntity <List<Weather>> getForecasts(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findForecastByname(name));
    }
//    public ResponseEntity <List<Weather>> getForecasts(@PathVariable String name) {
//        List<Weather> forecasts = repository.findAll();
//        Stream<Weather> stream = forecasts.stream().filter(forecast -> forecast.getName().equalsIgnoreCase(name));
//        List<Weather> result = stream.collect(Collectors.toList());
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }

    @PostMapping("/add-forecast")
    public ResponseEntity<String> addForecast(@RequestBody Weather forecast) {
        repository.save(forecast);
        return ResponseEntity.status(HttpStatus.OK).body("Forecast added");
    }

}
