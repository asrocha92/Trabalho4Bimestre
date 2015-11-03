package trab4bim.telas;
/**
 * @author Alex Santos Rocha, 31/10/2015 - 10:21:34
 * 
 * Comentario: tela principal para chamar telas interna do sistema no frame
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import trab4bim.telaLogin.Sistema;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame implements Sistema {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * @author Alex Santos Rocha, 02/11/2015 - 23:17:20
	 * 
	 * Comentario: depois de ferificar abre a tela principal
	 * 
	 */
	
	@Override
	public void abrir(String user, String pass) {
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
		mntmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaUsuario();
			}
		});
		mnCadastro.add(mntmUsurio);
		
		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);
		
		JMenuItem mntmEfetuarVenda = new JMenuItem("Efetuar venda");
		mntmEfetuarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVenda();
			}
		});
		mnVenda.add(mntmEfetuarVenda);
		
		JMenu mnRelattio = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelattio);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirRelatorioCliente();
			}
		});
		mnRelattio.add(mntmCliente_1);
		
		JMenuItem mntmProduto_1 = new JMenuItem("Produto");
		mntmProduto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirRelProduto();
			}
		});
		mnRelattio.add(mntmProduto_1);
		
		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirRelvenda();
			}
		});
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

	protected void abrirRelvenda() {
		TelaRelVenda rv = new TelaRelVenda();
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(rv);
			}			
		};
		rv.setCloseAction(a);
		tabbedPane.addTab("Relatório do Produto ", rv);
	}

	protected void abrirRelProduto() {
		TelaRelProduto rp = new TelaRelProduto();
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(rp);
			}			
		};
		rp.setCloseAction(a);
		tabbedPane.addTab("Relatório do Produto ", rp);
	}

	protected void abrirRelatorioCliente() {
		TelaRelCliente rc = new TelaRelCliente();
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(rc);
			}			
		};
		rc.setCloseAction(a);
		tabbedPane.addTab("Relatório do Cliente ", rc);		
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
	
	protected void abrirTelaUsuario() {
		TelaCadUsuario u = new TelaCadUsuario();
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(u);
			}			
		};
		u.setCloseAction(a);
		tabbedPane.addTab("Cadastro de Usuário ", u);
	}	
	
	protected void abrirVenda() {
		TelaCadVenda v = new TelaCadVenda();
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(v);
			}			
		};
		v.setCloseAction(a);
		tabbedPane.addTab("Vendas ", v);
	}
	
}
