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
        downOne.setHeight(0.0f);
        downOne.setInitialVelocity(15.0f);
        downOne.setInitialHeight(100.0f);
        InterfaceDownward InterfaceDownOne = new Downwards();
        System.out.println(InterfaceDownOne.searchFormule(downOne));
    
    }
}
