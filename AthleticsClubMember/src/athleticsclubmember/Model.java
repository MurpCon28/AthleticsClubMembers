/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athleticsclubmember;

import athleticsclubmember.AthleticsClubMemberTableGateway;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Model {
    
     private static Model instance = null;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    //all footballers, runners and athleticsclubmember have been put into an list
    private List<Footballer> footballers;
    private List<Runner> runners;
    private List<AthleticsClubMember> athleticsclubmember;
  
    // code for footballers and runners and athleticsclubmember are in one tablegateway, trainers is in another. Means less files
    private AthleticsClubMemberTableGateway aGateway;
    private TrainerTableGateway tGateway;
       

    private Model() {

        try {
            Connection conn = DBConnection.getInstance();
            this.aGateway = new AthleticsClubMemberTableGateway(conn);
            this.tGateway = new TrainerTableGateway(conn);

        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addFootballer(Footballer f) {
        Footballer pWithId = null;
        try {
             pWithId = this.aGateway.insertFootballer(
                   f.getName(), f.getGender(), f.getAge(), f.getSalary(), f.getTId(), f.getTeam(), f.getPosition() , f.getGoals() , f.getAssists() , f.getSkill());
          
            
        } 
        catch (SQLIntegrityConstraintViolationException fkExe)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, fkExe);
            System.out.println("Trainer ID does not exist, try again");
            return false;
        }
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        if (pWithId != null)
                return true;
        else 
            return false;
        
       
    }
    
    
     public List viewFootballers() {
        try {
            this.footballers = this.aGateway.getFootballer();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return footballers;
    }
     
     public boolean addRunner(Runner r) {
        Runner pWithId = null;
        try {
             pWithId = this.aGateway.insertRunner(
                   r.getName(), r.getGender(), r.getAge(), r.getSalary(), r.getTId(), r.getRaceType(), r.getLongestDistance() , r.getWins() , r.getBestTime());
          
            
        } 
        catch (SQLIntegrityConstraintViolationException fkExe)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, fkExe);
            System.out.println("Trainer ID does not exist, try again");
            return false;
        }
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        if (pWithId != null)
                return true;
        else 
            return false;
        
       
    }
    
    
     public List viewRunners() {
        try {
            this.runners = this.aGateway.getRunner();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return runners;
    }
     
     public boolean addTrainer(Trainer t) {
        Trainer pWithId = null;
        try {
             pWithId = this.tGateway.insertTrainer(
                   t.getName(), t.getSportsType());
          
            
        } 
        catch (SQLIntegrityConstraintViolationException fkExe)
        {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, fkExe);
            System.out.println("Trainer ID does not exist, try again");
            return false;
        }
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        if (pWithId != null)
                return true;
        else 
            return false;
        
       
    }
         
      // gets the trainer from the database, if trainer exists it goes to the athleticsclubmember table to get all athleticsclubmember with that trainer tId 
    public Trainer viewTrainer(int id) {
        Trainer t = null;
        try {
            t = this.tGateway.getTrainer(id);
            
            // Trainer exists get all athleticsclubmember for that trainer
            if (t != null){
                // get athleticsclubmember from AthleticsClubMemberTablGateway
                athleticsclubmember = aGateway.getAlLAthleticsClubMemberBytId(t.getTrainer());
                t.setAthleticsClubMember(athleticsclubmember);
            }
        
        } 
                
        catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return t; 
    
}
      
     
}
