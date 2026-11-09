package espoch.edu.ec.launchsimulator.model.formules.access;

import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;


public interface InterfaceDownward {

    public boolean compareUnits(Downward downward);

    public Float searchFormule(Downward downward);

    public Float torricelli(Downward downward);

    public Float generalEquation(Downward downward);

    public Float mathEquation(Downward downward);

    public Float averageVelocity(Downward downward);
}
