class Solution {
    int len;
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList();
        len = s.length();
        List<String> base = new ArrayList();
        for(char c: s.toCharArray()) {
            base.add(new String(new char[] {c}));
        }
        generateSubList(ans, base, 0);
        return ans;
    }
    private void generateSubList(List<List<String>> ans, List<String> base, int idx) {

        while(idx < base.size() - 1) {
            if(base.get(idx).equals(base.get(idx + 1))) {
                List<String> newBase = new ArrayList(base);
                String newEntry = newBase.remove(idx) + newBase.remove(idx);
                newBase.add(idx , newEntry);
                generateSubList(ans, newBase, idx);
            } 
            if(idx > 0 && idx < base.size() - 1 && base.get(idx - 1).equals(base.get(idx + 1))) {
                List<String> newBase = new ArrayList(base);
                String newEntry = newBase.remove(idx - 1) + newBase.remove(idx - 1) + newBase.remove(idx - 1);
                newBase.add(idx - 1, newEntry);
                generateSubList(ans, newBase, idx - 1);
            }
            idx++;
        }
        ans.add(base);
        
    }
}