/**
 *
 *There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 *
 *
 */


public class Main {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int difference_gas_cost = 0; // records the total gas spent in covering the gas stations
        int fuel_in_tank = 0; // records how much is there in the tank
        int starting_index = 0; // gas station to start
        int gas_stations = gas.length;
        for(int i = 0; i < gas_stations; i++) {
            difference_gas_cost += gas[i] - cost[i]; // add the gas to total gas
            fuel_in_tank += gas[i] - cost[i];

            if(fuel_in_tank < 0) { // if fuel is less than 0, meaning the gas station cannot go to another
                fuel_in_tank = 0; // reset fuel
                starting_index = i + 1; // make the starting index to where the next gas station is.
            }

            /**
             *
             *
             * starting_index = i + 1 is done because, we know that even if we start in any of the gas stations before i we wont be able to go fast i.
             *
             */
        }
        return (difference_gas_cost < 0) ? -1: starting_index;
    }
}
