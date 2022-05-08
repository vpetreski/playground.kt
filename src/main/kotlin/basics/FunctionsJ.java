package basics;

public class FunctionsJ {

    public static void main(String[] args) {
        // Top level functions in Kotlin can't be called as static methods from Java; Functions1.kt --> FunctionsKt
        Functions1Kt.topLevel();
        // Or Functions2.kt --> Util because of annotation in Kotlin file: @file:JvmName("Util")
        Util.someUtil();

        Functions1Kt.sum1(1, 2, 3);
        // Error
        //Functions1Kt.sum1(1, 2);
        // With @JvmOverloads
        Functions1Kt.sum2();
        Functions1Kt.sum2(1);
        Functions1Kt.sum2(1, 2);
        Functions1Kt.sum2(1, 2, 3);
    }
}
