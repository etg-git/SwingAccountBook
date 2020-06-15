package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//사용자지정기능 클래스
public class DlgSpecifiedDate extends JDialog {

	private MainAccountBook book;
	private CalendarPanel pnl;
	private CalendarDateCalculation calc = new CalendarDateCalculation();;

	// north
	private JButton btnBack;
	private JButton btnConfirm;
	private JLabel lblTitle;

	private JPanel pnlNorth;

	// center
	private JLabel lblStart;
	private JComboBox<String> cbxYearStart;
	private ArrayList<JComboBox<String>> cbxMonthStartList;
	private JComboBox<String> cbxMonthStart;
	private JComboBox<String> cbxDayStart;
	private JPanel pnlCenterNorthLeft;

	private JLabel lblRan;
	private JPanel pnlRan;

	private JLabel lblEnd;
	private JComboBox<Integer> cbxYearEnd;
	private ArrayList<JComboBox<Integer>> cbxMonthEndList;
	private JComboBox<Integer> cbxMonthEnd;
	private JComboBox<Integer> cbxDayEnd;
	private JPanel pnlCenterNorhtRight;

	private JPanel pnlCenterNorth;

	private JPanel pnlCenter;

	private JPanel pnlSouth;

	// =================지정기간출력============================
	private JLabel lblUserRange = new JLabel();
	private JTextArea taUserRange;

	private JLabel lblImage = new JLabel(new ImageIcon("image/complete.gif"));

	private HashMap<String, Integer> mapOption = new HashMap<>();
	private HashMap<String, Integer> mapOptionCount = new HashMap<>();

	private HashMap<String, Integer> op2Money = new HashMap<>();
	private HashMap<String, Integer> op2MoneyCount = new HashMap<>();
	private int startYear = 0;
	private int endYear = 0;
	private int startMonth = 0;
	private int endMonth = 0;
	private int startDay = 0;
	private int endDay = 0;

	private int days = 0;

	// =========================
	public DlgSpecifiedDate(MainAccountBook owner) {
		super(owner, "   << 사용자 지정구간 >>   ", true);
		this.book = owner;

		init();
		setDisplay();
		readAll();
		addListeners();
		showFrame();

	}

	private void init() {

		SetComponent.setLookAndFeel();
		cbxMonthStartList = new ArrayList<>();
		cbxMonthEndList = new ArrayList<>();
		btnBack = new JButton(new ImageIcon("image/before.png"));
		btnBack.setBackground(Color.WHITE);

		SetComponent.setButton(btnBack);
		btnConfirm = new JButton("확인");
		SetComponent.setButton(btnConfirm);
		btnConfirm.setBackground(Color.WHITE);
		lblTitle = new JLabel("사용자지정구간");
		lblTitle.setFont(new Font("휴면둥근헤드라인", Font.ITALIC, 25));
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setBorder(new EmptyBorder(10, 15, 10, 15));

		lblStart = new JLabel("구간 시작");
		lblEnd = new JLabel("구간 마감");

		// 시작년도 종료년도 설정
		cbxYearStart = new JComboBox<String>();
		cbxYearEnd = new JComboBox<Integer>();
		for (int i = 2000; i <= 2020; i++) {
			cbxYearStart.addItem(String.valueOf(i));
			cbxYearEnd.addItem(i);
		}
		// 시작월 종료월 설정
		cbxMonthStart = new JComboBox<>();
		cbxMonthEnd = new JComboBox<>();
		for (int i = 1; i < 13; i++) {
			cbxMonthStart.addItem(String.valueOf(i));
			cbxMonthEnd.addItem(i);
		}

		// 시작일종료일 설정

		int day = 0;
		for (int j = 0; j < 12; j++) {
			day = calc.getMonthArr(j);
			cbxDayStart = new JComboBox<String>();
			cbxDayEnd = new JComboBox<Integer>();

			for (int i = 1; i <= day; i++) {
				cbxDayStart.addItem(String.valueOf(i));
				cbxDayEnd.addItem(i);
			}
			cbxMonthStartList.add(cbxDayStart);
			cbxMonthEndList.add(cbxDayEnd);
		}
		// 범위
		lblRan = new JLabel("~");
		pnlRan = new JPanel();

		pnlCenterNorthLeft = new JPanel();
		pnlCenterNorhtRight = new JPanel();
		pnlCenterNorth = new JPanel();
		pnlCenter = new JPanel();

		pnlSouth = new JPanel();

		// 범위 레이블
		taUserRange = new JTextArea(25, 15);

		mapOption = new HashMap<>();
	}

