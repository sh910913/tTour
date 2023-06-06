/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.service;

import com.ttour.exception.TOURException;

/**
 *
 * @author Administrator
 */
public interface DAOInterface<K, T> {
//泛型Type token  用人家寫好的泛型作宣告
//集合裡面的元素到建立時再建立
//設計規則是用英文大寫
//型別代號T。型別當作變數名稱，因為還不確定實作的型別
//K是主鍵值的型別代號，產品可能是整數(INTERGER)  客戶是字串(STRING)    
    
    void insert(T c) throws TOURException;

    void update(T c) throws TOURException;

    T get(K id) throws TOURException;

    void delete(T c) throws TOURException;

}
