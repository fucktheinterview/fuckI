public class Hashtable<K, V> {
    private  class Entry {
        private final K key;
        private final V val;

        Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private static int BUCKET_COUNT = 13;

    @SuppressWarnings("unchecked")
    private List<Entry>[] buckets = new List[BUCKET_COUNT];

    public Hashtable() {
        for (int i = 0, l = buckets.length; i < l; i++) {
            buckets[i] = new ArrayList<Entry>();
        }
    }

    public V get(K key) {
        int b = key.hashCode() % BUCKET_COUNT;
        List<Entry> entries = buckets[b];
        for (Entry e: entries) {
            if (e.key.equals(key)) {
                return e.val;
            }
        }
        return null;
    }

    public void put(K key, V val) {
        int b = key.hashCode() % BUCKET_COUNT;
        List<Entry> entries = buckets[b];
        entries.add(new Entry(key, val));
    }
}


// worse one, only for String

public class HashTable{
// Uses the generic LinkedList2 class from Display 15.7
    private LinkedList2[] hashArray;
    private static final int SIZE = 10;
    public HashTable( ){
        hashArray = new LinkedList2[SIZE];
        for ( int i=0; i < SIZE; i++)
          hashArray[i] = new LinkedList2( );
    }
    private int computeHash(String s){
      int hash = 0;
      for ( int i = 0; i < s.length( ); i++){
        hash += s.charAt(i);
      }
      return hash % SIZE;
    }
    /**
    Returns true if the target is in the hash table,
    false if it is not.
    */
    public boolean containsString(String target){
        int hash = computeHash(target);
        LinkedList2 list = hashArray[hash];
        if (list.contains(target))
            return true;
        return false;
    }
    
    /**
    Stores or puts string s into the hash table
    */
    public void put(String s){
        LinkedList2 list = hashArray[hash];
        if (!list.contains(s))
        {
            // Only add the target if it's not already
            // on the list.
            hashArray[hash].addToStart(s);
        }
    }
} // End HashTable class
