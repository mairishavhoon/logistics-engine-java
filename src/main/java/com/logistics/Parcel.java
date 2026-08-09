package com.logistics;

public class Parcel {
    private final String trackingId;   //the TrackId
    private final double weightKg;     //the weight in kgs

    //constructor for the class Parcel

    public Parcel(String trackingId, double weightKg) {
        //checking if we have a valid weight
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }

        //checking if we have a valid tracking id
        if (trackingId == null || trackingId.isBlank()) {
            throw new IllegalArgumentException("Tracking ID cannot be empty");
        }
        this.trackingId = trackingId;
        this.weightKg = weightKg;
    }

    //function that returns tracking id when asked for it
    public String getTrackingId() {
        return trackingId;
    }

    //function that returns weight of the package in kgs when asked for it
    public double getWeightKg() {
        return weightKg;
    }
}