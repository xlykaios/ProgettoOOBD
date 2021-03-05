import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelCercaProgetto extends JPanel {
	private JTextField textFieldResultsTopic;
	private JTable tableRisultatiRicerca;
	
	

	/**
	 * Create the panel.
	 */
	public PanelCercaProgetto() {
		setBounds(0, 0, 585, 478);
		setBackground(new Color(135, 206, 250));
		setLayout(null);
		setVisible(true);
		
		JLabel lblWelcome = new JLabel("Benvenuto Admin");
		lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(176, 6, 233, 58);
		add(lblWelcome);
		
		JLabel lblSearch = new JLabel("");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setBounds(6, 74, 81, 58);
		Image logo = new ImageIcon(this.getClass().getResource("/Iconaricerca.png")).getImage();
		lblSearch.setIcon(new ImageIcon(logo));
		add(lblSearch);
		
		JLabel lblRicercaProg = new JLabel("Cerca progetto per topic:");
		lblRicercaProg.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblRicercaProg.setBounds(99, 74, 268, 58);
		add(lblRicercaProg);
		
		JComboBox comboBoxTopic = new JComboBox();
		comboBoxTopic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedTopic = comboBoxTopic.getSelectedItem().toString();
				textFieldResultsTopic.setText(selectedTopic);
			}
		});
		//dati fittizzi - DA CAMBIARE in seguito all'utilizzo di un enum
		comboBoxTopic.setModel(new DefaultComboBoxModel(new String[] {"Topic_1", "Topic_2", "Topic_3"}));
		comboBoxTopic.setBounds(379, 95, 130, 27);
		add(comboBoxTopic);
		
		JLabel lblRisultati = new JLabel("Risultati per il topic:");
		lblRisultati.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblRisultati.setBounds(99, 144, 268, 58);
		add(lblRisultati);
		
		textFieldResultsTopic = new JTextField();
		textFieldResultsTopic.setEditable(false);
		textFieldResultsTopic.setBounds(379, 164, 130, 27);
		add(textFieldResultsTopic);
		textFieldResultsTopic.setColumns(10);
		
		JButton btnNewButton = new JButton("Cerca");
		//COLLEGAMENTO DB: ricerca progetti dal database in tabella
		/**btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//database connection
				try {
					//open connection
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("url_", "root", "mysql@1234");
					//ID is "root" - nomeprogetto is "mysql@1234"
					
					Statement st = con.createStatement();
					//mysql query
					String sql = "select * from ID";
					ResultSet rs = st.executeQuery(sql);
					
					while(rs.next()) {
						//data will be added until finish
						String id = String.valueOf(rs.getInt("id"));
						String nomeP = rs.getString("nome progetto");
						
						//string array for store data into jtable
						String tbData[] = {id, nomeP};
						DefaultTableModel tblModel = (DefaultTableModel)tableRisultatiRicerca.getModel();
						
						//add array string data into table ** ADD MYSQL JAR 
						tblModel.addRow(tbData);
						
					}
					con.close();
					
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});*/
		btnNewButton.setBounds(234, 214, 117, 29);
		add(btnNewButton);
		
		String[] columnNames = {"ID", "NOME PROGETTO"};
		
		tableRisultatiRicerca = new JTable();
		tableRisultatiRicerca.setBounds(99, 383, 268, -82);
		tableRisultatiRicerca.setEnabled(false);
		add(tableRisultatiRicerca);

	}
}
