package implementation.medium;

import java.util.HashMap;
import java.util.Map;

public class FileSystem_Atlassian {
    public static void main(String[] args) {
        FileSystem_Atlassian fsa = new FileSystem_Atlassian();

    }

    public class FileSystem {
        Map<String, Integer> valueByPath = new HashMap<>();
        public FileSystem() {

        }

        public boolean createPath(String path, int value) {
            int lastForwardPath = path.lastIndexOf("/");

            if(lastForwardPath > 0 && !valueByPath.containsKey(path.substring(0, lastForwardPath))) {
                return false;
            }

            if(valueByPath.containsKey(path)) {
                return false;
            }

            valueByPath.put(path, value);

            return true;
        }

        public int get(String path) {
            return valueByPath.getOrDefault(path, -1);
        }
    }
}



