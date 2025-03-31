/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        
        try (Connection conn = ConectaDAO.getConnection();
             PreparedStatement prep = conn.prepareStatement(sql)) {
            
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        
        try (Connection conn = ConectaDAO.getConnection();
             PreparedStatement prep = conn.prepareStatement(sql);
             ResultSet rs = prep.executeQuery()) {
            
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));
                lista.add(produto);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        
        return lista;
    }
}
