package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;


public class MathematicalFormulas {

    public Float calculateFinalVelocity(Downward downward) {
        Float result =  0.0f;

        Float g = downward.getGravity().getPlanets();
        Float t = downward.getTime();
        Float Vo = downward.getInitialVelocity();

        if (Vo == null || Vo == 0) {
            result = g * t;
            System.out.println("Vf= gt");
        } else if (Vo > 0) {
            result = Vo + g * t;
            System.out.println("Vf= Vo + gt");
        }
        return result;
    }

    public Float calculateInitialVelocity(Downward downward) {
        System.out.println("Vo= Vf - gt");
        return (downward.getFinalVelocity() - (downward.getGravity().getPlanets() * downward.getTime()));
    }

    public Float calculateTime(Downward downward) {

        Float result =  0.0f;

        Float g = downward.getGravity().getPlanets();
        Float Vf = downward.getFinalVelocity();
        Float Vo = downward.getInitialVelocity();

        if (Vo == null || Vo == 0) {
            result = Vf / g;
            System.out.println("t= Vf/g");
        } else if (Vo > 0) {
            result = (Vf - Vo) / g;
            System.out.println("t= (Vf-Vo)/g");
        }

        return result;
    }

    public Float calculateGravity(Downward downward) {
        Float result =  0.0f;

        Float t = downward.getTime();
        Float Vf = downward.getFinalVelocity();
        Float Vo = downward.getInitialVelocity();

        if (Vo == null || Vo == 0) {
            result = Vf / t;
            System.out.println("g= Vf/t");
        } else if (Vo > 0) {
            result = (Vf - Vo) / t;
            System.out.println("g= (Vf-Vo)/t");
        }
        return result;
    }
}
