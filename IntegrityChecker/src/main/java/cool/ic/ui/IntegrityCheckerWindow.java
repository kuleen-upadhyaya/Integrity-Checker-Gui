package cool.ic.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		createComponents();
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

	private void createComponents() 
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
		
		pnlProgress.add(pbrOverall);
		pnlProgress.add(pbrIndiv);
		
		pnlStatus.add(pnlProgress);
		
		pnlSouth.add(pnlStatus);
		
		add(pnlSouth, BorderLayout.SOUTH);
		
		addActionListeners();
	}

	private void addActionListeners() 
	{
		btnStartCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if (btnStartCancel.getText().equals("Start"))
				{
					btnStartCancel.setText("Cancel");
				}
				else if (btnStartCancel.getText().equals("Cancel"))
				{
					btnStartCancel.setText("Start");
				}
			}
		});
	}

	public static void start() 
	{
		icw = new IntegrityCheckerWindow();
		icw.setVisible(true);
	}
}
