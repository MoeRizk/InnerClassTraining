package com.fox;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGear;
    private int currentGear = 0;
    private String fox;
    private boolean clutchIsIn;


    public GearBox(int maxGear) {
        this.maxGear = maxGear;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0,0.0);
        this.gears.add(neutral);

    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;

    }

    public void addGear(int number, double ratio){
        if ((number > 0) && (number > maxGear)){
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear){
        if ((newGear > 0) && newGear < (this.gears.size()) && (this.clutchIsIn)){
            this.currentGear = newGear;
            System.out.println("the new gear is " + newGear);
        } else {
            System.out.println("Grind!!!");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("Screem");
            return 0.0;
        }else{
            return revs * gears.get(currentGear).getRatio();

        }
    }

    private class Gear{
        private int gearNumber;
        private double ratio;

        public double getRatio() {
            return ratio;
        }

        public Gear(int gearNumber, double ratio) {

            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs){
            return revs *(this.ratio);
        }



    }
}
