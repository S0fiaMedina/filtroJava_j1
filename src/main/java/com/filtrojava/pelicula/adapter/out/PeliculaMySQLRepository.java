package com.filtrojava.pelicula.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.filtrojava.pelicula.domain.Pelicula;
import com.filtrojava.pelicula.infrastructure.PeliculaRepository;



public class PeliculaMySQLRepository implements PeliculaRepository{
    String url;
    String user;
    String password;

    

    public PeliculaMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void agregar(Pelicula pelicula) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO pelicula(codinterno, nombre, duracion, sinopsis) VALUES (?, ?, ?, ?)";

            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pelicula.getCodigoInterno());
                statement.setString(2, pelicula.getNombre());
                statement.setString(3, pelicula.getDuracion());
                statement.setString(4, pelicula.getSinopsis());
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void editar(Pelicula pelicula) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  pelicula SET codinterno = ? ,  nombre = ? ,  duracion = ?  , sinopsis = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pelicula.getCodigoInterno());
                statement.setString(2, pelicula.getNombre());
                statement.setString(3, pelicula.getDuracion());
                statement.setString(4, pelicula.getSinopsis());
                statement.setInt(5, pelicula.getId());

                
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM pelicula  WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){

                statement.setInt(1, id);
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public List<Pelicula> listar() {
        List<Pelicula> peliculas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT codinterno, nombre, duracion, sinopsis FROM pelicula";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Pelicula pelicula = new Pelicula(
                        rs.getInt("id"), 
                        rs.getString("codinterno"), 
                        rs.getString("nombre"),
                        rs.getString("duracion"),
                        rs.getString("sinopsis")
                    );
                    peliculas.add(pelicula);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return peliculas;
    }

    @Override
    public Optional<Pelicula> encontrarPorId(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, codinterno, nombre, duracion, sinopsis FROM pelicula WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Pelicula pelicula = new Pelicula(
                        rs.getInt("id"), 
                        rs.getString("codinterno"), 
                        rs.getString("nombre"),
                        rs.getString("duracion"),
                        rs.getString("sinopsis")
                    );
                    return Optional.of(pelicula);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return Optional.empty();
    }
    
}
