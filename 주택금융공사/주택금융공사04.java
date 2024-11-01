package etc;

/*
    4. 기지국 커버 넓이를 몬테카를로 방식으로 구하려고 한다.
    (기지국 중앙으로부터 반지름 r만큼의 원모양의 영역 생성됨)
    매개변수 int[] x, int[] y, int[] r은 같은 인덱스를 가진 기지국의 x좌표, y좌표, r좌표이다.

        1) 기지국 모든 위치를 커버하는 가장 작은 직사각형을 찾는다.
           이때, 직사각형의 왼쪽 변을 l, 오른쪽 변을 r, 위쪽 변을 t, 아래쪽 변을 b라고 한다.
        2) 난수 2개를 사용해서 직사각형 안에 있는 좌표로 변환을 한다.
           입력된 v배열에서 차례로 2개씩 점을 받아  각각 x, y라고 한다면
           내부 좌표로 변환하는 방법은 (l + x % (r - l), b + y % (t - b))이다.
        3) 2번의 좌표가 기지국 안에 있는지 확인한다.
        4) (기지국 영역 안에 있는 좌표 / 2번의 모든 좌표) = k라고 할 때, 기지국의 영역은 k * (r - l) * (t - b)로 계산한다.

    기지국의 영역을 소수점을 버린 뒤 출력
 */
public class 주택금융공사04 {
    public int solution(int[] x, int[] y, int[] r, int[] v) {
        int length = x.length, L = length, R = 0, T = 0, B = length;
        float included = 0;

        // 가장 작은 직사각형 찾기
        for (int i = 0; i < length; i++) {
            L = Math.min(L, x[i] - r[i]);
            R = Math.max(R, x[i] + r[i]);
            T = Math.max(T, y[i] + r[i]);
            B = Math.min(B, y[i] - r[i]);
        }

        for (int i = 0; i < v.length; i += 2) {
            // 내부 좌표 변환
            int X = L + v[i] % (R - L);
            int Y = B + v[i + 1] % (T - B);
            // 기지국 내에 좌표가 위치하는지 확인
            for (int j = 0; j < length; j++) {
                if (Math.pow(r[j], 2) >= Math.pow(Math.abs(X - x[j]), 2) + Math.pow(Math.abs(Y - y[j]), 2)) {
                    included++;
                    break;
                }
            }
        }
        return (int) ((included / (v.length / 2)) * (R - L) * (T - B));
    }

    public static void main(String[] args) {
//        int[] x = {5};
//        int[] y = {5};
//        int[] r = {5};
//        int[] v = {92, 83, 14, 45, 66, 37, 28, 9, 10, 81};
        // return 80

        int[] x = {3, 4};
        int[] y = {3, 5};
        int[] r = {2, 3};
        int[] v = {12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15};
//        return 28

        System.out.println(new 주택금융공사04().solution(x, y, r, v));
    }
}
