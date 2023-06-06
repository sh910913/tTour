/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttourtest;

import com.ttour.entiy.Member;
import com.ttour.exception.TOURException;
import com.ttour.service.MemberDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class TestMemberDAO {

    public static void main(String[] args) {
        Member m = new Member("s145@hotmail.com", "李大章", "123456", 'F');
        Member m1 = new Member("s15@hotmail.com", "李小章", "123456", 'M');
        MemberDAO dao = new MemberDAO();
        try {
//                dao.insert(m);//新增客戶
//                dao.insert(m1);
            Member a = dao.get("s145@hotmail.com");//查詢客戶
//            System.out.println("Hello," + a.getName());
//              dao.delete(a);
//              a.setPhone("0915296857");//修改資料
              System.out.println(a);
//              dao.update(a);

//            List<Member> list = dao.getMemberListByName("李");
//            System.out.println("list:" + list);
//            
//            list = dao.getMemberListByName(name);
//            System.out.println("list:" + list);
        } catch (TOURException ex) {//為什麼要拋錯
            Logger.getLogger(TestMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        
        
        
        
    }

}
