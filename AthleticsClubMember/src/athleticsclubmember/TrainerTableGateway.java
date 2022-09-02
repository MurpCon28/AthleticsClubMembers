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
public class TrainerTableGateway {

    // Declare all area in the trainer table
    private static final String TABLE_NAME = "trainer";
    private static final String COLUMN_TID = "tId";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SPORTSTYPE = "sportsType";

    private Connection mConnection;

    public TrainerTableGateway(Connection connection) {
        mConnection = connection;
    }

    public Trainer insertTrainer(String n, String s) throws SQLException {
        Trainer t = null;

        String query;     
        PreparedStatement stmt;        
        int numRowsAffected;  
        int tId;

        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_NAME + ", " +
                COLUMN_SPORTSTYPE + 
               ") VALUES (?, ?)";

        stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, n);
        stmt.setString(2, s);
      
        numRowsAffected = stmt.executeUpdate();
        if (numRowsAffected == 1) {
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();

            tId = keys.getInt(1);

            t = new Trainer(tId, n, s);
        }

        return t;
    }

    public Trainer getTrainer(int tId) throws SQLException {
        String query;           
        Statement stmt;                
        ResultSet rs;                   
       

        String name, sportsType;
        int id;
        

        Trainer t = null;  

        query = "SELECT * FROM " + TABLE_NAME + " WHERE tId = " + tId;
        
        System.out.println(query);
         
        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);

        while (rs.next()){
          tId = rs.getInt(COLUMN_TID);
          name = rs.getString(COLUMN_NAME);
          sportsType = rs.getString(COLUMN_SPORTSTYPE);
        
          t = new Trainer(tId, name, sportsType);
        }
        return t;
    }

}
