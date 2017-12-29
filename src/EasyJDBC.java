
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author the Code
 */
public class EasyJDBC {

    private Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String DBUsername;
    private String DBPassword;

    public void setDBUsername(String DBUsername) {
        this.DBUsername = DBUsername;
    }

    public void setDBPassword(String DBPassword) {
        this.DBPassword = DBPassword;
    }

    public Connection getConnection() {
        return con;
    }

    public void SetConnection(Connection con) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", this.DBUsername, this.DBPassword);
            this.con = con;
        } catch (ClassNotFoundException | SQLException ex) {

        }
    }

    private Statement getStatement() {
        try {
            statement = this.getConnection().createStatement();
        } catch (SQLException ex) {
        }
        return statement;
    }

    private PreparedStatement getPreparedStatement() {
        return this.preparedStatement;
    }

    public void createPreparedStatement(String SQL) {
        try {
            preparedStatement = this.getConnection().prepareStatement(SQL);
        } catch (SQLException ex) {
        }
    }

    public ResultSet getResultSet(String SQL) {
        try {
            this.resultSet = this.getStatement().executeQuery(SQL);
        } catch (SQLException ex) {
        }
        return this.resultSet;
    }
}