	private void setDisplay() {

		pnlNorth = new JPanel();
		pnlNorth.setPreferredSize(new Dimension(200, 100));
		pnlNorth.setBackground(Color.WHITE);

		pnlNorth.add(btnBack);
		pnlNorth.add(lblTitle);
		pnlNorth.add(btnConfirm);
		lblTitle.setBackground(Color.WHITE);

		pnlCenterNorthLeft.add(lblStart);
		pnlCenterNorthLeft.add(cbxYearStart);
		pnlCenterNorthLeft.add(cbxMonthStart);
		pnlCenterNorthLeft.add(cbxDayStart);
		pnlCenterNorthLeft.setBackground(Color.WHITE);

		pnlRan.add(lblRan);
		pnlRan.setBackground(Color.WHITE);

		pnlCenterNorhtRight.add(lblEnd);
		pnlCenterNorhtRight.add(cbxYearEnd);
		pnlCenterNorhtRight.add(cbxMonthEnd);
		pnlCenterNorhtRight.add(cbxDayEnd);
		pnlCenterNorhtRight.setBackground(Color.WHITE);

		pnlCenterNorth.add(pnlCenterNorthLeft);
		pnlCenterNorth.add(pnlRan);
		pnlCenterNorth.add(pnlCenterNorhtRight);
		pnlCenterNorth.setBackground(Color.WHITE);

		pnlCenter.setLayout(new BorderLayout());
		pnlCenter.setPreferredSize(new Dimension(200, 300));
		pnlCenter.setBackground(Color.WHITE);
		pnlCenter.add(pnlCenterNorth, BorderLayout.NORTH);
		pnlCenter.add(lblImage);

		pnlSouth.setLayout(new BorderLayout());
		pnlSouth.setBackground(Color.WHITE);
		pnlSouth.setBorder(new EmptyBorder(10, 10, 20, 10));
		pnlSouth.add(new JScrollPane(taUserRange));

		pnlSouth.setPreferredSize(new Dimension(550, 300));
		pnlSouth.setVisible(false);
		lblImage.setVisible(false);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

	}

