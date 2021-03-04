import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.swing.JTextField;

public class ConfermaCreazioneMeeting extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldDayM;
	public JTextField textFieldHoursM;
	public JTextField textFieldModM;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfermaCreazioneMeeting frame = new ConfermaCreazioneMeeting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfermaCreazioneMeeting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMeetInstr = new JLabel("Meeting creato!");
		lblMeetInstr.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblMeetInstr.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeetInstr.setBounds(132, 6, 185, 62);
		contentPane.add(lblMeetInstr);
		
		JLabel lblDataMInstr = new JLabel("Si terrà nel giorno");
		lblDataMInstr.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblDataMInstr.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataMInstr.setBounds(27, 90, 185, 25);
		contentPane.add(lblDataMInstr);
		
		JLabel lblAlleOre = new JLabel("Alle ore");
		lblAlleOre.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlleOre.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAlleOre.setBounds(27, 127, 185, 25);
		contentPane.add(lblAlleOre);
		
		JLabel lblInModalit = new JLabel("In modalità");
		lblInModalit.setHorizontalAlignment(SwingConstants.LEFT);
		lblInModalit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblInModalit.setBounds(27, 164, 185, 25);
		contentPane.add(lblInModalit);
		
		textFieldDayM = new JTextField();
		textFieldDayM.setEditable(false);
		textFieldDayM.setBounds(255, 92, 130, 26);
		contentPane.add(textFieldDayM);
		textFieldDayM.setColumns(10);
		
		textFieldHoursM = new JTextField();
		textFieldHoursM.setEditable(false);
		textFieldHoursM.setBounds(255, 129, 130, 26);
		contentPane.add(textFieldHoursM);
		textFieldHoursM.setColumns(10);
		
		textFieldModM = new JTextField();
		textFieldModM.setEditable(false);
		textFieldModM.setBounds(255, 166, 130, 26);
		contentPane.add(textFieldModM);
		textFieldModM.setColumns(10);
	}
}
