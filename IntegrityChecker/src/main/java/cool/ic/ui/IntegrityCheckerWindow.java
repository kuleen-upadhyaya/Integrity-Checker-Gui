package cool.ic.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class IntegrityCheckerWindow extends JFrame 
{
	private static IntegrityCheckerWindow icw;
	private JComboBox<File> cbDriveList;
	private JButton btnStartCancel;
	private JTextArea txtLog;
	private JLabel lblStatus;
	private JProgressBar pbrOverall;
	private JProgressBar pbrIndiv;
	
	private IntegrityCheckerWindow()
	{
		super("Integrity Checker");
		
		setLayout(new BorderLayout());

		createNorthComponents();
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

	private void createNorthComponents() 
	{
		JPanel pnlNorth = new JPanel(new GridLayout(2,1));
		
		pnlNorth.add(new JLabel("Integrity Checker"));
		
		JPanel pnlNorth1 = new JPanel(new GridLayout(1,3));
		pnlNorth1.add(new JLabel("Select Drive : "));
		
		cbDriveList = new JComboBox<File>(File.listRoots());
		pnlNorth1.add(cbDriveList);
		
		btnStartCancel = new JButton("Start");
		pnlNorth1.add(btnStartCancel);
		
		pnlNorth.add(pnlNorth1);
		add(pnlNorth, BorderLayout.NORTH);
		
		txtLog = new JTextArea(20, 80);
		add(txtLog, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel(new GridLayout(1,2));
		JPanel pnlStatus = new JPanel(new GridLayout(1,2));
		
		lblStatus = new JLabel();
		
		pnlStatus.add(new JLabel("Status : "));
		pnlStatus.add(lblStatus);
		
		pnlSouth.add(pnlStatus);
		
		JPanel pnlProgress = new JPanel(new GridLayout(1,2));
		
		pbrOverall = new JProgressBar(0, 100);
		pbrIndiv = new JProgressBar(0,100);
		
		pbrIndiv.setStringPainted(true);
		pbrOverall.setStringPainted(true);
		
		pnlStatus.add(pbrOverall);
		pnlStatus.add(pbrIndiv);
		
		pnlSouth.add(pnlStatus);
		
		add(pnlSouth, BorderLayout.SOUTH);
		
		addActionListeners();
	}

	private void addActionListeners() 
	{
		
	}

	public static void start() 
	{
		icw = new IntegrityCheckerWindow();
		icw.setVisible(true);
	}
}
