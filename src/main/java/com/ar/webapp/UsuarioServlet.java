package com.ar.webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    private ObjectMapper mapper = new ObjectMapper();

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Usuario usuario = mapper.readValue(req.getInputStream(), Usuario.class);    
            Integer id = usuarioDAO.insertUsuario(usuario);    
            String jsonResponse = mapper.writeValueAsString(id);
    
            resp.setContentType("application/json");    
            resp.getWriter().write(jsonResponse);    
            resp.setStatus(HttpServletResponse.SC_CREATED);            
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
            String jsonResp = mapper.writeValueAsString(usuarios);
            resp.setContentType("application/json");
            resp.getWriter().write(jsonResp);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID invalido");
            e.printStackTrace();
        }

    }
    
}
