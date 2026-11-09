package espoch.edu.ec.launchsimulator.model.formules.objects;

import espoch.edu.ec.launchsimulator.model.formules.enumeration.Gravity;

public class Downward {

    private Gravity gravity;
    private Float initialHeight;
    private Float height;
    private Float initialVelocity;
    private Float time;
    private Float finalVelocity;

    public Downward(Gravity gravity, Float initialHeight, Float height, Float initialVelocity, Float time, Float finalVelocity) {
        this.gravity = gravity;
        this.initialHeight = initialHeight;
        this.height = height;
        this.initialVelocity = initialVelocity;
        this.time = time;
        this.finalVelocity = finalVelocity;
    }

    public Downward() {
    }

    
    
    public Gravity getGravity() {
        return gravity;
    }

    public void setGravity(Gravity gravity) {
        this.gravity = gravity;
    }

    public Float getInitialHeight() {
        return initialHeight;
    }

    public void setInitialHeight(Float initialHeight) {
        this.initialHeight = initialHeight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getInitialVelocity() {
        return initialVelocity;
    }

    public void setInitialVelocity(Float initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public Float getFinalVelocity() {
        return finalVelocity;
    }

    public void setFinalVelocity(Float finalVelocity) {
        this.finalVelocity = finalVelocity;
    }

}
