import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Area;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.Closeable;
import java.io.Serializable;
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
import java.io.Serializable;
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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import java.io.Serializable;

// �׿� ��� ���� ������ �����ؼ� ���ϼ��� ���Ѵ��� �����ϴ� ���ϰ� ������ ������ ã��
class CalendarDateCalculation implements Serializable{
	// �̸� ���� ������ , ���ؿ��� ���ؼ� ����ϴ� ����� ������.
	
	private int baseYear = 2000; // ���� ����
	private int baseMonth = 1; // ���� �� �Դϴ�. �����δ� 1980�� 1�� 1�� �������� ���
	private int totalSum = 0; // ���� ��� ������ �Է¹��� ��¥���� �� �ϼ��� ���⿡ ����

	private int[] monthArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 
	
	public int getMonthArr(int j) {
		return monthArr[j];
	}
	
	public int[] getMonthArr() {
		return monthArr;
	}

	public void setMonthArr(int... monthArr) {
		this.monthArr = monthArr;
	}

	public boolean isLeapYear(int n) { // ������ �ִ� �⵵�� �����ϴ� �Լ��Դϴ�

		if (n % 4 == 0) { // 4�� ����� ����
			if (n % 100 == 0) { //100�� ����� ������ �ƴϴ�
				if (n % 400 == 0) { //400�� ����� ����
					return true;
				}
				return false;
			}
			return true;
		}
		else {
			return false;
		}
	}

	private int totalToMonth(int total) // ���� ��¥���� �Է¹��� ��¥���� �� �ϼ��� ���ؼ� ��ȯ,
	{

		boolean CHK = true; // ���� ������ ���������� �Ҹ��� ���Դϴ�.
		int i = 0; // i������ ���Դϴ�.
		int cnt = 0; // �� �ϼ��� ���� �ٲپ cnt �����ŵ�ϴ�.
		int checkLeapYear = baseYear; // �� �ϼ��� ���� �ٲٷ��� ������ �ִ� ���� ����ؾ��մϴ�.
										// ���ؿ������� �����ؼ� ������ �����մϴ�.

		while (CHK) {
			if (isLeapYear(checkLeapYear)) // ���� ���� ������ �����̶��
				monthArr[1] = 29; // 2������ �Ϸ簡 �� �þ�ϴ�.

			if (total >= monthArr[i]){ // �� �ϼ��� month_table[]�迭�� ���ϼ� ���� �۴ٸ�,
			
				total -= monthArr[i++]; // ���ϼ��� month_table �迭�� ���� ���� �ϼ��� ���ݴϴ�.
										// �׸��� i�� ������ŵ�ϴ�. �� �����޷� �����˴ϴ�.
				
				cnt++; // �׸��� ���� �����մϴ�.
				if (i == 12) {// ���� 12���̵ȴٸ� ������ ���� �ٽ� ���ڸ��� ���°�ó��
					i -= 12; // �ٽ� 12������ 0���� ������ݴϴ�.
					checkLeapYear++; // �׸��� 12������ �������� ������ �������������
				}
				monthArr[1] = 28; // ������ ����� �ط� �ٲپ��־���մϴ�.
			}
			else {
				CHK = false;
			}
		}
		cnt %= 12; // ���� ���ѷ����� ���� ���ϼ��� �ѿ����� ����, ���� 12 ������ ������ ���ָ� ��⵵ ����̶�� ������ �ٲܼ��ֽ��ϴ�.
		
		return (cnt + 1); // �׸��� �ٲ� ���� ��ȯ
	}

	private int countLeap(int n){ // ���� �������� �����ؼ� �Է¹��� ���������� ������ �ִ³��� ���ϴ�.
		int i; // ���ؿ����� �����մϴ�.
		int cnt = 0; // ������ �����Դϴ�.

		for (i = baseYear; i < (baseYear - n); i++){
			if (isLeapYear(i)){ 
				cnt++; 
			}
		}
		return cnt; // ī��Ʈ�� ������ ������ �����մϴ�.
	}

	private void allSumDay(int nYear) { // ���� �������� �Է¹��� �������� ���ϼ��� ���ؼ� �����մϴ�.
		totalSum = ((nYear - baseYear) * 365) + countLeap((baseYear - nYear));
	}
	
	public int result(int nYear, int mth) {//�ٽ�
		int month;

		int dy = countLeap(baseYear - nYear); // dy�� ���ؿ������� ���翬������ �� ������ �����Դϴ�.
		allSumDay(nYear); // �� �켱 ���ؿ������� ���� �������� �� ������ ���ϼ��� ���մϴ�. ��

		int day = 0; 
		if (nYear >= baseYear) {

			if (isLeapYear(nYear)) // ������ ������ 2���� �Ϸ� ����
				monthArr[1] = 29;

			for (int i = 0; i < (mth - baseMonth); i++)
				totalSum += monthArr[i];

			day = (totalSum + 6) % 7; //����
			
			month = totalToMonth(totalSum);
			
			monthArr[1] = 28; // �����̾��ٸ� �ٽ� ������� �ٲپ��ݴϴ�.
			
			return day;
		} else {
			return -1;
		}
		
	}
}
//��� ������ �޷� �г�
class CalendarPanel extends JPanel implements Serializable {
	private JPanel pnlCenter;
	private JPanel pnlCNorth;
	private JPanel pnlCCenter;

	private JLabel[] btnDayOfWeek;
	private JButton[] btnDays;

	private int startDay;
	private int lastDay;

