import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Point a = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point b = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point c = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point d = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(intersect(a, b, c, d) ? 1 : 0);
    }

    static long ccw(Point a, Point b, Point c) {
        long v = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (v > 0) return 1;
        if (v < 0) return -1;
        return 0;
    }

    static boolean onSegment(Point a, Point b, Point p) {
        return Math.min(a.x, b.x) <= p.x && p.x <= Math.max(a.x, b.x)
                && Math.min(a.y, b.y) <= p.y && p.y <= Math.max(a.y, b.y);
    }

    static boolean intersect(Point a, Point b, Point c, Point d) {
        long ab1 = ccw(a, b, c);
        long ab2 = ccw(a, b, d);
        long cd1 = ccw(c, d, a);
        long cd2 = ccw(c, d, b);

        if (ab1 * ab2 < 0 && cd1 * cd2 < 0) return true; // 일반 교차

        // 공선 처리
        if (ab1 == 0 && onSegment(a, b, c)) return true;
        if (ab2 == 0 && onSegment(a, b, d)) return true;
        if (cd1 == 0 && onSegment(c, d, a)) return true;
        if (cd2 == 0 && onSegment(c, d, b)) return true;

        return false;
    }
}