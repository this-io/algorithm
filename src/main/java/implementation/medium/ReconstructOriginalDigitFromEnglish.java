package implementation.medium;

public class ReconstructOriginalDigitFromEnglish {

    public static void main(String[] args) {
        ReconstructOriginalDigitFromEnglish r = new ReconstructOriginalDigitFromEnglish();
        System.out.println(r.originalDigits("owoztneoer"));
    }

    public String originalDigits(String s) {
        if(s.isEmpty()) {
            return "";
        }

        int[] count = new int[26];

        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] num = new int[10];

        num[0] = count['z' - 'a'];
        num[2] = count['w' - 'a'];
        num[4] = count['u' - 'a'];
        num[6] = count['x' - 'a'];
        num[8] = count['g' - 'a'];

        num[1] = count['o' - 'a'] - num[0] - num[2] - num[4];
        num[3] = count['h' - 'a'] - num[8];
        num[5] = count['f' - 'a'] - num[4];
        num[7] = count['s' - 'a'] - num[6];
        num[9] = count['i' - 'a'] - num[5] - num[6] - num[8];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++) {
            while(num[i]-- > 0) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
