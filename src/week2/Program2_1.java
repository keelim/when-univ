package week2;

public class Program2_1 {
    public static void main(String[] args) {
        double a, b, c;
        double determinant;
        double x1, x2;
        // 서로 다른 실근
        a = 1.0; b = 0.0; c = -4.0;

        a=3.0; b=0.0; c=-27.0;

        // 중근
        a=1.0; b=2.0; c=1.0;

        a=1.0; b=2.0; c=4.0;
        
        // 허근
        a=1.0; b=1.0; c=1.0;

        a=2.0; b=2.0; c=2.0;
        System.out.println("a= " + a + "b= " + b + "c= " + c);
        determinant = b * b - 4.0 * a * c;
        if(determinant>0){
            x1 = (-b+Math.sqrt(determinant)/(2.0*a));
            x2 = (-b-Math.sqrt(determinant)/(2.0*a));
            System.out.println("The solution is either"+x1+" or "+x2);
        } else if (determinant ==0){
            x1 = (-b+Math.sqrt(determinant)/(2.0*a));
            System.out.println("The solution is only" +x1);
        } else {
            System.out.println("The solution is NaN");
        }
    }
}

