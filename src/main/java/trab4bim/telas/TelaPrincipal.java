package trab4bim.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 363);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirCadCliente();
			}

		});
		mnCadastro.add(mntmCliente);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaDoProd();
			}
		});
		mnCadastro.add(mntmProduto);
		
		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mnCadastro.add(mntmUsurio);
		
		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);
		
		JMenuItem mntmEfetuarVenda = new JMenuItem("Efetuar venda");
		mnVenda.add(mntmEfetuarVenda);
		
		JMenu mnRelattio = new JMenu("Relat\u00F3tio");
		menuBar.add(mnRelattio);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mnRelattio.add(mntmCliente_1);
		
		JMenuItem mntmProduto_1 = new JMenuItem("Produto");
		mnRelattio.add(mntmProduto_1);
		
		JMenuItem mntmVenda = new JMenuItem("Venda");
		mnRelattio.add(mntmVenda);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(0, 255, 127));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}


	private void abrirCadCliente() {		
		TelaCadCliente tl = new TelaCadCliente();
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tl);
			}			
		};
		tl.setCloseAction(a);
		tabbedPane.addTab("Cadastro de Cliente ", tl);
	}
	
	protected void abrirTelaDoProd() {
		TelaCadProduto p = new TelaCadProduto();
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(p);
			}			
		};
		p.setCloseAction(a);
		tabbedPane.addTab("Cadastro de Produto ", p);
	}
	
}
