package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;

public class AverageVelocityFormulas {

    public Float calculateHeight(Downward downward) {
        Float result = 0.0f;

        Float vf = downward.getFinalVelocity();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();
        Float t = downward.getTime();

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene Vo ni ho -> 
            // h = (vf / 2) * t
            result = (vf / 2.0f) * t;
            System.out.println("h = (vf / 2) * t");

        } else if ((Vo == null || Vo == 0) && (ho != null && ho > 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho ->
            // h = (vf / 2) * t - ho
            result = ((vf / 2.0f) * t) - ho;
            System.out.println("h = (vf / 2) * t - ho");

        } else if ((Vo != null && Vo > 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho -> 
            //h = ((vf + Vo) / 2) * t
            result = ((vf + Vo) / 2.0f) * t;
            System.out.println("h = ((vf + Vo) / 2) * t");

        } else if ((Vo != null && Vo > 0) && (ho != null && ho > 0)) {
            // 4. Tiene las DOS (Vo y ho) -> 
            //h = ((vf + Vo) / 2) * t - ho
            result = (((vf + Vo) / 2.0f) * t) - ho;
            System.out.println("h = ((vf + Vo) / 2) * t - ho");

        }
        return result;
    }

    public Float calculateInitialVelocity(Downward downward) {
        Float result = 0.0f;

        Float vf = downward.getFinalVelocity();
        Float h = downward.getHeight();
        Float ho = downward.getInitialHeight();
        Float t = downward.getTime();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> 
            //Vo = ((2 * h) / t) - vf
            result = ((2 * h) / t) - vf;
            System.out.println("Vo = ((2 * h) / t) - vf");

        } else if (ho > 0) {
            // 2. SÍ tiene ho -> 
            //Vo = ((2 * (h + ho)) / t) - vf
            result = ((2 * (h + ho)) / t) - vf;
            System.out.println("Vo = ((2 * (h + ho)) / t) - vf");
        }
        return result;
    }

    public Float calculateFinalVelocity(Downward downward) {

        Float result = 0.0f;

        Float h = downward.getHeight();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();
        Float t = downward.getTime();

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene Vo ni ho ->
            //vf = (2 * h) / t
            result = (2 * h) / t;
            System.out.println("vf = (2 * h) / t");

        } else if ((Vo == null || Vo == 0) && (ho != null && ho > 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho -> 
            //vf = (2 * (h + ho)) / t
            result = (2 * (h + ho)) / t;
            System.out.println("vf = (2 * (h + ho)) / t");

        } else if ((Vo != null && Vo > 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho ->
            //vf = ((2 * h) / t) - Vo
            result = ((2 * h) / t) - Vo;
            System.out.println("vf = ((2 * h) / t) - Vo");

        } else if ((Vo != null && Vo > 0) && (ho != null && ho > 0)) {
            // 4. Tiene las DOS (Vo y ho) ->
            //vf = ((2 * (h + ho)) / t) - Vo
            result = ((2 * (h + ho)) / t) - Vo;
            System.out.println("vf = ((2 * (h + ho)) / t) - Vo");

        }
        return result;
    }

    public Float calculateTime(Downward downward) {
        Float result = 0.0f;

        Float vf = downward.getFinalVelocity();
        Float h = downward.getHeight();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene Vo ni ho -> 
            //t = (2 * h) / vf
            result = (2 * h) / vf;
            System.out.println("t = (2 * h) / vf");

        } else if ((Vo == null || Vo == 0) && (ho != null && ho > 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho -> }
            //t = (2 * (h + ho)) / vf
            result = (2 * (h + ho)) / vf;
            System.out.println("t = (2 * (h + ho)) / vf");

        } else if ((Vo != null && Vo > 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho ->
            //t = (2 * h) / (vf + Vo)
            result = (2 * h) / (vf + Vo);
            System.out.println("t = (2 * h) / (vf + Vo)");

        } else if ((Vo != null && Vo > 0) && (ho != null && ho > 0)) {
            // 4. Tiene las DOS (Vo y ho) -> 
            //t = (2 * (h + ho)) / (vf + Vo)
            result = (2 * (h + ho)) / (vf + Vo);
            System.out.println("t = (2 * (h + ho)) / (vf + Vo)");

        }
        return result;
    }

    public Float calculateInitialHeight(Downward downward) {
        Float result = 0.0f;
        Float vf = downward.getFinalVelocity();
        Float h = downward.getHeight();
        Float Vo = downward.getInitialVelocity();
        Float t = downward.getTime();

        if (Vo == null || Vo == 0) {
            // 1. No tiene Vo -> 
            //ho = ((vf / 2) * t) - h
            result = ((vf / 2.0f) * t) - h;
            System.out.println("ho = ((vf / 2) * t) - h");
            
        } else if (Vo > 0) {
            // 2. SÍ tiene Vo -> 
            //ho = (((vf + Vo) / 2) * t) - h
            result = (((vf + Vo) / 2.0f) * t) - h;
            System.out.println("ho = (((vf + Vo) / 2) * t) - h");
            
        }

        return result;
    }
}
