import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CartFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	SupplementFrame suf=null;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JLabel lbltotPrice;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Create the frame.
	 */
	public CartFrame(SupplementFrame mf) {
		suf=mf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplay = new JButton("DisplayCart");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(SupplementSys.displayMember());
				lbltotPrice.setText( SupplementSys.calculateTotalPrice()+"TL");
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDisplay.setBounds(442, 57, 228, 41);
		contentPane.add(btnDisplay);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 53, 289, 235);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblNewLabel = new JLabel(" Total Price ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(442, 178, 221, 28);
		contentPane.add(lblNewLabel);
		
		lbltotPrice = new JLabel("");
		lbltotPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbltotPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltotPrice.setBounds(442, 230, 221, 28);
		contentPane.add(lbltotPrice);
		
		btnNewButton = new JButton("Finish Shopping");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(31, 317, 271, 52);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Go Back to Supplement List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suf.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(361, 317, 262, 52);
		contentPane.add(btnNewButton_1);
	}

}
