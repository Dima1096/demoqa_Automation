package project.myFramework.myUtills;

public class Asserts {

    public static boolean compareWithVariance(int firstValue, int secondValue, int variance) {          //метод для сравнения двух чисел с погрешностью
        return firstValue >= secondValue - variance && firstValue <= secondValue + variance;
    }
}
