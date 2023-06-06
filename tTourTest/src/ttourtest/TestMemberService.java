/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttourtest;


import com.ttour.entiy.Member;
import com.ttour.exception.TOURException;
import com.ttour.service.MemberService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TestMemberService {
    public static void main(String[] args) {
        try {
            MemberService service = new MemberService();
            Member c = service.get("s145@hotmail.com");            
            System.out.println("Answer=" + c);            
            Member c2 = service.login("s145@hotmail.com","123456");
                
        } catch (TOURException ex) {
            Logger.getLogger(TestMemberService.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex){
            System.out.println(ex);
        }  
    }
}
