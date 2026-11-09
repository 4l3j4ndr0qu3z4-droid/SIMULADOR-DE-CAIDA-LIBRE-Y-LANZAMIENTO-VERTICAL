package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.data.MathematicalFormulas;
import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;


public class MathematicalFormulaUps extends MathematicalFormulas {

    public Float calculateFinalVelocity(Upward upward) {
        Float result = null;

        Float g = upward.getGravity().getPlanets();
        Float t = upward.getTime();
        Float Vo = upward.getInitialVelocity();

        result = Vo - (g * t);
        System.out.println("Vf = Vo - gt");
        return result;
    }

    public Float calculateInitialVelocity(Upward upward) {
        System.out.println("Vo= Vf + gt");
        return (upward.getFinalVelocity() + (upward.getGravity().getPlanets() * upward.getTime()));
    }

    public Float calculateTime(Upward upward) {

        Float result = 0.0f;

        Float g = upward.getGravity().getPlanets();
        Float Vf = upward.getFinalVelocity();
        Float Vo = upward.getInitialVelocity();

        result = (Vo - Vf) / g;
        System.out.println("t = (Vo - Vf) / g");

        return result;
    }

    public Float calculateGravity(Upward upward) {
        Float result = 0.0f;

        Float t = upward.getTime();
        Float Vf = upward.getFinalVelocity();
        Float Vo = upward.getInitialVelocity();

        result = (Vo - Vf) / t;
        System.out.println("g = (Vo - Vf) / t");

        return result;
    }
}
