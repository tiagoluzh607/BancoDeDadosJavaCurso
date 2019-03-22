/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Usuario;

/**
 *
 * @author tiago
 */
public class UsuarioDAO {
    
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
        String sql = "insert into usuario(usuario,senha) values('"+usuario.getUsuario()+"','"+ usuario.getSenha()+"');";
        System.out.println(sql);
       
        PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        statement.execute();
		
		
        ResultSet resultSet = statement.getGeneratedKeys();
		
	resultSet.next();
        int id = resultSet.getInt("id");
		
	usuario.setId(id);	

    }
    
}
