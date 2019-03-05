package com.buka.nlp;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

 你可以对一个单词进行如下三种操作：

 插入一个字符
 删除一个字符
 替换一个字符
 示例 1:

 输入: word1 = "horse", word2 = "ros"
 输出: 3
 解释:
 horse -> rorse (将 'h' 替换为 'r')
 rorse -> rose (删除 'r')
 rose -> ros (删除 'e')
 示例 2:

 输入: word1 = "intention", word2 = "execution"
 输出: 5
 解释:
 intention -> inention (删除 't')
 inention -> enention (将 'i' 替换为 'e')
 enention -> exention (将 'n' 替换为 'x')
 exention -> exection (将 'n' 替换为 'c')
 exection -> execution (插入 'u')
 */
public class EditDistanceProblem {
    public int editDistanceDP(String s1, String s2) {
        int [][] solution = new int[s1.length()+1][s2.length()+1];

        //base case
        //If any of the string if empty then number of operations
        //needed would be equal to the length of other string
        //(Either all characters will be removed or inserted)
        for (int i = 0; i <=s2.length(); i++) {//all elements will be inserted
        solution[0][i] =i;
        }

        for (int i = 0; i <=s1.length(); i++) {//all elements will be removed
        solution[i][0] =i;
        }

        //solving it bottom-up manner
        int m = s1.length();
        int n = s2.length();
        for (int i = 1; i <=m ; i++) {
        for (int j = 1; j <=n ; j++) {
        //If last characters are matching, ignore the last character
        // then the solution will be same as without the last character.
        if(s1.charAt(i-1)==s2.charAt(j-1))
        solution[i][j] = solution[i-1][j-1];
        else
        solution[i][j] = 1 +    Math.min(solution[i][j-1], //Insert
        Math.min(solution[i-1][j], // Remove
        solution[i-1][j-1])); //Replace
        }
        }
        return solution[s1.length()][s2.length()];
        }
    public static void main(String[] args) {
        String s1 = "horizon";
        String s2 = "horizontal";
        EditDistanceProblem ed = new EditDistanceProblem();
        System.out.println("Minimum Edit Distance -(DP): " + ed.editDistanceDP(s1, s2));
        }
        }
