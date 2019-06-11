import java.util.Random;

public final class DataGenerator {
    // Static class.
    // 더 이상 상속할 필요가 없으므로 "final" 로 선언
    // 생성자는 private. 따라서 외부에서 객체를 만들 수 없다.

    public static Integer[] ascendingList(int aSize) {
        Integer[] list = null; //오름 차순?
        if (aSize > 0) {
            list = new Integer[aSize];
            for (int i = 0; i < aSize; i++) {
                list[i] = i;
            }
        }
        return list;
    }

    public static Integer[] descendingList(int aSize) {
        Integer[] list = null; //내림 차순
        if (aSize > 0) {
            list = new Integer[aSize];
            for (int i = 0; i < aSize; i++) {
                list[i] = aSize - i - 1;
            }
        }
        return list;
    }

    public static Integer[] randomList(int aSize) {
        // 겹치는 원소가 없는 무작위 리스트를 생성하여, 돌려준다.
        Integer[] list = null;
        if (aSize > 0) {
            // 일단 Ascending order list 를 만든다
            list = new Integer[aSize];
            for (int i = 0; i < aSize; i++) {
                list[i] = i;
            }
            // 각 원소 list[i] 에 대해 무작위 위치 r 을 생성하여 list[i] 와 list[r] 를 맞바꾼다.
            Random random = new Random();
            for (int i = 0; i < aSize; i++) {
                int r = random.nextInt(aSize);
                Integer temp = list[i];
                list[i] = list[r];
                list[r] = temp;
            }
        }
        return list;
    }

    public static Integer[] randomListWithoutDuplication(int aSize) { // 겹치는 원소가 없는 무작위 리스트를 생성하여, 돌려준다.
        Integer[] list = null;
        if (aSize > 0) { // 일단 Ascending order list 를 만든다
            list = DataGenerator.ascendingList(aSize);
            // 각 원소 list[i] 에 대해 무작위 위치 r 을 생성하여 list[i] 와 list[r] 를 맞바꾼다.
            Random random = new Random();
            for (int i = 0; i < aSize; i++) {
                int randomIndex = random.nextInt(aSize);
                Integer temp = list[i];
                list[i] = list[randomIndex];
                list[randomIndex] = temp;
            }
        }
        return list;
    }
}
