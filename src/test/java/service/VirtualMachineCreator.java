package service;

import model.VirtualMachine;

public class VirtualMachineCreator {

    public static final String NUMBER_OF_INSTANCES = "testdata.virtualMachine.numberOfInstances";
    public static final String MACHINE_CLASS = "testdata.virtualMachine.machineClass";
    public static final String MACHINE_TYPE = "testdata.virtualMachine.machineType";
    public static final String REGION = "testdata.virtualMachine.region";
    public static final String COMMITTED_USAGE_TIME = "testdata.virtualMachine.committedUsageTime";

    public static VirtualMachine withCredentialsFromProperty () {
        return new VirtualMachine(TestDataReader.loadProperty(NUMBER_OF_INSTANCES), TestDataReader.loadProperty(MACHINE_CLASS),
                TestDataReader.loadProperty(MACHINE_TYPE), TestDataReader.loadProperty(REGION),
                TestDataReader.loadProperty(COMMITTED_USAGE_TIME));
    }
}
