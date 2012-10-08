package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import dao.*;
import entidades.*;
import dao.DaoPassagem;
import entidades.Passagem;
import java.awt.BorderLayout;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PanelConsulta {

    public JPanel inserirPnlConsulta() {
        pnlConsulta = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        pnlConsulta.setVisible(false);
        fontePadrao = new Font("Segoe UI", 1, 14);
        pnlConsulta.setBorder(BorderFactory.createTitledBorder(null, " CONSULTAS ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlConsulta.setBackground(new Color(240, 240, 240));
        pnlConsulta.setVisible(false);
        daoCidade = new DaoCidade();
        daoEstado = new DaoEstado();
        daoMotorista = new DaoMotorista();
        daoRota = new DaoRota();
        daoItinerario = new DaoItinerario();
        daoItinerario = new DaoItinerario();
        daoPassagem = new DaoPassagem();
        daoRotaItinerario = new DaoRotaItinerario();

        daoHorario = new DaoHorario();
        daoOnibus = new DaoOnibus();
        motorista = new Motorista();
        onibus = new Onibus();
        passagem = new Passagem();

        pnlConsultaEscolha = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        pnlConsultaEscolha.setPreferredSize(new Dimension(500, 130));
        pnlConsultaEscolha.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), " O que deseja consultar? ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaEscolha.setBackground(new Color(240, 240, 240));

        grupoRadioBtnConsulta = new ButtonGroup();
        rBtnOnibus = new JRadioButton("Onibus");
        rBtnMotorista = new JRadioButton("Motorista");
        rBtnEstado = new JRadioButton("Estado");
        rBtnCidade = new JRadioButton("Cidade");

        rBtnRota = new JRadioButton("Rota");
        rBtnItinerario = new JRadioButton("Itinerario");
        rBtnHorario = new JRadioButton("Horarios Viagem");
        rBtnPassagem = new JRadioButton("Passagens Compradas");

        rBtnOnibus.setMnemonic(KeyEvent.VK_O);
        rBtnMotorista.setMnemonic(KeyEvent.VK_M);
        rBtnEstado.setMnemonic(KeyEvent.VK_E);
        rBtnCidade.setMnemonic(KeyEvent.VK_C);
        rBtnRota.setMnemonic(KeyEvent.VK_R);
        rBtnItinerario.setMnemonic(KeyEvent.VK_I);
        rBtnHorario.setMnemonic(KeyEvent.VK_H);
        rBtnPassagem.setMnemonic(KeyEvent.VK_P);
        rBtnRota.setSelected(true);

        pnlConsultaOnibus = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        pnlConsultaOnibus.setPreferredSize(new Dimension(600, 300));
        pnlConsultaOnibus.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaOnibus.setBackground(new Color(240, 240, 240));

        lblConsultaOnibusId = new JLabel("Selecione a identificacao do onibus que deseja consultar:");
        lblConsultaOnibusModelo = new JLabel("Modelo:");
        lblConsultaOnibusMarca = new JLabel("Marca:");
        lblConsultaOnibusAno = new JLabel("Ano:");
        lblConsultaOnibusQtdeAssentos = new JLabel("Quantidade de assentos:");
        cboConsultaOnibusPlaca = new JComboBox(new String[]{"Selecione"});
        cboConsultaOnibusIdOculto = new JComboBox(new String[]{"Selecione"});
        lblConsultaOnibusModeloR = new JLabel("");
        lblConsultaOnibusMarcaR = new JLabel("");
        lblConsultaOnibusAnoR = new JLabel("");
        lblConsultaOnibusQtdeAssentosR = new JLabel("");

        cboConsultaOnibusPlaca.setPreferredSize(new Dimension(200, 30));
        lblConsultaOnibusId.setPreferredSize(new Dimension(380, 30));
        lblConsultaOnibusModelo.setPreferredSize(new Dimension(50, 30));
        lblConsultaOnibusMarca.setPreferredSize(new Dimension(50, 30));
        lblConsultaOnibusAno.setPreferredSize(new Dimension(50, 30));
        lblConsultaOnibusQtdeAssentos.setPreferredSize(new Dimension(160, 30));
        lblConsultaOnibusModeloR.setPreferredSize(new Dimension(530, 30));
        lblConsultaOnibusMarcaR.setPreferredSize(new Dimension(530, 30));
        lblConsultaOnibusAnoR.setPreferredSize(new Dimension(530, 30));
        lblConsultaOnibusQtdeAssentosR.setPreferredSize(new Dimension(420, 30));

        cboConsultaOnibusIdOculto.setVisible(false);
        pnlConsultaOnibus.add(lblConsultaOnibusId);
        pnlConsultaOnibus.add(cboConsultaOnibusPlaca);
        pnlConsultaOnibus.add(lblConsultaOnibusModelo);
        pnlConsultaOnibus.add(lblConsultaOnibusModeloR);
        pnlConsultaOnibus.add(lblConsultaOnibusMarca);
        pnlConsultaOnibus.add(lblConsultaOnibusMarcaR);
        pnlConsultaOnibus.add(lblConsultaOnibusAno);
        pnlConsultaOnibus.add(lblConsultaOnibusAnoR);
        pnlConsultaOnibus.add(lblConsultaOnibusQtdeAssentos);
        pnlConsultaOnibus.add(lblConsultaOnibusQtdeAssentosR);

        pnlConsultaMotorista = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        pnlConsultaMotorista.setPreferredSize(new Dimension(600, 330));
        pnlConsultaMotorista.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaMotorista.setBackground(new Color(240, 240, 240));
        pnlConsultaMotorista.setVisible(false);

        lblConsultaMotoristaNome = new JLabel("Selecione o nome do motorista que deseja consultar:");
        lblConsultaMotoristaRg = new JLabel("RG:");
        lblConsultaMotoristaCpf = new JLabel("CPF:");
        lblConsultaMotoristaEmail = new JLabel("E-mail:");
        lblConsultaMotoristaEnd = new JLabel("Endereco:");
        lblConsultaMotoristaTel = new JLabel("Telefone:");
        cboConsultaMotoristaNome = new JComboBox(new String[]{"Selecione"});
        cboConsultaMotoristaIdOculto = new JComboBox(new String[]{"Selecione"});
        lblConsultaMotoristaRgR = new JLabel("");
        lblConsultaMotoristaCpfR = new JLabel("");
        lblConsultaMotoristaEmailR = new JLabel("");
        lblConsultaMotoristaEndR = new JLabel("");
        lblConsultaMotoristaTelR = new JLabel("");

        cboConsultaMotoristaNome.setPreferredSize(new Dimension(200, 30));
        lblConsultaMotoristaNome.setPreferredSize(new Dimension(350, 30));
        lblConsultaMotoristaRg.setPreferredSize(new Dimension(70, 30));
        lblConsultaMotoristaCpf.setPreferredSize(new Dimension(70, 30));
        lblConsultaMotoristaTel.setPreferredSize(new Dimension(70, 30));
        lblConsultaMotoristaEnd.setPreferredSize(new Dimension(70, 30));
        lblConsultaMotoristaEmail.setPreferredSize(new Dimension(70, 30));
        lblConsultaMotoristaEmailR.setPreferredSize(new Dimension(475, 30));
        lblConsultaMotoristaRgR.setPreferredSize(new Dimension(475, 30));
        lblConsultaMotoristaCpfR.setPreferredSize(new Dimension(475, 30));
        lblConsultaMotoristaTelR.setPreferredSize(new Dimension(475, 30));
        lblConsultaMotoristaEndR.setPreferredSize(new Dimension(475, 30));

        cboConsultaMotoristaIdOculto.setVisible(false);
        pnlConsultaMotorista.add(lblConsultaMotoristaNome);
        pnlConsultaMotorista.add(cboConsultaMotoristaNome);
        pnlConsultaMotorista.add(lblConsultaMotoristaRg);
        pnlConsultaMotorista.add(lblConsultaMotoristaRgR);
        pnlConsultaMotorista.add(lblConsultaMotoristaCpf);
        pnlConsultaMotorista.add(lblConsultaMotoristaCpfR);
        pnlConsultaMotorista.add(lblConsultaMotoristaEnd);
        pnlConsultaMotorista.add(lblConsultaMotoristaEndR);
        pnlConsultaMotorista.add(lblConsultaMotoristaTel);
        pnlConsultaMotorista.add(lblConsultaMotoristaTelR);
        pnlConsultaMotorista.add(lblConsultaMotoristaEmail);
        pnlConsultaMotorista.add(lblConsultaMotoristaEmailR);

        grupoRadioBtnConsulta.add(rBtnEstado);
        grupoRadioBtnConsulta.add(rBtnCidade);
        grupoRadioBtnConsulta.add(rBtnRota);
        grupoRadioBtnConsulta.add(rBtnItinerario);
        grupoRadioBtnConsulta.add(rBtnHorario);
        grupoRadioBtnConsulta.add(rBtnPassagem);
        grupoRadioBtnConsulta.add(rBtnOnibus);
        grupoRadioBtnConsulta.add(rBtnMotorista);

        pnlConsultaEscolha.add(rBtnRota);
        pnlConsultaEscolha.add(rBtnItinerario);
        pnlConsultaEscolha.add(rBtnHorario);
        pnlConsultaEscolha.add(rBtnEstado);
        pnlConsultaEscolha.add(rBtnCidade);
        pnlConsultaEscolha.add(rBtnPassagem);
        pnlConsultaEscolha.add(rBtnOnibus);
        pnlConsultaEscolha.add(rBtnMotorista);

        pnlConsultaCidade = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pnlConsultaCidade.setVisible(false);
        pnlConsultaCidade.setPreferredSize(new Dimension(600, 300));
        pnlConsultaCidade.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaCidade.setBackground(new Color(240, 240, 240));

        lblConsultaCidadeNome = new JLabel("As cidades cadastradas sao as seguintes:");
        listConsultaCidade = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblConsultaCidadeNome.setPreferredSize(new Dimension(550, 30));

        listConsultaCidade.setPreferredSize(new Dimension(150, acumuladorConsultaCidade * 21));
        sListConsultaCidade = new JScrollPane(listConsultaCidade);
        sListConsultaCidade.setPreferredSize(new Dimension(250, 210));

        pnlConsultaCidade.add(lblConsultaCidadeNome);
        pnlConsultaCidade.add(sListConsultaCidade);

        pnlConsultaEstado = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pnlConsultaEstado.setVisible(false);
        pnlConsultaEstado.setPreferredSize(new Dimension(600, 300));
        pnlConsultaEstado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaEstado.setBackground(new Color(240, 240, 240));

        lblConsultaEstadoNome = new JLabel("Os Estados cadastrados sao os seguintes:");
        listConsultaEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblConsultaEstadoNome.setPreferredSize(new Dimension(550, 30));

        pnlConsultaEstado.add(lblConsultaEstadoNome);

        listConsultaEstado.setPreferredSize(new Dimension(100, acumuladorConsultaEstado * 21));
        sListConsultaEstado = new JScrollPane(listConsultaEstado);
        sListConsultaEstado.setPreferredSize(new Dimension(250, 210));
        pnlConsultaEstado.add(sListConsultaEstado);

        pnlConsultaRota = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pnlConsultaRota.setVisible(false);
        pnlConsultaRota.setPreferredSize(new Dimension(600, 300));
        pnlConsultaRota.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaRota.setBackground(new Color(240, 240, 240));

        lblConsultaRotaNome = new JLabel("As rotas cadastradas sao as seguintes:");
        listConsultaRota = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblConsultaRotaNome.setPreferredSize(new Dimension(550, 30));

        pnlConsultaRota.add(lblConsultaRotaNome);

        listConsultaRota.setPreferredSize(new Dimension(290, acumuladorConsultaRota * 25));
        sListConsultaRota = new JScrollPane(listConsultaRota);
        sListConsultaRota.setPreferredSize(new Dimension(300, 210));
        pnlConsultaRota.add(sListConsultaRota);

        pnlConsultaItinerario = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pnlConsultaItinerario.setVisible(false);
        pnlConsultaItinerario.setPreferredSize(new Dimension(600, 300));
        pnlConsultaItinerario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaItinerario.setBackground(new Color(240, 240, 240));

        lblConsultaItinerarioNome = new JLabel("Os itinerarios cadastrados sao os seguintes:");
        listConsultaItinerario = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblConsultaItinerarioNome.setPreferredSize(new Dimension(550, 30));

        pnlConsultaItinerario.add(lblConsultaItinerarioNome);

        listConsultaItinerario.setPreferredSize(new Dimension(290, acumuladorConsultaItinerario * 25));
        sListConsultaItinerario = new JScrollPane(listConsultaItinerario);
        sListConsultaItinerario.setPreferredSize(new Dimension(300, 210));
        pnlConsultaItinerario.add(sListConsultaItinerario);

        pnlConsultaHorario = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pnlConsultaHorario.setVisible(false);
        pnlConsultaHorario.setPreferredSize(new Dimension(600, 300));
        pnlConsultaHorario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaHorario.setBackground(new Color(240, 240, 240));

        lblConsultaHorarioSelecione = new JLabel("Selecione o itinerario que deseja consultar horarios:");
        cboConsultaHorarios = new JComboBox(new String[]{"Selecione"});
        lblConsultaHorarioSelecioneDia = new JLabel("Selecione o dia que deseja verificar horarios:");
        cboConsultaHorarioDia = new JComboBox(new String[]{"Selecione", "Domingo", "Segunda-feira", "Terca-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sabado"});
        cboConsultaHorariosIdOculto = new JComboBox(new String[]{"Selecione"});
        cboConsultaHorarios.setPreferredSize(new Dimension(200, 30));
        cboConsultaHorarioDia.setPreferredSize(new Dimension(200, 30));
        cboConsultaHorariosIdOculto.setVisible(false);

        lblConsultaHorarioSelecioneDia.setVisible(false);
        cboConsultaHorarioDia.setVisible(false);

        pnlConsultaHorario.add(lblConsultaHorarioSelecione);
        pnlConsultaHorario.add(cboConsultaHorarios);
        pnlConsultaHorario.add(lblConsultaHorarioSelecioneDia);
        pnlConsultaHorario.add(cboConsultaHorarioDia);


        tbmHorario = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };

        tableHorario = new JTable(tbmHorario);
        scrollPaneHorario = new JScrollPane(tableHorario);
        scrollPaneHorario.setPreferredSize(new Dimension(530, 150));
        tableHorario.setVisible(false);
        tableHorario.setFillsViewportHeight(true);
        tableHorario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        pnlConsultaHorario.add(scrollPaneHorario, BorderLayout.CENTER);


        pnlConsultaPassagem = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        pnlConsultaPassagem.setVisible(false);
        pnlConsultaPassagem.setPreferredSize(new Dimension(600, 300));
        pnlConsultaPassagem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP, fontePadrao));
        pnlConsultaPassagem.setBackground(new Color(240, 240, 240));

        pnlConsultaPassagemCampos = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlConsultaPassagemCampos.setPreferredSize(new Dimension(300, 200));
        pnlConsultaPassagemCampos.setBackground(new Color(240, 240, 240));

        lblConsultaPassagemSelecioneCampos = new JLabel("Selecione os campos para consultar passagens:");
        lblConsultaPassagemOrigem = new JLabel("Origem:");
        cboConsultaPassagemOrigem = new JComboBox(new String[]{"Selecione"});
        lblConsultaPassagemDestino = new JLabel("Destino:");
        cboConsultaPassagemDestino = new JComboBox(new String[]{"Selecione"});
        lblConsultaPassagemData = new JLabel("Data:");
        cboConsultaPassagemDataDia = new JComboBox(new String[]{"-"});
        cboConsultaPassagemDataMes = new JComboBox(new String[]{"-"});
        cboConsultaPassagemDataAno = new JComboBox(new String[]{"-"});
        lblConsultaPassagemHorario = new JLabel("Horario:");
        cboConsultaPassagemHorario = new JComboBox(new String[]{"Selecione"});
        listConsultaPassagem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        arrayRotaItinerarioIdCidadeDestino = new ArrayList<Integer>();
        arrayCidadesOrigemId = new ArrayList<Integer>();
        arrayCidadesDestinoId = new ArrayList<Integer>();
        arrayHorariosChegada = new ArrayList<String>();
        arrayPrecos = new ArrayList<Double>();
        arrayHorariosId = new ArrayList<Integer>();
        arrayPoltronasOcupadas = new ArrayList<Integer>();

        cboConsultaPassagemDataAno.setEnabled(false);
        cboConsultaPassagemDataDia.setEnabled(false);
        cboConsultaPassagemDataMes.setEnabled(false);
        cboConsultaPassagemDestino.setEnabled(false);
        cboConsultaPassagemHorario.setEnabled(false);

        cboConsultaPassagemOrigem.setPreferredSize(new Dimension(180, 30));
        cboConsultaPassagemDestino.setPreferredSize(new Dimension(180, 30));
        cboConsultaPassagemHorario.setPreferredSize(new Dimension(180, 30));
        cboConsultaPassagemDataDia.setPreferredSize(new Dimension(50, 30));
        cboConsultaPassagemDataMes.setPreferredSize(new Dimension(50, 30));
        cboConsultaPassagemDataAno.setPreferredSize(new Dimension(60, 30));
        lblConsultaPassagemOrigem.setPreferredSize(new Dimension(60, 30));
        lblConsultaPassagemDestino.setPreferredSize(new Dimension(60, 30));
        lblConsultaPassagemData.setPreferredSize(new Dimension(60, 30));
        lblConsultaPassagemHorario.setPreferredSize(new Dimension(60, 30));
        lblConsultaPassagemSelecioneCampos.setPreferredSize(new Dimension(500, 30));

        listConsultaPassagem.setPreferredSize(new Dimension(100, acumuladorConsultaPassagem * 21));
        sListConsultaPassagem = new JScrollPane(listConsultaPassagem);
        sListConsultaPassagem.setPreferredSize(new Dimension(250, 210));
        //sListConsultaPassagem.setVisible(false);
        for (int i = 1; i <= 31; i++) {
            if(i<10){
                cboConsultaPassagemDataDia.addItem("0"+i);
            } else {
                cboConsultaPassagemDataDia.addItem(i);
            }
        }
        for (int i = 1; i <= 12; i++) {
            if(i<10){
                cboConsultaPassagemDataMes.addItem("0"+i);
                
            } else {
                cboConsultaPassagemDataMes.addItem(i);
            }
        }
        for (int i = 2012; i <= 2013; i++) {
            cboConsultaPassagemDataAno.addItem(i);
        }
        pnlConsultaPassagemCampos.add(lblConsultaPassagemOrigem);
        pnlConsultaPassagemCampos.add(cboConsultaPassagemOrigem);
        pnlConsultaPassagemCampos.add(lblConsultaPassagemDestino);
        pnlConsultaPassagemCampos.add(cboConsultaPassagemDestino);
        pnlConsultaPassagemCampos.add(lblConsultaPassagemData);
        pnlConsultaPassagemCampos.add(cboConsultaPassagemDataDia);
        pnlConsultaPassagemCampos.add(cboConsultaPassagemDataMes);
        pnlConsultaPassagemCampos.add(cboConsultaPassagemDataAno);
        pnlConsultaPassagemCampos.add(lblConsultaPassagemHorario);
        pnlConsultaPassagemCampos.add(cboConsultaPassagemHorario);

        pnlConsultaPassagem.add(lblConsultaPassagemSelecioneCampos);
        pnlConsultaPassagem.add(pnlConsultaPassagemCampos);
        pnlConsultaPassagem.add(sListConsultaPassagem);

        pnlConsulta.add(pnlConsultaEscolha);
        pnlConsulta.add(pnlConsultaOnibus);
        pnlConsulta.add(pnlConsultaMotorista);
        pnlConsulta.add(pnlConsultaEstado);
        pnlConsulta.add(pnlConsultaCidade);
        pnlConsulta.add(pnlConsultaRota);
        pnlConsulta.add(pnlConsultaItinerario);
        pnlConsulta.add(pnlConsultaHorario);
        pnlConsulta.add(pnlConsultaPassagem);

        rBtnOnibus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(true);
                pnlConsultaMotorista.setVisible(false);
                pnlConsultaEstado.setVisible(false);
                pnlConsultaCidade.setVisible(false);
                pnlConsultaRota.setVisible(false);
                pnlConsultaItinerario.setVisible(false);
                pnlConsultaPassagem.setVisible(false);
                pnlConsultaHorario.setVisible(false);
                carregaCombosOnibus();
                lblConsultaOnibusQtdeAssentosR.setText("");
                lblConsultaOnibusAnoR.setText("");
                lblConsultaOnibusMarcaR.setText("");
                lblConsultaOnibusModeloR.setText("");
                cboConsultaOnibusPlaca.requestFocus();
            }
        });

        rBtnMotorista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(false);
                pnlConsultaMotorista.setVisible(true);
                pnlConsultaEstado.setVisible(false);
                pnlConsultaCidade.setVisible(false);
                pnlConsultaRota.setVisible(false);
                pnlConsultaItinerario.setVisible(false);
                pnlConsultaPassagem.setVisible(false);
                pnlConsultaHorario.setVisible(false);
                carregaCombosMotorista();
                lblConsultaMotoristaCpfR.setText("");
                lblConsultaMotoristaEmailR.setText("");
                lblConsultaMotoristaEndR.setText("");
                lblConsultaMotoristaRgR.setText("");
                lblConsultaMotoristaTelR.setText("");
                cboConsultaMotoristaNome.requestFocus();
            }
        });

        rBtnEstado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(false);
                pnlConsultaMotorista.setVisible(false);
                pnlConsultaEstado.setVisible(true);
                pnlConsultaCidade.setVisible(false);
                pnlConsultaRota.setVisible(false);
                pnlConsultaItinerario.setVisible(false);
                pnlConsultaPassagem.setVisible(false);
                pnlConsultaHorario.setVisible(false);
                carregaDadosConsultaEstado(daoEstado.ConsultarTodosEstados());
            }
        });

        rBtnCidade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(false);
                pnlConsultaMotorista.setVisible(false);
                pnlConsultaEstado.setVisible(false);
                pnlConsultaCidade.setVisible(true);
                pnlConsultaRota.setVisible(false);
                pnlConsultaItinerario.setVisible(false);
                pnlConsultaPassagem.setVisible(false);
                pnlConsultaHorario.setVisible(false);
                carregaDadosConsultaCidade(daoCidade.consultarTodasCidades());
            }
        });

        rBtnRota.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(false);
                pnlConsultaMotorista.setVisible(false);
                pnlConsultaEstado.setVisible(false);
                pnlConsultaCidade.setVisible(false);
                pnlConsultaRota.setVisible(true);
                pnlConsultaItinerario.setVisible(false);
                pnlConsultaPassagem.setVisible(false);
                pnlConsultaHorario.setVisible(false);
                carregaDadosConsultaRota(daoRota.consultarTodasRotas());
            }
        });

        rBtnItinerario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(false);
                pnlConsultaMotorista.setVisible(false);
                pnlConsultaEstado.setVisible(false);
                pnlConsultaCidade.setVisible(false);
                pnlConsultaRota.setVisible(false);
                pnlConsultaItinerario.setVisible(true);
                pnlConsultaPassagem.setVisible(false);
                pnlConsultaHorario.setVisible(false);
                carregaDadosConsultaItinerario(daoItinerario.consultarTodosItinerarios());
            }
        });

        rBtnHorario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(false);
                pnlConsultaMotorista.setVisible(false);
                pnlConsultaEstado.setVisible(false);
                pnlConsultaCidade.setVisible(false);
                pnlConsultaRota.setVisible(false);
                pnlConsultaItinerario.setVisible(false);
                pnlConsultaPassagem.setVisible(false);
                pnlConsultaHorario.setVisible(true);
                cboConsultaHorarios.requestFocus();
                carregaCombosHorario();
            }
        });

        rBtnPassagem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlConsultaOnibus.setVisible(false);
                pnlConsultaMotorista.setVisible(false);
                pnlConsultaEstado.setVisible(false);
                pnlConsultaCidade.setVisible(false);
                pnlConsultaRota.setVisible(false);
                pnlConsultaItinerario.setVisible(false);
                pnlConsultaPassagem.setVisible(true);
                pnlConsultaHorario.setVisible(false);
                cboConsultaPassagemDataAno.setEnabled(false);
                cboConsultaPassagemDataMes.setEnabled(false);
                cboConsultaPassagemDataDia.setEnabled(false);
                cboConsultaPassagemDestino.setEnabled(false);
                cboConsultaPassagemHorario.setEnabled(false);
                carregaDadosConsultaPassagem(daoPassagem.carregaCidadesOrigem());
                cboConsultaPassagemOrigem.requestFocus();
            }
        });

        cboConsultaMotoristaNome.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaMotoristaNome.getSelectedItem().equals("Selecione"))) {
                        cboConsultaMotoristaIdOculto.setSelectedIndex(cboConsultaMotoristaNome.getSelectedIndex());
                        motorista.setMotoristaId(Integer.parseInt(String.valueOf(cboConsultaMotoristaIdOculto.getSelectedItem())));
                        Motorista aux = daoMotorista.consultarMotorista(motorista);
                        lblConsultaMotoristaRgR.setText(aux.getMotoristaRg());
                        lblConsultaMotoristaCpfR.setText(aux.getMotoristaCpf());
                        lblConsultaMotoristaTelR.setText(aux.getMotoristaTel());
                        lblConsultaMotoristaEndR.setText(aux.getMotoristaEnd());
                        lblConsultaMotoristaEmailR.setText(aux.getMotoristaEmail());
                    } else {
                        lblConsultaMotoristaRgR.setText("");
                        lblConsultaMotoristaCpfR.setText("");
                        lblConsultaMotoristaTelR.setText("");
                        lblConsultaMotoristaEndR.setText("");
                        lblConsultaMotoristaEmailR.setText("");
                    }
                }
            }
        });

        cboConsultaOnibusPlaca.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaOnibusPlaca.getSelectedItem().equals("Selecione"))) {
                        cboConsultaOnibusIdOculto.setSelectedIndex(cboConsultaOnibusPlaca.getSelectedIndex());
                        onibus.setOnibusId(Integer.parseInt(String.valueOf(cboConsultaOnibusIdOculto.getSelectedItem())));
                        Onibus aux = daoOnibus.consultaOnibus(onibus);
                        lblConsultaOnibusModeloR.setText(aux.getOnibusModelo());
                        lblConsultaOnibusMarcaR.setText(aux.getOnibusMarca());
                        lblConsultaOnibusAnoR.setText(String.valueOf(aux.getOnibusAno()));
                        lblConsultaOnibusQtdeAssentosR.setText(String.valueOf(aux.getOnibusQtdeAssentos()));
                    } else {
                        lblConsultaOnibusModeloR.setText("");
                        lblConsultaOnibusMarcaR.setText("");
                        lblConsultaOnibusAnoR.setText("");
                        lblConsultaOnibusQtdeAssentosR.setText("");
                    }
                }
            }
        });

        cboConsultaPassagemOrigem.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                cboConsultaPassagemDataAno.setEnabled(false);
                cboConsultaPassagemDataAno.setSelectedItem("-");
                cboConsultaPassagemDataDia.setEnabled(false);
                cboConsultaPassagemDataDia.setSelectedItem("-");
                cboConsultaPassagemDataMes.setEnabled(false);
                cboConsultaPassagemDataMes.setSelectedItem("-");
                cboConsultaPassagemDestino.setEnabled(false);
                cboConsultaPassagemDestino.setSelectedItem("Selecione");
                cboConsultaPassagemHorario.setEnabled(false);
                cboConsultaPassagemHorario.setSelectedItem("Selecione");
                listConsultaPassagem.removeAll();
                listConsultaPassagem.updateUI();
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaPassagemOrigem.getSelectedItem().equals("Selecione"))) {
                        cboConsultaPassagemDestino.setEnabled(true);
                        Cidade cidade = new Cidade();
                        cidade.setCidadeId(arrayCidadesOrigemId.get(cboConsultaPassagemOrigem.getSelectedIndex()));
                        cidade.setCidadeNome(String.valueOf(cboConsultaPassagemOrigem.getSelectedItem()));
                        ArrayList<Cidade> cidades = daoPassagem.carregaCidadesDestino(cidade);
                        cboConsultaPassagemDestino.removeAllItems();
                        cboConsultaPassagemDestino.addItem("Selecione");
                        arrayRotaItinerarioIdCidadeDestino.clear();
                        arrayCidadesDestinoId.clear();
                        arrayRotaItinerarioIdCidadeDestino.add(0);
                        for (int i = 0; i < cidades.size(); i++) {
                            cboConsultaPassagemDestino.addItem(cidades.get(i).getCidadeNome());
                            arrayCidadesDestinoId.add(cidades.get(i).getCidadeId());
                            arrayRotaItinerarioIdCidadeDestino.add(cidades.get(i).getCidade_estadoId());
                        }
                        cboConsultaPassagemDestino.requestFocus();
                    } else {
                        listConsultaPassagem.removeAll();
                        listConsultaPassagem.updateUI();
                    }
                }
            }
        });

        cboConsultaPassagemDestino.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                cboConsultaPassagemDataAno.setEnabled(false);
                cboConsultaPassagemDataAno.setSelectedItem("-");
                cboConsultaPassagemDataDia.setEnabled(false);
                cboConsultaPassagemDataDia.setSelectedItem("-");
                cboConsultaPassagemDataMes.setEnabled(false);
                cboConsultaPassagemDataMes.setSelectedItem("-");
                cboConsultaPassagemHorario.setEnabled(false);
                cboConsultaPassagemHorario.setSelectedItem("Selecione");
                listConsultaPassagem.removeAll();
                listConsultaPassagem.updateUI();
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaPassagemDestino.getSelectedItem().equals("Selecione"))) {
                        cboConsultaPassagemDataAno.setEnabled(true);
                        cboConsultaPassagemDataDia.setEnabled(true);
                        cboConsultaPassagemDataMes.setEnabled(true);
                        cboConsultaPassagemDataDia.requestFocus();
                    }
                } else {
                    listConsultaPassagem.removeAll();
                    listConsultaPassagem.updateUI();
                }
            }
        });

        cboConsultaPassagemDataAno.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaPassagemDataAno.getSelectedItem().equals("-"))) {
                        if (!(cboConsultaPassagemDataDia.getSelectedItem().equals("-")) && !(cboConsultaPassagemDataMes.getSelectedItem().equals("-"))) {
                            ArrayList<Horario> horarios = daoPassagem.carregaHorarios(arrayRotaItinerarioIdCidadeDestino.get(cboConsultaPassagemDestino.getSelectedIndex()), Integer.parseInt(String.valueOf(cboConsultaPassagemDataDia.getSelectedItem())), Integer.parseInt(String.valueOf(cboConsultaPassagemDataMes.getSelectedItem())), Integer.parseInt(String.valueOf(cboConsultaPassagemDataAno.getSelectedItem())));
                            cboConsultaPassagemHorario.setEnabled(true);
                            cboConsultaPassagemHorario.removeAllItems();
                            cboConsultaPassagemHorario.addItem("Selecione");
                            arrayHorariosChegada.clear();
                            arrayHorariosChegada.add("");
                            arrayPrecos.clear();
                            arrayPrecos.add(0.0);
                            arrayHorariosId.clear();
                            arrayHorariosId.add(0);
                            for (int i = 0; i < horarios.size(); i++) {
                                cboConsultaPassagemHorario.addItem(horarios.get(i).getHorarioSaida());
                                arrayHorariosChegada.add(horarios.get(i).getHorarioChegada());
                                arrayPrecos.add(horarios.get(i).getHorarioPreco());
                                arrayHorariosId.add(horarios.get(i).getHorarioId());
                            }
                            cboConsultaPassagemHorario.requestFocus();
                        }
                    } else {
                        listConsultaPassagem.removeAll();
                        listConsultaPassagem.updateUI();
                    }
                }
            }
        });

        cboConsultaPassagemDataMes.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaPassagemDataMes.getSelectedItem().equals("-"))) {
                        if (!(cboConsultaPassagemDataDia.getSelectedItem().equals("-")) && !(cboConsultaPassagemDataAno.getSelectedItem().equals("-"))) {
                            ArrayList<Horario> horarios = daoPassagem.carregaHorarios(arrayRotaItinerarioIdCidadeDestino.get(cboConsultaPassagemDestino.getSelectedIndex()), Integer.parseInt(String.valueOf(cboConsultaPassagemDataDia.getSelectedItem())), Integer.parseInt(String.valueOf(cboConsultaPassagemDataMes.getSelectedItem())), Integer.parseInt(String.valueOf(cboConsultaPassagemDataAno.getSelectedItem())));
                            cboConsultaPassagemHorario.setEnabled(true);
                            cboConsultaPassagemHorario.removeAllItems();
                            cboConsultaPassagemHorario.addItem("Selecione");
                            arrayHorariosChegada.clear();
                            arrayHorariosChegada.add("");
                            arrayPrecos.clear();
                            arrayPrecos.add(0.0);
                            arrayHorariosId.clear();
                            arrayHorariosId.add(0);
                            for (int i = 0; i < horarios.size(); i++) {
                                cboConsultaPassagemHorario.addItem(horarios.get(i).getHorarioSaida());
                                arrayHorariosChegada.add(horarios.get(i).getHorarioChegada());
                                arrayPrecos.add(horarios.get(i).getHorarioPreco());
                                arrayHorariosId.add(horarios.get(i).getHorarioId());
                            }
                        }
                        cboConsultaPassagemDataAno.requestFocus();
                    } else {
                        listConsultaPassagem.removeAll();
                        listConsultaPassagem.updateUI();
                    }
                }
            }
        });

        cboConsultaPassagemDataDia.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaPassagemDataDia.getSelectedItem().equals("-"))) {
                        if (!(cboConsultaPassagemDataAno.getSelectedItem().equals("-")) && !(cboConsultaPassagemDataMes.getSelectedItem().equals("-"))) {
                            ArrayList<Horario> horarios = daoPassagem.carregaHorarios(arrayRotaItinerarioIdCidadeDestino.get(cboConsultaPassagemDestino.getSelectedIndex()), Integer.parseInt(String.valueOf(cboConsultaPassagemDataDia.getSelectedItem())), Integer.parseInt(String.valueOf(cboConsultaPassagemDataMes.getSelectedItem())), Integer.parseInt(String.valueOf(cboConsultaPassagemDataAno.getSelectedItem())));
                            cboConsultaPassagemHorario.setEnabled(true);
                            cboConsultaPassagemHorario.removeAllItems();
                            cboConsultaPassagemHorario.addItem("Selecione");
                            arrayHorariosChegada.clear();
                            arrayHorariosChegada.add("");
                            arrayPrecos.clear();
                            arrayPrecos.add(0.0);
                            arrayHorariosId.clear();
                            arrayHorariosId.add(0);
                            for (int i = 0; i < horarios.size(); i++) {
                                cboConsultaPassagemHorario.addItem(horarios.get(i).getHorarioSaida());
                                arrayHorariosChegada.add(horarios.get(i).getHorarioChegada());
                                arrayPrecos.add(horarios.get(i).getHorarioPreco());
                                arrayHorariosId.add(horarios.get(i).getHorarioId());
                            }
                        }
                        cboConsultaPassagemDataMes.requestFocus();
                    } else {
                        listConsultaPassagem.removeAll();
                        listConsultaPassagem.updateUI();
                    }
                }
            }
        });

        cboConsultaPassagemHorario.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    if (!(cboConsultaPassagemHorario.getSelectedItem().equals("Selecione"))) {
                        arrayPoltronasOcupadas.clear();
                        listConsultaPassagem.removeAll();
                        listConsultaPassagem.updateUI();
                        arrayPoltronasOcupadas = daoPassagem.consultaPoltronasCompradas(arrayHorariosId.get(cboConsultaPassagemHorario.getSelectedIndex()), (cboConsultaPassagemDataDia.getSelectedItem() + "/" + cboConsultaPassagemDataMes.getSelectedItem() + "/" + cboConsultaPassagemDataAno.getSelectedItem()), arrayCidadesDestinoId.get(cboConsultaPassagemDestino.getSelectedIndex() - 1));
                        if (arrayPoltronasOcupadas.isEmpty()) {
                            JLabel lblPassVendida = new JLabel("Não há passagens compradas nesta");
                            lblPassVendida.setPreferredSize(new Dimension(250, 30));
                            listConsultaPassagem.add(lblPassVendida);
                            JLabel lblPassVendida2 = new JLabel("viagem.");
                            lblPassVendida.setPreferredSize(new Dimension(250, 30));
                            listConsultaPassagem.add(lblPassVendida2);
                            listConsultaPassagem.updateUI();
                        } else {
                            JLabel lblPassVendida = new JLabel("Passagens Vendidas:");
                            lblPassVendida.setPreferredSize(new Dimension(250, 30));
                            listConsultaPassagem.add(lblPassVendida);
                            Collections.sort(arrayPoltronasOcupadas);
                            /*for(int i=0;i < arrayPoltronasOcupadas.size()-1;i++){
                            if(arrayPoltronasOcupadas.get(i) == arrayPoltronasOcupadas.get(i+1)){
                            arrayPoltronasOcupadas.remove(i);
                            i = i--;
                            }
                            } */

                            for (int i = 0; i < arrayPoltronasOcupadas.size(); i++) {
                                System.out.println("poltrona ocupada22: " + arrayPoltronasOcupadas.get(i));
                                listConsultaPassagem.add(new JLabel("" + arrayPoltronasOcupadas.get(i)));
                            }
                            listConsultaPassagem.updateUI();
                        }
                    } else {
                        listConsultaPassagem.removeAll();
                        listConsultaPassagem.updateUI();
                    }
                }
            }
        });

        cboConsultaHorarios.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    cboConsultaHorariosIdOculto.setSelectedIndex(cboConsultaHorarios.getSelectedIndex());
                    System.out.println(cboConsultaHorariosIdOculto.getSelectedItem());
                    scrollPaneHorario.setVisible(false);
                    cboConsultaHorarioDia.setVisible(false);
                    lblConsultaHorarioSelecioneDia.setVisible(false);
                    cboConsultaHorarioDia.setSelectedIndex(0);
                    if (!(cboConsultaHorarios.getSelectedItem().equals("Selecione"))) {
                        cboConsultaHorarioDia.setVisible(true);
                        lblConsultaHorarioSelecioneDia.setVisible(true);
                    }
                }
            }
        });

        cboConsultaHorarioDia.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    cboConsultaHorariosIdOculto.setSelectedIndex(cboConsultaHorarios.getSelectedIndex());
                    if (!(cboConsultaHorarioDia.getSelectedItem().equals("Selecione"))) {
                        tbmHorario.getDataVector().removeAllElements();
                        tbmHorario.fireTableDataChanged();
                        tbmHorario.setColumnCount(0);
                        int id = Integer.parseInt(String.valueOf(cboConsultaHorariosIdOculto.getSelectedItem()));
                        ArrayList<ArrayList<String>> rota = daoHorario.consultarTodosHorarios(id, cboConsultaHorarioDia.getSelectedIndex());
                        if (!rota.isEmpty()) {
                            scrollPaneHorario.setVisible(true);
                            int qtdeCidades = daoHorario.calculaTotalCidadesItinerario(id);
                            for (int i = 0; i < qtdeCidades; i++) {
                                tbmHorario.addColumn(rota.get(i).get(0));
                            }
                            for (int i = 0; i < qtdeCidades; i++) {
                                if (qtdeCidades <= 5) {
                                    tableHorario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                                } else {
                                    TableColumn col = tableHorario.getColumnModel().getColumn(i);
                                    int tamanho = rota.get(i).get(0).length() * 10;
                                    col.setPreferredWidth(tamanho);
                                }
                            }
                            Object add[] = new Object[qtdeCidades];
                            int cont = 0;
                            for (int i = 0; i < rota.size(); i++) {
                                if (cont != qtdeCidades) {
                                    add[cont] = rota.get(i).get(3);
                                    System.out.println(add[cont]);
                                    cont++;
                                } else {
                                    tbmHorario.addRow(add);
                                    cont = 0;
                                    i = i - 1;
                                }
                            }
                            tbmHorario.addRow(add);
                            tableHorario.setVisible(true);
                        } else {
                            scrollPaneHorario.setVisible(false);
                            JOptionPane.showMessageDialog(null, "Nao existe horario cadastrado para este dia.");
                            cboConsultaHorarioDia.requestFocus();
                        }
                    } else {
                        scrollPaneHorario.setVisible(false);
                    }
                }
            }
        });

        return pnlConsulta;
    }

    public void focusPnlPrincipal() {
        rBtnRota.setSelected(true);
        pnlConsultaOnibus.setVisible(false);
        pnlConsultaMotorista.setVisible(false);
        pnlConsultaEstado.setVisible(false);
        pnlConsultaCidade.setVisible(false);
        pnlConsultaRota.setVisible(true);
        pnlConsultaItinerario.setVisible(false);
        pnlConsultaPassagem.setVisible(false);
        pnlConsultaHorario.setVisible(false);
        carregaDadosConsultaRota(daoRota.consultarTodasRotas());
    }

    public void carregaDadosConsultaEstado(ArrayList<Estado> estados) {
        acumuladorConsultaEstado = 0;
        listConsultaEstado.removeAll();
        for (int i = 0; i < estados.size(); i++) {
            JLabel label = new JLabel(estados.get(i).getEstadoUf());
            label.setPreferredSize(new Dimension(150, 20));
            listConsultaEstado.add(label);
            acumuladorConsultaEstado++;
        }
        listConsultaEstado.setPreferredSize(new Dimension(150, acumuladorConsultaEstado * 25));
    }

    public void carregaDadosConsultaCidade(ArrayList<Cidade> cidades) {
        acumuladorConsultaCidade = 0;
        listConsultaCidade.removeAll();
        for (int i = 0; i < cidades.size(); i++) {
            JLabel label = new JLabel(cidades.get(i).getCidadeNome());
            label.setPreferredSize(new Dimension(250, 20));
            listConsultaCidade.add(label);
            acumuladorConsultaCidade++;
        }
        listConsultaCidade.setPreferredSize(new Dimension(150, acumuladorConsultaCidade * 25));
    }

    public void carregaDadosConsultaRota(ArrayList<Rota> rotas) {
        acumuladorConsultaRota = 0;
        listConsultaRota.removeAll();
        for (int i = 0; i < rotas.size(); i++) {
            JLabel label = new JLabel(rotas.get(i).getRota_cidadeOrigem() + " - " + rotas.get(i).getRota_cidadeDestino());
            label.setPreferredSize(new Dimension(250, 20));
            listConsultaRota.add(label);
            acumuladorConsultaRota++;
        }
        listConsultaRota.setPreferredSize(new Dimension(150, acumuladorConsultaRota * 25));
    }

    public void carregaDadosConsultaPassagem(ArrayList<Cidade> cidade) {
        cboConsultaPassagemOrigem.removeAllItems();
        cboConsultaPassagemOrigem.addItem("Selecione");
        arrayCidadesOrigemId.clear();
        arrayCidadesOrigemId.add(0);
        for (int i = 0; i < cidade.size(); i++) {
            cboConsultaPassagemOrigem.addItem(cidade.get(i).getCidadeNome());
            arrayCidadesOrigemId.add(cidade.get(i).getCidadeId());
        }
    }

    public void carregaDadosConsultaItinerario(ArrayList<Itinerario> itinerarios) {
        acumuladorConsultaItinerario = 0;
        listConsultaItinerario.removeAll();
        for (int i = 0; i < itinerarios.size(); i++) {
            JLabel label = new JLabel(itinerarios.get(i).getItinerario_cidadeOrigem() + " - " + itinerarios.get(i).getItinerario_cidadeDestino());
            label.setPreferredSize(new Dimension(250, 20));
            listConsultaItinerario.add(label);
            acumuladorConsultaItinerario++;
        }
        listConsultaItinerario.setPreferredSize(new Dimension(150, acumuladorConsultaItinerario * 25));
    }

    public void carregaCombosOnibus() {
        ArrayList<Onibus> aux = daoOnibus.consultarTodosOnibus();
        cboConsultaOnibusPlaca.removeAllItems();
        cboConsultaOnibusPlaca.addItem("Selecione");
        cboConsultaOnibusIdOculto.removeAllItems();
        cboConsultaOnibusIdOculto.addItem("Selecione");
        for (int i = 0; i < aux.size(); i++) {
            cboConsultaOnibusPlaca.addItem(aux.get(i).getOnibusPlaca());
            cboConsultaOnibusIdOculto.addItem(aux.get(i).getOnibusId());
        }
    }

    public void carregaCombosMotorista() {
        ArrayList<Motorista> aux = daoMotorista.consultarTodosMotoristas();
        cboConsultaMotoristaNome.removeAllItems();
        cboConsultaMotoristaNome.addItem("Selecione");
        cboConsultaMotoristaIdOculto.removeAllItems();
        cboConsultaMotoristaIdOculto.addItem("Selecione");
        for (int i = 0; i < aux.size(); i++) {
            cboConsultaMotoristaNome.addItem(aux.get(i).getMotoristaNome());
            cboConsultaMotoristaIdOculto.addItem(aux.get(i).getMotoristaId());
        }
    }

    public void carregaCombosHorario() {
        ArrayList<Itinerario> itinerariosRotaItinerario = daoRotaItinerario.consultarItinerariosCadastrados();
        cboConsultaHorarios.removeAllItems();
        cboConsultaHorarios.addItem("Selecione");
        for (int i = 0; i < itinerariosRotaItinerario.size(); i++) {
            cboConsultaHorarios.addItem(itinerariosRotaItinerario.get(i).getItinerario_cidadeOrigem() + " - " + itinerariosRotaItinerario.get(i).getItinerario_cidadeDestino());
            cboConsultaHorariosIdOculto.addItem(itinerariosRotaItinerario.get(i).getItinerarioId());
        }
    }

    //------- Geral
    private Font fontePadrao;
    private DaoOnibus daoOnibus;
    private DaoCidade daoCidade;
    private DaoEstado daoEstado;
    private DaoMotorista daoMotorista;
    private DaoRota daoRota;
    private DaoItinerario daoItinerario;
    private DaoPassagem daoPassagem;
    private DaoHorario daoHorario;
    private DaoRotaItinerario daoRotaItinerario;
    private Onibus onibus;
    private Motorista motorista;
    private Passagem passagem;
    private JPanel pnlConsulta;
    //------- Consulta
    private JPanel pnlConsultaEscolha;
    private JPanel pnlConsultaOnibus;
    private JPanel pnlConsultaMotorista;
    private JPanel pnlConsultaEstado;
    private JPanel pnlConsultaCidade;
    private JPanel pnlConsultaRota;
    private JPanel pnlConsultaItinerario;
    private JPanel pnlConsultaHorario;
    private JPanel pnlConsultaPassagem;
    private JRadioButton rBtnOnibus;
    private JRadioButton rBtnMotorista;
    private JRadioButton rBtnEstado;
    private JRadioButton rBtnCidade;
    private JRadioButton rBtnRota;
    private JRadioButton rBtnItinerario;
    private JRadioButton rBtnHorario;
    private JRadioButton rBtnPassagem;
    private ButtonGroup grupoRadioBtnConsulta;
    //onibus
    private JLabel lblConsultaOnibusId;
    private JLabel lblConsultaOnibusModelo;
    private JLabel lblConsultaOnibusMarca;
    private JLabel lblConsultaOnibusAno;
    private JLabel lblConsultaOnibusQtdeAssentos;
    private JComboBox cboConsultaOnibusPlaca;
    private JComboBox cboConsultaOnibusIdOculto;
    private JLabel lblConsultaOnibusModeloR;
    private JLabel lblConsultaOnibusMarcaR;
    private JLabel lblConsultaOnibusAnoR;
    private JLabel lblConsultaOnibusQtdeAssentosR;
    //motorista
    private JLabel lblConsultaMotoristaNome;
    private JLabel lblConsultaMotoristaRg;
    private JLabel lblConsultaMotoristaCpf;
    private JLabel lblConsultaMotoristaEmail;
    private JLabel lblConsultaMotoristaEnd;
    private JLabel lblConsultaMotoristaTel;
    private JComboBox cboConsultaMotoristaNome;
    private JComboBox cboConsultaMotoristaIdOculto;
    private JLabel lblConsultaMotoristaRgR;
    private JLabel lblConsultaMotoristaCpfR;
    private JLabel lblConsultaMotoristaEmailR;
    private JLabel lblConsultaMotoristaEndR;
    private JLabel lblConsultaMotoristaTelR;
    //estado
    private JLabel lblConsultaEstadoNome;
    private JPanel listConsultaEstado;
    private JScrollPane sListConsultaEstado;
    private int acumuladorConsultaEstado;
    //cidade
    private JLabel lblConsultaCidadeNome;
    private int acumuladorConsultaCidade;
    private JPanel listConsultaCidade;
    private JScrollPane sListConsultaCidade;
    //Rota
    private JLabel lblConsultaRotaNome;
    private int acumuladorConsultaRota;
    private JPanel listConsultaRota;
    private JScrollPane sListConsultaRota;
    //Itinerario
    private JLabel lblConsultaItinerarioNome;
    private int acumuladorConsultaItinerario;
    private JPanel listConsultaItinerario;
    private JScrollPane sListConsultaItinerario;
    //Horario
    private JLabel lblConsultaHorarioSelecione;
    private JComboBox cboConsultaHorarios;
    private JLabel lblConsultaHorarioSelecioneDia;
    private JComboBox cboConsultaHorarioDia;
    private JComboBox cboConsultaHorariosIdOculto;
    private JTable tableHorario;
    private DefaultTableModel tbmHorario;
    private JScrollPane scrollPaneHorario;
    //passagem
    private JPanel pnlConsultaPassagemCampos;
    private JLabel lblConsultaPassagemSelecioneCampos;
    private JLabel lblConsultaPassagemOrigem;
    private JComboBox cboConsultaPassagemOrigem;
    private JLabel lblConsultaPassagemDestino;
    private JComboBox cboConsultaPassagemDestino;
    private JLabel lblConsultaPassagemData;
    private JComboBox cboConsultaPassagemDataDia;
    private JComboBox cboConsultaPassagemDataMes;
    private JComboBox cboConsultaPassagemDataAno;
    private JLabel lblConsultaPassagemHorario;
    private JComboBox cboConsultaPassagemHorario;
    private int acumuladorConsultaPassagem;
    private JPanel listConsultaPassagem;
    private JScrollPane sListConsultaPassagem;
    private ArrayList<Integer> arrayCidadesOrigemId;
    private ArrayList<Integer> arrayCidadesDestinoId;
    private ArrayList<Integer> arrayRotaItinerarioIdCidadeDestino;
    private ArrayList<Integer> arrayHorariosId;
    private ArrayList<Integer> arrayPoltronasOcupadas;
    private ArrayList<Double> arrayPrecos;
    private ArrayList<String> arrayHorariosChegada;
}
