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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MioloDoProduto extends JPanel {
	protected JTextField txt_cod;
	protected JTextField txt_codBarra;
	private JLabel label;
	private JLabel lblEndereo;
	private JTextField txt_categoria;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblUf;
	private JTextField tex_desc;
	private JTextField txt_und;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnDeletar;
	private JTextField txt_custo;
	private JTextField txt_mLucro;
	private JScrollPane scrollPane;
	private JTable table;

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
		
		lblEndereo = new JLabel("CATEGORIA: ");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 3;
		add(lblEndereo, gbc_lblEndereo);
		
		txt_categoria = new JTextField();
		GridBagConstraints gbc_txt_categoria = new GridBagConstraints();
		gbc_txt_categoria.gridwidth = 4;
		gbc_txt_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_txt_categoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_categoria.gridx = 1;
		gbc_txt_categoria.gridy = 3;
		add(txt_categoria, gbc_txt_categoria);
		txt_categoria.setColumns(10);
		
		lblNewLabel_1 = new JLabel("DESCRI\u00C7\u00C3O: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tex_desc = new JTextField();
		GridBagConstraints gbc_tex_desc = new GridBagConstraints();
		gbc_tex_desc.gridwidth = 4;
		gbc_tex_desc.fill = GridBagConstraints.HORIZONTAL;
		gbc_tex_desc.insets = new Insets(0, 0, 5, 0);
		gbc_tex_desc.gridx = 1;
		gbc_tex_desc.gridy = 4;
		add(tex_desc, gbc_tex_desc);
		tex_desc.setColumns(10);
		
		lblNewLabel_2 = new JLabel("UNIDADE: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txt_und = new JTextField();
		GridBagConstraints gbc_txt_und = new GridBagConstraints();
		gbc_txt_und.gridwidth = 4;
		gbc_txt_und.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_und.insets = new Insets(0, 0, 5, 0);
		gbc_txt_und.gridx = 1;
		gbc_txt_und.gridy = 5;
		add(txt_und, gbc_txt_und);
		txt_und.setColumns(10);
		
		lblUf = new JLabel("CUSTO : ");
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.EAST;
		gbc_lblUf.insets = new Insets(0, 0, 5, 5);
		gbc_lblUf.gridx = 0;
		gbc_lblUf.gridy = 6;
		add(lblUf, gbc_lblUf);
		
		txt_custo = new JTextField();
		GridBagConstraints gbc_txt_custo = new GridBagConstraints();
		gbc_txt_custo.gridwidth = 4;
		gbc_txt_custo.insets = new Insets(0, 0, 5, 0);
		gbc_txt_custo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_custo.gridx = 1;
		gbc_txt_custo.gridy = 6;
		add(txt_custo, gbc_txt_custo);
		txt_custo.setColumns(10);
		
		lblNewLabel_3 = new JLabel("MARGEM DE LUCRO: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 7;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
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
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 10;
		add(label, gbc_label);
	}

	protected void cadastrar() {
		// TODO Auto-generated method stub
		
	}

	protected void atualizar() {
		// TODO Auto-generated method stub
		
	}

	protected void deletar() {
		// TODO Auto-generated method stub
		
	}

}