	private String[] dayOfWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };

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

	// ������ ����
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

	private void setCalendar() { // ������ �޷� ����
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
				String fileName = "dats/" + year + "��  " + zero + month + "��  " + (i - startDay + 1) + "��.dat";
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
						String hour = list[0].substring(20, list[0].indexOf("��"));
						String minute = list[0].substring(list[0].indexOf("��") + 1, list[0].indexOf("��"));
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

//�񱳺м� ��� Ŭ����
class DlgCompareAnalysis extends JDialog {

	public static final Dimension BTN_SIZE = new Dimension(60, 40);

	// ������Ʈ(�г�����)
	private JButton btnBack; // �ڷι�ư
	private JButton btnConfirm; // Ȯ�ι�ư

	private JComboBox<Integer> cbxStandardYear; // ���س�
	private JComboBox<Integer> cbxStandardMonth;// ���ؿ�

	private JComboBox<Integer> cbxComparativeYear; // �񱳳�
	private JComboBox<Integer> cbxComparativeMonth;// �񱳿�

	private JLabel stdLabel;
	private JButton btnCurrentMonth; // �������ư

	private JLabel cmpLabel;
	private JButton btnLastYear; // ���⵵ ���� ��ư
	private JButton btnLastMonth; // ���� ��ư

	// =================�м����̺�===============================

	private TitledBorder titleBorder;

	// =========================================================

	// �޼���� ������
	// calc
	private int stanYear;
	private int compYear;
	private int stanMonth;
	private int compMonth;

	private Vector<Integer> exp1 = new Vector<Integer>();

	// ������Ʈ �г�

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

		super(daily, "�񱳺м�", true);
		this.daily = daily;

		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		btnBack = new JButton(new ImageIcon("image/before.png"));
		SetComponent.setButton(btnBack);
		btnConfirm = new JButton("Ȯ��");
		SetComponent.setButton(btnConfirm);

		stdLabel = new JLabel("���س�¥����", JLabel.CENTER);
		stdLabel.setFont(new Font("�޸յձ�������", Font.ITALIC, 18));
		stdLabel.setBorder(new EmptyBorder(30, 0, 5, 0));
		cmpLabel = new JLabel("�񱳳�¥����", JLabel.CENTER);
		cmpLabel.setFont(new Font("�޸յձ�������", Font.ITALIC, 18));
		cmpLabel.setBorder(new EmptyBorder(30, 0, 5, 0));

		// North�� ��ư
		btnCurrentMonth = new JButton("�̹���");
		SetComponent.setButton(btnCurrentMonth);
		btnLastYear = new JButton("���⵵ ����");
		SetComponent.setButton(btnLastYear);
		btnLastMonth = new JButton("����");
		SetComponent.setButton(btnLastMonth);

		// ����ComboBox
		cbxStandardYear = new JComboBox<Integer>();
		cbxComparativeYear = new JComboBox<Integer>();

		for (int i = 2000; i <= 2020; i++) {
			cbxStandardYear.addItem(i);
			cbxComparativeYear.addItem(i);
		}

		// �� ComboBox
		cbxStandardMonth = new JComboBox<Integer>();
		cbxComparativeMonth = new JComboBox<Integer>();
		for (int i = 1; i < 13; i++) {
			cbxStandardMonth.addItem(i);
			cbxComparativeMonth.addItem(i);
		}

		// ��¥�����г�
		pnlCNorth = new JPanel(new BorderLayout());
		pnlWNorth = new JPanel(new BorderLayout());

		// �м����̺�

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
					// ��ư������ �ϴ� ������
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

	// �����
	private void btncurrentM() {
		cbxStandardMonth.setSelectedItem(Integer.parseInt(daily.getCbMonth().getSelectedItem().toString()));
		cbxStandardYear.setSelectedItem(daily.getCbYear().getSelectedItem());
	}

	// ���ؿ� ��� ���⵵����
	private void btnLastY() {
		cbxComparativeMonth.setSelectedItem(cbxStandardMonth.getSelectedItem());
		cbxComparativeYear.setSelectedItem(Integer.parseInt(cbxStandardYear.getSelectedItem().toString()) - 1);
	}

	// ���ؿ� ��� ����
	private void btnLastM() {
		cbxComparativeMonth.setSelectedItem(Integer.parseInt(cbxStandardMonth.getSelectedItem().toString()) - 1);
		cbxComparativeYear.setSelectedItem(cbxStandardYear.getSelectedItem());
	}

	// �����б�
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

		// ���ؿ��� ���� ���� �����̸� ���ϱ�
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
		// ���ؿ� ���� �б�
		String temp = "";
		if ((stanYear == compYear) && (stanMonth == compMonth)) {
			JOptionPane.showMessageDialog(this, "������ ���ؼ� ���ϽǷ�����...");

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
						int behind = line.indexOf("�׸�:");

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
				temp += "**���س�¥ " + keys + "��" + mapOp.get(keys) + "�Դϴ�\n";
			}

			String dm2 = "";
			String dd2 = "";
			String[] fileName2 = new String[31];

			// �������б�
			// �������̸� �����
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
			// ���� �б�
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
						int behind2 = line2.indexOf("�׸�:");

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
				temp2 += "�񱳳�¥" + keys2 + "��" + mapOp2.get(keys2) + "�Դϴ�.\n";
			}

		}
		JLabel lblInTitle = new JLabel("��    ��    ��    ��");
		lblInTitle.setHorizontalAlignment(JLabel.CENTER);
		lblInTitle.setFont(new Font("�޸յձ�������", Font.ITALIC, 35));

		JLabel lblStdDate = new JLabel(stanYear + "��" + stanMonth + "��       ");
		JLabel lblCmpDate = new JLabel("     " + compYear + "��" + compMonth + "��");
		JPanel pnlDate = new JPanel();
	
		lblCmpDate.setHorizontalAlignment(JLabel.CENTER);
		lblCmpDate.setFont(new Font("�޸յձ�������", Font.ITALIC, 24));
		
		lblStdDate.setHorizontalAlignment(JLabel.CENTER);
		lblStdDate.setFont(new Font("�޸յձ�������", Font.ITALIC, 24));
		
		
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
						temp3 = compYear + "�� " + compMonth + "������ " + stanYear + "�� " + stanMonth + "�� ���� " + keys
								+ "�� " + (mapOp.get(keys) - mapOp2.get(keys2)) + "����ŭ ����� �Ͽ����ϴ�.";
						temp4 = " ���� �԰� �ٴϴ�?";
						temp5 = "==================================================================";
					} else if (mapOp.get(keys) == mapOp2.get(keys2)) {
						temp3 = compYear + "�� " + compMonth + "������ " + stanYear + "�� " + stanMonth + "����" + keys
								+ "�� ���ݾ��� �����ϴ�." + mapOp.get(keys);
						temp4 = "\t�׷��׷�";
						temp5 = "==================================================================";
					} else {
						temp3 = compYear + "�� " + compMonth + "������ " + stanYear + "�� " + stanMonth + "�� ���� " + keys
								+ "�� " + (mapOp2.get(keys2) - mapOp.get(keys2)) + "����ŭ ����� �Ͽ����ϴ�.";
						temp4 = "�Ʋ����";
						temp5 = "==================================================================";

					}

					JLabel lblKeys = new JLabel(keys);
					lblKeys.setHorizontalAlignment(JLabel.CENTER);
					lblKeys.setFont(new Font("�޸յձ�������", Font.ITALIC, 25));
					lblKeys.setOpaque(true);
					

					JLabel lblTemp3 = new JLabel(temp3);
					lblTemp3.setOpaque(true);
					lblTemp3.setFont(new Font("�޸յձ�������", Font.ITALIC, 20));
					JLabel lblTemp4 = new JLabel(temp4);
					lblTemp4.setOpaque(true);
					lblTemp4.setFont(new Font("�޸յձ�������", Font.ITALIC, 20));
					JLabel lblTemp5 = new JLabel(temp5);
					lblTemp5.setOpaque(true);
					lblTemp5.setFont(new Font("�޸յձ�������", Font.ITALIC, 20));

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
			JOptionPane.showMessageDialog(this, "���� �׸��� �����ϴ�");
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
			// ��ư������ ui ����
			setSize(1250, 700);
			setLocationRelativeTo(null);
			add(pnlCenter, BorderLayout.CENTER);
		}
	}

	private void showFrame() {
		setSize(415, 400);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);

	}

}
// ����������� �󼼳���
class DlgCurrentMonthDetails extends JDialog implements Serializable{
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

