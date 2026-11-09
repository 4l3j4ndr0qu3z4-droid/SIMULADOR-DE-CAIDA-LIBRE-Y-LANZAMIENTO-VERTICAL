package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;


public class TorricelliFormulas {

    // vf = raiz( Vo2 + 2g(h-ho))
    public Float calculateFinalVelocity(Downward downward) {
        Float result = 0.0f;

        Float g = downward.getGravity().getPlanets();
        Float h = downward.getHeight();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene NINGUNA de las dos
            // vf2 = 2gh
            result = (float) Math.sqrt(2 * g * h);
            System.out.println("Vf2= (2gh)");

        } else if ((Vo == null || Vo == 0) && (ho != null && ho >= 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho
            // vf2 = 2g (h-ho)
            result = (float) Math.sqrt(2 * g * (h - ho));
            System.out.println("Vf2= (2g(h-ho))");

        } else if ((Vo != null && Vo >= 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho
            // vf2 = vo2 + 2gh)
            result = (float) Math.sqrt(Vo * Vo + 2 * g * h);
            System.out.println("Vf= raiz(Vo2 +  2gh)");
        } else {
            // 4. Tiene las DOS (Vo != null && ho != null)
            // vf2 = vo2 + 2g (h-ho)
            result = (float) Math.sqrt(Vo * Vo + 2 * g * (h - ho));
            System.out.println("Vf= raiz(Vo2 +  2g(h-ho))");
        }

        return result;
    }

    public Float calculateInitialVelocity(Downward downward) {

        Float result = null;

        Float g = downward.getGravity().getPlanets();
        Float h = downward.getHeight();
        Float ho = downward.getInitialHeight();
        Float Vf = downward.getFinalVelocity();

        if (ho == null || ho == 0) {
            // no hay ho
            // vo2 = vf2 -2gh
            result = ((float) Math.sqrt((Vf * Vf) - 2 * g * h));
            System.out.println("Vo= raiz(Vf2 - 2gh");
        } else if (ho > 0) {
            // hay ho
            // vo2 = vf2 -2g(h-ho)
            result = ((float) Math.sqrt((Vf * Vf) - 2 * g * (h - ho)));
            System.out.println("Vo= raiz(Vf2 - 2g(h-ho)");
        }
        return result;
    }

    public Float calculateGravity(Downward downward) {

        Float Vf = downward.getFinalVelocity();
        Float h = downward.getHeight();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();

        Float result = null;

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene NINGUNA de las dos
            // g = Vf2/2h
            result = (Vf * Vf) / (2 * h);
            System.out.println("g= Vf2/2h)");

        } else if ((Vo == null || Vo == 0) && (ho != null && ho >= 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho
            // g = Vf2/(2(h-ho))
            result = (Vf * Vf) / (2 * (h - ho));
            System.out.println("g= Vf2/(2(h-ho))");
        } else if ((Vo != null && Vo >= 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho
            // g = (Vf2-Vo2)/(2h)
            result = ((Vf * Vf) - (Vo * Vo)) / (2 * h);
            System.out.println("g= (Vf2-vo2)/2h)");
        } else {
            // 4. Tiene las DOS (Vo != null && ho != null)
            // g = (Vf2-Vo2)/(2(h-ho))
            result = ((Vf * Vf) - (Vo * Vo)) / (2 * (h - ho));
            System.out.println("g= (Vf2-vo2)/2h)");
        }
        return result;
    }

    public Float calculateHeight(Downward downward) {
        Float result = null;

        Float g = downward.getGravity().getPlanets();
        Float Vf = downward.getFinalVelocity();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene NINGUNA de las dos
            // h = vf2/ 2g
            result = (Vf * Vf) / (2 * g);
            System.out.println("h = vf2/ 2g");

        } else if ((Vo == null || Vo == 0) && (ho != null && ho >= 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho
            // h = vf2/ 2g   + ho
            result = (Vf * Vf) / (2 * g) + ho;
            System.out.println("h = vf2/ 2g   + ho");

        } else if ((Vo != null && Vo >= 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho
            // h = (vf2-vo2)/ 2g
            result = ((Vf * Vf) - (Vo * Vo)) / (2 * g);
            System.out.println("h = (vf2-vo2)/ 2g");
        } else {
            // 4. Tiene las DOS (Vo != null && ho != null)
            // h = (vf2-vo2)/ 2g   + ho
            result = ((Vf * Vf) - (Vo * Vo)) / (2 * g) + ho;
            System.out.println("h = (vf2-vo2)/ 2g   + ho");
        }
        return result;
    }

    public Float calculateInitialHeight(Downward downward) {
        Float result = null;

        Float g = downward.getGravity().getPlanets();
        Float h = downward.getHeight();
        Float Vo = downward.getInitialVelocity();
        Float Vf = downward.getFinalVelocity();

        if (Vo == null || Vo == 0) {
            // no hay Vo
            // ho = h - (Vf2)/2g
            result = h - ((Vf * Vf) / (2 * g));
            System.out.println("ho = h - ((Vf*Vf)/ (2*g))");
        } else if (Vo > 0) {
            // hay Vo
            // ho = h - (Vf2 - Vo2)/2g
            result = h - (((Vf * Vf) - (Vo * Vo)) / (2 * g));
            System.out.println("ho = h - (((Vf * Vf)-(Vo*Vo)) / (2 * g))");
        }
        return result;
    }
}
