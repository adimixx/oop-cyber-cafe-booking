package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import View.MainMenu;

public class MainMenuController extends MainMenu {

	@Override
	public void TransactionClicked() {
		frame.setVisible(false);
		try {
			TransactionController window = new TransactionController();
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
		}
	}

	@Override
	public void UserClicked() {
		frame.setVisible(false);
		try {
			UserController window = new UserController();
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
		}
	}

	@Override
	public void LocationClicked() {
		frame.setVisible(false);
		try {
			LocationController window = new LocationController();
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
		}
	}

	@Override
	public void ComputerClicked() {
		frame.setVisible(false);
		try {
			ComputerController window = new ComputerController();
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
		}
	}

	@Override
	public void MembershipClicked() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		try {
			membership_controller window = new membership_controller();
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
		}
	}

	@Override
	public void Logout() {
		frame.setVisible(false);
		try {
			LoginController window = new LoginController();
			window.frame.setVisible(true);
			window.frame.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					frame.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			frame.setVisible(true);
		}
	}

}
