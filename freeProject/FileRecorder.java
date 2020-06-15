package kr.ac.green;

import java.io.Serializable;

//내역추가한 내용들에 대한 객체
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
      str += "[" + hour + "시" + minute + "분] ";
      str += "in/out:" + inAndOut + " ";
      str += "항목:" + option + " ";
      str += "금액:" + amount + " ";
      str += "상세내역:" + details;
      
      return str;
   }
}