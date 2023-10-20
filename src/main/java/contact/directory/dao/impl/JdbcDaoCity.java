package contact.directory.dao.impl;

import contact.directory.model.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import contact.directory.dao.CityDao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoCity implements CityDao {

    private final DataSource dataSource;

    public JdbcDaoCity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public City getById(Integer id) {
        String sql = "SELECT * FROM ciudad WHERE ciudad.id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int cityId = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");

                    return new City(cityId, name);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> getAll() {
        String sql = "SELECT * FROM ciudad c ORDER BY c.nombre";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<City> cities = new ArrayList<>();
                while (resultSet.next()) {
                    int cityId = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");
                    cities.add(new City(cityId, name));
                }
                return cities;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> getByKey(String key) {
        String sql = "SELECT * FROM ciudad c WHERE c.nombre ILIKE ? ORDER BY c.nombre";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, "%" + key + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<City> cities = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");
                    cities.add(new City(id, name));
                }
                return cities;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(City t) {
        String sql = "INSERT INTO ciudad (nombre) VALUES (?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, t.getName());
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
    public void update(City t) {
        String sql = "UPDATE ciudad SET nombre = ? WHERE id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, t.getName());
            preparedStatement.setInt(2, t.getId());
            preparedStatement.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM ciudad WHERE ciudad.id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
