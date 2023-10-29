package org.example.cap1.Exemplo1;

public class OverbookingPolicy {

    public boolean isAllowed(Cargo cargo, Voyage voyage){
        return ((cargo.size() + voyage.bookedCargoSize()) <= (voyage.capacity() * 1.1));
    }
}
