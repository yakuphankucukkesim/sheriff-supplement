import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class SupplementFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	membershipFrame mf=null;
	CartFrame cf=new CartFrame(this);
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBox;
	private JRadioButton rdbtn599;
	private JRadioButton rdbtn601;
	private JCheckBox vegetarian;
	private JComboBox type;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public SupplementFrame(membershipFrame uf) {
		mf=uf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btndisplay = new JButton("DisplayAll");
		btndisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(SupplementSys.display());
			}
		});
		btndisplay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btndisplay.setBounds(389, 348, 134, 30);
		contentPane.add(btndisplay);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean size;
				boolean vegetarianx;
				if(rdbtn599.isSelected())
					size=false;
				else
					size=true;
				if(vegetarian.isSelected())
					vegetarianx=true;
				else
					vegetarianx=false;
				if(SupplementSys.SearchSupplement(comboBox.getSelectedItem().toString(),vegetarianx ,size ,type.getSelectedItem().toString())==null)
				{
					textArea.setText("There is No Supplement According to your Selections!!!");
				}
				else
				textArea.setText(SupplementSys.SearchSupplement(comboBox.getSelectedItem().toString(),vegetarianx ,size ,type.getSelectedItem().toString()).toString());
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(560, 347, 141, 30);
		contentPane.add(btnSearch);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HARDLINE", "WEIDER", "BIGJOY", "KINGSIZE"}));
		comboBox.setBounds(545, 71, 134, 30);
		contentPane.add(comboBox);
		
		rdbtn599 = new JRadioButton("-600 gr");
		rdbtn599.setSelected(true);
		rdbtn599.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(rdbtn599);
		rdbtn599.setBounds(400, 184, 103, 21);
		contentPane.add(rdbtn599);
		
		rdbtn601 = new JRadioButton("+600gr");
		rdbtn601.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonGroup.add(rdbtn601);
		rdbtn601.setBounds(558, 184, 103, 21);
		contentPane.add(rdbtn601);
		
		JLabel lblsize = new JLabel("Please Select a Size");
		lblsize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsize.setHorizontalAlignment(SwingConstants.CENTER);
		lblsize.setBounds(422, 148, 222, 30);
		contentPane.add(lblsize);
		
		vegetarian = new JCheckBox("Vegetarian");
		vegetarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vegetarian.setBounds(445, 221, 153, 30);
		contentPane.add(vegetarian);
		
		type = new JComboBox();
		type.setFont(new Font("Tahoma", Font.PLAIN, 15));
		type.setModel(new DefaultComboBoxModel(new String[] {"ProteinPowder", "AminoAcid", "Carnitine", "Creatine"}));
		type.setBounds(550, 277, 169, 39);
		contentPane.add(type);
		
		JLabel lblNewLabel = new JLabel("Please select a type of Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(345, 269, 199, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please Select A Brand");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(334, 67, 200, 38);
		contentPane.add(lblNewLabel_1);
		
		JButton btnaddtocart = new JButton("Add To Cart");
		btnaddtocart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean size;
				boolean vegetarianx;
				if(rdbtn599.isSelected())
					size=false;
				else
					size=true;
				if(vegetarian.isSelected())
					vegetarianx=true;
				else
					vegetarianx=false;
				if(SupplementSys.SearchSupplement(comboBox.getSelectedItem().toString(),vegetarianx ,size ,type.getSelectedItem().toString())==null)
				{
					textArea.setText("Supplement did'nt added to the cart !!!");
				}
				else
				{
					SupplementSys.addtocart(SupplementSys.SearchSupplement(comboBox.getSelectedItem().toString(),vegetarianx ,size ,type.getSelectedItem().toString()));
				}
			}
		});
		btnaddtocart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnaddtocart.setBounds(10, 455, 153, 39);
		contentPane.add(btnaddtocart);
		
		JButton btnCart = new JButton("Go To Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setVisible(true);
				dispose();
			}
		});
		btnCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCart.setBounds(464, 412, 237, 39);
		contentPane.add(btnCart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 51, 263, 313);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnremove = new JButton("Remove From Cart");
		btnremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean size;
				boolean vegetarianx;
				if(rdbtn599.isSelected())
					size=false;
				else
					size=true;
				if(vegetarian.isSelected())
					vegetarianx=true;
				else
					vegetarianx=false;
				if(SupplementSys.SearchSupplement(comboBox.getSelectedItem().toString(),vegetarianx ,size ,type.getSelectedItem().toString())==null)
				{
					textArea.setText("There is No Supplement According to your Selections!!!");
				}
				else if(SupplementSys.removeFromCart(comboBox.getSelectedItem().toString(),vegetarianx ,size ,type.getSelectedItem().toString()))
				{
					textArea.setText("Selected Item is Removed From Cart!!!");
				}
				else
				{
					textArea.setText("Selected Item is not in your cart already!!!");
				}
			}
		});
		btnremove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnremove.setBounds(173, 454, 214, 39);
		contentPane.add(btnremove);
		
		JButton btnNewButton = new JButton("Calculate Price Per Serving");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplementSys.calculatePricePerServing();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(51, 384, 291, 52);
		contentPane.add(btnNewButton);
	}
}
