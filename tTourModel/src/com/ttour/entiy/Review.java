/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.entiy;

import com.ttour.exception.TOURException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class Review {

    /*
    **會員評價
     */
    private String reiew;
    /*
    **會員評比
     */
    private int rating;

    public String getReiew() {
        return reiew;
    }

    public void setReiew(String reiew) {
        this.reiew = reiew;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating >=1 || rating <=5){
            this.rating =rating;
        }else{
            try {
                throw new TOURException("請評價!");
            } catch (TOURException ex) {
                Logger.getLogger(Review.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
