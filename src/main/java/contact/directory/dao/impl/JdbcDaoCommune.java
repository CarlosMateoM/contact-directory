package contact.directory.dao.impl;

import contact.directory.model.City;
import contact.directory.model.Commune;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import contact.directory.dao.CommuneDao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoCommune implements CommuneDao {

    private final DataSource dataSource;

    public JdbcDaoCommune(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Commune getById(Integer id) {
        String sql = "SELECT * FROM comuna WHERE comuna.id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, id);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                if (resultSet.next()) {
                    String name = resultSet.getString("nombre");
                    int cityId = resultSet.getInt("ciudad_id");
                    int communeId = resultSet.getInt("id");

                    return new Commune(communeId, name, new City(cityId, null));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Commune> getAll() {
        String sql = "SELECT * FROM comuna";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                List<Commune> comunas = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");
                    int cityId = resultSet.getInt("ciudad_id");

                    comunas.add(new Commune(id, name, new City(cityId, null)));
                }
                return comunas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Commune> getByKey(String key) {
        String sql = "SELECT * FROM comuna WHERE comuna.nombre ILIKE ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, "%" + key + "%");
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                List<Commune> communes = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");
                    int cityId = resultSet.getInt("ciudad_id");

                    communes.add(new Commune(id, name, new City(cityId, null)));
                }
                return communes;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(Commune t) {
        String sql = "INSERT INTO comuna (nombre, ciudad_id) VALUES (?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, t.getName());
            preparedStatement.setInt(2, t.getCity().getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(Commune t) {
        String sql = "UPDATE comuna SET nombre = ? WHERE id = ?";
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
    public List<Commune> getCommunesByCity(int id) {
        String sql = "SELECT * FROM  comuna c WHERE  c.ciudad_id = ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, id);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                List<Commune> communes = new ArrayList<>();
                while (resultSet.next()) {
                    int communeId = resultSet.getInt("id");
                    int cityId = resultSet.getInt("ciudad_id");
                    String name = resultSet.getString("nombre");

                    communes.add(new Commune(communeId, name, new City(cityId, null)));
                }
                return communes;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Commune> searchCommunesByCity(City ciudad, String key) {
        String sql = "SELECT * FROM  comuna c WHERE  c.ciudad_id = ? AND c.nombre ILIKE ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, ciudad.getId());
            preparedStatement.setString(2, "%" + key + "%");
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                List<Commune> comunas = new ArrayList<>();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");
                    int cityId = resultSet.getInt("ciudad_id");

                    comunas.add(new Commune(id, name, new City(cityId, null)));
                }
                return comunas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
