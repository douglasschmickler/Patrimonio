
package br.com.ifpr.DTO;

public class PatrimonioDTO {
    private int id_patrimonio;
    private String descricao_patrimonio;
    private double valor_patrimonio;
    private String data_entrada_patrimonio;
    private String local_atual;
    private String local_anterior;

    /**
     * @return the id_patrimonio
     */
    public int getId_patrimonio() {
        return id_patrimonio;
    }

    /**
     * @param id_patrimonio the id_patrimonio to set
     */
    public void setId_patrimonio(int id_patrimonio) {
        this.id_patrimonio = id_patrimonio;
    }

    /**
     * @return the descricao_patrimonio
     */
    public String getDescricao_patrimonio() {
        return descricao_patrimonio;
    }

    /**
     * @param descricao_patrimonio the descricao_patrimonio to set
     */
    public void setDescricao_patrimonio(String descricao_patrimonio) {
        this.descricao_patrimonio = descricao_patrimonio;
    }

    /**
     * @return the valor_patrimonio
     */
    public double getValor_patrimonio() {
        return valor_patrimonio;
    }

    /**
     * @param valor_patrimonio the valor_patrimonio to set
     */
    public void setValor_patrimonio(double valor_patrimonio) {
        this.valor_patrimonio = valor_patrimonio;
    }

    /**
     * @return the data_entrada_patrimonio
     */
    public String getData_entrada_patrimonio() {
        return data_entrada_patrimonio;
    }

    /**
     * @param data_entrada_patrimonio the data_entrada_patrimonio to set
     */
    public void setData_entrada_patrimonio(String data_entrada_patrimonio) {
        this.data_entrada_patrimonio = data_entrada_patrimonio;
    }

    /**
     * @return the local_atual
     */
    public String getLocal_atual() {
        return local_atual;
    }

    /**
     * @param local_atual the local_atual to set
     */
    public void setLocal_atual(String local_atual) {
        this.local_atual = local_atual;
    }

    /**
     * @return the local_anterior
     */
    public String getLocal_anterior() {
        return local_anterior;
    }

    /**
     * @param local_anterior the local_anterior to set
     */
    public void setLocal_anterior(String local_anterior) {
        this.local_anterior = local_anterior;
    }
    
    
    
}
