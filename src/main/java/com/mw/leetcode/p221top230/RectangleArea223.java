package com.mw.leetcode.p221top230;

public class RectangleArea223
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        // Rectangles don't overlap.
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        // if they are overlap?
        if (A >= G || E >= C || B >= H || F >= D)
            return area1 + area2;

        // Overlap.
        int width = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        return area1 + area2 - width * height;
    }
}
