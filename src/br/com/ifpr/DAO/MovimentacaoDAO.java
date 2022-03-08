/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifpr.DAO;

import br.com.ifpr.DTO.MovimentacaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dougr
 */
public class MovimentacaoDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<MovimentacaoDTO> lista = new ArrayList<>();
    
    public void Historico_PatrimonioDAO(MovimentacaoDTO  m){
    String sql = "insert into tb_movimentacao (id_movimentacao,FK_id_patrimonio,local_anterior,local_atual,data_movimentacao)"
    + "values (?,?,?,?,?)";
    conn = new conexaoDAO().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, m.getId_movimentacao());
            //pstm.setInt(2, m.getId_patrimonio().getId_patrimonio());
            pstm.setInt(2, m.getId_patrimonio());
            pstm.setString(3, m.getLocal_anterior());
            pstm.setString(4,m.getLocal_atual());
            pstm.setString(5, m.getData_movimentacao());
            pstm.execute();
            pstm.close();
            conn.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"AlterarPatrimonioDAO" + erro);
        }        
    }
    
    public ArrayList<MovimentacaoDTO>Listar_MovimentacoesDAO(){
        String sql = "select * from tb_movimentacao";
        conn = new conexaoDAO().getConexao();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                MovimentacaoDTO m = new MovimentacaoDTO();
                m.setId_movimentacao(rs.getInt("id_movimentacao"));
                m.setId_patrimonio(rs.getInt("FK_id_patrimonio"));
                m.setLocal_anterior(rs.getString("local_anterior"));
                m.setLocal_atual(rs.getString("local_atual"));
                m.setData_movimentacao(rs.getString("data_movimentacao"));
                lista.add(m);
                }
                pstm.close();
                rs.close();
                conn.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"ListarPatrimonioDAO" + erro);   
            }
            return lista;
        }
    public ArrayList<MovimentacaoDTO>Listar_MovimentacaoDAO(int id_patrimonio){
        String sql = "select * from tb_movimentacao where FK_id_patrimonio = ?";
        conn = new conexaoDAO().getConexao();
        //MovimentacaoDTO m = new MovimentacaoDTO();
        //m.getId_patrimonio();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id_patrimonio);
            rs = pstm.executeQuery();
            while(rs.next()){
                MovimentacaoDTO m = new MovimentacaoDTO();
                m.setId_movimentacao(rs.getInt("id_movimentacao"));
                m.setId_patrimonio(rs.getInt("FK_id_patrimonio"));
                m.setLocal_anterior(rs.getString("local_anterior"));
                m.setLocal_atual(rs.getString("local_atual"));
                m.setData_movimentacao(rs.getString("data_movimentacao"));
                lista.add(m);
                }
                pstm.close();
                rs.close();
                conn.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"ListarPatrimonioDAO" + erro);   
            }
            return lista;
        }
    
}
