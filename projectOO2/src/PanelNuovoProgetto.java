import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelNuovoProgetto extends JPanel {
	private JTextField textFieldNome;

	/**
	 * Create the panel.
	 */
	public PanelNuovoProgetto() throws SQLException{
		setBounds(0, 0, 585, 478);
		setLayout(null);
		setBackground(new Color(135, 206, 250));
		
		ConfermaCreazioneProgetto viewConfermaProgetto = new ConfermaCreazioneProgetto();
		AddTeamToNewProj viewAddTeam = new AddTeamToNewProj();
		
		JLabel labelNewProj = new JLabel("Crea Nuovo Progetto");
		labelNewProj.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		labelNewProj.setHorizontalAlignment(SwingConstants.CENTER);
		labelNewProj.setBounds(150, 18, 285, 49);
		add(labelNewProj);
		
		JLabel lblNomeP = new JLabel("Nome:");
		lblNomeP.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNomeP.setBounds(150, 79, 78, 49);
		add(lblNomeP);
		
		JLabel lblTopicP = new JLabel("Topic:");
		lblTopicP.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblTopicP.setBounds(150, 140, 78, 49);
		add(lblTopicP);
		
		JLabel lblAmbitoP = new JLabel("Ambito:");
		lblAmbitoP.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblAmbitoP.setBounds(150, 201, 91, 49);
		add(lblAmbitoP);
		
		JLabel lblTeamP = new JLabel("Team:");
		lblTeamP.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblTeamP.setBounds(150, 262, 78, 49);
		add(lblTeamP);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(298, 94, 130, 26);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JComboBox comboBoxTopicNewP = new JComboBox();
		comboBoxTopicNewP.setModel(new DefaultComboBoxModel(new String[] {"Topic1", "Topic2", "Topic3"}));
		comboBoxTopicNewP.setBounds(298, 156, 130, 27);
		add(comboBoxTopicNewP);
		
		JComboBox comboBoxAmbitoNewP = new JComboBox();
		comboBoxAmbitoNewP.setModel(new DefaultComboBoxModel(new String[] {"Ambito1", "Ambito2", "Ambito3"}));
		comboBoxAmbitoNewP.setBounds(298, 217, 130, 27);
		add(comboBoxAmbitoNewP);
		
		JButton btnAddTeam = new JButton("Add");
		btnAddTeam.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				viewAddTeam.setVisible(true);
				viewAddTeam.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//AddTeamToNewProj obj = new AddTeamToNewProj();
			}
		});
		
		btnAddTeam.setBounds(298, 277, 130, 29);
		add(btnAddTeam);
		
		JButton btnCreaNewP = new JButton("Crea");
		btnCreaNewP.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//Check input non vuoti
				if (textFieldNome.getText().isEmpty() || 
						comboBoxTopicNewP.getSelectedItem().equals(null) || 
						comboBoxAmbitoNewP.getSelectedItem().equals(null)) {
					viewConfermaProgetto.setVisible(false);
					JOptionPane.showMessageDialog(null, "Inserisci valori");
				} else {
					viewConfermaProgetto.setVisible(true);
					viewConfermaProgetto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					ConfermaCreazioneProgetto obj = new ConfermaCreazioneProgetto();
					
					String nomeProj = textFieldNome.getText().toString();
					obj.textFieldNomeP.setText(nomeProj);
					
					String topicProj = comboBoxTopicNewP.getSelectedItem().toString();
					obj.textFieldTopicP.setText(topicProj);
					
					obj.setVisible(true);
				}
				
				
			}
		});
		btnCreaNewP.setBounds(234, 350, 117, 29);
		add(btnCreaNewP);
		setVisible(true);
		

	}
	
}
