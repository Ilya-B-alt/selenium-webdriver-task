package model;

import java.util.Objects;

public class VirtualMachine {

    private String numberOfInstances;
    private String machineClass;
    private String machineType;
    private String region;
    private String committedUsageTime;

    public VirtualMachine(String numberOfInstances, String machineClass,
                          String machineType, String region, String committedUsageTime) {
        this.numberOfInstances = numberOfInstances;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.region = region;
        this.committedUsageTime = committedUsageTime;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommittedUsageTime() {
        return committedUsageTime;
    }

    public void setCommittedUsageTime(String committedUsageTime) {
        this.committedUsageTime = committedUsageTime;
    }

    @Override
    public String toString() {
        return "VirtualMachine{" +
                "numberOfInstances=" + numberOfInstances +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", region='" + region + '\'' +
                ", committedUsageTime='" + committedUsageTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine that = (VirtualMachine) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                machineClass.equals(that.machineClass) &&
                machineType.equals(that.machineType) &&
                region.equals(that.region) &&
                committedUsageTime.equals(that.committedUsageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, machineClass, machineType, region, committedUsageTime);
    }
}
