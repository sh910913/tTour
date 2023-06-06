
package com.ttour.service;

import com.ttour.entiy.Tour;
import com.ttour.exception.TOURException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Owner
 */
public class TourService {
    private ToursDAO dao = new ToursDAO();
    

    public void insert(Tour c) throws TOURException {
        dao.insert(c);
    }

    public void update(Tour c) throws TOURException {
        dao.update(c);
    }

    public void delete(Tour c) throws TOURException {
        dao.delete(c);
    }

    public Tour get(Integer id) throws TOURException {
        return dao.get(id);
    }

    public List<Tour> getToursByType(String type) throws TOURException {
        return dao.getToursByType(type);
    }

    public List<Tour> getToursByName(String name) throws SQLException, TOURException {
        return dao.getToursByName(name);
    }
    
        //TODO: insert, update,delete Product
}
