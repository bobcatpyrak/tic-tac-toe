import java.util.Scanner;

public class Console {
    
    private static Scanner sc = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();  // read user entry
       // sc.nextLine();  // discard any other data entered on the line
        return s;
    }

    public static String getChoiceString(String prompt, String s1, String s2) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getRequiredString(prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                System.out.println("Error! Entry must be '" + s1 + "' or '" +
                        s2 + "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }

    public static String getChoiceString(String prompt, String ...sa) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getRequiredString(prompt);
            
            
            for(String s1 : sa)
            {
            	if(s.equalsIgnoreCase(s1))
            		isValid = true;
            }
            
            if(!isValid)
            	System.out.println("Error! Unrecognized entry!");
        }
        return s;
    }
public static String getRequiredString(String prompt) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }

	public static boolean getBoolean(String prompt) {

		String check = getChoiceString(prompt, "true", "false");
		if(check.equalsIgnoreCase("true")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean getYesOrNo(String prompt) {

		String check = getChoiceString(prompt, "y", "n");
		if(check.equalsIgnoreCase("y")) {
			return true;
		}
		else {
			return false;
		}
	}
	
    public static int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }
    
    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i < min) {
                System.out.println(
                        "Error! Number must be greater than or equal to " + min + ".");
            } else if (i > max) {
                System.out.println(
                        "Error! Number must be less than or equal to " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid number. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d < min) {
                System.out.println(
                        "Error! Number must be greater than or equal to " + min + ".");
            } else if (d > max) {
                System.out.println(
                        "Error! Number must be less than or equal to " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }
    
    public static void println(String s)
    {
    	System.out.println(s);
    }
}