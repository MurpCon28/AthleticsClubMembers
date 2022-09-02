/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athleticsclubmember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import athleticsclubmember.Footballer;
import athleticsclubmember.Runner;
import athleticsclubmember.AthleticsClubMember;

/**
 *
 * @author user10
 */
public class AthleticsClubMemberTableGateway {

    // Used to declare all the variables from the table in the database.
    private static final String TABLE_NAME = "athleticsclubmember";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_SALARY = "salary";
    private static final String COLUMN_TID = "tId";
    private static final String COLUMN_SPORTTYPE = "sportType";
    private static final String COLUMN_TEAM = "team";
    private static final String COLUMN_POSITION = "position";
    private static final String COLUMN_GOALS = "goals";
    private static final String COLUMN_ASSISTS = "assists";
    private static final String COLUMN_SKILL = "skill";
    private static final String COLUMN_RACETYPE = "raceType";
    private static final String COLUMN_LONGESTDISTANCE = "longestDistance";
    private static final String COLUMN_WINS = "wins";
    private static final String COLUMN_BESTTIME = "bestTime";

    private Connection mConnection;

    public AthleticsClubMemberTableGateway(Connection connection) {
        mConnection = connection;
    }

    public List<AthleticsClubMember> getAlLAthleticsClubMemberBytId(int tId) throws SQLException {
        String query;
        Statement stmt;
        ResultSet rs;
        List<AthleticsClubMember> athleticsclubmember;              // This list contains the athletics club member objects that will return in the model
        // The list will contain Footballers and Runners

        String name, gender, team, position, skill, raceType, longestDistance, bestTime;
        int id, age, goals, assists, wins;
        double salary;

        Footballer f;
        Runner r;

        // This creates the SQL Query, this will read whatever the id is for the trainer, tID, from the athletics club member class
        query = "SELECT * FROM " + TABLE_NAME + " WHERE tId = " + tId;

        // statement object is created by using the database connection that will send the SQL query string to the database and run it.
        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);

        // The COLUMN_SPORTTYPE will either create a Footballer or a Runner object
        athleticsclubmember = new ArrayList<AthleticsClubMember>();
        while (rs.next()) {

            //default constructors from the athleticclubmember main class
            id = rs.getInt(COLUMN_ID);
            name = rs.getString(COLUMN_NAME);
            gender = rs.getString(COLUMN_GENDER);
            age = rs.getInt(COLUMN_AGE);
            salary = rs.getDouble(COLUMN_SALARY);
            tId = rs.getInt(COLUMN_TID);

            //if sportsType is same as footballer it uses the constructors from the footballer sub class
            if (rs.getString(COLUMN_SPORTTYPE).equals("footballer")) {
                team = rs.getString(COLUMN_TEAM);
                position = rs.getString(COLUMN_POSITION);
                goals = rs.getInt(COLUMN_GOALS);
                assists = rs.getInt(COLUMN_ASSISTS);
                skill = rs.getString(COLUMN_SKILL);
                f = new Footballer(id, name, gender, age, salary, tId, team, position, goals, assists, skill);
                athleticsclubmember.add(f);
                //if sportsType is same as runner it uses the constructors from the runner sub class
            } else if (rs.getString(COLUMN_SPORTTYPE).equals("runner")) {
                raceType = rs.getString(COLUMN_RACETYPE);
                longestDistance = rs.getString(COLUMN_LONGESTDISTANCE);
                wins = rs.getInt(COLUMN_WINS);
                bestTime = rs.getString(COLUMN_BESTTIME);
                r = new Runner(id, name, gender, age, salary, tId, raceType, longestDistance, wins, bestTime);
                athleticsclubmember.add(r);
            }

        }

