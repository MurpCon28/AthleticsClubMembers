/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athleticsclubmember;

/**
 *
 * @author N00180141
 */
public class Footballer extends AthleticsClubMember {

    private String team;
    private String position;
    private int goals;
    private int assists;
    private String skill;

    public Footballer(String n, String g, int a, double sl, int tId, String team, String position, int goals, int assists, String skill) {
        super(n, g, a, sl, tId);
        this.team = team;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        this.skill = skill;
    }

    public Footballer(int id, String n, String g, int a, double sl, int tId, String team, String position, int goals, int assists, String skill) {
        super(id, n, g, a, sl, tId);
        this.team = team;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        this.skill = skill;
    }

    @Override
    public void printSportsType() {
        System.out.println("Footballer:");
    }
    
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return super.toString() + " Team:" + getTeam() + " Position:"+ getPosition() + " Goals:" + getGoals() + " Assists:"+ getAssists() + " Skill:" + getSkill();
    }

}
