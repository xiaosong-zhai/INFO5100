package com.zxsipromise.model;

import java.util.Date;

public class Borrow {
    private int id;
    private int userid;
    private int bookid;
    private Date btime;
    private Date rtime;

    public Borrow(){
        super();
    }

    public Borrow(int id, int userid, int bookid, Date btime, Date rtime) {
        super();
        this.id = id;
        this.userid = userid;
        this.bookid = bookid;
        this.btime = btime;
        this.rtime = rtime;
    }

    public Borrow(int userid, int bookid) {
        this.userid = userid;
        this.bookid = bookid;
    }

    public Borrow(int userid, int bookid, Date btime) {
        this.userid = userid;
        this.bookid = bookid;
        this.btime = btime;
    }

    public Borrow(Date btime, Date rtime) {
        this.btime = btime;
        this.rtime = rtime;
    }

    public Borrow(int bookid) {
        this.bookid = bookid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", userid=" + userid +
                ", bookid=" + bookid +
                ", btime=" + btime +
                ", rtime=" + rtime +
                '}';
    }
}
