import java.util.*;


/**
 *
 *
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 *
 */


public class Main {

    public static void main(String[] args) {
        String test = "/a/b/../../c";
        System.out.println(simplifyPath(test));
    }

    public static String simplifyPath(String path) {

        // Split the string
        ArrayList<String> splitString = new ArrayList<>(Arrays.asList(path.split("/")));

        // Initialize stack
        Stack<String> stringStack = new Stack<>();

        // result strings - directories.
        ArrayList<String> result = new ArrayList<>();

        // remove the pointers to the same directory
        splitString.remove(".");

        // remove empty strings
        splitString.remove("");

        for (String s : splitString) {
            stringStack.push(s);
        }

        // keep count of .. (go back directory) - to help with their subsequent appearance
        int removeDirect = 0;

        while(!stringStack.isEmpty()) {

            // take the top element
            String temp = stringStack.pop();

            if (temp.equals("..")) {
                removeDirect++;
            } else if(temp.equals("")) {
                continue;
            } else if(temp.equals(".")) {
                continue;
            } else {
                if (removeDirect != 0) {
                    removeDirect--;
                    continue;
                }
                result.add(temp);
            }
        }

        // the result array is reversed to the last part appears last.
        Collections.reverse(result);
        StringBuilder str = new StringBuilder();

        if(result.isEmpty()) {
            str.append("/");
        }

        for (String s : result) {
            str.append("/");
            str.append(s);
        }

        return str.toString();
    }
}
