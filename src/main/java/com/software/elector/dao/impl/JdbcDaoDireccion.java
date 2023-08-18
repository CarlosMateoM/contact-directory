package com.software.elector.dao.impl;

import com.software.elector.dao.DireccionDao;
import com.software.elector.model.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoDireccion implements DireccionDao{
    
    private final Connection connection;

    public JdbcDaoDireccion(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Direccion getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Direccion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Direccion> getByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(Direccion t) {
        String sql = "INSERT INTO direccion (barrio_id, calle, carrera, numero, sobre) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, t.getBarrio().getId());
            preparedStatement.setString(2, t.getCalle());
            preparedStatement.setString(3, t.getCarrera());
            preparedStatement.setString(4, t.getNumero());
            preparedStatement.setString(5, t.getSobre());

            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);  // Obtener el ID generado
                    return generatedId;
                } else {
                     throw new SQLException("Error al obtener el id de la entidad insertada [direccion]: " + t.toString());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(Direccion t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
