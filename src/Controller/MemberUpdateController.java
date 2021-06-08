package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import Model.Membership;
import View.MemberUpdate;

public class MemberUpdateController extends MemberUpdate {

	public boolean AddStat;
	public int id;

	public MemberUpdateController(int id) {
		this.id = id;

		var getuser = datamodel.membership.stream().filter(x -> x.ID == id).collect(Collectors.toList());

		if (getuser != null) {
			name.setText(String.valueOf(getuser.get(0).getName()));
			email.setText(String.valueOf(getuser.get(0).getEmail()));
			hour.setText(String.valueOf(getuser.get(0).gethourSpend()));

			AddStat = false;
		} else {
			AddStat = true;
		}
	}

	private boolean Validation() {
		if (name.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter Name!", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (email.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter Email!", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (hour.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter Hour Spend !", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {

			var users = datamodel.membership.stream().filter(x -> x.email.equals(email.getText().strip()));
			if (users.count() != 0) {
				JOptionPane.showMessageDialog(null, "Email already exist. Please try again!", "Alert",
						JOptionPane.WARNING_MESSAGE);
				return false;
			} else {
				return true;
			}
		}

	}

	@Override
	public void SaveClicked() {
		// TODO Auto-generated method stub
		if (AddStat == true) {
			if (Validation() == true) {
				Membership mem = new Membership();

				mem.setName(name.getText());
				mem.setEmail(email.getText());
				mem.sethourSpend(hour.getText());

				if (mem.update()) {
					JOptionPane.showMessageDialog(null, "Member successfully update", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					frame.setVisible(false);
					try {
						membership_controller window = new membership_controller();
						window.frame.setVisible(true);
						window.generateHistoryTable();
						window.frame.addWindowListener(new WindowAdapter() {
							public void windowClosed(WindowEvent e) {
								frame.setVisible(true);
							}
						});
					} catch (Exception e) {
						e.printStackTrace();
						frame.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert",
							JOptionPane.WARNING_MESSAGE);
				}

			} else {
				name.setText("");
				email.setText("");
				hour.setText("");
			}
		} else {
			Membership mem = new Membership();

			mem.setName(name.getText());
			mem.setEmail(email.getText());
			mem.sethourSpend(hour.getText());

			mem.setID(id);

			if (mem.update()) {
				JOptionPane.showMessageDialog(null, "Member successfully updated", "Success",
						JOptionPane.INFORMATION_MESSAGE);

				frame.setVisible(false);
				try {
					membership_controller window = new membership_controller();
					window.frame.setVisible(true);
					window.generateHistoryTable();
					window.frame.addWindowListener(new WindowAdapter() {
						public void windowClosed(WindowEvent e) {
							frame.setVisible(true);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
					frame.setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(null, "System Error. Please Contact Admin", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	@Override
	public void BackClicked() {
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

}
