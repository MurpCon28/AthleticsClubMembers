/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;
import athleticsclubmember.Footballer;
import athleticsclubmember.Runner;
import athleticsclubmember.Trainer;

/**
 *
 * @author wrighta
 */
public class Input {
     // Called to read new footballer when the user chooses the Create Footballer option
    public static Footballer readFootballer() {
        String name, gender, team, position, skill;
        int id, age, tId, goals, assists;
        double salary;
        Scanner keyboard = new Scanner(System.in);
        
      
        // the program asks the user for all the variables needed for the database, id isnt required as it is auto incramented(automatic)
        System.out.print("Enter name : ");
        name = keyboard.nextLine();
       
        System.out.print("Enter gender : ");
        gender = keyboard.nextLine();
       
        System.out.print("Enter age : ");
        age = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.print("Enter salary : ");
        salary = keyboard.nextDouble();
        keyboard.nextLine();
        
        System.out.print("Enter trainer id : ");
        tId = keyboard.nextInt();
        keyboard.nextLine();
       
        System.out.print("Enter team : ");
        team = keyboard.nextLine();
        
        System.out.print("Enter position : ");
        position = keyboard.nextLine();
        
        System.out.print("Enter goals : ");
        goals = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.print("Enter assists : ");
        assists = keyboard.nextInt();
        keyboard.nextLine();
       
        System.out.print("Enter skill : ");
        skill = keyboard.nextLine();
        
        // Footballer is object f, it creates a new footballer
        Footballer f = 
                new Footballer(name, gender, age, salary, tId, team, position, goals, assists, skill);
        return f;       
    
    }
    
    public static Runner readRunner() {
        String name, gender, raceType, longestDistance, bestTime;
        int id, age, tId, wins;
        double salary;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter name : ");
        name = keyboard.nextLine();
       
        System.out.print("Enter gender : ");
        gender = keyboard.nextLine();
       
        System.out.print("Enter age : ");
        age = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.print("Enter salary : ");
        salary = keyboard.nextDouble();
        keyboard.nextLine();
        
        System.out.print("Enter trainer id : ");
        tId = keyboard.nextInt();
        keyboard.nextLine();
       
        System.out.print("Enter race type : ");
        raceType = keyboard.nextLine();
        
        System.out.print("Enter longest distance : ");
        longestDistance = keyboard.nextLine();
        
        System.out.print("Enter wins : ");
        wins = keyboard.nextInt();
        keyboard.nextLine();
       
        System.out.print("Enter best time : ");
        bestTime = keyboard.nextLine();
        
        Runner r = 
                new Runner(name, gender, age, salary, tId, raceType, longestDistance, wins, bestTime);
        return r;       
    
    }
    
    public static Trainer readTrainer() {
        String name, sportsType;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter name : ");
        name = keyboard.nextLine();

        System.out.print("Enter sports type : ");
        sportsType = keyboard.nextLine();

        Trainer t = new Trainer(name, sportsType);

        return t;

    }
}
