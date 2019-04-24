public class Ban extends UnSortedArrayList<Student> {

    private static char scoreToGrade(int aScore) {//주어진 aScore 에 해당하는 학점을 얻는다.
        if (aScore >= 90) {
            return 'A';
        } else if (aScore >= 80) {
            return 'B';
        } else if (aScore >= 70) {
            return 'C';
        } else if (aScore >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public Ban(int givenCapacity) {
        super(givenCapacity);
    } //constructor

    public Ban() {
        super();
    }

    public Student lowest() { //가장 낮은 점수를 재귀적으로 구현
        if (this.isEmpty()) {
            return null;
        } else {
            return this.lowestRecursively(0, this.size() - 1); //recursion
        }
    }

    private Student lowestRecursively(int left, int right) {
        if (left == right) { //초항
            return this.elementAt(left);
        } else {
            Student lowestFromRight = lowestRecursively(left + 1, right);
            if (lowestFromRight.compareTo(this.elementAt(left)) <= 0) {
                return lowestFromRight;
            } else {
                return this.elementAt(left);
            }
        }

    }

    //성적이 가장 낮은 학생을 얻는다.
    public Student highest() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.highestRecursively(0, this.size() - 1);
        }

    }

    private Student highestRecursively(int left, int right) {
        if (left == right) { //초항
            return this.elementAt(left);
        } else {
            Student rightFromRights = highestRecursively(left + 1, right);
            if (rightFromRights.compareTo(this.elementAt(left)) > 0) {
                return rightFromRights;
            } else {
                return this.elementAt(left);
            }
        }
    }


    public int sum() { //재귀적 구현
        if (this.isEmpty()) {
            return 0;
        } else {
            return this.sumOfScoresRecursively(0, this.size() - 1);
        }
    }

    private int sumOfScoresRecursively(int left, int right) { //반으로 나누어서 계산
        int mid = (left + right) / 2;

        if (left == right) {
            return this.elementAt(left).score();

        } else {

            int leftSum = this.sumOfScoresRecursively(left, mid);
            int rightSum = this.sumOfScoresRecursively(mid + 1, right);
            return (leftSum + rightSum);
        }
    }//학급의 학생들의 성적의 합계를 얻는다.


    public double average() {     //학급의 성적 평균 점수를 얻는다
        if (this.isEmpty()) {
            return 0;
        } else {
            return ((double) this.sum() / ((double) this.size()));
        }
    }

    public void sortByScore() {
        if (this.size() > 1) {
            int maxLoc = 0;
            for (int i = 1; i < this.size(); i++) { //?
                if (this.elementAt(i).score() > this.elementAt(maxLoc).score()) {
                    maxLoc = i;
                }
            }
            this.swap(maxLoc, this.size() - 1);
            this.quicksortRecursively(0, this.size() - 2);
        }
    }

    private void quicksortRecursively(int left, int right) {
        if (left < right) {
            int mid = this.partition(left, right - 1); //partition method를 통하여 중간 값 결정
            this.quicksortRecursively(left, mid - 1); //중간 이전
            this.quicksortRecursively(mid + 1, right); //중간 이후
        }

    }

    private int partition(int left, int right) {
        int pivot = left; //피봇 값을 정한다.
        int toRight = left;
        int toLeft = right + 1;
        do {
            do {
                toRight++;
            } while (this.elementAt(toRight).score() < this.elementAt(pivot).score()); //피봇값을 기준으로 움직인다.
            do {
                toLeft--;
            } while (this.elementAt(toLeft).score() > this.elementAt(pivot).score()); //피봇값을 기준으로 움직인다.

            if (toRight < toLeft) { //toLeft 가 크면 swap
                this.swap(toRight, toLeft);
            }
        } while (toRight < toLeft);
        this.swap(left, toLeft); //left 와 toleft swap
        return toLeft;
    }

    private void swap(int p, int q) {
        Student temp = this.elementAt(p);
        this.setElementAt(p, this.elementAt(q));
        this.setElementAt(q, temp);

    }

    //학급의 학생들을 성적 순으로 정렬한다.


    public int numberOfStudentsAboveAverage() {
        double average = this.average();
        int numberOfStudentAboveAverage = 0;

        Iterator<Student> iterator = this.iterator(); //iterator를 사용하여 구현
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.score() >= average) {
                numberOfStudentAboveAverage++;
            }
        }
        return numberOfStudentAboveAverage;
    }

    public GradeCounter countGrade() { //학생들의 수를 센다.
        // 학급의 학점별 학생수를 세게 하고, 그 결과를 가지고 있는 GradeCounter 객체를 얻는다
        GradeCounter counter = new GradeCounter();
        for (int i = 0; i < this.size(); i++) {
            char count = Ban.scoreToGrade(this.elementAt(i).score());
            counter.count(count);
        }
        return counter;
    }


}
