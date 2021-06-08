package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

import Model.User;
import View.User_Add;

public class User_AddController extends User_Add {
	
	public Boolean AddStat;
	public int id;
	
	public User_AddController(int id) {
		
		this.id = id;
		var getuser = datamodel.user.stream().filter(x-> x.ID == id).findFirst();
		if (!getuser.isEmpty()) {
			textFieldUsername.setText(String.valueOf(getuser.get().getUsername()));
			textFieldPassword.setText(String.valueOf(getuser.get().getPassword()));
			AddStat = false;
		}
		else {
			AddStat = true;
		}
	}
	
	
	private Boolean Validation() {
		if (textFieldUsername.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter username!", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if(textFieldPassword.getText().isBlank()){
			JOptionPane.showMessageDialog(null, "Please enter password!", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {

			var users = datamodel.user.stream().filter(x-> x.username.equals(textFieldUsername.getText().strip()));
			if (users.count() != 0) {
				JOptionPane.showMessageDialog(null, "Username already exist. Please try again!", "Alert", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			else {
				return true;
			}
		}
	}

	@Override
	public void SaveClicked() {
		// TODO Auto-generated method stub
		if(AddStat == true)
		{
			if(Validation()) {
				User usr = new User();
				
				usr.setUsername(textFieldUsername.getText());
				usr.setPassword(textFieldPassword.getText());
				
				if (usr.insert()) {
					JOptionPane.showMessageDialog(null, "User successfully inserted","Success", JOptionPane.INFORMATION_MESSAGE);
						
					frame.setVisible(false);
					try {
						UserController window = new UserController();
						window.frame.setVisible(true);
						window.generateTable();
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
				else {
					JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
				}	
	
			} else {
				textFieldUsername.setText("");
				textFieldPassword.setText("");
			}
		}
		else
		{
			User usr = new User();
			
			usr.setUsername(textFieldUsername.getText());
			usr.setPassword(textFieldPassword.getText());
			usr.setID(id);
			
			if (usr.update()) {
				JOptionPane.showMessageDialog(null, "User successfully inserted","Success", JOptionPane.INFORMATION_MESSAGE);
					
				frame.setVisible(false);
				try {
					UserController window = new UserController();
					window.frame.setVisible(true);
					window.generateTable();
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
			else {
				JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert", JOptionPane.WARNING_MESSAGE);
			}	
		}
		
		
	}

	@Override
	public void BackClicked() {
		// TODO Auto-generated method stub
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

}
