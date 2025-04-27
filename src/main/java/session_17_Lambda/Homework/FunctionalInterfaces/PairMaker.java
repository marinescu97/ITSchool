package session_17_Lambda.Homework.FunctionalInterfaces;

import session_17_Lambda.Homework.Pair;

@FunctionalInterface
public interface PairMaker<T,U> {
    Pair<T,U> create(T key, U value);
}
