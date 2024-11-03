package top.mioyi.utils;

import java.security.SecureRandom;

public class Snowflake {
    private static final long START_TIMESTAMP = 1672502400000L;
    private static final long SEQUENCE_BIT = 12;
    private static final long WORKER_BIT = 10;
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);
    private static final long MAX_WORKER_NUM = ~(-1L << WORKER_BIT);
    private static final long WORKER_LEFT = SEQUENCE_BIT;
    private static final long TIMESTAMP_LEFT = WORKER_LEFT + WORKER_BIT;

    private final long workerId = new SecureRandom().nextLong(MAX_WORKER_NUM + 1);
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public synchronized long nextId() {
        var currentTimestamp = System.currentTimeMillis();

        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;

            if (sequence == 0) {
                //noinspection StatementWithEmptyBody
                while ((currentTimestamp = System.currentTimeMillis()) <= lastTimestamp) ;
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = currentTimestamp;

        return ((currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT) | (workerId << WORKER_LEFT) | sequence;
    }
}