		super(owner, "�󼼺м�", true);
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
		lblTitle = new JLabel("   " + book.getYearSelected() + "�� " + book.getMonthSelected() + "���� �󼼳���   ");
		lblTitle.setFont(new Font("�޸յձ�������", Font.ITALIC, 25));
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setOpaque(true);
		lblTitle.setForeground(Color.WHITE);
		// 1
		lblMonthlyBalance = new JLabel("   " + book.getMonthSelected().toString() + "���� ����-����   ");
		
		lblMonthlyBalance.setFont(new Font("�޸յձ�������", Font.ITALIC, 25));
		lblMonthlyBalance.setForeground(Color.WHITE);
		lblMonthlyBalance.setBackground(Color.BLACK);
		lblMonthlyBalance.setOpaque(true);
		// 2
		lblMonthlyExpenditure = new JLabel("���� ����  :  ");
		SetComponent.setCMDLabel(lblMonthlyExpenditure);
		lblMonthlyExpenditure.setForeground(Color.RED);
		lblMonthlyExpenditure.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "��������", 0, TitledBorder.BELOW_TOP));
		
		lblMonthlyIncome = new JLabel("���� ����  :  ");
		SetComponent.setCMDLabel(lblMonthlyIncome);
		lblMonthlyIncome.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "��������", 0, TitledBorder.BELOW_TOP));
		lblMonthlyIncome.setForeground(Color.BLUE);
		
		lblFromLastMonth = new JLabel("�̿� �ݾ�  : ");
		SetComponent.setCMDLabel(lblFromLastMonth);
		lblFromLastMonth.setForeground(new Color(0x00cc00));
		lblFromLastMonth.setBorder(new TitledBorder(new LineBorder(new Color(0x00cc00), 2), "�̿��ݾ�", 0, TitledBorder.BELOW_TOP));
		// 3
		lblMonthlyHighestExpenditure = new JLabel("���� �ִ�����  :  ");
		SetComponent.setCMDLabel(lblMonthlyHighestExpenditure);
		lblMonthlyHighestExpenditure.setForeground(Color.RED);
		lblMonthlyHighestExpenditure.setBorder(new TitledBorder(new LineBorder(Color.RED, 2), "������", 0, TitledBorder.BELOW_TOP));
		
		lblMonthlyHighestIncome = new JLabel("���� �ִ����  :  ");
		SetComponent.setCMDLabel(lblMonthlyHighestIncome);
		lblMonthlyHighestIncome.setForeground(Color.BLUE);
		lblMonthlyHighestIncome.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "������", 0, TitledBorder.BELOW_TOP));

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
		pnlFourthLine.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2), "���� ����", 0 , TitledBorder.BELOW_TOP));
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
	//������� �ִ�����,���԰� �������� ���԰� �����ջ�
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
					int amountIndex = line.indexOf("�׸�:");
					String account = line.substring(index + 1, amountIndex);
					String inOut = line.substring(0, index);
					String option = line.substring(line.lastIndexOf(":")+1, line.length());
					int money = Integer.parseInt(account);
					if (inOut.contentEquals("����")) {
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
		lblMonthlyExpenditure.setText("���� ����  :  " + sumExpenditure + "��");
		lblMonthlyIncome.setText("���� ����  :  " + sumIncome + "��");
		lblMonthlyHighestExpenditure.setText("���� �ִ� ����  :  " + maxExpenditure + "��(" + maxEOption +")");
		lblMonthlyHighestIncome.setText("���� �ִ� ����  :  " + maxIncome + "��(" + maxIOption + ")");
	}
	// �̿��ݾ� 
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
					int amountIndex = line.indexOf("�׸�:");
					String account = line.substring(index + 1, amountIndex);
					String inOut = line.substring(0, index);
					int money = Integer.parseInt(account);
					if (inOut.equals("����")) {
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
		lblFromLastMonth.setText("�̿� �ݾ�  :  " + lastTotal + "��");
	}
	// �׸� ���� �� �ջ�
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
					int amountIndex = line.indexOf("�׸�:");
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
			JLabel lbl = new JLabel(options +": " + moneyMap.get(options) +"��", JLabel.CENTER);
			lbl.setFont(new Font("�޸ո���ü", Font.BOLD, 18));
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
// �����߰� ��� Ŭ����
class DlgDaily extends JDialog implements Serializable {
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
		this.saveFrList = cp.getFrList(); // ����� ����Ʈ
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
		lblDate = new JLabel(book.getCbYear().getSelectedItem() + "��  " + book.getCbMonth().getSelectedItem() + "��  "
				+ btnIdx + "��");
		btnAdd = new JButton("�����߰�");
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

	// ������ �޷� �����ϰ� center���ٰ� add
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

