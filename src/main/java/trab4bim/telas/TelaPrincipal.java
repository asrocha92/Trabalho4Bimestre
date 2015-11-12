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

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements Sistema {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * @author Alex Santos Rocha, 02/11/2015 - 23:17:20
	 * 
	 * Comentario: depois de verificar abre a tela principal
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

		if(verfTelaAberta("Relatório das Vendas")) return;
		
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(rv);
			}			
		};
		rv.setCloseAction(a);
		tabbedPane.addTab("Relatório das Vendas", rv);
		
		SelecioneTelaAbrirIndex();
	}

	protected void abrirRelProduto() {
		TelaRelProduto rp = new TelaRelProduto();
		
		if(verfTelaAberta("Relatório do Produto")) return;
		
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(rp);
			}			
		};
		rp.setCloseAction(a);
		tabbedPane.addTab("Relatório do Produto", rp);

		SelecioneTelaAbrirIndex();
	}

	protected void abrirRelatorioCliente() {
		TelaRelCliente rc = new TelaRelCliente();
		
		if(verfTelaAberta("Relatório do Cliente")) return;
		
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(rc);
			}			
		};
		rc.setCloseAction(a);
		tabbedPane.addTab("Relatório do Cliente", rc);		

		SelecioneTelaAbrirIndex();
	}

	private void abrirCadCliente() {		
		TelaCadCliente tl = new TelaCadCliente();
		
		if(verfTelaAberta("Cadastrar Cliente")) return;
		
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tl);
			}			
		};
		tl.setCloseAction(a);
		tabbedPane.addTab("Cadastrar Cliente", tl);

		SelecioneTelaAbrirIndex();
	}
	
	protected void abrirTelaDoProd() {
		TelaCadProduto p = new TelaCadProduto();
		
		if(verfTelaAberta("Cadastrar Produto")) return;
		
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(p);
			}			
		};
		p.setCloseAction(a);
		tabbedPane.addTab("Cadastrar Produto", p);

		SelecioneTelaAbrirIndex();
	}
	
	protected void abrirTelaUsuario() {
		TelaCadUsuario u = new TelaCadUsuario();
		
		if(verfTelaAberta("Cadastrar Usuário")) return;
		
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(u);
			}			
		};
		u.setCloseAction(a);
		tabbedPane.addTab("Cadastrar Usuário", u);

		SelecioneTelaAbrirIndex();
	}	
	
	protected void abrirVenda() {
		TelaCadVenda v = new TelaCadVenda();
		
		if(verfTelaAberta("Efetuar Venda")) return;
		
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(v);
			}			
		};
		v.setCloseAction(a);

		tabbedPane.addTab("Efetuar Venda", v);

		SelecioneTelaAbrirIndex();
	}
	
	//método que deixa ser instânciado somente uma aba especifica de um tipo na tela
	public boolean verfTelaAberta(String nTabPane){
		for(int i = 0; i < tabbedPane.getTabCount(); i++){
			if(tabbedPane.getTitleAt(i).equals(nTabPane)){
				tabbedPane.setSelectedIndex(i);
				SelecioneTelaAbrirComp(i);
				return true;
			}			
		}
		return false;
	}
	
	//seleciona a tela se estiver aberta
	public void SelecioneTelaAbrirIndex(){
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() -1);
	}
	
	public void SelecioneTelaAbrirComp(int index){
		tabbedPane.setSelectedComponent(tabbedPane.getComponent(index));
	}
}
