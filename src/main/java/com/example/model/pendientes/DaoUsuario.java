package com.example.model.pendientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.usuarios.BeanPendiente;
import com.example.utils.MySQLConnection;
import com.example.utils.Response;

public class DaoUsuario {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection mysql = new MySQLConnection();
    BeanUsuario usuarios = new BeanUsuario();

    private final String GET_USUARIOS = "SELECT * FROM USUARIOS";
    private final String GET_USUARIO = "SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";
    private final String INSERT_USUARIO = "INSERT INTO USUARIOS (NOMBRE, APELLIDO, PUESTO) VALUES (?, ?, ?)";

    @Override
    public Response<List> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<BeanUsuario> findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<BeanUsuario> save(BeanUsuario object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<BeanUsuario> update(BeanUsuario object, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<BeanUsuario> delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
