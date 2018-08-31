package ru.anna.mytestpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.anna.mytestpr.dao.TourDao;
import ru.anna.mytestpr.exceptions.BusinessException;
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

        if (tourDao.getAllTours().isEmpty())
            throw new BusinessException("there is no tours");
        else return tourDao.getAllTours();
        }

    public Tour getTourById(Long tour){

        try {
            return tourDao.getTourById(tour);
        }
        catch (EmptyResultDataAccessException e){
            throw new BusinessException("tour does not exist");
        }
    }
}
