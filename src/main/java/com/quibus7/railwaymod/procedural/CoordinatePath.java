package com.quibus7.railwaymod.procedural;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a segment of the railway path with 3D coordinates and metadata
 */
public class CoordinatePath {
    private final int x;
    private final int y;
    private final int z;
    private final double curvature; // -1 to 1, negative = left, positive = right
    private final double slope;     // -1 to 1, negative = downward, positive = upward
    private final PathType type;    // GROUND, BRIDGE, TUNNEL

    public enum PathType {
        GROUND,
        BRIDGE,
        TUNNEL
    }

    public CoordinatePath(int x, int y, int z, double curvature, double slope, PathType type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.curvature = Math.max(-1, Math.min(1, curvature));
        this.slope = Math.max(-1, Math.min(1, slope));
        this.type = type;
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    public double getCurvature() { return curvature; }
    public double getSlope() { return slope; }
    public PathType getType() { return type; }

    @Override
    public String toString() {
        return String.format("CoordinatePath{x=%d, y=%d, z=%d, curve=%.2f, slope=%.2f, type=%s}",
                x, y, z, curvature, slope, type);
    }

    /**
     * Calculate distance to another point
     */
    public double distanceTo(CoordinatePath other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double dz = other.z - this.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}