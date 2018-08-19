package ru.anna.mytestpr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.anna.mytestpr.jdo.Tour;
import ru.anna.mytestpr.utils.MyFileUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class TourDaoImpl implements TourDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void tourUpdate(Long tourId, Integer cnt) {
        Map<String, Object> map = new HashMap<>();
        map.put("tour_id", tourId);
        map.put("count_limit", cnt);
        namedParameterJdbcTemplate.update("UPDATE SA.TOURLIST SET count_limit=:count_limit WHERE tour_id=:tour_id", map);
    }

    private final TourMapper tourMapper= new TourMapper();

    @Override
    public Tour getTourById(Long tour) {
        Map<String, Long> map = new HashMap<>();
        map.put("tour_id",tour);
        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM SA.TOURLIST WHERE TOUR_ID=:tour_id", map, tourMapper);
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    private final static String CREATE_ALL_TABLES=MyFileUtils.scriptLoader("/sql/createAllTables.sql");




    @Override
    public List<Tour> getAllTours() {

        return namedParameterJdbcTemplate.query("SELECT * FROM SA.TOURLIST",new TourMapper());
    }

    private static class TourMapper implements RowMapper<Tour> {

        @Override
        public Tour mapRow(ResultSet resultSet, int i) throws SQLException {
            Tour tour = new Tour();
            tour.setTourId(resultSet.getLong("tour_id"));
            tour.setName(resultSet.getString("name"));
            tour.setDescription(resultSet.getString("description"));
            tour.setLocation(resultSet.getString("location"));
            tour.setStartDate(resultSet.getDate("start_date"));
            tour.setEndDate(resultSet.getDate("end_date"));
            tour.setCountLimit(resultSet.getInt("count_limit"));

            return tour;
        }


    }
}
