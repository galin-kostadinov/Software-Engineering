import java.util.*;

public class HashTable<TKey, TValue> implements Iterable<KeyValue<TKey, TValue>> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.7f;

    private LinkedList<KeyValue<TKey, TValue>>[] elements;

    private int size;

    private int capacity;

    public HashTable() {
        this.elements = new LinkedList[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public HashTable(int capacity) {
        this.elements = new LinkedList[capacity];
        this.capacity = capacity;
    }

    public void add(TKey key, TValue value) {
        growIfNeeded();

        int index = (key.hashCode() & 0x7fffffff) % this.capacity;

        if (this.elements[index] == null) {
            this.elements[index] = new LinkedList<>();
        }

        for (var item : this.elements[index]) {
            if (item.getKey().equals(key)) {
                throw new IllegalArgumentException();
            }
        }

        KeyValue<TKey, TValue> kvp = new KeyValue<>(key, value);
        this.elements[index].addLast(kvp);

        this.size++;
    }


    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean addOrReplace(TKey key, TValue value) {
        growIfNeeded();

        int index = (key.hashCode() & 0x7fffffff) % this.capacity;

        if (this.elements[index] == null) {
            this.elements[index] = new LinkedList<>();
        }

        for (var item : this.elements[index]) {
            if (item.getKey().equals(key)) {
                item.setValue(value);

                return true;
            }
        }

        KeyValue<TKey, TValue> kvp = new KeyValue<>(key, value);
        this.elements[index].addLast(kvp);

        this.size++;

        return false;
    }

    public TValue get(TKey key) {
        KeyValue<TKey, TValue> kvp = this.find(key);

        if (kvp == null) {
            throw new IllegalArgumentException();
        }

        return kvp.getValue();
    }

    public boolean tryGetValue(TKey key, TValue value) {
        KeyValue<TKey, TValue> kvp = this.find(key);

        if (kvp == null) {
            return false;
        } else {
            if (kvp.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    public KeyValue<TKey, TValue> find(TKey key) {
        int index = (key.hashCode() & 0x7fffffff) % this.capacity;

        if (this.elements[index] != null) {
            for (var item : this.elements[index]) {
                if (item.getKey().equals(key)) {
                    return item;
                }
            }
        }

        return null;
    }

    public boolean containsKey(TKey key) {
        return this.find(key) != null;
    }

    public boolean remove(TKey key) {
        int index = (key.hashCode() & 0x7fffffff) % this.capacity;

        if (this.elements[index] == null) {
            return false;
        }

        for (var item : this.elements[index]) {
            if (item.getKey().equals(key)) {
                elements[index].remove(item);
                this.size--;
                return true;
            }
        }

        return false;
    }

    public void clear() {
        this.elements = new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public Iterable<TKey> keys() {
        List<TKey> allTKeys = new ArrayList<>(this.size);

        for (var element : this.elements) {
            if (element != null) {
                for (var kvp : element) {
                    if (kvp != null) {
                        allTKeys.add(kvp.getKey());
                    }
                }
            }
        }

        return allTKeys;
    }

    public Iterable<TValue> values() {
        List<TValue> allTValues = new ArrayList<>(this.size);

        for (var element : this.elements) {
            if (element != null) {
                for (var kvp : element) {
                    if (kvp != null) {
                        allTValues.add(kvp.getValue());
                    }
                }
            }
        }

        return allTValues;
    }

    @Override
    public Iterator<KeyValue<TKey, TValue>> iterator() {
        List<KeyValue<TKey, TValue>> allKVP = this.getKvp();


        return new Iterator<KeyValue<TKey, TValue>>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < size) {
                    return true;
                }
                return false;
            }

            @Override
            public KeyValue<TKey, TValue> next() {
                return allKVP.get(index++);
            }
        };
    }

    private List<KeyValue<TKey, TValue>> getKvp() {
        List<KeyValue<TKey, TValue>> allKvp = new ArrayList<>(this.size);

        for (var element : this.elements) {
            if (element != null) {
                for (var kvp : element) {
                    if (kvp != null) {
                        allKvp.add(kvp);
                    }
                }
            }
        }

        return allKvp;
    }

    private void growIfNeeded() {
        int loadFactor = (this.size + 1) / this.capacity;

        if (loadFactor >= LOAD_FACTOR) {
            grow();
        }
    }

    private void grow() {
        HashTable<TKey, TValue> newTable = new HashTable<>(this.capacity * 2);
        for (var element : this.elements) {
            if (element != null) {
                for (var kvp : element) {
                    if (kvp != null) {
                        newTable.add(kvp.getKey(), kvp.getValue());
                    }
                }
            }
        }

        this.elements = newTable.elements;
        this.capacity *= 2;
    }
}
