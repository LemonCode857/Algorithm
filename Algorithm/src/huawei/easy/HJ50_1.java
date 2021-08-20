package huawei.easy;

import java.util.*;
public class HJ50_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            // 数字栈：用来存储数字
            Stack<Integer> stack1 = new Stack<Integer>();
            // 运算符栈：用来存储运算符
            Stack<Character> stack2 = new Stack<Character>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // 读取到的字符为数字，则进数字栈
                if (Character.isDigit(c)) {
                    // 考虑数字大于10的情况
                    if (i > 0 && Character.isDigit(str.charAt(i - 1))) {
                        stack1.push(stack1.pop() * 10 + (c - '0'));
                    } else {
                        //stack1.push(c - 48);  和下一句等效，为了数据类型转换
                        stack1.push(c - '0');
                    }
                } else {
                    // 读取到的字符非数字，进行过滤，进运算符栈
                    if (c == ')') {
                        // 新建一个栈存储本次小括号内的结果
                        Stack<Integer> stack = new Stack<Integer>();
                        // 新建一个栈存储小括号中的运算符
                        Stack<Character> option = new Stack<Character>();
                        int count = 0;
                        int m = stack1.pop();
                        char o = stack2.pop();
                        while (o != '(') {
                            // 对于乘除，需要计算结果
                            if (o == '*' || o == '/') {
                                int a = stack1.pop();
                                if (o == '*') {
                                    stack1.push(a * m);
                                } else {
                                    stack1.push(a / m);
                                }
                                // 对于加减，不需要计算结果
                            } else if (o == '+' || o == '-') {
                                stack.push(m);
                                option.push(o);
                            }
                            m = stack1.pop();
                            o = stack2.pop();
                        }
                        count += m;
                        // 上面处理完后，再计算剩下的操作（加减）
                        while (!option.empty()) {
                            char op = option.pop();
                            if (op == '+') {
                                count += stack.pop();
                            } else if (op == '-') {
                                count -= stack.pop();
                            }
                        }
                        stack1.push(count);
                    } else if (c == ']') {
                        Stack<Integer> stack = new Stack<Integer>();
                        Stack<Character> option = new Stack<Character>();
                        int count = 0;
                        int m = stack1.pop();
                        char o = stack2.pop();
                        while (o != '[') {
                            if (o == '*' || o == '/') {
                                int a = stack1.pop();
                                if (o == '*') {
                                    stack1.push(a * m);
                                } else {
                                    stack1.push(a / m);
                                }
                            } else if (o == '+' || o == '-') {
                                stack.push(m);
                                option.push(o);
                            }
                            m = stack1.pop();
                            o = stack2.pop();
                        }
                        count += m;
                        while (!option.empty()) {
                            char op = option.pop();
                            if (op == '+') {
                                count += stack.pop();
                            } else if (op == '-') {
                                count -= stack.pop();
                            }
                        }
                        stack1.push(count);
                    } else if (c == '}') {
                        Stack<Integer> stack = new Stack<Integer>();
                        Stack<Character> option = new Stack<Character>();
                        int count = 0;
                        int m = stack1.pop();
                        char o = stack2.pop();
                        while (o != '{') {
                            if (o == '*' || o == '/') {
                                int a = stack1.pop();
                                if (o == '*') {
                                    stack1.push(a * m);
                                } else {
                                    stack1.push(a / m);
                                }
                            } else if (o == '+' || o == '-') {
                                stack.push(m);
                                option.push(o);
                            }
                            m = stack1.pop();
                            o = stack2.pop();
                        }
                        count += m;
                        while (!option.empty()) {
                            char op = option.pop();
                            if (op == '+') {
                                count += stack.pop();
                            } else if (op == '-') {
                                count -= stack.pop();
                            }
                        }
                        stack1.push(count);
                    } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                        if (i == 0 || (!Character.isDigit(str.charAt(i - 1)) && str.charAt(i - 1) != ')' && str.charAt(i - 1) != ']' && str.charAt(i - 1) != '}')) { // 考虑省略0的情况
                            stack1.push(0);
                        }
                        stack2.push(c);
                    } else {
                        stack2.push(c);
                    }
                }
            }
            if (!stack2.empty()) { // 有可能还未运算结束
                Stack<Integer> stack = new Stack<Integer>();
                Stack<Character> option = new Stack<Character>();
                int count = 0;
                int m = stack1.pop();
                char o = stack2.pop();
                while (!stack1.empty()) {
                    if (o == '*' || o == '/') {
                        int a = stack1.pop();
                        if (o == '*') {
                            stack1.push(a * m);
                        } else {
                            stack1.push(a / m);
                        }
                    } else if (o == '+' || o == '-') {
                        stack.push(m);
                        option.push(o);
                    }
                    m = stack1.pop();
                    if (stack2.empty()) {
                        break;
                    } else {
                        o = stack2.pop();
                    }
                }
                count += m;
                do {
                    char op = option.pop();
                    if (op == '+') {
                        count += stack.pop();
                    } else if (op == '-') {
                        count -= stack.pop();
                    }
                } while (!option.empty());
                System.out.println(count);
            } else {
                System.out.println(stack1.pop());
            }
        }
    }
}