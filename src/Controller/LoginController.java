package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import View.Login;

public class LoginController extends Login {

	@Override
	public void login() {
		// TODO Auto-generated method stub
		datamodel.refreshData();
		@SuppressWarnings("deprecation")
		var check = datamodel.user.stream().filter(
				x -> x.username.equals(usernameField.getText().strip()) && x.password.equals(passwordField.getText()))
				.collect(Collectors.toList());
		if (check.size() == 0) {
			JOptionPane.showMessageDialog(null, "Wrong Username / Password!", "Alert", JOptionPane.WARNING_MESSAGE);
		} else {
			frame.setVisible(false);
			try {
				MainMenuController window = new MainMenuController();
				window.frame.setVisible(true);
				window.frame.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						frame.setVisible(true);
					}
				});
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Cannot log in. Program is problem", "Alert",
						JOptionPane.WARNING_MESSAGE);
				frame.setVisible(true);
			}
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		usernameField.setText("");
		passwordField.setText("");
	}
}
