package espoch.edu.ec.launchsimulator.model.formules.data;

import espoch.edu.ec.launchsimulator.model.formules.access.InterfaceUpward;
import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;
import java.util.Scanner;

public class Upwards extends Downwards implements InterfaceUpward {

    @Override
    public boolean compareUnits(Upward upward) {
        boolean result = false;
        return result;
    }

    @Override
    public Float searchFormule(Upward upward) {
        Float result = 0.0f;

        boolean haveT = upward.getTime() != null;
        boolean haveVf = upward.getFinalVelocity() != null;
        boolean haveH_Ho = upward.getHeight() != null || upward.getInitialHeight() != null;
        boolean haveG = upward.getGravity() != null && upward.getGravity().getPlanets() != null;

        if (!haveH_Ho) {
            result = mathEquation(upward);
        } else if (!haveVf) {
            result = generalEquation(upward);
        } else if (!haveT) {
            result = torricelli(upward);
        } else if (!haveG) {
            result = averageVelocity(upward);
        }
        return result;
    }

    @Override
    public Float torricelli(Upward upward) {
        boolean haveVf = upward.getFinalVelocity() != null;
        boolean haveH_Ho = upward.getHeight() != null || upward.getInitialHeight() != null;
        boolean haveVo = upward.getInitialVelocity() != null;
        boolean haveG = upward.getGravity() != null && upward.getGravity().getPlanets() != null;

        Float result = 0.0f;
        TorricelliFormulaUps torricelli = new TorricelliFormulaUps();

        if (!haveVf) {
            result = torricelli.calculateFinalVelocity(upward);
        } else if (!haveH_Ho) {
            result = torricelli.calculateHeight(upward);
        } else if (!haveVo) {
            result = torricelli.calculateInitialVelocity(upward);
        } else if (!haveG) {
            result = torricelli.calculateGravity(upward);
        }
        return result;
    }

    @Override
    public Float generalEquation(Upward upward) {
        boolean haveT = upward.getTime() != null && upward.getTime() > 0;
        boolean haveH = upward.getHeight() != null && upward.getHeight() >= 0;
        boolean haveHo = upward.getInitialHeight() != null && upward.getInitialHeight() >= 0;
        boolean haveVo = upward.getInitialVelocity() != null && upward.getInitialVelocity() >= 0;
        boolean haveG = upward.getGravity() != null && upward.getGravity().getPlanets() != null && upward.getGravity().getPlanets() > 0;
        Float result = 0.0f;
        GeneralFormulaUps general = new GeneralFormulaUps();

        if (haveT == false) {
            result = general.calculateTime(upward);
        } else if (haveH == false) {
            result = general.calculateHeight(upward);
        } else if (haveHo == false) {
            result = general.calculateInitialHeight(upward);
        } else if (haveVo == false) {
            result = general.calculateInitialVelocity(upward);
        } else if (haveG == false) {
            result = general.calculateGravity(upward);
        }
        return result;
    }

    @Override
    public Float mathEquation(Upward upward) {
        boolean haveT = upward.getTime() != null && upward.getTime() > 0;
        boolean haveVf = upward.getFinalVelocity() != null && upward.getFinalVelocity() > 0;
        boolean haveVo = upward.getInitialVelocity() != null && upward.getInitialVelocity() >= 0;
        boolean haveG = upward.getGravity() != null && upward.getGravity().getPlanets() != null && upward.getGravity().getPlanets() > 0;

        Float result = 0.0f;

        MathematicalFormulaUps math = new MathematicalFormulaUps();

        if (haveT == false) {
            result = math.calculateTime(upward);
        }
        if (haveVo == false) {
            result = math.calculateInitialVelocity(upward);
        }
        if (haveVf == false) {
            result = math.calculateFinalVelocity(upward);
        }

        if (haveG == false) {
            result = math.calculateGravity(upward);
        }
        return result;
    }

    @Override
    public Float averageVelocity(Upward upward) {
        return  super.averageVelocity(upward);
    }

    @Override
    public Float searchUpward(Upward upward) {

        Scanner scanner = new Scanner(System.in);
        Float result = 0.0f;
        System.out.println("Which formula for upward launch do you wish to calculate? ");
        System.out.println("1. RISE TIME");
        System.out.println("2. FLIGHT TIME ");
        System.out.println("3. MAXIMUM HEGHT");
        System.out.println("4. TOTAL DISTANCE");
        int opc = scanner.nextInt();
        switch (opc) {
            case 1 -> {
                System.out.println("Ts = Vo/g");
                result = (upward.getInitialVelocity() / upward.getGravity().getPlanets());
            }
            case 2 -> {
                result = ((2 * upward.getInitialVelocity()) / upward.getGravity().getPlanets());
                System.out.println("Tv = 2Vo/g");
            }
            case 3 -> {
                result = ((upward.getInitialVelocity() * upward.getInitialVelocity()) / (2 * upward.getGravity().getPlanets()));
                System.out.println("Hmax = (Vo*Vo)/2g");
            }
            case 4 -> {
                System.out.println("Rt = (Vo* Vo)/g");
                result = ((upward.getInitialVelocity() * upward.getInitialVelocity()) / upward.getGravity().getPlanets());
            }
            default -> {
                System.out.println("Has cometido un error");
                throw new AssertionError();
            }
        }
        return result;
    }

}
