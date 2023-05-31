package dao;

import model.City;

import java.util.List;

public interface CityDAO {
    void create(City city);

    City getById(int cityId);

    List<City> getAllCities();

    void updateCity(City city);

    void deleteCity(City city);
}

