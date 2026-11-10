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

        Upward  upOne = new Upward();
        upOne.setGravity(Gravity.EARTH);
        upOne.setTime(12.0f);
        upOne.setInitialVelocity(200.0f);
        InterfaceUpward InterfaceUpOne = new Upwards();
        System.out.println(InterfaceUpOne.searchFormule(upOne));

    }
}
