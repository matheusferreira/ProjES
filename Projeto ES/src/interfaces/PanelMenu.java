package interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.*;

import main.PrincipalFuncionario;

import util.Backup;

public class PanelMenu extends JPanel {

    public JPanel inserirPnlMenu() throws ParseException {
        pnlMenu = new JPanel();
        pnlMenu.setBackground(new Color(240, 240, 240));
        pnlMenu.setMinimumSize(new Dimension(885, 650));
        pnlMenu.setPreferredSize(new Dimension(885, 650));

        separadorMenu = new JSeparator();
        separadorMenu.setOrientation(SwingConstants.VERTICAL);
        btnOnibus = new JLabel();
        btnMotorista = new JLabel();
        btnCidade = new JLabel();
        btnEstado = new JLabel();
        btnRotaItinerario = new JLabel();
        btnHorario = new JLabel();
        btnItinerarioRota = new JLabel();

        btnOnibus.setToolTipText("Onibus");
        btnMotorista.setToolTipText("Motoristas");
        btnCidade.setToolTipText("Cidades");
        btnEstado.setToolTipText("Estados");
        btnRotaItinerario.setToolTipText("Associar Rotas a Itinerarios");
        btnHorario.setToolTipText("Horarios");
        btnItinerarioRota.setToolTipText("Rotas/Itinerarios");

        String local = System.getProperty("user.dir"); //pega diretorio do projeto
        btnOnibus.setIcon(new ImageIcon(local + "/src/imagens/bt_onibus75m.png"));
        btnMotorista.setIcon(new ImageIcon(local + "/src/imagens/bt_motorista75m.png"));
        btnCidade.setIcon(new ImageIcon(local + "/src/imagens/bt_cidade75m.png"));
        btnEstado.setIcon(new ImageIcon(local + "/src/imagens/bt_estados75m.png"));
        btnRotaItinerario.setIcon(new ImageIcon(local + "/src/imagens/bt_rotaItinerario75m.png"));
        btnHorario.setIcon(new ImageIcon(local + "/src/imagens/bt_itinerario75m.png"));
        btnItinerarioRota.setIcon(new ImageIcon(local + "/src/imagens/bt_rota75m.png"));

        homePanel = new PanelHome();
        onibusPanel = new PanelOnibus();
        motoristaPanel = new PanelMotorista();
        estadoPanel = new PanelEstado();
        cidadePanel = new PanelCidade();
        consultaPanel = new PanelConsulta();
        itinerarioRotaPanel = new PanelItinerarioRota();
        funcionarioPanel = new PanelFuncionario();
        horarioPanel = new PanelHorario();
        rotaItinerarioPanel = new PanelRotaItinerario();

        pnlHome = homePanel.inserirPnlHome();
        pnlOnibus = onibusPanel.inserirPnlOnibus();
        pnlMotorista = motoristaPanel.inserirPnlMotorista();
        pnlEstado = estadoPanel.inserirPnlEstado();
        pnlCidade = cidadePanel.inserirPnlCidade();
        pnlConsulta = consultaPanel.inserirPnlConsulta();
        pnlItinerarioRota = itinerarioRotaPanel.inserirPnlRotaItinerario();
        pnlFuncionario = funcionarioPanel.inserirPnlFuncionario();
        pnlHorario = horarioPanel.inserirPnlHorario();
        pnlRotaItinerario = rotaItinerarioPanel.inserirPnlItinerario();

        btnOnibus.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                btnOnibusMouseReleased(evt);
            }
        });

        btnMotorista.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                btnMotoristaMouseReleased(evt);
            }
        });

        btnCidade.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                btnCidadeMouseReleased(evt);
            }
        });

        btnEstado.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                btnEstadoMouseReleased(evt);
            }
        });

        btnRotaItinerario.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                btnRotaItinerarioMouseReleased(evt);
            }
        });

        btnHorario.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                btnHorarioMouseReleased(evt);
            }
        });

        btnItinerarioRota.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                btnItinerarioRotaMouseReleased(evt);
            }
        });

        GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
                pnlMenuLayout.createParallelGroup().addGroup(pnlMenuLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(pnlMenuLayout.createParallelGroup().addComponent(btnHorario, 73, 73, 73).addComponent(btnRotaItinerario, 73, 73, 73).addComponent(btnItinerarioRota, 73, 73, 73).addComponent(btnCidade, 73, 73, 73).addComponent(btnEstado, 73, 73, 73).addComponent(btnMotorista, 73, 73, 73).addComponent(btnOnibus, 73, 73, 73)).addGap(28, 28, 28).addComponent(separadorMenu, 2, 2, 2).addGap(28, 28, 28).addComponent(pnlHome, 695, 695, 695).addComponent(pnlOnibus, 695, 695, 695).addComponent(pnlMotorista, 695, 695, 695).addComponent(pnlEstado, 695, 695, 695).addComponent(pnlCidade, 695, 695, 695).addComponent(pnlConsulta, 695, 695, 695).addComponent(pnlItinerarioRota, 695, 695, 695).addComponent(pnlHorario, 695, 695, 695).addComponent(pnlRotaItinerario, 695, 695, 695).addComponent(pnlFuncionario, 695, 695, 695).addContainerGap(29, 29)));
        pnlMenuLayout.setVerticalGroup(
                pnlMenuLayout.createParallelGroup().addGroup(pnlMenuLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(pnlMenuLayout.createParallelGroup().addComponent(pnlHome, 590, 590, 590).addComponent(pnlOnibus, 590, 590, 590).addComponent(pnlMotorista, 590, 590, 590).addComponent(pnlEstado, 590, 590, 590).addComponent(pnlCidade, 590, 590, 590).addComponent(pnlConsulta, 590, 590, 590).addComponent(pnlHorario, 590, 590, 590).addComponent(pnlRotaItinerario, 590, 590, 590).addComponent(pnlItinerarioRota, 590, 590, 590).addComponent(pnlFuncionario, 590, 590, 590).addGroup(pnlMenuLayout.createSequentialGroup().addComponent(btnOnibus, 73, 73, 73).addGap(12, 12, 12).addComponent(btnMotorista, 73, 73, 73).addGap(12, 12, 12).addComponent(btnEstado, 73, 73, 73).addGap(12, 12, 12).addComponent(btnCidade, 73, 73, 73).addGap(12, 12, 12).addComponent(btnItinerarioRota, 73, 73, 73).addGap(12, 12, 12).addComponent(btnRotaItinerario, 73, 73, 73).addGap(12, 12, 12).addComponent(btnHorario, 73, 73, 73).addGap(7, 7, 7)).addComponent(separadorMenu, 590, 590, 590)).addContainerGap(31, 31)));
        return pnlMenu;
    }

    public JMenuBar inserirBarraMenu(int acesso) {
        //barra de menu
        menuPrincipal = new JMenuBar();
        menuHome = new JMenu("Inicio");
        menuConsultas = new JMenu("Consultas");
        menuRelatorio = new JMenu("Relatorio");
        menuSair = new JMenu("Sair");
        menuBackup = new JMenu("Backup");

        menuConsultasConsultar = new JMenuItem("Consultar");

        menuRelatorioGerarRelatorio = new JMenuItem("Gerar Relatorio");

        menuBackupFazerBackup = new JMenuItem("Fazer Backup");
        menuBackupRestaurarBackup = new JMenuItem("Restaurar Backup");

        menuHomeHome = new JMenuItem("Pagina Inicial");

        menuSairUsuario = new JMenuItem("Sair deste usuario");
        menuSairFecharPrograma = new JMenuItem("Fechar Programa");

        menuHome.add(menuHomeHome);

        menuConsultas.add(menuConsultasConsultar);

        menuRelatorio.add(menuRelatorioGerarRelatorio);

        menuBackup.add(menuBackupFazerBackup);
        menuBackup.add(menuBackupRestaurarBackup);

        //menuSair.add(menuSairUsuario);
        menuSair.add(menuSairFecharPrograma);

        menuPrincipal.add(menuHome);
        menuPrincipal.add(menuConsultas);
        menuPrincipal.add(menuRelatorio);
        if (acesso == 1) {
            menuFuncionario = new JMenu("Funcionario");

            menuFuncionarioCadastro = new JMenuItem("Cadastrar Funcionario");
            menuFuncionarioAlteracao = new JMenuItem("Alterar Funcionario");
            menuFuncionarioRemocao = new JMenuItem("Remover Funcionario");
            menuFuncionarioConsulta = new JMenuItem("Consultar Funcionario");

            menuFuncionario.add(menuFuncionarioCadastro);
            menuFuncionario.add(menuFuncionarioAlteracao);
            menuFuncionario.add(menuFuncionarioRemocao);
            menuFuncionario.add(menuFuncionarioConsulta);

            menuPrincipal.add(menuFuncionario);

            menuFuncionarioAlteracao.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    menuFuncionarioAlteracaoClick(evt);
                }
            });

            menuFuncionarioCadastro.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    menuFuncionarioCadastroClick(evt);
                }
            });

            menuFuncionarioConsulta.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    menuFuncionarioConsultaClick(evt);
                }
            });

            menuFuncionarioRemocao.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    menuFuncionarioRemocaoClick(evt);
                }
            });

        }
        menuPrincipal.add(menuBackup);
        menuPrincipal.add(menuSair);


        menuHomeHome.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                menuHomeHomeClick(evt);
            }
        });

        menuConsultasConsultar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                menuConsultasConsultarClick(evt);
            }
        });

        menuRelatorioGerarRelatorio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                menuRelatorioGerarRelatorioClick(evt);
            }
        });

        menuBackupFazerBackup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                menuBackupFazerBackupClick(evt);
            }
        });

        menuBackupRestaurarBackup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                menuBackupRestaurarBackupClick(evt);
            }
        });

        menuSairUsuario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    menuSairUsuarioClick(evt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        menuSairFecharPrograma.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                menuSairFecharProgramaClick(evt);
            }
        });

        return menuPrincipal;
    }

    private void btnOnibusMouseReleased(MouseEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(true);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
        onibusPanel.carregaCombosOnibus(2);
        onibusPanel.carregaCombosOnibus(3);
        onibusPanel.focusTxtPrincipal();
    }

    private void btnMotoristaMouseReleased(MouseEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(true);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
        motoristaPanel.carregaCombosMotorista(2);
        motoristaPanel.carregaCombosMotorista(3);
        motoristaPanel.focusTxtPrincipal();
    }

    private void btnEstadoMouseReleased(MouseEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(true);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
        estadoPanel.carregaCombosEstado(2);
        estadoPanel.carregaCombosEstado(3);
        estadoPanel.focusTxtPrincipal();
    }

    private void btnCidadeMouseReleased(MouseEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(true);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
        cidadePanel.carregaCombosCidade(2);
        cidadePanel.carregaCombosCidade(3);
        cidadePanel.carregaCombosEstado(5);
        cidadePanel.carregaCombosEstado(6);
        cidadePanel.focusTxtPrincipal();
    }

    private void btnRotaItinerarioMouseReleased(MouseEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(true);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
        rotaItinerarioPanel.carregaComboItinerarioCadastro();
        rotaItinerarioPanel.focusCboPrincipal();
    }

    private void btnHorarioMouseReleased(MouseEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(true);
        horarioPanel.carregaComboItinerario();
    }

    private void btnItinerarioRotaMouseReleased(MouseEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(true);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
        itinerarioRotaPanel.focusTxtPrincipal();
        itinerarioRotaPanel.carregaCombosCidade();
        itinerarioRotaPanel.carregaCombosItinerario();
    }

    private void menuHomeHomeClick(ActionEvent evt) {
        pnlHome.setVisible(true);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
    }

    private void menuConsultasConsultarClick(ActionEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(true);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(false);
        pnlHorario.setVisible(false);
        consultaPanel.focusPnlPrincipal();
    }

    private void menuRelatorioGerarRelatorioClick(ActionEvent evt) {
        relatorioFrame = new PanelRelatorio();
        relatorioFrame.setVisible(true);
    }

    private void menuFuncionarioCadastroClick(ActionEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(true);
        pnlHorario.setVisible(false);
        funcionarioPanel.carregaCombosFuncionario();
        funcionarioPanel.focusTxtCadastro();
    }

    private void menuFuncionarioAlteracaoClick(ActionEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(true);
        pnlHorario.setVisible(false);
        funcionarioPanel.carregaCombosFuncionario();
        funcionarioPanel.focusTxtAlteracao();
    }

    private void menuFuncionarioRemocaoClick(ActionEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(true);
        pnlHorario.setVisible(false);
        funcionarioPanel.carregaCombosFuncionario();
        funcionarioPanel.focusTxtRemocao();
    }

    private void menuFuncionarioConsultaClick(ActionEvent evt) {
        pnlHome.setVisible(false);
        pnlOnibus.setVisible(false);
        pnlMotorista.setVisible(false);
        pnlCidade.setVisible(false);
        pnlEstado.setVisible(false);
        pnlConsulta.setVisible(false);
        pnlItinerarioRota.setVisible(false);
        pnlRotaItinerario.setVisible(false);
        pnlFuncionario.setVisible(true);
        pnlHorario.setVisible(false);
        funcionarioPanel.carregaCombosFuncionario();
        funcionarioPanel.focusTxtConsulta();
    }

    private void menuBackupFazerBackupClick(ActionEvent evt) {
        Backup fazerBackup = new Backup();
        fazerBackup.CriarBackup();
    }

    private void menuBackupRestaurarBackupClick(ActionEvent evt) {
        Backup restaurarBackup = new Backup();
        restaurarBackup.RestaurarBackup();
        onibusPanel.carregaCombosOnibus(2);
        onibusPanel.carregaCombosOnibus(3);
        motoristaPanel.carregaCombosMotorista(2);
        motoristaPanel.carregaCombosMotorista(3);
        estadoPanel.carregaCombosEstado(2);
        estadoPanel.carregaCombosEstado(3);
        cidadePanel.carregaCombosCidade(2);
        cidadePanel.carregaCombosCidade(3);
        cidadePanel.carregaCombosEstado(5);
        cidadePanel.carregaCombosEstado(6);
        rotaItinerarioPanel.carregaComboItinerarioCadastro();
        horarioPanel.carregaComboItinerario();
        itinerarioRotaPanel.carregaCombosCidade();
        itinerarioRotaPanel.carregaCombosItinerario();
    }

    private void menuSairUsuarioClick(ActionEvent evt) throws ParseException {
        pnlMenu.setVisible(false);
        PrincipalFuncionario principal = new PrincipalFuncionario();
        principal.setVisible(true);
    }

    private void menuSairFecharProgramaClick(ActionEvent evt) {
        System.exit(0);
    }
    private PanelHome homePanel;
    private PanelOnibus onibusPanel;
    private PanelMotorista motoristaPanel;
    private PanelEstado estadoPanel;
    private PanelCidade cidadePanel;
    private PanelConsulta consultaPanel;
    private PanelItinerarioRota itinerarioRotaPanel;
    private PanelFuncionario funcionarioPanel;
    private PanelHorario horarioPanel;
    private PanelRotaItinerario rotaItinerarioPanel;
    private PanelRelatorio relatorioFrame;
    private JSeparator separadorMenu;
    private JPanel pnlHome;
    private JPanel pnlOnibus;
    private JPanel pnlMotorista;
    private JPanel pnlCidade;
    private JPanel pnlEstado;
    private JPanel pnlConsulta;
    private JPanel pnlItinerarioRota;
    private JPanel pnlFuncionario;
    private JPanel pnlHorario;
    private JPanel pnlRotaItinerario;
    private JPanel pnlMenu;
    private JLabel btnOnibus;
    private JLabel btnMotorista;
    private JLabel btnCidade;
    private JLabel btnEstado;
    private JLabel btnRotaItinerario;
    private JLabel btnHorario;
    private JLabel btnItinerarioRota;
    //------- Barra de Menu
    private JMenu menuHome;
    private JMenu menuConsultas;
    private JMenu menuRelatorio;
    private JMenu menuFuncionario;
    private JMenu menuBackup;
    private JMenu menuSair;
    private JMenuBar menuPrincipal;
    private JMenuItem menuFuncionarioCadastro;
    private JMenuItem menuFuncionarioAlteracao;
    private JMenuItem menuFuncionarioRemocao;
    private JMenuItem menuFuncionarioConsulta;
    private JMenuItem menuConsultasConsultar;
    private JMenuItem menuRelatorioGerarRelatorio;
    private JMenuItem menuBackupFazerBackup;
    private JMenuItem menuBackupRestaurarBackup;
    private JMenuItem menuHomeHome;
    private JMenuItem menuSairFecharPrograma;
    private JMenuItem menuSairUsuario;
}
