class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        int pointer = sArray.length - 1;
        int freq = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = sArray.length - 1; i >= 0; i--) {
            //Start
            if(sb.length() == 0) {
                sb.append(sArray[i]);
                freq = 1;
                continue;
            }
            //Case 1 Not dupe
            if(sArray[i] != sArray[i + 1]) {
                freq = 1;
                sb.append(sArray[i]);
                continue;
            }
            //Case 2 dupe but ok
            if (freq < repeatLimit) {
                sb.append(sArray[i]);
                freq++;
                continue;
            }
            //Case 3 dupe and not okay
            while (pointer >= 0 && (sArray[pointer] == sArray[i] || pointer > i)) {
                pointer--;
            }

            if (pointer >= 0) {
                sb.append(sArray[pointer]);
                char temp = sArray[i];
                sArray[i] = sArray[pointer];
                sArray[pointer] = temp;
                freq = 1;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}