package com.ar.webapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Integer insertUsuario(Usuario usuario) {

        DBConnection conexion = new DBConnection();

        String insertUsuarioSql = "INSERT INTO usuarios (nombre,apellido,email,clave,fechaNacimiento,pais) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        ResultSet rs = null;

        Connection cn = conexion.conectar();

        try {
            pstm = cn.prepareStatement(insertUsuarioSql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getApellido());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getClave());
            pstm.setString(5, usuario.getFechaNacimiento());
            pstm.setString(6, usuario.getPais());

            int result = pstm.executeUpdate();

            if (result > 0) {
                rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println("se cargo exitosamente un usuario");
                    return rs.getInt(1);
                } else {
                    System.out.println("Error al obtener id del usuario creado");
                    return null;
                }
            } else {
                System.out.println("Error al insertar usuario");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Usuario> getAllUsuarios() {
        DBConnection conexion = new DBConnection();

        String selectUsuariosSQL = "Select * from usuarios";

        PreparedStatement pstm = null;
        ResultSet rs = null;

        Connection cn = conexion.conectar();

        List<Usuario> usuarios = new ArrayList<>();

        try {
            pstm = cn.prepareStatement(selectUsuariosSQL);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String clave = rs.getString("clave");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String pais = rs.getString("pais");
                Usuario usuario = new Usuario(id, nombre, apellido, email, clave, fechaNacimiento, pais);
                usuarios.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}