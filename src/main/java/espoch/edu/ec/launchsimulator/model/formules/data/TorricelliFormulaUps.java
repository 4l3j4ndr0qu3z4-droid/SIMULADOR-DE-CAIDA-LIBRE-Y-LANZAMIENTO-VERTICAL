package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.data.TorricelliFormulas;
import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;


public class TorricelliFormulaUps extends TorricelliFormulas {
    // vf = raiz( Vo2 + 2g(h-ho))

    public Float calculateFinalVelocity(Upward upward) {
        Float result = null;

        Float g = upward.getGravity().getPlanets();
        Float h = upward.getHeight();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> Vf = raiz(Vo^2 - 2gh)
            float inner = (Vo * Vo) - (2 * g * h);
            if (inner >= 0) {
                result = (float) Math.sqrt(inner);
                System.out.println("Vf = raiz(Vo^2 - 2gh)");
            }

        } else if (ho > 0) {
            // 2. SÍ tiene ho -> Vf = raiz(Vo^2 - 2g(h - ho))
            Float raiz = (Vo * Vo) - (2 * g * (h - ho));
            if (raiz >= 0) {
                result = (float) Math.sqrt(raiz);
                System.out.println("Vf = raiz(Vo^2 - 2g(h - ho))");
            }
        }
        return result;
    }

    public Float calculateInitialVelocity(Upward upward) {

        Float result = null;

        Float g = upward.getGravity().getPlanets();
        Float h = upward.getHeight();
        Float ho = upward.getInitialHeight();
        Float Vf = upward.getFinalVelocity();

        if (ho == null || ho == 0) {
            // 1. No tiene ho 
            //Vo = raiz(Vf^2 + 2gh)
            Float raiz = (Vf * Vf) + (2 * g * h);
            if (raiz >= 0) {
                result = (float) Math.sqrt(raiz);
                System.out.println("Vo = raiz(Vf^2 + 2gh)");
            }
        } else if (ho > 0) {
            // 2. SÍ tiene ho 
            //Vo = raiz(Vf^2 + 2g(h - ho))
            float raiz = (Vf * Vf) + (2 * g * (h - ho));
            if (raiz >= 0) {
                result = (float) Math.sqrt(raiz);
                System.out.println("Vo = raiz(Vf^2 + 2g(h - ho))");
            }
        }
        return result;
    }

    public Float calculateGravity(Upward upward) {

        Float Vf = upward.getFinalVelocity();
        Float h = upward.getHeight();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();

        Float result = null;

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> g = (Vo^2 - Vf^2) / (2h)
            result = ((Vo * Vo) - (Vf * Vf)) / (2 * h);
            System.out.println("g = (Vo^2 - Vf^2) / 2h");
        } else if (ho > 0) {
            // 2. SÍ tiene ho -> g = (Vo^2 - Vf^2) / (2(h - ho))
            result = ((Vo * Vo) - (Vf * Vf)) / (2 * (h - ho));
            System.out.println("g = (Vo^2 - Vf^2) / (2(h - ho))");
        }
        return result;
    }

    public Float calculateHeight(Upward upward) {
        Float result = null;

        Float g = upward.getGravity().getPlanets();
        Float Vf = upward.getFinalVelocity();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> h = (Vo^2 - Vf^2) / 2g
            result = ((Vo * Vo) - (Vf * Vf)) / (2 * g);
            System.out.println("h = (Vo^2 - Vf^2) / 2g");
        } else if (ho > 0) {
            // 2. SÍ tiene ho -> h = ho + (Vo^2 - Vf^2) / 2g
            result = ho + (((Vo * Vo) - (Vf * Vf)) / (2 * g));
            System.out.println("h = ho + (Vo^2 - Vf^2) / 2g");
        }
        return result;
    }

    public Float calculateInitialHeight(Upward upward) {
        Float result = null;

        Float g = upward.getGravity().getPlanets();
        Float h = upward.getHeight();
        Float Vo = upward.getInitialVelocity();
        Float Vf = upward.getFinalVelocity();

        result = h - (((Vo * Vo) - (Vf * Vf)) / (2 * g));
        System.out.println("ho = h - ((Vo^2 - Vf^2) / 2g)");
        
        return result;
    }
}
