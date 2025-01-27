class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int len=prerequisites.length,n=queries.length;
        List<Boolean> ans=new LinkedList<>();
        HashSet<Integer>[] arr=new HashSet[numCourses];
        for(int i=0;i<numCourses;i++) arr[i]=new HashSet<Integer>();
        for(int i=0;i<len;i++){
            for(int x:arr[prerequisites[i][0]]) arr[prerequisites[i][1]].add(x);
            arr[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            HashSet<Integer> set=new HashSet<>();
            for(int x:arr[i]) for(int q:arr[x]) set.add(q);
            for(int x:set) arr[i].add(x);
        }
        for(int i=0;i<n;i++){
            if(arr[queries[i][1]].contains(queries[i][0])) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
