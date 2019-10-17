package kakao;

import java.util.Stack;

public class Compile {
    public String solution(String p) {
        String v = p;
        return recrusive(v);
    }

    private String recrusive(String v) {
        String aa = "";
        String recAns = "";
        String u = "";
        int left = 0;
        int right = 0;

        for (int i = 0; i < v.length(); i++) {
            char ch = v.charAt(i);
            u += ch;
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                right++;
            }
            if (left != 0 && right == left) {
                if (!checkString(u)) {
                    aa += "(";
                    if (i + 1 < v.length()) {
                        recAns = recrusive(v.substring(i + 1));
                        aa += recAns + ")";
                        u = convertU(u);
                        aa += u;
                        return aa;
                    }
                    aa += ")";
                    u = convertU(u);
                    aa += u;
                    return aa;
                }
                if (i + 1 < v.length()) {
                    recAns = recrusive(v.substring(i + 1));
                    return u + recAns;
                }
                return u;
            }
        }
        return "";
    }

    private boolean checkString(String u) {
        Stack s = new Stack();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                s.push('(');
            } else {
                if (s.empty()) {
                    return false;
                }
                s.pop();
            }
        }
        return s.empty();
    }

    private String convertU(String u) {
        String result = "";
        u = u.substring(1, u.length() - 1);
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                result += ")";
            } else {
                result += "(";
            }
        }
        return result;
    }
}
