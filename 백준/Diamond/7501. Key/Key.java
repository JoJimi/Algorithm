import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static long A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        List<Long> answers = new ArrayList<>();

        long start = (A % 2 == 0) ? A + 1 : A;
        for (long K = start; K <= B; K += 2) {
            if (!isDivisibleFactorialBySquare(K)) {
                answers.add(K);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answers.size(); i++) {
            sb.append(answers.get(i));
            if (i < answers.size() - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    static boolean isDivisibleFactorialBySquare(long K) {
        if (K <= 1) return false;
        Map<Long, Integer> factorMap = factorize(K);

        for (Map.Entry<Long, Integer> entry : factorMap.entrySet()) {
            long prime = entry.getKey();
            long exponentInK = entry.getValue();

            long expInFactorial = factorialExponent(K - 1, prime);
            long needed = 2 * exponentInK;

            if (expInFactorial < needed) {
                return false;
            }
        }
        return true;
    }

    static long factorialExponent(long n, long p) {
        long count = 0;
        while (n > 0) {
            n /= p;
            count += n;
        }
        return count;
    }

    static Map<Long, Integer> factorize(long n) {
        Map<Long, Integer> factorMap = new HashMap<>();
        if (n <= 1) return factorMap;
        List<Long> factorList = pollardRhoAllFactors(n);

        for (long f : factorList) {
            factorMap.put(f, factorMap.getOrDefault(f, 0) + 1);
        }
        return factorMap;
    }

    static List<Long> pollardRhoAllFactors(long n) {
        List<Long> res = new ArrayList<>();
        if (n <= 1) return res;
        if (isPrime(n)) {
            res.add(n);
        } else {
            long divisor = pollardRho(n);
            res.addAll(pollardRhoAllFactors(divisor));
            res.addAll(pollardRhoAllFactors(n / divisor));
        }
        return res;
    }

    static boolean isPrime(long n) {
        if (n < 2) return false;
        long[] smallPrimes = {2,3,5,7,11,13,17,19,23,29};
        for (long sp: smallPrimes) {
            if (n == sp) return true;
            if (n % sp == 0 && n != sp) return false;
        }
        return millerRabinTest(n);
    }

    static boolean millerRabinTest(long n) {
        long d = n - 1;
        int r = 0;
        while ((d & 1) == 0) {
            d >>= 1;
            r++;
        }

        long[] testBases = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (long a: testBases) {
            if (a == 0 || a == 1 || a == n) continue;
            if (!checkComposite(n, a, d, r)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkComposite(long n, long a, long d, int r) {
        long x = powMod(a, d, n);
        if (x == 1 || x == n - 1) return true;
        for (int i = 1; i < r; i++) {
            x = mulMod(x, x, n);
            if (x == n - 1) return true;
        }
        return false;
    }

    static long pollardRho(long n) {
        Random rand = new Random();
        while (true) {
            long x = Math.abs(rand.nextLong()) % (n-2) + 2;
            long y = x;
            long c = Math.abs(rand.nextLong()) % (n-1) + 1;
            long d = 1;
            while (d == 1) {
                x = f(x, c, n);
                y = f(f(y, c, n), c, n);
                d = gcd(Math.abs(x - y), n);
                if (d == n) break; // 실패 -> 재시도
            }
            if (d > 1 && d < n) return d;
        }
    }

    static long f(long x, long c, long n) {
        long xsq = mulMod(x, x, n);
        xsq = (xsq + c) % n;
        return xsq;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long mulMod(long a, long b, long m) {
        BigInteger mul = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));
        return mul.mod(BigInteger.valueOf(m)).longValue();
    }

    static long powMod(long base, long exp, long m) {
        long result = 1 % m;
        long cur = base % m;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = mulMod(result, cur, m);
            cur = mulMod(cur, cur, m);
            exp >>= 1;
        }
        return result;
    }
}
