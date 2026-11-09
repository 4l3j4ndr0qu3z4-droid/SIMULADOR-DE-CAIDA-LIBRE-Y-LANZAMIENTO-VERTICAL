package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;

public class GeneralFormulaUps extends GeneralFormulas {

    public Float calculateHeight(Upward upward) {
        Float result = null;

        Float g = upward.getGravity().getPlanets();
        Float t = upward.getTime();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();

        if (ho == null || ho == 0) {
            // 1. No tiene ho
            // h = (Vo * t) - (1/2) * g * t^2
            result = (Vo * t) - (0.5f * g * (t * t));
            System.out.println("h = (Vo * t) - (1/2) * g * t^2");

        } else if (ho > 0) {
            // 2. SÍ tiene ho 
            // h = ho + (Vo * t) - (1/2) * g * t^2
            result = ho + (Vo * t) - (0.5f * g * (t * t));
            System.out.println("h = ho + (Vo * t) - (1/2) * g * t^2");
        }

        return result;
    }

    // ho = h - vo*t - (g*t*t)/2
    public Float calculateInitialHeight(Upward upward) {
        Float result = 0.0f;

        Float g = upward.getGravity().getPlanets();
        Float h = upward.getHeight();
        Float t = upward.getTime();
        Float Vo = upward.getInitialVelocity();

        result = h - (Vo * t) + (0.5f * g * (t * t));

        System.out.println("ho = h - (Vo * t) + (1/2) * g * t^2");
        return result;
    }

    // vo = (2(h-ho)-(g*t*t)))/(2t)
    public Float calculateInitialVelocity(Upward upward) {
        Float result = 0.0f;

        Float g = upward.getGravity().getPlanets();
        Float h = upward.getHeight();
        Float t = upward.getTime();
        Float ho = upward.getInitialHeight();

        if (ho == null || ho == 0) {
            // 1. No tiene ho 
            //Vo = (h + (1/2) * g * t^2) / t
            result = (h + (0.5f * g * (t * t))) / t;
            System.out.println("Vo = (h + (1/2) * g * t^2) / t");
            System.out.println(result);

        } else if (ho > 0) {
            // 2. SÍ tiene ho 
            // Vo = (h - ho + (1/2) * g * t^2) / t
            result = (h - ho + (0.5f * g * (t * t))) / t;
            System.out.println("Vo = (h - ho + (1/2) * g * t^2) / t");
            System.out.println(result);

        }
        return result;
    }

    // t = (-vo +-  raiz (  Vo*Vo)  - 2*g (h-ho)))/g
    public Float calculateTime(Upward upward) {
        Float resultOne = 0.0f;
        Float resultTwo = 0.0f;
        Float correct = 0.0f;

        Float g = upward.getGravity().getPlanets();
        Float h = upward.getHeight();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();

        Float a = 0.5f * g;
        Float b = Vo;
        Float c = h - ho;
        Float discriminating = (b * b) - (4.0f * a * c);

        if (ho == null || ho == 0) {
            // 1. No tiene ho 
            // t = (Vo +- raiz(Vo^2 - 2gh)) / g
            if (discriminating >= 0) {
                Float raiz = (float) Math.sqrt(discriminating);
                resultOne = (Vo + raiz) / g;
                resultTwo = (Vo - raiz) / g;
                System.out.println("t = (Vo +- raiz(Vo^2 - 2gh)) / g");
            }

        } else if (ho > 0) {
            // 2. SÍ tiene ho 
            // t = (Vo +- raiz(Vo^2 - 2g(h - ho))) / g
            if (discriminating >= 0) {
                Float raiz = (float) Math.sqrt(discriminating);
                resultOne = (Vo + raiz) / g;
                resultTwo = (Vo - raiz) / g;
                System.out.println("t = (Vo +- raiz(Vo^2 - 2g(h - ho))) / g");
            }

        }
        correct = Float.max(resultOne, resultTwo);

        System.out.println(
                "1: " + resultOne);
        System.out.println(
                "2: " + resultTwo);
        System.out.println(
                "final: " + correct);
        return correct;

    }

    // g = (2(h-ho-(Vo*t)))/t*t
    public Float calculateGravity(Upward upward) {
        Float result = 0.0f;

        Float h = upward.getHeight();
        Float t = upward.getTime();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();

        if (ho == null || ho == 0) {
            // 1. No tiene ho 
            //g = (2 * ((Vo * t) - h)) / (t * t)
            result = (2 * ((Vo * t) - h)) / (t * t);
            System.out.println("g = (2 * ((Vo * t) - h)) / t^2");

        } else if (ho > 0) {
            // 2. SÍ tiene ho 
            // g = (2 * (ho + (Vo * t) - h)) / (t * t)
            result = (2 * (ho + (Vo * t) - h)) / (t * t);
            System.out.println("g = (2 * (ho + (Vo * t) - h)) / t^2");

        }
        return result;
    }

}
