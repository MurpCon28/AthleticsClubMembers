/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athleticsclubmember;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.Input;

/**
 *
 * @author N00180141
 */
public class DemoApp {

    /**
     * @param args the command line arguments
     */
    static Model model;
    static Scanner keyboard;

    public static void main(String[] args) {
        // TODO code application logic here

        keyboard = new Scanner(System.in);
        model = Model.getInstance();

        int opt;

        /**
         * ***********************************************
         ************* DISPLAY MENU **********************
         * *********************************************
         */
        do {
            System.out.println("\n***********MENU************");
            System.out.println("1. Create new Footballer");
            System.out.println("2. View all Footballers");
            System.out.println("3. Create new Runner");
            System.out.println("4. View all Runners");
            System.out.println("5. Create new Trainer");
            System.out.println("6. Get trainer and athletic member by trainer ID");

            System.out.println("8. Exit");
            System.out.println("**************************");
            System.out.println();

            System.out.print("Enter option: ");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);

            /**
             * *********************************************
             ****** DECIDE WHAT OPTION USER CHOSE***********
             * *********************************************
             */
            switch (opt) {
                case 1: {
                    System.out.println("Creating footballer");

                    // The code for inserting a footballer to through the program into the databse has been put into an utils folder in a file called Input.java . 
                    Footballer f = Input.readFootballer();
                    boolean created = model.addFootballer(f);
                    if (created) {
                        System.out.println("Footballer Created successfully");
                    } else {
                        System.out.println("Footballer not created");
                    }
                    break;
                }

                case 2: {
                    //calls the object viewFootballers which has the code to show all the footballers in the database
                    System.out.println("Viewing footballers");
                    viewFootballers();
                    break;
                }
                
                case 3: {
                    System.out.println("Creating runner");

                    // The code for runners to insert into the databse is also in the utils folder in a file called Input.java 
                    Runner r = Input.readRunner();
                    boolean created = model.addRunner(r);
                    if (created) {
                        System.out.println("Runner Created successfully");
                    } else {
                        System.out.println("Runner not created");
                    }
                    break;
                }

                case 4: {
                    System.out.println("Viewing runner");
                    viewRunners();
                    break;
                }
                
                case 5: {
                    System.out.println("Creating trainer");

                    // The code for trainers to insert into the databse is also in the utils folder in a file called Input.java  
                    Trainer t = Input.readTrainer();
                    boolean created = model.addTrainer(t);
                    if (created) {
                        System.out.println("Trainer Created successfully");
                    } else {
                        System.out.println("Trainer not created");
                    }
                    break;
                }

                case 6: {
                    System.out.println("Get trainer By ID");
                    getTrainer();
                    break;
                }
            }
        } while (opt != 8);
        System.out.println("Goodbye");
    } // END OF MAIN()

    private static void viewFootballers() {
        List<Footballer> footballers = model.viewFootballers();
        for (Footballer fs : footballers) {
            System.out.println(fs.toString());
        }
    }
    
    private static void viewRunners() {
        List<Runner> runners = model.viewRunners();
        for (Runner rs : runners) {
            System.out.println(rs.toString());
        }
    }

    private static void getTrainer() {

        System.out.print("Enter trainer ID : ");
        int tId = keyboard.nextInt();
        keyboard.nextLine();

        Trainer t = model.viewTrainer(tId);
        t.printTrainerInfo();

    }
}
