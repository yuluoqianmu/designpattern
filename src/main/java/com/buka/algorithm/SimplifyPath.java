package com.buka.algorithm;

import java.util.Stack;

/**
 *给定一个文档 (Unix-style) 的完全路径，请进行路径简化。

 例如，
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 边界情况:

 你是否考虑了 路径 = "/../" 的情况？
 在这种情况下，你需返回 "/" 。
 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {

        String[] names = path.split("/");

        Stack<String> stack = new Stack<>();

        for (int i=0; i<names.length; i++) {
            if (".".equals(names[i]) || "".equals(names[i]))
                continue;
            if ("..".equals(names[i])) {
                if (!stack.empty())
                    stack.pop();
            } else
                stack.push(names[i]);

        }

        StringBuilder sb = new StringBuilder();

        while(!stack.empty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        if (sb.length()==0)
            sb.append("/");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }
}
