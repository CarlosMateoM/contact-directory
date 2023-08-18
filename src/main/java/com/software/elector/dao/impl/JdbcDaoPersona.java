package com.software.elector.dao.impl;

import com.software.elector.dao.PersonaDao;
import com.software.elector.model.Barrio;
import com.software.elector.model.Ciudad;
import com.software.elector.model.Comuna;
import com.software.elector.model.Direccion;
import com.software.elector.model.Persona;
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
public class JdbcDaoPersona implements PersonaDao {

    private final Connection connection;

    public JdbcDaoPersona(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Persona getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> getAll() {
        String sql = "SELECT "
                + "p.primer_nombre as primerNombre, "
                + "p.segundo_nombre as segundoNombre, "
                + "p.primer_apellido as primerApellido, "
                + "p.segundo_apellido as segundoApellido, "
                + "p.cedula as cedula, "
                + "p.telefono as telefono, "
                + "d.calle as calle, "
                + "d.carrera as carrera, "
                + "d.numero as numero, "
                + "d.sobre as sobre, "
                + "b.nombre as Barrio, "
                + "c.nombre as comuna, "
                + "c2.nombre as ciudad "
                + "FROM "
                + "persona p "
                + "INNER JOIN direccion d ON p.direccion_id = d.id "
                + "INNER JOIN barrio b ON d.barrio_id = b.id "
                + "INNER JOIN comuna c ON b.comuna_id = c.id "
                + "INNER JOIN ciudad c2 ON c.ciudad_id = c2.id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Persona> personas = new ArrayList<>();
                while (resultSet.next()) {

                    String primerNombre = resultSet.getString("primerNombre");
                    String segundoNombre = resultSet.getString("segundoNombre");
                    String primerApellido = resultSet.getString("primerApellido");
                    String segundoApellido = resultSet.getString("segundoApellido");
                    String cedula = resultSet.getString("cedula");
                    String telefono = resultSet.getString("telefono");
                    String calle = resultSet.getString("calle");
                    String carrera = resultSet.getString("carrera");
                    String numero = resultSet.getString("numero");
                    String sobre = resultSet.getString("sobre");
                    String barrio = resultSet.getString("Barrio");
                    String comuna = resultSet.getString("comuna");
                    String ciudad = resultSet.getString("ciudad");

                    Ciudad ciudadPersona = new Ciudad(-1, ciudad);
                    Comuna comunaPersona = new Comuna(-1, comuna, ciudadPersona);
                    Barrio barrioPersona = new Barrio(-1, barrio, comunaPersona);
                    Direccion direccion = new Direccion(
                            -1,
                            calle,
                            carrera,
                            numero,
                            sobre,
                            barrioPersona
                    );

                    Persona persona = new Persona(
                            -1,
                            cedula,
                            primerNombre,
                            segundoNombre,
                            primerApellido,
                            segundoApellido,
                            telefono,
                            direccion
                    );

                    personas.add(persona);
                }
                return personas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Persona> getByKey(String key) {
        String sql = "SELECT "
                + "p.primer_nombre as primerNombre, "
                + "p.segundo_nombre as segundoNombre, "
                + "p.primer_apellido as primerApellido, "
                + "p.segundo_apellido as segundoApellido, "
                + "p.cedula as cedula, "
                + "p.telefono as telefono, "
                + "d.calle as calle, "
                + "d.carrera as carrera, "
                + "d.numero as numero, "
                + "d.sobre as sobre, "
                + "b.nombre as Barrio, "
                + "c.nombre as comuna, "
                + "c2.nombre as ciudad, "
                + "p.primer_nombre || \" \" || p.segundo_nombre || \" \" || p.primer_apellido || \" \" || p.segundo_apellido  as nombreCompleto "
                + "FROM "
                + "persona p "
                + "INNER JOIN direccion d ON p.direccion_id = d.id "
                + "INNER JOIN barrio b ON d.barrio_id = b.id "
                + "INNER JOIN comuna c ON b.comuna_id = c.id "
                + "INNER JOIN ciudad c2 ON c.ciudad_id = c2.id "
                + "WHERE nombreCompleto LIKE ? "
                + "OR cedula LIKE ? ORDER BY p.primer_nombre";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Persona> personas = new ArrayList<>();
                while (resultSet.next()) {

                    String primerNombre = resultSet.getString("primerNombre");
                    String segundoNombre = resultSet.getString("segundoNombre");
                    String primerApellido = resultSet.getString("primerApellido");
                    String segundoApellido = resultSet.getString("segundoApellido");
                    String cedula = resultSet.getString("cedula");
                    String telefono = resultSet.getString("telefono");
                    String calle = resultSet.getString("calle");
                    String carrera = resultSet.getString("carrera");
                    String numero = resultSet.getString("numero");
                    String sobre = resultSet.getString("sobre");
                    String barrio = resultSet.getString("Barrio");
                    String comuna = resultSet.getString("comuna");
                    String ciudad = resultSet.getString("ciudad");

                    Ciudad ciudadPersona = new Ciudad(-1, ciudad);
                    Comuna comunaPersona = new Comuna(-1, comuna, ciudadPersona);
                    Barrio barrioPersona = new Barrio(-1, barrio, comunaPersona);
                    Direccion direccion = new Direccion(
                            -1,
                            calle,
                            carrera,
                            numero,
                            sobre,
                            barrioPersona
                    );

                    Persona persona = new Persona(
                            -1,
                            cedula,
                            primerNombre,
                            segundoNombre,
                            primerApellido,
                            segundoApellido,
                            telefono,
                            direccion
                    );

                    personas.add(persona);
                }
                return personas;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(Persona t) {
        String sql = "INSERT INTO persona (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, cedula, telefono, direccion_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, t.getPrimerNombre());
            preparedStatement.setString(2, t.getSegundoNombre());
            preparedStatement.setString(3, t.getPrimerApellido());
            preparedStatement.setString(4, t.getSegundoApellido());
            preparedStatement.setString(5, t.getCedula());
            preparedStatement.setString(6, t.getTelefono());
            preparedStatement.setInt(7, t.getDireccion().getId());

            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);  // Obtener el ID generado
                    return generatedId;
                } else {
                    throw new SQLException("Error al obtener el id de la entidad insertada [persona]: " + t.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(Persona t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    @Override
    public boolean isCedulaInUse(String cedula) {
        String sql = "SELECT COUNT(*) FROM persona WHERE cedula = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cedula);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

    
    public boolean isTelefonoInUse(String telefono) {
        String sql = "SELECT COUNT(*) FROM persona WHERE telefono = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, telefono);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

}
