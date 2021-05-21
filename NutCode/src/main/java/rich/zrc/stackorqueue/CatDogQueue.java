package rich.zrc.stackorqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
  猫狗队列
 */

public class CatDogQueue {

    private static class Pet {
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Pet(String type) {
            this.type = type;
        }
    }

    private static class Dog extends Pet{
        public Dog() {
            super("dog");
        }
    }

    private static class Cat extends Pet {
        public Cat(String type) {
            super(type);
        }
    }

    private static class Card {
        private Pet pet;
        private int step;

        public Pet getPet() {
            return pet;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }

        public Card(Pet pet, int step) {
            this.pet = pet;
            this.step = step;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }
    }

    private Queue<Card> dogQueue;
    private Queue<Card> catQueue;
    private static int num;

    public CatDogQueue(Queue<Card> dogQueue, Queue<Card> catQueue) {
        this.dogQueue = dogQueue;
        this.catQueue = catQueue;

        dogQueue.add(new Card(null, Integer.MAX_VALUE));
        catQueue.add(new Card(null, Integer.MAX_VALUE));
    }

    public void add(Pet pet) {
        Card card = new Card(pet, num++);
        if (pet instanceof Dog) {
            dogQueue.add(card);
        } else {
            catQueue.add(card);
        }
    }

    public List<Pet> pollAll() {
        List<Pet> result = new ArrayList<>();
        while (dogQueue.size() > 1 && catQueue.size() > 1) {
            Pet cur = dogQueue.peek().step > catQueue.peek().step ? catQueue.poll().pet : dogQueue.poll().pet;
            result.add(cur);
        }
        return result;
    }

    public List<Pet> pollDog() {
        List<Pet> result = new ArrayList<>();
        while (dogQueue.size() > 1) {
            result.add(dogQueue.poll().pet);
        }
        return result;
    }

    public List<Pet> pollCat() {
        List<Pet> result = new ArrayList<>();
        while (catQueue.size() > 1) {
            result.add(catQueue.poll().pet);
        }
        return result;
    }

    public boolean isEmpty() {
        return !(catQueue.size() > 1) && !(dogQueue.size() > 1);
    }

    public boolean isDogEmpty() {
        return !(dogQueue.size() > 1);
    }

    public boolean isCatEmpty() {
        return !(catQueue.size() > 1);
    }
}
