
// three methods - valueOf(), Ordinal(), values() - all of which are added internally by the java compiler


class Main {

    // Without initial values
    enum Colors {
        black,
        white,
        purple
    }

    // enum with initial values to constants

    enum ColorsValues {
        black(10), white(20), purple(30);
        private int value;
        ColorsValues(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        
        // Variable can hold enum

        Colors thisIsAColorVariable = Colors.black;
        
        // The valueOf() method returns the enum constant along with the defined name

        System.out.println(ColorsValues.valueOf("black").value);

        // To print out

        for(Colors color: Colors.values()) {
            System.out.println(color);
        }

        // ordinal returns the index of the element inside the enum class.

        System.out.println(Colors.valueOf("white").ordinal());



    }
}