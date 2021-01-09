package br.edu.iftm.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;

public class Janela extends JFrame{
    public Janela(){
    this.setBounds(250, 100, 900, 470);

    CardLayout mudarTela = new CardLayout();
    JPanel interfaces = new JPanel(mudarTela);

    Login login = new Login(interfaces);
    Principal principal = new Principal(interfaces);
    Conta conta = new Conta(interfaces);

    interfaces.add(login, "Login");
    interfaces.add(principal, "Principal");
    interfaces.add(conta, "Conta");

    this.add(interfaces);

    this.setVisible(true);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
