package espoch.edu.ec.launchsimulator.model.unitconverterlaunch.data;

import espoch.edu.ec.launchsimulator.model.unitconverterlaunch.access.InterfaceUnitConverter;
import espoch.edu.ec.launchsimulator.model.unitconverterlaunch.objects.UnitConverter;

public class UnitConverters implements InterfaceUnitConverter {

        public Float kmtoM(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * 1000.0f);
    }

    public Float kmtoCm(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * 100000.0f);
    }

    public Float MtoCm(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * 100.0f);
    }

    public Float MtoKm(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 1000.0f);
    }

    public Float CmtoKm(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 100000.0f);
    }

    public Float CmtoM(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 100.0f);
    }

    public Float HtoS(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * 3600.0f);
    }

    public Float HtoMin(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * 60.0f);
    }

    public Float StoMin(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 60.0f);
    }

    public Float StoH(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 3600.0f);
    }

    public Float MintoH(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 60.0f);
    }

    public Float MintoS(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * 60.0f);
    }

    public Float kmForH_to_mForS(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 3.6f);
    }

    public Float kmForH_to_cmForMin(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * (10000.0f / 6.0f));
    }

    public Float mForS_to_kmForH(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() * 3.6f);
    }

    public Float mForS_to_cmForMin(UnitConverter unitConverter) {
        // 1 m/s = (100 cm) / (1/60 min) = 100 * 60 = 6000 cm/min
        return (unitConverter.getValueOne() * 6000.0f);
    }

    public Float cmForMin_to_mForS(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / 6000.0f);
    }

    public Float cmForMin_to_kmForH(UnitConverter unitConverter) {
        return (unitConverter.getValueOne() / (10000.0f / 6.0f));
    }

}
