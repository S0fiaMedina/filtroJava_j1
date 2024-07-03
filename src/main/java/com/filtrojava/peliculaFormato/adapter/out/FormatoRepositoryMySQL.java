package com.filtrojava.peliculaFormato.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.filtrojava.formato.domain.Formato;
import com.filtrojava.formato.infrastructure.FormatoRepository;

public class FormatoRepositoryMySQL implements FormatoRepository{
    String url;
    String user;
    String password;

    

    public FormatoRepositoryMySQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void agregar(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO formato(descripcion) VALUES (?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, formato.getDescripcion());
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void editar(Formato formato) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  formato SET descripcion = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, formato.getDescripcion());
                statement.setInt(2, formato.getId());

                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM formato  WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){

                statement.setInt(1, id);
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public List<Formato> listar() {
        List<Formato> formatos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM formato";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Formato Formato = new Formato(
                        rs.getInt("id"), 
                        rs.getString("descripcion") 
                    );
                    formatos.add(Formato);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return formatos;
    }

    @Override
    public Optional<Formato> encontrarPorId(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM formato WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Formato formato = new Formato(
                        rs.getInt("id"), 
                        rs.getString("descripcion") 
                    );
                    return Optional.of(formato);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return Optional.empty();
    }
    
}
