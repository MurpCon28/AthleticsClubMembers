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
public abstract class AthleticsClubMember implements Printable {
    private int id;
    private String name;
    private String gender;
    private int age;
    private double salary;
    private int tId;
    
    public AthleticsClubMember(String n, String g, int a, double sl, int tId) {
       this.name = n;
       this.gender = g;
       this.age = a;
       this.salary = sl;
       this.tId = tId;
    }
    
    public AthleticsClubMember(int id, String n, String g, int a, double sl, int tId) {
     // assigned the values into this constructor with the variables above  
       this.id = id;
       this.name = n;
       this.gender = g;
       this.age = a;
       this.salary = sl;
       this.tId = tId;
    }
    
    //makes a public void which stores in each sub-class the sport type. It is created here first and called in other areas of the code.
    public abstract void printSportsType();
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void salary(double salary) {
        this.salary = salary;
    }
    
    public int getTId() {
        return tId;
    }

    public void setTId(int tId) {
        this.tId = tId;
    }
    
    @Override
    public String toString()
    {
        //prints out all the variables from the constructor
        return "ID:"+ getId() + " Name:" + getName() + " Gender:"+ getGender() + " Age:" + getAge() + " Salary:" + getSalary() + " Trainer ID:" + getTId() + " ";
    }
    
    public int getTrainer() {
        return tId;
    }
    
    public void setTrainer(int id) {
        this.tId = id;
    }
}
