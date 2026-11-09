package espoch.edu.ec.launchsimulator.model.formules.access;

import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;

public interface InterfaceUpward extends InterfaceDownward {

    public boolean compareUnits(Upward upward);

    public Float searchFormule(Upward upward);

    public Float torricelli(Upward upward);

    public Float generalEquation(Upward upward);

    public Float mathEquation(Upward upward);

    public Float averageVelocity(Upward upward);

    public Float searchUpward(Upward upward);
}
