package com.software.elector.dao.impl;

import com.software.elector.model.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.software.elector.dao.CiudadDao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoCiudad implements CiudadDao {

    private final Connection connection;

    public JdbcDaoCiudad(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Ciudad getById(Integer id) {
        String sql = "SELECT * FROM ciudad WHERE ciudad.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int cuidadId = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");

                    return new Ciudad(cuidadId, nombre);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ciudad> getAll() {
        String sql = "SELECT * FROM ciudad c ORDER BY c.nombre";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Ciudad> ciudades = new ArrayList<>();
                while (resultSet.next()) {
                    int ciudadId = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    ciudades.add(new Ciudad(ciudadId, nombre));
                }
                return ciudades;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ciudad> getByKey(String key) {
        String sql = "SELECT * FROM ciudad c WHERE c.nombre ILIKE ? ORDER BY c.nombre";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + key + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Ciudad> ciudades = new ArrayList<>();
                while (resultSet.next()) {
                    int cuidad_id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");

                    ciudades.add(new Ciudad(cuidad_id, nombre));
                }
                return ciudades;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(Ciudad t) {
        String sql = "INSERT INTO ciudad (nombre) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, t.getNombre());
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
    public void update(Ciudad t) {
        String sql = "UPDATE ciudad SET nombre = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, t.getNombre());
            preparedStatement.setInt(2, t.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM ciudad WHERE ciudad.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
