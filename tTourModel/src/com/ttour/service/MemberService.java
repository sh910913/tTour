/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.service;


import com.ttour.entiy.Member;
import com.ttour.exception.TOURException;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class MemberService {
    private MemberDAO dao = new MemberDAO();
    //TODO: 會員註冊
    public void register(Member c) throws TOURException{
        dao.insert(c);
    }
    
    //TODO: 會員登入
    public Member login(String email, String pwd) throws TOURException{
        if(email==null || email.length()==0 || pwd==null ||pwd.length()==0  ){
            throw new IllegalArgumentException("登入失敗: 必須輸入帳號和密碼");
        }
        
        Member c = dao.get(email);
        if(c!=null && pwd.equals(c.getPassword())){
            return c;
        }else{
            throw new TOURException("登入失敗!");
        }        
    }
    
    //TODO: 
    public void update(Member c) throws TOURException {
        dao.update(c);
    }

    public void delete(Member c) throws TOURException {
        dao.delete(c);
    }

    public List<Member> getMemberListByName(String name) throws TOURException {
        return dao.getMemberListByName(name);
    }
    
    public Member get(String id) throws TOURException{
        Member c = dao.get(id);
        return c;
    }

    
}
