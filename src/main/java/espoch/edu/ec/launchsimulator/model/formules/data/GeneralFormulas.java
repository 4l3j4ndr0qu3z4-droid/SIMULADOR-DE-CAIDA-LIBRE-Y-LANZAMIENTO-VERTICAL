package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;


public class GeneralFormulas {

    // h = ho + vo*t + (g*t*t)/2
    public Float calculateHeight(Downward downward) {
        Float result = 0.0f;

        Float g = downward.getGravity().getPlanets();
        Float t = downward.getTime();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene Vo ni ho (ambos son 0 o nulos)
            // h = (1/2) * g * t^2
            result = 0.5f * g * (t * t);
            System.out.println("h = (1/2) * g * t^2");
            System.out.println(result);

        } else if ((Vo == null || Vo == 0) && (ho != null && ho > 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho
            // h = ho + (1/2) * g * t^2
            result = ho + (0.5f * g * (t * t));
            System.out.println("h = ho + (1/2) * g * t^2");
            System.out.println(result);

        } else if ((Vo != null && Vo > 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho
            // h = (Vo * t) + (1/2) * g * t^2
            result = (Vo * t) + (0.5f * g * (t * t));
            System.out.println("h = (Vo * t) + (1/2) * g * t^2");
            System.out.println(result);

        } else if ((Vo != null && Vo > 0) && (ho != null && ho > 0)) {
            // 4. Tiene las DOS (ho y Vo)
            // h = ho + (Vo * t) + (1/2) * g * t^2
            result = ho + (Vo * t) + (0.5f * g * (t * t));
            System.out.println("h = ho + (Vo * t) + (1/2) * g * t^2");
            System.out.println(result);
        }

        return result;
    }

    // ho = h - vo*t - (g*t*t)/2
    public Float calculateInitialHeight(Downward downward) {
        Float result = 0.0f;

        Float g = downward.getGravity().getPlanets();
        Float h = downward.getHeight();
        Float t = downward.getTime();
        Float Vo = downward.getInitialVelocity();

        if (Vo == null || Vo == 0) {
            // 1. No tiene Vo -> ho = h - (1/2) * g * t^2
            result = h - (0.5f * g * (t * t));
            System.out.println("ho = h - (1/2) * g * t^2");

        } else if (Vo > 0) {
            // 2. SÍ tiene Vo -> ho = h - (Vo * t) - (1/2) * g * t^2
            result = h - (Vo * t) - (0.5f * g * (t * t));
            System.out.println("ho = h - (Vo * t) - (1/2) * g * t^2");

        }
        return result;
    }

    // vo = (2(h-ho)-(g*t*t)))/(2t)
    public Float calculateInitialVelocity(Downward downward) {
        Float result = 0.0f;

        Float g = downward.getGravity().getPlanets();
        Float h = downward.getHeight();
        Float t = downward.getTime();
        Float ho = downward.getInitialHeight();

        if (ho == null || ho == 0) {
            // 1. No tiene ho -> Vo = (h - (1/2) * g * t^2) / t
            result = (h - (0.5f * g * (t * t))) / t;
            System.out.println("Vo = (h - (1/2) * g * t^2) / t");

        } else if (ho > 0) {
            // 2. SÍ tiene ho -> Vo = (h - ho - (1/2) * g * t^2) / t
            result = (h - ho - (0.5f * g * (t * t))) / t;
            System.out.println("Vo = (h - ho - (1/2) * g * t^2) / t");

        }
        return result;
    }

    // t = (-vo +-  raiz (  Vo*Vo)  - 2*g (h-ho)))/g
    public Float calculateTime(Downward downward) {
        Float resultOne = 0.0f;
        Float resultTwo = 0.0f;
        Float correct = 0.0f;

        Float g = downward.getGravity().getPlanets();
        Float h = downward.getHeight();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();

        Float a = 0.5f * g;
        Float b = Vo;
        Float c = h - ho;
        Float discriminating = (b * b) - (4.0f * a * c);

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene Vo ni ho
            // t = (+-raiz(-2gh))/g
            if (discriminating >= 0) {
                Float raiz = (float) Math.sqrt(discriminating);
                resultOne = raiz / g;
                resultTwo = -raiz / g;
                System.out.println("t = +- raiz(2gh) / g");
            }

        } else if ((Vo == null || Vo == 0) && (ho != null && ho > 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho
            // t = (+-raiz(-2g(h-ho)))/g
            if (discriminating >= 0) {
                Float raiz = (float) Math.sqrt(discriminating);
                resultOne = raiz / g;
                resultTwo = -raiz / g;
                System.out.println("t = +- raiz(2g(ho - h)) / g");
            }

        } else if ((Vo != null && Vo > 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho
            // t = (- Vo +-raiz(-2gh))/g
            if (discriminating >= 0) {
                Float raiz = (float) Math.sqrt(discriminating);
                resultOne = (-Vo + raiz) / g;
                resultTwo = (-Vo - raiz) / g;
                System.out.println("t = (-Vo + raiz(Vo^2 + 2gh)) / g");
            }

        } else if ((Vo != null && Vo > 0) && (ho != null && ho > 0)) {
            // 4. Tiene las DOS (Vo y ho)
            // t = (- Vo +-raiz(-2g(h-ho)))/g
            if (discriminating >= 0) {
                Float raiz = (float) Math.sqrt(discriminating);
                resultOne = (-Vo + raiz) / g;
                resultTwo = (-Vo - raiz) / g;
                System.out.println("t = (-Vo + raiz(Vo^2 + 2g(ho - h))) / g");
            }

        }
        correct = Float.max(resultOne, resultTwo);
        System.out.println("1: " + resultOne);
        System.out.println("2: " + resultTwo);
        System.out.println("final: " + correct);
        return correct;

    }

    // g = (2(h-ho-(Vo*t)))/t*t
    public Float calculateGravity(Downward downward) {
        Float result = 0.0f;

        Float h = downward.getHeight();
        Float t = downward.getTime();
        Float ho = downward.getInitialHeight();
        Float Vo = downward.getInitialVelocity();

        if ((Vo == null || Vo == 0) && (ho == null || ho == 0)) {
            // 1. No tiene Vo ni ho -> g = (2 * h) / t^2
            result = (2 * h) / (t * t);
            System.out.println("g = (2 * h) / t^2");

        } else if ((Vo == null || Vo == 0) && (ho != null && ho > 0)) {
            // 2. NO tiene Vo, pero SÍ tiene ho -> g = (2 * (h - ho)) / t^2
            result = (2 * (h - ho)) / (t * t);
            System.out.println("g = (2 * (h - ho)) / t^2");

        } else if ((Vo != null && Vo > 0) && (ho == null || ho == 0)) {
            // 3. SÍ tiene Vo, pero NO tiene ho -> g = (2 * (h - (Vo * t))) / t^2
            result = (2 * (h - (Vo * t))) / (t * t);
            System.out.println("g = (2 * (h - (Vo * t))) / t^2");

        } else if ((Vo != null && Vo > 0) && (ho != null && ho > 0)) {
            // 4. Tiene las DOS (ho y Vo) -> g = (2 * (h - ho - (Vo * t))) / t^2
            result = (2 * (h - ho - (Vo * t))) / (t * t);
            System.out.println("g = (2 * (h - ho - (Vo * t))) / t^2");

        }
        return result;
    }

}
