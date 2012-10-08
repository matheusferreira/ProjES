package interfaces;

import dao.DaoFuncionario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import entidades.Funcionario;

public class PanelFuncionario extends JPanel {

    public JPanel inserirPnlFuncionario() throws ParseException {
        fontePadrao = new Font("Segoe UI", 1, 14);
        gridLayout2_2 = new GridLayout(2, 2);
        layoutLeft = new FlowLayout(FlowLayout.LEFT);
        layoutRight = new FlowLayout(FlowLayout.RIGHT);
        mascaraCpf = new MaskFormatter("###.###.###-##");
        gridLayout2_2.setHgap(10);
        gridLayout2_2.setVgap(20);
        layoutLeft.setHgap(15);
        daoFuncionario = new DaoFuncionario();
        funcionario = new Funcionario();

        pnlFuncionario = new JPanel(gridLayout2_2);
        pnlFuncionario.setVisible(false);
        pnlFuncionario.setBorder(BorderFactory.createTitledBorder(null, " FUNCIONARIO ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlFuncionario.setBackground(new Color(240, 240, 240));

        pnlFuncionarioCadastro = new JPanel(layoutRight);
        pnlFuncionarioAlteracao = new JPanel(layoutRight);
        pnlFuncionarioRemocao = new JPanel(layoutRight);
        pnlFuncionarioConsulta = new JPanel(layoutRight);

        pnlFuncionarioCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Cadastro ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlFuncionarioAlteracao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Alteracao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlFuncionarioRemocao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Remocao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlFuncionarioConsulta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Consulta ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));

        pnlFuncionarioCadastro.setBackground(new Color(240, 240, 240));
        pnlFuncionarioAlteracao.setBackground(new Color(240, 240, 240));
        pnlFuncionarioRemocao.setBackground(new Color(240, 240, 240));
        pnlFuncionarioConsulta.setBackground(new Color(240, 240, 240));

        //cadastro
        lblFuncionarioCadastroNome = new JLabel("Nome:");
        lblFuncionarioCadastroCpf = new JLabel("CPF:");
        lblFuncionarioCadastroEmail = new JLabel("E-mail:");
        lblFuncionarioCadastroSenha = new JLabel("Senha:");
        btnFuncionarioCadastrar = new JButton("Cadastrar");
        btnFuncionarioCadastroLimpa = new JButton("Limpar Campos");
        txtFuncionarioCadastroNome = new JTextField("", 17);
        txtFuncionarioCadastroCpf = new JFormattedTextField(mascaraCpf);
        txtFuncionarioCadastroEmail = new JTextField("", 17);
        txtFuncionarioCadastroSenha = new JPasswordField("", 17);
        chBxFuncionarioCadastroAdmin = new JCheckBox("Administrador");

        chBxFuncionarioCadastroAdmin.setSelected(false);
        txtFuncionarioCadastroCpf.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioCadastroNome.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioCadastroEmail.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioCadastroSenha.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioCadastroCpf.setPreferredSize(new Dimension(70, 30));
        btnFuncionarioCadastrar.setPreferredSize(new Dimension(100, 32));
        btnFuncionarioCadastroLimpa.setPreferredSize(new Dimension(128, 32));
        chBxFuncionarioCadastroAdmin.setPreferredSize(new Dimension(270, 30));

        pnlFuncionarioCadastro.add(lblFuncionarioCadastroNome);
        pnlFuncionarioCadastro.add(txtFuncionarioCadastroNome);
        pnlFuncionarioCadastro.add(lblFuncionarioCadastroCpf);
        pnlFuncionarioCadastro.add(txtFuncionarioCadastroCpf);
        pnlFuncionarioCadastro.add(lblFuncionarioCadastroEmail);
        pnlFuncionarioCadastro.add(txtFuncionarioCadastroEmail);
        pnlFuncionarioCadastro.add(lblFuncionarioCadastroSenha);
        pnlFuncionarioCadastro.add(txtFuncionarioCadastroSenha);
        pnlFuncionarioCadastro.add(chBxFuncionarioCadastroAdmin);
        pnlFuncionarioCadastro.add(btnFuncionarioCadastroLimpa);
        pnlFuncionarioCadastro.add(btnFuncionarioCadastrar);

        //alteracao
        lblFuncionarioAlteracaoNomeNovo = new JLabel("Novo Nome:");
        lblFuncionarioAlteracaoNome = new JLabel("Nome:");
        lblFuncionarioAlteracaoCpf = new JLabel("CPF:");
        lblFuncionarioAlteracaoEmail = new JLabel("E-mail:");
        lblFuncionarioAlteracaoSenha = new JLabel("Senha:");
        btnFuncionarioAlterar = new JButton("Alterar");
        cboFuncionarioAlteracaoNome = new JComboBox(new String[]{"Selecione"});
        cboFuncionarioAlteracaoIdOculto = new JComboBox(new String[]{"Selecione"});
        txtFuncionarioAlteracaoNome = new JTextField("", 17);
        txtFuncionarioAlteracaoCpf = new JFormattedTextField(mascaraCpf);
        txtFuncionarioAlteracaoEmail = new JTextField("", 17);
        txtFuncionarioAlteracaoSenha = new JPasswordField("", 17);
        chBxFuncionarioAlteracaoAdmin = new JCheckBox("Administrador");

        chBxFuncionarioAlteracaoAdmin.setSelected(false);
        txtFuncionarioAlteracaoCpf.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioAlteracaoNomeNovo.setPreferredSize(new Dimension(80, 30));
        lblFuncionarioAlteracaoNome.setPreferredSize(new Dimension(80, 30));
        lblFuncionarioAlteracaoEmail.setPreferredSize(new Dimension(80, 30));
        lblFuncionarioAlteracaoSenha.setPreferredSize(new Dimension(80, 30));
        lblFuncionarioAlteracaoCpf.setPreferredSize(new Dimension(80, 30));
        btnFuncionarioAlterar.setPreferredSize(new Dimension(100, 32));
        cboFuncionarioAlteracaoNome.setPreferredSize(new Dimension(200, 30));
        chBxFuncionarioAlteracaoAdmin.setPreferredSize(new Dimension(180, 30));

        cboFuncionarioAlteracaoIdOculto.setVisible(false);
        pnlFuncionarioAlteracao.add(cboFuncionarioAlteracaoIdOculto);
        pnlFuncionarioAlteracao.add(lblFuncionarioAlteracaoNome);
        pnlFuncionarioAlteracao.add(cboFuncionarioAlteracaoNome);
        pnlFuncionarioAlteracao.add(lblFuncionarioAlteracaoNomeNovo);
        pnlFuncionarioAlteracao.add(txtFuncionarioAlteracaoNome);
        pnlFuncionarioAlteracao.add(lblFuncionarioAlteracaoCpf);
        pnlFuncionarioAlteracao.add(txtFuncionarioAlteracaoCpf);
        pnlFuncionarioAlteracao.add(lblFuncionarioAlteracaoEmail);
        pnlFuncionarioAlteracao.add(txtFuncionarioAlteracaoEmail);
        pnlFuncionarioAlteracao.add(lblFuncionarioAlteracaoSenha);
        pnlFuncionarioAlteracao.add(txtFuncionarioAlteracaoSenha);
        pnlFuncionarioAlteracao.add(chBxFuncionarioAlteracaoAdmin);
        pnlFuncionarioAlteracao.add(btnFuncionarioAlterar);

        //remocao
        lblFuncionarioRemocaoNome = new JLabel("Nome:");
        lblFuncionarioRemocaoCpf = new JLabel("CPF:");
        lblFuncionarioRemocaoEmail = new JLabel("E-mail:");
        cboFuncionarioRemocaoNome = new JComboBox(new String[]{"Selecione"});
        cboFuncionarioRemocaoIdOculto = new JComboBox(new String[]{"Selecione"});
        lblFuncionarioRemocaoCpfR = new JLabel("");
        lblFuncionarioRemocaoEmailR = new JLabel("");
        btnFuncionarioRemover = new JButton("Remover");
        lblFuncionarioRemocaoAdmin = new JLabel();

        cboFuncionarioRemocaoNome.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioRemocaoNome.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioRemocaoEmail.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioRemocaoCpf.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioRemocaoEmailR.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioRemocaoCpfR.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioRemocaoAdmin.setPreferredSize(new Dimension(300, 30));
        btnFuncionarioRemover.setPreferredSize(new Dimension(100, 32));

        cboFuncionarioRemocaoIdOculto.setVisible(false);
        pnlFuncionarioRemocao.add(lblFuncionarioRemocaoNome);
        pnlFuncionarioRemocao.add(cboFuncionarioRemocaoNome);
        pnlFuncionarioRemocao.add(lblFuncionarioRemocaoCpf);
        pnlFuncionarioRemocao.add(lblFuncionarioRemocaoCpfR);
        pnlFuncionarioRemocao.add(lblFuncionarioRemocaoEmail);
        pnlFuncionarioRemocao.add(lblFuncionarioRemocaoEmailR);
        pnlFuncionarioRemocao.add(lblFuncionarioRemocaoAdmin);
        pnlFuncionarioRemocao.add(btnFuncionarioRemover);


        //consulta
        lblFuncionarioConsultaNome = new JLabel("Nome:");
        lblFuncionarioConsultaCpf = new JLabel("CPF:");
        lblFuncionarioConsultaEmail = new JLabel("E-mail:");
        cboFuncionarioConsultaNome = new JComboBox(new String[]{"Selecione"});
        cboFuncionarioConsultaIdOculto = new JComboBox(new String[]{"Selecione"});
        lblFuncionarioConsultaCpfR = new JLabel("");
        lblFuncionarioConsultaEmailR = new JLabel("");
        lblFuncionarioConsultaAdmin = new JLabel();

        cboFuncionarioConsultaNome.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioConsultaNome.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioConsultaEmail.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioConsultaCpf.setPreferredSize(new Dimension(70, 30));
        lblFuncionarioConsultaEmailR.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioConsultaCpfR.setPreferredSize(new Dimension(200, 30));
        lblFuncionarioConsultaAdmin.setPreferredSize(new Dimension(300, 30));

        cboFuncionarioConsultaIdOculto.setVisible(false);
        pnlFuncionarioConsulta.add(lblFuncionarioConsultaNome);
        pnlFuncionarioConsulta.add(cboFuncionarioConsultaNome);
        pnlFuncionarioConsulta.add(lblFuncionarioConsultaCpf);
        pnlFuncionarioConsulta.add(lblFuncionarioConsultaCpfR);
        pnlFuncionarioConsulta.add(lblFuncionarioConsultaEmail);
        pnlFuncionarioConsulta.add(lblFuncionarioConsultaEmailR);
        pnlFuncionarioConsulta.add(lblFuncionarioConsultaAdmin);

        pnlFuncionario.add(pnlFuncionarioCadastro);
        pnlFuncionario.add(pnlFuncionarioAlteracao);
        pnlFuncionario.add(pnlFuncionarioRemocao);
        pnlFuncionario.add(pnlFuncionarioConsulta);

        btnFuncionarioCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (txtFuncionarioCadastroNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite um nome.");
                    txtFuncionarioCadastroNome.requestFocus();
                } else if (txtFuncionarioCadastroCpf.getText().equals("   .   .   -  ")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite um CPF.");
                    txtFuncionarioCadastroCpf.requestFocus();
                } else if (txtFuncionarioCadastroEmail.getText().equals("")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite um e-mail.");
                    txtFuncionarioCadastroEmail.requestFocus();
                } else if (txtFuncionarioCadastroSenha.getText().equals("")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite uma senha.");
                    txtFuncionarioCadastroSenha.requestFocus();
                } else {
                    funcionario.setFuncionarioNome(txtFuncionarioCadastroNome.getText());
                    funcionario.setFuncionarioCpf(txtFuncionarioCadastroCpf.getText());
                    funcionario.setFuncionarioSenha(txtFuncionarioCadastroSenha.getText());
                    funcionario.setFuncionarioEmail(txtFuncionarioCadastroEmail.getText());
                    if (chBxFuncionarioCadastroAdmin.isSelected()) {
                        funcionario.setFuncionarioAcesso(1);
                    } else {
                        funcionario.setFuncionarioAcesso(0);
                    }
                    boolean verifica = daoFuncionario.cadastrarFuncionario(funcionario);
                    if (verifica) {
                        JOptionPane.showMessageDialog(pnlFuncionario, "Funcionario cadastrado com sucesso!");
                        txtFuncionarioCadastroNome.setText("");
                        txtFuncionarioCadastroCpf.setValue("");
                        txtFuncionarioCadastroSenha.setText("");
                        txtFuncionarioCadastroEmail.setText("");
                        chBxFuncionarioCadastroAdmin.setSelected(false);
                        carregaCombosFuncionario();
                        txtFuncionarioCadastroNome.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(pnlFuncionario, "CPF ja existe para outro funcionario!");
                        txtFuncionarioCadastroCpf.setValue("");
                        txtFuncionarioCadastroCpf.requestFocus();
                    }
                }
            }
        });

        btnFuncionarioCadastroLimpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                txtFuncionarioCadastroCpf.setValue("");
                txtFuncionarioCadastroEmail.setText("");
                txtFuncionarioCadastroSenha.setText("");
                txtFuncionarioCadastroNome.setText("");
                chBxFuncionarioCadastroAdmin.setSelected(false);
                txtFuncionarioCadastroNome.requestFocus();
            }
        });

        btnFuncionarioAlterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboFuncionarioAlteracaoNome.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Selecione um funcionario.");
                    cboFuncionarioAlteracaoNome.requestFocus();
                } else if (txtFuncionarioAlteracaoNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite um nome.");
                    txtFuncionarioAlteracaoNome.requestFocus();
                } else if (txtFuncionarioAlteracaoCpf.getText().equals("")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite um CPF.");
                    txtFuncionarioAlteracaoCpf.requestFocus();
                } else if (txtFuncionarioAlteracaoEmail.getText().equals("")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite um e-mail.");
                    txtFuncionarioAlteracaoEmail.requestFocus();
                } else if (txtFuncionarioAlteracaoSenha.getText().equals("")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Digite uma senha.");
                    txtFuncionarioAlteracaoSenha.requestFocus();
                } else {
                    funcionario.setFuncionarioId(Integer.parseInt(String.valueOf(cboFuncionarioAlteracaoIdOculto.getSelectedItem())));
                    funcionario.setFuncionarioNome(txtFuncionarioAlteracaoNome.getText());
                    funcionario.setFuncionarioCpf(txtFuncionarioAlteracaoCpf.getText());
                    funcionario.setFuncionarioSenha(txtFuncionarioAlteracaoSenha.getText());
                    funcionario.setFuncionarioEmail(txtFuncionarioAlteracaoEmail.getText());
                    if (chBxFuncionarioAlteracaoAdmin.isSelected()) {
                        funcionario.setFuncionarioAcesso(1);
                    } else {
                        funcionario.setFuncionarioAcesso(0);
                    }
                    boolean verifica = daoFuncionario.alterarFuncionario(funcionario);
                    if (verifica) {
                        JOptionPane.showMessageDialog(pnlFuncionario, "Funcionario alterado com sucesso!");
                        txtFuncionarioAlteracaoNome.setText("");
                        txtFuncionarioAlteracaoCpf.setValue("");
                        txtFuncionarioAlteracaoSenha.setText("");
                        txtFuncionarioAlteracaoEmail.setText("");
                        chBxFuncionarioAlteracaoAdmin.setSelected(false);
                        cboFuncionarioAlteracaoNome.setSelectedItem("Selecione");
                        cboFuncionarioAlteracaoIdOculto.setSelectedItem("Selecione");
                        carregaCombosFuncionario();
                        cboFuncionarioAlteracaoNome.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(pnlFuncionario, "CPF ja existe para outro funcionario!");
                        txtFuncionarioAlteracaoCpf.setValue("");
                        txtFuncionarioAlteracaoEmail.setText("");
                        txtFuncionarioAlteracaoNome.setText("");
                        txtFuncionarioAlteracaoSenha.setText("");
                        chBxFuncionarioAlteracaoAdmin.setSelected(false);
                        txtFuncionarioAlteracaoCpf.requestFocus();
                    }
                }
            }
        });

        btnFuncionarioRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int confirma = 0;
                if (cboFuncionarioRemocaoNome.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(pnlFuncionario, "Selecione um funcionario para remover.");
                    cboFuncionarioRemocaoNome.requestFocus();
                } else {
                    confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?");
                    if (confirma == JOptionPane.YES_OPTION) {
                        funcionario.setFuncionarioId(Integer.parseInt(String.valueOf(cboFuncionarioRemocaoIdOculto.getSelectedItem())));
                        boolean verifica = daoFuncionario.removerFuncionario(funcionario);
                        if (verifica) {
                            JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nao foi possivel remover o funcionario. Ele esta cadastrado em algum itinerario.");
                        }
                        cboFuncionarioRemocaoNome.setSelectedItem("Selecione");
                        cboFuncionarioRemocaoIdOculto.setSelectedItem("Selecione");
                        lblFuncionarioRemocaoCpfR.setText("");
                        lblFuncionarioRemocaoEmailR.setText("");
                        lblFuncionarioRemocaoAdmin.setText("");
                        carregaCombosFuncionario();
                        cboFuncionarioRemocaoNome.requestFocus();
                    } else {
                        cboFuncionarioRemocaoNome.setSelectedItem("Selecione");
                        cboFuncionarioRemocaoIdOculto.setSelectedItem("Selecione");
                        lblFuncionarioRemocaoCpfR.setText("");
                        lblFuncionarioRemocaoEmailR.setText("");
                        lblFuncionarioRemocaoAdmin.setText("");
                        cboFuncionarioRemocaoNome.requestFocus();
                    }
                }
            }
        });

        cboFuncionarioAlteracaoNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboFuncionarioAlteracaoNome.getSelectedItem().equals("Selecione"))) {
                        cboFuncionarioAlteracaoIdOculto.setSelectedIndex(cboFuncionarioAlteracaoNome.getSelectedIndex());
                        funcionario.setFuncionarioId(Integer.parseInt(String.valueOf(cboFuncionarioAlteracaoIdOculto.getSelectedItem())));
                        Funcionario aux = daoFuncionario.consultarFuncionario(funcionario);
                        txtFuncionarioAlteracaoNome.setText(aux.getFuncionarioNome());
                        txtFuncionarioAlteracaoCpf.setText(aux.getFuncionarioCpf());
                        txtFuncionarioAlteracaoSenha.setText(aux.getFuncionarioSenha());
                        txtFuncionarioAlteracaoEmail.setText(aux.getFuncionarioEmail());
                        if (aux.getFuncionarioAcesso() == 1) {
                            chBxFuncionarioAlteracaoAdmin.setSelected(true);
                        } else {
                            chBxFuncionarioAlteracaoAdmin.setSelected(false);
                        }
                    } else {
                        txtFuncionarioAlteracaoNome.setText("");
                        txtFuncionarioAlteracaoCpf.setValue("");
                        txtFuncionarioAlteracaoSenha.setText("");
                        txtFuncionarioAlteracaoEmail.setText("");
                        cboFuncionarioAlteracaoIdOculto.setSelectedItem("Selecione");
                    }
                }
            }
        });

        cboFuncionarioRemocaoNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboFuncionarioRemocaoNome.getSelectedItem().equals("Selecione"))) {
                        cboFuncionarioRemocaoIdOculto.setSelectedIndex(cboFuncionarioRemocaoNome.getSelectedIndex());
                        funcionario.setFuncionarioId(Integer.parseInt(String.valueOf(cboFuncionarioRemocaoIdOculto.getSelectedItem())));
                        Funcionario aux = daoFuncionario.consultarFuncionario(funcionario);
                        lblFuncionarioRemocaoCpfR.setText(aux.getFuncionarioCpf());
                        lblFuncionarioRemocaoEmailR.setText(aux.getFuncionarioEmail());
                        if (aux.getFuncionarioAcesso() == 1) {
                            lblFuncionarioRemocaoAdmin.setText("Administrador do Sistema.");
                        } else {
                            lblFuncionarioRemocaoAdmin.setText("Nao e Administrador do Sistema.");
                        }
                    } else {
                        lblFuncionarioRemocaoCpfR.setText("");
                        lblFuncionarioRemocaoEmailR.setText("");
                        lblFuncionarioRemocaoAdmin.setText("");
                        cboFuncionarioRemocaoIdOculto.setSelectedIndex(cboFuncionarioRemocaoNome.getSelectedIndex());
                    }
                }
            }
        });

        cboFuncionarioConsultaNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboFuncionarioConsultaNome.getSelectedItem().equals("Selecione"))) {
                        cboFuncionarioConsultaIdOculto.setSelectedIndex(cboFuncionarioConsultaNome.getSelectedIndex());
                        funcionario.setFuncionarioId(Integer.parseInt(String.valueOf(cboFuncionarioConsultaIdOculto.getSelectedItem())));
                        Funcionario aux = daoFuncionario.consultarFuncionario(funcionario);
                        lblFuncionarioConsultaCpfR.setText(aux.getFuncionarioCpf());
                        lblFuncionarioConsultaEmailR.setText(aux.getFuncionarioEmail());
                        if (aux.getFuncionarioAcesso() == 1) {
                            lblFuncionarioConsultaAdmin.setText("Administrador do Sistema.");
                        } else {
                            lblFuncionarioConsultaAdmin.setText("Nao e Administrador do Sistema.");
                        }
                    } else {
                        lblFuncionarioConsultaCpfR.setText("");
                        lblFuncionarioConsultaEmailR.setText("");
                        lblFuncionarioConsultaAdmin.setText("");
                        cboFuncionarioConsultaIdOculto.setSelectedIndex(cboFuncionarioConsultaNome.getSelectedIndex());
                    }
                }
            }
        });

        return pnlFuncionario;
    }

    public void focusTxtCadastro() {
        txtFuncionarioCadastroNome.requestFocus();
    }

    public void focusTxtAlteracao() {
        cboFuncionarioAlteracaoNome.requestFocus();
    }

    public void focusTxtRemocao() {
        cboFuncionarioRemocaoNome.requestFocus();
    }

    public void focusTxtConsulta() {
        cboFuncionarioConsultaNome.requestFocus();
    }

    public void carregaCombosFuncionario() {
        ArrayList<Funcionario> aux2 = daoFuncionario.consultarTodosFuncionarios();
        cboFuncionarioAlteracaoNome.removeAllItems();
        cboFuncionarioAlteracaoNome.addItem("Selecione");
        cboFuncionarioAlteracaoIdOculto.removeAllItems();
        cboFuncionarioAlteracaoIdOculto.addItem("Selecione");
        for (int i = 0; i < aux2.size(); i++) {
            cboFuncionarioAlteracaoIdOculto.addItem(aux2.get(i).getFuncionarioId());
            cboFuncionarioAlteracaoNome.addItem(aux2.get(i).getFuncionarioNome());
        }
        ArrayList<Funcionario> aux3 = daoFuncionario.consultarTodosFuncionarios();
        cboFuncionarioRemocaoNome.removeAllItems();
        cboFuncionarioRemocaoNome.addItem("Selecione");
        cboFuncionarioRemocaoIdOculto.removeAllItems();
        cboFuncionarioRemocaoIdOculto.addItem("Selecione");
        for (int i = 0; i < aux3.size(); i++) {
            cboFuncionarioRemocaoNome.addItem(aux3.get(i).getFuncionarioNome());
            cboFuncionarioRemocaoIdOculto.addItem(aux3.get(i).getFuncionarioId());
        }
        ArrayList<Funcionario> aux4 = daoFuncionario.consultarTodosFuncionarios();
        cboFuncionarioConsultaNome.removeAllItems();
        cboFuncionarioConsultaNome.addItem("Selecione");
        cboFuncionarioConsultaIdOculto.removeAllItems();
        cboFuncionarioConsultaIdOculto.addItem("Selecione");
        for (int i = 0; i < aux4.size(); i++) {
            cboFuncionarioConsultaNome.addItem(aux4.get(i).getFuncionarioNome());
            cboFuncionarioConsultaIdOculto.addItem(aux4.get(i).getFuncionarioId());
        }

    }

    private PlainDocument limitaCaracteres(final int limiteCaracteres) {
        return new PlainDocument() {

            @Override
            public void insertString(int offs, String str, AttributeSet a)
                    throws BadLocationException {
                if (getLength() + str.length() <= limiteCaracteres) {
                    super.insertString(offs, str, a);
                }
            }
        };
    }

    
    //------- Geral
    private Font fontePadrao;
    private GridLayout gridLayout2_2;
    private FlowLayout layoutLeft;
    private FlowLayout layoutRight;
    private MaskFormatter mascaraCpf;
    private DaoFuncionario daoFuncionario;
    private Funcionario funcionario;
    private JPanel pnlFuncionario;
    //------- Funcionario
    private JPanel pnlFuncionarioCadastro;
    private JPanel pnlFuncionarioAlteracao;
    private JPanel pnlFuncionarioRemocao;
    private JPanel pnlFuncionarioConsulta;
    //cadastro
    private JLabel lblFuncionarioCadastroNome;
    private JLabel lblFuncionarioCadastroCpf;
    private JLabel lblFuncionarioCadastroEmail;
    private JLabel lblFuncionarioCadastroSenha;
    private JButton btnFuncionarioCadastrar;
    private JButton btnFuncionarioCadastroLimpa;
    private JTextField txtFuncionarioCadastroNome;
    private JFormattedTextField txtFuncionarioCadastroCpf;
    private JTextField txtFuncionarioCadastroEmail;
    private JPasswordField txtFuncionarioCadastroSenha;
    private JCheckBox chBxFuncionarioCadastroAdmin;
    //alteracao
    private JComboBox cboFuncionarioAlteracaoNome;
    private JComboBox cboFuncionarioAlteracaoIdOculto;
    private JLabel lblFuncionarioAlteracaoNome;
    private JLabel lblFuncionarioAlteracaoNomeNovo;
    private JLabel lblFuncionarioAlteracaoCpf;
    private JLabel lblFuncionarioAlteracaoEmail;
    private JLabel lblFuncionarioAlteracaoSenha;
    private JButton btnFuncionarioAlterar;
    private JTextField txtFuncionarioAlteracaoNome;
    private JFormattedTextField txtFuncionarioAlteracaoCpf;
    private JTextField txtFuncionarioAlteracaoEmail;
    private JPasswordField txtFuncionarioAlteracaoSenha;
    private JCheckBox chBxFuncionarioAlteracaoAdmin;
    //remocao
    private JLabel lblFuncionarioRemocaoNome;
    private JLabel lblFuncionarioRemocaoCpf;
    private JLabel lblFuncionarioRemocaoEmail;
    private JButton btnFuncionarioRemover;
    private JComboBox cboFuncionarioRemocaoNome;
    private JComboBox cboFuncionarioRemocaoIdOculto;
    private JLabel lblFuncionarioRemocaoCpfR;
    private JLabel lblFuncionarioRemocaoEmailR;
    private JLabel lblFuncionarioRemocaoAdmin;
    //consulta
    private JLabel lblFuncionarioConsultaNome;
    private JLabel lblFuncionarioConsultaCpf;
    private JLabel lblFuncionarioConsultaEmail;
    private JComboBox cboFuncionarioConsultaNome;
    private JComboBox cboFuncionarioConsultaIdOculto;
    private JLabel lblFuncionarioConsultaCpfR;
    private JLabel lblFuncionarioConsultaEmailR;
    private JLabel lblFuncionarioConsultaAdmin;
}
