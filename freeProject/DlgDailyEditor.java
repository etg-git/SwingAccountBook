package kr.ac.green;

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

// 내역 추가 기능
public class DlgDailyEditor extends JDialog implements Serializable {

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

	// 수정삭제하는 생성자
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
		btnDelete = new JButton("삭제");
		btnConfirm = new JButton("확인");

		cbxHour = new JComboBox<Integer>();
		cbxMinute = new JComboBox<Integer>();

		rbIncome = new JRadioButton("수입", true);
		rbExpenditure = new JRadioButton("지출");
		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(rbIncome);
		btnGrp.add(rbExpenditure);

		tfAmount = new JTextField(10);
		cbxIncome = new JComboBox<String>();
		cbxExpenditure = new JComboBox<String>();
		btnExpAppend = new JButton("항목추가");

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
		btnOConfirm = new JButton("확인");
		recorderList = new ArrayList<>();
	}

	private void setDisplay() {
		SetComponent.setLookAndFeel();
		SetComponent.setButton(btnBefore);
		SetComponent.setButton(btnDelete);
		SetComponent.setButton(btnConfirm);
		btnDelete.setBackground(new Color(0xFFCCCC));
		tfAmount.setText("금액을입력하시오");
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

	// 콤보박스 첫 옵션 셋팅
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

	// 수정에 대해서 확인 눌리는 event
	private void editConfirm() {
		boolean flag = true;

		if (tfAmount.getText().equals("") || tfAmount.getText().equals("금액을입력하시오")) {
			JOptionPane.showMessageDialog(this, "금액을 입력하시오");
			flag = false;
		}
		if (flag && taDetail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "상세내용을 입력하시오");
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
				// 시간, 분, 수입지출인지, 항목, 금액, 상세내용
				// 파일안에 수정
				fileList.get(index).setHour(cbxHour.getSelectedItem().toString());
				fileList.get(index).setMinute(cbxMinute.getSelectedItem().toString());
				fileList.get(index).setInAndOut(radioStr());
				fileList.get(index).setOption(cbxStr());
				fileList.get(index).setAmount(Integer.parseInt(tfAmount.getText()));
				fileList.get(index).setDetails(taDetail.getText());

				// 지출수입 내용 패널 수정
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
				JOptionPane.showMessageDialog(this, "금액란에 숫자를 입력하세요");
			} finally {
				MyUtils.closeAll(dos, fw);
			}
		}
		FileWriter fOption = null;
		try {
			fOption = new FileWriter("dats/option.dat");
			for (int i = 0; i < cbxIncome.getItemCount(); i++) {
				fOption.write("수입:" + cbxIncome.getItemAt(i) + "\n");
			}
			for (int i = 0; i < cbxExpenditure.getItemCount(); i++) {
				fOption.write("지출:" + cbxExpenditure.getItemAt(i) + "\n");
			}
			fOption.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fOption);
		}
	}

	// 내역추가 확인버튼 event
	private void confirm() {
		boolean flag = true;
		int count = 1;
		if (tfAmount.getText().equals("") || tfAmount.getText().equals("금액을입력하시오")) {
			JOptionPane.showMessageDialog(this, "금액을 입력하시오");
			flag = false;
		}
		if (flag && taDetail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "상세내용을 입력하시오");
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
				// 시간, 분, 수입지출인지, 항목, 금액, 상세내용
				FileRecorder fr = new FileRecorder(cbxHour.getSelectedItem().toString(),
						cbxMinute.getSelectedItem().toString(), radioStr(), cbxStr(),
						Integer.parseInt(tfAmount.getText()), taDetail.getText());

				recorderList.add(fr);

				for (int i = daily.getSaveFrList().size(); i < count + daily.getSaveFrList().size(); i++) {
					dos.writeUTF(recorderList.get(i).toString());
				}

				taDetail.setText("");
				tfAmount.setText("금액을입력하시오");
				daily.setCenter(recorderList);
				dispose();
				recorderList = new ArrayList<>();
				count++;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "금액란에 숫자를 입력하세요");
			} finally {
				MyUtils.closeAll(dos, fw);
			}
		}
		FileWriter fOption = null;
		try {
			fOption = new FileWriter("dats/option.dat");
			for (int i = 0; i < cbxIncome.getItemCount(); i++) {
				fOption.write("수입:" + cbxIncome.getItemAt(i) + "\n");
			}
			for (int i = 0; i < cbxExpenditure.getItemCount(); i++) {
				fOption.write("지출:" + cbxExpenditure.getItemAt(i) + "\n");
			}
			fOption.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fOption);
		}

	}

	// 삭제
	private void delete() {
		FileOutputStream fw = null;
		DataOutputStream dos = null;

		String fileName = "dats/" + daily.getLblDate().getText() + ".dat";
		ArrayList<FileRecorder> fileList = daily.getSaveFrList();
		ArrayList<DlgDailyPanel> pnlList = daily.getPnlList();
		try {
			fw = new FileOutputStream(fileName);
			dos = new DataOutputStream(fw);
			fileList.remove(index); // 수정할 항목 인덱스찾아서 삭제

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
			// 시간, 분, 수입지출인지, 항목, 금액, 상세내용
			dispose();
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "금액란에 숫자를 입력하세요");
		} finally {
			MyUtils.closeAll(dos, fw);
		}
	}

	// 수입-지출 radio버튼 리턴
	private String radioStr() {
		if (rbIncome.isSelected()) {
			return rbIncome.getText();
		} else {
			return rbExpenditure.getText();
		}
	}

	// 수입-지출 콤보박스 문자열 리턴
	private String cbxStr() {

		if (rbIncome.isSelected()) {
			return cbxIncome.getSelectedItem().toString();
		} else {
			return cbxExpenditure.getSelectedItem().toString();
		}
	}

	// 확인버튼 누르기전 항목입력했는지 여부
	private void optionConfirm() {
		if (tfAppendOption.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "항목을 입력하세요", "입력", JOptionPane.WARNING_MESSAGE);
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

	// 항목들을 파일에서 읽어온다
	private void readOption() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("dats/option.dat");
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.contains("수입:")) {
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

	// 항목들을 파일에서 읽어온다 (오버로딩), 파라미터 : 수입과 지출을 나누기위해
	private void readOption(String option) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("dats/option.dat");
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String strOption = line.substring(3, line.length());
				if (line.contains("수입:")) {
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}