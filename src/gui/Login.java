package gui;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Login extends JFrame {
	public Login() {
		
		JButton btnNewButton = new JButton("ggg");
		
		JButton btnNewButton_1 = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(171)
					.addComponent(btnNewButton)
					.addContainerGap(423, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(338, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(256))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(115)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(92))
		);
		getContentPane().setLayout(groupLayout);
	}
}
