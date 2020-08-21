class SharePurchases {
    public static long analyzeInvestments(String s) {
        String t = "ABC";
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();

        int[] tcount = new int[256];
        for (char c : tc) {
            tcount[c]++;
        }

        int unformed = tc.length;
        int lo = 0; // start of window
        int hi = 0; // end of window

        int count = 0;

        while (hi < sc.length) {
            if (tcount[sc[hi]]-- > 0) {
                unformed--;
            }

            while (lo <= hi && unformed == 0) {
                count += s.length() - hi;

                if (tcount[sc[lo++]]++ == 0) {
                    unformed++;
                }
            }

            hi++;
        }

        return count;
    }
}


class Main {
    public static void main(String[] args) {
        String[] testcases = new String[] {"PQACBA", "ABCCBA"};

        for (String testcase : testcases) {
            System.out.println(SharePurchases.analyzeInvestments(testcase));
        }
    }
}
