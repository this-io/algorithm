package main.implementation.easy;

import java.util.Map;

public class ParkingSystem {
    int big;
    int small;
    int medium;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.small = small;
        this.medium = medium;
    }

    public boolean addCar(int carType) {
        boolean result = false;
        if (carType == 1 && big != 0) {
            big -= 1;
            result = true;
        }
        if (carType == 2 && medium != 0) {
            medium -= 1;
            result = true;
        }
        if (carType == 3 && small != 0) {
            small -= 1;
            result = true;
        }
        return result;
    }
}
