/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpr.DAO;

import br.com.ifpr.DTO.PatrimonioDTO;
import br.com.ifpr.DAO.conexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class PatrimonioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PatrimonioDTO> lista = new ArrayList<>();
    
    public void Cadastrar_Patrimonio(PatrimonioDTO patrimonio) {
        String sql = "insert into tb_patrimonio (id_patrimonio, descricao_patrimonio,valor_patrimonio,data_entrada_patrimonio,local_atual_patrimonio)"
        + "values (?,?,?,?,?)";
        conn = new conexaoDAO().getConexao();
        try {                        
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, patrimonio.getId_patrimonio());
            pstm.setString(2, patrimonio.getDescricao_patrimonio());
            pstm.setDouble(3, patrimonio.getValor_patrimonio());
            pstm.setString(4,patrimonio.getData_entrada_patrimonio());
            pstm.setString(5, patrimonio.getLocal_atual());
            pstm.execute();
            pstm.close();
            conn.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "CadastrarPatrimonioDAO" + erro);
        }
    }
    public ArrayList<PatrimonioDTO>Listar_PatrimonioDAO(){
        String sql = "select * from tb_patrimonio";
        conn = new conexaoDAO().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                PatrimonioDTO p = new PatrimonioDTO();
                p.setId_patrimonio(rs.getInt("id_patrimonio"));
                p.setDescricao_patrimonio(rs.getString("descricao_patrimonio"));
                p.setValor_patrimonio(rs.getDouble("valor_patrimonio"));
                p.setData_entrada_patrimonio(rs.getString("data_entrada_patrimonio"));
                p.setLocal_atual(rs.getString("local_atual_patrimonio"));
                lista.add(p);
                }
                pstm.close();
                rs.close();
                conn.close();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"ListarPatrimonioDAO" + erro);   
            }
            return lista;
        }
    public void Excluir_PatrimonioDAO(PatrimonioDTO p){
        String sql = "delete from tb_patrimonio where id_patrimonio=?";
        conn = new conexaoDAO().getConexao();
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,p.getId_patrimonio());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ExcluirPatrimonioDAO" + erro);
        }
    }
    public void Alterar_PatrimonioDAO(PatrimonioDTO  p){
    String sql = "update tb_patrimonio set local_atual_patrimonio = ? where id_patrimonio = ?";
    conn = new conexaoDAO().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,p.getLocal_atual());
            pstm.setInt(2,p.getId_patrimonio());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"AlterarPatrimonioDAO" + erro);
        }        
    }

    public ArrayList<PatrimonioDTO>Pesquisar_CursoDAO(String id_codigo){
        String sql1 = "select * from tb_patrimonio where id_patrimonio=?";
        ArrayList<PatrimonioDTO> lista = new ArrayList<PatrimonioDTO>();        
        conn = new conexaoDAO().getConexao();
            try {
                pstm = conn.prepareStatement(sql1);
                pstm.setString(1,id_codigo);      
                rs = pstm.executeQuery();
                while(rs.next()){                                     
                    PatrimonioDTO p = new PatrimonioDTO();
                    p.setId_patrimonio(rs.getInt("id_curso"));
                    p.setDescricao_patrimonio(rs.getString("descricao_curso"));
                    p.setValor_patrimonio(rs.getDouble("valor_patrimonio"));
                    p.setData_entrada_patrimonio(rs.getString("data_entrada_patrimonio"));
                    lista.add(p);
                }
                pstm.close();
                conn.close();
                rs.close();
                
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,"PesquisarPatrimonioDAO " + erro);   
            }
            return lista;        
    }     
}
