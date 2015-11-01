package trab4bim.telas;

/**
 * @author Alex Santos Rocha, 31/10/2015 - 21:04:37
 * 
 * Comentario: tela de configuração da tela de cadastro de produto.
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import trab4bim.Dao.DaoCliente;
import trab4bim.Dao.DaoProduto;
import trab4bim.classes.Cliente;
import trab4bim.classes.Estado;
import trab4bim.classes.Genero;
import trab4bim.classes.Produto;
import trab4bim.tabelas.TableCliente;
import trab4bim.tabelas.TableProduto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MioloDoProduto extends JPanel {
	protected JTextField txt_cod;
	protected JTextField txt_codBarra;
	private JTextField txt_categoria;
	private JTextField txt_desc;
	private JTextField txt_und;
	private JTextField txt_custo;
	private JTextField txt_mLucro;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnDeletar;
	private JTable table;
	
	private TableProduto tableProduto;
	private DaoProduto p = new DaoProduto();
	private List<Produto> listaP = new ArrayList<>();
	private int indece = -1;

	/**
	 * Create the panel.
	 */
	public MioloDoProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{116, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("C\u00D3DIGO: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		txt_cod = new JTextField();
		GridBagConstraints gbc_txt_cod = new GridBagConstraints();
		gbc_txt_cod.gridwidth = 4;
		gbc_txt_cod.insets = new Insets(0, 0, 5, 0);
		gbc_txt_cod.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_cod.gridx = 1;
		gbc_txt_cod.gridy = 1;
		add(txt_cod, gbc_txt_cod);
		txt_cod.setColumns(10);
		txt_cod.enable(false);
		
		JLabel lblNewLabel = new JLabel("C\u00D3D_BARRA: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txt_codBarra = new JTextField();
		GridBagConstraints gbc_txt_codBarra = new GridBagConstraints();
		gbc_txt_codBarra.gridwidth = 4;
		gbc_txt_codBarra.insets = new Insets(0, 0, 5, 0);
		gbc_txt_codBarra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_codBarra.gridx = 1;
		gbc_txt_codBarra.gridy = 2;
		add(txt_codBarra, gbc_txt_codBarra);
		txt_codBarra.setColumns(10);
		
		JLabel lblcategoria = new JLabel("CATEGORIA: ");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 3;
		add(lblcategoria, gbc_lblCategoria);
		
		txt_categoria = new JTextField();
		GridBagConstraints gbc_txt_categoria = new GridBagConstraints();
		gbc_txt_categoria.gridwidth = 4;
		gbc_txt_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_txt_categoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_categoria.gridx = 1;
		gbc_txt_categoria.gridy = 3;
		add(txt_categoria, gbc_txt_categoria);
		txt_categoria.setColumns(10);
		
		JLabel lblDescriacao = new JLabel("DESCRI\u00C7\u00C3O: ");
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.EAST;
		gbc_lblDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescricao.gridx = 0;
		gbc_lblDescricao.gridy = 4;
		add(lblDescriacao, gbc_lblDescricao);
		
		txt_desc = new JTextField();
		GridBagConstraints gbc_txt_desc = new GridBagConstraints();
		gbc_txt_desc.gridwidth = 4;
		gbc_txt_desc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_desc.insets = new Insets(0, 0, 5, 0);
		gbc_txt_desc.gridx = 1;
		gbc_txt_desc.gridy = 4;
		add(txt_desc, gbc_txt_desc);
		txt_desc.setColumns(10);
		
		JLabel lblUnidade = new JLabel("UNIDADE: ");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 5;
		add(lblUnidade, gbc_lblUnidade);
		
		txt_und = new JTextField();
		GridBagConstraints gbc_txt_und = new GridBagConstraints();
		gbc_txt_und.gridwidth = 4;
		gbc_txt_und.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_und.insets = new Insets(0, 0, 5, 0);
		gbc_txt_und.gridx = 1;
		gbc_txt_und.gridy = 5;
		add(txt_und, gbc_txt_und);
		txt_und.setColumns(10);
		
		JLabel lblCusto = new JLabel("CUSTO : ");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 6;
		add(lblCusto, gbc_lblCusto);
		
		txt_custo = new JTextField();
		GridBagConstraints gbc_txt_custo = new GridBagConstraints();
		gbc_txt_custo.gridwidth = 4;
		gbc_txt_custo.insets = new Insets(0, 0, 5, 0);
		gbc_txt_custo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_custo.gridx = 1;
		gbc_txt_custo.gridy = 6;
		add(txt_custo, gbc_txt_custo);
		txt_custo.setColumns(10);
		
		JLabel lblNewMLucro = new JLabel("MARGEM DE LUCRO: ");
		GridBagConstraints gbc_lblMLucro = new GridBagConstraints();
		gbc_lblMLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMLucro.gridx = 0;
		gbc_lblMLucro.gridy = 7;
		add(lblNewMLucro, gbc_lblMLucro);
		
		txt_mLucro = new JTextField();
		GridBagConstraints gbc_txt_mLucro = new GridBagConstraints();
		gbc_txt_mLucro.gridwidth = 4;
		gbc_txt_mLucro.insets = new Insets(0, 0, 5, 0);
		gbc_txt_mLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_mLucro.gridx = 1;
		gbc_txt_mLucro.gridy = 7;
		add(txt_mLucro, gbc_txt_mLucro);
		txt_mLucro.setColumns(10);
		
		btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("ATUALIZAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 8;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar();
			}
		});
		GridBagConstraints gbc_btnDeletar = new GridBagConstraints();
		gbc_btnDeletar.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeletar.gridx = 4;
		gbc_btnDeletar.gridy = 8;
		add(btnDeletar, gbc_btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		// click duplo para alterar o cliente
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent evt) {
						if (evt.getClickCount() == 2) {
							Produto p = (Produto) listaP.get(table.getSelectedRow());
							returnCliente(p);
							indece = table.getSelectedRow();
						}
					}
				});
		scrollPane.setViewportView(table);
		
		// iniciar conexão 
		p.getCon();
		//listar todos os clientes na table
		listaDeCliente();
		
	}

	// lista dados armazenados no banco na table
	public void listaDeCliente() {
		new Thread(new Runnable() {			
			@Override
			public void run() {
				tableProduto = new TableProduto();
				listaP = tableProduto.listar();
				table.setModel(tableProduto);		
			}
		}).start();
	}

	protected void cadastrar() {
		Produto produto = new Produto(Integer.parseInt(txt_codBarra.getText()), 
				txt_categoria.getText(),
				txt_desc.getText(),
				txt_und.getText(),
				BigDecimal.valueOf(Double.parseDouble(txt_custo.getText())),
				BigDecimal.valueOf(Double.parseDouble(txt_mLucro.getText()))
				);
		p.inserir(produto);
		tableProduto.adicionarLista(produto);
		limpar();
	}

	protected void atualizar() {
		if (indece > -1) {
			Produto produto = new Produto(Integer.parseInt(txt_cod.getText()),
					Integer.parseInt(txt_codBarra.getText()), 
					txt_categoria.getText(),
					txt_desc.getText(),
					txt_und.getText(),
					BigDecimal.valueOf(Double.parseDouble(txt_custo.getText())),
					BigDecimal.valueOf(Double.parseDouble(txt_mLucro.getText()))
					);
			p.atualizar(produto);
			tableProduto.atualizarLista(indece, produto);
			limpar();
			indece = -1;
		}else{
			JOptionPane.showMessageDialog(null, "Selecio um produto para editar!");
		}
	}

	protected void deletar() {
		p.deletar(table.getSelectedRow());
		tableProduto.deletar(table.getSelectedRow());
	}

	public void returnCliente(Produto p) {
		txt_cod.setText(String.valueOf(p.getCod()));
		txt_codBarra.setText(String.valueOf(p.getCodBarra()));
		txt_categoria.setText(p.getCategoria());
		txt_desc.setText(p.getDescricao());
		txt_und.setText(p.getUnidade());
		txt_custo.setText(String.valueOf(p.getCusto()));
		txt_mLucro.setText(String.valueOf(p.getMargenLucro()));
	}

	public void limpar() {
		txt_cod.setText("");
		txt_codBarra.setText("");
		txt_categoria.setText("");
		txt_desc.setText("");
		txt_und.setText("");
		txt_custo.setText("");
		txt_mLucro.setText("");
	}

}
