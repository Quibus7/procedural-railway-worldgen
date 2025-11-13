package com.quibus7.railwaymod.procedural;

import net.minecraft.world.level.levelgen.synth.ImprovedNoise;

/**
 * Provides noise generation for procedural railway path generation
 * Uses Perlin/Simplex noise seeded by world seed for deterministic results
 */
public class NoiseProvider {
    private final ImprovedNoise perlinNoise;
    private final long seed;

    public NoiseProvider(long worldSeed) {
        this.seed = worldSeed;
        this.perlinNoise = new ImprovedNoise(new java.util.Random(worldSeed));
    }

    /**
     * Sample noise at given coordinates
     * @param x X coordinate
     * @param z Z coordinate
     * @param scale Scale/frequency of noise
     * @return Noise value between -1 and 1
     */
    public double sampleNoise(double x, double z, double scale) {
        return perlinNoise.perlin(x / scale, 0, z / scale);
    }

    /**
     * Sample multi-octave noise for more natural variation
     * @param x X coordinate
     * @param z Z coordinate
     * @param scale Base scale
     * @param octaves Number of noise octaves to combine
     * @return Combined noise value
     */
    public double sampleMultiOctaveNoise(double x, double z, double scale, int octaves) {
        double result = 0;
        double amplitude = 1;
        double frequency = 1;
        double maxValue = 0;

        for (int i = 0; i < octaves; i++) {
            result += sampleNoise(x * frequency, z * frequency, scale) * amplitude;
            maxValue += amplitude;
            amplitude *= 0.5;
            frequency *= 2;
        }

        return result / maxValue;
    }

    public long getSeed() {
        return seed;
    }
}