        // This returns the list of club members to the athleticclubmember
        return athleticsclubmember;
    }

    // The tId in the athleticclubmember table is a foriegn key from the trainer table. 
    //this function inserts the footballer data into the database 
    public Footballer insertFootballer(String n, String g, int a, double sl, int tId, String t, String p, int gl, int as, String sk) throws SQLException, SQLIntegrityConstraintViolationException {
        Footballer f = null;

        String query;       // the SQL query to execute
        PreparedStatement stmt;         // the java.sql.PreparedStatement object used to execute the SQL query
        int numRowsAffected;
        int id;

        //  required SQL INSERT statement that has place holders for the values to be inserted into the database through the program by the user
        query = "INSERT INTO " + TABLE_NAME + " ("
                + COLUMN_NAME + ", "
                + COLUMN_GENDER + ", "
                + COLUMN_AGE + ", "
                + COLUMN_SALARY + ", "
                + COLUMN_TID + ", "
                + COLUMN_SPORTTYPE + ", "
                + COLUMN_TEAM + ", "
                + COLUMN_POSITION + ", "
                + COLUMN_GOALS + ", "
                + COLUMN_ASSISTS + ", "
                + COLUMN_SKILL 
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // a PreparedStatement object is created to run the query and insert the values into the query
        stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, n);
        stmt.setString(2, g);
        stmt.setInt(3, a);
        stmt.setDouble(4, sl);
        stmt.setInt(5, tId);

        // the sportsType column in the athleticclubmember table is set to footballer so it knows the print the footballer constructors
        stmt.setString(6, "footballer");
        stmt.setString(7, t);
        stmt.setString(8, p);
        stmt.setInt(9, gl);
        stmt.setInt(10, as);
        stmt.setString(11, sk);

        //  Runs the query and make sure that only one row was inserted
        numRowsAffected = stmt.executeUpdate();
        if (numRowsAffected == 1) {
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();

            id = keys.getInt(1);
            f = new Footballer(id, n, g, a, sl, tId, t, p, gl, as, sk);
        }

        // returns the footballer object created from f
        return f;
    }

    public List<Footballer> getFootballer() throws SQLException {
        String query;                   // the SQL query to execute
        Statement stmt;                 // the java.sql.Statement object used to execute the SQL query
        ResultSet rs;                   // the java.sql.ResultSet representing the result of SQL query
        List<Footballer> footballers;   // the java.util.List containing the Footballer objects created for each row
        // in the result of the query the id of a footballer

        String name, gender, team, position, skill;
        int id, age, tId, goals, assists;
        double salary;

        Footballer f;                   // a Footballer object was created from a row in the result of the query

        // WHERE sportsType is same as footballer it gathers and prints all the variables of footballers from the database. 
        query = "SELECT * FROM " + TABLE_NAME + " WHERE sportType = 'footballer'";

        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);
        
        // gathers all the data from each row in the datbase and stores it in the Footballer object.
        //Then it is added into an empty arraylist which when gathered all the data will print in the prgram
        footballers = new ArrayList<Footballer>();
        while (rs.next()) {
            id = rs.getInt(COLUMN_ID);
            name = rs.getString(COLUMN_NAME);
            gender = rs.getString(COLUMN_GENDER);
            age = rs.getInt(COLUMN_AGE);
            salary = rs.getDouble(COLUMN_SALARY);
            tId = rs.getInt(COLUMN_TID);
            team = rs.getString(COLUMN_TEAM);
            position = rs.getString(COLUMN_POSITION);
            goals = rs.getInt(COLUMN_GOALS);
            assists = rs.getInt(COLUMN_ASSISTS);
            skill = rs.getString(COLUMN_SKILL);

            f = new Footballer(id, name, gender, age, salary, tId, team, position, goals, assists, skill);
            footballers.add(f);
        }

        // returns the arraylist of Footballer objects gathered
        return footballers;
    }
    
    public Runner insertRunner(String n, String g, int a, double sl, int tId, String rt, String ld, int w, String bs) throws SQLException, SQLIntegrityConstraintViolationException {
        Runner r = null;

        String query;       // the SQL query to execute
        PreparedStatement stmt;         // the java.sql.PreparedStatement object used to execute the SQL query
        int numRowsAffected;
        int id;

        query = "INSERT INTO " + TABLE_NAME + " ("
                + COLUMN_NAME + ", "
                + COLUMN_GENDER + ", "
                + COLUMN_AGE + ", "
                + COLUMN_SALARY + ", "
                + COLUMN_TID + ", "
                + COLUMN_SPORTTYPE + ", "
                + COLUMN_RACETYPE + ", "
                + COLUMN_LONGESTDISTANCE + ", "
                + COLUMN_WINS + ", "
                + COLUMN_BESTTIME 
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, n);
        stmt.setString(2, g);
        stmt.setInt(3, a);
        stmt.setDouble(4, sl);
        stmt.setInt(5, tId);

        // the sportsType column in the athleticclubmember table is set to runner so it knows the print the runner constructors
        stmt.setString(6, "runner");
        stmt.setString(7, rt);
        stmt.setString(8, ld);
        stmt.setInt(9, w);
        stmt.setString(10, bs);

        numRowsAffected = stmt.executeUpdate();
        if (numRowsAffected == 1) {
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();

            id = keys.getInt(1);
            r = new Runner(id, n, g, a, sl, tId, rt, ld, w, bs);
        }

        return r;
    }

    public List<Runner> getRunner() throws SQLException {
        String query;                   
        Statement stmt;                 
        ResultSet rs;                   
        List<Runner> runners;   

        String name, gender, raceType, longestDistance, bestTime;
        int id, age, tId, wins;
        double salary;

        Runner r;                   

        // WHERE sportsType is same as runner it gathers and prints all the variables of runners from the database. 
        query = "SELECT * FROM " + TABLE_NAME + " WHERE sportType = 'runner'";

        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);

        // gathers all the data from each row in the datbase and stores it in the Runner object.
        //Then it is added into an empty arraylist which when gathered all the data will print in the program
        runners = new ArrayList<Runner>();
        while (rs.next()) {
            id = rs.getInt(COLUMN_ID);
            name = rs.getString(COLUMN_NAME);
            gender = rs.getString(COLUMN_GENDER);
            age = rs.getInt(COLUMN_AGE);
            salary = rs.getDouble(COLUMN_SALARY);
            tId = rs.getInt(COLUMN_TID);
            raceType = rs.getString(COLUMN_RACETYPE);
            longestDistance = rs.getString(COLUMN_LONGESTDISTANCE);
            wins = rs.getInt(COLUMN_WINS);
            bestTime = rs.getString(COLUMN_BESTTIME);

            r = new Runner(id, name, gender, age, salary, tId, raceType, longestDistance, wins, bestTime);
            runners.add(r);
        }
        return runners;
    }

}
