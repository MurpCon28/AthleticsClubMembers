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
public class Runner extends AthleticsClubMember {

    private String raceType;
    private String longestDistance;
    private int wins;
    private String bestTime;

    public Runner(String n, String g, int a, double sl, int tId, String raceType, String longestDistance, int wins, String bestTime) {
        super(n, g, a, sl, tId);
        this.raceType = raceType;
        this.longestDistance = longestDistance;
        this.wins = wins;
        this.bestTime = bestTime;
    }

    public Runner(int id, String n, String g, int a, double sl, int tId, String raceType, String longestDistance, int wins, String bestTime) {
        super(id, n, g, a, sl, tId);
        this.raceType = raceType;
        this.longestDistance = longestDistance;
        this.wins = wins;
        this.bestTime = bestTime;
    }

    @Override
    public void printSportsType(){
        System.out.println("Runner:");
    }
    
    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getLongestDistance() {
        return longestDistance;
    }

    public void setLongestDistance(String longestDistance) {
        this.longestDistance = longestDistance;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getBestTime() {
        return bestTime;
    }

    public void setBestTime(String bestTime) {
        this.bestTime = bestTime;
    }

    @Override
    public String toString() {
        return super.toString() + " Race Type:"+ getRaceType() + " Longest Distance Ran:" + getLongestDistance() + " Wins:"+ getWins() + " Best Time:" + getBestTime() ;
    }

}