package com.filtrojava.tipoActor.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.filtrojava.tipoActor.domain.TipoActor;
import com.filtrojava.tipoActor.infrastructure.TipoActorRepository;

public class TipoActorMySQLRepository implements TipoActorRepository{
    String url;
    String user;
    String password;


    public TipoActorMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void agregar(TipoActor tipoActor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO tipo_actor(descripcion) VALUES (?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tipoActor.getDescripcion());
                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void editar(TipoActor tipoActor) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  tipoactor SET descripcion = ? WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tipoActor.getDescripcion());
                statement.setInt(2, tipoActor.getId());

                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM tipoactor  WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                statement.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
    }

    @Override
    public List<TipoActor> listar() {
        List<TipoActor> tipoActores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM tipoactor";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    TipoActor tipoActor = new TipoActor(
                        rs.getInt("id"), 
                        rs.getString("descripcion") 
                    );
                    tipoActores.add(tipoActor);
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error " +  e.getMessage());
        }
        return tipoActores;
    }

    @Override
    public Optional<TipoActor> encontrarPorId(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM tipoactor WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id);

                ResultSet rs = statement.executeQuery();

                
                while(rs.next()){
                    TipoActor genero = new TipoActor(
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
