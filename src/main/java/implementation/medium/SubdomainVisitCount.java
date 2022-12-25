package implementation.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        SubdomainVisitCount s = new SubdomainVisitCount();
        String[] ip = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> op = s.subdomainVisits(ip);
        for(String i : op) {
            System.out.println(i);
        }
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains.length == 0) {
            return new ArrayList<>();
        }

        Map<String, Integer> op = new HashMap<>();

        for (String s : cpdomains) {
            int domainVisitCount = Integer.valueOf(s.split(" ")[0]);
            String sValue = s.split(" ")[1];
            decode(sValue, domainVisitCount, op);
        }

        if (op.size() == 0) {
            return new ArrayList<>();
        }

        List<String> rOp = new ArrayList<>();
        for(String i : op.keySet()) {
            rOp.add(op.get(i) + " " + i);
        }
        return rOp;
    }

    private void decode(String ip, int domainsVisitCount, Map<String, Integer> op) {
        if (ip.isBlank() || ip.isEmpty()) {
            return;
        }

        if (ip.contains(".")) {
            if (op.containsKey(ip)) {
                int v = op.getOrDefault(ip, 0);
                op.put(ip, v + domainsVisitCount);
            } else {
                op.put(ip, domainsVisitCount);
            }

            int k = ip.indexOf(".", 0);
            String j = ip.substring(k + 1, ip.length());

            decode(j, domainsVisitCount, op);
        } else {
            if (op.containsKey(ip)) {
                int v = op.getOrDefault(ip, 0);
                op.put(ip, v + domainsVisitCount);
            } else {
                op.put(ip, domainsVisitCount);
            }
            decode("", domainsVisitCount, op);
        }
    }
}
