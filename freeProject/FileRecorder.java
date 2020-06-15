package kr.ac.green;

import java.io.Serializable;

//�����߰��� ����鿡 ���� ��ü
public class FileRecorder implements Serializable{

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