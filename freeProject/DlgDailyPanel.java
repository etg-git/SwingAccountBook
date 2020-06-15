package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// 내역추가한 내용 패널
public class DlgDailyPanel extends JPanel implements Serializable{
	
	private JLabel lblHour;
	private JLabel lblMinute;
	private JLabel lblOption;
	private JLabel lblAmount;
	private JLabel lblDetail;
	
	private JPanel pnlTime;
	private JPanel pnlOption;
	private JPanel pnlAmount;
	private JPanel pnlDetail;
	
	private JPanel pnlMain;
	
	private DlgDaily daily;
	
	private DlgDailyEditor ed;
	
	private int index;
	public DlgDailyPanel(DlgDaily daily, int i) {
		this.daily = daily;
		index = i;
		init();
		setDisplay();
		addListeners();
	}

	public JLabel getLblHour() {
		return lblHour;
	}

	public void setLblHour(JLabel lblHour) {
		this.lblHour = lblHour;
	}
	public JLabel getLblMinute() {
		return lblMinute;
	}

	public void setLblMinute(JLabel lblMinute) {
		this.lblMinute = lblMinute;
	}

	public JLabel getLblOption() {
		return lblOption;
	}
	
	public DlgDaily getDaily() {
		return daily;
	}

	public void setDaily(DlgDaily daily) {
		this.daily = daily;
	}

	public void setLblOption(JLabel lblOption) {
		this.lblOption = lblOption;
	}
	

	public JLabel getLblAmount() {
		return lblAmount;
	}


	public void setLblAmount(JLabel lblAmount) {
		this.lblAmount = lblAmount;
	}


	public JLabel getLblDetail() {
		return lblDetail;
	}
	

	public void setLblDetail(JLabel lblDetail) {
		this.lblDetail = lblDetail;
	}

	private void init() {
		lblHour = new JLabel("시간", JLabel.CENTER);
		lblMinute = new JLabel("분", JLabel.CENTER);
		lblOption = new JLabel("항목");
		lblAmount = new JLabel("입출금액");
		lblDetail = new JLabel("상세내역");
		
		pnlTime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlOption = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlAmount = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlDetail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pnlMain = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));		
	}
	private void setDisplay() {
		SetComponent.setItemPanel2(pnlTime);
		SetComponent.setItemPanel2(pnlAmount);
		SetComponent.setItemPanel2(pnlOption);
		SetComponent.setItemPanel(pnlDetail);
		
		lblHour.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		lblMinute.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		lblAmount.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		lblOption.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		lblDetail.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		pnlTime.add(new JLabel(new ImageIcon("image/clock.png")));
		pnlTime.add(lblHour);
		pnlTime.add(new JLabel("시"));
		pnlTime.add(lblMinute);
		pnlTime.add(new JLabel("분"));
		pnlOption.add(new JLabel(new ImageIcon("image/item.png")));
		pnlOption.add(lblOption);
		pnlAmount.add(new JLabel(new ImageIcon("image/money.png")));
		pnlAmount.add(lblAmount);
		pnlAmount.add(new JLabel("원"));
		pnlDetail.add(new JLabel(new ImageIcon("image/details.png")));
		pnlDetail.add(lblDetail);
		pnlDetail.setPreferredSize(new Dimension(300,30));
		
		pnlMain.setBorder(new TitledBorder(new LineBorder(new Color(0x9966FF)), "추가내역"));
		pnlMain.setOpaque(true);
		pnlMain.setBackground(Color.WHITE);
		pnlMain.add(pnlTime);
		pnlMain.add(pnlOption);
		pnlMain.add(pnlAmount);
		pnlMain.add(pnlDetail);
		
		
		add(pnlMain, BorderLayout.CENTER);
	}
	
	private void addListeners() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				if(me.getButton() == me.BUTTON1) {
					ed	= new DlgDailyEditor(daily, DlgDailyPanel.this, index, lblHour.getText(), lblMinute.getText(),
							lblOption.getText(), lblAmount.getText(), lblDetail.getText());	
					ed.setVisible(true);
				}
			}
		});
	}
}