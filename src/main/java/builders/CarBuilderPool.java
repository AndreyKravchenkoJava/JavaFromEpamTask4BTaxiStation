package builders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CarBuilderPool implements Iterable<Class<? extends CarBuilder>> {
    private final List<Class<? extends CarBuilder>> builderPool;
    {
        builderPool = new ArrayList<>();
        builderPool.add(CarHyundaiBuilder.class);
        builderPool.add(CarRenoBuilder.class);
        builderPool.add(CarSkodaBuilder.class);
        builderPool.add(CarVolkswagenBuilder.class);
    }

    public int getPoolSize() {
        return builderPool.size();
    }

    public Class<? extends CarBuilder> getCertainBuilder(int index) {
        return builderPool.get(index);
    }

    @Override
    public Iterator<Class<? extends CarBuilder>> iterator() {
        return builderPool.iterator();
    }
}
