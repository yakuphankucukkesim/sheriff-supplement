import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	membershipFrame mf=null;

	/**
	 * Create the frame.
	 */
	public SignUpFrame(membershipFrame sf) {
		mf=sf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up To Sheriff Supplements");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(87, 32, 384, 61);
		contentPane.add(lblNewLabel);
		
		txtusername = new JTextField();
		txtusername.setBounds(256, 103, 282, 29);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(256, 163, 282, 29);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(256, 221, 282, 29);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(24, 161, 97, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Password Again:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(24, 219, 197, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("UserName:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(24, 103, 97, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblpassword = new JLabel("");
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpassword.setBounds(24, 256, 514, 34);
		contentPane.add(lblpassword);
		
		JButton btnsignup = new JButton("Sign Up");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtusername.getText().isEmpty()||String.valueOf(passwordField.getPassword()).isEmpty()||String.valueOf(passwordField_1.getPassword()).isEmpty())
				{
					lblpassword.setText("Please Don't leave Empty Fields!!!!");
					txtusername.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
					
				}
				else if(!String.valueOf(passwordField.getPassword()).equalsIgnoreCase(String.valueOf(passwordField_1.getPassword()))) {
					lblpassword.setText("Passwords Do not Match Please enter Again!!!");
					passwordField.setText("");
					passwordField_1.setText("");
					}
				else {
					SupplementSys.addMembership(txtusername.getText(), String.valueOf(passwordField.getPassword()));
					mf.setVisible(true);
					dispose();
				}
			}
		});
		btnsignup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnsignup.setBounds(159, 309, 268, 49);
		contentPane.add(btnsignup);
	}

}
