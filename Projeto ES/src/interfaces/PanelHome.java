package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelHome {

    public JPanel inserirPnlHome() {
        pnlHome = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 320));
        pnlHome.setBackground(new Color(240, 240, 240));
        pnlHome.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)), " SISTEMA DE COMPRAS DE PASSAGENS DE ONIBUS ", TitledBorder.CENTER, TitledBorder.TOP, new Font("Segoe UI", 1, 14)));
        lblImagemInicial = new JLabel();
        String local = System.getProperty("user.dir"); //pega diretorio do projeto
        lblImagemInicial.setIcon(new ImageIcon(local + "/src/imagens/logo.png"));
        pnlHome.add(lblImagemInicial);
        return pnlHome;
    }
    
    private JPanel pnlHome;
    private JLabel lblImagemInicial;
}
