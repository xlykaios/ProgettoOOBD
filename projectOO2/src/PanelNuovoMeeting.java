import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelNuovoMeeting extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelNuovoMeeting() {
		setBounds(0, 0, 585, 478);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(363, 35, 61, 16);
		add(lblNewLabel);
		setVisible(true);

	}

}
