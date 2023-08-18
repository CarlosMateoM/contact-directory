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
public class JdbcDaoBarrio implements BarrioDao {

    private final Connection connection;

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
        String sql = "INSERT INTO barrio (nombre, comuna_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, t.getNombre());
            preparedStatement.setInt(2, t.getComuna().getId());
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(Barrio t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
         String sql = "DELETE FROM barrio WHERE barrio.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Barrio> getBarriosByComuna(int id) {
        String sql = "SELECT * FROM  barrio c WHERE  c.comuna_id = ? ORDER BY c.nombre";
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

    @Override
    public List<Barrio> getBarriosByComuna(Comuna comuna, String key) {
        String sql = "SELECT * FROM  barrio b WHERE  b.comuna_id = ? AND b.nombre LIKE ? ORDER BY b.nombre";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, comuna.getId());
            preparedStatement.setString(2, "%" + key + "%");
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
