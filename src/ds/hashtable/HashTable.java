package ds.hashtable;

/**
 * HashTable data structure implementation
 * using resolve collision strategy with two hash functions
 */
public class HashTable {
    private String[] hashArray;
    private int arraySize;
    // counter for number of elements
    private int size = 0;

    /**
     * HashTable constructor
     * @param noOfSlots
     */
    public HashTable(int noOfSlots) {
        if (this.isPrime(noOfSlots)) {
            // If number of slots are prime - init the instance
            this.hashArray = new String[noOfSlots];
            this.arraySize = noOfSlots;
        } else {
            // If number of slots aren't prime - get next prime and then init the instance
            int primeCount = this.getNextPrime(noOfSlots);
            this.hashArray = new String[primeCount];
            this.arraySize = primeCount;

            // Give feedback about the change in the array size
            System.out.println("Hash table size given (" + noOfSlots + ") is not a prime number!");
            System.out.println("Hash table size changed to: " + primeCount);
        }
    }

    /**
     * Check if number is prime
     * @param num to be checked
     * @return boolean whether number is prime or not
     */
    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get next prime number given a starting position
     * @param minNumber starting position to check
     * @return prime number
     */
    private int getNextPrime(int minNumber) {
        for (int i = minNumber; true; i++) {
            if (this.isPrime(i)) {
                return i;
            }
        }
    }

    /**
     * Get preferred index position
     * @param word string value
     * @return preferred index
     */
    private int firstHash(String word) {
        // Utilizing Java hashCode method
        int hashVal = word.hashCode();
        // Getting the reminder considering array size as hashCode
        hashVal = hashVal % this.arraySize;
        if (hashVal < 0) {
            // Get hash value positive
            hashVal += this.arraySize;
        }

        // Ideal index position for insert and searching
        return hashVal;
    }

    /**
     * Get step value (greater than 0)
     * @param word given string
     * @return step value for the current iteration
     */
    private int secondHash(String word) {
        // Getting the hash from the first hashing method
        int hashVal = this.firstHash(word);

        // Constant should be prime number < array size
        int constant = 3;
        // Step size
        return constant - (hashVal % constant);
    }

    /**
     * Insert word in HashTable
     * @param word to be inserted
     */
    public void insert(String word) {
        int preferredPosition = firstHash(word);
        int stepSize = secondHash(word);

        while (this.hashArray[preferredPosition] != null) {
            // Increase with the step
            preferredPosition = preferredPosition + stepSize;
            // Get next candidate index
            preferredPosition = preferredPosition % this.arraySize;
        }

        // Assign word to available index
        this.hashArray[preferredPosition] = word;
        System.out.println("Inserted word: " + word);
        size++;
    }

    /**
     * Find word in HashTable
     * @param word to be found
     * @return the word or null
     */
    public String find(String word) {
        int preferredPosition = firstHash(word);
        int stepSize = secondHash(word);

        while (this.hashArray[preferredPosition] != null) {
            if (hashArray[preferredPosition].equals(word)) {
                // Return if match found
                return this.hashArray[preferredPosition];
            }
            // Increase with the step
            preferredPosition = preferredPosition + stepSize;
            // Get next index to check
            preferredPosition = preferredPosition % this.arraySize;
        }

        // If no match found return null
        return this.hashArray[preferredPosition];
    }

    /**
     * Rendering hash table with empty slots
     */
    public void render() {
        this.render(true);
    }

    /**
     * Rendering hash table
     * @param showEmpty whether to show empty slots or not
     */
    public void render(boolean showEmpty) {
        System.out.println("Hash Table: ");
        if (!showEmpty) {
            System.out.println("Without empty indexes!");
        }
        for (int i = 0; i < this.arraySize; i++) {
            String word = hashArray[i];
            if (word != null) {
                System.out.print("[" + i + "] " + word);
                System.out.println();
            } else {
                if (showEmpty) {
                    System.out.print("[" + i + "] (empty)");
                    System.out.println();
                }
            }
        }
    }
}
