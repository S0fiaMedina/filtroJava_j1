package com.filtrojava.actor.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.filtrojava.actor.domain.Actor;
import com.filtrojava.actor.infrastructure.ActorRepository;



public class ActorMySQLRepository implements ActorRepository{
    String url;
    String user;
    String password;

    

    public ActorMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void agregar(Actor Actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO actor(nombre, idnacionalidad, edad, idgenero) VALUES (?, ?, ?, ?)";

            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, Actor.getNombre());
                statement.setInt(2, Actor.getIdNacionalidad());
                statement.setInt(3, Actor.getEdad());
                statement.setInt(4, Actor.getIdGenero());
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void editar(Actor Actor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  actor SET nombre = ? ,  didnacionalidad = ?, edad = ?, idgenero = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, Actor.getNombre());
                statement.setInt(2, Actor.getIdNacionalidad());
                statement.setInt(3, Actor.getEdad());
                statement.setInt(4, Actor.getIdGenero());
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM actor  WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){

                statement.setInt(1, id);
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public List<Actor> listar() {
        List<Actor> Actors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, codinterno, nombre, duracion, sinopsis FROM Actor";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Actor Actor = new Actor(
                        rs.getInt("id"), 
                        rs.getString("codinterno"), 
                        rs.getString("nombre"),
                        rs.getString("duracion"),
                        rs.getString("sinopsis")
                    );
                    Actors.add(Actor);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return Actors;
    }

    @Override
    public Optional<Actor> encontrarPorId(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, codinterno, nombre, duracion, sinopsis FROM Actor WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    Actor Actor = new Actor(
                        rs.getInt("id"), 
                        rs.getString("codinterno"), 
                        rs.getString("nombre"),
                        rs.getString("duracion"),
                        rs.getString("sinopsis")
                    );
                    return Optional.of(Actor);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return Optional.empty();
    }
    
}
