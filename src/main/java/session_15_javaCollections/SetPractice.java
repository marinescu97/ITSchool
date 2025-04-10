package session_15_javaCollections;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class SetPractice {
    enum ZileleSaptamanii{
        LUNI, MARTI, MIERCURI, JOI, VINERI, SAMBATA, DUMINICA
    }

    public static void main(String[] args) {
        EnumSet<ZileleSaptamanii> zileleSaptamanii = EnumSet.range(ZileleSaptamanii.LUNI, ZileleSaptamanii.MIERCURI);
        System.out.println(zileleSaptamanii);
        zileleSaptamanii.add(ZileleSaptamanii.VINERI);
        zileleSaptamanii.add(ZileleSaptamanii.MARTI);
        System.out.println(zileleSaptamanii);

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Element A");
        hashSet.add("Element B");
        hashSet.add("Element C");
        hashSet.add("Element D");
        hashSet.add("Element E");

        System.out.println(hashSet);
        hashSet.add("Element B");

        System.out.println(hashSet);
    }
}
