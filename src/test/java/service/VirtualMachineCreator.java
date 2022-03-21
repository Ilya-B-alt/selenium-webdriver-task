package service;

import model.VirtualMachine;

public class VirtualMachineCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.virtualMachine.numberOfInstances";
    public static final String MACHINE_CLASS = "testdata.virtualMachine.machineClass";
    public static final String MACHINE_TYPE = "testdata.virtualMachine.machineType";
    public static final String REGION = "testdata.virtualMachine.region";
    public static final String COMMITTED_USAGE_TIME = "testdata.virtualMachine.committedUsageTime";

    public static VirtualMachine withCredentialsFromProperty () {
        return new VirtualMachine(TestDataReader.getTestData(NUMBER_OF_INSTANCES), TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_TYPE), TestDataReader.getTestData(REGION),
                TestDataReader.getTestData(COMMITTED_USAGE_TIME));
    }
}
