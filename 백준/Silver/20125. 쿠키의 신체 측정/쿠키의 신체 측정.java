import java.io.*;

public class Main {
    static char[][] a;
    static int x, y, lArm, rArm, lLeg, rLeg, waist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        a = new char[N+1][N+1];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= N; j++){
                a[i][j] = str.charAt(j-1);
            }
        }

        Outer: for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(a[i][j] == '*'){
                    if(i == 1 || i == N || j == 1 || j == N) continue;
                    if(a[i-1][j] == '*' && a[i+1][j] == '*' && a[i][j-1] == '*' && a[i][j+1] == '*'){
                        x = i; y = j;
                        break Outer;
                    }
                }
            }
        }

        int nx = x, ny = y, count = 0;
        while(true){
            ny--;
            if(ny < 1 || ny > N || a[nx][ny] == '_'){
                lArm = count;
                break;
            }
            count++;
        }

        nx = x; ny = y; count = 0;
        while(true){
            ny++;
            if(ny < 1 || ny > N || a[nx][ny] == '_'){
                rArm = count;
                break;
            }
            count++;
        }

        nx = x; ny = y; count = 0;
        while(true){
            nx++;
            if(nx < 1 || nx > N || a[nx][ny] == '_'){
                waist = count;
                break;
            }
            count++;
        }
        int nnx = nx-1, nny = ny-1;
        count = 0;
        while(true){
            nnx++;
            if(nnx < 1 || nnx > N || nny < 1 || nny > N || a[nnx][nny] == '_'){
                lLeg = count;
                break;
            }
            count++;
        }

        nnx = nx-1; nny = ny+1;
        count = 0;
        while(true){
            nnx++;
            if(nnx < 1 || nnx > N || nny < 1 || nny > N || a[nnx][nny] == '_'){
                rLeg = count;
                break;
            }
            count++;
        }

        System.out.println(x + " " + y);
        System.out.println(lArm + " " + rArm + " " + waist + " " + lLeg + " " + rLeg);
    }
}