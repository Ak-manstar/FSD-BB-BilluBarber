package com.fsd.bookingService.bean;

import java.time.LocalTime;

public class Slot {

    private String time;
    private int manpowerLeft;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getManpowerLeft() {
        return manpowerLeft;
    }

    public void setManpowerLeft(int manpowerLeft) {
        this.manpowerLeft = manpowerLeft;
    }

//    public int getSeatLeft() {
//        return seatLeft;
//    }
//
//    public void setSeatLeft(int seatLeft) {
//        this.seatLeft = seatLeft;
//    }


}