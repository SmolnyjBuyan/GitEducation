package products.impl;

public enum Cup {
    SMALL(0.15F), MEDIUM(0.2F), LARGE(0.25F);

    public final float volume;

    Cup(float volume) {
        this.volume = volume;
    }

    public float getVolume() {
        return volume;
    }
}
