package espoch.edu.ec.launchsimulator.model.comparebody.data;

import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;
import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;


public class CompareDowns {

    private Downward objectDownwardOne;
    private Downward objectDownwardTwo;
    private Upward objetctUpwardOne;
    private Upward objetctUpwardTwo;

    public CompareDowns(Downward objectDownwardOne, Downward objectDownwardTwo, Upward objetctUpwardOne, Upward objetctUpwardTwo) {
        this.objectDownwardOne = objectDownwardOne;
        this.objectDownwardTwo = objectDownwardTwo;
        this.objetctUpwardOne = objetctUpwardOne;
        this.objetctUpwardTwo = objetctUpwardTwo;
    }

    public Downward getObjectDownwardOne() {
        return objectDownwardOne;
    }

    public void setObjectDownwardOne(Downward objectDownwardOne) {
        this.objectDownwardOne = objectDownwardOne;
    }

    public Downward getObjectDownwardTwo() {
        return objectDownwardTwo;
    }

    public void setObjectDownwardTwo(Downward objectDownwardTwo) {
        this.objectDownwardTwo = objectDownwardTwo;
    }

    public Upward getObjetctUpwardOne() {
        return objetctUpwardOne;
    }

    public void setObjetctUpwardOne(Upward objetctUpwardOne) {
        this.objetctUpwardOne = objetctUpwardOne;
    }

    public Upward getObjetctUpwardTwo() {
        return objetctUpwardTwo;
    }

    public void setObjetctUpwardTwo(Upward objetctUpwardTwo) {
        this.objetctUpwardTwo = objetctUpwardTwo;
    }
    
    
}
