package trab4bim.telaLogin;

/**
 * @author Alex Santos Rocha, 02/11/2015 - 22:54:49
 * 
 * Comentario tela de login
 */
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_user;
	private JTextField txt_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setBackground(new Color(0, 0, 0, .5f));
					((JPanel) frame.getContentPane()).setOpaque(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{60, 317, 0, 0};
		gbl_contentPane.rowHeights = new int[]{25, 20, 20, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSistemaGestoDe = new JLabel("Sistema Gest\u00E3o de Pe\u00E7as");
		lblSistemaGestoDe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		GridBagConstraints gbc_lblSistemaGestoDe = new GridBagConstraints();
		gbc_lblSistemaGestoDe.anchor = GridBagConstraints.NORTH;
		gbc_lblSistemaGestoDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblSistemaGestoDe.gridx = 1;
		gbc_lblSistemaGestoDe.gridy = 0;
		contentPane.add(lblSistemaGestoDe, gbc_lblSistemaGestoDe);
		
		JLabel lblLogin = new JLabel("Usu\u00E1rio: ");
		lblLogin.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 1;
		contentPane.add(lblLogin, gbc_lblLogin);
		
		txt_user = new JTextField();
		GridBagConstraints gbc_txt_user = new GridBagConstraints();
		gbc_txt_user.anchor = GridBagConstraints.NORTH;
		gbc_txt_user.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_user.insets = new Insets(0, 0, 5, 5);
		gbc_txt_user.gridx = 1;
		gbc_txt_user.gridy = 1;
		contentPane.add(txt_user, gbc_txt_user);
		txt_user.setColumns(10);
		
		JLabel lblPassord = new JLabel("Senha: ");
		lblPassord.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		GridBagConstraints gbc_lblPassord = new GridBagConstraints();
		gbc_lblPassord.anchor = GridBagConstraints.EAST;
		gbc_lblPassord.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassord.gridx = 0;
		gbc_lblPassord.gridy = 2;
		contentPane.add(lblPassord, gbc_lblPassord);
		
		txt_pass = new JTextField();
		GridBagConstraints gbc_txt_pass = new GridBagConstraints();
		gbc_txt_pass.anchor = GridBagConstraints.NORTH;
		gbc_txt_pass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_pass.insets = new Insets(0, 0, 5, 5);
		gbc_txt_pass.gridx = 1;
		gbc_txt_pass.gridy = 2;
		contentPane.add(txt_pass, gbc_txt_pass);
		txt_pass.setColumns(10);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifica();
			}
		});
		GridBagConstraints gbc_btnLogar = new GridBagConstraints();
		gbc_btnLogar.anchor = GridBagConstraints.NORTH;
		gbc_btnLogar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogar.gridx = 1;
		gbc_btnLogar.gridy = 3;
		contentPane.add(btnLogar, gbc_btnLogar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.insets = new Insets(0, 0, 0, 5);
		gbc_btnFechar.anchor = GridBagConstraints.NORTH;
		gbc_btnFechar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFechar.gridx = 1;
		gbc_btnFechar.gridy = 4;
		contentPane.add(btnFechar, gbc_btnFechar);
	}

	protected void verifica() {
		limpar();
	}
	
	private void limpar(){
		txt_user.setText("");
		txt_pass.setText("");
	}

}
