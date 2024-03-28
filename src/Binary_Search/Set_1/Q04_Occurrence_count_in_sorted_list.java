package Binary_Search.Set_1;

//find first Index & last index of occurrence :=> lastIndex-firstIndex = count;
public class Q04_Occurrence_count_in_sorted_list {
      //brute force solution
      public static int brute_force_approach(int[] array, int value){
            int count = 0;
            for(int num : array){
                  if(num == value){
                        count += 1;
                  }
            }
            return count;
      }

      //optimise solution
      public static int binary_search_approach(int[] array,int value){

            int firstIndex = get_firstIndex(array, value);
            int lastIndex = get_lastIndex(array, value);
            return lastIndex - firstIndex + 1;

      }
//      function to get first Index
      public static int get_firstIndex(int[] array, int value){
            int start = 0;
            int end = array.length-1;
            while(start <= end){
                  int mid = start + (end-start) / 2;
                  if(mid == 0 && array[mid] == value) return mid;
                  if(mid != 0 && array[mid] == value && array[mid-1] != value){
                        return mid;
                  }
                  if(array[mid] < value){
                        start = mid + 1;
                  }else{
                        end = mid - 1;
                  }
            }
            return -1;
      }
//      function to get last Index
      public static int get_lastIndex(int[] array, int value){
            int start = 0;
            int end = array.length-1;
            if(array[end] == value) return end;
            while(start<= end){
                  int mid = start + (end - start) / 2;
                  if(mid != array.length-1 && array[mid] == value && array[mid+1] != value){
                        return mid;
                  }
                  if(array[mid] <= value){
                        start = mid + 1;
                  }else{
                        end = mid - 1;
                  }
            }
            return -1;
      }

      public static void main(String[] args){
            int[] array = { 1,2,3,4,5,6,7,7,7,7,7,8,8,9,10};
            System.out.println(binary_search_approach (array , 7));

      }
}