	private void addListeners() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if (src == btnBack) {
					dispose();
				} else if (src == btnConfirm) {
					warning();
					sectorRead();
					makeStr();
					if (DlgSpecifiedDate.this.count != 0) {
						taUserRange.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 20));
						TitledBorder title = new TitledBorder(new LineBorder(Color.WHITE), "총" + calcDays() + "일",
						TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
						title.setTitleFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 15));
						taUserRange.setBorder(title);
						lblUserRange.setText("==" + "일간 상세내역==");
						setSize(600, 900);
						pnlSouth.setVisible(true);
						lblImage.setVisible(true);
						setLocationRelativeTo(null);
						DlgSpecifiedDate.this.count = 0;
					} else {
						JOptionPane.showMessageDialog(DlgSpecifiedDate.this, "평균을 구할 항목이 없습니다.");
						setSize(600,400);
						setLocationRelativeTo(null);
						pnlSouth.setVisible(false);
						lblImage.setVisible(false);
					}

				}
			}
		};
		ActionListener alsnr = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JComboBox<?> jcb = (JComboBox<?>) ae.getSource();
				if (jcb == cbxMonthStart) {
					String index = jcb.getSelectedItem().toString();
					cbxDayStart.setVisible(false);
					cbxDayStart = cbxMonthStartList.get((Integer.parseInt(index) - 1));
					cbxDayStart.setVisible(true);
					pnlCenterNorthLeft.add(cbxDayStart);
				} else if (jcb == cbxMonthEnd) {
					String index = jcb.getSelectedItem().toString();
					cbxDayEnd.setVisible(false);
					cbxDayEnd = cbxMonthEndList.get((Integer.parseInt(index) - 1));
					cbxDayEnd.setVisible(true);
					pnlCenterNorhtRight.add(cbxDayEnd);
					cbxDayEnd.remove(0);
				}
			}
		};

		btnBack.addActionListener(listener);
		btnConfirm.addActionListener(listener);
		cbxMonthStart.addActionListener(alsnr);
		cbxMonthEnd.addActionListener(alsnr);
	}

	public void warning() {
		if (cbxYearStart.getSelectedIndex() > cbxYearEnd.getSelectedIndex()) {
			JOptionPane.showMessageDialog(this, "비교년도는 기준년도보다 작을수 없습니다");
			cbxYearEnd.setSelectedItem(cbxYearStart.getSelectedItem());
			if (cbxMonthStart.getSelectedIndex() > cbxMonthEnd.getSelectedIndex()) {
				JOptionPane.showMessageDialog(this, "비교월은 기준월보다 작을수 없습니다");
				cbxMonthEnd.setSelectedItem(cbxMonthStart.getSelectedItem());
				if (cbxDayStart.getSelectedIndex() > cbxDayEnd.getSelectedIndex()) {
					JOptionPane.showMessageDialog(this, "비교일은 기준일보다 작을수 없습니다");
					cbxDayEnd.setSelectedItem(cbxDayStart.getSelectedItem());
				}
			}
		}
	}

	private int k = 0;
	private int j = 0;
	private int i = 0;
	private String fileName = "";

	public void sectorRead() {

		startYear = Integer.parseInt(cbxYearStart.getSelectedItem().toString());
		endYear = Integer.parseInt(cbxYearEnd.getSelectedItem().toString());
		startMonth = Integer.parseInt(cbxMonthStart.getSelectedItem().toString());
		endMonth = Integer.parseInt(cbxMonthEnd.getSelectedItem().toString());
		startDay = Integer.parseInt(cbxDayStart.getSelectedItem().toString());
		endDay = Integer.parseInt(cbxDayEnd.getSelectedItem().toString());

		if (startMonth <= endMonth) {
			for (k = startYear; k <= endYear; k++) {
				for (j = startMonth; j <= endMonth; j++) {
					if (endMonth == j) {
						for (int i = 1; i <= Integer.parseInt(cbxDayEnd.getSelectedItem().toString()); i++) {
							fileRead(i);
						}
					} else {
						for (i = 1; i <= 31; i++) {
							fileRead(i);
						}
					}
				}
			}
		} else if (startMonth > endMonth) {
			for (k = startYear; k <= endYear; k++) {
				for (j = endMonth; j <= startMonth; j--) {
					if (endMonth == j) {
						for (i = 1; i <= Integer.parseInt(cbxDayEnd.getSelectedItem().toString()); i++) {
							fileRead(i);
						}
					} else {
						for (i = 1; i <= 31; i++) {
							fileRead(i);
						}
					}

				}
			}
		}
	}

	private int count = 0;

	public void fileRead(int i) {
		String dm = "";
		String dd = "";

		if (j < 10) {
			dm = "0";
			if (i < 10) {
				dd = "0";
				fileName = "account/" + k + dm + j + dd + i + "Account.dat";
			} else {
				fileName = "account/" + k + dm + j + dd + i + "Account.dat";
			}
		} else {
			if (i < 10) {
				fileName = "account/" + k + dm + j + dd + i + "Account.dat";
			} else {
				fileName = "account/" + k + dm + j + dd + i + "Account.dat";
			}
		}
		FileReader fr = null;
		BufferedReader br = null;

		String line = new String();
		String option = "";
		String strMoney = "";

		int money = 0;
		int count = 1;
		try {
			fr = new FileReader((String) fileName);
			br = new BufferedReader(fr);

			while ((line = br.readLine()) != null) {

				int start = line.indexOf(":");
				int ending = line.indexOf("항목:");

				option = line.substring(ending + 3);
				strMoney = line.substring(start + 1, ending);
				money = Integer.parseInt(strMoney);

				if (op2Money.containsKey(option)) {
					op2Money.put(option, op2Money.get(option) + money);
					op2MoneyCount.put(option, op2MoneyCount.get(option) + count);

				} else {
					op2Money.put(option, money);
					op2MoneyCount.put(option, count);
				}
				this.count++;
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException fnf) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(br, fr);
		}
	}

	public void makeStr() {
		StringBuffer sb = new StringBuffer();
		String temp = "\n" + startYear + "." + startMonth + "." + startDay + "~" + endYear + "." + endMonth + "."
				+ endDay + "\n";
		temp += "\n============항목별 구간평균 내역들=============\n\n";
		for (String keys : op2Money.keySet()) {
			int avgOp = (op2Money.get(keys)) / op2MoneyCount.get(keys);
			sb.append(keys + "의 구간 평균 : " + avgOp + "원\n");
			sb.append("\n");
		}
		
		sb.append("\n===========항목별 전체평균 내역들=============\n\n");
		for(String keys : mapOption.keySet()) {
			int avgMapOp = (mapOption.get(keys)) / mapOptionCount.get(keys);
			sb.append(keys + "의 전체 평균 : " + avgMapOp + "원\n");
			sb.append("\n");
		}
		
		String strSb = sb.toString();
		temp = temp + strSb;

		taUserRange.setText(temp);

		op2Money = new HashMap<>();
	}
	public HashMap<String, Integer> readAll() {

		CalendarDateCalculation calc = new CalendarDateCalculation();

		for (int i = 2000; i < 2021; i++) {
			for (int j = 1; j <= 12; j++) {
				for (int k = 1; k <= calc.getMonthArr(j - 1); k++) {

					String line = null;
					FileReader fr = null;
					BufferedReader br = null;

					String month = "";
					String day = "";

					if (j <= 9) {
						month = "0";
					}
					if (k <= 9) {
						day = "0";
					}

					String fileName = "account/" + i + month + j + day + k + "Account.dat";
					int count = 1;

					try {
						fr = new FileReader(fileName);
						br = new BufferedReader(fr);

						while ((line = br.readLine()) != null) {
							int moneyIndex = line.indexOf(":");

							int amountIndex = line.indexOf("항목:");
							int money = Integer.parseInt(line.substring(moneyIndex + 1, amountIndex));
							String option = line.substring(amountIndex + 3, line.length());

							if (mapOption.containsKey(option)) {
								mapOption.put(option, mapOption.get(option) + money);
								mapOptionCount.put(option, mapOptionCount.get(option) + count);

							} else {
								mapOption.put(option, money);
								mapOptionCount.put(option, count);
							}
						}
					} catch (FileNotFoundException e) {

					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						MyUtils.closeAll(br, fr);
					}

				}
			}
		}

		return mapOption;
	}

	// 얘는 그냥 레이블 꾸며주는 메서드n
	public String calcDays() {

		// c3
		int sumMonthC3 = 0;
		int c3 = 0;
		for (int i = 0; i < endMonth - 1; i++) {
			sumMonthC3 += calc.getMonthArr(i);
		}

		c3 = sumMonthC3 + (endDay);
		// c2
		int c2 = 0;
		int c2sy = startYear + 1;
		int c2ey = endYear - 1;
		int sumtemp1 = 0;
		int sumtemp2 = 0;
		for (int i = c2sy; i <= c2ey; i++) {
			if (calc.isLeapYear(i) == true) {
				sumtemp1 += 366;
			} else {
				sumtemp2 += 365;
			}
			c2 = sumtemp1 + sumtemp2;
		}
		// c1
		int c1 = 0;
		int sumMonthC1 = 0;
		if (startYear == endYear) {
		} else {
			for (int i = 0; i < startMonth - 1; i++) {
				sumMonthC1 += calc.getMonthArr(i);
			}
			if (calc.isLeapYear(startYear) == true) {
				c1 = 366 - (sumMonthC1 + startDay);
			} else {
				c1 = 365 - (sumMonthC1 + startDay);
			}
		}
		String sector = String.valueOf(c1 + c2 + c3);

		return sector;
	}

	private void showFrame() {

		setSize(600, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}