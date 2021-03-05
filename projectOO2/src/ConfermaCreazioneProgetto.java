import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConfermaCreazioneProgetto extends JFrame {

	private JPanel 	   contentPane;
	public 	JTextField textFieldNomeP;
	public 	JTextField textFieldTopicP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfermaCreazioneProgetto frame = new ConfermaCreazioneProgetto();
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
	public ConfermaCreazioneProgetto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjInstr = new JLabel("Progetto creato!");
		lblProjInstr.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblProjInstr.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjInstr.setBounds(132, 6, 185, 62);
		contentPane.add(lblProjInstr);
		
		JLabel lblNomeProj = new JLabel("Nome");
		lblNomeProj.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNomeProj.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProj.setBounds(27, 90, 185, 25);
		contentPane.add(lblNomeProj);
		
		JLabel lblTipoProj = new JLabel("Tipo");
		lblTipoProj.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoProj.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTipoProj.setBounds(27, 150, 185, 25);
		contentPane.add(lblTipoProj);
		
		
		textFieldNomeP = new JTextField();
		textFieldNomeP.setEditable(false);
		textFieldNomeP.setBounds(255, 92, 130, 26);
		contentPane.add(textFieldNomeP);
		textFieldNomeP.setColumns(10);
		
		textFieldTopicP = new JTextField();
		textFieldTopicP.setEditable(false);
		textFieldTopicP.setBounds(255, 152, 130, 26);
		contentPane.add(textFieldTopicP);
		textFieldTopicP.setColumns(10);
		
	}

}
