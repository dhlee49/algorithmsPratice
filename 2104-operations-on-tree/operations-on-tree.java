/*
    Thought Process of the solution: 
    We have a tree given as array with incrementing order.
    If we create an array of nodes (i create arraylist for conviennce but array works as size is given)
    we can use array as map (as it is ordered index)
    and use node to traverse tree for check in O(log n) instead of scan.
*/
class LockingTree {
    class Node {
        //I'd do getter setter if i had time and was live env
        Node parent;
        int user;
        boolean lockStatus;
        ArrayList<Node> children;
        public Node() {
            this.parent = null;
            this.user = -1;
            this.lockStatus = false;
            this.children = new ArrayList();
        }
    }
    ArrayList<Node> nodes;
    
    public LockingTree(int[] parent) {
        nodes = new ArrayList();
        for(int i : parent) {
            nodes.add(new Node());
        }

        for(int i = 1; i < parent.length; i++) {
            nodes.get(i).parent = nodes.get(parent[i]);
            nodes.get(i).parent.children.add(nodes.get(i));
        }
        
    }

    public boolean lock(int num, int user) {
        //Base case locked -> return false
        Node cur = nodes.get(num);
        if(cur.lockStatus) return false;

        cur.lockStatus = true;
        cur.user = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        Node cur = nodes.get(num);
        if(!cur.lockStatus) return false;
        if(cur.user == user) {
            cur.lockStatus = false;
            cur.user = -1;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        Node cur = nodes.get(num);
        
        //Check condtion 1
        if(cur.lockStatus) return false;

        //Check condition 2
        Stack<Node> curChildren = new Stack();
        for (Node child : cur.children) {
            curChildren.push(child);
        }

        //Check Condition 3
        Node parentCheck = cur;
        while(parentCheck.parent != null) {
            if(parentCheck.parent.lockStatus) return false;
            parentCheck = parentCheck.parent;
        }
        boolean lockedChildren = false;
        while(!curChildren.isEmpty()) {
            Node curChild = curChildren.pop();
            if(curChild.lockStatus) {
                lockedChildren =  true;
                curChild.lockStatus = false;
                curChild.user = -1;
            }
            for(Node child : curChild.children) {
                curChildren.push(child);
            }
        }
        if(!lockedChildren) return false;

        cur.lockStatus = true;
        cur.user = user;
        return true;
    
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */