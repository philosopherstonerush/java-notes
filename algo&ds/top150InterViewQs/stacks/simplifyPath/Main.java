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

        // adding directories to this
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int i =0;

        while(i < path.length()) {

            // remove multiple trailing slashes
            while(i < path.length() && path.charAt(i) == '/') i++;
            // add characters together until you get the string between the trailing /
            while(i < path.length() && path.charAt(i) != '/') sb.append(path.charAt(i++));

            // get the directory name
            String ok = sb.toString();

            // if its .. remove the previous entry
            if(ok.equals("..") && !arr.isEmpty()) arr.remove(arr.size()-1);
            // if its . dont store
            else if(!ok.isBlank() && !ok.equals(".") && !ok.equals("..")) arr.add(ok);
            sb = new StringBuilder();
        }

        StringBuilder result = new StringBuilder();
        result.append("/");
        for(String s : arr) {
            result.append(s).append("/");
        }

        // remove the last / if directory is actually present
        if (result.length() > 1) result.deleteCharAt(result.length()-1);

        return result.toString();
    }
}
