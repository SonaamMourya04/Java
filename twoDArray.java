public class twoDArray {
    public static void main(String a[]){
        int nums[][]=new int [3][4];//3 rows 4 column


        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                nums[i][j]=(int)(Math.random()*10);
                System.out.println(nums[i][j]);
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
              System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();


        
        // Outer loop pulls out a 1D integer array (a row)
        for(int n[]:nums){
                // Inner loop pulls out a single integer from that row
            for(int m:n){
                System.out.println(m + " ");
            }
            System.out.println();// Moves to next line after row finishes
        }
    }
    
}
