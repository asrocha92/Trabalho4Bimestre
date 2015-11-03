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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_user;
	private JPasswordField txt_pass;
	private FundoDaTelaLogin frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setBackground(new Color(0, 0, 0, .8f));
					((JPanel) frame.getContentPane()).setOpaque(false);
					frame.setLocationRelativeTo(null);
//					frame.setEnabled(false);
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{317, 0};
		gbl_contentPane.rowHeights = new int[]{25, 20, 0, 20, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLogin = new JLabel("Usu\u00E1rio: ");
		lblLogin.setForeground(Color.GREEN);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 0;
		contentPane.add(lblLogin, gbc_lblLogin);
		
		txt_user = new JTextField();
		GridBagConstraints gbc_txt_user = new GridBagConstraints();
		gbc_txt_user.fill = GridBagConstraints.BOTH;
		gbc_txt_user.insets = new Insets(0, 0, 5, 0);
		gbc_txt_user.gridx = 0;
		gbc_txt_user.gridy = 1;
		contentPane.add(txt_user, gbc_txt_user);
		txt_user.setColumns(10);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifica();
			}
		});
		
		JLabel lblPassord = new JLabel("Senha: ");
		lblPassord.setForeground(Color.GREEN);
		lblPassord.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblPassord = new GridBagConstraints();
		gbc_lblPassord.fill = GridBagConstraints.VERTICAL;
		gbc_lblPassord.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassord.gridx = 0;
		gbc_lblPassord.gridy = 2;
		contentPane.add(lblPassord, gbc_lblPassord);
		
		txt_pass = new JPasswordField();
		GridBagConstraints gbc_txt_pass = new GridBagConstraints();
		gbc_txt_pass.fill = GridBagConstraints.BOTH;
		gbc_txt_pass.insets = new Insets(0, 0, 5, 0);
		gbc_txt_pass.gridx = 0;
		gbc_txt_pass.gridy = 3;
		
		contentPane.add(txt_pass, gbc_txt_pass);
		GridBagConstraints gbc_btnLogar = new GridBagConstraints();
		gbc_btnLogar.fill = GridBagConstraints.BOTH;
		gbc_btnLogar.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogar.gridx = 0;
		gbc_btnLogar.gridy = 4;
		contentPane.add(btnLogar, gbc_btnLogar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame1.dispose();
				dispose();
			}
		});
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.fill = GridBagConstraints.BOTH;
		gbc_btnFechar.gridx = 0;
		gbc_btnFechar.gridy = 5;
		contentPane.add(btnFechar, gbc_btnFechar);
		
		frame1 = new FundoDaTelaLogin();
		frame1.setUndecorated(true);
		frame1.setBackground(new Color(0, 0, 0, .9f));
		((JPanel) frame1.getContentPane()).setOpaque(false);
		frame1.setLocationRelativeTo(null);
		frame1.setExtendedState(MAXIMIZED_BOTH);
		frame1.setEnabled(false);
		frame1.setVisible(true);
	}

	protected void verifica() {
		try {
			new SistemaProxy(txt_user.getText(), new String(txt_pass.getPassword()));
			this.dispose();
			frame1.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuário ou senha\nINCORRETOS");
			limpar();
			txt_user.setFocusable(true);
		}
	}
	
	private void limpar(){
		txt_user.setText("");
		txt_pass.setText("");
	}

}
