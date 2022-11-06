/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xmuproject.teste_jtablemodel.model;

import com.xmuproject.teste_jtablemodel.entity.Socio;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author muuti
 */
public class SocioTableModel extends AbstractTableModel {

    // Constantes representando o índice das colunas
    private static final int ATIVO = 0;
    private static final int NOME = 1;
    private static final int ENDERECO = 2;
    private static final int MESANLIDADE = 3;

    // Lista de Sócios a serem exibidos na tabela
    private final List<Socio> linhas;
    private String[] colunas = new String[]{"Ativo", "Nome", "Endereço","Mesalidade"};

    // Cria um SocioTableModel sem nenhuma linha
    public SocioTableModel() {
        linhas = new ArrayList<Socio>();
    }

    // Cria um SocioTableModel contendo a lista recebida por parâmetro
    public SocioTableModel(List<Socio> listaDeSocios) {
        linhas = new ArrayList<Socio>(listaDeSocios);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    /**
     * Este método deve verificar o índice recebido por parâmetro e retornar o
     * tipo de classe correspondente à coluna. Para a nossa tabela, tanto o nome
     * quanto o endereço são tratados como Strings.
     *
     * @param columnIndex
     * @return
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case ATIVO:
                return Boolean.class;
            case NOME:
                return String.class;
            case ENDERECO:
                return String.class;
            case MESANLIDADE:
                return BigDecimal.class;
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    /**
     * A implementação deste método vai depender do critério utilizado para
     * definir quais células são editáveis ou não. Neste primeiro momento vamos
     * deixar o retorno sempre como false, assim nenhuma célula será editável
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //apenas o campo ativo será editável
        return columnIndex == ATIVO;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Socio socio = linhas.get(rowIndex);

        switch (columnIndex) {
            case ATIVO:
                return socio.isAtivo();
            case NOME:
                return socio.getNome();
            case ENDERECO:
                return socio.getEndereco();
            case MESANLIDADE:
                return socio.getMensalidade();
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    /**
     * A implementação deste método possui uma estrutura parecida com a do
     * getValueAt, porém devemos setar o valor do campo ao invés de retorná-lo.
     * Além disso, precisamos dizer para a JTable que a célula em questão foi
     * alterada, caso contrário o novo valor não será exibido na tela.
     *
     * @param aValue
     * @param rowIndex
     * @param columnIndex
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        Socio socio = linhas.get(rowIndex);

        switch (columnIndex) {
            case ATIVO:
                socio.setAtivo((Boolean) aValue);
                break;
            case NOME:
                socio.setNome((String) aValue);
                break;
            case ENDERECO:
                socio.setEndereco((String) aValue);
                break;
            case MESANLIDADE:
                socio.setMensalidade((BigDecimal) aValue);
                break;
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }

    //Retorna o socio referente a linha especificada
    public Socio getSocio(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    // Adiciona o sócio especificado ao modelo
    public void addSocio(Socio socio) {
        // Adiciona o registro.
        linhas.add(socio);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    // Remove o sócio da linha especificada.
    public void removeSocio(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    // Adiciona uma lista de sócios no final da lista.
    public void addListaDeSocios(List<Socio> socios) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(socios);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + socios.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }

}
