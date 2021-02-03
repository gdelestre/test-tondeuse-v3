package fr.publicis;

import fr.publicis.helper.StartProgHelper;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        StartProgHelper.loadAllDataFromTxt();

        if (StartProgHelper.validDataFormat()) {
            System.out.println("Données valides");

            if (StartProgHelper.createItems()) {
                StartProgHelper.startLawnmower();
            } else {
                System.out.println("Erreur sur une tondeuse");
            }

        }else
            System.out.println("Fin du programme");

    }
}
