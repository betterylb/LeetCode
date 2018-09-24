import java.util.*;

/**
 * 字符串输入一个数学表达式，计算结果
 * 现将中缀表达式转换成后缀表达式，再用栈实现后缀表达式的计算
 */

public class Calculater {
    private String[] transfer2PostExpr(String[] expr){
        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("+", 1);
        priorities.put("-", 1);
        priorities.put("*", 2);
        priorities.put("/", 2);
        priorities.put("(", 0);

        Stack<String> symboll = new Stack<>();
        List<String> posExpr = new ArrayList<>();
        for (String s:expr){
            if (s.equals("(")){
                symboll.push(s);
            }
            else if (s.equals(")")){
                while (!symboll.peek().equals("(")){
                    posExpr.add(symboll.pop());
                }
                symboll.pop();
            }
            else if (s.equals("+") || s.equals("-")
                    || s.equals("*") || s.equals("/")){
                while (!symboll.isEmpty()
                        && priorities.get(symboll.peek()) >= priorities.get(s)){
                    posExpr.add(symboll.pop());
                }
                symboll.push(s);
            }
            else {
                posExpr.add(s);
            }
        }

        while (!symboll.isEmpty()){
            posExpr.add(symboll.pop());
        }
        return posExpr.toArray(new String[0]);
    }

    public int evalRPN(String[] tokens){
        Stack<Integer> number = new Stack<>();
        int a, b;
        for(String token:tokens){
            switch (token){
                case "+":
                    a = number.pop();
                    b = number.pop();
                    number.push(a+b);
                    break;
                case "-":
                    a = number.pop();
                    b = number.pop();
                    number.push(b-a);
                    break;
                case "*":
                    a = number.pop();
                    b = number.pop();
                    number.push(a*b);
                    break;
                case "/":
                    a = number.pop();
                    b = number.pop();
                    number.push(b/a);
                    break;
                default:
                    number.push(Integer.parseInt(token));
            }
        }
        return number.pop();
    }

    public static void main(String[] args){
        String str = "a+b*c+(d*e+f)*g/h";
//        List<String> expr= new ArrayList<>(Arrays.asList(str.split("")));
        Calculater c= new Calculater();
        System.out.println(Arrays.asList(c.transfer2PostExpr(str.split(""))));
    }

}
