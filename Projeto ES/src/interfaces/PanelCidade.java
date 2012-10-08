package interfaces;

import dao.DaoCidade;
import dao.DaoEstado;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import entidades.Cidade;
import entidades.Estado;

public class PanelCidade {

    public JPanel inserirPnlCidade() throws ParseException {
        fontePadrao = new Font("Segoe UI", 1, 14);
        gridLayout3_1 = new GridLayout(3, 1);
        layoutLeft = new FlowLayout(FlowLayout.LEFT);
        layoutRight = new FlowLayout(FlowLayout.RIGHT);
        gridLayout3_1.setHgap(10);
        gridLayout3_1.setVgap(20);
        layoutLeft.setHgap(15);
        cidade = new Cidade();
        daoCidade = new DaoCidade();
        daoEstado = new DaoEstado();

        pnlCidade = new JPanel(gridLayout3_1);
        pnlCidade.setVisible(false);
        pnlCidade.setBorder(BorderFactory.createTitledBorder(null, " CIDADE ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlCidade.setBackground(new Color(240, 240, 240));

        pnlCidadeCadastro = new JPanel(layoutLeft);
        pnlCidadeAlteracao = new JPanel(layoutLeft);
        pnlCidadeRemocao = new JPanel(layoutLeft);
        pnlCidadeCadastroBotao = new JPanel(layoutRight);
        pnlCidadeAlteracaoBotao = new JPanel(layoutRight);
        pnlCidadeRemocaoBotao = new JPanel(layoutRight);

        pnlCidadeCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Cadastro ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlCidadeAlteracao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Alteracao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlCidadeRemocao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Remocao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));

        pnlCidadeCadastro.setBackground(new Color(240, 240, 240));
        pnlCidadeAlteracao.setBackground(new Color(240, 240, 240));
        pnlCidadeRemocao.setBackground(new Color(240, 240, 240));
        pnlCidadeCadastroBotao.setBackground(new Color(240, 240, 240));
        pnlCidadeAlteracaoBotao.setBackground(new Color(240, 240, 240));
        pnlCidadeRemocaoBotao.setBackground(new Color(240, 240, 240));

        //cadastro
        lblCidadeCadastroNome = new JLabel("Nome:");
        lblCidadeCadastroEstado = new JLabel("Estado:");
        btnCidadeCadastrar = new JButton("Cadastrar");
        btnCidadeCadastroLimpa = new JButton("Limpar Campos");
        txtCidadeCadastroNome = new JTextField("", 19);
        cboCidadeCadastroEstado = new JComboBox(new String[]{"Selecione"});

        lblCidadeCadastroNome.setPreferredSize(new Dimension(70, 30));
        lblCidadeCadastroEstado.setPreferredSize(new Dimension(61, 30));
        btnCidadeCadastrar.setPreferredSize(new Dimension(100, 32));
        btnCidadeCadastroLimpa.setPreferredSize(new Dimension(125, 32));
        pnlCidadeCadastroBotao.setPreferredSize(new Dimension(632, 40));
        cboCidadeCadastroEstado.setPreferredSize(new Dimension(229, 30));

        pnlCidadeCadastro.add(lblCidadeCadastroNome);
        pnlCidadeCadastro.add(txtCidadeCadastroNome);
        pnlCidadeCadastro.add(lblCidadeCadastroEstado);
        pnlCidadeCadastro.add(cboCidadeCadastroEstado);
        pnlCidadeCadastro.add(pnlCidadeCadastroBotao);
        pnlCidadeCadastroBotao.add(btnCidadeCadastroLimpa);
        pnlCidadeCadastroBotao.add(btnCidadeCadastrar);

        //alteracao
        lblCidadeAlteracaoNomeNovo = new JLabel("Novo Nome:");
        lblCidadeAlteracaoNome = new JLabel("Nome:");
        lblCidadeAlteracaoEstado = new JLabel("Estado:");
        btnCidadeAlterar = new JButton("Alterar");
        cboCidadeAlteracaoNome = new JComboBox(new String[]{"Selecione"});
        cboCidadeAlteracaoIdOculto = new JComboBox(new String[]{"Selecione"});
        txtCidadeAlteracaoNome = new JTextField("", 18);
        cboCidadeAlteracaoEstado = new JComboBox(new String[]{"Selecione"});

        lblCidadeAlteracaoNomeNovo.setPreferredSize(new Dimension(80, 30));
        lblCidadeAlteracaoNome.setPreferredSize(new Dimension(70, 30));
        lblCidadeAlteracaoEstado.setPreferredSize(new Dimension(70, 30));
        btnCidadeAlterar.setPreferredSize(new Dimension(100, 32));
        pnlCidadeAlteracaoBotao.setPreferredSize(new Dimension(310, 40));
        cboCidadeAlteracaoNome.setPreferredSize(new Dimension(222, 30));
        cboCidadeAlteracaoEstado.setPreferredSize(new Dimension(222, 30));

        cboCidadeAlteracaoIdOculto.setVisible(false);
        pnlCidadeAlteracao.add(cboCidadeAlteracaoIdOculto);
        pnlCidadeAlteracao.add(lblCidadeAlteracaoNome);
        pnlCidadeAlteracao.add(cboCidadeAlteracaoNome);
        pnlCidadeAlteracao.add(lblCidadeAlteracaoNomeNovo);
        pnlCidadeAlteracao.add(txtCidadeAlteracaoNome);
        pnlCidadeAlteracao.add(lblCidadeAlteracaoEstado);
        pnlCidadeAlteracao.add(cboCidadeAlteracaoEstado);
        pnlCidadeAlteracao.add(pnlCidadeAlteracaoBotao);
        pnlCidadeAlteracaoBotao.add(btnCidadeAlterar);

        //remocao
        lblCidadeRemocaoNome = new JLabel("Nome:");
        lblCidadeRemocaoEstado = new JLabel("Estado:");
        cboCidadeRemocaoNome = new JComboBox(new String[]{"Selecione"});
        cboCidadeRemocaoIdOculto = new JComboBox(new String[]{"Selecione"});
        lblCidadeRemocaoEstadoR = new JLabel("");
        btnCidadeRemover = new JButton("Remover");

        cboCidadeRemocaoNome.setPreferredSize(new Dimension(222, 30));
        lblCidadeRemocaoNome.setPreferredSize(new Dimension(70, 30));
        lblCidadeRemocaoEstado.setPreferredSize(new Dimension(70, 30));
        lblCidadeRemocaoEstadoR.setPreferredSize(new Dimension(222, 30));
        btnCidadeRemover.setPreferredSize(new Dimension(100, 32));
        pnlCidadeRemocaoBotao.setPreferredSize(new Dimension(632, 40));

        cboCidadeRemocaoIdOculto.setVisible(false);
        pnlCidadeRemocao.add(lblCidadeRemocaoNome);
        pnlCidadeRemocao.add(cboCidadeRemocaoNome);
        pnlCidadeRemocao.add(lblCidadeRemocaoEstado);
        pnlCidadeRemocao.add(lblCidadeRemocaoEstadoR);
        pnlCidadeRemocao.add(pnlCidadeRemocaoBotao);
        pnlCidadeRemocaoBotao.add(btnCidadeRemover);

        pnlCidade.add(pnlCidadeCadastro);
        pnlCidade.add(pnlCidadeAlteracao);
        pnlCidade.add(pnlCidadeRemocao);

        btnCidadeCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (txtCidadeCadastroNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um nome.");
                    txtCidadeCadastroNome.requestFocus();
                } else if (cboCidadeCadastroEstado.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Estado.");
                    cboCidadeCadastroEstado.requestFocus();
                } else {
                    cidade.setCidadeNome(txtCidadeCadastroNome.getText());
                    cidade.setCidade_estadoId(daoEstado.selecionaEstadoId(String.valueOf(cboCidadeCadastroEstado.getSelectedItem())));
                    boolean verifica = daoCidade.cadastrarCidade(cidade);
                    if (verifica == true) {
                        JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
                        txtCidadeCadastroNome.setText("");
                        cboCidadeCadastroEstado.setSelectedItem("Selecione");
                        carregaCombosCidade(2);
                        carregaCombosCidade(3);
                        txtCidadeCadastroNome.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cidade ja existe no Estado escolhido.");
                        cboCidadeCadastroEstado.setSelectedItem("Selecione");
                        cboCidadeCadastroEstado.requestFocus();
                    }
                }
            }
        });

        btnCidadeCadastroLimpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                txtCidadeCadastroNome.setText("");
                cboCidadeCadastroEstado.setSelectedItem("Selecione");
                txtCidadeCadastroNome.requestFocus();
            }
        });

        btnCidadeAlterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboCidadeAlteracaoNome.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um nome.");
                    cboCidadeAlteracaoNome.requestFocus();
                } else if (txtCidadeAlteracaoNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um nome.");
                    txtCidadeAlteracaoNome.requestFocus();
                } else if (cboCidadeAlteracaoEstado.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Estado.");
                    cboCidadeAlteracaoEstado.requestFocus();
                } else {
                    cidade.setCidadeId(Integer.parseInt(String.valueOf(cboCidadeAlteracaoIdOculto.getSelectedItem())));
                    cidade.setCidadeNome(txtCidadeAlteracaoNome.getText());
                    cidade.setCidade_estadoId(daoEstado.selecionaEstadoId(String.valueOf(cboCidadeAlteracaoEstado.getSelectedItem())));
                    boolean verifica = daoCidade.alterarCidade(cidade);
                    if (verifica == true) {
                        JOptionPane.showMessageDialog(null, "Cidade alterada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cidade ja existe!");
                    }
                    txtCidadeAlteracaoNome.setText("");
                    cboCidadeAlteracaoNome.setSelectedItem("Selecione");
                    cboCidadeAlteracaoEstado.setSelectedItem("Selecione");
                    cboCidadeAlteracaoIdOculto.setSelectedItem("Selecione");
                    carregaCombosCidade(2);
                    carregaCombosCidade(3);
                    cboCidadeAlteracaoNome.requestFocus();
                }
            }
        });

        btnCidadeRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int confirma = 0;
                if (cboCidadeRemocaoNome.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma cidade para remover.");
                    cboCidadeRemocaoNome.requestFocus();
                } else {
                    confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?");
                    if (confirma == JOptionPane.YES_OPTION) {
                        cidade.setCidadeId(Integer.parseInt(String.valueOf(cboCidadeRemocaoIdOculto.getSelectedItem())));
                        boolean verifica = daoCidade.removerCidade(cidade);
                        if (verifica) {
                            JOptionPane.showMessageDialog(null, "Cidade removida com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nao foi possivel remover cidade. Ela esta sendo usada por alguma rota.");
                        }
                        cboCidadeRemocaoNome.setSelectedItem("Selecione");
                        cboCidadeRemocaoIdOculto.setSelectedItem("Selecione");
                        carregaCombosCidade(2);
                        carregaCombosCidade(3);
                        cboCidadeRemocaoNome.requestFocus();
                    } else {
                        cboCidadeRemocaoNome.setSelectedItem("Selecione");
                        cboCidadeRemocaoIdOculto.setSelectedItem("Selecione");
                        cboCidadeRemocaoNome.requestFocus();
                    }
                }
            }
        });

        cboCidadeAlteracaoNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboCidadeAlteracaoNome.getSelectedItem().equals("Selecione"))) {
                        cboCidadeAlteracaoIdOculto.setSelectedIndex(cboCidadeAlteracaoNome.getSelectedIndex());
                        cidade.setCidadeId(Integer.parseInt(String.valueOf(cboCidadeAlteracaoIdOculto.getSelectedItem())));
                        Cidade aux = daoCidade.consultaCidade(cidade);
                        txtCidadeAlteracaoNome.setText(aux.getCidadeNome());
                        System.out.println(aux.getCidade_estadoId());
                        cboCidadeAlteracaoEstado.setSelectedItem(daoEstado.selecionaEstadoUF(Integer.parseInt(String.valueOf(aux.getCidade_estadoId()))));
                    } else {
                        txtCidadeAlteracaoNome.setText("");
                        cboCidadeAlteracaoEstado.setSelectedItem("Selecione");
                        cboCidadeAlteracaoIdOculto.setSelectedItem("Selecione");
                    }
                }
            }
        });

        cboCidadeRemocaoNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboCidadeRemocaoNome.getSelectedItem().equals("Selecione"))) {
                        cboCidadeRemocaoIdOculto.setSelectedIndex(cboCidadeRemocaoNome.getSelectedIndex());
                        cidade.setCidadeId(Integer.parseInt(String.valueOf(cboCidadeRemocaoIdOculto.getSelectedItem())));
                        Cidade aux = daoCidade.consultaCidade(cidade);
                        lblCidadeRemocaoEstadoR.setText(daoEstado.selecionaEstadoUF(Integer.parseInt(String.valueOf(aux.getCidade_estadoId()))));
                    } else {
                        lblCidadeRemocaoEstadoR.setText("");
                        cboCidadeRemocaoIdOculto.setSelectedIndex(cboCidadeRemocaoNome.getSelectedIndex());
                    }
                }
            }
        });
        return pnlCidade;
    }

    public void focusTxtPrincipal() {
        txtCidadeCadastroNome.requestFocus();
    }

    public void carregaCombosCidade(int id) {
        switch (id) {
            case 2: //alteracao
                ArrayList<Cidade> aux2 = daoCidade.consultarTodasCidades();
                cboCidadeAlteracaoNome.removeAllItems();
                cboCidadeAlteracaoNome.addItem("Selecione");
                cboCidadeAlteracaoIdOculto.removeAllItems();
                cboCidadeAlteracaoIdOculto.addItem("Selecione");
                for (int i = 0; i < aux2.size(); i++) {
                    cboCidadeAlteracaoNome.addItem(aux2.get(i).getCidadeNome());
                    cboCidadeAlteracaoIdOculto.addItem(aux2.get(i).getCidadeId());
                }
                break;
            case 3: //remocao
                ArrayList<Cidade> aux3 = daoCidade.consultarTodasCidades();
                cboCidadeRemocaoNome.removeAllItems();
                cboCidadeRemocaoNome.addItem("Selecione");
                cboCidadeRemocaoIdOculto.removeAllItems();
                cboCidadeRemocaoIdOculto.addItem("Selecione");
                for (int i = 0; i < aux3.size(); i++) {
                    cboCidadeRemocaoNome.addItem(aux3.get(i).getCidadeNome());
                    cboCidadeRemocaoIdOculto.addItem(aux3.get(i).getCidadeId());
                }
                break;
        }
    }

    public void carregaCombosEstado(int id) {
        switch (id) {

            case 5: //alteracao cidade
                ArrayList<Estado> aux5 = daoEstado.ConsultarTodosEstados();
                cboCidadeAlteracaoEstado.removeAllItems();
                cboCidadeAlteracaoEstado.addItem("Selecione");
                for (int i = 0; i < aux5.size(); i++) {
                    cboCidadeAlteracaoEstado.addItem(aux5.get(i).getEstadoUf());
                }
                break;
            case 6: //cadastro cidade
                ArrayList<Estado> aux6 = daoEstado.ConsultarTodosEstados();
                cboCidadeCadastroEstado.removeAllItems();
                cboCidadeCadastroEstado.addItem("Selecione");
                for (int i = 0; i < aux6.size(); i++) {
                    cboCidadeCadastroEstado.addItem(aux6.get(i).getEstadoUf());
                }
                break;
        }
    }
    //------- Geral
    private Font fontePadrao;
    private GridLayout gridLayout3_1;
    private FlowLayout layoutLeft;
    private FlowLayout layoutRight;
    private Cidade cidade;
    private DaoCidade daoCidade;
    private DaoEstado daoEstado;
    private JPanel pnlCidade;
    //------- Cidade
    private JPanel pnlCidadeCadastro;
    private JPanel pnlCidadeAlteracao;
    private JPanel pnlCidadeRemocao;
    private JPanel pnlCidadeCadastroBotao;
    private JPanel pnlCidadeAlteracaoBotao;
    private JPanel pnlCidadeRemocaoBotao;
    //cadastro
    private JLabel lblCidadeCadastroNome;
    private JLabel lblCidadeCadastroEstado;
    private JButton btnCidadeCadastrar;
    private JButton btnCidadeCadastroLimpa;
    private JTextField txtCidadeCadastroNome;
    private JComboBox cboCidadeCadastroEstado;
    //alteracao
    private JComboBox cboCidadeAlteracaoNome;
    private JComboBox cboCidadeAlteracaoIdOculto;
    private JLabel lblCidadeAlteracaoNome;
    private JLabel lblCidadeAlteracaoNomeNovo;
    private JLabel lblCidadeAlteracaoEstado;
    private JButton btnCidadeAlterar;
    private JTextField txtCidadeAlteracaoNome;
    private JComboBox cboCidadeAlteracaoEstado;
    //remocao
    private JLabel lblCidadeRemocaoNome;
    private JLabel lblCidadeRemocaoEstado;
    private JButton btnCidadeRemover;
    private JComboBox cboCidadeRemocaoNome;
    private JComboBox cboCidadeRemocaoIdOculto;
    private JLabel lblCidadeRemocaoEstadoR;
}
