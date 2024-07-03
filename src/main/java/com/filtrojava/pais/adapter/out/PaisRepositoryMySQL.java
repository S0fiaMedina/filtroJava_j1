package com.filtrojava.pais.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.filtrojava.pais.domain.Pais;
import com.filtrojava.pais.infrastructure.PaisRepository;

public class PaisRepositoryMySQL implements PaisRepository{
    String url;
    String user;
    String password;

    

    public PaisRepositoryMySQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void agregar(Pais pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO Pais(descripcion) VALUES (?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pais.getDescripcion());
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void editar(Pais pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  pais SET descripcion = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pais.getDescripcion());
                statement.setInt(2, pais.getId());

                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM pais  WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public List<Pais> listar() {
        List<Pais> paises = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM pais";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Pais pais = new Pais(
                        rs.getInt("id"), 
                        rs.getString("descripcion") 
                    );
                    paises.add(pais);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return paises;
    }

    @Override
    public Optional<Pais> encontrarPorId(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM pais WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Pais pais = new Pais(
                        rs.getInt("id"), 
                        rs.getString("descripcion") 
                    );
                    return Optional.of(pais);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return Optional.empty();
    }
    
}
