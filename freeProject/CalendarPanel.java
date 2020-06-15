package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//년과 월마다 달력 패널
public class CalendarPanel extends JPanel implements Serializable {
	private JPanel pnlCenter;
	private JPanel pnlCNorth;
	private JPanel pnlCCenter;

	private JLabel[] btnDayOfWeek;
	private JButton[] btnDays;

	private int startDay;
	private int lastDay;

	private String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };

	private CalendarDateCalculation calendar;
	private MainAccountBook book;

	private DlgDaily[] daily;

	private int year;
	private int month;

	private ArrayList<FileRecorder> frList;
	private ArrayList<DlgDailyPanel> ddpList;
	private JPanel setPnl;


	public CalendarPanel(MainAccountBook book, int start, int last) {
		calendar = new CalendarDateCalculation();
		this.book = book;
		this.year = start;
	
		startDay = calendar.result(start, last);
		lastDay = calendar.getMonthArr()[last-1];
		init();
		setDisplay();
		for (int i = startDay; i <= lastDay + startDay - 1; i++) {
			addListeners(i);
		}
	}

	// 저장한 시점
	public CalendarPanel(MainAccountBook book, int start, int last, boolean flag) {
		calendar = new CalendarDateCalculation();
		this.book = book;
		this.year = start;
		this.month = last;
		startDay = calendar.result(start, last);
		lastDay = calendar.getMonthArr()[last - 1];
		init();
		setDisplay();
		for (int i = startDay; i <= lastDay + startDay - 1; i++) {
			saveAddListeners(i);
		}
	}

	public JPanel getSetPnl() {
		return setPnl;
	}

	public void setSetPnl(JPanel setPnl) {
		this.setPnl = setPnl;
	}

	public int getBtnDaysLength() {
		return btnDays.length;
	}

	public JButton[] getBtnDays() {
		return btnDays;
	}

	public void setBtnDays(JButton[] btnDays) {
		this.btnDays = btnDays;
	}

	public ArrayList<FileRecorder> getFrList() {
		return frList;
	}

	public void setFrList(ArrayList<FileRecorder> frList) {
		this.frList = frList;
	}

	public ArrayList<DlgDailyPanel> getDdpList() {
		return ddpList;
	}

	public void setDdpList(ArrayList<DlgDailyPanel> ddpList) {
		this.ddpList = ddpList;
	}

	public DlgDaily[] getDaily() {
		return daily;
	}

	public void setDaily(DlgDaily[] daily) {
		this.daily = daily;
	}

	private void init() {
		setLayout(new BorderLayout());

		pnlCenter = new JPanel(new BorderLayout());
		pnlCNorth = new JPanel(new GridLayout(0, 7));
		pnlCCenter = new JPanel(new GridLayout(0, 7));

		daily = new DlgDaily[42];
		btnDayOfWeek = new JLabel[7];
		btnDays = new JButton[42];
		frList = new ArrayList<>();
		ddpList = new ArrayList<>();
		setPnl = new JPanel(new GridLayout(0, 1));


	}

	private void setDisplay() {

		setCalendar();

		pnlCenter.add(pnlCNorth, BorderLayout.NORTH);
		pnlCenter.add(pnlCCenter, BorderLayout.CENTER);

		pnlCenter.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));

		add(pnlCenter, BorderLayout.CENTER);
	}

	private void setCalendar() { // 월마다 달력 변경
		for (int i = 0; i < btnDayOfWeek.length; i++) {
			btnDayOfWeek[i] = new JLabel(dayOfWeek[i], JLabel.CENTER);
			btnDayOfWeek[i].setBorder(new LineBorder(Color.BLACK, 1));
			btnDayOfWeek[i].setBackground(Color.WHITE);
			btnDayOfWeek[i].setOpaque(true);
			pnlCNorth.add(btnDayOfWeek[i]);
		}
		for (int i = 0; i < btnDays.length; i++) {

			if (i >= startDay && i <= lastDay + startDay - 1) {
				btnDays[i] = new JButton(i - startDay + 1 + " ");
				btnDays[i].setHorizontalAlignment(JButton.LEFT);
				btnDays[i].setVerticalAlignment(JButton.TOP);
				btnDays[i].setOpaque(true);

				if (i % 7 == 0) {
					btnDays[i].setForeground(Color.RED);
				} else if (i % 7 == 6) {
					btnDays[i].setForeground(Color.BLUE);
				}
				
				btnDays[i].setBackground(Color.WHITE);

				btnDays[i].setBorder(new LineBorder(Color.BLACK, 1));
				
				pnlCCenter.add(btnDays[i]);

			} else {
				btnDays[i] = new JButton("x");
				btnDays[i].setBorder(new LineBorder(Color.BLACK, 1));
				btnDays[i].setBackground(new Color(0xd1c0b9));
				btnDays[i].setEnabled(false);
				pnlCCenter.add(btnDays[i]);
			}
		}
	}

	private void addListeners(int i) {
		ActionListener listener = (ae) -> {
			Object src = ae.getSource();
			if (btnDays[i] == src) {
				try {
					StringTokenizer tz = new StringTokenizer(btnDays[i].getText(), " ");
					if (btnDays[i].getText().length() > 3) {
						tz.nextToken();
						daily[i].setVisible(true);
					} else {
						daily[i] = new DlgDaily(book, i, Integer.parseInt(tz.nextToken()), this);
						daily[i].setVisible(true);
					}
				} catch (NumberFormatException e) {
				}
			}
		};
		btnDays[i].addActionListener(listener);
	}

	private void saveAddListeners(int i) {
		ActionListener listener = (ae) -> {
			Object src = ae.getSource();
			if (btnDays[i] == src) {
				String zero = "";
				if (month < 10) {
					zero += "0";
				}
				String fileName = "dats/" + year + "년  " + zero + month + "월  " + (i - startDay + 1) + "일.dat";
				boolean flag = true;
				FileInputStream fis = null;
				DataInputStream dis = null;
				ddpList = new ArrayList<>();

				try {

					StringTokenizer tz = new StringTokenizer(btnDays[i].getText(), " ");
					if (btnDays[i].getText().length() > 3) {
						tz.nextToken();
					}
					daily[i] = new DlgDaily(book, i, Integer.parseInt(tz.nextToken()), this);
					if (btnDays[i].getText().length() <= 3 && flag) {
						daily[i].setVisible(true);
						flag = false;
					}
					fis = new FileInputStream(fileName);
					dis = new DataInputStream(fis);

					int idx = 0;

					while (dis.available() > 0) {
						int j = 0;

						String[] list = new String[5];
						StringTokenizer lineTok = new StringTokenizer(dis.readUTF(), " ");
						ddpList.add(new DlgDailyPanel(daily[i], idx));
						while (lineTok.hasMoreTokens()) {
							try {
							list[j] = lineTok.nextToken();
							int index = list[j].indexOf(":");
							list[j] = list[j].substring(index + 1, list[j].length());
							j++;
							} catch(ArrayIndexOutOfBoundsException e) {}
						}
						String hour = list[0].substring(20, list[0].indexOf("시"));
						String minute = list[0].substring(list[0].indexOf("시") + 1, list[0].indexOf("분"));
						String inOut = list[1];
						String option = list[2];
						String amount = list[3];
						String detail = list[4];

						ddpList.get(idx).getLblHour().setText(hour);
						ddpList.get(idx).getLblMinute().setText(minute);
						ddpList.get(idx).getLblAmount().setText(amount);
						ddpList.get(idx).getLblOption().setText(option);
						ddpList.get(idx).getLblDetail().setText(detail);

						frList.add(new FileRecorder(hour, minute, inOut, option, Integer.parseInt(amount), detail));
						idx++;
					}
					for (int j = 0; j < frList.size(); j++) {
						setPnl.add(ddpList.get(j));
					}

					daily[i].add(setPnl, BorderLayout.CENTER);
					daily[i].pack();
					if (flag) {
						daily[i].setVisible(true);
					}
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				} catch (NullPointerException e) {

				} finally {
					MyUtils.closeAll(dis, fis);
				}

			}
			frList = new ArrayList<>();
			setPnl = new JPanel(new GridLayout(0, 1));
		};
		btnDays[i].addActionListener(listener);
		
	}
}