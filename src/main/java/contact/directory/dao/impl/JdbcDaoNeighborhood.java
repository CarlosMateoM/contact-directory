package contact.directory.dao.impl;

import contact.directory.model.Neighborhood;
import contact.directory.model.Commune;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import contact.directory.dao.NeighborhoodDao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoNeighborhood implements NeighborhoodDao {

    private final DataSource dataSource;

    public JdbcDaoNeighborhood(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public Neighborhood getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Neighborhood> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Neighborhood> getByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int save(Neighborhood t) {
        String sql = "INSERT INTO barrio (nombre, comuna_id) VALUES (?, ?)";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, t.getName());
            preparedStatement.setInt(2, t.getCommune().getId());
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
    public void update(Neighborhood t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM barrio WHERE barrio.id = ?";
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
    public List<Neighborhood> getNeighborhoodsByCommune(int id) {
        String sql = "SELECT * FROM  barrio c WHERE  c.comuna_id = ? ORDER BY c.nombre";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Neighborhood> neighborhoods = new ArrayList<>();
                while (resultSet.next()) {
                    
                    String name = resultSet.getString("nombre");
                    int addressId = resultSet.getInt("id");
                    int communeId = resultSet.getInt("comuna_id");

                    neighborhoods.add(new Neighborhood(addressId, name, new Commune(communeId, null, null)));
                }
                return neighborhoods;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Neighborhood> searchNeighborhoodByCommune(Commune commune, String key) {
        String sql = "SELECT * FROM  barrio b WHERE  b.comuna_id = ? AND b.nombre ILIKE ? ORDER BY b.nombre";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, commune.getId());
            preparedStatement.setString(2, "%" + key + "%");
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                
                List<Neighborhood> neighborhoods = new ArrayList<>();
                while (resultSet.next()) {
                    
                    String name = resultSet.getString("nombre");
                    int neighborhoodId = resultSet.getInt("id");
                    int communeId = resultSet.getInt("comuna_id");

                    neighborhoods.add(new Neighborhood(neighborhoodId, name, new Commune(communeId, null, null)));
                }
                
                return neighborhoods;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
