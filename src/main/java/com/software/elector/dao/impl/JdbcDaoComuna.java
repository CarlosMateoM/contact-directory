package com.software.elector.dao.impl;

import com.software.elector.dao.ComunaDao;
import com.software.elector.model.Ciudad;
import com.software.elector.model.Comuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoComuna implements ComunaDao {

    private final DataSource dataSource;

    public JdbcDaoComuna(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    

    @Override
    public Comuna getById(Integer id) {
        String sql = "SELECT * FROM comuna WHERE comuna.id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int comunaId = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    int ciudadId = resultSet.getInt("ciudad_id");

                    return new Comuna(comunaId, nombre, new Ciudad(ciudadId, null));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comuna> getAll() {
        String sql = "SELECT * FROM comuna";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Comuna> comunas = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    int ciudadId = resultSet.getInt("ciudad_id");

                    comunas.add(new Comuna(id, nombre, new Ciudad(ciudadId, null)));
                }
                return comunas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comuna> getByKey(String key) {
        String sql = "SELECT * FROM comuna WHERE comuna.nombre ILIKE ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + key + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Comuna> comunas = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    int ciudadId = resultSet.getInt("ciudad_id");

                    comunas.add(new Comuna(id, nombre, new Ciudad(ciudadId, null)));
                }
                return comunas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(Comuna t) {
        String sql = "INSERT INTO comuna (nombre, ciudad_id) VALUES (?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, t.getNombre());
            preparedStatement.setInt(2, t.getCiudad().getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(Comuna t) {
        String sql = "UPDATE comuna SET nombre = ? WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, t.getNombre());
            preparedStatement.setInt(2, t.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM comuna WHERE ciudad.id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comuna> getComunasByCiudad(int id) {
        String sql = "SELECT * FROM  comuna c WHERE  c.ciudad_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Comuna> comunas = new ArrayList<>();
                while (resultSet.next()) {
                    int comunaId = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    int ciudadId = resultSet.getInt("ciudad_id");

                    comunas.add(new Comuna(comunaId, nombre, new Ciudad(ciudadId, null)));
                }
                return comunas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comuna> getComunasByCiudad(Ciudad ciudad, String key) {
        String sql = "SELECT * FROM  comuna c WHERE  c.ciudad_id = ? AND c.nombre ILIKE ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, ciudad.getId());
            preparedStatement.setString(2, "%" + key + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Comuna> comunas = new ArrayList<>();
                while (resultSet.next()) {
                    int comunaId = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    int ciudadId = resultSet.getInt("ciudad_id");

                    comunas.add(new Comuna(comunaId, nombre, new Ciudad(ciudadId, null)));
                }
                return comunas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
