package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;


public class AverageVelocityFormulaUps extends AverageVelocityFormulas {

    public Float calculateHeight(Upward upward) {
        Float result = 0.0f;

        Float vf = upward.getFinalVelocity();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();
        Float t = upward.getTime();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> h = ((vf + Vo) / 2) * t
            result = ((vf + Vo) / 2.0f) * t;
            System.out.println("h = ((vf + Vo) / 2) * t");

        } else if (ho > 0) {
            // 2. SÍ tiene ho -> h = ho + (((vf + Vo) / 2) * t)
            result = ho + (((vf + Vo) / 2.0f) * t);
            System.out.println("h = ho + (((vf + Vo) / 2) * t)");
        }

        return result;
    }

    public Float calculateInitialVelocity(Upward upward) {
        Float result = 0.0f;

        Float vf = upward.getFinalVelocity();
        Float h = upward.getHeight();
        Float ho = upward.getInitialHeight();
        Float t = upward.getTime();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> Vo = ((2 * h) / t) - vf
            result = ((2 * h) / t) - vf;
            System.out.println("Vo = ((2 * h) / t) - vf");

        } else if (ho > 0) {
            // 2. SÍ tiene ho -> Vo = ((2 * (h - ho)) / t) - vf
            result = ((2 * (h - ho)) / t) - vf;
            System.out.println("Vo = ((2 * (h - ho)) / t) - vf");
        }

        return result;
    }

    public Float calculateFinalVelocity(Upward upward) {

        Float result = 0.0f;

        Float h = upward.getHeight();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();
        Float t = upward.getTime();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> vf = ((2 * h) / t) - Vo
            result = ((2 * h) / t) - Vo;
            System.out.println("vf = ((2 * h) / t) - Vo");

        } else if (ho > 0) {
            // 2. SÍ tiene ho -> vf = ((2 * (h - ho)) / t) - Vo
            result = ((2 * (h - ho)) / t) - Vo;
            System.out.println("vf = ((2 * (h - ho)) / t) - Vo");
        }

        return result;
    }

    public Float calculateTime(Upward upward) {
        Float result = 0.0f;

        Float vf = upward.getFinalVelocity();
        Float h = upward.getHeight();
        Float ho = upward.getInitialHeight();
        Float Vo = upward.getInitialVelocity();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> t = (2 * h) / (vf + Vo)
            result = (2 * h) / (vf + Vo);
            System.out.println("t = (2 * h) / (vf + Vo)");

        } else if (ho > 0) {
            // 2. SÍ tiene ho -> t = (2 * (h - ho)) / (vf + Vo)
            result = (2 * (h - ho)) / (vf + Vo);
            System.out.println("t = (2 * (h - ho)) / (vf + Vo)");
        }
        return result;
    }

    public Float calculateInitialHeight(Upward upward) {
        Float result = 0.0f;
        Float vf = upward.getFinalVelocity();
        Float h = upward.getHeight();
        Float Vo = upward.getInitialVelocity();
        Float t = upward.getTime();

        result = h - (((vf + Vo) / 2.0f) * t);
        System.out.println("ho = h - (((vf + Vo) / 2) * t)");

        return result;
    }

}
