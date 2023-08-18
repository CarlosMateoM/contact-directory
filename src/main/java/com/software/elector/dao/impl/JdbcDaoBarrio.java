package com.software.elector.dao.impl;

import com.software.elector.dao.BarrioDao;
import com.software.elector.model.Barrio;
import com.software.elector.model.Comuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoBarrio implements BarrioDao{
    
    private Connection connection; 

    public JdbcDaoBarrio(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public Barrio getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Barrio> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Barrio> getByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(Barrio t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Barrio t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Barrio> getBarrioByComuna(int id) {
        String sql = "SELECT * FROM  barrio c WHERE  c.comuna_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
               List<Barrio> barrios = new ArrayList<>();
                while (resultSet.next()) {
                    int barrioId = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    int comunaId = resultSet.getInt("comuna_id");

                    barrios.add(new Barrio(barrioId, nombre, new Comuna(comunaId, null, null)));
                }
                return barrios;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
