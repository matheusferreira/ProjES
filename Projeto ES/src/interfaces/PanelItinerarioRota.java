package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import dao.DaoItinerario;
import dao.DaoRota;
import dao.DaoCidade;
import entidades.*;

public class PanelItinerarioRota extends JPanel {

    public JPanel inserirPnlRotaItinerario() {
        fontePadrao = new Font("Segoe UI", 1, 14);
        layoutRight = new FlowLayout(FlowLayout.RIGHT);
        layoutRight.setHgap(5);
        rota = new Rota();
        itinerario = new Itinerario();
        daoRota = new DaoRota();
        daoItinerario = new DaoItinerario();
        daoCidade = new DaoCidade();

        pnlRotaItinerario = new JPanel(layoutRight);
        pnlRotaItinerario.setVisible(false);
        pnlRotaItinerario.setBorder(BorderFactory.createTitledBorder(null, " ROTA / ITINERARIO ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlRotaItinerario.setBackground(new Color(240, 240, 240));

        inserePnlRota();
        inserePnlItinerario();

        pnlRotaItinerario.add(pnlRotaCadastro);
        pnlRotaItinerario.add(pnlItinerarioCadastro);
        pnlRotaItinerario.add(pnlRotaAlteracao);
        pnlRotaItinerario.add(pnlItinerarioAlteracao);
        pnlRotaItinerario.add(pnlRotaRemocao);
        pnlRotaItinerario.add(pnlItinerarioRemocao);

        carregaCombosCidade();
        carregaCombosRota();
        carregaCombosItinerario();
        carregaCombosHora();
        carregaCombosMinuto();

        return pnlRotaItinerario;
    }

    public void inserePnlRota() {
        /* Instacia dos Panel de Rota(Cadastro,Alterar,Remover)*/
        pnlRotaCadastro = new JPanel(layoutRight);
        pnlRotaAlteracao = new JPanel(layoutRight);
        pnlRotaRemocao = new JPanel(layoutRight);

        /* Formatação dos Panel de Rota(Cadastro,Alterar,Remover)*/
        pnlRotaCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Cadastro Rota ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlRotaAlteracao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Alteracao Rota ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlRotaRemocao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Remocao Rota ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));

        pnlRotaCadastro.setBackground(new Color(240, 240, 240));
        pnlRotaAlteracao.setBackground(new Color(240, 240, 240));
        pnlRotaRemocao.setBackground(new Color(240, 240, 240));

        pnlRotaCadastro.setPreferredSize(new Dimension(320, 180));
        pnlRotaAlteracao.setPreferredSize(new Dimension(320, 210));
        pnlRotaRemocao.setPreferredSize(new Dimension(320, 140));

        //Instancia de Lbl, TxtField, ComboBox - Cadastro
        JLabel lblAux = new JLabel("");
        lblRotaCadastroOrigem = new JLabel("Origem:");
        lblRotaCadastroDestino = new JLabel("Destino:");
        lblRotaCadastroDuracao = new JLabel("Duracao:");
        btnRotaCadastrar = new JButton("Cadastrar");
        btnRotaCadastroLimpa = new JButton("Limpar Campos");
        cboRotaCadastroOrigem = new JComboBox(new String[]{"Selecione"});
        cboRotaCadastroDestino = new JComboBox(new String[]{"Selecione"});
        txtRotaCadastroDuracao = new JTextField("", 19);
        cboRotaCadastroOrigemOculto = new JComboBox(new String[]{"Selecione"});
        cboRotaCadastroDestinoOculto = new JComboBox(new String[]{"Selecione"});
        cboRotaCadastroDuracaoHora = new JComboBox(new String[]{"-"});;
        cboRotaCadastroDuracaoMinuto = new JComboBox(new String[]{"-"});;

        /* Determinar tamanho do Lbl, TxtField, ComboBox - Cadastro */
        lblAux.setPreferredSize(new Dimension(110, 30));
        lblRotaCadastroOrigem.setPreferredSize(new Dimension(70, 30));
        lblRotaCadastroDestino.setPreferredSize(new Dimension(70, 30));
        lblRotaCadastroDuracao.setPreferredSize(new Dimension(70, 30));
        btnRotaCadastrar.setPreferredSize(new Dimension(100, 32));
        btnRotaCadastroLimpa.setPreferredSize(new Dimension(125, 32));
        cboRotaCadastroOrigem.setPreferredSize(new Dimension(222, 30));
        cboRotaCadastroDestino.setPreferredSize(new Dimension(222, 30));
        cboRotaCadastroDuracaoHora.setPreferredSize(new Dimension(50, 30));
        cboRotaCadastroDuracaoMinuto.setPreferredSize(new Dimension(50, 30));

        /* Inserir no Panel os Lbl, TxtField, ComboBox - Cadastro */
        pnlRotaCadastro.add(lblRotaCadastroOrigem);
        pnlRotaCadastro.add(cboRotaCadastroOrigem);
        pnlRotaCadastro.add(lblRotaCadastroDestino);
        pnlRotaCadastro.add(cboRotaCadastroDestino);
        pnlRotaCadastro.add(lblRotaCadastroDuracao);
        pnlRotaCadastro.add(cboRotaCadastroDuracaoHora);
        pnlRotaCadastro.add(cboRotaCadastroDuracaoMinuto);
        pnlRotaCadastro.add(lblAux);
        pnlRotaCadastro.add(btnRotaCadastroLimpa);
        pnlRotaCadastro.add(btnRotaCadastrar);

        //Instancia de Lbl, TxtField, ComboBox - Alteracao
        JLabel lblAux2 = new JLabel("");
        lblRotaAlteracaoDuracao = new JLabel("Duracao:");
        lblRotaAlteracaoOrigem = new JLabel("Origem:");
        lblRotaAlteracaoRota = new JLabel("Rota:");
        lblRotaAlteracaoDestino = new JLabel("Destino:");
        btnRotaAlterar = new JButton("Alterar");
        cboRotaAlteracaoIdRota = new JComboBox(new String[]{"Selecione"});
        cboRotaAlteracaoIdRotaOculto = new JComboBox(new String[]{"Selecione"});
        cboRotaAlteracaoOrigem = new JComboBox(new String[]{"Selecione"});
        cboRotaAlteracaoDestino = new JComboBox(new String[]{"Selecione"});
        cboRotaAlteracaoOrigemOculto = new JComboBox(new String[]{"Selecione"});
        cboRotaAlteracaoDestinoOculto = new JComboBox(new String[]{"Selecione"});
        cboRotaAlteracaoDuracaoHora = new JComboBox(new String[]{"-"});
        cboRotaAlteracaoDuracaoMinuto = new JComboBox(new String[]{"-"});

        /* Determinar tamanho do Lbl, TxtField, ComboBox - Alterar */
        lblAux2.setPreferredSize(new Dimension(110, 30));
        lblRotaAlteracaoDuracao.setPreferredSize(new Dimension(70, 30));
        btnRotaAlterar.setPreferredSize(new Dimension(100, 32));
        cboRotaAlteracaoIdRota.setPreferredSize(new Dimension(222, 30));
        cboRotaAlteracaoOrigem.setPreferredSize(new Dimension(222, 30));
        cboRotaAlteracaoDestino.setPreferredSize(new Dimension(222, 30));
        lblRotaAlteracaoOrigem.setPreferredSize(new Dimension(70, 30));
        lblRotaAlteracaoRota.setPreferredSize(new Dimension(70, 30));
        lblRotaAlteracaoDestino.setPreferredSize(new Dimension(70, 30));
        cboRotaAlteracaoDuracaoHora.setPreferredSize(new Dimension(50, 30));
        cboRotaAlteracaoDuracaoMinuto.setPreferredSize(new Dimension(50, 30));

        /* Inserir no Panel os Lbl, TxtField, ComboBox - Alterar */
        cboRotaAlteracaoIdRotaOculto.setVisible(false);
        pnlRotaAlteracao.add(lblRotaAlteracaoRota);
        pnlRotaAlteracao.add(cboRotaAlteracaoIdRota);
        pnlRotaAlteracao.add(lblRotaAlteracaoOrigem);
        pnlRotaAlteracao.add(cboRotaAlteracaoOrigem);
        pnlRotaAlteracao.add(lblRotaAlteracaoDestino);
        pnlRotaAlteracao.add(cboRotaAlteracaoDestino);
        pnlRotaAlteracao.add(lblRotaAlteracaoDuracao);
        pnlRotaAlteracao.add(cboRotaAlteracaoDuracaoHora);
        pnlRotaAlteracao.add(cboRotaAlteracaoDuracaoMinuto);
        pnlRotaAlteracao.add(lblAux2);
        pnlRotaAlteracao.add(btnRotaAlterar);

        //Instancia de Lbl, TxtField, ComboBox - Remoção
        lblRotaRemocaoOrigemDestino = new JLabel("Rota:");
        lblRotaRemocaoDuracao = new JLabel("Duracao:");
        cboRotaRemocaoIdRota = new JComboBox(new String[]{"Selecione"});
        cboRotaRemocaoIdRotaOculto = new JComboBox(new String[]{"Selecione"});
        lblRotaRemocaoDuracaoR = new JLabel();
        btnRotaRemover = new JButton("Remover");

        /* Determinar tamanho do Lbl, TxtField, ComboBox - Remover */
        cboRotaRemocaoIdRota.setPreferredSize(new Dimension(222, 30));
        lblRotaRemocaoOrigemDestino.setPreferredSize(new Dimension(70, 30));
        lblRotaRemocaoDuracao.setPreferredSize(new Dimension(70, 30));
        lblRotaRemocaoDuracaoR.setPreferredSize(new Dimension(222, 30));
        btnRotaRemover.setPreferredSize(new Dimension(100, 32));

        /* Inserir no Panel os Lbl, TxtField, ComboBox - Remover */
        cboRotaRemocaoIdRotaOculto.setVisible(false);
        pnlRotaRemocao.add(lblRotaRemocaoOrigemDestino);
        pnlRotaRemocao.add(cboRotaRemocaoIdRota);
        pnlRotaRemocao.add(lblRotaRemocaoDuracao);
        pnlRotaRemocao.add(lblRotaRemocaoDuracaoR);
        pnlRotaRemocao.add(btnRotaRemover);

        /* Rota */
        
                /* Cadastro */
        
        btnRotaCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboRotaCadastroOrigem.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Origem.");
                    cboRotaCadastroOrigem.requestFocus();
                } else if (cboRotaCadastroDestino.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Destino.");
                    cboRotaCadastroDestino.requestFocus();
                } else if (cboRotaCadastroDuracaoHora.getSelectedItem().equals("-")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma hora.");
                    cboRotaCadastroDuracaoHora.requestFocus();
                } else if (cboRotaCadastroDuracaoMinuto.getSelectedItem().equals("-")) {
                    JOptionPane.showMessageDialog(null, "Selecione os minutos.");
                    cboRotaCadastroDuracaoMinuto.requestFocus();
                } else {
                    int hora, total;
                    hora = (Integer.parseInt(String.valueOf(cboRotaCadastroDuracaoHora.getSelectedItem())) * 60);
                    total = hora + Integer.parseInt(String.valueOf(cboRotaCadastroDuracaoMinuto.getSelectedItem()));
                    rota.setRotaDuracao(String.valueOf(total));
                    rota.setRota_cidadeOrigemId(Integer.parseInt(String.valueOf(cboRotaCadastroOrigemOculto.getSelectedItem())));
                    rota.setRota_cidadeDestinoId(Integer.parseInt(String.valueOf(cboRotaCadastroDestinoOculto.getSelectedItem())));

                    int verifica = daoRota.cadastrarRota(rota);
                    if (verifica == 0) {
                        JOptionPane.showMessageDialog(null, "Rota cadastrada com sucesso!");
                        cboRotaCadastroOrigem.setSelectedItem("Selecione");
                        cboRotaCadastroDestino.setSelectedItem("Selecione");
                        carregaCombosCidade();
                        carregaCombosRota();
                        carregaCombosHora();
                        carregaCombosMinuto();
                        cboRotaCadastroOrigem.requestFocus();
                    } else if (verifica == 1) {
                        JOptionPane.showMessageDialog(null, "Rota ja existente.");
                        cboRotaCadastroOrigem.setSelectedItem("Selecione");
                        cboRotaCadastroOrigem.requestFocus();
                        cboRotaCadastroDestino.setSelectedItem("Selecione");
                    } else if (verifica == 2) {
                        JOptionPane.showMessageDialog(null, "Selecione um Destino diferente da Origem.");
                        cboRotaCadastroDestino.setSelectedItem("Selecione");
                        cboRotaCadastroDestino.requestFocus();
                    }
                }
            }
        });

        btnRotaCadastroLimpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                txtRotaCadastroDuracao.setText("");
                cboRotaCadastroOrigem.setSelectedItem("Selecione");
                cboRotaCadastroOrigemOculto.setSelectedItem("Selecione");
                cboRotaCadastroDestino.setSelectedItem("Selecione");
                cboRotaCadastroDestinoOculto.setSelectedItem("Selecione");
                cboRotaCadastroOrigem.requestFocus();
            }
        });

        cboRotaCadastroOrigem.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboRotaCadastroOrigem.getSelectedItem().equals("Selecione"))) {
                        cboRotaCadastroOrigemOculto.setSelectedIndex(cboRotaCadastroOrigem.getSelectedIndex());
                    } else {
                        txtRotaCadastroDuracao.setText("");
                        cboRotaCadastroOrigem.setSelectedItem("Selecione");
                        cboRotaCadastroDestino.setSelectedItem("Selecione");
                    }
                }
            }
        });
        
        cboRotaCadastroDestino.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboRotaCadastroDestino.getSelectedItem().equals("Selecione"))) {
                        cboRotaCadastroDestinoOculto.setSelectedIndex(cboRotaCadastroDestino.getSelectedIndex());
                    } else {
                        txtRotaCadastroDuracao.setText("");
                        cboRotaCadastroOrigem.setSelectedItem("Selecione");
                        cboRotaCadastroDestino.setSelectedItem("Selecione");
                    }
                }
            }
        });
        
                
                /* Alteracao */
        
        btnRotaAlterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboRotaAlteracaoIdRota.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Rota.");
                    cboRotaAlteracaoIdRota.requestFocus();
                } else if (cboRotaAlteracaoOrigem.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Origem.");
                    cboRotaAlteracaoOrigem.requestFocus();
                } else if (cboRotaAlteracaoDestino.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Destino.");
                    cboRotaAlteracaoDestino.requestFocus();
                } else if (cboRotaAlteracaoDuracaoHora.getSelectedItem().equals("-") || cboRotaAlteracaoDuracaoMinuto.getSelectedItem().equals("-")) {
                    JOptionPane.showMessageDialog(null, "Selecione a Duracao da Rota.");
                    cboRotaAlteracaoDuracaoHora.requestFocus();
                } else {
                    rota.setRotaId(Integer.parseInt(String.valueOf(cboRotaAlteracaoIdRotaOculto.getSelectedItem())));
                    int horaEmMinutos = Integer.parseInt(String.valueOf(cboRotaAlteracaoDuracaoHora.getSelectedItem())) * 60;
                    int minuto = Integer.parseInt(String.valueOf(cboRotaAlteracaoDuracaoMinuto.getSelectedItem()));
                    rota.setRotaDuracao(String.valueOf(horaEmMinutos + minuto));
                    rota.setRota_cidadeOrigemId(Integer.parseInt(String.valueOf(cboRotaAlteracaoOrigemOculto.getSelectedItem())));
                    rota.setRota_cidadeDestinoId(Integer.parseInt(String.valueOf(cboRotaAlteracaoDestinoOculto.getSelectedItem())));
                    int verifica = daoRota.alterarRota(rota);
                    if (verifica == 0) {
                        JOptionPane.showMessageDialog(null, "Rota alterada com sucesso!");
                    } else if (verifica == 1) {
                        JOptionPane.showMessageDialog(null, "Rota ja existente!");
                    } else if (verifica == 2) {
                        JOptionPane.showMessageDialog(null, "Nao foi possivel alterar essa Rota pois ela pertence a um itinerario!");
                    } else if (verifica == 3) {
                        JOptionPane.showMessageDialog(null, "Selecione um Destino diferente da Origem!");
                    }
                    carregaCombosCidade();
                    carregaCombosRota();
                    carregaCombosHora();
                    carregaCombosMinuto();
                    cboRotaAlteracaoIdRota.setSelectedItem("Selecione");
                    cboRotaAlteracaoIdRotaOculto.setSelectedItem("Selecione");
                    cboRotaAlteracaoOrigem.setSelectedItem("Selecione");
                    cboRotaAlteracaoOrigemOculto.setSelectedItem("Selecione");
                    cboRotaAlteracaoDestino.setSelectedItem("Selecione");
                    cboRotaAlteracaoDestinoOculto.setSelectedItem("Selecione");
                    cboRotaAlteracaoIdRota.requestFocus();
                }
            }
        });

        cboRotaAlteracaoIdRota.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboRotaAlteracaoIdRota.getSelectedItem().equals("Selecione"))) {
                        cboRotaAlteracaoIdRotaOculto.setSelectedIndex(cboRotaAlteracaoIdRota.getSelectedIndex());
                        rota.setRotaId(Integer.parseInt(String.valueOf(cboRotaAlteracaoIdRotaOculto.getSelectedItem())));
                        Rota aux = daoRota.consultaRota(rota);
                        int hora, minuto;
                        hora = (Integer.parseInt(aux.getRotaDuracao()) / 60);
                        minuto = Integer.parseInt(aux.getRotaDuracao()) - (hora * 60);
                        cboRotaAlteracaoDuracaoHora.setSelectedItem(hora);
                        cboRotaAlteracaoDuracaoMinuto.setSelectedItem(minuto);
                        cboRotaAlteracaoOrigemOculto.setSelectedItem(aux.getRota_cidadeOrigemId());
                        cboRotaAlteracaoDestinoOculto.setSelectedItem(aux.getRota_cidadeDestinoId());
                        cboRotaAlteracaoOrigem.setSelectedIndex(cboRotaAlteracaoOrigemOculto.getSelectedIndex());
                        cboRotaAlteracaoDestino.setSelectedIndex(cboRotaAlteracaoDestinoOculto.getSelectedIndex());
                    } else {
                        cboRotaAlteracaoDuracaoHora.setSelectedItem("-");
                        cboRotaAlteracaoDuracaoMinuto.setSelectedItem("-");
                        cboRotaAlteracaoOrigem.setSelectedItem("Selecione");
                        cboRotaAlteracaoDestino.setSelectedItem("Selecione");
                        cboRotaAlteracaoOrigemOculto.setSelectedItem("Selecione");
                        cboRotaAlteracaoDestinoOculto.setSelectedItem("Selecione");
                    }
                }
            }
        });

        cboRotaAlteracaoOrigem.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboRotaAlteracaoOrigem.getSelectedItem().equals("Selecione"))) {
                        cboRotaAlteracaoOrigemOculto.setSelectedIndex(cboRotaAlteracaoOrigem.getSelectedIndex());
                    }
                }
            }
        });

        cboRotaAlteracaoDestino.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboRotaAlteracaoDestino.getSelectedItem().equals("Selecione"))) {
                        cboRotaAlteracaoDestinoOculto.setSelectedIndex(cboRotaAlteracaoDestino.getSelectedIndex());
                    }
                }
            }
        });

                /* Remocao */
        btnRotaRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int confirma = 0;
                if (cboRotaRemocaoIdRota.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Rota para remover.");
                    cboRotaRemocaoIdRota.requestFocus();
                } else {
                    confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?");
                    if (confirma == JOptionPane.YES_OPTION) {
                        rota.setRotaId(Integer.parseInt(String.valueOf(cboRotaRemocaoIdRotaOculto.getSelectedItem())));
                        boolean verifica = daoRota.removerRota(rota);
                        if (verifica) {
                            JOptionPane.showMessageDialog(null, "Rota removida com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nao foi possivel remover Rota. Ela esta sendo usada por algum Itinerario.");
                        }
                        cboRotaRemocaoIdRota.setSelectedItem("Selecione");
                        cboRotaRemocaoIdRotaOculto.setSelectedItem("Selecione");
                        lblRotaRemocaoDuracaoR.setText("");
                        cboRotaRemocaoIdRota.requestFocus();
                    } else {
                        cboRotaRemocaoIdRota.setSelectedItem("Selecione");
                        cboRotaRemocaoIdRotaOculto.setSelectedItem("Selecione");
                        lblRotaRemocaoDuracaoR.setText("");
                        cboRotaRemocaoIdRota.requestFocus();
                    }
                    carregaCombosCidade();
                    carregaCombosRota();
                }
            }
        });
        
        cboRotaRemocaoIdRota.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboRotaRemocaoIdRota.getSelectedItem().equals("Selecione"))) {
                        cboRotaRemocaoIdRotaOculto.setSelectedIndex(cboRotaRemocaoIdRota.getSelectedIndex());
                        rota.setRotaId(Integer.parseInt(String.valueOf(cboRotaRemocaoIdRotaOculto.getSelectedItem())));
                        rota = daoRota.consultaRota(rota);
                        lblRotaRemocaoDuracaoR.setText(rota.getRotaDuracao());
                    } else {
                        cboRotaRemocaoIdRotaOculto.setSelectedIndex(cboRotaRemocaoIdRota.getSelectedIndex());
                        lblRotaRemocaoDuracaoR.setText("");
                    }
                }
            }
        });

    }

    public void inserePnlItinerario() {
        pnlItinerarioCadastro = new JPanel(layoutRight);
        pnlItinerarioAlteracao = new JPanel(layoutRight);
        pnlItinerarioRemocao = new JPanel(layoutRight);

        pnlItinerarioCadastro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Cadastro Itinerario ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlItinerarioAlteracao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Alteracao Itinerario ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlItinerarioRemocao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)), " Remocao Itinerario ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));

        pnlItinerarioCadastro.setBackground(new Color(240, 240, 240));
        pnlItinerarioAlteracao.setBackground(new Color(240, 240, 240));
        pnlItinerarioRemocao.setBackground(new Color(240, 240, 240));

        pnlItinerarioCadastro.setPreferredSize(new Dimension(320, 180));
        pnlItinerarioAlteracao.setPreferredSize(new Dimension(320, 210));
        pnlItinerarioRemocao.setPreferredSize(new Dimension(320, 140));

        //cadastro
        JLabel lblItinerarioCadatroAux = new JLabel("");
        lblItinerarioCadastroOrigem = new JLabel("Origem:");
        lblItinerarioCadastroDestino = new JLabel("Destino:");
        btnItinerarioCadastrar = new JButton("Cadastrar");
        btnItinerarioCadastroLimpa = new JButton("Limpar Campos");
        cboItinerarioCadastroOrigem = new JComboBox(new String[]{"Selecione"});
        cboItinerarioCadastroDestino = new JComboBox(new String[]{"Selecione"});

        lblItinerarioCadastroOrigem.setPreferredSize(new Dimension(70, 30));
        lblItinerarioCadastroDestino.setPreferredSize(new Dimension(70, 30));
        btnItinerarioCadastrar.setPreferredSize(new Dimension(100, 32));
        btnItinerarioCadastroLimpa.setPreferredSize(new Dimension(125, 32));
        cboItinerarioCadastroOrigem.setPreferredSize(new Dimension(222, 30));
        cboItinerarioCadastroDestino.setPreferredSize(new Dimension(222, 30));
        lblItinerarioCadatroAux.setPreferredSize(new Dimension(292, 30));


        pnlItinerarioCadastro.add(lblItinerarioCadastroOrigem);
        pnlItinerarioCadastro.add(cboItinerarioCadastroOrigem);
        pnlItinerarioCadastro.add(lblItinerarioCadastroDestino);
        pnlItinerarioCadastro.add(cboItinerarioCadastroDestino);
        pnlItinerarioCadastro.add(lblItinerarioCadatroAux);
        pnlItinerarioCadastro.add(btnItinerarioCadastroLimpa);
        pnlItinerarioCadastro.add(btnItinerarioCadastrar);

        //alteracao
        JLabel lblItinerarioAlteracaoAux = new JLabel("");
        lblItinerarioAlteracaoOrigem = new JLabel("Origem:");
        lblItinerarioAlteracaoOrigemDestino = new JLabel("Itinerario:");
        lblItinerarioAlteracaoDestino = new JLabel("Destino:");
        btnItinerarioAlterar = new JButton("Alterar");
        cboItinerarioAlteracaoIdItinerario = new JComboBox(new String[]{"Selecione"});
        cboItinerarioAlteracaoOrigem = new JComboBox(new String[]{"Selecione"});
        cboItinerarioAlteracaoDestino = new JComboBox(new String[]{"Selecione"});

        btnItinerarioAlterar.setPreferredSize(new Dimension(100, 32));
        cboItinerarioAlteracaoIdItinerario.setPreferredSize(new Dimension(222, 30));
        cboItinerarioAlteracaoOrigem.setPreferredSize(new Dimension(222, 30));
        cboItinerarioAlteracaoDestino.setPreferredSize(new Dimension(222, 30));
        lblItinerarioAlteracaoAux.setPreferredSize(new Dimension(292, 30));
        lblItinerarioAlteracaoOrigem.setPreferredSize(new Dimension(70, 30));
        lblItinerarioAlteracaoOrigemDestino.setPreferredSize(new Dimension(70, 30));
        lblItinerarioAlteracaoDestino.setPreferredSize(new Dimension(70, 30));

        pnlItinerarioAlteracao.add(lblItinerarioAlteracaoOrigemDestino);
        pnlItinerarioAlteracao.add(cboItinerarioAlteracaoIdItinerario);
        pnlItinerarioAlteracao.add(lblItinerarioAlteracaoOrigem);
        pnlItinerarioAlteracao.add(cboItinerarioAlteracaoOrigem);
        pnlItinerarioAlteracao.add(lblItinerarioAlteracaoDestino);
        pnlItinerarioAlteracao.add(cboItinerarioAlteracaoDestino);
        pnlItinerarioAlteracao.add(lblItinerarioAlteracaoAux);
        pnlItinerarioAlteracao.add(btnItinerarioAlterar);

        //remocao
        lblItinerarioRemocaoOrigemDestino = new JLabel("Itinerario:");
        JLabel lblItinerarioRemocaoAux = new JLabel("");
        cboItinerarioRemocaoIdItinerario = new JComboBox(new String[]{"Selecione"});
        btnItinerarioRemover = new JButton("Remover");

        cboItinerarioRemocaoIdItinerario.setPreferredSize(new Dimension(222, 30));
        lblItinerarioRemocaoOrigemDestino.setPreferredSize(new Dimension(70, 30));
        lblItinerarioRemocaoAux.setPreferredSize(new Dimension(292, 30));

        btnItinerarioRemover.setPreferredSize(new Dimension(100, 32));

        pnlItinerarioRemocao.add(lblItinerarioRemocaoOrigemDestino);
        pnlItinerarioRemocao.add(cboItinerarioRemocaoIdItinerario);
        pnlItinerarioRemocao.add(lblItinerarioRemocaoAux);
        pnlItinerarioRemocao.add(btnItinerarioRemover);

        /* Cadastro */
        btnItinerarioCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboItinerarioCadastroOrigem.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Origem.");
                    cboItinerarioCadastroOrigem.requestFocus();
                } else if (cboItinerarioCadastroDestino.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Destino.");
                    cboItinerarioCadastroDestino.requestFocus();
                } else {
                    itinerario.setItinerario_cidadeOrigemId(arrayListCidade.get(cboItinerarioCadastroOrigem.getSelectedIndex() - 1).getCidadeId());
                    itinerario.setItinerario_cidadeDestinoId(arrayListCidade.get(cboItinerarioCadastroDestino.getSelectedIndex() - 1).getCidadeId());
                    int verifica = daoItinerario.cadastrarItinerario(itinerario);
                    if (verifica == 0) {
                        JOptionPane.showMessageDialog(null, "Itinerario cadastrado com sucesso!");
                        cboItinerarioCadastroOrigem.setSelectedItem("Selecione");
                        cboItinerarioCadastroDestino.setSelectedItem("Selecione");
                        carregaCombosCidade();
                        carregaCombosItinerario();
                        cboItinerarioCadastroOrigem.requestFocus();
                    } else if (verifica == 1) {
                        JOptionPane.showMessageDialog(null, "Selecione um Destino diferente da Origem.");
                        cboItinerarioCadastroOrigem.setSelectedItem("Selecione");
                        cboItinerarioCadastroDestino.setSelectedItem("Selecione");
                        cboItinerarioCadastroOrigem.requestFocus();
                    }
                }
            }
        });

        btnItinerarioCadastroLimpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                cboItinerarioCadastroOrigem.setSelectedItem("Selecione");
                cboItinerarioCadastroDestino.setSelectedItem("Selecione");
                cboItinerarioCadastroOrigem.requestFocus();
            }
        });

        cboItinerarioCadastroOrigem.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboItinerarioCadastroOrigem.getSelectedItem().equals("Selecione"))) {
                        //cboItinerarioCadastroOrigemOculto.setSelectedIndex(cboItinerarioCadastroOrigem.getSelectedIndex());
                    } else {
                        cboItinerarioCadastroOrigem.setSelectedItem("Selecione");
                        cboItinerarioCadastroDestino.setSelectedItem("Selecione");
                    }
                }
            }
        });

        cboItinerarioCadastroDestino.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboItinerarioCadastroDestino.getSelectedItem().equals("Selecione"))) {
                        //cboItinerarioCadastroDestinoOculto.setSelectedIndex(cboItinerarioCadastroDestino.getSelectedIndex());
                    } else {
                        cboItinerarioCadastroOrigem.setSelectedItem("Selecione");
                        cboItinerarioCadastroDestino.setSelectedItem("Selecione");
                    }
                }
            }
        });

        /* Alteração */
        btnItinerarioAlterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboItinerarioAlteracaoIdItinerario.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Itiner�rio.");
                    cboItinerarioAlteracaoIdItinerario.requestFocus();
                } else if (cboItinerarioAlteracaoOrigem.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione uma Origem.");
                    cboItinerarioAlteracaoOrigem.requestFocus();
                } else if (cboItinerarioAlteracaoDestino.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Destino.");
                    cboItinerarioAlteracaoDestino.requestFocus();
                } else {
                    itinerario.setItinerarioId(arraylistItinerarios.get(cboItinerarioAlteracaoIdItinerario.getSelectedIndex() - 1).getItinerarioId());
                    itinerario.setItinerario_cidadeOrigemId(arrayListCidade.get(cboItinerarioAlteracaoOrigem.getSelectedIndex() - 1).getCidadeId());
                    itinerario.setItinerario_cidadeDestinoId(arrayListCidade.get(cboItinerarioAlteracaoDestino.getSelectedIndex() - 1).getCidadeId());
                    int verifica = daoItinerario.alterarItinerario(itinerario);
                    if (verifica == 0) {
                        JOptionPane.showMessageDialog(null, "Itinerario alterado com sucesso!");
                    } else if (verifica == 1) {
                        JOptionPane.showMessageDialog(null, "Nao foi possivel alterar esse Itinerario pois ela pertence a uma viagem!");
                    } else if (verifica == 2) {
                        JOptionPane.showMessageDialog(null, "Selecione um  Destino diferente da Origem!");
                    }
                    carregaCombosCidade();
                    carregaCombosItinerario();
                    cboItinerarioAlteracaoIdItinerario.setSelectedItem("Selecione");
                    cboItinerarioAlteracaoOrigem.setSelectedItem("Selecione");
                    cboItinerarioAlteracaoDestino.setSelectedItem("Selecione");
                    cboItinerarioAlteracaoIdItinerario.requestFocus();
                }
            }
        });

        cboItinerarioAlteracaoIdItinerario.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboItinerarioAlteracaoIdItinerario.getSelectedItem().equals("Selecione"))) {
                        itinerario.setItinerarioId(arraylistItinerarios.get(cboItinerarioAlteracaoIdItinerario.getSelectedIndex() - 1).getItinerarioId());
                        Itinerario alterarItinerario = daoItinerario.consultaItinerario(itinerario);
                        for (int i = 0; i < arrayListCidade.size(); i++) {
                            if (alterarItinerario.getItinerario_cidadeOrigemId() == arrayListCidade.get(i).getCidadeId()) {
                                cboItinerarioAlteracaoOrigem.setSelectedIndex(i + 1);
                            }
                        }
                        for (int i = 0; i < arrayListCidade.size(); i++) {
                            if (alterarItinerario.getItinerario_cidadeDestinoId() == arrayListCidade.get(i).getCidadeId()) {
                                cboItinerarioAlteracaoDestino.setSelectedIndex(i + 1);
                            }
                        }
                    } else {
                        cboItinerarioAlteracaoOrigem.setSelectedItem("Selecione");
                        cboItinerarioAlteracaoDestino.setSelectedItem("Selecione");
                    }
                }
            }
        });

        /* Remover */
        btnItinerarioRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int confirma = 0;
                if (cboItinerarioRemocaoIdItinerario.getSelectedItem().equals("Selecione")) {
                    JOptionPane.showMessageDialog(null, "Selecione um Itinerario para remover.");
                    cboItinerarioRemocaoIdItinerario.requestFocus();
                } else {
                    confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o registro?");
                    if (confirma == JOptionPane.YES_OPTION) {
                        itinerario.setItinerarioId(arraylistItinerarios.get(cboItinerarioRemocaoIdItinerario.getSelectedIndex() - 1).getItinerarioId());
                        boolean verifica = daoItinerario.removerItinerario(itinerario);
                        if (verifica) {
                            JOptionPane.showMessageDialog(null, "Itinerario removido com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nao foi possivel remover o itinerario. Ele pertence a uma viagem.");
                        }
                        cboItinerarioRemocaoIdItinerario.setSelectedItem("Selecione");
                        cboItinerarioRemocaoIdItinerario.requestFocus();
                    } else {
                        cboItinerarioRemocaoIdItinerario.setSelectedItem("Selecione");
                        cboItinerarioRemocaoIdItinerario.requestFocus();
                    }
                    carregaCombosCidade();
                    carregaCombosItinerario();
                }
            }
        });

        cboItinerarioRemocaoIdItinerario.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboItinerarioRemocaoIdItinerario.getSelectedItem().equals("Selecione"))) {
                        itinerario.setItinerarioId(arraylistItinerarios.get(cboItinerarioRemocaoIdItinerario.getSelectedIndex() - 1).getItinerarioId());
                        itinerario = daoItinerario.consultaItinerario(itinerario);
                    }
                }
            }
        });
    }

    public void focusTxtPrincipal() {
        cboRotaCadastroOrigem.requestFocus();
    }

    public void carregaCombosHora() {

        //Cadastro
        cboRotaCadastroDuracaoHora.removeAllItems();
        cboRotaCadastroDuracaoHora.addItem("-");

        /* Alteracao*/
        cboRotaAlteracaoDuracaoHora.removeAllItems();
        cboRotaAlteracaoDuracaoHora.addItem("-");

        for (int i = 0; i < 24; i++) {
            /* Cadastro */
            cboRotaCadastroDuracaoHora.addItem(i);
            /* ALterar */
            cboRotaAlteracaoDuracaoHora.addItem(i);
        }

    }

    public void carregaCombosMinuto() {
        //cadastro
        cboRotaCadastroDuracaoMinuto.removeAllItems();
        cboRotaCadastroDuracaoMinuto.addItem("-");

        /*alteracao */
        cboRotaAlteracaoDuracaoMinuto.removeAllItems();
        cboRotaAlteracaoDuracaoMinuto.addItem("-");


        for (int i = 0; i < 60; i+=5) {
            /* Cadastro */
            cboRotaCadastroDuracaoMinuto.addItem(i);
            /* ALterar */
            cboRotaAlteracaoDuracaoMinuto.addItem(i);
        }
    }

    public void carregaCombosCidade() {
        arrayListCidade = new ArrayList<Cidade>();
        arrayListCidade = daoCidade.consultarTodasCidades();
        for (int j = 0; j < arrayListCidade.size(); j++) {
            System.out.println(arrayListCidade.get(j).getCidadeId() + " Cidade:" + arrayListCidade.get(j).getCidadeNome());
        }
        cont++;
        System.out.println(cont + "\n");

        /* Rota */

        //cadastro
        cboRotaCadastroOrigem.removeAllItems();
        cboRotaCadastroOrigem.addItem("Selecione");
        cboRotaCadastroDestino.removeAllItems();
        cboRotaCadastroDestino.addItem("Selecione");
        cboRotaCadastroOrigemOculto.removeAllItems();
        cboRotaCadastroOrigemOculto.addItem("Selecione");
        cboRotaCadastroDestinoOculto.removeAllItems();
        cboRotaCadastroDestinoOculto.addItem("Selecione");

        //alteracao
        cboRotaAlteracaoOrigem.removeAllItems();
        cboRotaAlteracaoOrigem.addItem("Selecione");
        cboRotaAlteracaoDestino.removeAllItems();
        cboRotaAlteracaoDestino.addItem("Selecione");
        cboRotaAlteracaoOrigemOculto.removeAllItems();
        cboRotaAlteracaoOrigemOculto.addItem("Selecione");
        cboRotaAlteracaoDestinoOculto.removeAllItems();
        cboRotaAlteracaoDestinoOculto.addItem("Selecione");

        /* Itinerario */

        //cadastro
        cboItinerarioCadastroOrigem.removeAllItems();
        cboItinerarioCadastroOrigem.addItem("Selecione");
        cboItinerarioCadastroDestino.removeAllItems();
        cboItinerarioCadastroDestino.addItem("Selecione");

        //alteracao
        cboItinerarioAlteracaoOrigem.removeAllItems();
        cboItinerarioAlteracaoOrigem.addItem("Selecione");
        cboItinerarioAlteracaoDestino.removeAllItems();
        cboItinerarioAlteracaoDestino.addItem("Selecione");

        for (int i = 0; i < arrayListCidade.size(); i++) {
            /* Rota */
            cboRotaCadastroOrigem.addItem(arrayListCidade.get(i).getCidadeNome());
            cboRotaCadastroOrigemOculto.addItem(arrayListCidade.get(i).getCidadeId());
            cboRotaCadastroDestino.addItem(arrayListCidade.get(i).getCidadeNome());
            cboRotaCadastroDestinoOculto.addItem(arrayListCidade.get(i).getCidadeId());
            cboRotaAlteracaoOrigem.addItem(arrayListCidade.get(i).getCidadeNome());
            cboRotaAlteracaoDestino.addItem(arrayListCidade.get(i).getCidadeNome());
            cboRotaAlteracaoOrigemOculto.addItem(arrayListCidade.get(i).getCidadeId());
            cboRotaAlteracaoDestinoOculto.addItem(arrayListCidade.get(i).getCidadeId());

            /* Itinerario */
            cboItinerarioCadastroOrigem.addItem(arrayListCidade.get(i).getCidadeNome());
            cboItinerarioCadastroDestino.addItem(arrayListCidade.get(i).getCidadeNome());
            cboItinerarioAlteracaoOrigem.addItem(arrayListCidade.get(i).getCidadeNome());
            cboItinerarioAlteracaoDestino.addItem(arrayListCidade.get(i).getCidadeNome());
        }

    }

    public void carregaCombosRota() {
        ArrayList<Rota> arraylistRotas = daoRota.consultarTodasRotas();
        //alteracao
        cboRotaAlteracaoIdRota.removeAllItems();
        cboRotaAlteracaoIdRota.addItem("Selecione");
        cboRotaAlteracaoIdRotaOculto.removeAllItems();
        cboRotaAlteracaoIdRotaOculto.addItem("Selecione");
        //remocao
        cboRotaRemocaoIdRota.removeAllItems();
        cboRotaRemocaoIdRota.addItem("Selecione");
        cboRotaRemocaoIdRotaOculto.removeAllItems();
        cboRotaRemocaoIdRotaOculto.addItem("Selecione");
        for (int i = 0; i < arraylistRotas.size(); i++) {
            cboRotaAlteracaoIdRota.addItem(arraylistRotas.get(i).getRota_cidadeOrigem() + " - " + arraylistRotas.get(i).getRota_cidadeDestino());
            cboRotaRemocaoIdRota.addItem(arraylistRotas.get(i).getRota_cidadeOrigem() + " - " + arraylistRotas.get(i).getRota_cidadeDestino());
            cboRotaAlteracaoIdRotaOculto.addItem(arraylistRotas.get(i).getRotaId());
            cboRotaRemocaoIdRotaOculto.addItem(arraylistRotas.get(i).getRotaId());
        }

    }

    public void carregaCombosItinerario() {
        arraylistItinerarios = new ArrayList<Itinerario>();
        arraylistItinerarios = daoItinerario.consultarTodosItinerarios();

        //alteracao
        cboItinerarioAlteracaoIdItinerario.removeAllItems();
        cboItinerarioAlteracaoIdItinerario.addItem("Selecione");
        //remocao
        cboItinerarioRemocaoIdItinerario.removeAllItems();
        cboItinerarioRemocaoIdItinerario.addItem("Selecione");
        for (int i = 0; i < arraylistItinerarios.size(); i++) {
            cboItinerarioAlteracaoIdItinerario.addItem(arraylistItinerarios.get(i).getItinerario_cidadeOrigem() + " - " + arraylistItinerarios.get(i).getItinerario_cidadeDestino());
            cboItinerarioRemocaoIdItinerario.addItem(arraylistItinerarios.get(i).getItinerario_cidadeOrigem() + " - " + arraylistItinerarios.get(i).getItinerario_cidadeDestino());
        }
    }

    //------- Geral
    int cont = 0;
    ArrayList<Cidade> arrayListCidade;
    private Font fontePadrao;
    private FlowLayout layoutRight;
    private Rota rota;
    private Itinerario itinerario;
    private DaoCidade daoCidade;
    private DaoRota daoRota;
    private DaoItinerario daoItinerario;
    private JPanel pnlRotaItinerario;
    //------- Rota
    private JPanel pnlRotaCadastro;
    private JPanel pnlRotaAlteracao;
    private JPanel pnlRotaRemocao;
    //cadastro
    private JLabel lblRotaCadastroOrigem;
    private JLabel lblRotaCadastroDestino;
    private JLabel lblRotaCadastroDuracao;
    private JButton btnRotaCadastrar;
    private JButton btnRotaCadastroLimpa;
    private JTextField txtRotaCadastroDuracao;
    private JComboBox cboRotaCadastroDuracaoHora;
    private JComboBox cboRotaCadastroDuracaoMinuto;
    private JComboBox cboRotaCadastroOrigem;
    private JComboBox cboRotaCadastroDestino;
    private JComboBox cboRotaCadastroOrigemOculto;
    private JComboBox cboRotaCadastroDestinoOculto;
    //alteracao
    private JComboBox cboRotaAlteracaoIdRota;
    private JComboBox cboRotaAlteracaoIdRotaOculto;
    private JComboBox cboRotaAlteracaoOrigem;
    private JComboBox cboRotaAlteracaoDestino;
    private JComboBox cboRotaAlteracaoOrigemOculto;
    private JComboBox cboRotaAlteracaoDestinoOculto;
    private JLabel lblRotaAlteracaoRota;
    private JLabel lblRotaAlteracaoOrigem;
    private JLabel lblRotaAlteracaoDestino;
    private JLabel lblRotaAlteracaoDuracao;
    private JButton btnRotaAlterar;
    private JComboBox cboRotaAlteracaoDuracaoHora;
    private JComboBox cboRotaAlteracaoDuracaoMinuto;
    //remocao
    private JComboBox cboRotaRemocaoIdRota;
    private JComboBox cboRotaRemocaoIdRotaOculto;
    private JLabel lblRotaRemocaoOrigemDestino;
    private JLabel lblRotaRemocaoDuracao;
    private JButton btnRotaRemover;
    private JLabel lblRotaRemocaoDuracaoR;
    //------- Itinerario
    ArrayList<Itinerario> arraylistItinerarios;
    private JPanel pnlItinerarioCadastro;
    private JPanel pnlItinerarioAlteracao;
    private JPanel pnlItinerarioRemocao;
    //cadastro
    private JLabel lblItinerarioCadastroOrigem;
    private JLabel lblItinerarioCadastroDestino;
    private JButton btnItinerarioCadastrar;
    private JButton btnItinerarioCadastroLimpa;
    private JComboBox cboItinerarioCadastroOrigem;
    private JComboBox cboItinerarioCadastroDestino;
    //alteracao
    private JComboBox cboItinerarioAlteracaoIdItinerario;
    private JComboBox cboItinerarioAlteracaoOrigem;
    private JComboBox cboItinerarioAlteracaoDestino;
    private JLabel lblItinerarioAlteracaoOrigemDestino;
    private JLabel lblItinerarioAlteracaoOrigem;
    private JLabel lblItinerarioAlteracaoDestino;
    private JButton btnItinerarioAlterar;
    //remocao
    private JComboBox cboItinerarioRemocaoIdItinerario;
    private JLabel lblItinerarioRemocaoOrigemDestino;
    private JButton btnItinerarioRemover;
}
