package interfaces;

import dao.DaoPassagem;
import entidades.Passagem;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class PanelRelatorio extends JFrame {

    public PanelRelatorio() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setLayout(null);
        this.setTitle("Relatorio");
        this.setMinimumSize(new Dimension(300, 200));
        this.setResizable(false);
        Container frame = this.getContentPane();
        this.setSize(300, 200);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        //  Centralizando
        setLocation((screenSize.width - getSize().width) / 2,
                (screenSize.height - getSize().height) / 2);

        daoPassagem = new DaoPassagem();
        lblSelecioneData = new JLabel("Selecione a data que deseja gerar relatorio:");
        cboDia = new JComboBox(new String[]{"-"});
        cboMes = new JComboBox(new String[]{"-"});
        cboAno = new JComboBox(new String[]{"-"});
        btnGerarRelatorio = new JButton("Gerar Relatorio");
        btnFecharFrame = new JButton("Cancelar");

        lblSelecioneData.setBounds(20, 5, 290, 30);
        cboDia.setBounds(30, 50, 50, 30);
        cboMes.setBounds(100, 50, 50, 30);
        cboAno.setBounds(170, 50, 70, 30);
        btnGerarRelatorio.setBounds(15, 100, 130, 40);
        btnFecharFrame.setBounds(160, 100, 110, 40);
        barraN = System.clearProperty("line.separator");
        
        frame.add(lblSelecioneData);
        frame.add(cboDia);
        frame.add(cboMes);
        frame.add(cboAno);
        frame.add(btnGerarRelatorio);
        frame.add(btnFecharFrame);

        for (int i = 1; i <= 31; i++) {
            if(i<10){
                cboDia.addItem("0"+i);
            } else {
                cboDia.addItem(i);
            }
        }
        for (int i = 1; i <= 12; i++) {
            if(i<10){
                cboMes.addItem("0"+i);
            } else {
                cboMes.addItem(i);
            }
        }
        for (int i = 2012; i >= 2000; i--) {
            cboAno.addItem(i);
        }

        btnGerarRelatorio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (cboDia.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um dia.");
                    cboDia.requestFocus();
                } else if (cboMes.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um mes.");
                    cboMes.requestFocus();
                } else if (cboAno.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um ano.");
                    cboAno.requestFocus();
                } else {
                    String local = System.getProperty("user.dir");
                    //escreve relatorio
                    try {
                        ArrayList<ArrayList<String>> passagens = daoPassagem.consultarTodasPassagensDoDia(String.valueOf(cboDia.getSelectedItem()) + "/" + String.valueOf(cboMes.getSelectedItem()) + "/" + String.valueOf(cboAno.getSelectedItem()));
                        if(passagens.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Nao ha passagens compradas nesta data.");      
                        } else {
                            FileWriter f0 = new FileWriter(local + "/src/imagens/ComprovanteCompra.txt");
                            f0.write("Relatorio do dia " + String.valueOf(cboDia.getSelectedItem()) + "/" + String.valueOf(cboMes.getSelectedItem()) + "/" + String.valueOf(cboAno.getSelectedItem()) + barraN + barraN + barraN);
                            for (int i = 0; i < passagens.size()-1; i++) {
                                int j = i;
                                while ((passagens.get(j).get(1).equals(passagens.get(j + 1).get(1))) && (passagens.get(j).get(13).equals(passagens.get(j + 1).get(13))) && (passagens.get(j).get(3).equals(passagens.get(j + 1).get(3)))) {
                                    j++;
                                    if (j == passagens.size()-1) {
                                        break;
                                    }
                                }
                                f0.write(barraN + "Passageiro: " + passagens.get(i).get(2));
                                f0.write(barraN + "CPF: " + passagens.get(i).get(1));
                                f0.write(barraN + "Assento comprado: " + passagens.get(i).get(3));
                                f0.write(barraN + "Viagem: " + passagens.get(i).get(7) + "-" + passagens.get(i).get(8) + " até " + passagens.get(j).get(9) + "-" + passagens.get(j).get(10));
                                f0.write(barraN + "Horario de Saida: " + passagens.get(i).get(4));
                                f0.write(barraN + "Horario de Chegada: " + passagens.get(j).get(5));
                                f0.write(barraN + "Placa do Onibus que fez esta viagem: " + passagens.get(i).get(11));
                                //f0.write(barraN+"Motorista que fez esta viagem: "+passagens.get(i).get(12));


                                f0.write(barraN + barraN);
                                i = j;
                                System.out.println("i modificado: "+ i);
                            }
                            f0.close();
                            java.awt.Desktop.getDesktop().open(new File(local + "/src/imagens/ComprovanteCompra.txt"));
                            cboDia.setSelectedIndex(0);
                            cboMes.setSelectedIndex(0);
                            cboAno.setSelectedIndex(0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnFecharFrame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
            }
        });

    }
    
    private DaoPassagem daoPassagem;
    private JLabel lblSelecioneData;
    private JComboBox cboDia;
    private JComboBox cboMes;
    private JComboBox cboAno;
    private JButton btnGerarRelatorio;
    private JButton btnFecharFrame;
    private String barraN;
}
