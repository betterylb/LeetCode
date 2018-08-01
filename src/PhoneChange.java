import java.util.*;

public class PhoneChange {
    public static void solution(int n, int k, int[] phoneNums){
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                }
        );



        for(int i=0; i<n; i++){
            if(map.containsKey(phoneNums[i])){
                map.replace(phoneNums[i], map.get(phoneNums[i])+1);
            }
            else {
                map.put(phoneNums[i], 1);
            }
        }

        Collection<Integer> a = map.values();
        Arrays.sort(a.toArray());
        System.out.println(map.get(7));
    }

    public static void main(String[] args){
        int[] a = {1,5,0,0,8,4,2,1,9,0,1};
        solution(6, 3,a);
    }
}
