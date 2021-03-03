import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MenuButtonMouseAdapter extends MouseAdapter {
	
	JPanel panel;
	public MenuButtonMouseAdapter(JPanel panel) {
		this.panel = panel;
	}
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(new Color(135, 206, 250));
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		panel.setBackground(new Color(255, 255, 255));
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.setBackground(new Color(255, 255, 255));
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		panel.setBackground(new Color(135, 206, 250));
		
	}
	

}
