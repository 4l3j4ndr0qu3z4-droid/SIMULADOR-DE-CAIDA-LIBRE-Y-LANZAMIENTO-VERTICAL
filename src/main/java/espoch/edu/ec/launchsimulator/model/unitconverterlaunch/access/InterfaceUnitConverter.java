package espoch.edu.ec.launchsimulator.model.unitconverterlaunch.access;

import espoch.edu.ec.launchsimulator.model.unitconverterlaunch.objects.UnitConverter;


public interface InterfaceUnitConverter {
    public Float kmtoM(UnitConverter unitConverter);

    public Float kmtoCm(UnitConverter unitConverter);

    public Float MtoCm(UnitConverter unitConverter);

    public Float MtoKm(UnitConverter unitConverter);

    public Float CmtoKm(UnitConverter unitConverter);

    public Float CmtoM(UnitConverter unitConverter);

    public Float HtoS(UnitConverter unitConverter);

    public Float HtoMin(UnitConverter unitConverter);

    public Float StoMin(UnitConverter unitConverter);

    public Float StoH(UnitConverter unitConverter);

    public Float MintoH(UnitConverter unitConverter);

    public Float MintoS(UnitConverter unitConverter);

    public Float kmForH_to_mForS(UnitConverter unitConverter);

    public Float kmForH_to_cmForMin(UnitConverter unitConverter);

    public Float mForS_to_kmForH(UnitConverter unitConverter);

    public Float mForS_to_cmForMin(UnitConverter unitConverter);

    public Float cmForMin_to_mForS(UnitConverter unitConverter);

    public Float cmForMin_to_kmForH(UnitConverter unitConverter);
}
