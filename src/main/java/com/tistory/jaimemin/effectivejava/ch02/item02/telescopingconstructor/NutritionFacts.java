package com.tistory.jaimemin.effectivejava.ch02.item02.telescopingconstructor;

/**
 * 코드 2-1 점층적 생성자 패턴 - 확장하기 어렵다! (14~15쪽)
 * Chaining
 *
 * 문제점: 똑같은 타입의 필드가 많을 경우 어떤 파라미터를 전달해야할지 헷갈릴 확률이 높음
 * Intellij IDEA 사용한다면 cmd + p 단축키로 해결이 가능
 */
public class NutritionFacts {
    private final int servingSize;  // (mL, 1회 제공량)    required

    private final int servings;     // (회, 총 n회 제공량)  required

    private final int calories;     // (1회 제공량당)       optional

    private final int fat;          // (g/1회 제공량)       optional

    private final int sodium;       // (mg/1회 제공량)      optional

    private final int carbohydrate; // (g/1회 제공량)       optional

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize
            , int servings
            , int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize
            , int servings
            , int calories
            , int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize
            , int servings
            , int calories
            , int fat
            , int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize
            , int servings
            , int calories
            , int fat
            , int sodium
            , int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts(10, 10);
        System.out.println(cocaCola);
    }

}
