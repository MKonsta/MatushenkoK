package ru.job4j;

public class Engineer extends Profession {
    public boolean higerEducation;
    public int houseFloors;

    public Engineer(String name, int age, String specialization) {
        super(name, age, specialization);
    }

    public boolean getHigerEducation() {
        return this.higerEducation;
    }
    public int getHouseFloors() {
        return this.houseFloors;
    }

    public String projectBuild(HouseProject building) {
        return "проектирует " + building.getFloorsNumber() + "-этажный дом";
    }
    public void createDrawning() {
    }
}
