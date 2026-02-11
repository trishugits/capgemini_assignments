package CapgeminiTraining.day3;
interface Comparator<T>{
    int compare(T o, T b);
}
class IntegerCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a-b;
    }
}

class StringCompare implements Comparator<String> {
    public int compare(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) - b.charAt(i);
            }
        }
        return a.length() - b.length();
    }
}

class UniCompare<T> implements Comparator<T>{
    public int compare(T a, T b){
        if (a == null && b == null) {
            return 0;
        }
        if (a instanceof Integer && b instanceof Integer) return (Integer)a - (Integer)b;
        return 0;
    }
}
public class ComparatorFunc {
    public static void main(String[] args) {
        Comparator<Integer> c = new IntegerCompare();
        System.out.println(c.compare(20,30));
        Comparator<String> c2 = new StringCompare();
        System.out.println(c2.compare("ABC", "BDC"));
    }
}
