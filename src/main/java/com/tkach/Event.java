package com.tkach;


import javax.swing.text.DateFormatter;
import java.util.Date;

public class Event {
    private int id;
    private String msg;
    private Date date;


    public Event(Date date) {
        this.date = date;

    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "id = " + this.id + "; msg = " + this.msg + "; date = " + this.date ;
    }
}
