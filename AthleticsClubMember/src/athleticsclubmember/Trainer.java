/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athleticsclubmember;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author N00180141
 */
public class Trainer {

    private int tId;
    private String name;
    private String sportsType;

    private List<AthleticsClubMember> athleticsclubmember;

    public Trainer(String name, String sportsType) {
        this.name = name;
        this.sportsType = sportsType;
        
        athleticsclubmember = new ArrayList();
    }
    
    public Trainer(int id, String name, String sportsType) {
        this.tId = id;
        this.name = name;
        this.sportsType = sportsType;

        athleticsclubmember = new ArrayList();
    }
    
    public void addTrainer(AthleticsClubMember a){
        athleticsclubmember.add(a);
    }
    
    // remove a staff member from the maangers list of staff
    public void removeTrainer(AthleticsClubMember a){
        athleticsclubmember.remove(a);
    }
    
    public int getTrainer() {
        return tId;
    }

    public void setTrainer(int tId) {
        this.tId = tId;
    }
    
    public List <AthleticsClubMember> getAthleticsClubMember() {
        return athleticsclubmember;
    }
    
    public void setAthleticsClubMember(List <AthleticsClubMember> athleticsclubmember) {
        this.athleticsclubmember = athleticsclubmember;
    }
    
    public int getTID() {
        return tId;
    }
  
    public void setTID(int tId) {
        this.tId = tId;
    }
   
    public String getName() {
        return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }

    public String getSportsType() {
        return sportsType;
    }

    public void setSportsType(String sportsType) {
        this.sportsType = sportsType;
    }
    
    public String printTrainerInfo() {
        return  " Trainer ID:" + getTID() + " Trainer Name:"+ getName() + " Sport Type:" + getSportsType() + "";
    }
 
}
