public class Stringuffer {
    public static void main(String a[]){
        StringBuffer sb =new StringBuffer("hello");
        System.out.println(sb.capacity());//capacity is 21
        System.out.println(sb.length());//length is 4 
    //length and capacity both are different things
     sb.append(" guys");
    System.out.println(sb);
    //delete
     sb.deleteCharAt(8);
     System.out.println(sb);
     //insert
     sb.insert(0,"java");
     System.out.println(sb);
    
    }
    
}
