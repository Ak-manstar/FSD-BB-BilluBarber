package com.fsd.bookingService.bean;

import java.time.LocalTime;

public class Slot {

    private LocalTime time;
    private int manpowerLeft;
   // private int seatLeft;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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