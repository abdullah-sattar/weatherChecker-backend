package com.example.weather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WeatherRepository extends JpaRepository<Weather, String> {
    List<Weather> findForecastByname(String name);
}
