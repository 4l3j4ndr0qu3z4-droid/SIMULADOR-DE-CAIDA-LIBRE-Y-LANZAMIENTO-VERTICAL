package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.access.InterfaceDownward;
import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;


public class Downwards implements InterfaceDownward {

    @Override
    public boolean compareUnits(Downward downward) {
        boolean result = false;
        return result;

    }

    @Override
    public Float searchFormule(Downward downward) {
        boolean haveT = downward.getTime() != null;
        boolean haveVf = downward.getFinalVelocity() != null;
        boolean haveH_Ho = downward.getHeight() != null || downward.getInitialHeight() != null;
        boolean haveG = downward.getGravity() != null &&  downward.getGravity().getPlanets() != null;
        Float result = 0.0f;

        if (!haveH_Ho) {
            // Caso 1 sin altura
            // formula Vf = Vo + gt
            result = mathEquation(downward);
        } else if (!haveVf) {
            // Caso 2 sin velocidad final
            // formula h = ho + Vo t + (g*t*t)/2
            result = generalEquation(downward);
        } else if (!haveT) {
            //Caso 3 sin tiempo
            //  Vf2 = Vo2 + 2gh
            result = torricelli(downward);
        } else if (!haveG) {
            // caso 4 sin gravedad
            // h = ((Vf + Vo)/2 ) * t
            result = averageVelocity(downward);
        }
        return result;
    }

    //Caso 3 sin tiempo
    //  Vf2 = Vo2 + 2gh
    @Override
    public Float torricelli(Downward downward) {
        boolean haveVf = downward.getFinalVelocity() != null;
        boolean haveH_Ho = downward.getHeight() != null || downward.getInitialHeight() != null;
        boolean haveVo = downward.getInitialVelocity() != null;
        boolean haveG = downward.getGravity() != null && downward.getGravity().getPlanets() != null;

        Float result = 0.0f;
        TorricelliFormulas torricelli = new TorricelliFormulas();

        if (!haveVf) {
            result = torricelli.calculateFinalVelocity(downward);
        } else if (!haveH_Ho) {
            result = torricelli.calculateHeight(downward);
        } else if (!haveVo) {
            result = torricelli.calculateInitialVelocity(downward);
        } else if (!haveG) {
            result = torricelli.calculateGravity(downward);
        }
        return result;
    }

    // Caso 2 sin velocidad final
    // formula h = ho + Vo t + (g*t*t)/2
    @Override
    public Float generalEquation(Downward downward) {
        boolean haveT = downward.getTime() != null && downward.getTime() > 0;
        boolean haveH = downward.getHeight() != null && downward.getHeight() >= 0;
        boolean haveHo = downward.getInitialHeight() != null && downward.getInitialHeight() >= 0;
        boolean haveVo = downward.getInitialVelocity() != null && downward.getInitialVelocity() >= 0;
        boolean haveG = downward.getGravity() != null && downward.getGravity().getPlanets() != null && downward.getGravity().getPlanets() > 0;
        Float result = 0.0f;
        GeneralFormulas general = new GeneralFormulas();

        if (haveT == false) {
            result = general.calculateTime(downward);
        } else if (haveH == false) {
            result = general.calculateHeight(downward);
        } else if (haveHo == false) {
            result = general.calculateInitialHeight(downward);
        } else if (haveVo == false) {
            result = general.calculateInitialVelocity(downward);
        } else if (haveG == false) {
            result = general.calculateGravity(downward);
        }
        return result;

    }

    // Caso 1 sin altura
    // formula Vf = Vo + gt
    @Override
    public Float mathEquation(Downward downward) {
        boolean haveT = downward.getTime() != null && downward.getTime() > 0;
        boolean haveVf = downward.getFinalVelocity() != null && downward.getFinalVelocity() > 0;
        boolean haveVo = downward.getInitialVelocity() != null && downward.getInitialVelocity() >= 0;
        boolean haveG = downward.getGravity() != null && downward.getGravity().getPlanets() != null && downward.getGravity().getPlanets() > 0;

        Float result = 0.0f;

        MathematicalFormulas math = new MathematicalFormulas();

        if (haveT == false) {
            result = math.calculateTime(downward);
        }
        if (haveVo == false) {
            result = math.calculateInitialVelocity(downward);
        }
        if (haveVf == false) {
            result = math.calculateFinalVelocity(downward);
        }

        if (haveG == false) {
            result = math.calculateGravity(downward);
        }
        return result;

    }

    // caso 4 sin gravedad
    // h = ((Vf + Vo)/2 ) * t
    @Override
    public Float averageVelocity(Downward downward) {
        
        boolean haveT = downward.getTime() != null && downward.getTime() > 0;
        boolean haveVf = downward.getFinalVelocity() != null && downward.getFinalVelocity() > 0;
        boolean haveH = downward.getHeight() != null && downward.getHeight() > 0;
        boolean haveVo = downward.getInitialVelocity() != null && downward.getInitialVelocity() >= 0;
        
        Float result = 0.0f;
        AverageVelocityFormulas average = new AverageVelocityFormulas();

        if (haveVo == false) {
            result = average.calculateInitialVelocity(downward);
        }
        if (haveT == false) {
            result = average.calculateTime(downward);
        }
        if (haveVf == false) {
            result = average.calculateFinalVelocity(downward);
        }
        if (haveH == false) {
            result = average.calculateHeight(downward);
        }

        return result;

    }

}
