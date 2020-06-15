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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//비교분석 기능 클래스
public class DlgCompareAnalysis extends JDialog {

	public static final Dimension BTN_SIZE = new Dimension(60, 40);

	// 컴포넌트(패널제외)
	private JButton btnBack; // 뒤로버튼
	private JButton btnConfirm; // 확인버튼

	private JComboBox<Integer> cbxStandardYear; // 기준년
	private JComboBox<Integer> cbxStandardMonth;// 기준월

	private JComboBox<Integer> cbxComparativeYear; // 비교년
	private JComboBox<Integer> cbxComparativeMonth;// 비교월

	private JLabel stdLabel;
	private JButton btnCurrentMonth; // 현재월버튼

	private JLabel cmpLabel;
	private JButton btnLastYear; // 전년도 동월 버튼
	private JButton btnLastMonth; // 전월 버튼

	// =================분석레이블===============================

	private TitledBorder titleBorder;

	// =========================================================

	// 메서드용 변수들
	// calc
	private int stanYear;
	private int compYear;
	private int stanMonth;
	private int compMonth;

	private Vector<Integer> exp1 = new Vector<Integer>();

	// 컴포넌트 패널

	// pnlWest
	private JPanel pnlWest = new JPanel();
	private JPanel pnlCbWcenter = new JPanel();
	private JPanel pnlWNorth;
	private JPanel pnlBtWNorth = new JPanel();
	private JPanel pnlCenter;

	// pnlcenter
	private JPanel pnlEast = new JPanel();
	private JPanel pnlCbECenter = new JPanel();
	private JPanel pnlBtESouth = new JPanel();

	private JPanel pnlCNorth;

	private MainAccountBook daily;

	private int expenditureEaten = 0;

	private String temp3;
	private String temp4;
	private String temp5;

