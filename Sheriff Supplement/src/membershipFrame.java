import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;

public class membershipFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	SignUpFrame suf=new SignUpFrame(this);
	SupplementFrame uf=new SupplementFrame(this);
	private JLabel lbl;
	/**
	 * Create the frame.
	 */
	
	
	 
	public membershipFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Sheriff Supplements");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 40, 332, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtusername.getText().isEmpty()||String.valueOf(passwordField.getPassword()).isEmpty())
				{
					lbl.setText("Please Don't Leave Any Empty Fields!!!");
				}
				else if(SupplementSys.bonusOrNot(txtusername.getText(),String.valueOf(passwordField.getPassword())))
				{
				 uf.setVisible(true);
				  dispose();
					}
					else {
						lbl.setText("Please Check if your username or password is correct!!");
					}
				
			}
		});
		btnlogin.setBounds(64, 298, 156, 50);
		contentPane.add(btnlogin);
		
		
		JButton btnsignup = new JButton("Sign Up");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suf.setVisible(true);
				dispose();
			}
		});
		btnsignup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnsignup.setBounds(373, 298, 156, 50);
		contentPane.add(btnsignup);
		
		JLabel lblNewLabel_1 = new JLabel("Don't Have an account? Sign Up.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(334, 261, 215, 27);
		contentPane.add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setBounds(205, 123, 275, 27);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("UserName:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(76, 120, 97, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(76, 177, 97, 27);
		contentPane.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			        if (e.getKeyCode()==KeyEvent.VK_ENTER){
			        	if(txtusername.getText().isEmpty()||String.valueOf(passwordField.getPassword()).isEmpty())
						{
							lbl.setText("Please Don't Leave Any Empty Fields!!!");
						}
						else if(SupplementSys.bonusOrNot(txtusername.getText(),String.valueOf(passwordField.getPassword())))
						{
						 uf.setVisible(true);
						  dispose();
							}
							else {
								lbl.setText("Please Check if your username or password is correct!!");
							}
			        }}
			
		});
		passwordField.setBounds(205, 177, 275, 27);
		contentPane.add(passwordField);
		
		lbl = new JLabel("");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl.setBounds(86, 214, 394, 27);
		contentPane.add(lbl);
	}
}
