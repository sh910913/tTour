/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttourtest;

import com.ttour.entiy.Tour;
import com.ttour.exception.TOURException;
import com.ttour.service.ToursDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class TestToursDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ToursDAO dao = new ToursDAO();
//            Tour t = dao.get(1);
//            System.out.println("t =" +t);
            
//            System.out.println(dao.getToursByType("戶外"));
            try {
                System.out.println(dao.getToursByName("藝術"));
            } catch (SQLException ex) {
                Logger.getLogger(TestToursDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (TOURException ex) {
            Logger.getLogger(TestToursDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
