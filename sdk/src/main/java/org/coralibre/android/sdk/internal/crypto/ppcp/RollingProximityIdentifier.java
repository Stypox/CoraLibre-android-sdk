package org.coralibre.android.sdk.internal.crypto.ppcp;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class RollingProximityIdentifier {
    public static final int RPI_LENGTH = 16;

    private final byte[] data = new byte[RPI_LENGTH];
    private final ENNumber interval;

    public RollingProximityIdentifier(byte[] rawPRI, ENNumber interval) {
        if(rawPRI.length != RPI_LENGTH) throw new InvalidParameterException("wrong rawRPI size");
        this.interval = new ENNumber(interval);
        System.arraycopy(rawPRI, 0, data, 0, RPI_LENGTH);
    }

    public byte[] getData() {
        byte[] retVal = new byte[RPI_LENGTH];
        System.arraycopy(data, 0, retVal, 0, RPI_LENGTH);
        return retVal;
    }

    public ENNumber getInterval() {
        return interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollingProximityIdentifier that = (RollingProximityIdentifier) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