	public DlgCompareAnalysis(MainAccountBook daily) {

		super(daily, "비교분석", true);
		this.daily = daily;

		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		btnBack = new JButton(new ImageIcon("image/before.png"));
		SetComponent.setButton(btnBack);
		btnConfirm = new JButton("확인");
		SetComponent.setButton(btnConfirm);

		stdLabel = new JLabel("기준날짜설정", JLabel.CENTER);
		stdLabel.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 18));
		stdLabel.setBorder(new EmptyBorder(30, 0, 5, 0));
		cmpLabel = new JLabel("비교날짜설정", JLabel.CENTER);
		cmpLabel.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 18));
		cmpLabel.setBorder(new EmptyBorder(30, 0, 5, 0));

		// North의 버튼
		btnCurrentMonth = new JButton("이번달");
		SetComponent.setButton(btnCurrentMonth);
		btnLastYear = new JButton("전년도 동월");
		SetComponent.setButton(btnLastYear);
		btnLastMonth = new JButton("전월");
		SetComponent.setButton(btnLastMonth);

		// 연도ComboBox
		cbxStandardYear = new JComboBox<Integer>();
		cbxComparativeYear = new JComboBox<Integer>();

		for (int i = 2000; i <= 2020; i++) {
			cbxStandardYear.addItem(i);
			cbxComparativeYear.addItem(i);
		}

		// 월 ComboBox
		cbxStandardMonth = new JComboBox<Integer>();
		cbxComparativeMonth = new JComboBox<Integer>();
		for (int i = 1; i < 13; i++) {
			cbxStandardMonth.addItem(i);
			cbxComparativeMonth.addItem(i);
		}

		// 날짜설정패널
		pnlCNorth = new JPanel(new BorderLayout());
		pnlWNorth = new JPanel(new BorderLayout());

		// 분석레이블

		titleBorder = new TitledBorder(new LineBorder(Color.BLACK, 1));

		// ===================================

		pnlCenter = new JPanel(new BorderLayout());
	}
	private void setDisplay() {
		SetComponent.setLookAndFeel();

		// west
		SetComponent.setPanel(pnlWest);

		pnlCbWcenter.add(cbxStandardYear);
		pnlCbWcenter.add(cbxStandardMonth);

		pnlBtWNorth.add(btnCurrentMonth);

		pnlWNorth.add(btnBack, BorderLayout.NORTH);
		pnlWNorth.add(stdLabel, BorderLayout.CENTER);

		pnlWest.setLayout(new GridLayout(0, 1));
		pnlWest.setPreferredSize(new Dimension(200, 200));
		pnlWNorth.setBackground(new Color(0xe7f8f7));
		pnlCbWcenter.setBackground(new Color(0xe7f8f7));
		pnlBtWNorth.setBackground(new Color(0xe7f8f7));
		pnlWest.add(pnlWNorth);
		pnlWest.add(pnlCbWcenter);
		pnlWest.add(pnlBtWNorth);

		// east
		SetComponent.setPanel(pnlEast);
		pnlCbECenter.add(cbxComparativeYear);
		pnlCbECenter.add(cbxComparativeMonth);

		pnlCNorth.add(btnConfirm, BorderLayout.NORTH);
		pnlCNorth.add(cmpLabel, BorderLayout.CENTER);
		pnlCNorth.setBackground(new Color(0xe7f8f7));
		pnlCbECenter.setBackground(new Color(0xe7f8f7));
		pnlBtESouth.setBackground(new Color(0xe7f8f7));
		pnlBtESouth.add(btnLastYear);
		pnlBtESouth.add(btnLastMonth);

		pnlEast.setLayout(new GridLayout(0, 1));
		pnlEast.add(pnlCNorth);
		pnlEast.add(pnlCbECenter);
		pnlEast.add(pnlBtESouth);
		
		add(pnlWest, BorderLayout.WEST);
		add(pnlEast, BorderLayout.EAST);
		
	}

	private void addListeners() {

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if (src == btnBack) {
					dispose();
				} else if (src == btnCurrentMonth) {
					btncurrentM();
				} else if (src == btnLastYear) {
					btnLastY();
				} else if (src == btnLastMonth) {
					btnLastM();
				} else if (src == btnConfirm) {
					// 버튼누를때 하는 리스너
					fileRead();
					pnlCenter.setBorder(titleBorder);
				}
			}
		};
		btnBack.addActionListener(listener);
		btnCurrentMonth.addActionListener(listener);
		btnLastMonth.addActionListener(listener);
		btnLastYear.addActionListener(listener);
		btnConfirm.addActionListener(listener);

	}

	// 현재월
	private void btncurrentM() {
		cbxStandardMonth.setSelectedItem(Integer.parseInt(daily.getCbMonth().getSelectedItem().toString()));
		cbxStandardYear.setSelectedItem(daily.getCbYear().getSelectedItem());
	}

	// 기준월 대비 전년도동월
	private void btnLastY() {
		cbxComparativeMonth.setSelectedItem(cbxStandardMonth.getSelectedItem());
		cbxComparativeYear.setSelectedItem(Integer.parseInt(cbxStandardYear.getSelectedItem().toString()) - 1);
	}

	// 기준월 대비 전월
	private void btnLastM() {
		cbxComparativeMonth.setSelectedItem(Integer.parseInt(cbxStandardMonth.getSelectedItem().toString()) - 1);
		cbxComparativeYear.setSelectedItem(cbxStandardYear.getSelectedItem());
	}

	// 파일읽기
	private void fileRead() {
		ArrayList<JLabel> lblInDetails = new ArrayList<>();
		pnlCenter.setVisible(false);
		pnlCenter = new JPanel(new GridLayout(0, 1));
		String option = "";
		String option2 = "";

		HashMap<String, Integer> mapOp = new HashMap<>();
		HashMap<String, Integer> mapOp2 = new HashMap<>();

		stanYear = Integer.parseInt(cbxStandardYear.getSelectedItem().toString());
		compYear = Integer.parseInt(cbxComparativeYear.getSelectedItem().toString());
		stanMonth = Integer.parseInt(cbxStandardMonth.getSelectedItem().toString());
		compMonth = Integer.parseInt(cbxComparativeMonth.getSelectedItem().toString());

		String dm = "";
		String dd = "";

		String[] fileName = new String[31];

		// 기준월에 대해 읽을 파일이름 정하기
		if (Integer.parseInt(cbxStandardMonth.getSelectedItem().toString()) < 10) {
			dm = "0";
			for (int i = 1; i < 32; i++) {
				if (i < 10) {
					dd = "0";
					fileName[i - 1] = "account/" + cbxStandardYear.getSelectedItem().toString() + dm
							+ cbxStandardMonth.getSelectedItem().toString() + dd + i + "Account.dat";
				} else {
					dd = "";
					fileName[i - 1] = "account/" + cbxStandardYear.getSelectedItem().toString() + dm
							+ cbxStandardMonth.getSelectedItem().toString() + dd + i + "Account.dat";
				}
			}
		} else {
			dm = "";
			for (int i = 1; i < 32; i++) {
				if (i < 10) {
					dd = "0";
					fileName[i - 1] = "account/" + cbxStandardYear.getSelectedItem().toString() + dm
							+ cbxStandardMonth.getSelectedItem().toString() + dd + i + "Account.dat";
				} else {
					dd = "";
					fileName[i - 1] = "account/" + cbxStandardYear.getSelectedItem().toString() + dm
							+ cbxStandardMonth.getSelectedItem().toString() + dd + i + "Account.dat";
				}
			}
		}
		// 기준월 파일 읽기
		String temp = "";
		if ((stanYear == compYear) && (stanMonth == compMonth)) {
			JOptionPane.showMessageDialog(this, "같은건 비교해서 뭐하실려구요...");

		} else {
			for (int i = 1; i < 32; i++) {
				FileReader fr = null;
				BufferedReader br = null;
				String line = "";
				try {
					fr = new FileReader(fileName[i - 1]);
					br = new BufferedReader(fr);
					int money = 0;

					while ((line = br.readLine()) != null) {
						int front = line.indexOf(":");
						int behind = line.indexOf("항목:");

						String strMoney = line.substring(front + 1, behind);
						option = line.substring(behind + 3);
						money = Integer.parseInt(strMoney);

						if (mapOp.containsKey(option)) {
							mapOp.put(option, mapOp.get(option) + money);
						} else {
							mapOp.put(option, money);
						}
					}

					exp1.add(expenditureEaten);

				} catch (FileNotFoundException fnfe) {
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} finally {
					MyUtils.closeAll(br, fr);
				}
			}
			for (String keys : mapOp.keySet()) {
				temp += "**기준날짜 " + keys + "은" + mapOp.get(keys) + "입니다\n";
			}

			String dm2 = "";
			String dd2 = "";
			String[] fileName2 = new String[31];

			// 비교파일읽기
			// 비교파일이름 만들기
			if (Integer.parseInt(cbxComparativeMonth.getSelectedItem().toString()) < 10) {
				dm2 = "0";
				for (int i = 1; i < 32; i++) {
					if (i < 10) {
						dd2 = "0";
						fileName2[i - 1] = "account/" + cbxComparativeYear.getSelectedItem().toString() + dm2
								+ cbxComparativeMonth.getSelectedItem().toString() + dd2 + i + "Account.dat";
					} else {
						dd2 = "";
						fileName2[i - 1] = "account/" + cbxComparativeYear.getSelectedItem().toString() + dm2
								+ cbxComparativeMonth.getSelectedItem().toString() + dd2 + i + "Account.dat";
					}
				}
			} else {
				dm2 = "";
				for (int i = 1; i < 32; i++) {
					if (i < 10) {
						dd2 = "0";
						fileName2[i - 1] = "account/" + cbxComparativeYear.getSelectedItem().toString() + dm2
								+ cbxComparativeMonth.getSelectedItem().toString() + dd2 + i + "Account.dat";
					} else {
						dd2 = "";
						fileName2[i - 1] = "account/" + cbxComparativeYear.getSelectedItem().toString() + dm2
								+ cbxComparativeMonth.getSelectedItem().toString() + dd2 + i + "Account.dat";
					}
				}
			}
			// 파일 읽기
			String temp2 = "";

			for (int i = 1; i < 32; i++) {

				FileReader fr2 = null;
				BufferedReader br2 = null;
				String line2 = "";

				try {

					fr2 = new FileReader(fileName2[i - 1]);
					br2 = new BufferedReader(fr2);

					int money2 = 0;

					while ((line2 = br2.readLine()) != null) {
						int front2 = line2.indexOf(":");
						int behind2 = line2.indexOf("항목:");

						option2 = line2.substring(behind2 + 3);
						String strMoney2 = line2.substring(front2 + 1, behind2);
						money2 = Integer.parseInt(strMoney2);

						if (mapOp2.containsKey(option2)) {
							mapOp2.put(option2, mapOp2.get(option2) + money2);
						} else {
							mapOp2.put(option2, money2);
						}

					}

				} catch (FileNotFoundException fnfe2) {
				} catch (IOException ioe2) {
					ioe2.printStackTrace();
				} finally {
					MyUtils.closeAll(br2, fr2);
				}
			}
			for (String keys2 : mapOp2.keySet()) {
				temp2 += "비교날짜" + keys2 + "는" + mapOp2.get(keys2) + "입니다.\n";
			}

		}
		JLabel lblInTitle = new JLabel("월    간    비    교");
		lblInTitle.setHorizontalAlignment(JLabel.CENTER);
		lblInTitle.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 35));

		JLabel lblStdDate = new JLabel(stanYear + "년" + stanMonth + "월       ");
		JLabel lblCmpDate = new JLabel("     " + compYear + "년" + compMonth + "월");
		JPanel pnlDate = new JPanel();
	
		lblCmpDate.setHorizontalAlignment(JLabel.CENTER);
		lblCmpDate.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 24));
		
		lblStdDate.setHorizontalAlignment(JLabel.CENTER);
		lblStdDate.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 24));
		
		
		pnlDate.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
		pnlDate.add(lblStdDate);
		pnlDate.add(new JLabel(new ImageIcon("image/compare.png")));
		pnlDate.add(lblCmpDate);
		pnlDate.setBackground(new Color(0xebebf3));
		int cnt = 0;
		temp3 = "";
		temp4 = "";
		temp5 = "";

		for (String keys : mapOp.keySet()) {
			for (String keys2 : mapOp2.keySet()) {
				if (keys.equals(keys2)) {
					if (mapOp.get(keys) > mapOp2.get(keys2)) {
						temp3 = compYear + "년 " + compMonth + "월에는 " + stanYear + "년 " + stanMonth + "월 보다 " + keys
								+ "로 " + (mapOp.get(keys) - mapOp2.get(keys2)) + "원만큼 더사용 하였습니다.";
						temp4 = " 밥은 먹고 다니니?";
						temp5 = "==================================================================";
					} else if (mapOp.get(keys) == mapOp2.get(keys2)) {
						temp3 = compYear + "년 " + compMonth + "월에는 " + stanYear + "년 " + stanMonth + "월과" + keys
								+ "의 사용금액이 같습니다." + mapOp.get(keys);
						temp4 = "\t그래그래";
						temp5 = "==================================================================";
					} else {
						temp3 = compYear + "년 " + compMonth + "월에는 " + stanYear + "년 " + stanMonth + "월 보다 " + keys
								+ "로 " + (mapOp2.get(keys2) - mapOp.get(keys2)) + "원만큼 더사용 하였습니다.";
						temp4 = "아껴써라";
						temp5 = "==================================================================";

					}

					JLabel lblKeys = new JLabel(keys);
					lblKeys.setHorizontalAlignment(JLabel.CENTER);
					lblKeys.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 25));
					lblKeys.setOpaque(true);
					

					JLabel lblTemp3 = new JLabel(temp3);
					lblTemp3.setOpaque(true);
					lblTemp3.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 20));
					JLabel lblTemp4 = new JLabel(temp4);
					lblTemp4.setOpaque(true);
					lblTemp4.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 20));
					JLabel lblTemp5 = new JLabel(temp5);
					lblTemp5.setOpaque(true);
					lblTemp5.setFont(new Font("휴먼둥근헤드라인", Font.ITALIC, 20));

					lblInDetails.add(lblKeys);
					lblKeys.setBackground(Color.LIGHT_GRAY);
					lblInDetails.add(lblTemp3);
					lblTemp3.setBackground(new Color(0xebebf3));
					lblInDetails.add(lblTemp4);
					lblTemp4.setBackground(new Color(0xebebf3));
					lblInDetails.add(lblTemp5);
					lblTemp5.setBackground(new Color(0xebebf3));
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			JOptionPane.showMessageDialog(this, "비교할 항목이 없습니다");
		} else {
			JPanel layout = new JPanel(new BorderLayout());
			layout.add(lblInTitle, BorderLayout.NORTH);
			layout.add(pnlDate, BorderLayout.CENTER);
			layout.add(new JLabel(new ImageIcon("image/graph.gif")), BorderLayout.SOUTH);
			pnlCenter.add(layout, BorderLayout.NORTH);
			layout.setBackground(new Color(0xebebf3));
			
			JPanel pnl = new JPanel(new GridLayout(0,1));
			for (int i = 0; i < lblInDetails.size(); i++) {
				pnl.add(lblInDetails.get(i));
			}
			JScrollPane scroll = new JScrollPane(pnl);
			pnlCenter.add(scroll, BorderLayout.CENTER);
			
			pnlCenter.setBackground(Color.WHITE);
			// 버튼누를때 ui 조정
			setSize(1250, 700);
			setLocationRelativeTo(null);
			add(pnlCenter, BorderLayout.CENTER);
		}
	}

	private void showFrame() {
		setSize(415, 400);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

}