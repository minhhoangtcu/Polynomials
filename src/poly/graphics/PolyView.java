package poly.graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class PolyView extends JFrame {

	private JPanel contentPane;
	private MainMenu main;
	private JTextField textFieldPolyInput;

	/**
	 * Create the frame.
	 */
	public PolyView(MainMenu main) {
		this.main = main; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel input = new JPanel();
		contentPane.add(input, BorderLayout.NORTH);
		input.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		input.add(lblInput, BorderLayout.NORTH);
		
		JPanel panelInput = new JPanel();
		input.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPleaseInsertThe = new JLabel("Please insert the polynomials in the form of: x^2*y^5*z^10");
		panelInput.add(lblPleaseInsertThe);
		lblPleaseInsertThe.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldPolyInput = new JTextField();
		panelInput.add(textFieldPolyInput);
		textFieldPolyInput.setColumns(45);
		
		JButton btnSave = new JButton("Save");
		panelInput.add(btnSave);
		
		JPanel output = new JPanel();
		contentPane.add(output, BorderLayout.SOUTH);
	}

}
