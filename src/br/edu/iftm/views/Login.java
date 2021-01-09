package br.edu.iftm.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel {

    private final Color cor_fundo = Color.BLACK;
    private JPanel interfaces;
    private CardLayout mudarTela;
    private JLabel entrar;
    private JLabel imgFundo;
    private JLabel imgLogo;
    private JTextField usuario;
    private JTextField senha;
    private JButton logar;

    public Login (JPanel interfaces) {
        this.interfaces = interfaces;
        this.mudarTela = (CardLayout) interfaces.getLayout();
        setBackground(cor_fundo);
        setLayout(null);
        inicializarInterface();

    }

    private void inicializarInterface() {
        entrar = new JLabel("Entrar");
        entrar.setBounds(90, 155, 260, 20);
        entrar.setFont(new Font("Tahoma", Font.BOLD, 22));
        entrar.setForeground(Color.white);

        imgLogo = new JLabel("");
        ImageIcon logo = new ImageIcon(this.getClass().getResource("imagens/Logo4.png"));
        imgLogo.setIcon(logo);
        imgLogo.setBounds(110, 5, 150, 100);

        imgFundo = new JLabel("");
        ImageIcon fundo = new ImageIcon(this.getClass().getResource("imagens/Fundo2.jpg"));
        imgFundo.setIcon(fundo);
        imgFundo.setBounds(390, 0, 638, 436);

        usuario = alterarCampo("Email ou numero de telefone", 200);

        senha = alterarCampo("Senha", 250);

        logar = new JButton("Entrar");
        logar.setBounds(90, 330, 200, 30);
        logar.setForeground(Color.WHITE);
        logar.setBackground(Color.RED);
        logar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        logar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                
                String campousuario = usuario.getText();
                String camposenha = senha.getText();
                String mensagem = String.format("Efetuado login\n Email ou telefone: %s \n senha: %s \n", usuario, senha);
                
                try {
                    if(campousuario.equals("admin")){
                        if(camposenha.equals("1234")){
                            mudarTela.show(interfaces, "Principal");
                        }else{
                        JOptionPane.showMessageDialog(null, "Senha inválida!", "Login", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario não existe!", "Login", JOptionPane.WARNING_MESSAGE);   
                    }
                } catch (Exception j) {
                    JOptionPane.showMessageDialog(null, mensagem, "Login", JOptionPane.WARNING_MESSAGE);
                }
                
            }
            
        });

        add(imgLogo);
        add(entrar);
        add(imgFundo);
        add(usuario);
        add(senha);
        add(logar);
    }

    private JTextField alterarCampo(String placeholder, int posicaoy) {
        JTextField campo = new JTextField(placeholder);
        campo.setBounds(90, posicaoy, 200, 30);
        campo.setFont(new Font("Tahoma", Font.BOLD, 12));
        campo.setBackground(Color.GRAY);
        campo.setForeground(Color.LIGHT_GRAY);
        campo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        campo.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if(campo.getText().equals(placeholder)){
                    campo.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(campo.getText().isEmpty()){
                    campo.setText(placeholder);
                }             
            }			
		});
        return campo;
    }
    public JTextField getSenha() {
        return senha;
    }
    public void setSenha(JTextField senha) {
        this.senha = senha;
    }
    public JTextField getUsuario() {
        return usuario;
    }
    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }
 }

