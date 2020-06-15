package kr.ac.green;

import java.io.Serializable;

// 그에 년과 월을 윤년을 포함해서 총일수를 구한다음 시작하는 요일과 끝나는 요일을 찾음
public class CalendarDateCalculation implements Serializable{
	// 미리 기준 연도와 , 기준월을 정해서 출력하는 방법을 선택함.
	
	private int baseYear = 2000; // 기준 연도
	private int baseMonth = 1; // 기준 월 입니다. 실제로는 1980년 1월 1을 기준으로 계산
	private int totalSum = 0; // 기준 년과 월에서 입력받은 날짜까지 총 일수를 여기에 저장

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

	public boolean isLeapYear(int n) { // 윤년이 있는 년도를 조사하는 함수입니다

		if (n % 4 == 0) { // 4의 배수는 윤년
			if (n % 100 == 0) { //100의 배수는 윤년이 아니다
				if (n % 400 == 0) { //400의 배수는 윤년
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

	private int totalToMonth(int total) // 기준 날짜부터 입력받은 날짜까지 총 일수를 구해서 반환,
	{

		boolean CHK = true; // 무한 루프를 돌리기위한 불리안 값입니다.
		int i = 0; // i변수는 월입니다.
		int cnt = 0; // 총 일수를 월로 바꾸어서 cnt 저장시킵니다.
		int checkLeapYear = baseYear; // 총 일수를 월로 바꾸려면 윤년이 있는 날을 고려해야합니다.
										// 기준연도부터 시작해서 윤년을 조사합니다.

		while (CHK) {
			if (isLeapYear(checkLeapYear)) // 만약 지금 연도가 윤년이라면
				monthArr[1] = 29; // 2월달은 하루가 더 늘어납니다.

			if (total >= monthArr[i]){ // 총 일수가 month_table[]배열의 총일수 보다 작다면,
			
				total -= monthArr[i++]; // 총일수를 month_table 배열의 현재 월의 일수로 빼줍니다.
										// 그리고 i를 증가시킵니다. 즉 다음달로 증가됩니다.
				
				cnt++; // 그리고 월이 증가합니다.
				if (i == 12) {// 만약 12월이된다면 계절이 변해 다시 제자리로 오는것처럼
					i -= 12; // 다시 12를빼서 0으로 만들어줍니다.
					checkLeapYear++; // 그리고 12개월이 지났으니 연도도 증가시켜줘야함
				}
				monthArr[1] = 28; // 윤년을 평년의 해로 바꾸어주어야합니다.
			}
			else {
				CHK = false;
			}
		}
		cnt %= 12; // 위의 무한루프를 통해 총일수를 총월수로 계산됨, 이제 12 나머지 연산을 해주면 몇년도 몇월이라는 값으로 바꿀수있습니다.
		
		return (cnt + 1); // 그리고 바꾼 월을 반환
	}

	private int countLeap(int n){ // 기준 연도부터 시작해서 입력받은 연도까지의 윤년이 있는날을 셉니다.
		int i; // 기준연도를 저장합니다.
		int cnt = 0; // 윤년의 개수입니다.

		for (i = baseYear; i < (baseYear - n); i++){
			if (isLeapYear(i)){ 
				cnt++; 
			}
		}
		return cnt; // 카운트한 윤년의 갯수를 리턴합니다.
	}

	private void allSumDay(int nYear) { // 기준 연도부터 입력받은 연도까지 총일수를 구해서 리턴합니다.
		totalSum = ((nYear - baseYear) * 365) + countLeap((baseYear - nYear));
	}
	
	public int result(int nYear, int mth) {//핵심
		int month;

		int dy = countLeap(baseYear - nYear); // dy는 기준연도부터 현재연도까지 낀 윤년의 갯수입니다.
		allSumDay(nYear); // ★ 우선 기준연도부터 현재 연도까지 년 단위로 총일수를 구합니다. ★

		int day = 0; 
		if (nYear >= baseYear) {

			if (isLeapYear(nYear)) // 윤달이 낀날의 2월은 하루 증가
				monthArr[1] = 29;

			for (int i = 0; i < (mth - baseMonth); i++)
				totalSum += monthArr[i];

			day = (totalSum + 6) % 7; //요일
			
			month = totalToMonth(totalSum);
			
			monthArr[1] = 28; // 윤년이었다면 다시 평년으로 바꾸어줍니다.
			
			return day;
		} else {
			return -1;
		}
		
	}
}