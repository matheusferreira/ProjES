package main;

import dao.DaoLogin;
import entidades.Funcionario;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.*;
import interfaces.PanelMenu;

public class PrincipalFuncionario extends JFrame {

    public PrincipalFuncionario() throws ParseException {
        //abrir com aparencia "Nimbus"
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }

    private void initComponents() throws ParseException {
        this.setTitle("SISTEMA DE COMPRAS DE PASSAGENS DE ONIBUS");
        this.setMinimumSize(new Dimension(900, 700));
        this.setExtendedState(PrincipalFuncionario.MAXIMIZED_BOTH); //abrir tela maximizada
        Container esse = this.getContentPane();
        esse.setBackground(new Color(240, 240, 240));

        menuPanel = new PanelMenu();
        inserirPnlLogin();
        //pnlEntrar.setVisible(false);

        pnlMenu = menuPanel.inserirPnlMenu();
       pnlMenu.setVisible(false);

       // setJMenuBar(menuPanel.inserirBarraMenu(1));

        //montagem no frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(pnlEntrar, 885, 885, 885).addComponent(pnlMenu, 885, 885, 885).addGap(0, 0, Short.MAX_VALUE)));
        //layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(pnlMenu, 885, 885, 885).addGap(0, 0, Short.MAX_VALUE)));

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(pnlEntrar, 650, 650, 650).addComponent(pnlMenu, 650, 650, 650).addGap(0, 0, Short.MAX_VALUE)));
        //layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(pnlMenu, 650, 650, 650).addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }
    
    public JPanel inserirPnlLogin() throws ParseException {
        pnlEntrar = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 155));
        pnlEntrar.setBackground(new Color(240, 240, 240));
        pnlEntrar.setMinimumSize(new Dimension(885, 650));
        pnlEntrar.setPreferredSize(new Dimension(885, 650));
        daoLogin = new DaoLogin();

        fontePadrao = new Font("Segoe UI", 1, 14);
        gridLayout3_1 = new GridLayout(3, 1);
        layoutLeft = new FlowLayout(FlowLayout.LEFT);
        gridLayout3_1.setHgap(10);
        gridLayout3_1.setVgap(20);
        layoutLeft.setHgap(15);
        pnlLogin = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        pnlLogin.setPreferredSize(new Dimension(400, 300));
        pnlLogin.setBorder(BorderFactory.createTitledBorder(null, " LOGIN ", TitledBorder.CENTER, TitledBorder.TOP, fontePadrao));
        pnlLogin.setBackground(new Color(240, 240, 240));
        pnlEntrar.add(pnlLogin);

        JLabel lblAux = new JLabel();
        lblUsuario = new JLabel("Login:");
        lblSenha = new JLabel("Senha:");
        btnLogar = new JButton("Entrar");
        txtUsuario = new JTextField("", 20);
        txtSenha = new JPasswordField("", 20);
        lblAux.setPreferredSize(new Dimension(300, 20));
        lblUsuario.setPreferredSize(new Dimension(60, 30));
        lblSenha.setPreferredSize(new Dimension(60, 30));
        btnLogar.setPreferredSize(new Dimension(145, 40));
        pnlLogin.add(lblAux);
        pnlLogin.add(lblUsuario);
        pnlLogin.add(txtUsuario);
        pnlLogin.add(lblSenha);
        pnlLogin.add(txtSenha);
        pnlLogin.add(btnLogar);

        btnLogar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                btnLogarClick(evt);
            }
        });

        return pnlEntrar;
    }

    private void btnLogarClick(ActionEvent evt) {
        if (txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite um nome de usuario.");
            txtUsuario.requestFocus();
        } else if (txtSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite uma senha.");
            txtSenha.requestFocus();
        } else {
            funcionario = new Funcionario();
            funcionario.setFuncionarioEmail(txtUsuario.getText());
            funcionario.setFuncionarioSenha(txtSenha.getText());
            if (txtUsuario.getText().equals("admin") && txtSenha.getText().equals("admin")) {
                pnlEntrar.setVisible(false);
                pnlMenu.setVisible(true);
                setJMenuBar(menuPanel.inserirBarraMenu(1));
            } else {
                int verifica = daoLogin.fazerLogin(funcionario);
                if (verifica == 0) {
                    pnlEntrar.setVisible(false);
                    pnlMenu.setVisible(true);
                    setJMenuBar(menuPanel.inserirBarraMenu(1));
                } else if (verifica == 3) {
                    pnlEntrar.setVisible(false);
                    pnlMenu.setVisible(true);
                    setJMenuBar(menuPanel.inserirBarraMenu(0));
                } else if (verifica == 1) {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    txtSenha.setText("");
                    txtSenha.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario nao existe!");
                    txtUsuario.setText("");
                    txtSenha.setText("");
                    txtUsuario.requestFocus();
                }
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        PrincipalFuncionario esse = new PrincipalFuncionario();
        esse.setVisible(true);
    }
    
    //------- Geral
    private JPanel pnlMenu;
    private JPanel pnlLogin;
    private Font fontePadrao;
    private GridLayout gridLayout3_1;
    private FlowLayout layoutLeft;
    private Funcionario funcionario;
    private DaoLogin daoLogin;
    private PanelMenu menuPanel;
    //------- Login
    private JPanel pnlEntrar;
    private JLabel lblUsuario;
    private JLabel lblSenha;
    private JTextField txtUsuario;
    private JTextField txtSenha;
    private JButton btnLogar;
}
