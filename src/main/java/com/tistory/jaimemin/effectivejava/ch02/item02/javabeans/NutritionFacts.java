package com.tistory.jaimemin.effectivejava.ch02.item02.javabeans;

/**
 * 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
 *
 * 장점: 객체 생성이 telescoping constructor에 비해 간단해짐
 * 단점: 필수값들이 세팅되지 않은 상태로 사용될 수 있음 (consistency가 깨진 상태로 사용될 가능성 존재)
 * -> setter 를 통해 필수값을 모두 세팅하기 전에 사용될 가능성이 있음
 *
 * 두 방법을 혼용해서 required 필드들은 생성자로 넘기고 optional한 필드들은 setter로 (기존의 단점들을 상쇄)
 * 그러나 해당 방법도 불변 객체(immutable)로 선언하기 어려움 (setter를 사용하기 때문에)
 * 객체 freezing을 통해 해결 가능하지만 javascript에서 지원되고 java에서는 직접 구현해야하고 현업에서 잘 사용하지 않는 방법
 */
public class NutritionFacts {
    // 필드 (기본값이 있다면) 기본값으로 초기화된다.
    private int servingSize  = -1; // required

    private int servings     = -1; // required

    private int calories     = 0;

    private int fat          = 0;

    private int sodium       = 0;

    private int carbohydrate = 0;

    private boolean healthy;

    public NutritionFacts() { }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);

        System.out.println(cocaCola);
    }
}
