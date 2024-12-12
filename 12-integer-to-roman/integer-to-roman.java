class Solution {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int digit = 1000;
        while(digit >= 1) {
            int curr = num / digit;
            if(curr != 0) {
                if(digit == 1000) {
                    for(int i = 0; i < curr; i++) sb.append("M");
                } else {
                    char half, one, full;
                    if(digit == 100) {
                        half = 'D';
                        one = 'C';
                        full = 'M';
                    } else if(digit == 10) {
                        half = 'L';
                        one = 'X';
                        full = 'C';
                    } else {
                        half = 'V';
                        one = 'I';
                        full = 'X';
                    }
                    if(curr == 4) {
                        sb.append(one);
                        sb.append(half);
                    } else if(curr == 9) {
                        sb.append(one);
                        sb.append(full);
                    } else {
                        if(curr >= 5) {
                            curr -= 5;
                            sb.append(half);
                        }
                        for(int i = 0; i < curr; i++) {
                            sb.append(one);
                        }
                    }
                }
            }
            num = num % digit;
            digit /= 10;
        }
        return sb.toString();
    }
}