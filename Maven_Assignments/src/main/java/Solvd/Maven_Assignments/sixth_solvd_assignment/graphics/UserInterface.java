package sixth_solvd_assignment.graphics;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UserInterface {
	// STILL NOT FINISHED, WORKING OUT THE LAYOUT AND TEXT MANAGEMENT
	private static final ImageIcon welcomeBackground = new ImageIcon("backgrounds/welcomeBackground.jpg");
	private static final ImageIcon zooBackground = new ImageIcon("backgrounds/zooBackground.jpg");
	private static final ImageIcon arenaBackground = new ImageIcon("backgrounds/arenaBackground.jpg");
	private static final ImageIcon nurseryBrackground = new ImageIcon("backgrounds/nuseryBackground.jpg");
	private static final ImageIcon lastLogBackground = new ImageIcon("backgrounds/lastLogBackground.jpg");

	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Exit") {
				System.exit(0);
			}
		}
	}

	public void launchFrame() {
		// FRAME
		JFrame frame = new JFrame("Inheritance v6");
		frame.setMinimumSize(new Dimension(1280, 720));
		// MENU BAR
		JMenuBar topMenuBar = new JMenuBar();
		// MENU TABS
		JMenu menuTab = new JMenu("Menu");
		JMenu helpTab = new JMenu("Help");
		// MENU TAB BUTTONS
		JMenuItem closeButton = new JMenuItem("Exit");
		closeButton.addActionListener(new ExitListener());
		// HELP TAB BUTTONS
		JMenuItem aboutProgram = new JMenuItem("Welcome");
		aboutProgram.setToolTipText(
				"<html>Hello, and welcome to Inheritance park! This isn't really a program with a practical use outside of a concept demonstration,"
						+ "<br>feel free, however, to experiment to your heart's desire. Hell, if you can manage to break it and send me the log I'd be more than grateful.</html>");

		JMenuItem aboutProgrammer = new JMenuItem("About");
		aboutProgrammer.setToolTipText("<html>This program was develop in November of 2021 by Lautaro Joaquín Fonseca,"
				+ "<br> as part of a training programme from Solvd, Inc.</html>");
		// MENU BAR SETUP
		menuTab.add(closeButton);

		helpTab.add(aboutProgram);
		helpTab.addSeparator();
		helpTab.add(aboutProgrammer);

		topMenuBar.add(menuTab);
		topMenuBar.add(helpTab);

		frame.setJMenuBar(topMenuBar);
		// TABBED PANE
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		// WELCOME TAB
		JPanel welcome = new JPanel();
		welcome.setLayout(new BorderLayout());

		// ZOO TAB
		JPanel zoo = new JPanel();
		zoo.setLayout(new BorderLayout());
		// ARENA TAB
		JPanel arena = new JPanel();
		arena.setLayout(new BorderLayout());
		// NURSERY TAB
		JPanel nursery = new JPanel();
		nursery.setLayout(new BorderLayout());
		// LAST LOG TAB
		JPanel lastLog = new JPanel();
		lastLog.setLayout(new BorderLayout());

		tabs.addTab("Welcome", welcome);
		tabs.addTab("Zoo", zoo);
		tabs.addTab("Arena", arena);
		tabs.addTab("Nursery", nursery);
		tabs.setEnabledAt(3, false);
		tabs.addTab("Last Log", lastLog);

		// FRAME SETUP
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(tabs);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new UserInterface().launchFrame();
	}
}
