
public class HashSet<TKey> {
    private HashTable<TKey, TKey> table;

    public HashSet() {
        this.table = new HashTable<>();
    }

    public HashSet(Iterable<KeyValue<TKey, TKey>> enumerable) {
        this.table = new HashTable<>();
        for (var item : enumerable) {
            this.table.addOrReplace(item.getKey(), item.getKey());
        }
    }

    public void add(TKey key) {
        this.table.addOrReplace(key, key);
    }

    public HashSet<TKey> unionWith(HashSet<TKey> other) {
        HashSet<TKey> result = new HashSet<>();

        for (KeyValue<TKey, TKey> tKeyTKeyKeyValue : table) {
            result.add(tKeyTKeyKeyValue.getKey());
        }

        for (KeyValue<TKey, TKey> tKeyTKeyKeyValue : other.table) {
            result.add(tKeyTKeyKeyValue.getKey());
        }

        return result;
    }

    public HashSet<TKey> intersectWith(HashSet<TKey> other) {
        HashSet<TKey> result = new HashSet<>();

        for (KeyValue<TKey, TKey> tKeyTKeyKeyValue : table) {
            if (other.contains(tKeyTKeyKeyValue.getKey())) {
                result.add(tKeyTKeyKeyValue.getKey());
            }
        }

        return result;
    }

    public HashSet<TKey> exept(HashSet<TKey> other) {
        HashSet<TKey> result = new HashSet<>();

        for (KeyValue<TKey, TKey> tKeyTKeyKeyValue : table) {
            if (!other.contains(tKeyTKeyKeyValue.getKey())) {
                result.add(tKeyTKeyKeyValue.getKey());
            }
        }

        return result;
    }

    public HashSet<TKey> symetricExept(HashSet<TKey> other) {
        HashSet<TKey> result = new HashSet<>();

        for (KeyValue<TKey, TKey> tKeyTKeyKeyValue : table) {
            if (!other.contains(tKeyTKeyKeyValue.getKey())) {
                result.add(tKeyTKeyKeyValue.getKey());
            }
        }

        for (KeyValue<TKey, TKey> tKeyTKeyKeyValue : other.table) {
            if (!table.containsKey(tKeyTKeyKeyValue.getKey())) {
                result.add(tKeyTKeyKeyValue.getKey());
            }
        }

        return result;
    }

    public boolean contains(TKey key) {
        return this.table.containsKey(key);
    }
}
