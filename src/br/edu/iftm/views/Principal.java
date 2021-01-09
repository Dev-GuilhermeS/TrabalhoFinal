package br.edu.iftm.views;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JPanel {

    private final Color cor_fundo = Color.BLACK;
    private JPanel interfaces;
    private CardLayout mudarTela;
    private JButton inicio;
    private JLabel imgLogo;
    private JLabel destaque;
    private JButton conta;
    private JLabel filme1;
    private JLabel filme2;
    private JLabel filme3;
    private JButton assistir1;
    private JButton assistir2;
    private JButton assistir3;  

    public Principal(JPanel interfaces) {
        this.interfaces = interfaces;
        this.mudarTela = (CardLayout) interfaces.getLayout();
        setBackground(cor_fundo);
        setLayout(null);
        inicializarInterface();  

    }

    private void inicializarInterface() {
        inicio = alterarCampo("Inicio", 60);
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarTela.show(interfaces, "Principal");
            }           
        });

        conta = alterarCampo("Conta", 800);
        conta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarTela.show(interfaces, "Conta");
            }           
        });
        

        assistir1 = new JButton("Assistir");
        assistir1.setBounds(30, 330, 200, 20);
        assistir1.setForeground(Color.WHITE);
        assistir1.setBackground(Color.GRAY);
        assistir1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        assistir2 = new JButton("Assistir");
        assistir2.setBounds(335, 330, 200, 20);
        assistir2.setForeground(Color.WHITE);
        assistir2.setBackground(Color.GRAY);
        assistir2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        assistir3 = new JButton("Assistir");
        assistir3.setBounds(645, 330, 200, 20);
        assistir3.setForeground(Color.WHITE);
        assistir3.setBackground(Color.GRAY);
        assistir3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        imgLogo = new JLabel("");
        ImageIcon logo = new ImageIcon(this.getClass().getResource("imagens/Logo5.png"));
        imgLogo.setIcon(logo);
        imgLogo.setBounds(3, 5, 50, 20);

        filme1 = new JLabel("");
        ImageIcon filme01 = new ImageIcon(this.getClass().getResource("imagens/A-Chefa.jpg"));
        filme1.setIcon(filme01);
        filme1.setBounds(20, 70, 245, 245);

        filme2 = new JLabel("");
        ImageIcon filme02 = new ImageIcon(this.getClass().getResource("imagens/natal.jpg"));
        filme2.setIcon(filme02);
        filme2.setBounds(310, 70, 245, 245);
        
        filme3 = new JLabel("");
        ImageIcon filme03 = new ImageIcon(this.getClass().getResource("imagens/velozes.jpg"));
        filme3.setIcon(filme03);
        filme3.setBounds(620, 70, 245, 245);

        destaque = new JLabel("Destaques");
        destaque.setBounds(7, 40, 100, 20);
        destaque.setFont(new Font("Tahoma", Font.BOLD, 16));
        destaque.setForeground(Color.white);


        add(imgLogo);
        add(filme1);
        add(filme2);
        add(filme3);
        add(destaque);
        add(inicio);
        add(conta);
        add(assistir1);
        add(assistir2);
        add(assistir3);
    }

    private JButton alterarCampo(String placeholder, int posicaoy) {
        JButton campo = new JButton(placeholder);
        campo.setBounds(posicaoy, 2, 80, 20);
        campo.setFont(new Font("Tahoma", Font.BOLD, 12));
        campo.setBackground(cor_fundo);
        campo.setForeground(Color.white);
        campo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        return campo;
    }
}