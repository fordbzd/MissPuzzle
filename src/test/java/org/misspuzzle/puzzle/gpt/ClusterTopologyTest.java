package org.misspuzzle.puzzle.gpt;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

public class ClusterTopologyTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // ------------------------------------------------------------------
    // Helper: build a tree
    // ------------------------------------------------------------------
    private ClusterTopology.Node buildTree(String rootId, Map<String, List<String>> edges) {
        Map<String, ClusterTopology.Node> nodes = new HashMap<>();

        ClusterTopology.Node root = new ClusterTopology().new Node(rootId, null);
        nodes.put(rootId, root);

        // create all nodes
        for (List<String> children : edges.values()) {
            for (String childId : children) {
                nodes.putIfAbsent(childId, new ClusterTopology().new Node(childId, null));
            }
        }

        // link parent / children
        for (Map.Entry<String, List<String>> e : edges.entrySet()) {
            ClusterTopology.Node parent = nodes.get(e.getKey());
            for (String childId : e.getValue()) {
                ClusterTopology.Node child = nodes.get(childId);
                child.parent = parent;
                parent.children.add(child);
            }
        }
        return root;
    }

    private int runCount(ClusterTopology.Node root) {
        outContent.reset();
        root.receiveMessage(null, "count");
        return Integer.parseInt(outContent.toString().trim());
    }

    // ------------------------------------------------------------------
    // Test cases
    // ------------------------------------------------------------------

    @Test
    public void testSingleNode() {
        ClusterTopology.Node root = new ClusterTopology().new Node("1", null);
        assertEquals(1, runCount(root));
    }

    @Test
    public void testSimpleTree() {
        // 1
        // / \
        // 2  3
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));

        assertEquals(3, runCount(buildTree("1", edges)));
    }

    @Test
    public void testUnbalancedTree() {
        // 1 - 2 - 3
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2"));
        edges.put("2", Arrays.asList("3"));

        assertEquals(3, runCount(buildTree("1", edges)));
    }

    @Test
    public void testExampleFromProblem() {
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));
        edges.put("2", Arrays.asList("4", "5"));
        edges.put("3", Arrays.asList("6"));

        assertEquals(6, runCount(buildTree("1", edges)));
    }

    @Test
    public void testCompleteBinaryTree() {
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));
        edges.put("2", Arrays.asList("4", "5"));
        edges.put("3", Arrays.asList("6", "7"));

        assertEquals(7, runCount(buildTree("1", edges)));
    }

    @Test
    public void testLargerUnbalanced() {
        // 1 - 2 - 3 - 4 - 5
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2"));
        edges.put("2", Arrays.asList("3"));
        edges.put("3", Arrays.asList("4"));
        edges.put("4", Arrays.asList("5"));

        assertEquals(5, runCount(buildTree("1", edges)));
    }

    @Test
    public void testMultipleChildrenAtRoot() {
        //   1
        // / | \
        // 2 3  4
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3", "4"));

        assertEquals(4, runCount(buildTree("1", edges)));
    }

    // ------------------------------------------------------------------
    // Part 2 – Topology tests
    // ------------------------------------------------------------------

    private String runTopology(ClusterTopology.Node root) {
        outContent.reset();
        root.receiveMessage(null, "topology");
        return outContent.toString().trim();
    }

    @Test
    public void testTopologySingleNode() {
        ClusterTopology.Node root = new ClusterTopology().new Node("1", null);
        assertEquals("1()", runTopology(root));
    }

    @Test
    public void testTopologySimpleTree() {
        // 1
        // / \
        // 2  3
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));

        assertEquals("1(2(),3())", runTopology(buildTree("1", edges)));
    }

    @Test
    public void testTopologyUnbalancedTree() {
        // 1 - 2 - 3
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2"));
        edges.put("2", Arrays.asList("3"));

        assertEquals("1(2(3()))", runTopology(buildTree("1", edges)));
    }

    @Test
    public void testTopologyExampleFromProblem() {
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));
        edges.put("2", Arrays.asList("4", "5"));
        edges.put("3", Arrays.asList("6"));

        assertEquals("1(2(4(),5()),3(6()))", runTopology(buildTree("1", edges)));
    }

    @Test
    public void testTopologyCompleteBinaryTree() {
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));
        edges.put("2", Arrays.asList("4", "5"));
        edges.put("3", Arrays.asList("6", "7"));

        assertEquals("1(2(4(),5()),3(6(),7()))", runTopology(buildTree("1", edges)));
    }

    @Test
    public void testTopologyLargerUnbalanced() {
        // 1 - 2 - 3 - 4 - 5
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2"));
        edges.put("2", Arrays.asList("3"));
        edges.put("3", Arrays.asList("4"));
        edges.put("4", Arrays.asList("5"));

        assertEquals("1(2(3(4(5()))))", runTopology(buildTree("1", edges)));
    }

    @Test
    public void testTopologyMultipleChildrenAtRoot() {
        //   1
        // / | \
        // 2 3  4
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3", "4"));

        assertEquals("1(2(),3(),4())", runTopology(buildTree("1", edges)));
    }

    // ------------------------------------------------------------------
    // Part 3 – Idempotency / Duplicate message tests
    // ------------------------------------------------------------------

    @Test
    public void testDuplicateCountRequestOnRoot() {
        //       1
        //      / \
        //     2   3
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));
        ClusterTopology.Node root = buildTree("1", edges);

        String requestId = "req-001";

        outContent.reset();
        // First request
        root.receiveMessage(null, "count?requestId=" + requestId);
        // Duplicate request with the same ID
        root.receiveMessage(null, "count?requestId=" + requestId);

        String output = outContent.toString().trim();
        // Should print the correct count only once
        assertEquals("3", output);
    }

    @Test
    public void testDuplicateCountRequestOnInternalNode() {
        // 1 - 2 - 3
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2"));
        edges.put("2", Arrays.asList("3"));
        ClusterTopology.Node root = buildTree("1", edges);

        String requestId = "req-002";

        outContent.reset();
        root.receiveMessage(null, "count?requestId=" + requestId);

        // Simulate a duplicate request arriving at node 2
        ClusterTopology.Node node2 = root.children.get(0);
        node2.receiveMessage(root.id, "count?requestId=" + requestId);

        String output = outContent.toString().trim();
        assertEquals("3", output);   // still correct, no double counting
    }

    @Test
    public void testDuplicateResponseFromChild() {
        // 1
        // / \
        // 2  3
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));
        ClusterTopology.Node root = buildTree("1", edges);

        String requestId = "req-003";

        outContent.reset();
        root.receiveMessage(null, "count?requestId=" + requestId);

        // The normal flow already finished and printed 3.
        // Now simulate a late/duplicate response from child 2
        root.receiveMessage("2", "countResponse?requestId=" + requestId + "&value=1");

        String output = outContent.toString().trim();
        // Should still be only one line with the correct answer
        assertEquals("3", output);
    }

    @Test
    public void testDifferentRequestIdsAreIndependent() {
        // Single node
        ClusterTopology.Node root = new ClusterTopology().new Node("1", null);

        outContent.reset();
        root.receiveMessage(null, "count?requestId=req-A");
        root.receiveMessage(null, "count?requestId=req-B");  // different ID

        String output = outContent.toString().trim();
        // Two independent requests → two correct answers
        assertEquals("1\n1", output);
    }

    @Test
    public void testIdempotencyOnLargerTree() {
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("1", Arrays.asList("2", "3"));
        edges.put("2", Arrays.asList("4", "5"));
        edges.put("3", Arrays.asList("6"));
        ClusterTopology.Node root = buildTree("1", edges);

        String requestId = "req-004";

        outContent.reset();
        // Normal request
        root.receiveMessage(null, "count?requestId=" + requestId);
        // Duplicate at root
        root.receiveMessage(null, "count?requestId=" + requestId);
        // Duplicate at an internal node
        ClusterTopology.Node node2 = root.children.get(0);
        node2.receiveMessage(root.id, "count?requestId=" + requestId);

        String output = outContent.toString().trim();
        assertEquals("6", output);
    }
}
