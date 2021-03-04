import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class PanelNuovoMeeting extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelNuovoMeeting() {
		setBounds(0, 0, 585, 478);
		setLayout(null);
		setBackground(new Color(135, 206, 250));
		
		JLabel labelNewMeet = new JLabel("Crea Nuovo Meeting");
		labelNewMeet.setHorizontalAlignment(SwingConstants.CENTER);
		labelNewMeet.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		labelNewMeet.setBounds(150, 6, 285, 49);
		add(labelNewMeet);
		
		JLabel lblDataM = new JLabel("Data:");
		lblDataM.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDataM.setBounds(146, 92, 78, 49);
		add(lblDataM);
		
		JLabel lblOraM = new JLabel("Ora:");
		lblOraM.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblOraM.setBounds(150, 153, 78, 49);
		add(lblOraM);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblTipo.setBounds(150, 220, 78, 49);
		add(lblTipo);
		
		JLabel lblPartecipanti = new JLabel("Partecipanti:");
		lblPartecipanti.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPartecipanti.setBounds(150, 287, 131, 49);
		add(lblPartecipanti);
		
		JLabel lblDataIcon = new JLabel("");
		lblDataIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataIcon.setBounds(77, 92, 48, 49);
		
		Image dataIcon = new ImageIcon(this.getClass().getResource("/data-meeting.png")).getImage();
		lblDataIcon.setIcon(new ImageIcon(dataIcon));
		add(lblDataIcon);
		
		JLabel lblOraIcon = new JLabel("");
		lblOraIcon.setBounds(77, 153, 57, 56);
		
		Image oraIcon = new ImageIcon(this.getClass().getResource("/orario-meting.png")).getImage();
		lblOraIcon.setIcon(new ImageIcon(oraIcon));
		add(lblOraIcon);
		
		JLabel lblTipoIcon = new JLabel("");
		lblTipoIcon.setBounds(77, 220, 48, 49);
		Image tipoIcon = new ImageIcon(this.getClass().getResource("/mod-meeting.png")).getImage();
		lblTipoIcon.setIcon(new ImageIcon(tipoIcon));
		add(lblTipoIcon);
		
		JLabel lblPartecipantiIcon = new JLabel("");
		lblPartecipantiIcon.setBounds(77, 294, 57, 42);
		
		Image partecipantiIcon = new ImageIcon(this.getClass().getResource("/partecipanti-meeting.png")).getImage();
		lblPartecipantiIcon.setIcon(new ImageIcon(partecipantiIcon));
		add(lblPartecipantiIcon);
		
		
		setVisible(true);

	}
}
