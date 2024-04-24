package OA;

public class Q_19_Compress_String {


    public static String compressString(String str){


        char ch = str.charAt(0);
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) != ch){
                sb.append(count);
                sb.append(ch);
                count = 0;
                ch = str.charAt(i);
            }
            count += 1;
        }
        sb.append(count);
        sb.append(ch);
        return sb.toString();
    }



    public static void main(String[] args) {
        String s = "aaabbbccdfg";
        String result = compressString(s);
        System.out.println("Result : "+ result);
    }
}
