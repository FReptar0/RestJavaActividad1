package com.example.model.usuarios;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.repository.Repository;
import com.example.utils.MySQLConnection;
import com.example.utils.Response;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class DaoPendiente implements Repository<BeanPendiente> {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection mysql = new MySQLConnection();
    BeanPendiente pendientes = new BeanPendiente();

    private final String GET_PENDIENTES = "SELECT * FROM PENDIENTES WHERE FK_ID_USUARIO = ?";
    private final String GET_PENDIENTE = "SELECT * FROM PENDIENTES WHERE FK_ID_USUARIO = ? AND ID_PENDIENTES = ?";
    private final String INSERT_PENDIENTES = "INSERT INTO PENDIENTE (DESCRIPCION, FECHA, HORA, ESTADO, FK_ID_USUARIO) VALUES (?,?,?,?,?)";
    private final String UPDATE_PENDIENTE = "UPDATE PENDIENTES SET DESCRIPCION = ?, FECHA = ?, HORA = ?, ESTADO = ? WHERE ID_PENDIENTES = ?";
    private final String DELTE_PENDIENTES = "DELETE FROM PENDIENTES WHERE ID_PENDIENTES = ?";

    public Response<BeanPendiente> delete(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response<List> findAll(Long fk) {
        List<BeanPendiente> pendientes = new ArrayList<>();
        Response<List> response = new Response<>();
        BeanPendiente pendiente = null;

        try {
            mysql.getConnection();
            pstm = conn.prepareStatement(GET_PENDIENTES);
            pstm.setLong(1, fk);
            rs = pstm.executeQuery();

            while (rs.next()) {
                pendiente = new BeanPendiente();
                pendiente.setId(rs.getInt("ID_PENDIENTES"));
                pendiente.setDescripcion(rs.getString("DESCRIPCION"));
                pendiente.setFecha(rs.getString("FECHA"));
                pendiente.setHora(rs.getString("HORA"));
                // pendiente.setEstado(rs.getString("ESTADO"));
                // pendiente.setFkIdUsuario(rs.getLong("FK_ID_USUARIO"));
                pendientes.add(pendiente);
            }

            if (pendientes.isEmpty()) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Nothing found");
                response.setData(null);
            } else {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Success");
                response.setData(pendientes);
            }

        } catch (Exception e) {
            Logger.getLogger().log(Level.ERROR, e.getMessage());
        }

        return response;
    }

    public Response<BeanPendiente> findOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response<BeanPendiente> save(BeanPendiente object) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response<BeanPendiente> update(BeanPendiente object, Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response<List> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
