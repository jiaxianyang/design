package com.example.design.base;

import java.util.ArrayList;
import java.util.List;

public class FormatClass {
    public List<String> generateParenthesis(int n) {
        //递归
        List<String> result = new ArrayList<>();
        // 从第一层开始
        generate(0, 0, n, "", result);
        return result;
    }

    /**
     * 解题思路：我们想象成有很多格子，我们往里面放入左右括号，如果想要最终满足结果，那么要同事符合以下规则：
     * 1. 我们在组装结果的时候，放入的右边的括号数量不能大于左边，如果大于那么就会组装成无用的结果 所以（right < left）
     * 2. 我们放入的左括号数量不能大于n,如果大于n，最终组装的结果也是不满足的
     * 3. 当左括号数量和右括号数量相当并且都等于n的时候，为我们想要的结果
     *
     * @param left   左括号数量
     * @param right  有括号数量
     * @param max    n
     * @param str    字符串
     * @param result 结果集
     */
    private void generate(int left, int right, int max, String str, List<String> result) {
        if (left == max && right == max) {
            result.add(str);
            return;
        }
        if (left < max) {
            generate(left + 1, right, max, str + "(", result);
        }
        if (right < left) {
            generate(left, right + 1, max, str + ")", result);
        }
    }
}
