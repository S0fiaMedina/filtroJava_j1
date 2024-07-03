package com.filtrojava.genero.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.filtrojava.genero.domain.Genero;
import com.filtrojava.genero.infrastructure.GeneroRepository;

public class generoRepositoryMySQL implements GeneroRepository{
    String url;
    String user;
    String password;

    

    public generoRepositoryMySQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void agregar(Genero genero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO genero(descripcion) VALUES (?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, genero.getDescripcion());
                statement.executeQuery();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void editar(Genero genero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  genero SET descripcion = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, genero.getDescripcion());
                statement.setInt(2, genero.getId());

                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM genero  WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public List<Genero> listar() {
        List<Genero> generos = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM genero";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet rs = statement.executeQuery();

                statement.executeUpdate();
                while(rs.next()){
                    Genero genero = new Genero(
                        rs.getInt("id"), 
                        rs.getString("descripcion") 
                    );
                    generos.add(genero);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return generos;
    }

    @Override
    public Optional<Genero> encontrarPorId(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM genero WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                ResultSet rs = statement.executeQuery();

                statement.executeUpdate();
                while(rs.next()){
                    Genero genero = new Genero(
                        rs.getInt("id"), 
                        rs.getString("descripcion") 
                    );
                    return Optional.of(genero);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return Optional.empty();
    }
    
}
