package kr.ac.green;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// 컴포넌트 변경
public class SetComponent extends JComponent implements Serializable{
	public static final Dimension BTN_SIZE = new Dimension(110, 40);
	public static void setLookAndFeel() {
		try {	
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {
		}
	}

	public static void setButton(JButton btn) {
		btn.setPreferredSize(BTN_SIZE);
		btn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
	}

	public static void setLabel(JLabel lbl) {
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		lbl.setPreferredSize(new Dimension(80, 40));
	}
	public static void setCMDLabel(JLabel lbl) {
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		lbl.setPreferredSize(new Dimension(80, 40));
		lbl.setBackground(Color.WHITE);
		lbl.setOpaque(true);
	}
	public static void setDatePanel(JPanel pnl) {
		pnl.setBorder(new LineBorder(Color.BLACK, 2));
		pnl.setPreferredSize(new Dimension(80, 40));
	}
	public static void setItemPanel(JPanel pnl) {
		pnl.setPreferredSize(new Dimension(300, 30));
		pnl.setBackground(Color.WHITE);
	}
	public static void setItemPanel2(JPanel pnl) {
		pnl.setPreferredSize(new Dimension(130, 30));
		pnl.setBackground(Color.WHITE);
	}
	public static void setDateLabel(JLabel lbl) {
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
		lbl.setPreferredSize(new Dimension(150, 40));
	}
	public static void setPanel(JPanel pnl) {
		pnl.setPreferredSize(new Dimension(200, 200));
	}
}