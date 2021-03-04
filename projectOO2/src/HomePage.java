import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class HomePage extends JFrame {

	private JPanel contentPane;
	
	private PanelCercaProgetto panelCercaProgetto;
	private PanelNuovoProgetto panelNuovoProgetto;
	private PanelNuovoMeeting  panelNuovoMeeting;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 490);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCercaProgetto = new PanelCercaProgetto();
		panelNuovoProgetto = new PanelNuovoProgetto();
		panelNuovoMeeting  = new PanelNuovoMeeting();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(null);
		panelMenu.setBounds(0, 0, 200, 490);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image logo = new ImageIcon(this.getClass().getResource("/logo-aziendale.png")).getImage();
		lblLogo.setIcon(new ImageIcon(logo));
		
		lblLogo.setBounds(6, 6, 188, 70);
		panelMenu.add(lblLogo);
		
		JPanel paneCercaProgetto = new JPanel();
		paneCercaProgetto.addMouseListener(new MenuButtonMouseAdapter(paneCercaProgetto) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCercaProgetto);
			}
		});
		
		paneCercaProgetto.setBackground(new Color(255, 255, 255));
		paneCercaProgetto.setBounds(0, 149, 200, 70);
		panelMenu.add(paneCercaProgetto);
		paneCercaProgetto.setLayout(null);
		
		JLabel lblCercaProg = new JLabel("Cerca Progetto");
		lblCercaProg.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblCercaProg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCercaProg.setBounds(6, 6, 188, 58);
		paneCercaProgetto.add(lblCercaProg);
		
		JPanel paneNuovoProgetto = new JPanel();
		paneNuovoProgetto.addMouseListener(new MenuButtonMouseAdapter(paneNuovoProgetto){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelNuovoProgetto);
			}
		});
		paneNuovoProgetto.setBackground(new Color(255, 255, 255));
		paneNuovoProgetto.setBounds(0, 231, 200, 70);
		panelMenu.add(paneNuovoProgetto);
		paneNuovoProgetto.setLayout(null);
		
		JLabel lblNuovoProg = new JLabel("Nuovo Progetto");
		lblNuovoProg.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNuovoProg.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuovoProg.setBounds(6, 6, 188, 58);
		paneNuovoProgetto.add(lblNuovoProg);
		
		JPanel paneNuovoMeeting = new JPanel();
		paneNuovoMeeting.addMouseListener(new MenuButtonMouseAdapter(paneNuovoMeeting){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelNuovoMeeting);
			}
		});
		paneNuovoMeeting.setBackground(new Color(255, 255, 255));
		paneNuovoMeeting.setBounds(0, 313, 200, 70);
		panelMenu.add(paneNuovoMeeting);
		paneNuovoMeeting.setLayout(null);
		
		JLabel lblNuovoMeet = new JLabel("Nuovo Meeting");
		lblNuovoMeet.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNuovoMeet.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuovoMeet.setBounds(6, 6, 188, 58);
		paneNuovoMeeting.add(lblNuovoMeet);
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro di chiudere l'applicazione?", "Conferma", JOptionPane.YES_NO_OPTION) == 0) {
				HomePage.this.dispose();
		}	
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(69, 423, 61, 61);
		Image exit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		lblExit.setIcon(new ImageIcon(exit));
		panelMenu.add(lblExit);
			
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBackground(Color.WHITE);
		panelMainContent.setBounds(212, 6, 585, 478);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		panelMainContent.add(panelCercaProgetto);
		panelMainContent.add(panelNuovoProgetto);
		panelMainContent.add(panelNuovoMeeting);
		
		menuClicked(paneCercaProgetto);

	}
	
	public void menuClicked(JPanel panel) {
		panelCercaProgetto.setVisible(false);
		panelNuovoProgetto.setVisible(false);
		panelNuovoMeeting.setVisible(false);
		
		panel.setVisible(true);
	}
}
