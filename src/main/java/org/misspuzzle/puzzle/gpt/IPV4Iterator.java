package org.misspuzzle.puzzle.gpt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IPV4Iterator implements Iterator<String> {

    long curr;
    long limit;
    long step;

    boolean reverse;
    boolean hasNext;

    public IPV4Iterator(String ipOrCidr) {
         this(ipOrCidr, false);
    }

    public IPV4Iterator(String ipOrCidr, boolean reserve) {
         this(ipOrCidr, reserve, 1);
    }

    public IPV4Iterator(String ipOrCidr, boolean reverse, long step) {
        this.step = step;
        this.reverse = reverse;

        String ipStr;
        int prefix = 0;

        // Translate the ip string to long (curr)
        if (ipOrCidr.contains("/")) {
            String[] ipOrCidrStrs = ipOrCidr.split("/");
            ipStr = ipOrCidrStrs[0];
            prefix = Integer.parseInt(ipOrCidrStrs[1]);
        } else {
            ipStr = ipOrCidr;
        }

        String[] ipParts = ipStr.split("\\.");
        for (int i = 0; i < 4; i++) {
            curr = (curr << 8) | Integer.parseInt(ipParts[i]);
        }

        // Calculate the limit
        int hostBit = 32 - prefix;
        long mask = (0xFFFFFFFFL << hostBit) & 0xFFFFFFFFL;
        long hostCount = 1L << hostBit;

        long upper = (curr & mask) + hostCount - 1;
        long lower = curr & mask;

        hasNext = (curr >= lower && curr <= upper);
        limit   = reverse ? lower : upper;

        System.out.println("curr=" + longToStr(curr));
        System.out.println("limit=" + longToStr(limit));
        System.out.println("hasNext=" + hasNext);
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    // throws NoSuchElementException when exhausted
    @Override
    public String next() {  
        if (!hasNext) {
            throw new NoSuchElementException();
        }

        long result = curr;
        
        if (reverse) {
            curr -= step;
            if (curr < limit) {
                hasNext = false;
            }
        } else {
            curr += step;
            if (curr > limit) {
                hasNext = false;
            }
        }

        // Build long to string
        return longToStr(result);
    }      

    private String longToStr(long value) {
        return ((value >> 24) & 0xFF) + "." +
               ((value >> 16) & 0xFF) + "." +
               ((value >>  8) & 0xFF) + "." +
               ( value        & 0xFF);
    }
}
