package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// 현재월에대한 상세내역
public class DlgCurrentMonthDetails extends JDialog implements Serializable{
	public static final Dimension SIZE_OF_LBLTITLE = new Dimension(500, 20);

	// North - components
	private JButton btnBack;
	private JLabel lblTitle;

	private JLabel lblMonthlyBalance;
	private JLabel lblFromLastMonth;

	private JLabel lblMonthlyExpenditure;
	private JLabel lblMonthlyIncome;

	private JLabel lblMonthlyHighestExpenditure;
	private JLabel lblMonthlyHighestIncome;

	// pnlCenter
	private JPanel pnlFirstLine;
	private JPanel pnlSecondLine;
	private JPanel pnlThirdLine;
	private JPanel pnlFourthLine;

	private JPanel pnlFourthLineDetails;

	private JPanel pnlNorth;
	private JPanel pnlCenter;

	private JPanel pnlMain;

	private MainAccountBook book;

	public DlgCurrentMonthDetails(MainAccountBook owner) {

		super(owner, "상세분석", true);
		this.book = owner;

		init();
		setDisplay();
		monthDetails();
		lastMonthAccount();
		totalAccountOption();
		addListeners();
		showFrame();
	}

	private void init() {
		// n
		btnBack = new JButton(new ImageIcon("image/before.png"));
		lblTitle = new JLabel("   " + book.getYearSelected() + "년 " + book.getMonthSelected() + "월간 상세내역   ");
		lblTitle.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 25));
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setOpaque(true);
		lblTitle.setForeground(Color.WHITE);
		// 1
		lblMonthlyBalance = new JLabel("   " + book.getMonthSelected().toString() + "월간 수입-지출   ");
		
		lblMonthlyBalance.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 25));
		lblMonthlyBalance.setForeground(Color.WHITE);
		lblMonthlyBalance.setBackground(Color.BLACK);
		lblMonthlyBalance.setOpaque(true);
		// 2
		lblMonthlyExpenditure = new JLabel("월간 지출  :  ");
		SetComponent.setCMDLabel(lblMonthlyExpenditure);
		lblMonthlyExpenditure.setForeground(Color.RED);
		lblMonthlyExpenditure.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "월간지출", 0, TitledBorder.BELOW_TOP));
		
		lblMonthlyIncome = new JLabel("월간 수입  :  ");
		SetComponent.setCMDLabel(lblMonthlyIncome);
		lblMonthlyIncome.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "월간수입", 0, TitledBorder.BELOW_TOP));
		lblMonthlyIncome.setForeground(Color.BLUE);
		
		lblFromLastMonth = new JLabel("이월 금액  : ");
		SetComponent.setCMDLabel(lblFromLastMonth);
		lblFromLastMonth.setForeground(new Color(0x00cc00));
		lblFromLastMonth.setBorder(new TitledBorder(new LineBorder(new Color(0x00cc00), 2), "이월금액", 0, TitledBorder.BELOW_TOP));
		// 3
		lblMonthlyHighestExpenditure = new JLabel("월간 최대지출  :  ");
		SetComponent.setCMDLabel(lblMonthlyHighestExpenditure);
		lblMonthlyHighestExpenditure.setForeground(Color.RED);
		lblMonthlyHighestExpenditure.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "월지출", 0, TitledBorder.BELOW_TOP));
		
		lblMonthlyHighestIncome = new JLabel("월간 최대수입  :  ");
		SetComponent.setCMDLabel(lblMonthlyHighestIncome);
		lblMonthlyHighestIncome.setForeground(Color.BLUE);
		lblMonthlyHighestIncome.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "월수입", 0, TitledBorder.BELOW_TOP));

		// pnl1,2,3,4, n,c
		pnlFirstLine = new JPanel();
		pnlSecondLine = new JPanel();
		pnlThirdLine = new JPanel();
		pnlFourthLine = new JPanel();

		pnlFourthLineDetails = new JPanel();

		pnlNorth = new JPanel();
		pnlCenter = new JPanel();

		pnlMain = new JPanel();
	}

	private void setDisplay() {

		SetComponent.setButton(btnBack);
		pnlNorth.setPreferredSize(new Dimension(500, 100));

		// pnlFirstLine.setLayout(new GridLayout(0, 1));
		pnlFirstLine.setBorder(new EmptyBorder(0, 30, 0, 30));
		pnlFirstLine.add(new JLabel(new ImageIcon("image/left.jpg")));
		pnlFirstLine.add(lblMonthlyBalance);
		pnlFirstLine.add(new JLabel(new ImageIcon("image/right.jpg")));
		pnlFirstLine.setBackground(Color.BLACK);
		pnlFirstLine.setBorder(new LineBorder(Color.WHITE));
		lblMonthlyBalance.setHorizontalAlignment(JLabel.CENTER);
		// 2
		pnlSecondLine.setLayout(new GridLayout(0, 1));
		pnlSecondLine.setPreferredSize(new Dimension(200, 400));
		pnlSecondLine.add(lblMonthlyIncome);
		pnlSecondLine.add(lblMonthlyExpenditure);
		pnlSecondLine.add(lblFromLastMonth);
		// 3
		pnlSecondLine.add(lblMonthlyHighestExpenditure);
		pnlSecondLine.add(lblMonthlyHighestIncome);
		// 4
		pnlFourthLine.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "월간 내용", 0 , TitledBorder.BELOW_TOP));
		pnlFourthLine.setBackground(Color.WHITE);
		pnlFourthLineDetails.setLayout(new GridLayout(0, 2, 20, 20));
		pnlFourthLineDetails.setBorder(new LineBorder(Color.GRAY));
		pnlFourthLine.add(pnlFourthLineDetails);
		pnlFourthLine.setPreferredSize(new Dimension(200, 200));
		// n
		pnlNorth.add(btnBack);
		pnlNorth.add(lblTitle);
		lblTitle.setBorder(new LineBorder(Color.WHITE));
		pnlNorth.add(pnlFirstLine);
		// c
		pnlCenter.setLayout(new GridLayout(0, 1));
		
		pnlCenter.add(pnlSecondLine);

		// dlg
		
		pnlMain.setLayout(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(0, 10, 5, 10));
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(new JScrollPane(pnlFourthLine), BorderLayout.SOUTH);
		add(pnlMain, BorderLayout.CENTER);
		
		pnlMain.setBackground(Color.BLACK);
		pnlCenter.setBackground(Color.BLACK);
		pnlNorth.setBackground(Color.BLACK);
	}

	private void addListeners() {
		ActionListener alsnr = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if (src == btnBack) {
					dispose();
				}
			}
		};
		btnBack.addActionListener(alsnr);
	}
	//현재월의 최대지출,수입과 월에대한 수입과 지출합산
	private void monthDetails() {
		int maxIncome = 0;
		int maxExpenditure = 0;
		int sumIncome = 0;
		int sumExpenditure = 0;
		String maxIOption = "";
		String maxEOption = "";
		for (int i = 0; i < 31; i++) {
			String day = "";
			if(i <9) {
				day = "0" + (i+1); 
			} else {
				day = "" + (i+1);
			}
			String fileName = "account/" + book.getCbYear().getSelectedItem().toString() + ""
					+ book.getCbMonth().getSelectedItem().toString() + day + "Account.dat";
			FileReader fr = null;
			BufferedReader br = null;
			String line = null;
			try {
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);

				while ((line = br.readLine()) != null) {
					int index = line.indexOf(":");
					int amountIndex = line.indexOf("항목:");
					String account = line.substring(index + 1, amountIndex);
					String inOut = line.substring(0, index);
					String option = line.substring(line.lastIndexOf(":")+1, line.length());
					int money = Integer.parseInt(account);
					if (inOut.contentEquals("수입")) {
						sumIncome += money;
						if (maxIncome <= money) {
							maxIncome = money;
							maxIOption = option;
						}
					} else {
						if (maxExpenditure <= money) {
							sumExpenditure += money;
							maxExpenditure = money;
							maxEOption = option;
						}
					}
				}
			} catch (FileNotFoundException e1) {

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				MyUtils.closeAll(br, fr);
			}
		}
		lblMonthlyExpenditure.setText("월간 지출  :  " + sumExpenditure + "원");
		lblMonthlyIncome.setText("월간 수입  :  " + sumIncome + "원");
		lblMonthlyHighestExpenditure.setText("월간 최대 지출  :  " + maxExpenditure + "원(" + maxEOption +")");
		lblMonthlyHighestIncome.setText("월간 최대 수입  :  " + maxIncome + "원(" + maxIOption + ")");
	}
	// 이월금액 
	private void lastMonthAccount() {
		int lastTotal = 0;
		String zero = "";
		if (Integer.parseInt(book.getCbMonth().getSelectedItem().toString()) - 1 < 10) {
			zero += "0";
		}
		for (int i = 0; i < 31; i++) {
			String day = "" + (i + 1);
			String fileName = "account/" + book.getCbYear().getSelectedItem().toString() + zero
					+ (Integer.parseInt(book.getCbMonth().getSelectedItem().toString()) - 1) + "" + day + "Account.dat";
			FileReader fr = null;
			BufferedReader br = null;
			String line = null;
			try {
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);

				while ((line = br.readLine()) != null) {
					int index = line.indexOf(":");
					int amountIndex = line.indexOf("항목:");
					String account = line.substring(index + 1, amountIndex);
					String inOut = line.substring(0, index);
					int money = Integer.parseInt(account);
					if (inOut.equals("수입")) {
						lastTotal += money;
					} else {
						lastTotal -= money;
					}
				}
			} catch (FileNotFoundException e1) {
			}

			catch (IOException e) {
				e.printStackTrace();
			} finally {
				MyUtils.closeAll(br, fr);
			}
		}
		lblFromLastMonth.setText("이월 금액  :  " + lastTotal + "원");
	}
	// 항목에 대한 총 합산
	private void totalAccountOption() {
		HashMap<String, Integer> moneyMap = new HashMap<>();
		for (int i = 0; i < 31; i++) {
			String day = "" + (i + 1);
			if(i <= 9) {
				day = "0" + (i+1);
			}
			String fileName = "account/" + book.getCbYear().getSelectedItem().toString() + ""
					+ book.getCbMonth().getSelectedItem().toString() + day + "Account.dat";
			FileReader fr = null;
			BufferedReader br = null;
			String line = null;
			try {
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);
				
				while ((line = br.readLine()) != null) {
					int index = line.indexOf(":");
					int amountIndex = line.indexOf("항목:");
					String account = line.substring(index + 1, amountIndex);
					String option = line.substring(amountIndex + 3, line.length());
					int money = Integer.parseInt(account);

					if (moneyMap.containsKey(option)) {
						moneyMap.put(option, moneyMap.get(option) + money);
					} else {
						moneyMap.put(option, money);
					}
				}
			} catch (FileNotFoundException e1) {

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				MyUtils.closeAll(br, fr);
			}
		}
		for (String options : moneyMap.keySet()) {
			JLabel lbl = new JLabel(options +": " + moneyMap.get(options) +"원", JLabel.CENTER);
			lbl.setFont(new Font("휴먼매직체", Font.BOLD, 18));
			pnlFourthLineDetails.add(lbl);
			pnlFourthLineDetails.setBackground(new Color(0xFFFFCC));
		}
	}

	private void showFrame() {

		setSize(600,750);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}