package interfaces;

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
import javax.swing.text.MaskFormatter;

import entidades.Estado;


public class PanelEstado {

    public JPanel inserirPnlEstado() throws ParseException {
        fontePadrao = new Font("Segoe UI", 1, 14);
        gridLayout3_1 = new GridLayout(3, 1);
        layoutLeft = new FlowLayout(FlowLayout.LEFT);
        layoutRight = new FlowLayout(FlowLayout.RIGHT);
        mascaraUF = new MaskFormatter("UU");
        gridLayout3_1.setHgap(10);
        gridLayout3_1.setVgap(20);
        layoutLeft.setHgap(15);
        daoEstado = new DaoEstado();
        estado = new Estado();
        
        pnlEstado = new JPanel(gridLayout3_1);
        pnlEstado.setVisible(false);
        pnlEstado.setBorder(BorderFactory.createTitledBorder(null, " ESTADO ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlEstado.setBackground(new Color(240, 240, 240));

        pnlEstadoCadastro = new JPanel(layoutLeft);
        pnlEstadoAlteracao = new JPanel(layoutLeft);
        pnlEstadoRemocao = new JPanel(layoutLeft);
        pnlEstadoCadastroBotao = new JPanel(layoutRight);
        pnlEstadoAlteracaoBotao = new JPanel(layoutRight);
        pnlEstadoRemocaoBotao = new JPanel(layoutRight);

        pnlEstadoCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Cadastro ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlEstadoAlteracao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Alteracao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlEstadoRemocao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Remocao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));

        pnlEstadoCadastro.setBackground(new Color(240, 240, 240));
        pnlEstadoAlteracao.setBackground(new Color(240, 240, 240));
        pnlEstadoRemocao.setBackground(new Color(240, 240, 240));
        pnlEstadoCadastroBotao.setBackground(new Color(240, 240, 240));
        pnlEstadoAlteracaoBotao.setBackground(new Color(240, 240, 240));
        pnlEstadoRemocaoBotao.setBackground(new Color(240, 240, 240));

        //cadastro
        lblEstadoCadastroUf = new JLabel("UF:");
        btnEstadoCadastrar = new JButton("Cadastrar");
        btnEstadoCadastroLimpa = new JButton("Limpar Campos");
        txtEstadoCadastroUf = new JFormattedTextField(mascaraUF);

        txtEstadoCadastroUf.setPreferredSize(new Dimension(220, 30));
        lblEstadoCadastroUf.setPreferredSize(new Dimension(70, 30));
        btnEstadoCadastrar.setPreferredSize(new Dimension(100, 32));
        btnEstadoCadastroLimpa.setPreferredSize(new Dimension(128, 32));
        pnlEstadoCadastroBotao.setPreferredSize(new Dimension(310, 40));

        pnlEstadoCadastro.add(lblEstadoCadastroUf);
        pnlEstadoCadastro.add(txtEstadoCadastroUf);
        pnlEstadoCadastro.add(pnlEstadoCadastroBotao);
        pnlEstadoCadastroBotao.add(btnEstadoCadastroLimpa);
        pnlEstadoCadastroBotao.add(btnEstadoCadastrar);

        //alteracao
        lblEstadoAlteracaoUfNovo = new JLabel("Novo UF:");
        lblEstadoAlteracaoUf = new JLabel("UF:");
        btnEstadoAlterar = new JButton("Alterar");
        cboEstadoAlteracaoUf = new JComboBox(new String[]{"Selecione"});
        cboEstadoAlteracaoIdOculto = new JComboBox(new String[]{"Selecione"});
        txtEstadoAlteracaoUf = new JFormattedTextField(mascaraUF);

        txtEstadoAlteracaoUf.setPreferredSize(new Dimension(210, 30));
        lblEstadoAlteracaoUfNovo.setPreferredSize(new Dimension(80, 30));
        lblEstadoAlteracaoUf.setPreferredSize(new Dimension(70, 30));
        btnEstadoAlterar.setPreferredSize(new Dimension(100, 32));
        pnlEstadoAlteracaoBotao.setPreferredSize(new Dimension(632, 40));
        cboEstadoAlteracaoUf.setPreferredSize(new Dimension(222, 30));

        cboEstadoAlteracaoIdOculto.setVisible(false);
        pnlEstadoAlteracao.add(cboEstadoAlteracaoIdOculto);
        pnlEstadoAlteracao.add(lblEstadoAlteracaoUf);
        pnlEstadoAlteracao.add(cboEstadoAlteracaoUf);
        pnlEstadoAlteracao.add(lblEstadoAlteracaoUfNovo);
        pnlEstadoAlteracao.add(txtEstadoAlteracaoUf);
        pnlEstadoAlteracao.add(pnlEstadoAlteracaoBotao);
        pnlEstadoAlteracaoBotao.add(btnEstadoAlterar);

        //remocao
        lblEstadoRemocaoUf = new JLabel("UF:");
        cboEstadoRemocaoUf = new JComboBox(new String[]{"Selecione"});
        cboEstadoRemocaoIdOculto = new JComboBox(new String[]{"Selecione"});
        btnEstadoRemover = new JButton("Remover");

        cboEstadoRemocaoUf.setPreferredSize(new Dimension(222, 30));
        lblEstadoRemocaoUf.setPreferredSize(new Dimension(70, 30));
        btnEstadoRemover.setPreferredSize(new Dimension(100, 32));
        pnlEstadoRemocaoBotao.setPreferredSize(new Dimension(310, 40));

        pnlEstadoRemocao.add(lblEstadoRemocaoUf);
        pnlEstadoRemocao.add(cboEstadoRemocaoUf);
        pnlEstadoRemocao.add(pnlEstadoRemocaoBotao);
        pnlEstadoRemocaoBotao.add(btnEstadoRemover);

        cboEstadoRemocaoIdOculto.setVisible(false);
        pnlEstado.add(pnlEstadoCadastro);
        pnlEstado.add(pnlEstadoAlteracao);
        pnlEstado.add(pnlEstadoRemocao);

        btnEstadoCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (txtEstadoCadastroUf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite um nome.");
            txtEstadoCadastroUf.requestFocus();
        } else {
            estado.setEstadoUf(txtEstadoCadastroUf.getText());
            boolean verifica = daoEstado.cadastrarEstado(estado);
            if (verifica == true) {
                JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Estado ja existe!");
            }
            txtEstadoCadastroUf.setValue("");
            carregaCombosEstado(2);
            carregaCombosEstado(3);
            txtEstadoCadastroUf.requestFocus();
        }
            }
        });

        btnEstadoCadastroLimpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                txtEstadoCadastroUf.setValue("");
                txtEstadoCadastroUf.requestFocus();
            }
        });

        btnEstadoAlterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboEstadoAlteracaoUf.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um nome.");
                    cboEstadoAlteracaoUf.requestFocus();
                } else if (txtEstadoAlteracaoUf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um nome.");
                    txtEstadoAlteracaoUf.requestFocus();
                } else {
                    estado.setEstadoId(Integer.parseInt(String.valueOf(cboEstadoAlteracaoIdOculto.getSelectedItem())));
                    estado.setEstadoUf(txtEstadoAlteracaoUf.getText());
                    boolean verifica = daoEstado.alterarEstado(estado);
                    if (verifica == true) {
                        JOptionPane.showMessageDialog(null, "Estado alterado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Estado ja existe!");
                    }
                    txtEstadoAlteracaoUf.setValue("");
                    cboEstadoAlteracaoUf.setSelectedItem("Selecione");
                    cboEstadoAlteracaoIdOculto.setSelectedItem("Selecione");
                    carregaCombosEstado(2);
                    carregaCombosEstado(3);
                    cboEstadoAlteracaoUf.requestFocus();
                }
            }
        });

        btnEstadoRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int confirma = 0;
                if (cboEstadoRemocaoUf.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Estado para remover.");
                    cboEstadoRemocaoUf.requestFocus();
                } else {
                    confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?");
                    if (confirma == JOptionPane.YES_OPTION) {
                        cboEstadoRemocaoIdOculto.setSelectedIndex(cboEstadoRemocaoUf.getSelectedIndex());
                        estado.setEstadoId(Integer.parseInt(String.valueOf(cboEstadoRemocaoIdOculto.getSelectedItem())));
                        boolean verifica = daoEstado.removerEstado(estado);
                        if (verifica == true) {
                            JOptionPane.showMessageDialog(null, "Estado removido com sucesso!");
                            cboEstadoRemocaoUf.setSelectedItem("Selecione");
                            cboEstadoRemocaoIdOculto.setSelectedItem("Selecione");
                            carregaCombosEstado(2);
                            carregaCombosEstado(3);
                            cboEstadoRemocaoUf.requestFocus();
                        } else {
                            JOptionPane.showMessageDialog(null, "Estado nao pode ser removido. Ha cidades relacionadas a ele.");
                            cboEstadoRemocaoUf.setSelectedItem("Selecione");
                            cboEstadoRemocaoIdOculto.setSelectedItem("Selecione");
                            cboEstadoRemocaoUf.requestFocus();
                        }
                    } else {
                        cboEstadoRemocaoUf.setSelectedItem("Selecione");
                        cboEstadoRemocaoIdOculto.setSelectedItem("Selecione");
                        cboEstadoRemocaoUf.requestFocus();
                    }
                }
            }
        });

        cboEstadoAlteracaoUf.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                txtEstadoAlteracaoUf.requestFocus();
                cboEstadoAlteracaoUf.requestFocus();
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboEstadoAlteracaoUf.getSelectedItem().equals("Selecione"))) {
                        txtEstadoAlteracaoUf.setText(String.valueOf(cboEstadoAlteracaoUf.getSelectedItem()));
                        cboEstadoAlteracaoIdOculto.setSelectedIndex(cboEstadoAlteracaoUf.getSelectedIndex());
                    } else {
                        txtEstadoAlteracaoUf.setValue("");
                        cboEstadoAlteracaoIdOculto.setSelectedItem("Selecione");
                    }
                }
            }
        });

        cboEstadoRemocaoUf.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                cboEstadoRemocaoIdOculto.setSelectedIndex(cboEstadoRemocaoUf.getSelectedIndex());
            }
        });

        return pnlEstado;
    }

    public void focusTxtPrincipal(){
        txtEstadoCadastroUf.requestFocus();
    }
    
    public void carregaCombosEstado(int id) {
        switch (id) {
            case 2: //alteracao
                ArrayList<Estado> aux2 = daoEstado.ConsultarTodosEstados();
                cboEstadoAlteracaoUf.removeAllItems();
                cboEstadoAlteracaoUf.addItem("Selecione");
                cboEstadoAlteracaoIdOculto.removeAllItems();
                cboEstadoAlteracaoIdOculto.addItem("Selecione");
                for (int i = 0; i < aux2.size(); i++) {
                    cboEstadoAlteracaoUf.addItem(aux2.get(i).getEstadoUf());
                    cboEstadoAlteracaoIdOculto.addItem(aux2.get(i).getEstadoId());
                }
                break;
            case 3: //remocao
                ArrayList<Estado> aux3 = daoEstado.ConsultarTodosEstados();
                cboEstadoRemocaoUf.removeAllItems();
                cboEstadoRemocaoUf.addItem("Selecione");
                cboEstadoRemocaoIdOculto.removeAllItems();
                cboEstadoRemocaoIdOculto.addItem("Selecione");
                for (int i = 0; i < aux3.size(); i++) {
                    cboEstadoRemocaoUf.addItem(aux3.get(i).getEstadoUf());
                    cboEstadoRemocaoIdOculto.addItem(aux3.get(i).getEstadoId());
                }
                break;
        }
    }

    
    private JPanel pnlEstado;
    //------- Geral
    private Font fontePadrao;
    private GridLayout gridLayout3_1;
    private FlowLayout layoutLeft;
    private FlowLayout layoutRight;
    private DaoEstado daoEstado;
    private Estado estado;
    private MaskFormatter mascaraUF;
    //------- Estado
    private JPanel pnlEstadoCadastro;
    private JPanel pnlEstadoAlteracao;
    private JPanel pnlEstadoRemocao;
    private JPanel pnlEstadoCadastroBotao;
    private JPanel pnlEstadoAlteracaoBotao;
    private JPanel pnlEstadoRemocaoBotao;
    //cadastro
    private JLabel lblEstadoCadastroUf;
    private JButton btnEstadoCadastrar;
    private JButton btnEstadoCadastroLimpa;
    private JFormattedTextField txtEstadoCadastroUf;
    //alteracao
    private JComboBox cboEstadoAlteracaoUf;
    private JComboBox cboEstadoAlteracaoIdOculto;
    private JLabel lblEstadoAlteracaoUf;
    private JLabel lblEstadoAlteracaoUfNovo;
    private JButton btnEstadoAlterar;
    private JFormattedTextField txtEstadoAlteracaoUf;
    //remocao
    private JLabel lblEstadoRemocaoUf;
    private JButton btnEstadoRemover;
    private JComboBox cboEstadoRemocaoUf;
    private JComboBox cboEstadoRemocaoIdOculto;
}
