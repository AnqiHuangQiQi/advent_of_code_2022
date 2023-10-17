import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day1A {
  public static void main(String[] args) {
      System.out.println("Day 1 A result:");
      System.out.println(getTopCalorie());
      System.out.println("Done");
  }

  private static int getTopCalorie() {
    int top = 0;
    String dir = System.getProperty("user.dir");
    try {
			BufferedReader reader = new BufferedReader(new FileReader(dir + "/day1_input.txt"));

      String line = reader.readLine();

      int cur = 0;

			while (line != null) {
        if (line.length() == 0) {
          top = Math.max(cur, top);
          cur = 0;
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

    return top;
  }
}