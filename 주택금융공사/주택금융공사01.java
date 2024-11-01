package etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    1.
    명령어 따라 수행한 뒤 출력되는 숫자들과 에러 발생 수를 배열로 리턴
    명령어는 입력 순서대로 실행되며 에러 발생 시 다음 명령어 수행함

    매개변수: String[] codes
    명령어 설명: 변수명은 영문으로 이루어져 있음

    - declare [변수명] [숫자]
        : [변수명]을 가진 변수 생성되고 그 값은 [숫자]
        : 이미 [변수명]이 존재한다면 error 발생

    - update [변수명] [숫자]
        : [변수명]의 값을 [숫자]로 변경
        : [변수명]이 선언되어있지 않으면 error 발생

    - update [변수명1] [변수명2]
        : [변수명1]의 값을 [변수명2]가 가진 값으로 변경
        : [변수명1]이나 [변수명2]가 없을 시 error 발생

    - print [변수명]
        : [변수명]이 가진 값을 출력
        : [변수명]이 선언되어있지 않으면 error 발생
 */
public class 주택금융공사01 {
    public ArrayList<Integer> solution(String[] codes) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int error = 0;
        for (String code : codes) {
            StringTokenizer st = new StringTokenizer(code);
            switch (st.nextToken()) {
                case "declare":
                    String key = st.nextToken();
                    if (map.containsKey(key)) {
                        error++;
                        break;
                    }
                    map.put(key, Integer.parseInt(st.nextToken()));
                    break;
                case "update":
                    key = st.nextToken();
                    if (!map.containsKey(key)) {
                        error++;
                        break;
                    }
                    String param = st.nextToken();
                    if (Character.isDigit(param.charAt(0))) {
                        map.put(key, Integer.parseInt(param));
                    } else {
                        if (!map.containsKey(param)) {
                            error++;
                            break;
                        }
                        map.put(key, map.get(param));
                    }
                    break;
                case "print":
                    key = st.nextToken();
                    if (!map.containsKey(key)) {
                        error++;
                        break;
                    }
                    answer.add(map.get(key));
                    break;
            }
        }
        answer.add(error);
        return answer;
    }

    public static void main(String[] args) {
        String[] codes = {"declare param 7517", "declare param 19499", "declare abc 199", "print param", "update param 36399", "print param", "update param abc", "print param", "print abcd"};
        // return [7517, 36399, 199, 2]
        System.out.println(new 주택금융공사01().solution(codes));
    }
}
