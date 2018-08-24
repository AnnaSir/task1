package ru.anna.mytestpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.TourDao;
import ru.anna.mytestpr.jdo.Tour;

import java.util.List;

@Service
public class TourService {

    private TourDao tourDao;

    @Autowired
    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }

    public List<Tour> getAllTours(){
        return tourDao.getAllTours();
    }

    public Tour getTourById(Long tour){
        return tourDao.getTourById(tour);
    }


}
