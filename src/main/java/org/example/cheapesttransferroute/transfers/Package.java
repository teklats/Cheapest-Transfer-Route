package org.example.cheapesttransferroute.transfers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Package implements Comparable<Package>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private int weight;
    private int cost;

    public Package(long id, int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }
    public Package(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    public Package() {

    }

    public long getId() {
        return id;
    }
    private void setId(long id) {
        this.id = id;
    }
    public int getWeight() {
        return weight;
    }
    private void setWeight(int weight) {
        this.weight = weight;
    }
    public int getCost() {
        return cost;
    }
    private void setCost(int cost) {
        this.cost = cost;
    }
    @Override
    public String toString() {
        return "Package{" +
                "weight=" + weight +
                ", cost=" + cost +
                '}';
    }
    @Override
    public int compareTo(Package p) {
        return Double.compare(this.weight, p.getWeight());
    }
}
