/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferdeveloper.persistencia.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ferdeveloper.persistencia.jdbc.ConnectionFactory;

/**
 *
 * @author fernandoarenasdev
 */
public class ConnectionFactoryImplDriveManager implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/control_ejercicios", "root", "");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return connection;
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
