public class Ban extends DictionarybyBinarySearchTree<String, Student> {


    public Ban() {
        super();
    }

    public static char scoreToGrade(int aScore) {//주어진 aScore 에 해당하는 학점을 얻는다.
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

    public Student lowest() { //가장 낮은 점수를 재귀적으로 구현
        if (this.isEmpty()) {
            return null;
        } else {
            DictionaryElement<String, Student> lowest = this.lowestRecursively(this.root());
            return lowest.object();
        }
    }

    private DictionaryElement<String, Student> lowestRecursively(BinaryNode<DictionaryElement<String, Student>> aRoot) {
        DictionaryElement<String, Student> lowest = aRoot.element();
        if (aRoot.left() != null) {
            DictionaryElement<String, Student> lowestOfLeftSubtree = this.lowestRecursively(aRoot.left());
            if (lowestOfLeftSubtree.object().score() < lowest.object().score()) {
                lowest = lowestOfLeftSubtree;
            }
        }
        if (aRoot.right() != null) {
            DictionaryElement<String, Student> lowestOfRightSubtree = this.lowestRecursively(aRoot.right());
            if (lowestOfRightSubtree.object().score() < lowest.object().score()) {
                lowest = lowestOfRightSubtree;
            }
        }
        return lowest;

    }

    //성적이 가장 높은 학생을 얻는다.
    public Student highest() {
        if (this.isEmpty()) {
            return null;
        } else {
            DictionaryElement<String, Student> highest = this.highestRecursively(this.root());
            return highest.object();
        }

    }

    private DictionaryElement<String, Student> highestRecursively(BinaryNode<DictionaryElement<String, Student>> aRoot) {
        DictionaryElement<String, Student> highest = aRoot.element();
        if (aRoot.left() != null) {
            DictionaryElement<String, Student> highestOfLeftSubtree = this.lowestRecursively(aRoot.left());
            if (highestOfLeftSubtree.object().score() >= highest.object().score()) {
                highest = highestOfLeftSubtree;
            }
        }
        if (aRoot.right() != null) {
            DictionaryElement<String, Student> highestOfRightSubtree = this.lowestRecursively(aRoot.right());
            if (highestOfRightSubtree.object().score() >= highest.object().score()) {
                highest = highestOfRightSubtree;
            }
        }
        return highest;

    }


    private int sumOfScores() { //재귀적 구현
        return this.sumOfScoresRecursively(this.root());
    }

    private int sumOfScoresRecursively(BinaryNode<DictionaryElement<String, Student>> aRoot) { //todo
        DictionaryElement<String, Student> sum = aRoot.element();
        int totalSum = sum.object().score();
        if (aRoot.left() != null) {
            DictionaryElement<String, Student> sumOfLeftSubtree = this.lowestRecursively(aRoot.left());
            if (sumOfLeftSubtree.object().score() > sum.object().score()) {
                totalSum += sumOfLeftSubtree.object().score();
            }
        }
        if (aRoot.right() != null) {
            DictionaryElement<String, Student> sumOfRightSubtree = this.lowestRecursively(aRoot.right());
            if (sumOfRightSubtree.object().score() > sum.object().score()) {
                totalSum += sumOfRightSubtree.object().score();
            }
        }
        return totalSum;
    }


    public double average() {     //학급의 성적 평균 점수를 얻는다
        if (this.isEmpty()) {
            return 0;
        } else {
            return (int) (((double) this.sumOfScores()) / ((double) this.size())); // Why type casting? }
        }
    }

    public Student[] studentSortedByScore() {
        Student[] students = new Student[this.size()];
        Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            students[i] = iterator.next().object();
        }
        Sort<Student> quicksort = new QuickSort<Student>();
        quicksort.sort(students, this.size());
        return students;
    }


    //학급의 학생들을 성적 순으로 정렬한다.
    public int numberOfStudentsAboveAverage() {
        double average = this.average();
        int count = 0;
        Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next().object();
            if ((double) student.score() >= average) {
                count++;
            }
        }
        return count;

    }

    public GradeCounter countGrade() { //학생들의 수를 센다.
        // 학급의 학점별 학생수를 세게 하고, 그 결과를 가지고 있는 GradeCounter 객체를 얻는다
        GradeCounter counter = new GradeCounter();
        Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
        while (iterator.hasNext()) {
           DictionaryElement<String, Student> element = iterator.next();
           char count = Ban.scoreToGrade(element.object().score());
           counter.count(count);
        }
        return counter;
    }

}


