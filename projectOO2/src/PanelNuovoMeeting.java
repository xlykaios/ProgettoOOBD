import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelNuovoMeeting extends JPanel {


	public PanelNuovoMeeting() {
		setBounds(0, 0, 585, 478);
		setLayout(null);
		setBackground(new Color(135, 206, 250));
		
		ConfermaCreazioneMeeting viewConfermaMeeting = new ConfermaCreazioneMeeting();
		
		AddTeamToNewProj viewAddList = new AddTeamToNewProj();

		
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
		
		//ICONS
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
		
		
		
		JComboBox comboBoxTipoM = new JComboBox();
		comboBoxTipoM.setModel(new DefaultComboBoxModel(new String[] {"IRL", "Online"}));
		comboBoxTipoM.setBounds(300, 236, 135, 27);
		add(comboBoxTipoM);
		
		JButton btnAddListaP = new JButton("Aggiungi");
		btnAddListaP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAddList.setVisible(true);
				viewAddList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAddListaP.setBounds(300, 302, 135, 29);
		add(btnAddListaP);
		
		DatePicker datePicker = new DatePicker();		
		datePicker.setBounds(300, 94, 212, 29);
		add(datePicker);
		
		TimePicker timePicker = new TimePicker();
		timePicker.setBounds(300, 153, 212, 29);
		add(timePicker);
		
		JButton btnCreaMeet = new JButton("Crea");
		btnCreaMeet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Check input non vuoti
				
				//data - ora - tipo - partec
				if (datePicker.getDateStringOrEmptyString().isEmpty() || 
						timePicker.getTimeStringOrEmptyString().isEmpty() || 
						comboBoxTipoM.getSelectedItem().equals(null)) {
					
					viewConfermaMeeting.setVisible(false);
					JOptionPane.showMessageDialog(null, "Inserisci valori");
				} else {
			
				//Manda dati al JFrame di conferma
				viewConfermaMeeting.setVisible(true);
				viewConfermaMeeting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				ConfermaCreazioneMeeting obj = new ConfermaCreazioneMeeting();
				
				String meetingType = comboBoxTipoM.getSelectedItem().toString();
				obj.textFieldModM.setText(meetingType);
				
				String selectedDate = datePicker.getDateStringOrEmptyString();
				obj.textFieldDayM.setText(selectedDate);
				
				String selectedTime = timePicker.getTimeStringOrEmptyString().toString();
				obj.textFieldHoursM.setText(selectedTime);
				
				obj.setVisible(true);
				
				//Refresh degli input fields
				datePicker.setDate(null);
				timePicker.setTime(null);
				comboBoxTipoM.setSelectedItem(null);
				}
			}
		});
		btnCreaMeet.setBounds(227, 410, 117, 29);
		add(btnCreaMeet);
		
		
		setVisible(true);

	}
}
