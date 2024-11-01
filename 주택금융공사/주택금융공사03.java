package etc;

/*
    3. 주어지는 매개변수 int배열 query의 인덱스는 카테고리 종류, 값은 요청할 정보의 수이다.
    정보를 요청할 때, 다음의 조건을 따라야 함

    1. 하나의 요청을 할 때는 하나의 카테고리만 가능
    2. 동시에 여러번 요청할 수 있음
    3. 한번에 최대 x개의 정보만 요청할 수 있음
    4. n시간동안 최대 k번 요청할 수 있음 (k번까지 요청 보낸 뒤 n시간 휴식)

    위의 조건을 따르면서 모든 정보를 얻을 수 있는 최소 시간 구함
 */
public class 주택금융공사03 {
    public int solution(int[] query, int n, int k, int x) {
        int answer;
        int count = 0;
        for (int q : query) {
            count += (q + x - 1) / x;
        }
        answer = (count + k - 1) / k - 1;
        answer *= (n + 1);
        return answer;
    }

    public static void main(String[] args) {
        int[] query = {1, 3, 2};
        int n = 3;
        int k = 1;
        int x = 1;
        // return 20

//        int[] query = {8, 5, 2};
//        int n = 4;
//        int k = 2;
//        int x = 2;
        // return 15

//        int[] query = {1, 2, 3, 4};
//        int n = 100;
//        int k = 4;
//        int x = 4;
        // return 0

//        int[] query = {1, 2, 3, 4};
//        int n = 100;
//        int k = 4;
//        int x = 3;
        // return 101
        System.out.println(new 주택금융공사03().solution(query, n, k, x));
    }
}
