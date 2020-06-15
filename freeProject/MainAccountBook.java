package kr.ac.green;

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

//첫화면
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
		details = new JButton("상세내역");
		cmpAnalsis = new JButton("비교분석");
		specifiedDate = new JButton("사용자지정");

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

	private void setComboBox() { // 년도 월별 콤보박스
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
				before(); // 이전버튼
			} else if (after == src) {
				after(); // 후버튼
			} else if (details == src) { // 상세내역 버튼
				new DlgCurrentMonthDetails(MainAccountBook.this);
			} else if (cmpAnalsis == src) { // 비교분석버튼
				new DlgCompareAnalysis(MainAccountBook.this);
			} else if (specifiedDate == src) { // 사용자지정 버튼
				new DlgSpecifiedDate(MainAccountBook.this);
			}
		};
		ActionListener cbxListener = (ae) -> { // 년,월 콤보박스 리스너
			JComboBox<?> jcb = (JComboBox<?>) ae.getSource();

			if (jcb == cbYear) {
				try {
					String index = jcb.getSelectedItem().toString();
					pnlCenter.setVisible(false);
					year(index);

				} catch (NullPointerException e) {

				}
			} else if (jcb == cbMonth) {
				try {
					String index = jcb.getSelectedItem().toString();
					pnlCenter.setVisible(false);
					month(index);
				} catch (NullPointerException e) {

				}
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
				int result = JOptionPane.showConfirmDialog(MainAccountBook.this, "종료하시겠습니까???", "exit",
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

	// 년마다
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

	// 월마다
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

	// 전 버튼
	private void before() {
		pnlCenter.removeAll();
		if (cbMonth.getSelectedIndex() <= 0) {
			cbYear.setSelectedIndex(cbYear.getSelectedIndex() - 1);
			cbMonth.setSelectedIndex(11);

		} else if (cbYear.getSelectedIndex() <= -1) {
			JOptionPane.showMessageDialog(this, "2000년까지입니다", "최소", JOptionPane.WARNING_MESSAGE);
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

	// 후 버튼
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
			JOptionPane.showMessageDialog(this, "2020년까지입니다", "최대", JOptionPane.WARNING_MESSAGE);
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
		setTitle("가계부");
		setSize(850, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainAccountBook();
	}
}