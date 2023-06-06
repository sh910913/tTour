/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttour.entiy;

import com.ttour.exception.TOURException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class Member {
    
    public static final char MALE = 'M';
    public static final char FEMALE = 'F';
    
    
    private int id;
    private String email;
    private String password;
    private char gender;
    private String name;
    private Date birthday;
    private String phone;
        /**
     * 國籍
     */
    private String nationality;

    public Member() {
    }
    
    public Member(String email,String name,String password){
        this.email = email;
        this.name = name;
        this.password = name;
    }
    public Member(String email,String name,String password,char gender){
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
//        setGender(gender) ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public char getGender() {
         return gender;
     }

    public void setGender(char gender) {//為何要拋錯
        if(gender == FEMALE|| gender == MALE){
            this.gender = gender == FEMALE? FEMALE : MALE;
        }else{
            try {
                throw new TOURException("性別資料不正確");
            } catch (TOURException ex) {
                Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date bDate) throws TOURException {
        //非必要，所以空值可以，但要輸入一定不能空且生日在現在之前
        if (birthday == null || (birthday != null && birthday.before(new Date()))) {
            this.birthday = bDate;
        } else {
            System.out.println("[server]客戶生日日期必須小於現在時間!");
            throw new TOURException("[client]客戶生日日期必須小於現在時間!");
        }
    }
    public static final DateFormat webDateFormat;


    static {
        webDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void setBirthday(String bDay) throws TOURException {
        //先判斷是不是空值，不然parse會錯
        if (bDay != null && bDay.length() > 0) {
            try {
                bDay = bDay.replace('/', '-');
                Date d = webDateFormat.parse(bDay);
                this.birthday = d;
            } catch (ParseException ex) {
                Logger.getLogger(Member.class.getName()).log(Level.SEVERE,
                        "[server]客戶生日日期不正確！", ex);
                //只有系統訊息↑，還是要告訴user
                throw new TOURException("客戶生日日期不正確！");
            }
        } else {
            //非必要欄位所以沒差。
            this.birthday = null;
        }
    }

    public void setBirthday(int year, int month, int day) {

        this.birthday = new GregorianCalendar(year, month-1, day).getTime();
    }
    public int getAge() {
        Date now = new Date();
        if (this.getBirthday() != null) {
            /**
             * 1.年相減 =years 2.生日月>現在月 →years - 1 3.
             */            
            if (now.after(birthday)) {
                long nowMiliSecs = now.getTime();//1970年算到現在的秒數。
                long bDayMiliSecs = birthday.getTime();//1970年算到生日過的秒數
                long diff = nowMiliSecs - bDayMiliSecs;//相減即為總共活的秒數
                Date age = new Date(diff);//從1970年開始算的秒數，活十年算出來是1980年。
                return age.getYear() + 1900 -1970;//劃掉表示過時，不建議使用。
            }
        }
        return 0;
    }    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return nationality;
    }

    public void setCountry(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", email=" + email + ", password=" + password + ", gender=" + gender + ", name=" + name + ", birthday=" + birthday + ", phone=" + phone + ", country=" + nationality + '}';
    }
    
}
