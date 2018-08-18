package ru.anna.mytestpr.dao;

import ru.anna.mytestpr.jdo.Tour;

import java.util.List;

public interface TourDao {
    List<Tour> getAllTours();
    Tour getTourById(Long tour);
}
