package LC.Contest_266;

public class Pair<T1, T2> {
    T1 t1;
    T2 t2;

    Pair(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 getKey() {
        return t1;
    }

    public T2 getValue() {
        return t2;
    }
}
