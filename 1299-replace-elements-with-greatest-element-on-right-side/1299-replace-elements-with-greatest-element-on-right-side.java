class Solution {
    public int[] replaceElements(int[] arr) {
            int size = arr.length;
            int last = arr[size-1];
                    if(size==1) return new int[]{-1};
            if(size==2){
                    arr[0] = arr[1];
                    arr[1] = -1;
                    return arr;
            }
            int secLast = arr[size-2];
        for(int i = size-3; i>=0; i--){
                int temp = last;
                int temp2 = arr[i];
               arr[i] = Math.max(last,secLast);
                last = temp2;
                secLast = arr[i];
        }
            arr[size-2] = arr[size-1];
            arr[size-1] = -1;
                                      return arr;
    }
}