/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jdbc;

import java.sql.Connection;


/**
 *
 * @author fernandoarenasdev
 */
public interface ConnectionFactory {
    Connection getConnection();
    void closeConnection(Connection connection);
}
