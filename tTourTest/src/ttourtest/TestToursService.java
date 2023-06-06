/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttourtest;

import com.ttour.entiy.Tour;
import com.ttour.exception.TOURException;
import com.ttour.service.TourService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class TestToursService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        TourService service = new TourService();
        
        try {
            List<Tour> t1 = service.getToursByType("藝術");
            List<Tour> t2 = service.getToursByName("建築");
            System.out.println(t2);
        } catch (TOURException ex) {
            Logger.getLogger(TestToursService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
