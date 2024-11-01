package etc;

/*
    2. n개의 숫자배열이 주어질 때, 각 i번째 비트를 더한 숫자를 반환
 */
public class 주택금융공사02 {
    public int solution(int[] numbers) {
        int answer = 0;
        int pow = 0;
        for (int number : numbers) {
            answer += (number & (int) Math.pow(2, pow++));
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 27, 9, 0, 31};
        // return 19
//        int[] numbers = {1, 2, 5, 8};
        // return 15
//        int[] numbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        // return 0
        System.out.println(new 주택금융공사02().solution(numbers));
    }
}
