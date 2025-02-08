// using lazy update
class NumberContainers {
    HashMap<Integer,PriorityQueue<Integer>> numToint;
    HashMap<Integer,Integer> intTonum;
    public NumberContainers() {
        numToint = new HashMap<>();
        intTonum = new HashMap<>();
    }
    
    public void change(int index, int number) {
        
        intTonum.put(index,number);
        if (!numToint.containsKey(number)){
            numToint.put(number,new PriorityQueue<>());
        }
        numToint.get(number).offer(index);
    }
    
    public int find(int number) {
        if (!numToint.containsKey(number)){
            return -1;
        }
        // PriorityQueue<Integer> pq = numToint.get(number);
        while (!numToint.get(number).isEmpty()){
            int p = numToint.get(number).peek();
            if (intTonum.get(p) == number){
                break;
            }
            else{
                numToint.get(number).poll();
            }
        }
        if ( numToint.get(number).isEmpty()){
            numToint.remove(number);
            return -1;
        }
        return numToint.get(number).peek();
    } 
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
