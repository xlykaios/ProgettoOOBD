import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.DefaultListModel;

import java.util.Vector;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;

public class AddTeamToNewProj extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSalary;
	private JTextField textFieldVal;

	ArrayList<Utenti> partecipanti = new ArrayList<Utenti>();
	//ProgettoDAO = new ProgettoDAO();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeamToNewProj frame = new AddTeamToNewProj();
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
	public AddTeamToNewProj() throws SQLException{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCercaMembro = new JLabel("Cerca Membro");
		lblCercaMembro.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblCercaMembro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCercaMembro.setBounds(128, 20, 194, 48);
		contentPane.add(lblCercaMembro);
		
		JLabel lblAddIcon = new JLabel("");
		lblAddIcon.setBounds(72, 20, 48, 48);
		Image addIcon = new ImageIcon(this.getClass().getResource("/aggiungi-team.png")).getImage();
		lblAddIcon.setIcon(new ImageIcon(addIcon));
		contentPane.add(lblAddIcon);
		
		JLabel lblSalarioMedio = new JLabel("Salario medio:");
		lblSalarioMedio.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblSalarioMedio.setBounds(72, 115, 152, 27);
		contentPane.add(lblSalarioMedio);
		
		JLabel lblValutazione = new JLabel("Valutazione:");
		lblValutazione.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblValutazione.setBounds(72, 180, 152, 27);
		contentPane.add(lblValutazione);
		
		JLabel lblTopicProgetti = new JLabel("Topic progetti:");
		lblTopicProgetti.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblTopicProgetti.setBounds(72, 245, 163, 27);
		contentPane.add(lblTopicProgetti);
		
		JLabel show_validation_here1 = new JLabel("");
		show_validation_here1.setForeground(Color.RED);
		show_validation_here1.setBounds(274, 139, 120, 16);
		contentPane.add(show_validation_here1);
		
		textFieldSalary = new JTextField();
		textFieldSalary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				try {
					int i = Integer.parseInt(textFieldSalary.getText());
					show_validation_here1.setText("");
					
				} catch (NumberFormatException e1) {
					show_validation_here1.setText("Invalid number");
					
				}
			}
		});
		
		textFieldSalary.setBounds(270, 119, 130, 20);
		contentPane.add(textFieldSalary);
		textFieldSalary.setColumns(10);
		
		JLabel show_validation_here2 = new JLabel("");
		show_validation_here2.setForeground(Color.RED);
		show_validation_here2.setBounds(274, 206, 120, 16);
		contentPane.add(show_validation_here2);
		
		
		textFieldVal = new JTextField();
		textFieldVal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				try {
					int i = Integer.parseInt(textFieldVal.getText());
					show_validation_here2.setText("");
					
				} catch (NumberFormatException e1) {
					show_validation_here2.setText("Invalid number");
					
				}
			}
		});
		textFieldVal.setColumns(10);
		textFieldVal.setBounds(270, 186, 130, 20);
		contentPane.add(textFieldVal);
		
		JComboBox comboBoxMemPerTopic = new JComboBox();
		comboBoxMemPerTopic.setModel(new DefaultComboBoxModel(new String[] {"Ricerca di Base", "Sviluppo Industriale", "Ricerca Industriale", "Sviluppo Sperimentale", "Ricerca Sperimentale"}));
		comboBoxMemPerTopic.setBounds(270, 247, 130, 20);
		contentPane.add(comboBoxMemPerTopic);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(6, 362, 130, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnCercaPartecipanti = new JButton("Cerca");
		btnCercaPartecipanti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//list.add(list, Utenti.class.getName());
				for (int i = 0; i < partecipanti.size(); i++) {
			//	list.add(partecipanti.get(i).Nome);
			//	list.add(partecipanti.get(i).Cognome);
			//	list.add(partecipanti.get(i).CF);
					lblNewLabel.setText(partecipanti.get(i).Nome);
				
				}
			}
		});
		btnCercaPartecipanti.setBounds(166, 326, 117, 29);
		contentPane.add(btnCercaPartecipanti);
		

		

	
		
		//SALVERà I DATI DELLA LISTA 
		JButton btnDoneLista = new JButton("Done");
		btnDoneLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aggiorna input fields
				textFieldSalary.setText("");
				textFieldVal.setText("");
				comboBoxMemPerTopic.setSelectedItem(null);

			}
		});
		btnDoneLista.setBounds(166, 581, 117, 29);
		contentPane.add(btnDoneLista);
		
		
		FinalDAO.GetPartecipanti();
		ArrayList<Utenti> partecipanti = FinalDAO.partecip;
		JList<Object> list = new JList<Object>(partecipanti.toArray());
		list.setBounds(100, 405, 248, 125);
		contentPane.add(list);
		
	
		
		
		
		
		
		

	}
}
