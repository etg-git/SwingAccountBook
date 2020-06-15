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

// ���� �߰� ���
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}