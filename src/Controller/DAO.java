/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import Model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alunocmc
 */
public class DAO {
    Veiculo veiculo = new Veiculo();
    public void Cadastrar (Veiculo veiculo) throws SQLException, ClassNotFoundException{
            PreparedStatement ps;
            Connection conexao = new Conexao().getConnection();
            ps=conexao.prepareStatement("insert into veiculos (marca,modelo,placa, anodesc,tipo,status) values (?,?,?,?,?,?)");
            ps.setString(1,veiculo.getMarca());
            ps.setString(2,veiculo.getModelo());
            ps.setString(3,veiculo.getPlaca());
            ps.setString(4,veiculo.getAnodesc());
            ps.setString(5,veiculo.getTipo());
            ps.setString(6,veiculo.getStatus());
            ps.execute();
        }    

    public void Pesquisar (Veiculo veiculo) throws ClassNotFoundException, SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "Select * from veiculos where placa=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1,veiculo.getPlaca());
        ResultSet rs= ps.executeQuery();
         while (rs.next()){
                veiculo.setMarca(rs.getString(2));
                veiculo.setModelo(rs.getString(3));
                veiculo.setTipo(rs.getString(4));
                veiculo.setAnodesc(rs.getString(5));
                veiculo.setStatus(rs.getString(6));
            }

    }

    public void Alterar (Veiculo veiculo) throws ClassNotFoundException, SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "update veículos set marca = ?, modelo = ?, anodesc = ?, tipo = ?, status = ? where id = ?;";
        PreparedStatement st = conexao.prepareStatement(sql); 

        st.setString(1, veiculo.getMarca());
        st.setString(2,veiculo.getModelo());
        st.setString(3, veiculo.getAnodesc());
        st.setString(4, veiculo.getTipo());
        st.setString(5, veiculo.getStatus());
        st.setString(6, veiculo.getPlaca());
        st.executeUpdate();
    }
    public void Excluir (Veiculo veiculo) throws ClassNotFoundException, SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "delete from veiculos where placa =? ";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setString(1, veiculo.getPlaca());
        st.execute();
    }
    public void CadastroUsuario (Usuario usuario)throws ClassNotFoundException, SQLException{
        PreparedStatement ps;
        Connection conexao = new Conexao().getConnection();
        ps=conexao.prepareStatement("insert into usuarios (nome, email, senha, status) values (?,?,?,?)");
        ps.setString(1, usuario.getNome());
        ps.setString(2,usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getStatus());
        ps.execute();
    }
    public boolean Logar (Usuario usuario) throws ClassNotFoundException, SQLException{
        PreparedStatement ps;
        ResultSet rs;
        Connection conexao = new Conexao().getConnection();
        ps=conexao.prepareStatement("select * from usuarios where email = ? and senha = ?");
        ps.setString(1, usuario.getEmail());
        ps.setString(2, usuario.getSenha());

        rs = ps.executeQuery();
        return rs.next(); 
    }
    public List<Veiculo> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection conexao = new Conexao().getConnection();
        PreparedStatement ps;
        ps = conexao.prepareStatement("select * from veiculos where tipo = ? and status = ?");
        ps.setString(1, veiculo.getTipo());
        ps.setString(2, veiculo.getStatus());
        ps.execute();
        ResultSet rs = ps.executeQuery();
        
        var lv = new ArrayList<Veiculo>();
        int cont = 0;
        while(rs.next()){
            veiculo.setTipo(rs.getString("tipo"));
            veiculo.setModelo(rs.getString("modelo"));
            veiculo.setPlaca(rs.getString("placa"));
            veiculo.setStatus(rs.getString("status"));
            lv.add(veiculo);
            cont = cont + 1;
        }
        System.out.println("Cont..: " + cont);
        conexao.close();
        return lv;
        }
    }

