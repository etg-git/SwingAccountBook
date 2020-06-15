package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// 내역추가 기능 클래스
public class DlgDaily extends JDialog implements Serializable {
	// north
	private JPanel pnlNorth;
	private JButton btnBefore;
	private JLabel lblDate;
	private JButton btnAdd;

	// center
	private ArrayList<DlgDailyPanel> pnlList;
	private ArrayList<DlgDailyPanel> savePnlList;
	
	
	private ArrayList<FileRecorder> saveFrList;
	private JPanel pnlCenter;
	private JPanel pnlSouth;
	private MainAccountBook book;

	private int index;
	private int btnIdx;
	private DlgDailyEditor editor;

	private JPanel setPnl;
	public DlgDaily(MainAccountBook book, int i, int btnIdx, CalendarPanel cp) {
		super(book, "Daily", true);
		this.book = book;
		index = i;
		this.btnIdx = btnIdx;
		this.saveFrList = cp.getFrList(); // 저장된 리스트
		savePnlList = cp.getDdpList();
		setPnl = cp.getSetPnl();
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	public JPanel getPnlCenter() {
		return pnlCenter;
	}

	public void setPnlCenter(JPanel pnlCenter) {
		this.pnlCenter = pnlCenter;
	}

	public ArrayList<FileRecorder> getSaveFrList() {
		return saveFrList;
	}

	public void setSaveFrList(ArrayList<FileRecorder> saveFrList) {
		this.saveFrList = saveFrList;
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public JPanel getSetPnl() {
		return setPnl;
	}

	public void setSetPnl(JPanel setPnl) {
		this.setPnl = setPnl;
	}

	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}

	public ArrayList<DlgDailyPanel> getPnlList() {
		return pnlList;
	}

	public void setPnlList(ArrayList<DlgDailyPanel> pnlList) {
		this.pnlList = pnlList;
	}

	public ArrayList<DlgDailyPanel> getSavePnlList() {
		return savePnlList;
	}

	public void setSavePnlList(ArrayList<DlgDailyPanel> savePnlList) {
		this.savePnlList = savePnlList;
	}

	private void init() {
		SetComponent.setLookAndFeel();

		pnlNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
		btnBefore = new JButton(new ImageIcon("image/before.png"));
		lblDate = new JLabel(book.getCbYear().getSelectedItem() + "년  " + book.getCbMonth().getSelectedItem() + "월  "
				+ btnIdx + "일");
		btnAdd = new JButton("내역추가");
		pnlCenter = new JPanel(new GridLayout(0,1));
		editor = new DlgDailyEditor(this);
		editor.setVisible(false);
		
		pnlSouth = new JPanel(new GridLayout(0,1));
	}

	private void setDisplay() {
		pnlNorth.add(btnBefore);
		pnlNorth.add(lblDate);
		pnlNorth.add(btnAdd);

		SetComponent.setButton(btnBefore);
		SetComponent.setButton(btnAdd);
		SetComponent.setDateLabel(lblDate);
		add(pnlNorth, BorderLayout.NORTH);
	}

	private void addListeners() {
		ActionListener alsnr = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if (src == btnAdd) {
					editor.getBtnDelete().setVisible(false);
					editor.setVisible(true);
				} else if (src == btnBefore) {
					before();
					setVisible(false);
				}
			}
		};
		btnAdd.addActionListener(alsnr);
		btnBefore.addActionListener(alsnr);
	}

	// 월마다 달력 변경하고 center에다가 add
	public void setCenter(ArrayList<FileRecorder> list) {
		pnlList = new ArrayList<>();
		setPnl.setVisible(false);
		pnlSouth.setVisible(false);
		pnlSouth = new JPanel(new GridLayout(0,1));
		saveFrList = new ArrayList<>();
		ArrayList<FileRecorder> fList = new ArrayList<>();
		// add
		for (int i = 0; i < list.size(); i++) {
			pnlList.add(new DlgDailyPanel(this,i));
			pnlList.get(i).getLblHour().setText(list.get(i).getHour());
			pnlList.get(i).getLblMinute().setText(list.get(i).getMinute());
			pnlList.get(i).getLblOption().setText(list.get(i).getOption());
			pnlList.get(i).getLblAmount().setText(String.valueOf(list.get(i).getAmount()));
			pnlList.get(i).getLblDetail().setText(list.get(i).getDetails());
			pnlSouth.add(pnlList.get(i));
			fList.add(list.get(i));	
		}
		
		saveFrList = fList;
		add(pnlSouth, BorderLayout.SOUTH);
		
		pack();
	}

	// 이전버튼(지출, 수입 합계 캘린더에 띄우기)
	private void before() {
		JLabel expenditure;
		JLabel income;
		for (Integer key : book.getCalendarMap().keySet()) {
			CalendarPanel pnl = book.getCalendarMap().get(key);
			if (Integer
					.parseInt(book.getCbYear().getSelectedItem() + "" + book.getCbMonth().getSelectedItem()) == key) {
				income = new JLabel("수입  : " + "\n");
				expenditure = new JLabel("지출 : " + "\n");
				FileWriter fw = null;
				String idx = "";
				if (btnIdx <= 9) {
					idx = "0" + btnIdx;
				} else {
					idx = "" + btnIdx;
				}
				String fileName = "account/" + book.getCbYear().getSelectedItem().toString() + ""
						+ book.getCbMonth().getSelectedItem().toString() + idx + "Account.dat";
				try {
					fw = new FileWriter(fileName);
					
					for (int i = 0; i < saveFrList.size(); i++) {
						if (saveFrList.get(i).getInAndOut().equals("수입")) {
							fw.write("수입:" + saveFrList.get(i).getAmount() + "항목:" + saveFrList.get(i).getOption()
									+ "\n");
						} else {
							fw.write("지출:" + saveFrList.get(i).getAmount() + "항목:" + saveFrList.get(i).getOption()
									+ "\n");
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					MyUtils.closeAll(fw);
				}
				int totalIncome = 0;
				int totalExpenditure = 0;
				FileReader fr = null;
				BufferedReader br = null;
				String line = null;
				try {
					fr = new FileReader(fileName);
					br = new BufferedReader(fr);

					while ((line = br.readLine()) != null) {
						int index = line.indexOf(":");
						int amountIndex = line.indexOf("항목:");
						String name = line.substring(0, index);
						String amount = line.substring(index + 1, amountIndex);
						if (name.equals("수입")) {
							totalIncome += Long.parseLong(amount);
						} else {
							totalExpenditure += Long.parseLong(amount);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (totalIncome == 0 && totalExpenditure == 0) {
					pnl.getBtnDays()[index].setText("" + btnIdx);
				} else {
					pnl.getBtnDays()[index].setText(
							"<html> " + btnIdx + " <br/><font Color:blue>" + income.getText() + "" + totalIncome
									+ "원<br/>" + expenditure.getText() + "" + totalExpenditure + "원</font></html>");
				}
			}
		}
	}

	private void showFrame() {
		pack();
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}