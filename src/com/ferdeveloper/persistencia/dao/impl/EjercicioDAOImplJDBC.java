package com.ferdeveloper.persistencia.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ferdeveloper.negocio.dominio.Ejercicio;
import com.ferdeveloper.persistencia.dao.EjercicioDAO;
import com.ferdeveloper.persistencia.jdbc.ConnectionFactory;
import com.ferdeveloper.persistencia.jdbc.impl.ConnectionFactoryImplDriveManager;
import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fernandoarenasdev
 */
public class EjercicioDAOImplJDBC implements EjercicioDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Ejercicio get(int idEjercicio) {

        try {
            Ejercicio ejercicio = null;
            Connection connection = connectionFactory.getConnection();
            
            String selectSQL = "SELECT nombreEjercicio, descripcionEjercicio, categoriaEjercicio, fechaEjercicio, observacionesEjercicio FROM ejercicios WHERE idEjercicio = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, idEjercicio);
            
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombreEjercicio = rs.getString("nombreEjercicio");
                String descripcionEjercicio = rs.getString("descripcionEjercicio");
                String categoriaEjercicio = rs.getString("categoriaEjercicio");
                Date fechaEjercicio = rs.getDate("fechaEjercicio");
                String observacionesEjercicio = rs.getString("observacionesEjercicio");

                ejercicio = new Ejercicio(idEjercicio, nombreEjercicio, categoriaEjercicio, descripcionEjercicio, fechaEjercicio, observacionesEjercicio);

            }
            return ejercicio;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Ejercicio insert(Ejercicio ejercicio) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactoryImplDriveManager();
            String insertTableSQL = "INSERT INTO ejercicios"
                    + "(nombreEjercicio, descripcionEjercicio, categoriaEjercicio, fechaEjercicio, observacionesEjercicio) VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(insertTableSQL);
            preparedStatement.setString(1, ejercicio.getNombreEjercicio());
            preparedStatement.setString(2, ejercicio.getDescripcionEjercicio());
            preparedStatement.setString(3, ejercicio.getCategoriaEjercicio());
            preparedStatement.setDate(4, ejercicio.getFechaEjercicio());
            preparedStatement.setString(5, ejercicio.getObservacionesEjercicio());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ejercicio;
    }

    @Override
    public Ejercicio update(Ejercicio ejercicio) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactoryImplDriveManager();
            String updateTableSQL = "UPDATE ejercicios SET nombreEjercicio = ?, descripcionEjercicio = ?, categoriaEjercicio = ?, fechaEjercicio = ?, observacionesEjercicio = ? WHERE idEjercicio = ?";
            PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(updateTableSQL);
            preparedStatement.setString(1, ejercicio.getNombreEjercicio());
            preparedStatement.setString(2, ejercicio.getDescripcionEjercicio());
            preparedStatement.setString(3, ejercicio.getCategoriaEjercicio());
            preparedStatement.setDate(4, ejercicio.getFechaEjercicio());
            preparedStatement.setString(5, ejercicio.getObservacionesEjercicio());
            preparedStatement.setInt(6, ejercicio.getIdEjercicio());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ejercicio;
    }

    @Override
    public boolean delete(int idEjercicio) {

        boolean borrado = false;
        try {

            ConnectionFactory connectionFactory = new ConnectionFactoryImplDriveManager();

            String deleteSQL = "DELETE FROM ejercicios WHERE idEjercicio = ?";
            PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(deleteSQL);
            preparedStatement.setInt(1, idEjercicio);

            int filasBorradas = preparedStatement.executeUpdate();

            if (filasBorradas == 1) {
                borrado = true;
            } else if (filasBorradas == 0) {
                borrado = false;
            } else {
                throw new RuntimeException("Existe mas de una fila.");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return borrado;

    }

    @Override
    public List<Ejercicio> findAll() {

        List<Ejercicio> ejercicios = new ArrayList<>();

        try {

            ConnectionFactory connectionFactory = new ConnectionFactoryImplDriveManager();

            String selectSQL = "SELECT * FROM ejercicios";
            PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idEjercicio = rs.getInt("idEjercicio");
                String nombreEjercicio = rs.getString("nombreEjercicio");
                String descripcionEjercicio = rs.getString("descripcionEjercicio");
                String categoriaEjercicio = rs.getString("categoriaEjercicio");
                Date fechaEjercicio = rs.getDate("fechaEjercicio");
                String observacionesEjercicio = rs.getString("observacionesEjercicio");

                Ejercicio ejercicio = new Ejercicio(idEjercicio, nombreEjercicio, categoriaEjercicio, descripcionEjercicio, fechaEjercicio, observacionesEjercicio);
                ejercicios.add(ejercicio);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ejercicios;
    }

    @Override
    public List<Ejercicio> findByCategoria(String categoriaEjercicio) {
        List<Ejercicio> ejercicios = new ArrayList<>();

        try {

            ConnectionFactory connectionFactory = new ConnectionFactoryImplDriveManager();

            String selectSQL = "SELECT * FROM ejercicios WHERE categoriaEjercicio = ?";
            PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(selectSQL);
            preparedStatement.setString(1, categoriaEjercicio);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idEjercicio = rs.getInt("idEjercicio");
                String nombreEjercicio = rs.getString("nombreEjercicio");
                String descripcionEjercicio = rs.getString("descripcionEjercicio");
                Date fechaEjercicio = rs.getDate("fechaEjercicio");
                String observacionesEjercicio = rs.getString("observacionesEjercicio");

                Ejercicio ejercicio = new Ejercicio(idEjercicio, nombreEjercicio, categoriaEjercicio, descripcionEjercicio, fechaEjercicio, observacionesEjercicio);
                ejercicios.add(ejercicio);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ejercicios;
    }

}
