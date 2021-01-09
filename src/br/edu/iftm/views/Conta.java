package br.edu.iftm.views;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conta extends JPanel {

    private final Color cor_fundo = Color.BLACK;
    private JPanel interfaces;
    private CardLayout mudarTela;
    private JButton inicio;
    private JButton editar;
    private JLabel imgLogo;
    private JLabel avatar;
    private JLabel informacao;  
    private JLabel usuario;
    private JTextField infoUsuario;
    private JLabel senha;
    private JTextField infoSenha;

    public Conta(JPanel interfaces) {
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

        imgLogo = new JLabel("");
        ImageIcon logo = new ImageIcon(this.getClass().getResource("imagens/Logo5.png"));
        imgLogo.setIcon(logo);
        imgLogo.setBounds(3, 5, 50, 20);

        avatar = new JLabel("");
        ImageIcon avatarUsuario = new ImageIcon(this.getClass().getResource("imagens/avatar.jpg"));
        avatar.setIcon(avatarUsuario);
        avatar.setBounds(200, 80, 150, 100);

        informacao = new JLabel("Informações do usuário");
        informacao.setBounds(7, 40, 250, 20);
        informacao.setFont(new Font("Tahoma", Font.BOLD, 16));
        informacao.setForeground(Color.white);

        usuario = new JLabel("Usuario:");
        usuario.setBounds(7, 80, 250, 20);
        usuario.setFont(new Font("Tahoma", Font.BOLD, 14));
        usuario.setForeground(Color.white);

        infoUsuario = new JTextField("admin");
        infoUsuario.setBounds(70, 80, 60, 20);
        infoUsuario.setForeground(Color.WHITE);
        infoUsuario.setBackground(Color.GRAY);
        infoUsuario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        senha = new JLabel("senha:");
        senha.setBounds(7, 120, 250, 20);
        senha.setFont(new Font("Tahoma", Font.BOLD, 14));
        senha.setForeground(Color.white);

        infoSenha = new JTextField("1234");
        infoSenha.setBounds(60, 120, 60, 20);
        infoSenha.setForeground(Color.WHITE);
        infoSenha.setBackground(Color.GRAY);
        infoSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        editar = new JButton("Editar");
        editar.setBounds(230, 200, 80, 20);
        editar.setForeground(Color.WHITE);
        editar.setBackground(Color.GRAY);
        editar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));


        add(imgLogo);
        add(avatar);
        add(informacao);
        add(usuario);
        add(senha);
        add(inicio);
        add(editar);
        add(infoUsuario);
        add(infoSenha);
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