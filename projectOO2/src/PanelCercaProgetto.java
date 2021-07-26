import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class PanelCercaProgetto extends JPanel {
	private JTextField textFieldResultsTopic;
	private JTable tableRisultatiRicerca;
	
	public JComboBox comboBoxTopic;
	public String selectedTopic;
	public JTextArea textAreaRisProj;
	
	private String dbConnessioneDriver   = "com.mysql.jdbc.Driver";
	private String dbConnessioneUrl      = "vexera.ddns.net";
	private String dbConnessioneUser     = "User";
	private String dbConnessionePassword = "1234";

	/**
	 * Create the panel.
	 */
	public PanelCercaProgetto() {
		setBounds(0, 0, 585, 478);
		setBackground(new Color(135, 206, 250));
		setLayout(null);
		setVisible(true);

		
		tableRisultatiRicerca = new JTable();
		tableRisultatiRicerca.setForeground(Color.WHITE);
		tableRisultatiRicerca.setBackground(Color.GRAY);
		tableRisultatiRicerca.setBounds(99, 422, 384, -121);
		add(tableRisultatiRicerca);
		
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
		//comboBoxTopic.setModel(new DefaultComboBoxModel(new String[] {"Topic_1", "Topic_2", "Topic_3"}));
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
		
		JButton btnCercaProj = new JButton("Cerca");

		
		//COLLEGAMENTO DB: ricerca progetti dal database in tabella
		btnCercaProj.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				updatetextAreaRisProj();
				}
		});
		btnCercaProj.setBounds(234, 214, 117, 29);
		add(btnCercaProj);
		
		JTextArea textAreaRisProj = new JTextArea();
		textAreaRisProj.setEditable(false);
		textAreaRisProj.setBounds(100, 274, 384, 174);
		add(textAreaRisProj);
		
		JLabel lblNP = new JLabel("Nome Progetto");
		lblNP.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNP.setBounds(99, 246, 142, 27);
		add(lblNP);
		
		String[] columnNames = {"ID", "NOME PROGETTO"};
		
		

	}
	
	//update comboBoxTopic
	public void updateComboBox() throws SQLException { 
		try {

			 Class.forName("org.postgresql.Driver");

			 } catch (ClassNotFoundException e) {
			 System.out.println("Where is your PostgreSQL JDBC Driver? � + �Include in your library path!");
			 e.printStackTrace();
			 return;
			 }
			 System.out.println("PostgreSQL JDBC Driver Registered!");
			 Connection connection = null;

			 try {
			 connection = DriverManager.getConnection("jdbc:postgresql://vexera.ddns.net:44044/project", "User",
			 "1234");
			 } catch (SQLException e) {

			 System.out.println("Connection Failed! Check output console");
			 e.printStackTrace();
			 return;
			 }

			 if (connection != null) { 
				String sql = "select * from public.progetti";
				try {
					Statement pst = connection.prepareStatement(sql);
					ResultSet rs = pst.executeQuery(sql);
					
					while(rs.next()) {
						comboBoxTopic.addItem(rs.getString("ambito"));
					}
				} catch (Exception e) {

					 System.out.println("Where is your PostgreSQL JDBC Driver? � + �Include in your library path!");
					 e.printStackTrace();
					 return;

					 }
			}
}
	
	
	//update textAreaRisProj - predere i topic dal db e inserirli nel cmbo box
	public void updatetextAreaRisProj()  { 
		try {

			 Class.forName("org.postgresql.Driver");

			 } catch (ClassNotFoundException e) {
			 System.out.println("Where is your PostgreSQL JDBC Driver? � + �Include in your library path!");
			 e.printStackTrace();
			 return;
			 }
			 System.out.println("PostgreSQL JDBC Driver Registered!");
			 Connection connection = null;

			 try {
			 connection = DriverManager.getConnection("jdbc:postgresql://vexera.ddns.net:44044/project", "User",
			 "1234");
			 } catch (SQLException e) {

			 System.out.println("Connection Failed! Check output console");
			 e.printStackTrace();
			 return;
			 }

			 if (connection != null) { 
				String sql = "select * from public.progetti where \"tipo\" = + selectedTopic + ";


				try {
					Statement pst = connection.prepareStatement(sql);
					ResultSet rs = pst.executeQuery(sql);
					//String text = textAreaRisProj.setText(text);
					
					while(rs.next()) {
					//line aper linea - mostrare i nomi dei progetti per topic selezionato
				//		textAreaRisProj = textAreaRisProj.
						//text += textAreaRisProj[1];
		                
						//textAreaRisProj.setText() += Environment.NewLine;
					}
				} catch (Exception e) {

					 System.out.println("Where is your PostgreSQL JDBC Driver? � + �Include in your library path!");
					 e.printStackTrace();
					 return;

					 }
			}
}
}
