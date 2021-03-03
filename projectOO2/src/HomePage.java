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
		setBounds(100, 100, 760, 490);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JPanel panelCercaProgetto = new JPanel();
		panelCercaProgetto.addMouseListener(new MenuButtonMouseAdapter(panelCercaProgetto));
		panelCercaProgetto.setBackground(new Color(255, 255, 255));
		panelCercaProgetto.setBounds(0, 149, 200, 70);
		panelMenu.add(panelCercaProgetto);
		panelCercaProgetto.setLayout(null);
		
		JLabel lblCercaProg = new JLabel("Cerca Progetto");
		lblCercaProg.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblCercaProg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCercaProg.setBounds(6, 6, 188, 58);
		panelCercaProgetto.add(lblCercaProg);
		
		JPanel panelNuovoProgetto = new JPanel();
		panelNuovoProgetto.addMouseListener(new MenuButtonMouseAdapter(panelNuovoProgetto));
		panelNuovoProgetto.setBackground(new Color(255, 255, 255));
		panelNuovoProgetto.setBounds(0, 231, 200, 70);
		panelMenu.add(panelNuovoProgetto);
		panelNuovoProgetto.setLayout(null);
		
		JLabel lblNuovoProg = new JLabel("Nuovo Progetto");
		lblNuovoProg.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNuovoProg.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuovoProg.setBounds(6, 6, 188, 58);
		panelNuovoProgetto.add(lblNuovoProg);
		
		JPanel panelNuovoMeeting = new JPanel();
		panelNuovoMeeting.addMouseListener(new MenuButtonMouseAdapter(panelNuovoMeeting));
		panelNuovoMeeting.setBackground(new Color(255, 255, 255));
		panelNuovoMeeting.setBounds(0, 313, 200, 70);
		panelMenu.add(panelNuovoMeeting);
		panelNuovoMeeting.setLayout(null);
		
		JLabel lblNuovoMeet = new JLabel("Nuovo Meeting");
		lblNuovoMeet.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNuovoMeet.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuovoMeet.setBounds(6, 6, 188, 58);
		panelNuovoMeeting.add(lblNuovoMeet);
		
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
		
		JPanel panelContent = new JPanel();
		panelContent.setBounds(212, 6, 542, 478);
		contentPane.add(panelContent);
		
	}
}
