package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;

public class PrincipalView{
	private JFrame frmPrincipalView;
	private JPanel principalMain;
	private JPanel configurationPanel;
	private JButton btnPlay;
	private JButton btnConfiguration;
	private JButton btnAccept;
	private JTextField textFieldUp;
	private JTextField textFieldDown;
	private JTextField textFieldLeft;
	private JTextField textFieldRight;

	public PrincipalView() {
		frmPrincipalView = new JFrame();
		frmPrincipalView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipalView.setBounds(100, 100, 600, 500);
		frmPrincipalView.setResizable(false);
		frmPrincipalView.setLocationRelativeTo(null);
		frmPrincipalView.setUndecorated(true);
		frmPrincipalView.setFocusable(true);
		principalMain = new JPanel();
		principalMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		principalMain.setBackground(Color.lightGray);
		frmPrincipalView.setContentPane(principalMain);
		principalMain.setVisible(false);
		principalMain.setLayout(null);
		
		configurationPanel = new JPanel();
		configurationPanel.setBounds(50, 50, 500, 350);
		principalMain.add(configurationPanel);
		configurationPanel.setVisible(false);
		configurationPanel.setLayout(null);
		
		btnAccept = new JButton("Accept");
		btnAccept.setBounds(210, 300, 89, 23);
		configurationPanel.add(btnAccept);
		
		JLabel lblMovement = new JLabel("Movement player 1:");
		lblMovement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMovement.setBounds(10, 11, 142, 14);
		configurationPanel.add(lblMovement);
		
		JLabel lblUp = new JLabel("Up:");
		lblUp.setBounds(10, 36, 46, 14);
		configurationPanel.add(lblUp);
		
		JLabel lblDown = new JLabel("Down:");
		lblDown.setBounds(10, 61, 46, 14);
		configurationPanel.add(lblDown);
		
		JLabel lblLeft = new JLabel("Left:");
		lblLeft.setBounds(10, 86, 46, 14);
		configurationPanel.add(lblLeft);
		
		JLabel lblRight = new JLabel("Right:");
		lblRight.setBounds(10, 111, 46, 14);
		configurationPanel.add(lblRight);
		
		textFieldUp = new JTextField();
		textFieldUp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldUp.getText().length() == 1)
					e.consume();
			}
		});
		textFieldUp.setBounds(66, 33, 86, 20);
		configurationPanel.add(textFieldUp);
		textFieldUp.setColumns(10);
		
		textFieldDown = new JTextField();
		textFieldDown.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldDown.getText().length() == 1)
					e.consume();
			}
		});
		textFieldDown.setBounds(66, 58, 86, 20);
		configurationPanel.add(textFieldDown);
		textFieldDown.setColumns(10);
		
		textFieldLeft = new JTextField();
		textFieldLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldLeft.getText().length() == 1)
					e.consume();
			}
		});
		textFieldLeft.setBounds(66, 83, 86, 20);
		configurationPanel.add(textFieldLeft);
		textFieldLeft.setColumns(10);
		
		textFieldRight = new JTextField();
		textFieldRight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldRight.getText().length() == 1)
					e.consume();
			}
		});
		textFieldRight.setText("");
		textFieldRight.setBounds(66, 108, 86, 20);
		configurationPanel.add(textFieldRight);
		textFieldRight.setColumns(10);
		
		btnPlay = new JButton("Play");
		btnPlay.setBounds(350, 425, 111, 50);
		principalMain.add(btnPlay);

		btnConfiguration = new JButton("Configuration");
		btnConfiguration.setBounds(150, 425, 111, 50);
		principalMain.add(btnConfiguration);
	}

	public JFrame getFrmPrincipalView() {
		return frmPrincipalView;
	}

	public JPanel getPrincipalMain() {
		return principalMain;
	}

	public JPanel getConfigurationPanel() {
		return configurationPanel;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public JButton getBtnConfiguration() {
		return btnConfiguration;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public JTextField getTextFieldUp() {
		return textFieldUp;
	}

	public JTextField getTextFieldDown() {
		return textFieldDown;
	}

	public JTextField getTextFieldLeft() {
		return textFieldLeft;
	}

	public JTextField getTextFieldRight() {
		return textFieldRight;
	}
}
