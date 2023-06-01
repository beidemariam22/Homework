package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import static org.example.Aircraft.LOGGER;

public final class LieutenantColonel extends Officer {

    private List<LieutenantColonel> lieutenans = new LinkedList<>();

    public LieutenantColonel() {

    }

    public LieutenantColonel(String name, int age, String rank, String department,
                             String location, int yearsofservice, String branch) {
        super(name, age, rank, department, location, yearsofservice, branch);

    }

    public List<LieutenantColonel> getLieutenan() {
        return lieutenans;
    }

    public void setLieutenan(List<LieutenantColonel> lieutenans) {
        this.lieutenans = lieutenans;
    }

    public final void oversee() {
        LOGGER.info("Lieutenant Colonel oversees the deployment.");
    }

    @Override
    public void status() {
        LOGGER.info("Lieutenant Colonel " + getName() + " has served for " + getYearsOfService() + " years.");
        if (getYearsOfService() >= 20) {
            LOGGER.info("Lieutenant Colonel " + getName() + " is eligible for retirement.");
        } else {
            LOGGER.info("Lieutenant Colonel " + getName() + " is not yet eligible for retirement.");
        }
    }
    public void addLieutenant(LieutenantColonel letco){
        lieutenans.add(letco);
    }
    public void processLieutenantColonel(Consumer<LieutenantColonel> lieutenanConsumer) {
       // List<LieutenantColonel> lie = new ArrayList<>();
        for (LieutenantColonel liee : lieutenans) {
            lieutenanConsumer.accept(liee);
        }
    }

    @Override
    public String toString() {
        return "LieutenantColonel{" +
                " Name='" + getName() +
                ", Age=" + getAge() +
                ", Rank='" + getRank() +
                ", YearsOfService" + getYearsOfService() +
                " ,Branch " + getBranch() + "}";
    }
}



