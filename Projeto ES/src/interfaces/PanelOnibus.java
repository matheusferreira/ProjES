package interfaces;

import dao.DaoOnibus;
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

import entidades.Onibus;


public class PanelOnibus {

    public JPanel inserirPnlOnibus() throws ParseException {
        fontePadrao = new Font("Segoe UI", 1, 14);
        gridLayout3_1 = new GridLayout(3, 1);
        layoutLeft = new FlowLayout(FlowLayout.LEFT);
        layoutRight = new FlowLayout(FlowLayout.RIGHT);
        mascaraPlaca = new MaskFormatter("UUU-####");
        mascaraAno = new MaskFormatter("####");
        mascaraQtdeAssentos = new MaskFormatter("##");
        gridLayout3_1.setHgap(10);
        gridLayout3_1.setVgap(20);
        layoutLeft.setHgap(15);
        daoOnibus = new DaoOnibus();
        onibus = new Onibus();
        
        pnlOnibus = new JPanel(gridLayout3_1);
        pnlOnibus.setVisible(false);
        pnlOnibus.setBorder(BorderFactory.createTitledBorder(null, " ONIBUS ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlOnibus.setBackground(new Color(240, 240, 240));

        pnlOnibusCadastro = new JPanel(layoutLeft);
        pnlOnibusAlteracao = new JPanel(layoutLeft);
        pnlOnibusRemocao = new JPanel(layoutLeft);
        pnlOnibusCadastroBotao = new JPanel(layoutRight);
        pnlOnibusAlteracaoBotao = new JPanel(layoutRight);
        pnlOnibusRemocaoBotao = new JPanel(layoutRight);

        pnlOnibusCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Cadastro ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlOnibusAlteracao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Alteracao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlOnibusRemocao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " Remocao ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));

        pnlOnibusCadastro.setBackground(new Color(240, 240, 240));
        pnlOnibusAlteracao.setBackground(new Color(240, 240, 240));
        pnlOnibusRemocao.setBackground(new Color(240, 240, 240));
        pnlOnibusCadastroBotao.setBackground(new Color(240, 240, 240));
        pnlOnibusAlteracaoBotao.setBackground(new Color(240, 240, 240));
        pnlOnibusRemocaoBotao.setBackground(new Color(240, 240, 240));

        //cadastro
        lblOnibusCadastroPlaca = new JLabel("Placa:");
        lblOnibusCadastroModelo = new JLabel("Modelo:");
        lblOnibusCadastroMarca = new JLabel("Marca:");
        lblOnibusCadastroAno = new JLabel("Ano:");
        lblOnibusCadastroQtdeAssentos = new JLabel("Assentos:");
        btnOnibusCadastrar = new JButton("Cadastrar");
        btnOnibusCadastroLimpa = new JButton("Limpar Campos");
        txtOnibusCadastroPlaca = new JFormattedTextField(mascaraPlaca);
        txtOnibusCadastroModelo = new JTextField("", 15);
        txtOnibusCadastroMarca = new JTextField("", 15);
        txtOnibusCadastroAno = new JFormattedTextField(mascaraAno);
        txtOnibusCadastroQtdeAssentos = new JFormattedTextField(mascaraQtdeAssentos);
        txtOnibusCadastroQtdeAssentos.setEnabled(false);
        txtOnibusCadastroQtdeAssentos.setValue("48");
        
        txtOnibusCadastroAno.setPreferredSize(new Dimension(177, 30));
        txtOnibusCadastroQtdeAssentos.setPreferredSize(new Dimension(177, 30));
        txtOnibusCadastroPlaca.setPreferredSize(new Dimension(177, 30));
        lblOnibusCadastroPlaca.setPreferredSize(new Dimension(110, 30));
        lblOnibusCadastroAno.setPreferredSize(new Dimension(110, 30));
        lblOnibusCadastroQtdeAssentos.setPreferredSize(new Dimension(110, 30));
        lblOnibusCadastroMarca.setPreferredSize(new Dimension(110, 30));
        lblOnibusCadastroModelo.setPreferredSize(new Dimension(110, 30));
        btnOnibusCadastrar.setPreferredSize(new Dimension(100, 32));
        btnOnibusCadastroLimpa.setPreferredSize(new Dimension(128, 32));
        pnlOnibusCadastroBotao.setPreferredSize(new Dimension(307, 40));

        pnlOnibusCadastro.add(lblOnibusCadastroPlaca);
        pnlOnibusCadastro.add(txtOnibusCadastroPlaca);
        pnlOnibusCadastro.add(lblOnibusCadastroModelo);
        pnlOnibusCadastro.add(txtOnibusCadastroModelo);
        pnlOnibusCadastro.add(lblOnibusCadastroMarca);
        pnlOnibusCadastro.add(txtOnibusCadastroMarca);
        pnlOnibusCadastro.add(lblOnibusCadastroAno);
        pnlOnibusCadastro.add(txtOnibusCadastroAno);
        pnlOnibusCadastro.add(lblOnibusCadastroQtdeAssentos);
        pnlOnibusCadastro.add(txtOnibusCadastroQtdeAssentos);
        pnlOnibusCadastro.add(pnlOnibusCadastroBotao);
        pnlOnibusCadastroBotao.add(btnOnibusCadastroLimpa);
        pnlOnibusCadastroBotao.add(btnOnibusCadastrar);

        //alteracao
        lblOnibusAlteracaoPlacaNova = new JLabel("Nova Placa:");
        lblOnibusAlteracaoPlaca = new JLabel("Placa:");
        lblOnibusAlteracaoModelo = new JLabel("Modelo:");
        lblOnibusAlteracaoMarca = new JLabel("Marca:");
        lblOnibusAlteracaoAno = new JLabel("Ano:");
        lblOnibusAlteracaoQtdeAssentos = new JLabel("Assentos:");
        btnOnibusAlterar = new JButton("Alterar");
        cboOnibusAlteracaoPlaca = new JComboBox(new String[]{"Selecione"});
        cboOnibusAlteracaoIdOculto = new JComboBox(new String[]{"Selecione"});
        txtOnibusAlteracaoPlaca = new JFormattedTextField(mascaraPlaca);
        txtOnibusAlteracaoModelo = new JTextField("", 15);
        txtOnibusAlteracaoMarca = new JTextField("", 14);
        txtOnibusAlteracaoAno = new JFormattedTextField(mascaraAno);
        txtOnibusAlteracaoQtdeAssentos = new JFormattedTextField(mascaraQtdeAssentos);
        txtOnibusAlteracaoQtdeAssentos.setEnabled(false);
        txtOnibusAlteracaoQtdeAssentos.setValue("48");
        
        txtOnibusAlteracaoAno.setPreferredSize(new Dimension(177, 30));
        txtOnibusAlteracaoQtdeAssentos.setPreferredSize(new Dimension(166, 30));
        txtOnibusAlteracaoPlaca.setPreferredSize(new Dimension(166, 30));
        lblOnibusAlteracaoPlacaNova.setPreferredSize(new Dimension(120, 30));
        lblOnibusAlteracaoPlaca.setPreferredSize(new Dimension(110, 30));
        lblOnibusAlteracaoAno.setPreferredSize(new Dimension(110, 30));
        lblOnibusAlteracaoQtdeAssentos.setPreferredSize(new Dimension(120, 30));
        lblOnibusAlteracaoMarca.setPreferredSize(new Dimension(120, 30));
        lblOnibusAlteracaoModelo.setPreferredSize(new Dimension(110, 30));
        btnOnibusAlterar.setPreferredSize(new Dimension(100, 32));
        pnlOnibusAlteracaoBotao.setPreferredSize(new Dimension(625, 40));
        cboOnibusAlteracaoPlaca.setPreferredSize(new Dimension(177, 30));

        cboOnibusAlteracaoIdOculto.setVisible(false);
        pnlOnibusAlteracao.add(cboOnibusAlteracaoIdOculto);
        pnlOnibusAlteracao.add(lblOnibusAlteracaoPlaca);
        pnlOnibusAlteracao.add(cboOnibusAlteracaoPlaca);
        pnlOnibusAlteracao.add(lblOnibusAlteracaoPlacaNova);
        pnlOnibusAlteracao.add(txtOnibusAlteracaoPlaca);
        pnlOnibusAlteracao.add(lblOnibusAlteracaoModelo);
        pnlOnibusAlteracao.add(txtOnibusAlteracaoModelo);
        pnlOnibusAlteracao.add(lblOnibusAlteracaoMarca);
        pnlOnibusAlteracao.add(txtOnibusAlteracaoMarca);
        pnlOnibusAlteracao.add(lblOnibusAlteracaoAno);
        pnlOnibusAlteracao.add(txtOnibusAlteracaoAno);
        pnlOnibusAlteracao.add(lblOnibusAlteracaoQtdeAssentos);
        pnlOnibusAlteracao.add(txtOnibusAlteracaoQtdeAssentos);
        pnlOnibusAlteracao.add(pnlOnibusAlteracaoBotao);
        pnlOnibusAlteracaoBotao.add(btnOnibusAlterar);

        //remocao
        lblOnibusRemocaoPlaca = new JLabel("Placa:");
        lblOnibusRemocaoModelo = new JLabel("Modelo:");
        lblOnibusRemocaoMarca = new JLabel("Marca:");
        lblOnibusRemocaoAno = new JLabel("Ano:");
        lblOnibusRemocaoQtdeAssentos = new JLabel("Assentos:");
        cboOnibusRemocaoPlaca = new JComboBox(new String[]{"Selecione"});
        cboOnibusRemocaoIdOculto = new JComboBox(new String[]{"Selecione"});
        lblOnibusRemocaoModeloR = new JLabel("");
        lblOnibusRemocaoMarcaR = new JLabel("");
        lblOnibusRemocaoAnoR = new JLabel("");
        lblOnibusRemocaoQtdeAssentosR = new JLabel("");
        btnOnibusRemover = new JButton("Remover");

        cboOnibusRemocaoPlaca.setPreferredSize(new Dimension(177, 30));
        lblOnibusRemocaoPlaca.setPreferredSize(new Dimension(110, 30));
        lblOnibusRemocaoAno.setPreferredSize(new Dimension(110, 30));
        lblOnibusRemocaoQtdeAssentos.setPreferredSize(new Dimension(110, 30));
        lblOnibusRemocaoMarca.setPreferredSize(new Dimension(110, 30));
        lblOnibusRemocaoModelo.setPreferredSize(new Dimension(110, 30));
        lblOnibusRemocaoAnoR.setPreferredSize(new Dimension(177, 30));
        lblOnibusRemocaoQtdeAssentosR.setPreferredSize(new Dimension(177, 30));
        lblOnibusRemocaoMarcaR.setPreferredSize(new Dimension(177, 30));
        lblOnibusRemocaoModeloR.setPreferredSize(new Dimension(177, 30));
        btnOnibusRemover.setPreferredSize(new Dimension(100, 32));
        pnlOnibusRemocaoBotao.setPreferredSize(new Dimension(307, 40));

        cboOnibusRemocaoIdOculto.setVisible(false);
        pnlOnibusRemocao.add(lblOnibusRemocaoPlaca);
        pnlOnibusRemocao.add(cboOnibusRemocaoPlaca);
        pnlOnibusRemocao.add(lblOnibusRemocaoModelo);
        pnlOnibusRemocao.add(lblOnibusRemocaoModeloR);
        pnlOnibusRemocao.add(lblOnibusRemocaoMarca);
        pnlOnibusRemocao.add(lblOnibusRemocaoMarcaR);
        pnlOnibusRemocao.add(lblOnibusRemocaoAno);
        pnlOnibusRemocao.add(lblOnibusRemocaoAnoR);
        pnlOnibusRemocao.add(lblOnibusRemocaoQtdeAssentos);
        pnlOnibusRemocao.add(lblOnibusRemocaoQtdeAssentosR);
        pnlOnibusRemocao.add(pnlOnibusRemocaoBotao);
        pnlOnibusRemocaoBotao.add(btnOnibusRemover);

        pnlOnibus.add(pnlOnibusCadastro);
        pnlOnibus.add(pnlOnibusAlteracao);
        pnlOnibus.add(pnlOnibusRemocao);

        btnOnibusCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (txtOnibusCadastroPlaca.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite uma identificacao.");
                    txtOnibusCadastroPlaca.requestFocus();
                } else if (txtOnibusCadastroModelo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um modelo.");
                    txtOnibusCadastroModelo.requestFocus();
                } else if (txtOnibusCadastroMarca.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite uma marca.");
                    txtOnibusCadastroMarca.requestFocus();
                } else if (txtOnibusCadastroAno.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um ano.");
                    txtOnibusCadastroAno.requestFocus();
                } else if (txtOnibusCadastroQtdeAssentos.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite a quantidade de assentos.");
                    txtOnibusCadastroQtdeAssentos.requestFocus();
                } else {
                    int auxAno = 0;
                    int auxQtdeAssentos = 0;
                    try {
                        auxAno = Integer.parseInt(txtOnibusCadastroAno.getText());
                        try {
                            auxQtdeAssentos = Integer.parseInt(txtOnibusCadastroQtdeAssentos.getText());
                            onibus.setOnibusPlaca(txtOnibusCadastroPlaca.getText());
                            onibus.setOnibusModelo(txtOnibusCadastroModelo.getText());
                            onibus.setOnibusMarca(txtOnibusCadastroMarca.getText());
                            onibus.setOnibusAno(Integer.parseInt(txtOnibusCadastroAno.getText()));
                            onibus.setOnibusQtdeAssentos(Integer.parseInt(txtOnibusCadastroQtdeAssentos.getText()));
                            boolean verifica = daoOnibus.cadastrarOnibus(onibus);
                            if (verifica == true) {
                                JOptionPane.showMessageDialog(null, "Onibus cadastrado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Onibus ja existe!");
                            }
                            txtOnibusCadastroPlaca.setValue("");
                            txtOnibusCadastroModelo.setText("");
                            txtOnibusCadastroMarca.setText("");
                            txtOnibusCadastroAno.setValue("");
                            txtOnibusCadastroQtdeAssentos.setValue("48");
                            carregaCombosOnibus(2);
                            carregaCombosOnibus(3);
                            txtOnibusCadastroPlaca.requestFocus();
                        } catch (NumberFormatException ex) {
                            System.err.println(ex);
                            JOptionPane.showMessageDialog(null, "Por favor, digite uma quantidade de assentos valida.");
                            txtOnibusCadastroQtdeAssentos.setValue("");
                            txtOnibusCadastroQtdeAssentos.requestFocus();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, digite um ano valido.");
                        txtOnibusCadastroAno.setValue("");
                        txtOnibusCadastroAno.requestFocus();
                    }
                }
            }
        });

        btnOnibusCadastroLimpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                txtOnibusCadastroAno.setValue("");
                txtOnibusCadastroPlaca.setValue("");
                txtOnibusCadastroMarca.setText("");
                txtOnibusCadastroModelo.setText("");
                txtOnibusCadastroQtdeAssentos.setValue("48");
                txtOnibusCadastroPlaca.requestFocus();
            }
        });

        btnOnibusAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboOnibusAlteracaoPlaca.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma placa.");
                    cboOnibusAlteracaoPlaca.requestFocus();
                } else if (txtOnibusAlteracaoPlaca.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite uma identificacao.");
                    txtOnibusAlteracaoPlaca.requestFocus();
                } else if (txtOnibusAlteracaoModelo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um modelo.");
                    txtOnibusAlteracaoModelo.requestFocus();
                } else if (txtOnibusAlteracaoMarca.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite uma marca.");
                    txtOnibusAlteracaoMarca.requestFocus();
                } else if (txtOnibusAlteracaoAno.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite um ano.");
                    txtOnibusAlteracaoAno.requestFocus();
                } else if (txtOnibusAlteracaoQtdeAssentos.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite a quantidade de assentos.");
                    txtOnibusAlteracaoQtdeAssentos.requestFocus();
                } else {
                    int auxAno = 0;
                    int auxQtdeAssentos = 0;
                    try {
                        auxAno = Integer.parseInt(txtOnibusAlteracaoAno.getText());
                        try {
                            auxQtdeAssentos = Integer.parseInt(txtOnibusAlteracaoQtdeAssentos.getText());
                            onibus.setOnibusId(Integer.parseInt(String.valueOf(cboOnibusAlteracaoIdOculto.getSelectedItem())));
                            onibus.setOnibusPlaca(txtOnibusAlteracaoPlaca.getText());
                            onibus.setOnibusModelo(txtOnibusAlteracaoModelo.getText());
                            onibus.setOnibusMarca(txtOnibusAlteracaoMarca.getText());
                            onibus.setOnibusAno(Integer.parseInt(txtOnibusAlteracaoAno.getText()));
                            onibus.setOnibusQtdeAssentos(Integer.parseInt(txtOnibusAlteracaoQtdeAssentos.getText()));
                            boolean verifica = daoOnibus.alterarOnibus(onibus);
                            if (verifica == true) {
                                JOptionPane.showMessageDialog(null, "Onibus alterado com sucesso!");
                                txtOnibusAlteracaoPlaca.setValue("");
                                txtOnibusAlteracaoModelo.setText("");
                                txtOnibusAlteracaoMarca.setText("");
                                txtOnibusAlteracaoAno.setValue("");
                                txtOnibusAlteracaoQtdeAssentos.setValue("48");
                                cboOnibusAlteracaoPlaca.setSelectedItem("Selecione");
                                cboOnibusAlteracaoIdOculto.setSelectedItem("Selecione");
                                carregaCombosOnibus(2);
                                carregaCombosOnibus(3);
                                cboOnibusAlteracaoPlaca.requestFocus();
                            } else {
                                JOptionPane.showMessageDialog(null, "Ja existe um onibus com esta identificacao.");
                                txtOnibusAlteracaoPlaca.setValue("");
                                txtOnibusAlteracaoPlaca.requestFocus();
                            }

                        } catch (NumberFormatException ex) {
                            System.err.println(ex);
                            JOptionPane.showMessageDialog(null, "Por favor, digite uma quantidade de assentos valida.");
                            txtOnibusAlteracaoQtdeAssentos.setValue("");
                            txtOnibusAlteracaoQtdeAssentos.requestFocus();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, digite um ano valido.");
                        txtOnibusAlteracaoAno.setValue("");
                        txtOnibusAlteracaoAno.requestFocus();
                    }
                }
            }
        });

        btnOnibusRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int confirma = 0;
                if (cboOnibusRemocaoPlaca.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um onibus para remover.");
                    cboOnibusRemocaoPlaca.requestFocus();
                } else {
                    confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?");
                    if (confirma == JOptionPane.YES_OPTION) {
                        onibus.setOnibusId(Integer.parseInt(String.valueOf(cboOnibusRemocaoIdOculto.getSelectedItem())));
                        boolean verifica = daoOnibus.removerOnibus(onibus);
                        if (verifica) JOptionPane.showMessageDialog(null, "Onibus removido com sucesso!");
                        else JOptionPane.showMessageDialog(null, "Nao foi possivel remover o onibus. Ele esta cadastrado em algum itinerario.");
                        cboOnibusRemocaoPlaca.setSelectedItem("Selecione");
                        cboOnibusRemocaoIdOculto.setSelectedItem("Selecione");
                        carregaCombosOnibus(2);
                        carregaCombosOnibus(3);
                        cboOnibusRemocaoPlaca.requestFocus();
                    } else {
                        cboOnibusRemocaoPlaca.setSelectedItem("Selecione");
                        cboOnibusRemocaoIdOculto.setSelectedItem("Selecione");
                        cboOnibusRemocaoPlaca.requestFocus();
                    }
                }
            }
        });

        cboOnibusAlteracaoPlaca.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                txtOnibusAlteracaoPlaca.requestFocus();
                cboOnibusAlteracaoPlaca.requestFocus();
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboOnibusAlteracaoPlaca.getSelectedItem().equals("Selecione"))) {
                        cboOnibusAlteracaoIdOculto.setSelectedIndex(cboOnibusAlteracaoPlaca.getSelectedIndex());
                        onibus.setOnibusId(Integer.parseInt(String.valueOf(cboOnibusAlteracaoIdOculto.getSelectedItem())));
                        Onibus aux = daoOnibus.consultaOnibus(onibus);
                        txtOnibusAlteracaoPlaca.setText(aux.getOnibusPlaca());
                        txtOnibusAlteracaoModelo.setText(aux.getOnibusModelo());
                        txtOnibusAlteracaoMarca.setText(aux.getOnibusMarca());
                        txtOnibusAlteracaoAno.setText(String.valueOf(aux.getOnibusAno()));
                        txtOnibusAlteracaoQtdeAssentos.setText(String.valueOf(aux.getOnibusQtdeAssentos()));
                    } else {
                        txtOnibusAlteracaoPlaca.setValue("");
                        txtOnibusAlteracaoModelo.setText("");
                        txtOnibusAlteracaoMarca.setText("");
                        txtOnibusAlteracaoAno.setValue("");
                        txtOnibusAlteracaoQtdeAssentos.setValue("48");
                        cboOnibusAlteracaoIdOculto.setSelectedItem("Selecione");
                    }
                }
            }
        });

        cboOnibusRemocaoPlaca.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboOnibusRemocaoPlaca.getSelectedItem().equals("Selecione"))) {
                        cboOnibusRemocaoIdOculto.setSelectedIndex(cboOnibusRemocaoPlaca.getSelectedIndex());
                        onibus.setOnibusId(Integer.parseInt(String.valueOf(cboOnibusRemocaoIdOculto.getSelectedItem())));
                        Onibus aux = daoOnibus.consultaOnibus(onibus);
                        lblOnibusRemocaoModeloR.setText(aux.getOnibusModelo());
                        lblOnibusRemocaoMarcaR.setText(aux.getOnibusModelo());
                        lblOnibusRemocaoAnoR.setText(String.valueOf(aux.getOnibusAno()));
                        lblOnibusRemocaoQtdeAssentosR.setText(String.valueOf(aux.getOnibusQtdeAssentos()));
                    } else {
                        lblOnibusRemocaoModeloR.setText("");
                        lblOnibusRemocaoMarcaR.setText("");
                        lblOnibusRemocaoAnoR.setText("");
                        lblOnibusRemocaoQtdeAssentosR.setText("");
                        cboOnibusRemocaoIdOculto.setSelectedIndex(cboOnibusRemocaoPlaca.getSelectedIndex());
                    }
                }
            }
        });

        txtOnibusAlteracaoPlaca.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                txtOnibusAlteracaoPlaca.requestFocus();
            }
        });

        return pnlOnibus;
    }

    public void focusTxtPrincipal(){
        txtOnibusCadastroPlaca.requestFocus();
    }
    
    public void carregaCombosOnibus(int id) {
        switch (id) {
            case 2: //alteracao
                ArrayList<Onibus> aux2 = daoOnibus.consultarTodosOnibus();
                cboOnibusAlteracaoPlaca.removeAllItems();
                cboOnibusAlteracaoPlaca.addItem("Selecione");
                cboOnibusAlteracaoIdOculto.removeAllItems();
                cboOnibusAlteracaoIdOculto.addItem("Selecione");
                for (int i = 0; i < aux2.size(); i++) {
                    cboOnibusAlteracaoIdOculto.addItem(aux2.get(i).getOnibusId());
                    cboOnibusAlteracaoPlaca.addItem(aux2.get(i).getOnibusPlaca());
                }
                break;
            case 3: //remocao
                ArrayList<Onibus> aux3 = daoOnibus.consultarTodosOnibus();
                cboOnibusRemocaoPlaca.removeAllItems();
                cboOnibusRemocaoPlaca.addItem("Selecione");
                cboOnibusRemocaoIdOculto.removeAllItems();
                cboOnibusRemocaoIdOculto.addItem("Selecione");

                for (int i = 0; i < aux3.size(); i++) {
                    cboOnibusRemocaoPlaca.addItem(aux3.get(i).getOnibusPlaca());
                    cboOnibusRemocaoIdOculto.addItem(aux3.get(i).getOnibusId());
                }
                break;
        }
    }




    
    //------- Geral
    private Font fontePadrao;
    private GridLayout gridLayout3_1;
    private FlowLayout layoutLeft;
    private FlowLayout layoutRight;
    private DaoOnibus daoOnibus;
    private Onibus onibus;
    private MaskFormatter mascaraPlaca;
    private MaskFormatter mascaraAno;
    private MaskFormatter mascaraQtdeAssentos;
    private JPanel pnlOnibus;
    //------- Onibus
    private JPanel pnlOnibusCadastro;
    private JPanel pnlOnibusAlteracao;
    private JPanel pnlOnibusRemocao;
    private JPanel pnlOnibusCadastroBotao;
    private JPanel pnlOnibusAlteracaoBotao;
    private JPanel pnlOnibusRemocaoBotao;
    //cadastro
    private JLabel lblOnibusCadastroPlaca;
    private JLabel lblOnibusCadastroModelo;
    private JLabel lblOnibusCadastroMarca;
    private JLabel lblOnibusCadastroAno;
    private JLabel lblOnibusCadastroQtdeAssentos;
    private JButton btnOnibusCadastrar;
    private JButton btnOnibusCadastroLimpa;
    private JFormattedTextField txtOnibusCadastroPlaca;
    private JTextField txtOnibusCadastroModelo;
    private JTextField txtOnibusCadastroMarca;
    private JFormattedTextField txtOnibusCadastroAno;
    private JFormattedTextField txtOnibusCadastroQtdeAssentos;
    //alteracao
    private JComboBox cboOnibusAlteracaoPlaca;
    private JComboBox cboOnibusAlteracaoIdOculto;
    private JLabel lblOnibusAlteracaoPlaca;
    private JLabel lblOnibusAlteracaoPlacaNova;
    private JLabel lblOnibusAlteracaoModelo;
    private JLabel lblOnibusAlteracaoMarca;
    private JLabel lblOnibusAlteracaoAno;
    private JLabel lblOnibusAlteracaoQtdeAssentos;
    private JButton btnOnibusAlterar;
    private JFormattedTextField txtOnibusAlteracaoPlaca;
    private JTextField txtOnibusAlteracaoModelo;
    private JTextField txtOnibusAlteracaoMarca;
    private JFormattedTextField txtOnibusAlteracaoAno;
    private JFormattedTextField txtOnibusAlteracaoQtdeAssentos;
    //remocao
    private JLabel lblOnibusRemocaoPlaca;
    private JLabel lblOnibusRemocaoModelo;
    private JLabel lblOnibusRemocaoMarca;
    private JLabel lblOnibusRemocaoAno;
    private JLabel lblOnibusRemocaoQtdeAssentos;
    private JButton btnOnibusRemover;
    private JComboBox cboOnibusRemocaoPlaca;
    private JComboBox cboOnibusRemocaoIdOculto;
    private JLabel lblOnibusRemocaoModeloR;
    private JLabel lblOnibusRemocaoMarcaR;
    private JLabel lblOnibusRemocaoAnoR;
    private JLabel lblOnibusRemocaoQtdeAssentosR;
}
