/*
 * The view is the front-end.
 */
package poly.graphics;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

@SuppressWarnings("serial")
public class PolyView extends JFrame {
	
	// Set up references to other components
	private MainMenu main;
	private PolyModel model;
	
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldZ;
	private JTextField textFieldArithmeticResult;
	private Object[] tableDataColNames;
	private Object[][] tableDataColData;
	
	// A set of components that we want to give access to the controller
	JTable tableData;
	JButton btnSave, btnEvaluate, btnDisplay, btnDelete;
	JPanel panelEvaluate, panelDisplay;
	JLabel lblDisplay, lblArithFeedback, lblInputFeedback;

	/**
	 * Create the frame.
	 */
	public PolyView(MainMenu mainMenu) {
		main = mainMenu;
		model = main.model;
		
		// Set up the main menu
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[774px]", "[130.00px][219.00px][172.00px]"));
		
		
		
		// INPUT SECTION
		JPanel input = new JPanel();
		contentPane.add(input, "cell 0 0,grow");
		input.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setBackground(Color.LIGHT_GRAY);
		lblInput.setOpaque(true);
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		input.add(lblInput, BorderLayout.NORTH);
		
		JPanel panelInput = new JPanel();
		input.add(panelInput, BorderLayout.CENTER);
		panelInput.setLayout(new MigLayout("", "[684.00px][100.00px]", "[20px][23px][21.00]"));
		
		JLabel lblInputInstruction = new JLabel("Please insert the polynomials in the form of: x^2*y^5*z^10");
		lblInputInstruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelInput.add(lblInputInstruction, "cell 0 0 2 1,alignx center,aligny center");
		lblInputInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField textFieldPolyInput;
		textFieldPolyInput = new JTextField();
		panelInput.add(textFieldPolyInput, "cell 0 1,alignx right,aligny center");
		textFieldPolyInput.setColumns(80);
		
		btnSave = new JButton("Save");
		panelInput.add(btnSave, "cell 1 1,alignx left,aligny top");
		
		lblInputFeedback = new JLabel("Feedback");
		lblInputFeedback.setVisible(false);
		lblInputFeedback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelInput.add(lblInputFeedback, "cell 0 2 2 1,alignx center");
		lblInputFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel output = new JPanel();
		contentPane.add(output, "cell 0 1,grow");
		output.setLayout(new BorderLayout(0, 0));
		
		
		
		//DATABASE SECTION
		// DATABASE> LEFT SIDE
		JLabel lblDatabase = new JLabel("DATABASE");
		lblDatabase.setOpaque(true);
		lblDatabase.setBackground(Color.LIGHT_GRAY);
		lblDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 25));
		output.add(lblDatabase, BorderLayout.NORTH);
		
		tableDataColNames = new Object[2];
		tableDataColNames[0] = "ID";
		tableDataColNames[1] = "Polynomials";
		tableDataColData = model.getData();	
		
		JPanel panelData = new JPanel();
		output.add(panelData, BorderLayout.CENTER);
		panelData.setLayout(new GridLayout(0, 2, 0, 0));
		tableData = new JTable(tableDataColData, tableDataColNames);
		tableData.setFillsViewportHeight(true);
		output.add(tableData, BorderLayout.SOUTH);
		
		JScrollPane scrollData = new JScrollPane(tableData);
		panelData.add(scrollData);
		
		
		// DATABASE> RIGHT SIDE
		JPanel panelDatabaseCommands = new JPanel();
		panelData.add(panelDatabaseCommands);
		panelDatabaseCommands.setLayout(new MigLayout("", "[89.00px][73.00px][133.00px][92.00px]", "[34px][23px][33px][34.00px][]"));
		
		JLabel lblDataCommandsInstruction = new JLabel("<html><center>Please choose a polynomial from the list on the left and<br> choose the following command</center></html>");
		lblDataCommandsInstruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataCommandsInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatabaseCommands.add(lblDataCommandsInstruction, "cell 0 0 4 1,alignx center,aligny top");
		
		JPanel panelCommands = new JPanel();
		panelDatabaseCommands.add(panelCommands, "cell 0 1 4 1,alignx center,aligny top");
		panelCommands.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnDelete = new JButton("Delete");
		panelCommands.add(btnDelete);
		
		btnDisplay = new JButton("Display");
		panelCommands.add(btnDisplay);
		
		btnEvaluate = new JButton("Evaluate");
		panelCommands.add(btnEvaluate);
		
		panelDisplay = new JPanel();
		panelDatabaseCommands.add(panelDisplay, "cell 0 2 4 1,alignx center,aligny center");
		panelDisplay.setVisible(false);
		
		lblDisplay = new JLabel("Displaying: ");
		panelDisplay.add(lblDisplay);
		
		panelEvaluate = new JPanel();
		panelDatabaseCommands.add(panelEvaluate, "cell 0 3 4 1,alignx center,aligny top");
		panelEvaluate.setLayout(new GridLayout(0, 1, 0, 0));
		panelEvaluate.setVisible(false);
		
		JPanel panelInputXYZ = new JPanel();
		panelEvaluate.add(panelInputXYZ);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the value of x, y, z");
		panelInputXYZ.add(lblPleaseEnterThe);
		
		textFieldX = new JTextField();
		panelInputXYZ.add(textFieldX);
		textFieldX.setColumns(2);
		
		textFieldY = new JTextField();
		panelInputXYZ.add(textFieldY);
		textFieldY.setColumns(2);
		
		textFieldZ = new JTextField();
		panelInputXYZ.add(textFieldZ);
		textFieldZ.setColumns(2);
		
		JButton btnSolve = new JButton("Solve");
		panelInputXYZ.add(btnSolve);
		
		JLabel lblResult = new JLabel("Result: ");
		panelEvaluate.add(lblResult);
		
		JButton btnLoadDatabase = new JButton("Load Database");
		panelDatabaseCommands.add(btnLoadDatabase, "cell 1 4 1 1,alignx center,aligny top");
		
		JButton btnNewButton = new JButton("Save Database");
		panelDatabaseCommands.add(btnNewButton, "cell 2 4 1 1,alignx center,aligny top");
		
		
		
		// ARITHMETIC SECTION
		JPanel arithmetic = new JPanel();
		contentPane.add(arithmetic, "cell 0 2,grow");
		arithmetic.setLayout(new MigLayout("", "[760px]", "[][][71.00px][]"));
		
		JLabel lblArithmetic = new JLabel("Arithmetic");
		lblArithmetic.setBackground(Color.LIGHT_GRAY);
		lblArithmetic.setOpaque(true);
		lblArithmetic.setHorizontalAlignment(SwingConstants.CENTER);
		lblArithmetic.setFont(new Font("Tahoma", Font.PLAIN, 25));
		arithmetic.add(lblArithmetic, "cell 0 0,grow");
		
		JPanel panelArithmeticDecision = new JPanel();
		arithmetic.add(panelArithmeticDecision, "cell 0 1,grow");
		
		JLabel lblChooseFirstPolynomial = new JLabel("Choose first polynomial");
		panelArithmeticDecision.add(lblChooseFirstPolynomial);
		
		JComboBox<String> comboBoxFirst = new JComboBox<String>();
		panelArithmeticDecision.add(comboBoxFirst);
		
		JLabel lblChooseSecondPolynomial = new JLabel("Choose second polynomial");
		panelArithmeticDecision.add(lblChooseSecondPolynomial);
		
		JComboBox<String> comboBoxSecond = new JComboBox<String>();
		panelArithmeticDecision.add(comboBoxSecond);
		
		JButton btnAdd = new JButton("Add");
		panelArithmeticDecision.add(btnAdd);
		
		JButton btnSubstract = new JButton("Substract");
		panelArithmeticDecision.add(btnSubstract);
		
		JButton btnMultiply = new JButton("Multiply");
		panelArithmeticDecision.add(btnMultiply);
		
		textFieldArithmeticResult = new JTextField();
		arithmetic.add(textFieldArithmeticResult, "cell 0 2,grow");
		textFieldArithmeticResult.setColumns(10);
		
		lblArithFeedback = new JLabel("Feedback");
		lblArithFeedback.setVisible(false);
		lblArithFeedback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		arithmetic.add(lblArithFeedback, "cell 0 3,alignx center,aligny center");
	}
}
