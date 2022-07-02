//미완성 코드.. 시간되면 다시 해보겠습니다.
/*DP
* 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
* 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다
* 마지막 도착 계단은 반드시 밟아야 한다.
*/
/*num = 6
10  20  15  25  10  20
0   1   2   3   4   5(필)
=====================
0   1   X   3   X   5
0   X   2   3   X   5
0   X   2   X   4   5
X   1   2   x   4   5
x   1   x   3   x   5
*/
/*num = 5
0   1   2   3   4(필)
=====================
0   1   X   3   4
0   X   2   X   4
X   1   2   x   4
X   1   X   3   4
*/
/*num = 4
0   1   2   3(필)
=====================
0   1   X   3
0   X   2   3
X   1   X   3
*/
/*마지막 계단이 필수(20) -> 10, 25중 택 -> (25)-> 15, 20 중 택 -> (20) -> 10, 0 중 택 => (10)
...
????
그냥 모든 경우의수 다 보기..
그동안 오른 계단 수, 연속될 경우, 못뽑게,
마지막꼭 해야하는데 연속되면 안되는경우다.

import java.util.*;

public class baekjoon_2579 {
    public static void main(String[] args) {
        int num, i, j, maxScore;
        ArrayList<Integer> stairs = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> DP = new ArrayList<ArrayList<Integer>>();
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        for (i = 0; i < num; i++){
            stairs.add(i, sc.nextInt());
        }

        for (j = 0; j < num-1; j++){
            ArrayList<Integer> miniDP = new ArrayList<>();
            DP.add(j, up(num, 0,0, num, miniDP, stairs));
            for (i = 0; i < num; i++){
                DP.get(j).add(i,miniDP );
            }
        }
    }

    public static ArrayList<Integer> up(int num, int count, int sum, int last, ArrayList<Integer> dp, ArrayList<Integer> stairs){
        if (num == last){
            return dp;
        }
        else if (count == 3){
            num++;
            count = 0;
        }
        for (int i = 0; i < last; i++) {

            sum += stairs.get(num);
            dp.add(num++);
            return up(num, ++count, sum, last, dp, stairs);
        }
    }
}*/
