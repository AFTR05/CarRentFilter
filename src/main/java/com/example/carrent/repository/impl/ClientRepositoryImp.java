package com.example.carrent.repository.impl;

import com.example.carrent.model.Client;
import com.example.carrent.repository.Repository;
import com.example.carrent.utilities.ConnectionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class ClientRepositoryImp implements Repository {
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        return ConnectionBD.getInstance();
    }

    private Client createClient(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setNickname(resultSet.getString("nickname"));
        client.setPassword(resultSet.getString("password"));
        return client;
    }
    @Override
    public HashSet<Client> list() {
        HashSet<Client> clients = new HashSet<>();
        try (Statement statement=getConnection().createStatement();
             ResultSet resultSet=statement.executeQuery("SELECT * FROM products")
        ){
            while (resultSet.next()) {
                Client client = createClient(resultSet);
                clients.add(client);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    @Override
    public Client byId(Long id) {
        Client client = null;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("SELECT * FROM client WHERE id =?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                client = createClient(resultSet);
            }
            resultSet.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    @Override
    public void save(Object o) {
        Client client = (Client) o;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("INSERT INTO client(nickname,password) VALUES (?,?)")){
            preparedStatement.setString(1,client.getNickname());
            preparedStatement.setString(2,client.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        Client product = null;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("DELETE FROM client WHERE id =?")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id, Object o) {
        Client product = (Client) o;
        try (PreparedStatement preparedStatement=getConnection().prepareStatement("UPDATE client SET nickname=? ,password=? where id=?")){
            preparedStatement.setString(1,product.getNickname());
            preparedStatement.setString(2,product.getPassword());
            preparedStatement.setLong(4,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
