/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import java.util.List;
import negocio.dominio.Ejercicio;

/**
 *
 * @author fernandoarenasdev
 */
public interface EjercicioDAO extends GenericDAO<Ejercicio>{

    List<Ejercicio> findByCategoria(String nombre);
}
