/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttourtest;

import com.ttour.entiy.Tour;
import com.ttour.exception.TOURException;
import com.ttour.service.ToursDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class TestTourDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ToursDAO dao = new ToursDAO();
            Tour t  = dao.get(1);
            System.out.println("t ="+t );
        } catch (TOURException ex) {
            Logger.getLogger(TestTourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
