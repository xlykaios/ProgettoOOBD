import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelNuovoProgetto extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelNuovoProgetto() {
		setBounds(0, 0, 585, 478);
		setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(349, 5, 61, 16);
		add(label);
		setVisible(true);

	}

}
