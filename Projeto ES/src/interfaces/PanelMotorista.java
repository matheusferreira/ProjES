package interfaces;

import dao.DaoMotorista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import entidades.Motorista;


public class PanelMotorista extends JPanel {

    public JPanel inserirPnlMotorista() throws ParseException {
        fontePadrao = new Font("Segoe UI", 1, 14);
        gridLayout3_1 = new GridLayout(3, 1);
        layoutLeft = new FlowLayout(FlowLayout.LEFT);
        layoutRight = new FlowLayout(FlowLayout.RIGHT);
        mascaraCpf = new MaskFormatter("###.###.###-##");
        mascaraTelefone = new MaskFormatter("(##) ####.####");
        gridLayout3_1.setHgap(10);
        gridLayout3_1.setVgap(20);
        layoutLeft.setHgap(15);
        daoMotorista = new DaoMotorista();
        motorista = new Motorista();
        
        pnlMotorista = new JPanel(gridLayout3_1);
        pnlMotorista.setVisible(false);
        pnlMotorista.setBorder(BorderFactory.createTitledBorder(null, " MOTORISTA ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlMotorista.setBackground(new Color(240, 240, 240));

        pnlMotoristaCadastro = new JPanel(layoutLeft);
        pnlMotoristaAlteracao = new JPanel(layoutLeft);
        pnlMotoristaRemocao = new JPanel(layoutLeft);
        pnlMotoristaCadastroBotao = new JPanel(layoutRight);
        pnlMotoristaAlteracaoBotao = new JPanel(layoutRight);
        pnlMotoristaRemocaoBotao = new JPanel(layoutRight);

        pnlMotoristaCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Cadastro ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlMotoristaAlteracao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Alteracao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlMotoristaRemocao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Remocao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));

        pnlMotoristaCadastro.setBackground(new Color(240, 240, 240));
        pnlMotoristaAlteracao.setBackground(new Color(240, 240, 240));
        pnlMotoristaRemocao.setBackground(new Color(240, 240, 240));
        pnlMotoristaCadastroBotao.setBackground(new Color(240, 240, 240));
        pnlMotoristaAlteracaoBotao.setBackground(new Color(240, 240, 240));
        pnlMotoristaRemocaoBotao.setBackground(new Color(240, 240, 240));

        //cadastro
        lblMotoristaCadastroNome = new JLabel("Nome:");
        lblMotoristaCadastroRg = new JLabel("RG:");
        lblMotoristaCadastroCpf = new JLabel("CPF:");
        lblMotoristaCadastroEmail = new JLabel("E-mail:");
        lblMotoristaCadastroEnd = new JLabel("Endereco:");
        lblMotoristaCadastroTel = new JLabel("Telefone:");
        btnMotoristaCadastrar = new JButton("Cadastrar");
        btnMotoristaCadastroLimpa = new JButton("Limpar Campos");
        txtMotoristaCadastroNome = new JTextField("", 19);
        txtMotoristaCadastroRg = new JTextField("", 19);
        txtMotoristaCadastroCpf = new JFormattedTextField(mascaraCpf);
        txtMotoristaCadastroEmail = new JTextField("", 19);
        txtMotoristaCadastroEnd = new JTextField("", 19);
        txtMotoristaCadastroTel = new JFormattedTextField(mascaraTelefone);

        txtMotoristaCadastroCpf.setPreferredSize(new Dimension(222, 30));
        txtMotoristaCadastroRg.setDocument(limitaCaracteres(12));

        txtMotoristaCadastroTel.setPreferredSize(new Dimension(222, 30));
        lblMotoristaCadastroNome.setPreferredSize(new Dimension(70, 30));
        lblMotoristaCadastroEmail.setPreferredSize(new Dimension(70, 30));
        lblMotoristaCadastroEnd.setPreferredSize(new Dimension(70, 30));
        lblMotoristaCadastroCpf.setPreferredSize(new Dimension(70, 30));
        lblMotoristaCadastroRg.setPreferredSize(new Dimension(70, 30));
        lblMotoristaCadastroTel.setPreferredSize(new Dimension(70, 30));
        btnMotoristaCadastrar.setPreferredSize(new Dimension(100, 32));
        btnMotoristaCadastroLimpa.setPreferredSize(new Dimension(128, 32));
        pnlMotoristaCadastroBotao.setPreferredSize(new Dimension(632, 40));

        pnlMotoristaCadastro.add(lblMotoristaCadastroNome);
        pnlMotoristaCadastro.add(txtMotoristaCadastroNome);
        pnlMotoristaCadastro.add(lblMotoristaCadastroRg);
        pnlMotoristaCadastro.add(txtMotoristaCadastroRg);
        pnlMotoristaCadastro.add(lblMotoristaCadastroCpf);
        pnlMotoristaCadastro.add(txtMotoristaCadastroCpf);
        pnlMotoristaCadastro.add(lblMotoristaCadastroEnd);
        pnlMotoristaCadastro.add(txtMotoristaCadastroEnd);
        pnlMotoristaCadastro.add(lblMotoristaCadastroTel);
        pnlMotoristaCadastro.add(txtMotoristaCadastroTel);
        pnlMotoristaCadastro.add(lblMotoristaCadastroEmail);
        pnlMotoristaCadastro.add(txtMotoristaCadastroEmail);
        pnlMotoristaCadastro.add(pnlMotoristaCadastroBotao);
        pnlMotoristaCadastroBotao.add(btnMotoristaCadastroLimpa);
        pnlMotoristaCadastroBotao.add(btnMotoristaCadastrar);

        //alteracao
        lblMotoristaAlteracaoNomeNovo = new JLabel("Novo Nome:");
        lblMotoristaAlteracaoNome = new JLabel("Nome:");
        lblMotoristaAlteracaoRg = new JLabel("RG:");
        lblMotoristaAlteracaoCpf = new JLabel("CPF:");
        lblMotoristaAlteracaoEmail = new JLabel("E-mail:");
        lblMotoristaAlteracaoEnd = new JLabel("Endereco:");
        lblMotoristaAlteracaoTel = new JLabel("Telefone:");
        btnMotoristaAlterar = new JButton("Alterar");
        cboMotoristaAlteracaoNome = new JComboBox(new String[]{"Selecione"});
        cboMotoristaAlteracaoIdOculto = new JComboBox(new String[]{"Selecione"});
        txtMotoristaAlteracaoNome = new JTextField("", 18);
        txtMotoristaAlteracaoRg = new JTextField("", 19);
        txtMotoristaAlteracaoCpf = new JFormattedTextField(mascaraCpf);
        txtMotoristaAlteracaoEmail = new JTextField("", 19);
        txtMotoristaAlteracaoEnd = new JTextField("", 19);
        txtMotoristaAlteracaoTel = new JFormattedTextField(mascaraTelefone);

        txtMotoristaAlteracaoRg.setDocument(limitaCaracteres(12));

        txtMotoristaAlteracaoCpf.setPreferredSize(new Dimension(211, 30));
        txtMotoristaAlteracaoTel.setPreferredSize(new Dimension(211, 30));
        lblMotoristaAlteracaoNomeNovo.setPreferredSize(new Dimension(80, 30));
        lblMotoristaAlteracaoNome.setPreferredSize(new Dimension(70, 30));
        lblMotoristaAlteracaoEmail.setPreferredSize(new Dimension(70, 30));
        lblMotoristaAlteracaoEnd.setPreferredSize(new Dimension(70, 30));
        lblMotoristaAlteracaoCpf.setPreferredSize(new Dimension(80, 30));
        lblMotoristaAlteracaoRg.setPreferredSize(new Dimension(70, 30));
        lblMotoristaAlteracaoTel.setPreferredSize(new Dimension(80, 30));
        btnMotoristaAlterar.setPreferredSize(new Dimension(100, 32));
        pnlMotoristaAlteracaoBotao.setPreferredSize(new Dimension(310, 40));
        cboMotoristaAlteracaoNome.setPreferredSize(new Dimension(222, 30));

        cboMotoristaAlteracaoIdOculto.setVisible(false);
        pnlMotoristaAlteracao.add(cboMotoristaAlteracaoIdOculto);
        pnlMotoristaAlteracao.add(lblMotoristaAlteracaoNome);
        pnlMotoristaAlteracao.add(cboMotoristaAlteracaoNome);
        pnlMotoristaAlteracao.add(lblMotoristaAlteracaoNomeNovo);
        pnlMotoristaAlteracao.add(txtMotoristaAlteracaoNome);
        pnlMotoristaAlteracao.add(lblMotoristaAlteracaoRg);
        pnlMotoristaAlteracao.add(txtMotoristaAlteracaoRg);
        pnlMotoristaAlteracao.add(lblMotoristaAlteracaoCpf);
        pnlMotoristaAlteracao.add(txtMotoristaAlteracaoCpf);
        pnlMotoristaAlteracao.add(lblMotoristaAlteracaoEnd);
        pnlMotoristaAlteracao.add(txtMotoristaAlteracaoEnd);
        pnlMotoristaAlteracao.add(lblMotoristaAlteracaoTel);
        pnlMotoristaAlteracao.add(txtMotoristaAlteracaoTel);
        pnlMotoristaAlteracao.add(lblMotoristaAlteracaoEmail);
        pnlMotoristaAlteracao.add(txtMotoristaAlteracaoEmail);
        pnlMotoristaAlteracao.add(pnlMotoristaAlteracaoBotao);
        pnlMotoristaAlteracaoBotao.add(btnMotoristaAlterar);

        //remocao
        lblMotoristaRemocaoNome = new JLabel("Nome:");
        lblMotoristaRemocaoRg = new JLabel("RG:");
        lblMotoristaRemocaoCpf = new JLabel("CPF:");
        lblMotoristaRemocaoEmail = new JLabel("E-mail:");
        lblMotoristaRemocaoEnd = new JLabel("Endereco:");
        lblMotoristaRemocaoTel = new JLabel("Telefone:");
        cboMotoristaRemocaoNome = new JComboBox(new String[]{"Selecione"});
        cboMotoristaRemocaoIdOculto = new JComboBox(new String[]{"Selecione"});
        lblMotoristaRemocaoRgR = new JLabel("");
        lblMotoristaRemocaoCpfR = new JLabel("");
        lblMotoristaRemocaoEmailR = new JLabel("");
        lblMotoristaRemocaoEndR = new JLabel("");
        lblMotoristaRemocaoTelR = new JLabel("");
        btnMotoristaRemover = new JButton("Remover");

        cboMotoristaRemocaoNome.setPreferredSize(new Dimension(222, 30));
        lblMotoristaRemocaoNome.setPreferredSize(new Dimension(70, 30));
        lblMotoristaRemocaoEmail.setPreferredSize(new Dimension(70, 30));
        lblMotoristaRemocaoEnd.setPreferredSize(new Dimension(70, 30));
        lblMotoristaRemocaoCpf.setPreferredSize(new Dimension(70, 30));
        lblMotoristaRemocaoRg.setPreferredSize(new Dimension(70, 30));
        lblMotoristaRemocaoTel.setPreferredSize(new Dimension(70, 30));
        lblMotoristaRemocaoEmailR.setPreferredSize(new Dimension(222, 30));
        lblMotoristaRemocaoEndR.setPreferredSize(new Dimension(222, 30));
        lblMotoristaRemocaoCpfR.setPreferredSize(new Dimension(222, 30));
        lblMotoristaRemocaoRgR.setPreferredSize(new Dimension(222, 30));
        lblMotoristaRemocaoTelR.setPreferredSize(new Dimension(222, 30));
        btnMotoristaRemover.setPreferredSize(new Dimension(100, 32));
        pnlMotoristaRemocaoBotao.setPreferredSize(new Dimension(632, 40));

        cboMotoristaRemocaoIdOculto.setVisible(false);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoNome);
        pnlMotoristaRemocao.add(cboMotoristaRemocaoNome);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoRg);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoRgR);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoCpf);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoCpfR);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoEnd);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoEndR);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoTel);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoTelR);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoEmail);
        pnlMotoristaRemocao.add(lblMotoristaRemocaoEmailR);
        pnlMotoristaRemocao.add(pnlMotoristaRemocaoBotao);
        pnlMotoristaRemocaoBotao.add(btnMotoristaRemover);

        pnlMotorista.add(pnlMotoristaCadastro);
        pnlMotorista.add(pnlMotoristaAlteracao);
        pnlMotorista.add(pnlMotoristaRemocao);

        btnMotoristaCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (txtMotoristaCadastroNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um nome.");
                    txtMotoristaCadastroNome.requestFocus();
                } else if (txtMotoristaCadastroRg.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um RG.");
                    txtMotoristaCadastroRg.requestFocus();
                } else if (txtMotoristaCadastroCpf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um CPF.");
                    txtMotoristaCadastroCpf.requestFocus();
                } else if (txtMotoristaCadastroEnd.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um endereco.");
                    txtMotoristaCadastroEnd.requestFocus();
                } else {
                    motorista.setMotoristaNome(txtMotoristaCadastroNome.getText());
                    motorista.setMotoristaRg(removeCaracteres(txtMotoristaCadastroRg.getText()));
                    motorista.setMotoristaCpf(txtMotoristaCadastroCpf.getText());
                    motorista.setMotoristaEnd(txtMotoristaCadastroEnd.getText());
                    motorista.setMotoristaTel(txtMotoristaCadastroTel.getText());
                    motorista.setMotoristaEmail(txtMotoristaCadastroEmail.getText());
                    int verifica = daoMotorista.cadastrarMotorista(motorista);
                    if (verifica == 0) {
                        JOptionPane.showMessageDialog(null, "Motorista cadastrado com sucesso!");
                        txtMotoristaCadastroNome.setText("");
                        txtMotoristaCadastroRg.setText("");
                        txtMotoristaCadastroCpf.setValue("");
                        txtMotoristaCadastroEnd.setText("");
                        txtMotoristaCadastroTel.setValue("");
                        txtMotoristaCadastroEmail.setText("");
                        carregaCombosMotorista(2);
                        carregaCombosMotorista(3);
                        txtMotoristaCadastroNome.requestFocus();
                    } else if (verifica == 1) {
                        JOptionPane.showMessageDialog(null, "RG ja existe para outro motorista!");
                        txtMotoristaCadastroRg.setText("");
                        txtMotoristaCadastroRg.requestFocus();
                    } else if (verifica == 2) {
                        JOptionPane.showMessageDialog(null, "CPF ja existe para outro motorista!");
                        txtMotoristaCadastroCpf.setValue("");
                        txtMotoristaCadastroCpf.requestFocus();
                    }
                }
            }
        });

        btnMotoristaCadastroLimpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                txtMotoristaCadastroCpf.setValue("");
                txtMotoristaCadastroEmail.setText("");
                txtMotoristaCadastroEnd.setText("");
                txtMotoristaCadastroNome.setText("");
                txtMotoristaCadastroRg.setText("");
                txtMotoristaCadastroTel.setValue("");
                txtMotoristaCadastroNome.requestFocus();
            }
        });

        btnMotoristaAlterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboMotoristaAlteracaoNome.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um motorista.");
                    cboMotoristaAlteracaoNome.requestFocus();
                } else if (txtMotoristaAlteracaoNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um nome.");
                    txtMotoristaAlteracaoNome.requestFocus();
                } else if (txtMotoristaAlteracaoRg.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um RG.");
                    txtMotoristaAlteracaoRg.requestFocus();
                } else if (txtMotoristaAlteracaoCpf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um CPF.");
                    txtMotoristaAlteracaoCpf.requestFocus();
                } else if (txtMotoristaAlteracaoEnd.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um endereco.");
                    txtMotoristaAlteracaoEnd.requestFocus();
                } else {
                    motorista.setMotoristaId(Integer.parseInt(String.valueOf(cboMotoristaAlteracaoIdOculto.getSelectedItem())));
                    motorista.setMotoristaNome(txtMotoristaAlteracaoNome.getText());
                    motorista.setMotoristaRg(removeCaracteres(txtMotoristaAlteracaoRg.getText()));
                    motorista.setMotoristaCpf(txtMotoristaAlteracaoCpf.getText());
                    motorista.setMotoristaEnd(txtMotoristaAlteracaoEnd.getText());
                    motorista.setMotoristaTel(txtMotoristaAlteracaoTel.getText());
                    motorista.setMotoristaEmail(txtMotoristaAlteracaoEmail.getText());
                    int verifica = daoMotorista.alterarMotorista(motorista);
                    if (verifica == 0) {
                        JOptionPane.showMessageDialog(null, "Motorista alterado com sucesso!");
                        txtMotoristaAlteracaoNome.setText("");
                        txtMotoristaAlteracaoRg.setText("");
                        txtMotoristaAlteracaoCpf.setValue("");
                        txtMotoristaAlteracaoEnd.setText("");
                        txtMotoristaAlteracaoTel.setValue("");
                        txtMotoristaAlteracaoEmail.setText("");
                        cboMotoristaAlteracaoNome.setSelectedItem("Selecione");
                        cboMotoristaAlteracaoIdOculto.setSelectedItem("Selecione");
                        carregaCombosMotorista(2);
                        carregaCombosMotorista(3);
                        cboMotoristaAlteracaoNome.requestFocus();
                    } else if (verifica == 1) {
                        JOptionPane.showMessageDialog(null, "RG ja existe para outro motorista!");
                        txtMotoristaAlteracaoRg.setText("");
                        txtMotoristaAlteracaoRg.requestFocus();
                    } else if (verifica == 2) {
                        JOptionPane.showMessageDialog(null, "CPF ja existe para outro motorista!");
                        txtMotoristaAlteracaoCpf.setValue("");
                        txtMotoristaAlteracaoCpf.requestFocus();
                    }
                }
            }
        });

        btnMotoristaRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int confirma = 0;
                if (cboMotoristaRemocaoNome.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um motorista para remover.");
                    cboMotoristaRemocaoNome.requestFocus();
                } else {
                    confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?");
                    if (confirma == JOptionPane.YES_OPTION) {
                        motorista.setMotoristaId(Integer.parseInt(String.valueOf(cboMotoristaRemocaoIdOculto.getSelectedItem())));
                        boolean verifica = daoMotorista.removerMotorista(motorista);
                        if(verifica) JOptionPane.showMessageDialog(null, "Motorista removido com sucesso!");
                        else JOptionPane.showMessageDialog(null, "Nao foi possivel remover o motorista. Ele esta cadastrado em algum itinerario.");
                        cboMotoristaRemocaoNome.setSelectedItem("Selecione");
                        cboMotoristaRemocaoIdOculto.setSelectedItem("Selecione");
                        carregaCombosMotorista(2);
                        carregaCombosMotorista(3);
                        cboMotoristaRemocaoNome.requestFocus();
                    } else {
                        cboMotoristaRemocaoNome.setSelectedItem("Selecione");
                        cboMotoristaRemocaoIdOculto.setSelectedItem("Selecione");
                        cboMotoristaRemocaoNome.requestFocus();
                    }
                }
            }
        });

        cboMotoristaAlteracaoNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboMotoristaAlteracaoNome.getSelectedItem().equals("Selecione"))) {
                        cboMotoristaAlteracaoIdOculto.setSelectedIndex(cboMotoristaAlteracaoNome.getSelectedIndex());
                        motorista.setMotoristaId(Integer.parseInt(String.valueOf(cboMotoristaAlteracaoIdOculto.getSelectedItem())));                Motorista aux = daoMotorista.consultarMotorista(motorista);
                        txtMotoristaAlteracaoNome.setText(aux.getMotoristaNome());
                        txtMotoristaAlteracaoRg.setText(aux.getMotoristaRg());
                        txtMotoristaAlteracaoCpf.setText(aux.getMotoristaCpf());
                        txtMotoristaAlteracaoTel.setText(aux.getMotoristaTel());
                        txtMotoristaAlteracaoEnd.setText(aux.getMotoristaEnd());
                        txtMotoristaAlteracaoEmail.setText(aux.getMotoristaEmail());
                    } else {
                        txtMotoristaAlteracaoNome.setText("");
                        txtMotoristaAlteracaoRg.setText("");
                        txtMotoristaAlteracaoCpf.setValue("");
                        txtMotoristaAlteracaoTel.setValue("");
                        txtMotoristaAlteracaoEnd.setText("");
                        txtMotoristaAlteracaoEmail.setText("");
                        cboMotoristaAlteracaoIdOculto.setSelectedItem("Selecione");
                    }
                }
            }
        });

        cboMotoristaRemocaoNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboMotoristaRemocaoNome.getSelectedItem().equals("Selecione"))) {
                        cboMotoristaRemocaoIdOculto.setSelectedIndex(cboMotoristaRemocaoNome.getSelectedIndex());
                        motorista.setMotoristaId(Integer.parseInt(String.valueOf(cboMotoristaRemocaoIdOculto.getSelectedItem())));
                        Motorista aux = daoMotorista.consultarMotorista(motorista);
                        lblMotoristaRemocaoRgR.setText(aux.getMotoristaRg());
                        lblMotoristaRemocaoCpfR.setText(aux.getMotoristaCpf());
                        lblMotoristaRemocaoTelR.setText(aux.getMotoristaTel());
                        lblMotoristaRemocaoEndR.setText(aux.getMotoristaEnd());
                        lblMotoristaRemocaoEmailR.setText(aux.getMotoristaEmail());
                    } else {
                        lblMotoristaRemocaoRgR.setText("");
                        lblMotoristaRemocaoCpfR.setText("");
                        lblMotoristaRemocaoTelR.setText("");
                        lblMotoristaRemocaoEndR.setText("");
                        lblMotoristaRemocaoEmailR.setText("");
                        cboMotoristaRemocaoIdOculto.setSelectedIndex(cboMotoristaRemocaoNome.getSelectedIndex());
                    }
                }
            }
        });
        
        return pnlMotorista;
    }

    public void focusTxtPrincipal(){
        txtMotoristaCadastroNome.requestFocus();
    }
    
    public void carregaCombosMotorista(int id) {
        switch (id) {
            case 2: //alteracao
                ArrayList<Motorista> aux2 = daoMotorista.consultarTodosMotoristas();
                cboMotoristaAlteracaoNome.removeAllItems();
                cboMotoristaAlteracaoNome.addItem("Selecione");
                cboMotoristaAlteracaoIdOculto.removeAllItems();
                cboMotoristaAlteracaoIdOculto.addItem("Selecione");
                for (int i = 0; i < aux2.size(); i++) {
                    cboMotoristaAlteracaoIdOculto.addItem(aux2.get(i).getMotoristaId());
                    cboMotoristaAlteracaoNome.addItem(aux2.get(i).getMotoristaNome());
                }
                break;
            case 3: //remocao
                ArrayList<Motorista> aux3 = daoMotorista.consultarTodosMotoristas();
                cboMotoristaRemocaoNome.removeAllItems();
                cboMotoristaRemocaoNome.addItem("Selecione");
                cboMotoristaRemocaoIdOculto.removeAllItems();
                cboMotoristaRemocaoIdOculto.addItem("Selecione");
                for (int i = 0; i < aux3.size(); i++) {
                    cboMotoristaRemocaoNome.addItem(aux3.get(i).getMotoristaNome());
                    cboMotoristaRemocaoIdOculto.addItem(aux3.get(i).getMotoristaId());
                }
                break;
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

    private static String removeCaracteres(String s) {
        String temp = Normalizer.normalize(s, java.text.Normalizer.Form.NFD);
        temp = temp.replaceAll("\\.", "");
        return temp.replaceAll("-", "");
    }

    
    //------- Geral
    private Font fontePadrao;
    private GridLayout gridLayout3_1;
    private FlowLayout layoutLeft;
    private FlowLayout layoutRight;
    private MaskFormatter mascaraCpf;
    private MaskFormatter mascaraTelefone;
    private DaoMotorista daoMotorista;
    private Motorista motorista;
    private JPanel pnlMotorista;
    
    //------- Motorista
    private JPanel pnlMotoristaCadastro;
    private JPanel pnlMotoristaAlteracao;
    private JPanel pnlMotoristaRemocao;
    private JPanel pnlMotoristaCadastroBotao;
    private JPanel pnlMotoristaAlteracaoBotao;
    private JPanel pnlMotoristaRemocaoBotao;
    //cadastro
    private JLabel lblMotoristaCadastroNome;
    private JLabel lblMotoristaCadastroRg;
    private JLabel lblMotoristaCadastroCpf;
    private JLabel lblMotoristaCadastroEmail;
    private JLabel lblMotoristaCadastroEnd;
    private JLabel lblMotoristaCadastroTel;
    private JButton btnMotoristaCadastrar;
    private JButton btnMotoristaCadastroLimpa;
    private JTextField txtMotoristaCadastroNome;
    private JTextField txtMotoristaCadastroRg;
    private JFormattedTextField txtMotoristaCadastroCpf;
    private JTextField txtMotoristaCadastroEmail;
    private JTextField txtMotoristaCadastroEnd;
    private JFormattedTextField txtMotoristaCadastroTel;
    //alteracao
    private JComboBox cboMotoristaAlteracaoNome;
    private JComboBox cboMotoristaAlteracaoIdOculto;
    private JLabel lblMotoristaAlteracaoNome;
    private JLabel lblMotoristaAlteracaoNomeNovo;
    private JLabel lblMotoristaAlteracaoRg;
    private JLabel lblMotoristaAlteracaoCpf;
    private JLabel lblMotoristaAlteracaoEmail;
    private JLabel lblMotoristaAlteracaoEnd;
    private JLabel lblMotoristaAlteracaoTel;
    private JButton btnMotoristaAlterar;
    private JTextField txtMotoristaAlteracaoNome;
    private JTextField txtMotoristaAlteracaoRg;
    private JFormattedTextField txtMotoristaAlteracaoCpf;
    private JTextField txtMotoristaAlteracaoEmail;
    private JTextField txtMotoristaAlteracaoEnd;
    private JFormattedTextField txtMotoristaAlteracaoTel;
    //remocao
    private JLabel lblMotoristaRemocaoNome;
    private JLabel lblMotoristaRemocaoRg;
    private JLabel lblMotoristaRemocaoCpf;
    private JLabel lblMotoristaRemocaoEmail;
    private JLabel lblMotoristaRemocaoEnd;
    private JLabel lblMotoristaRemocaoTel;
    private JButton btnMotoristaRemover;
    private JComboBox cboMotoristaRemocaoNome;
    private JComboBox cboMotoristaRemocaoIdOculto;
    private JLabel lblMotoristaRemocaoRgR;
    private JLabel lblMotoristaRemocaoCpfR;
    private JLabel lblMotoristaRemocaoEmailR;
    private JLabel lblMotoristaRemocaoEndR;
    private JLabel lblMotoristaRemocaoTelR;
}
