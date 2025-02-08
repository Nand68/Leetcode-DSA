class NumberContainers {

  Map<Integer ,Integer> map=new HashMap<>();
   Map<Integer ,TreeSet<Integer>> map2=new HashMap<>();
    public NumberContainers() {
        int index;
        int number;
      

        
    }
    
    public void change(int index, int number) {
        if(map.containsKey(index)){
            int old=map.get(index);
           TreeSet<Integer> set= map2.get(old);
           set.remove(index);
           map2.put(old , set);

        }
        map.put(index , number);
         TreeSet<Integer> set = map2.getOrDefault(number, new TreeSet<>());
           set.add(index);
           map2.put(number, set);
    }
    
    public int find(int number) {
      TreeSet<Integer> set= map2.getOrDefault(number , new TreeSet<>());
      if(!set.isEmpty()) {
      if(map.containsKey(set.first())){
            return set.first();
      }
      }
      return -1;
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
