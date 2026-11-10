/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package espoch.edu.ec.launchsimulator;

import espoch.edu.ec.launchsimulator.model.formules.access.InterfaceDownward;
import espoch.edu.ec.launchsimulator.model.formules.access.InterfaceUpward;
import espoch.edu.ec.launchsimulator.model.formules.data.Downwards;
import espoch.edu.ec.launchsimulator.model.formules.data.Upwards;
import espoch.edu.ec.launchsimulator.model.formules.enumeration.Gravity;
import espoch.edu.ec.launchsimulator.model.formules.objects.Downward;
import espoch.edu.ec.launchsimulator.model.formules.objects.Upward;

/**
 *
 * @author aleja
 */
public class LaunchSimulator {

    public static void main(String[] args) {
        Downward downOne = new Downward();
        downOne.setGravity(Gravity.EARTH);
        downOne.setTime(12.0f);
        downOne.setInitialVelocity(200.0f);
        InterfaceDownward InterfaceDownOne = new Downwards();
        System.out.println(InterfaceDownOne.searchFormule(downOne));

        Downward downTwo = new Downward();
        downTwo.setGravity(Gravity.EARTH);
        downTwo.setTime(12.0f);
        downTwo.setInitialVelocity(200.0f);
        downTwo.setInitialHeight(0.0f);
        InterfaceDownward InterfaceDownTwo = new Downwards();
        System.out.println(InterfaceDownTwo.searchFormule(downTwo));
    }
}
