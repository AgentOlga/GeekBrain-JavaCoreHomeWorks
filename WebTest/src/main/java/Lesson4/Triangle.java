package Lesson4;

import java.util.Scanner;
public class Triangle {
        public static void main(String[] args) {

            Scanner in = new Scanner( System.in ) ;

            System.out.println("Input number:" );
            int a = in.nextInt();

            System.out.println("Input number:" );
            int b = in.nextInt();

            System.out.println("Input number:" );
            int c = in.nextInt();

            //float p = (a + b + c) / 2.f;
            //System.out.println("perimeter:" + p);


            float s = CalculateArea(a,b,c);
            System.out.println("Square:" + s);
        }

    public static float CalculateArea (int a, int b, int c) {
        float p = (a + b + c) / 2.f;
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
