public class free15 {
  public static void main(String[] args) throws Exception {
    String date = "2023-01-27";
    String[] d = date.split("-");
    int year = Integer.parseInt(d[0]);
    int month = Integer.parseInt(d[1]);
    int[] dayNum = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int result = 0;

    if (month == 2 && (year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0) {
      result = 29;
    } else {
      result = dayNum[month];
    }

    System.out.println(result);
  }
}
