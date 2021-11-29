package eighth_solvd_assignment.graphics;

public class UserInterface extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private javax.swing.JMenuItem jAboutProgram;
	private javax.swing.JMenuItem jAboutProgrammer;
	private javax.swing.JMenu jAboutTab;
	private javax.swing.JPanel jArenaPanel;
	private javax.swing.JMenuItem jExitButton;
	private javax.swing.JPanel jLastLogPanel;
	private javax.swing.JMenu jMenuTab;
	private javax.swing.JPanel jNursery;
	private javax.swing.JPanel jSafariPanel;
	private javax.swing.JPopupMenu.Separator jSeparator;
	private javax.swing.JTabbedPane jTabs;
	private javax.swing.JMenuBar jTopMenuBar;
	private javax.swing.JLabel jWelcomeBackgroundLeft;
	private javax.swing.JLabel jWelcomeBackgroundRight;
	private javax.swing.JTextField jWelcomeInteractionField;
	private javax.swing.JPanel jWelcomeInteractionPanel;
	private javax.swing.JPanel jWelcomePanel;
	private javax.swing.JPanel jZooPanel;

	public UserInterface() {
		initComponents();
	}

	private void initComponents() {

		jTabs = new javax.swing.JTabbedPane();
		jWelcomePanel = new javax.swing.JPanel();
		jWelcomeBackgroundLeft = new javax.swing.JLabel();
		jWelcomeBackgroundRight = new javax.swing.JLabel();
		jWelcomeInteractionPanel = new javax.swing.JPanel();
		jWelcomeInteractionField = new javax.swing.JTextField();
		jZooPanel = new javax.swing.JPanel();
		jArenaPanel = new javax.swing.JPanel();
		jNursery = new javax.swing.JPanel();
		jSafariPanel = new javax.swing.JPanel();
		jLastLogPanel = new javax.swing.JPanel();
		jTopMenuBar = new javax.swing.JMenuBar();
		jMenuTab = new javax.swing.JMenu();
		jExitButton = new javax.swing.JMenuItem();
		jAboutTab = new javax.swing.JMenu();
		jAboutProgram = new javax.swing.JMenuItem();
		jSeparator = new javax.swing.JPopupMenu.Separator();
		jAboutProgrammer = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Inheritance v6");
		setBounds(new java.awt.Rectangle(0, 0, 0, 0));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setMaximumSize(new java.awt.Dimension(1280, 720));
		setPreferredSize(new java.awt.Dimension(1280, 720));
		setResizable(false);
		setSize(new java.awt.Dimension(1280, 720));

		jTabs.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
		jTabs.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jTabs.setName("jTabs"); // NOI18N
		jTabs.setPreferredSize(new java.awt.Dimension(1280, 720));

		jWelcomePanel.setName("jWelcomePanel"); // NOI18N

		jWelcomeBackgroundLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/welcomeBackground.jpg"))); // NOI18N
		jWelcomeBackgroundLeft.setIconTextGap(0);
		jWelcomeBackgroundLeft.setName("jWelcomeBackgroundLeft"); // NOI18N

		jWelcomeBackgroundRight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jWelcomeBackgroundRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/welcomeBackground.jpg"))); // NOI18N
		jWelcomeBackgroundRight.setIconTextGap(0);
		jWelcomeBackgroundRight.setName("jWelcomeBackgroundRight"); // NOI18N

		jWelcomeInteractionPanel
				.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jWelcomeInteractionPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jWelcomeInteractionPanel.setName("jWelcomeInteractionPanel"); // NOI18N

		jWelcomeInteractionField.setBackground(new java.awt.Color(255, 255, 255));
		jWelcomeInteractionField.setForeground(java.awt.SystemColor.textInactiveText);
		jWelcomeInteractionField.setText("Type your interaction and hit ENTER");
		jWelcomeInteractionField.setName("jWelcomeInteractionField"); // NOI18N

		javax.swing.GroupLayout jWelcomeInteractionPanelLayout = new javax.swing.GroupLayout(jWelcomeInteractionPanel);
		jWelcomeInteractionPanel.setLayout(jWelcomeInteractionPanelLayout);
		jWelcomeInteractionPanelLayout
				.setHorizontalGroup(
						jWelcomeInteractionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jWelcomeInteractionPanelLayout.createSequentialGroup().addGap(80, 80, 80)
										.addComponent(jWelcomeInteractionField, javax.swing.GroupLayout.PREFERRED_SIZE,
												500, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(284, Short.MAX_VALUE)));
		jWelcomeInteractionPanelLayout.setVerticalGroup(
				jWelcomeInteractionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jWelcomeInteractionPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(jWelcomeInteractionField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(168, Short.MAX_VALUE)));

		javax.swing.GroupLayout jWelcomePanelLayout = new javax.swing.GroupLayout(jWelcomePanel);
		jWelcomePanel.setLayout(jWelcomePanelLayout);
		jWelcomePanelLayout
				.setHorizontalGroup(jWelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jWelcomePanelLayout.createSequentialGroup()
								.addComponent(jWelcomeBackgroundLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jWelcomeInteractionPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jWelcomeBackgroundRight, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)));
		jWelcomePanelLayout.setVerticalGroup(jWelcomePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jWelcomePanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(jWelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jWelcomeBackgroundRight, javax.swing.GroupLayout.PREFERRED_SIZE, 699,
										Short.MAX_VALUE)
								.addComponent(jWelcomeBackgroundLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
										Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(jWelcomePanelLayout.createSequentialGroup().addGap(482, 482, 482)
						.addComponent(jWelcomeInteractionPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jTabs.addTab("Welcome", null, jWelcomePanel, "");

		jZooPanel.setName("jZooPanel"); // NOI18N

		javax.swing.GroupLayout jZooPanelLayout = new javax.swing.GroupLayout(jZooPanel);
		jZooPanel.setLayout(jZooPanelLayout);
		jZooPanelLayout.setHorizontalGroup(jZooPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1280, Short.MAX_VALUE));
		jZooPanelLayout.setVerticalGroup(jZooPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 681, Short.MAX_VALUE));

		jTabs.addTab("Zoo", jZooPanel);

		jArenaPanel.setName("jArenaPanel"); // NOI18N

		javax.swing.GroupLayout jArenaPanelLayout = new javax.swing.GroupLayout(jArenaPanel);
		jArenaPanel.setLayout(jArenaPanelLayout);
		jArenaPanelLayout.setHorizontalGroup(jArenaPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1280, Short.MAX_VALUE));
		jArenaPanelLayout.setVerticalGroup(jArenaPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 681, Short.MAX_VALUE));

		jTabs.addTab("Arena", jArenaPanel);

		jNursery.setName("jNursery"); // NOI18N

		javax.swing.GroupLayout jNurseryLayout = new javax.swing.GroupLayout(jNursery);
		jNursery.setLayout(jNurseryLayout);
		jNurseryLayout.setHorizontalGroup(jNurseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 1280, Short.MAX_VALUE));
		jNurseryLayout.setVerticalGroup(jNurseryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 681, Short.MAX_VALUE));

		jTabs.addTab("Nursery", jNursery);

		jSafariPanel.setName("jSafariPanel"); // NOI18N

		javax.swing.GroupLayout jSafariPanelLayout = new javax.swing.GroupLayout(jSafariPanel);
		jSafariPanel.setLayout(jSafariPanelLayout);
		jSafariPanelLayout.setHorizontalGroup(jSafariPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1280, Short.MAX_VALUE));
		jSafariPanelLayout.setVerticalGroup(jSafariPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 681, Short.MAX_VALUE));

		jTabs.addTab("Safari", jSafariPanel);

		jLastLogPanel.setName("jLastLogPanel"); // NOI18N

		javax.swing.GroupLayout jLastLogPanelLayout = new javax.swing.GroupLayout(jLastLogPanel);
		jLastLogPanel.setLayout(jLastLogPanelLayout);
		jLastLogPanelLayout.setHorizontalGroup(jLastLogPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1280, Short.MAX_VALUE));
		jLastLogPanelLayout.setVerticalGroup(jLastLogPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 681, Short.MAX_VALUE));

		jTabs.addTab("Last Log", jLastLogPanel);

		jTopMenuBar.setName("jTopMenuBar"); // NOI18N

		jMenuTab.setText("Main Menu");
		jMenuTab.setName("jMenuTab"); // NOI18N

		jExitButton.setText("Exit");
		jExitButton.setName("jExitButton"); // NOI18N
		jMenuTab.add(jExitButton);

		jTopMenuBar.add(jMenuTab);

		jAboutTab.setText("About");
		jAboutTab.setName("jAboutTab"); // NOI18N

		jAboutProgram.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		jAboutProgram.setText("The Program");
		jAboutProgram.setToolTipText(
				"<html>Hello, and welcome to Inheritance park! This isn't really a program with a practical use outside of a concept demonstration,<br>feel free, however, to experiment to your heart's desire. Hell, if you can manage to break it and send me the log I'd be more than grateful.</html>");
		jAboutProgram.setEnabled(false);
		jAboutProgram.setName("jAboutProgram"); // NOI18N
		jAboutTab.add(jAboutProgram);

		jSeparator.setName("jSeparator"); // NOI18N
		jAboutTab.add(jSeparator);

		jAboutProgrammer.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
		jAboutProgrammer.setText("The Programmer");
		jAboutProgrammer.setToolTipText(
				"<html>This program was develop in November of 2021 by Lautaro Fonseca,<br> as part of a training programme from Solvd, Inc.</html>");
		jAboutProgrammer.setEnabled(false);
		jAboutProgrammer.setName("jAboutProgrammer"); // NOI18N
		jAboutTab.add(jAboutProgrammer);

		jTopMenuBar.add(jAboutTab);

		setJMenuBar(jTopMenuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1280,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 714, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UserInterface().setVisible(true);
			}
		});
	}
}
