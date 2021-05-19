package datastructures;

public class HashTable {

    private int INITIAL_SIZE = 4;
    private HashEntry[] data; // LinkedList

    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();

        //hashCode & 0x7fffffff will keep the result as a positive int
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        return index;
    }

    public void put(String key, String value) {
        int index = getIndex(key);

        HashEntry newEntry = new HashEntry(key, value);

        if (data[index] != null) {
            HashEntry temp = data[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newEntry;
        } else {
            data[index] = newEntry;
        }
    }

    public String get(String key) {
        int index = getIndex(key);
        HashEntry entries = data[index];
        while (entries != null) {
            if (entries.key == key) {
                return entries.value;
            }
            entries = entries.next;
        }

       return null;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.key)
                    .append("/")
                    .append(entry.value);
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.key)
                        .append("/")
                        .append(temp.value);
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}