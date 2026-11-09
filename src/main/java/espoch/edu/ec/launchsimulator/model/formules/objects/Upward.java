package espoch.edu.ec.launchsimulator.model.formules.objects;

import espoch.edu.ec.launchsimulator.model.formules.enumeration.Gravity;

public class Upward extends Downward {

    public Float RiseTime;
    public Float FlightTime;
    public Float MaximumHeight;
    public Float TotalDistance;

    public Upward(Float RiseTime, Float FlightTime, Float MaximumHeight, Float TotalDistance, Gravity gravity, Float initialHeight, Float height, Float initialVelocity, Float time, Float finalVelocity) {
        super(gravity, initialHeight, height, initialVelocity, time, finalVelocity);
        this.RiseTime = RiseTime;
        this.FlightTime = FlightTime;
        this.MaximumHeight = MaximumHeight;
        this.TotalDistance = TotalDistance;
    }

    public Upward() {
    }

    public Float getRiseTime() {
        return RiseTime;
    }

    public void setRiseTime(Float RiseTime) {
        this.RiseTime = RiseTime;
    }

    public Float getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(Float FlightTime) {
        this.FlightTime = FlightTime;
    }

    public Float getMaximumHeight() {
        return MaximumHeight;
    }

    public void setMaximumHeight(Float MaximumHeight) {
        this.MaximumHeight = MaximumHeight;
    }

    public Float getTotalDistance() {
        return TotalDistance;
    }

    public void setTotalDistance(Float TotalDistance) {
        this.TotalDistance = TotalDistance;
    }

}
