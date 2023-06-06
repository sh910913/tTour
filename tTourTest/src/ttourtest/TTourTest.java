/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttourtest;

import com.ttour.entiy.Member;

/**
 *
 * @author Owner
 */
public class TTourTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Member c = new Member();
        
        //性別測試
//        c.setGender('A');
//        c.setGender('M');
//        System.out.println(c.getGender());
        //生日測試
        c.setBirthday(1986, -1, 23);
//        c.setBirthday(1986, 1, 236);
//        c.setBirthday(2003, 1, 23);
        System.out.println(c.getBirthday());
        System.out.println(c.getAge());
        System.out.println(c);
        
        
        
    }
    
}