	// ������ư(����, ���� �հ� Ķ������ ����)
	private void before() {
		JLabel expenditure;
		JLabel income;
		for (Integer key : book.getCalendarMap().keySet()) {
			CalendarPanel pnl = book.getCalendarMap().get(key);
			if (Integer
					.parseInt(book.getCbYear().getSelectedItem() + "" + book.getCbMonth().getSelectedItem()) == key) {
				income = new JLabel("����  : " + "\n");
				expenditure = new JLabel("���� : " + "\n");
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
						if (saveFrList.get(i).getInAndOut().equals("����")) {
							fw.write("����:" + saveFrList.get(i).getAmount() + "�׸�:" + saveFrList.get(i).getOption()
									+ "\n");
						} else {
							fw.write("����:" + saveFrList.get(i).getAmount() + "�׸�:" + saveFrList.get(i).getOption()
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
						int amountIndex = line.indexOf("�׸�:");
						String name = line.substring(0, index);
						String amount = line.substring(index + 1, amountIndex);
						if (name.equals("����")) {
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
									+ "��<br/>" + expenditure.getText() + "" + totalExpenditure + "��</font></html>");
				}
			}
		}
	}

	private void showFrame() {
		pack();
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}
// ���� �߰� ���
class DlgDailyEditor extends JDialog implements Serializable {

	// north
	private JButton btnBefore;
	private JButton btnDelete;
	private JButton btnConfirm;
	// center
	private JComboBox<Integer> cbxHour;
	private JComboBox<Integer> cbxMinute;
	private JRadioButton rbIncome;
	private JRadioButton rbExpenditure;

	private JTextField tfAmount;
	private JComboBox<String> cbxIncome;
	private JComboBox<String> cbxExpenditure;
	private JButton btnExpAppend;

	private JTextArea taDetail;

	private JPanel pnlNorth;
	private JPanel pnlCenter;

	private JPanel pnlFirstline;
	private JPanel pnlSecondline;
	private JPanel pnlThirdline;

	private JPanel pnlFirstlineTime;
	private JPanel pnlSecnodlineCcbx;

	// pnlAppendOption=========================
	private JPanel pnlAppendption;
	private JTextField tfAppendOption;
	private JButton btnOConfirm;

	private DlgDaily daily;
	private DlgDailyPanel dailyPnl;
	private ArrayList<FileRecorder> recorderList;
	private int index;

	private boolean flag;

	public DlgDailyEditor(DlgDaily daily) {
		super(daily, "DlgAdd", true);
		this.daily = daily;
		init();
		readOption();
		setDisplay();
		flag = false;
		addListeners();
		showDialog();
	}

	// ���������ϴ� ������
	public DlgDailyEditor(DlgDaily daily, DlgDailyPanel dailyPnl, int i, String hour, String minute, String option,
			String amount, String detail) {
		super(daily, "DlgEditor", true);
		index = i;
		this.dailyPnl = dailyPnl;
		this.daily = daily;
		init();
		setDisplay();
		readOption(option);
		setCbx(hour, minute, option);
		tfAmount.setText(amount);
		taDetail.setText(detail);
		flag = true;
		addListeners();
		showDialog();
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public ArrayList<FileRecorder> getRecorderList() {
		return recorderList;
	}

	public void setRecorderList(ArrayList<FileRecorder> recorderList) {
		this.recorderList = recorderList;
	}

	private void init() {
		btnBefore = new JButton(new ImageIcon("image/before.png"));
		btnDelete = new JButton("����");
		btnConfirm = new JButton("Ȯ��");

		cbxHour = new JComboBox<Integer>();
		cbxMinute = new JComboBox<Integer>();

		rbIncome = new JRadioButton("����", true);
		rbExpenditure = new JRadioButton("����");
		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(rbIncome);
		btnGrp.add(rbExpenditure);

		tfAmount = new JTextField(10);
		cbxIncome = new JComboBox<String>();
		cbxExpenditure = new JComboBox<String>();
		btnExpAppend = new JButton("�׸��߰�");

		taDetail = new JTextArea(20, 30);
		pnlNorth = new JPanel();

		pnlFirstlineTime = new JPanel();
		pnlSecnodlineCcbx = new JPanel();

		pnlCenter = new JPanel(new GridLayout(0, 1));
		pnlFirstline = new JPanel();
		pnlSecondline = new JPanel();
		pnlThirdline = new JPanel(new BorderLayout());

		// pnlAppendOption=========================
		pnlAppendption = new JPanel();
		tfAppendOption = new JTextField(15);
		btnOConfirm = new JButton("Ȯ��");
		recorderList = new ArrayList<>();
	}

	private void setDisplay() {
		SetComponent.setLookAndFeel();
		SetComponent.setButton(btnBefore);
		SetComponent.setButton(btnDelete);
		SetComponent.setButton(btnConfirm);
		btnDelete.setBackground(new Color(0xFFCCCC));
		tfAmount.setText("�ݾ����Է��Ͻÿ�");
		tfAmount.setForeground(new Color(0x123456));
		btnConfirm.setBackground(new Color(0x00FFFF));

		for (int i = 0; i < 60; i++) {
			cbxMinute.addItem(i);
		}
		for (int i = 0; i < 24; i++) {
			cbxHour.addItem(i);
		}
		pnlNorth.add(btnBefore);
		pnlNorth.add(btnDelete);
		pnlNorth.add(btnConfirm);

		pnlFirstlineTime.add(cbxHour);
		pnlFirstlineTime.add(cbxMinute);

		pnlFirstline.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
		pnlFirstline.add(pnlFirstlineTime);
		pnlFirstline.add(rbIncome);
		pnlFirstline.add(rbExpenditure);

		pnlSecondline.add(tfAmount);
		pnlSecnodlineCcbx.add(cbxIncome);
		pnlSecnodlineCcbx.add(cbxExpenditure);
		pnlSecondline.add(pnlSecnodlineCcbx);
		pnlSecondline.add(btnExpAppend);
		pnlSecondline.add(taDetail);

		pnlAppendption.add(tfAppendOption);
		pnlThirdline.add(pnlAppendption, BorderLayout.CENTER);
		pnlThirdline.add(taDetail, BorderLayout.SOUTH);

		pnlAppendption.setVisible(false);
		cbxExpenditure.setVisible(false);

		pnlCenter.setLayout(new BorderLayout());
		pnlCenter.add(pnlFirstline, BorderLayout.NORTH);
		pnlCenter.add(pnlSecondline, BorderLayout.CENTER);
		pnlCenter.add(pnlThirdline, BorderLayout.SOUTH);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);

		// pnlAppendOption==================
		pnlAppendption.add(tfAppendOption);
		pnlAppendption.add(btnOConfirm);
	}

	private void addListeners() {
		ActionListener alsnr = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if (src == btnBefore) {
					dispose();
				} else if (src == btnDelete) {
					delete();
					daily.pack();
				} else if (src == btnExpAppend) {
					pnlAppendption.setVisible(true);
					pack();
				} else if (src == btnOConfirm) {
					optionConfirm();
				} else if (src == btnConfirm) {
					if (flag) {
						editConfirm();
					} else {
						confirm();
					}
				}
			}
		};
		btnBefore.addActionListener(alsnr);
		btnDelete.addActionListener(alsnr);
		btnConfirm.addActionListener(alsnr);
		btnExpAppend.addActionListener(alsnr);
		btnOConfirm.addActionListener(alsnr);

		ItemListener ilsnr = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				Object src = ie.getItem();
				if (src == rbIncome) {
					cbxIncome.setVisible(true);
					cbxExpenditure.setVisible(false);
				} else if (src == rbExpenditure) {
					cbxIncome.setVisible(false);
					cbxExpenditure.setVisible(true);
				}
			}
		};
		rbIncome.addItemListener(ilsnr);
		rbExpenditure.addItemListener(ilsnr);

		MouseListener mlsnr = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (tfAmount == me.getSource()) {
					tfAmount.setText("");
				}
			}
		};
		tfAmount.addMouseListener(mlsnr);
	}

	// �޺��ڽ� ù �ɼ� ����
	private void setCbx(String hour, String minute, String option) {
		for (int i = 0; i < cbxHour.getItemCount(); i++) {
			if (cbxHour.getItemAt(i).toString().equals(hour)) {
				cbxHour.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < cbxMinute.getItemCount(); i++) {
			if (cbxMinute.getItemAt(i).toString().equals(minute)) {
				cbxMinute.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < cbxIncome.getItemCount(); i++) {
			if (cbxIncome.getItemAt(i).toString().equals(option)) {
				cbxIncome.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < cbxExpenditure.getItemCount(); i++) {
			if (cbxExpenditure.getItemAt(i).toString().equals(option)) {
				cbxExpenditure.setSelectedIndex(i);
			}
		}
	}

	// ������ ���ؼ� Ȯ�� ������ event
	private void editConfirm() {
		boolean flag = true;

		if (tfAmount.getText().equals("") || tfAmount.getText().equals("�ݾ����Է��Ͻÿ�")) {
			JOptionPane.showMessageDialog(this, "�ݾ��� �Է��Ͻÿ�");
			flag = false;
		}
		if (flag && taDetail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "�󼼳����� �Է��Ͻÿ�");
			flag = false;
		}
		if (flag) {

			FileOutputStream fw = null;
			DataOutputStream dos = null;
			String fileName = "dats/" + daily.getLblDate().getText() + ".dat";

			ArrayList<FileRecorder> fileList = daily.getSaveFrList();
			try {
				fw = new FileOutputStream(fileName);
				dos = new DataOutputStream(fw);
				// �ð�, ��, ������������, �׸�, �ݾ�, �󼼳���
				// ���Ͼȿ� ����
				fileList.get(index).setHour(cbxHour.getSelectedItem().toString());
				fileList.get(index).setMinute(cbxMinute.getSelectedItem().toString());
				fileList.get(index).setInAndOut(radioStr());
				fileList.get(index).setOption(cbxStr());
				fileList.get(index).setAmount(Integer.parseInt(tfAmount.getText()));
				fileList.get(index).setDetails(taDetail.getText());

				// ������� ���� �г� ����
				dailyPnl.getLblHour().setText(cbxHour.getSelectedItem().toString());
				dailyPnl.getLblMinute().setText(cbxMinute.getSelectedItem().toString());
				dailyPnl.getLblOption().setText(cbxStr());
				dailyPnl.getLblAmount().setText(tfAmount.getText());
				dailyPnl.getLblDetail().setText(taDetail.getText());

				for (int i = 0; i < fileList.size(); i++) {
					dos.writeUTF(fileList.get(i).toString());
				}
				daily.setCenter(fileList);
				dispose();
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "�ݾ׶��� ���ڸ� �Է��ϼ���");
			} finally {
				MyUtils.closeAll(dos, fw);
			}
		}
		FileWriter fOption = null;
		try {
			fOption = new FileWriter("dats/option.dat");
			for (int i = 0; i < cbxIncome.getItemCount(); i++) {
				fOption.write("����:" + cbxIncome.getItemAt(i) + "\n");
			}
			for (int i = 0; i < cbxExpenditure.getItemCount(); i++) {
				fOption.write("����:" + cbxExpenditure.getItemAt(i) + "\n");
			}
			fOption.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fOption);
		}
	}

	// �����߰� Ȯ�ι�ư event
	private void confirm() {
		boolean flag = true;
		int count = 1;
		if (tfAmount.getText().equals("") || tfAmount.getText().equals("�ݾ����Է��Ͻÿ�")) {
			JOptionPane.showMessageDialog(this, "�ݾ��� �Է��Ͻÿ�");
			flag = false;
		}
		if (flag && taDetail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "�󼼳����� �Է��Ͻÿ�");
			flag = false;
		}
		if (flag) {
			FileOutputStream fw = null;
			DataOutputStream dos = null;

			String fileName = "dats/" + daily.getLblDate().getText() + ".dat";

			try {
				fw = new FileOutputStream(fileName);
				dos = new DataOutputStream(fw);
				for (int i = 0; i < daily.getSaveFrList().size(); i++) {
					dos.writeUTF(daily.getSaveFrList().get(i).toString());
					recorderList.add(daily.getSaveFrList().get(i));
				}
				// �ð�, ��, ������������, �׸�, �ݾ�, �󼼳���
				FileRecorder fr = new FileRecorder(cbxHour.getSelectedItem().toString(),
						cbxMinute.getSelectedItem().toString(), radioStr(), cbxStr(),
						Integer.parseInt(tfAmount.getText()), taDetail.getText());

				recorderList.add(fr);

				for (int i = daily.getSaveFrList().size(); i < count + daily.getSaveFrList().size(); i++) {
					dos.writeUTF(recorderList.get(i).toString());
				}

				taDetail.setText("");
				tfAmount.setText("�ݾ����Է��Ͻÿ�");
				daily.setCenter(recorderList);
				dispose();
				recorderList = new ArrayList<>();
				count++;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "�ݾ׶��� ���ڸ� �Է��ϼ���");
			} finally {
				MyUtils.closeAll(dos, fw);
			}
		}
		FileWriter fOption = null;
		try {
			fOption = new FileWriter("dats/option.dat");
			for (int i = 0; i < cbxIncome.getItemCount(); i++) {
				fOption.write("����:" + cbxIncome.getItemAt(i) + "\n");
			}
			for (int i = 0; i < cbxExpenditure.getItemCount(); i++) {
				fOption.write("����:" + cbxExpenditure.getItemAt(i) + "\n");
			}
			fOption.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fOption);
		}

	}

	// ����
	private void delete() {
		FileOutputStream fw = null;
		DataOutputStream dos = null;

		String fileName = "dats/" + daily.getLblDate().getText() + ".dat";
		ArrayList<FileRecorder> fileList = daily.getSaveFrList();
		ArrayList<DlgDailyPanel> pnlList = daily.getPnlList();
		try {
			fw = new FileOutputStream(fileName);
			dos = new DataOutputStream(fw);
			fileList.remove(index); // ������ �׸� �ε���ã�Ƽ� ����

			if (pnlList == null) {
				daily.getSavePnlList().get(index).setLayout(null);
				daily.getSavePnlList().get(index).setVisible(false);
			} else {
				pnlList.get(index).setLayout(null);
				pnlList.get(index).setVisible(false);

			}
			daily.setCenter(fileList);
			if (fileList.size() == 0) {
				dos.writeUTF("");
			} else {
				for (int i = 0; i < fileList.size(); i++) {
					dos.writeUTF(fileList.get(i).toString());
				}
			}
			// �ð�, ��, ������������, �׸�, �ݾ�, �󼼳���
			dispose();
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "�ݾ׶��� ���ڸ� �Է��ϼ���");
		} finally {
			MyUtils.closeAll(dos, fw);
		}
	}

	// ����-���� radio��ư ����
	private String radioStr() {
		if (rbIncome.isSelected()) {
			return rbIncome.getText();
		} else {
			return rbExpenditure.getText();
		}
	}

	// ����-���� �޺��ڽ� ���ڿ� ����
	private String cbxStr() {

		if (rbIncome.isSelected()) {
			return cbxIncome.getSelectedItem().toString();
		} else {
			return cbxExpenditure.getSelectedItem().toString();
		}
	}

	// Ȯ�ι�ư �������� �׸��Է��ߴ��� ����
	private void optionConfirm() {
		if (tfAppendOption.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "�׸��� �Է��ϼ���", "�Է�", JOptionPane.WARNING_MESSAGE);
		} else if (rbIncome.isSelected()) {
			cbxIncome.addItem(tfAppendOption.getText());
			pnlAppendption.setVisible(false);
		} else {
			cbxExpenditure.addItem(tfAppendOption.getText());
			pnlAppendption.setVisible(false);
		}
		pack();
		tfAppendOption.setText("");
	}

	// �׸���� ���Ͽ��� �о�´�
	private void readOption() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("dats/option.dat");
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.contains("����:")) {
					String strOption = line.substring(3, line.length());
					cbxIncome.addItem(strOption);
				} else {
					cbxExpenditure.addItem(line.substring(3, line.length()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fr);
		}
	}

	// �׸���� ���Ͽ��� �о�´� (�����ε�), �Ķ���� : ���԰� ������ ����������
	private void readOption(String option) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("dats/option.dat");
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String strOption = line.substring(3, line.length());
				if (line.contains("����:")) {
					cbxIncome.addItem(strOption);
					if (strOption.equals(option)) {
						rbIncome.setSelected(true);
						cbxIncome.setSelectedItem(option);
						cbxIncome.setVisible(true);
						cbxExpenditure.setVisible(false);
					}
				} else {
					cbxExpenditure.addItem(line.substring(3, line.length()));
					if (strOption.equals(option)) {
						rbExpenditure.setSelected(true);
						cbxExpenditure.setSelectedItem(option);
						cbxIncome.setVisible(false);
						cbxExpenditure.setVisible(true);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fr);
		}
	}

	private void showDialog() {
		setTitle("");
		pack();
		setLocationRelativeTo(null);
		setVisible(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}
// �����߰��� ���� �г�

class DlgDailyPanel extends JPanel implements Serializable{
	
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
		lblHour = new JLabel("�ð�", JLabel.CENTER);
		lblMinute = new JLabel("��", JLabel.CENTER);
		lblOption = new JLabel("�׸�");
		lblAmount = new JLabel("����ݾ�");
		lblDetail = new JLabel("�󼼳���");
		
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
		pnlTime.add(new JLabel("��"));
		pnlTime.add(lblMinute);
		pnlTime.add(new JLabel("��"));
		pnlOption.add(new JLabel(new ImageIcon("image/item.png")));
		pnlOption.add(lblOption);
		pnlAmount.add(new JLabel(new ImageIcon("image/money.png")));
		pnlAmount.add(lblAmount);
		pnlAmount.add(new JLabel("��"));
		pnlDetail.add(new JLabel(new ImageIcon("image/details.png")));
		pnlDetail.add(lblDetail);
		pnlDetail.setPreferredSize(new Dimension(300,30));
		
		pnlMain.setBorder(new TitledBorder(new LineBorder(new Color(0x9966FF)), "�߰�����"));
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
//������������ Ŭ����
class DlgSpecifiedDate extends JDialog {

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

	// =================�����Ⱓ���============================
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
		super(owner, "   << ����� �������� >>   ", true);
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
		btnConfirm = new JButton("Ȯ��");
		SetComponent.setButton(btnConfirm);
		btnConfirm.setBackground(Color.WHITE);
		lblTitle = new JLabel("�������������");
		lblTitle.setFont(new Font("�޸�ձ�������", Font.ITALIC, 25));
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setBorder(new EmptyBorder(10, 15, 10, 15));

		lblStart = new JLabel("���� ����");
		lblEnd = new JLabel("���� ����");

		// ���۳⵵ ����⵵ ����
		cbxYearStart = new JComboBox<String>();
		cbxYearEnd = new JComboBox<Integer>();
		for (int i = 2000; i <= 2020; i++) {
			cbxYearStart.addItem(String.valueOf(i));
			cbxYearEnd.addItem(i);
		}
		// ���ۿ� ����� ����
		cbxMonthStart = new JComboBox<>();
		cbxMonthEnd = new JComboBox<>();
		for (int i = 1; i < 13; i++) {
			cbxMonthStart.addItem(String.valueOf(i));
			cbxMonthEnd.addItem(i);
		}

		// ������������ ����

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
		// ����
		lblRan = new JLabel("~");
		pnlRan = new JPanel();

		pnlCenterNorthLeft = new JPanel();
		pnlCenterNorhtRight = new JPanel();
		pnlCenterNorth = new JPanel();
		pnlCenter = new JPanel();

		pnlSouth = new JPanel();

		// ���� ���̺�
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
						taUserRange.setFont(new Font("�޸յձ�������", Font.ITALIC, 20));
						TitledBorder title = new TitledBorder(new LineBorder(Color.WHITE), "��" + calcDays() + "��",
						TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
						title.setTitleFont(new Font("�޸յձ�������", Font.ITALIC, 15));
						taUserRange.setBorder(title);
						lblUserRange.setText("==" + "�ϰ� �󼼳���==");
						setSize(600, 900);
						pnlSouth.setVisible(true);
						lblImage.setVisible(true);
						setLocationRelativeTo(null);
						DlgSpecifiedDate.this.count = 0;
					} else {
						JOptionPane.showMessageDialog(DlgSpecifiedDate.this, "����� ���� �׸��� �����ϴ�.");
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
			JOptionPane.showMessageDialog(this, "�񱳳⵵�� ���س⵵���� ������ �����ϴ�");
			cbxYearEnd.setSelectedItem(cbxYearStart.getSelectedItem());
			if (cbxMonthStart.getSelectedIndex() > cbxMonthEnd.getSelectedIndex()) {
				JOptionPane.showMessageDialog(this, "�񱳿��� ���ؿ����� ������ �����ϴ�");
				cbxMonthEnd.setSelectedItem(cbxMonthStart.getSelectedItem());
				if (cbxDayStart.getSelectedIndex() > cbxDayEnd.getSelectedIndex()) {
					JOptionPane.showMessageDialog(this, "������ �����Ϻ��� ������ �����ϴ�");
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
				int ending = line.indexOf("�׸�:");

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
		temp += "\n============�׸� ������� ������=============\n\n";
		for (String keys : op2Money.keySet()) {
			int avgOp = (op2Money.get(keys)) / op2MoneyCount.get(keys);
			sb.append(keys + "�� ���� ��� : " + avgOp + "��\n");
			sb.append("\n");
		}
		
		sb.append("\n===========�׸� ��ü��� ������=============\n\n");
		for(String keys : mapOption.keySet()) {
			int avgMapOp = (mapOption.get(keys)) / mapOptionCount.get(keys);
			sb.append(keys + "�� ��ü ��� : " + avgMapOp + "��\n");
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

							int amountIndex = line.indexOf("�׸�:");
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

	// ��� �׳� ���̺� �ٸ��ִ� �޼���n
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
//�����߰��� ����鿡 ���� ��ü
class FileRecorder implements Serializable{

   private String hour;
   private String minute;
   private String inAndOut;
   private String option;
   private int amount;
   private String details;
   
   
   public FileRecorder(String hour, String minute, String inAndOut, String option, int amount, String details) {
      super();
      this.hour = hour;
      this.minute = minute;
      this.inAndOut = inAndOut;
      this.option = option;
      this.amount = amount;
      this.details = details;
   }
   
   public String getHour() {
      return hour;
   }
   public void setHour(String hour) {
      this.hour = hour;
   }
   public String getMinute() {
      return minute;
   }
   public void setMinute(String minute) {
      this.minute = minute;
   }
   public String getInAndOut() {
      return inAndOut;
   }

   public void setInAndOut(String inAndOut) {
      this.inAndOut = inAndOut;
   }

   public String getOption() {
      return option;
   }

   public void setOption(String option) {
      this.option = option;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

   public String getDetails() {
      return details;
   }

   public void setDetails(String details) {
      this.details = details;
   }
   @Override
   public String toString() {
      String str = "===================";
      str += "[" + hour + "��" + minute + "��] ";
      str += "in/out:" + inAndOut + " ";
      str += "�׸�:" + option + " ";
      str += "�ݾ�:" + amount + " ";
      str += "�󼼳���:" + details;
      
      return str;
   }
}
// ������Ʈ ����
class SetComponent extends JComponent implements Serializable{
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
		lbl.setFont(new Font("�޸ո���ü", Font.BOLD, 25));
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
class MyUtils implements Serializable{
	public static void closeAll(Closeable... c) {
		for( Closeable temp : c ) {
			try {
				temp.close();
			} catch(Exception e) {}
		}
	}
}

//ùȭ��
public class MainAccountBook extends JFrame implements Serializable {

	// north
	private JPanel pnlNorth;
	private JComboBox<Integer> cbYear;
	private JComboBox<String> cbMonth;
	private JButton before;
	private JButton after;

	// center
	private HashMap<Integer, CalendarPanel> calendarMap;
	private JPanel pnlCenter;
	private int key;
	// south
	private JPanel pnlSouth;
	private JButton details;
	private JButton cmpAnalsis;
	private JButton specifiedDate;
	private ArrayList<Integer> keyList;
	public static final String SAVE_FILE_NAME = "myAccountBook/MyAcountBook.dat";

	public MainAccountBook() {
		init();
		readCalendar();
		setDisplay();
		addListeners();
		showFrame();

	}

	public HashMap<Integer, CalendarPanel> getCalendarMap() {
		return calendarMap;
	}

	public void setCalendarMap(HashMap<Integer, CalendarPanel> calendarMap) {
		this.calendarMap = calendarMap;
	}

	public JComboBox<Integer> getCbYear() {
		return cbYear;
	}

	public void setCbYear(JComboBox<Integer> cbYear) {
		this.cbYear = cbYear;
	}

	public JComboBox<String> getCbMonth() {
		return cbMonth;
	}

	public void setCbMonth(JComboBox<String> cbMonth) {
		this.cbMonth = cbMonth;
	}

	public Object getMonthSelected() {
		return cbMonth.getSelectedItem();
	}

	public Object getYearSelected() {
		return cbYear.getSelectedItem();
	}

	private void init() {
		SetComponent.setLookAndFeel();

		pnlNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
		cbYear = new JComboBox<>();
		cbMonth = new JComboBox<>();
		before = new JButton(new ImageIcon("image/before.png"));
		after = new JButton(new ImageIcon("image/after.png"));

		calendarMap = new HashMap<>();
		pnlCenter = new JPanel(new BorderLayout());

		pnlSouth = new JPanel();
		details = new JButton("�󼼳���");
		cmpAnalsis = new JButton("�񱳺м�");
		specifiedDate = new JButton("���������");

	}

	private void setDisplay() {
		setComboBox();

		if (!calendarMap.containsKey(202006)) {
			calendarMap.put(202006, new CalendarPanel(this, Integer.parseInt(cbYear.getSelectedItem().toString()),
					Integer.parseInt(cbMonth.getSelectedItem().toString())));
		}
		SetComponent.setButton(details);
		SetComponent.setButton(cmpAnalsis);
		SetComponent.setButton(specifiedDate);

		pnlNorth.add(before);
		pnlNorth.add(cbYear);
		pnlNorth.add(cbMonth);
		pnlNorth.add(after);

		pnlSouth.add(details);
		pnlSouth.add(cmpAnalsis);
		pnlSouth.add(specifiedDate);

		pnlNorth.setBackground(new Color(0xe6f4fa));

		add(pnlNorth, BorderLayout.NORTH);

		pnlCenter.add(calendarMap.get(202006));
		add(pnlCenter, BorderLayout.CENTER);

		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setComboBox() { // �⵵ ���� �޺��ڽ�
		for (int i = 2000; i < 2021; i++) {
			cbYear.addItem(i);
		}
		for (int i = 1; i < 13; i++) {
			if (i < 10) {
				cbMonth.addItem("0" + i);
			} else {
				cbMonth.addItem("" + i);
			}
		}
		cbYear.setPreferredSize(new Dimension(70, 28));
		cbMonth.setPreferredSize(new Dimension(70, 28));

		cbYear.setSelectedIndex(20);
		cbMonth.setSelectedIndex(5);
	}

	private void addListeners() {
		ActionListener listener = (ae) -> {
			Object src = ae.getSource();
			if (before == src) {
				before(); // ������ư
			} else if (after == src) {
				after(); // �Ĺ�ư
			} else if (details == src) { // �󼼳��� ��ư
				new DlgCurrentMonthDetails(MainAccountBook.this);
			} else if (cmpAnalsis == src) { // �񱳺м���ư
				new DlgCompareAnalysis(MainAccountBook.this);
			} else if (specifiedDate == src) { // ��������� ��ư
				new DlgSpecifiedDate(MainAccountBook.this);
			}
		};
		ActionListener cbxListener = (ae) -> { // ��,�� �޺��ڽ� ������
			JComboBox<?> jcb = (JComboBox<?>) ae.getSource();

			if (jcb == cbYear) {
				String index = jcb.getSelectedItem().toString();
				pnlCenter.setVisible(false);
				year(index);
			} else if (jcb == cbMonth) {
				String index = jcb.getSelectedItem().toString();
				pnlCenter.setVisible(false);
				month(index);
			}

		};
		before.addActionListener(listener);
		after.addActionListener(listener);

		details.addActionListener(listener);
		cmpAnalsis.addActionListener(listener);
		specifiedDate.addActionListener(listener);

		cbYear.addActionListener(cbxListener);
		cbMonth.addActionListener(cbxListener);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				int result = JOptionPane.showConfirmDialog(MainAccountBook.this, "�����Ͻðڽ��ϱ�???", "exit",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				keyList = new ArrayList<>();
				if (result == JOptionPane.YES_OPTION) {
					FileOutputStream fis = null;
					ObjectOutputStream oos = null;
					try {
						fis = new FileOutputStream(SAVE_FILE_NAME);
						oos = new ObjectOutputStream(fis);
						Vector<CalendarPanel> calendar = new Vector<>();

						for (Integer keys : calendarMap.keySet()) {
							boolean flag = false;
							for (int i = 0; i < calendarMap.get(keys).getBtnDays().length; i++) {
								if (calendarMap.get(keys).getBtnDays()[i].getText().length() > 3) {
									flag = true;
								}

							}
							if (flag) {
								calendar.add(calendarMap.get(keys));
								keyList.add(keys);
							}
						}

						oos.writeObject(calendar);
						oos.flush();
						oos.reset();

					} catch (ClassCastException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						MyUtils.closeAll(oos, fis);
					}
					FileOutputStream fos2 = null;
					DataOutputStream dos2 = null;
					try {
						fos2 = new FileOutputStream("myAccountBook/keys.dat");
						dos2 = new DataOutputStream(fos2);

						for (int i = 0; i < keyList.size(); i++) {
							dos2.writeUTF(keyList.get(i).toString());
						}
						dos2.flush();
					} catch (IOException e) {
					} finally {
						MyUtils.closeAll(dos2, fos2);
					}
					System.exit(0);
				}
			}
		});
	}

	// �⸶��
	private void year(String index) {
		pnlCenter.removeAll();
		key = Integer.parseInt(index + cbMonth.getSelectedItem().toString());

		int year = Integer.parseInt(index);
		int month = Integer.parseInt(cbMonth.getSelectedItem().toString());

		if (calendarMap.containsKey(key)) {
		} else {
			calendarMap.put(key, new CalendarPanel(this, year, month));
		}
		calendarMap.get(202006).setVisible(false);
		if (cbYear.getSelectedIndex() == 20 && cbMonth.getSelectedIndex() == 5) {
			calendarMap.get(202006).setVisible(true);
		}
		pnlCenter.add(calendarMap.get(key));
		pnlCenter.setVisible(true);
		add(pnlCenter, BorderLayout.CENTER);
	}

	// ������
	private void month(String index) {
		pnlCenter.removeAll();
		key = Integer.parseInt(cbYear.getSelectedItem().toString() + index);

		int year = Integer.parseInt(cbYear.getSelectedItem().toString());
		int month = Integer.parseInt(index);

		if (calendarMap.containsKey(key)) {
		} else {
			calendarMap.put(key, new CalendarPanel(this, year, month));
		}
		calendarMap.get(202006).setVisible(false);
		if (cbYear.getSelectedIndex() == 20 && cbMonth.getSelectedIndex() == 5) {
			calendarMap.get(202006).setVisible(true);
		}
		pnlCenter.add(calendarMap.get(key));
		pnlCenter.setVisible(true);
		add(pnlCenter, BorderLayout.CENTER);
	}

	// �� ��ư
	private void before() {
		pnlCenter.removeAll();
		if (cbMonth.getSelectedIndex() <= 0) {
			cbYear.setSelectedIndex(cbYear.getSelectedIndex() - 1);
			cbMonth.setSelectedIndex(11);

		} else if (cbYear.getSelectedIndex() <= -1) {
			JOptionPane.showMessageDialog(this, "2000������Դϴ�", "�ּ�", JOptionPane.WARNING_MESSAGE);
			cbMonth.setSelectedIndex(0);
			cbYear.setSelectedIndex(0);
		} else {
			cbMonth.setSelectedIndex(cbMonth.getSelectedIndex() - 1);
		}

		key = Integer.parseInt(cbYear.getSelectedItem().toString() + cbMonth.getSelectedItem().toString());

		int year = Integer.parseInt(cbYear.getSelectedItem().toString());
		int month = Integer.parseInt(cbMonth.getSelectedItem().toString());

		if (calendarMap.containsKey(key)) {
		} else {
			calendarMap.put(key, new CalendarPanel(this, year, month));
		}
		calendarMap.get(202006).setVisible(false);
		if (cbYear.getSelectedIndex() == 20 && cbMonth.getSelectedIndex() == 5) {
			calendarMap.get(202006).setVisible(true);
		}
		pnlCenter.add(calendarMap.get(key));
		pnlCenter.setVisible(true);
		add(pnlCenter, BorderLayout.CENTER);
	}

	// �� ��ư
	private void after() {
		pnlCenter.removeAll();
		try {
			if (cbMonth.getSelectedIndex() >= 11) {
				cbYear.setSelectedIndex(cbYear.getSelectedIndex() + 1);
				cbMonth.setSelectedIndex(0);
			} else {
				cbMonth.setSelectedIndex(cbMonth.getSelectedIndex() + 1);
			}

			key = Integer.parseInt(cbYear.getSelectedItem().toString() + cbMonth.getSelectedItem().toString());

			int year = Integer.parseInt(cbYear.getSelectedItem().toString());
			int month = Integer.parseInt(cbMonth.getSelectedItem().toString());

			if (calendarMap.containsKey(key)) {
			} else {
				calendarMap.put(key, new CalendarPanel(this, year, month));
			}
			
			calendarMap.get(202006).setVisible(false);
			if (cbYear.getSelectedIndex() == 20 && cbMonth.getSelectedIndex() == 5) {
				calendarMap.get(202006).setVisible(true);
			}
			pnlCenter.add(calendarMap.get(key));
			pnlCenter.setVisible(true);
			add(pnlCenter, BorderLayout.CENTER);

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, "2020������Դϴ�", "�ִ�", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void readCalendar() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Vector<?> list = null;
		try {
			fis = new FileInputStream(SAVE_FILE_NAME);
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			list = (Vector<?>) o;

		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		} finally {
			MyUtils.closeAll(ois, fis);
		}

		FileInputStream fis2 = null;
		DataInputStream dis2 = null;

		try {
			fis2 = new FileInputStream("myAccountBook/keys.dat");
			dis2 = new DataInputStream(fis2);

			keyList = new ArrayList<>();
			while (dis2.available() > 0) {
				keyList.add(Integer.parseInt(dis2.readUTF()));
			}
		} catch (IOException e) {
		} catch (NullPointerException e) {

		} finally {
			MyUtils.closeAll(dis2, fis2);
		}
		setMainAccountBook(list, keyList);
	}

	public void setMainAccountBook(Vector<?> book, ArrayList<Integer> keys) {
		try {
			for (int i = 0; i < book.size(); i++) {
				CalendarPanel pnl = (CalendarPanel) book.get(i);
				calendarMap.put(keys.get(i), new CalendarPanel(this, keys.get(i) / 100, keys.get(i) % 100, true));
				for (int j = 0; j < pnl.getBtnDays().length; j++) {
					if (pnl.getBtnDays()[j].getText().length() > 3)
						calendarMap.get(keys.get(i)).getBtnDays()[j].setText(pnl.getBtnDays()[j].getText());
				}
			}
		} catch (NullPointerException e) {
		}
	}

	private void showFrame() {
		setTitle("�����");
		setSize(850, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainAccountBook();
	}
}