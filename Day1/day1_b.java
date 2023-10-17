import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Day1B {
  public static void main(String[] args) {
      System.out.println("Day 1 B result:");
      System.out.println(getTopCalorie());
      System.out.println("Done");
  }

  private static int getTopCalorie() {
    Stack<Integer> top = new Stack<Integer>();
    Stack<Integer> tmp = new Stack<Integer>();
    String dir = System.getProperty("user.dir");
    try {
			BufferedReader reader = new BufferedReader(new FileReader(dir + "/day1_input.txt"));

      String line = reader.readLine();

      int cur = 0;

			while (line != null) {
        if (line.length() == 0) {

          int i = 3;
          while (!top.empty() && i-- > 0) {
            if (cur > top.peek()) {
              tmp.push(top.pop());
            }
          }

          if (top.size() < 3) {
            top.push(cur);
          }

          while (top.size() < 3 && !tmp.empty()) {
            top.push(tmp.pop());
          }

          cur = 0;
          tmp.clear();
        } else {
          // If there is no valid input, add validation here for each line string
          cur += Integer.valueOf(line);
        }

				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    int sum = 0;
    while (!top.empty()) {
      sum += top.pop();
    }

    return sum;
  }
}