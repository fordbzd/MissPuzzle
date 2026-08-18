package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class IPV4IteratorTest {

    // ------------------------------------------------------------------
    // Helper
    // ------------------------------------------------------------------
    private List<String> collect(IPV4Iterator it) {
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }

    // ------------------------------------------------------------------
    // Part 1 – Forward (bare IPv4)
    // ------------------------------------------------------------------

    @Test
    public void testForwardNearTop() {
        List<String> got = collect(new IPV4Iterator("255.255.255.250"));
        List<String> expected = Arrays.asList(
            "255.255.255.250",
            "255.255.255.251",
            "255.255.255.252",
            "255.255.255.253",
            "255.255.255.254",
            "255.255.255.255"
        );
        assertEquals(expected, got);
    }

    @Test
    public void testForwardFromZero() {
        IPV4Iterator it = new IPV4Iterator("0.0.0.0");
        assertTrue(it.hasNext());
        assertEquals("0.0.0.0", it.next());
        assertEquals("0.0.0.1", it.next());
        assertEquals("0.0.0.2", it.next());
    }

    @Test
    public void testForwardLastAddress() {
        List<String> got = collect(new IPV4Iterator("255.255.255.255"));
        assertEquals(Collections.singletonList("255.255.255.255"), got);
    }

    @Test
    public void testForwardOctetRollover() {
        IPV4Iterator it = new IPV4Iterator("192.168.0.254");
        assertEquals("192.168.0.254", it.next());
        assertEquals("192.168.0.255", it.next());
        assertEquals("192.168.1.0", it.next());
        assertEquals("192.168.1.1", it.next());
    }

    @Test
    public void testForwardExhaustedThrows() {
        IPV4Iterator it = new IPV4Iterator("255.255.255.255");
        it.next(); // the only address
        assertFalse(it.hasNext());
        try {
            it.next();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException expected) {
            // ok
        }
    }

    // ------------------------------------------------------------------
    // Part 2 – Reverse
    // ------------------------------------------------------------------

    @Test
    public void testReverseDownToZero() {
        List<String> got = collect(new IPV4Iterator("0.0.0.5", true));
        List<String> expected = Arrays.asList(
            "0.0.0.5", "0.0.0.4", "0.0.0.3", "0.0.0.2", "0.0.0.1", "0.0.0.0"
        );
        assertEquals(expected, got);
    }

    @Test
    public void testReverseFromZero() {
        List<String> got = collect(new IPV4Iterator("0.0.0.0", true));
        assertEquals(Collections.singletonList("0.0.0.0"), got);
    }

    @Test
    public void testReverseFromBroadcast() {
        IPV4Iterator it = new IPV4Iterator("255.255.255.255", true);
        assertEquals("255.255.255.255", it.next());
        assertEquals("255.255.255.254", it.next());
        assertEquals("255.255.255.253", it.next());
    }

    @Test
    public void testReverseOctetUnderflow() {
        IPV4Iterator it = new IPV4Iterator("192.168.1.1", true);
        assertEquals("192.168.1.1", it.next());
        assertEquals("192.168.1.0", it.next());
        assertEquals("192.168.0.255", it.next());
        assertEquals("192.168.0.254", it.next());
    }

    // ------------------------------------------------------------------
    // Part 3 – CIDR
    // ------------------------------------------------------------------

    @Test
    public void testCidrForwardFromMiddle() {
        // 192.168.1.5/29  → block 192.168.1.0 – 192.168.1.7
        List<String> got = collect(new IPV4Iterator("192.168.1.5/29"));
        List<String> expected = Arrays.asList(
            "192.168.1.5", "192.168.1.6", "192.168.1.7"
        );
        assertEquals(expected, got);
    }

    @Test
    public void testCidrReverseFromMiddle() {
        List<String> got = collect(new IPV4Iterator("192.168.1.5/29", true));
        List<String> expected = Arrays.asList(
            "192.168.1.5", "192.168.1.4", "192.168.1.3",
            "192.168.1.2", "192.168.1.1", "192.168.1.0"
        );
        assertEquals(expected, got);
    }

    @Test
    public void testCidrForwardFromNetworkAddress() {
        List<String> got = collect(new IPV4Iterator("192.168.1.0/29"));
        List<String> expected = Arrays.asList(
            "192.168.1.0", "192.168.1.1", "192.168.1.2", "192.168.1.3",
            "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7"
        );
        assertEquals(expected, got);
    }

    @Test
    public void testCidrReverseFromBroadcast() {
        List<String> got = collect(new IPV4Iterator("192.168.1.7/29", true));
        List<String> expected = Arrays.asList(
            "192.168.1.7", "192.168.1.6", "192.168.1.5", "192.168.1.4",
            "192.168.1.3", "192.168.1.2", "192.168.1.1", "192.168.1.0"
        );
        assertEquals(expected, got);
    }

    @Test
    public void testCidrSlash32() {
        List<String> got = collect(new IPV4Iterator("192.168.1.100/32"));
        assertEquals(Collections.singletonList("192.168.1.100"), got);
    }

    @Test
    public void testCidrSlash31() {
        List<String> got = collect(new IPV4Iterator("10.0.0.0/31"));
        assertEquals(Arrays.asList("10.0.0.0", "10.0.0.1"), got);
    }

    @Test
    public void testCidrSlash31Reverse() {
        List<String> got = collect(new IPV4Iterator("10.0.0.1/31", true));
        assertEquals(Arrays.asList("10.0.0.1", "10.0.0.0"), got);
    }

    @Test
    public void testCidrSlash30() {
        // 10.0.0.5/30 → block 10.0.0.4 – 10.0.0.7
        List<String> got = collect(new IPV4Iterator("10.0.0.5/30"));
        assertEquals(Arrays.asList("10.0.0.5", "10.0.0.6", "10.0.0.7"), got);
    }

    @Test
    public void testCidrSeedIsNetworkAddress() {
        // seed == network address
        List<String> got = collect(new IPV4Iterator("192.168.1.0/29"));
        assertEquals(Arrays.asList(
            "192.168.1.0", "192.168.1.1", "192.168.1.2", "192.168.1.3",
            "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7"
        ), got);
    }

    @Test
    public void testCidrSeedIsBroadcastAddress() {
        // seed == broadcast address (only one address should be yielded)
        List<String> got = collect(new IPV4Iterator("192.168.1.7/29"));
        assertEquals(Collections.singletonList("192.168.1.7"), got);
    }

    @Test
    public void testCidrSeedIsBroadcastAddressReverse() {
        List<String> got = collect(new IPV4Iterator("192.168.1.7/29", true));
        assertEquals(Arrays.asList(
            "192.168.1.7", "192.168.1.6", "192.168.1.5", "192.168.1.4",
            "192.168.1.3", "192.168.1.2", "192.168.1.1", "192.168.1.0"
        ), got);
    }

    @Test
    public void testCidrSeedInMiddleOfDifferentBlock() {
        // 192.168.1.10/29 belongs to block 192.168.1.8 – 192.168.1.15
        List<String> got = collect(new IPV4Iterator("192.168.1.10/29"));
        assertEquals(Arrays.asList(
            "192.168.1.10", "192.168.1.11", "192.168.1.12",
            "192.168.1.13", "192.168.1.14", "192.168.1.15"
        ), got);
    }

    @Test
    public void testCidrFullSpaceSlash0() {
        IPV4Iterator it = new IPV4Iterator("1.2.3.4/0");
        assertEquals("1.2.3.4", it.next());
        assertEquals("1.2.3.5", it.next());
        // just check it keeps going; don't collect everything
        assertTrue(it.hasNext());
    }
}