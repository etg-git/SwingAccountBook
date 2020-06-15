package kr.ac.green;

import java.io.Serializable;

// �׿� ��� ���� ������ �����ؼ� ���ϼ��� ���Ѵ��� �����ϴ� ���ϰ� ������ ������ ã��
public class CalendarDateCalculation implements Serializable{
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