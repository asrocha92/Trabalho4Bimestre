package trab4bim.telaLogin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FundoDaTelaLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FundoDaTelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lb_img = new JLabel("");
		lb_img.setIcon(new ImageIcon("C:\\Users\\Alex\\git\\Trabalho4Bimestre\\src\\main\\resources\\imagem\\ENG.jpg"));
		GridBagConstraints gbc_lb_img = new GridBagConstraints();
		gbc_lb_img.gridx = 0;
		gbc_lb_img.gridy = 0;
		contentPane.add(lb_img, gbc_lb_img);
	}

}
