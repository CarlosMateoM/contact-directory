package contact.directory.dao.impl;

import contact.directory.model.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import contact.directory.dao.AddressDao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoAddress implements AddressDao {

    private final DataSource dataSource;

    public JdbcDaoAddress(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public Address getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Address> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Address> getByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int save(Address t) {
        String sql = "INSERT INTO direccion (barrio_id, calle, carrera, numero, sobre) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, t.getNeighborhood().getId());
            preparedStatement.setString(2, t.getStreet());
            preparedStatement.setString(3, t.getAvenue());
            preparedStatement.setString(4, t.getNumber());
            preparedStatement.setString(5, t.getOn());

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
    public void update(Address t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
