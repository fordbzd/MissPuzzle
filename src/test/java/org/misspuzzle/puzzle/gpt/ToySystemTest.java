package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.Test;
// import unnecessary in same package
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import static org.misspuzzle.puzzle.gpt.ToySystem.*;

public class ToySystemTest {

    // ------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------
    private Node leaf(String name) {
        return new Node(name);
    }

    private Node tuple(Node... nodes) {
        return new Node(Arrays.asList(nodes));
    }

    // ------------------------------------------------------------------
    // Part 1 – toStr()
    // ------------------------------------------------------------------

    @Test
    public void testNodeToStrPrimitive() {
        assertEquals("int", leaf("int").toStr());
        assertEquals("str", leaf("str").toStr());
        assertEquals("bool", leaf("bool").toStr());
    }

    @Test
    public void testNodeToStrGeneric() {
        assertEquals("T1", leaf("T1").toStr());
        assertEquals("T2", leaf("T2").toStr());
    }

    @Test
    public void testNodeToStrSimpleTuple() {
        Node t = tuple(leaf("int"), leaf("T1"));
        assertEquals("[int,T1]", t.toStr());
    }

    @Test
    public void testNodeToStrNestedTuple() {
        Node inner = tuple(leaf("T1"), leaf("str"));
        Node outer = tuple(leaf("int"), inner);
        assertEquals("[int,[T1,str]]", outer.toStr());
    }

    @Test
    public void testFunctionToStr() {
        Function f = new Function(
            Arrays.asList(leaf("int"), leaf("T1")),
            tuple(leaf("T1"), leaf("str"))
        );
        assertEquals("(int,T1) -> [T1,str]", f.toStr());
    }

    @Test
    public void testFunctionToStrNoParams() {
        Function f = new Function(Collections.emptyList(), leaf("bool"));
        assertEquals("() -> bool", f.toStr());
    }

    // ------------------------------------------------------------------
    // Part 2 – getReturnType
    // ------------------------------------------------------------------

    @Test
    public void testBasicSubstitution() throws Exception {
        // (T1, T2, int, T1) -> [T1, T2]
        // args: int, str, int, int  →  [int, str]
        Node T1 = leaf("T1");
        Node T2 = leaf("T2");
        Node INT = leaf("int");
        Node STR = leaf("str");

        Function f = new Function(
            Arrays.asList(T1, T2, INT, T1),
            tuple(T1, T2)
        );

        Node result = getReturnType(Arrays.asList(INT, STR, INT, INT), f);
        assertEquals("[int,str]", result.toStr());
    }

    @Test
    public void testNestedTuples() throws Exception {
        // ([[T1, float], T2, T3]) -> [T3, T1]
        // args: [[str, float], [int, str], int]  →  [int, str]
        Node T1 = leaf("T1");
        Node T2 = leaf("T2");
        Node T3 = leaf("T3");
        Node FLOAT = leaf("float");
        Node STR = leaf("str");
        Node INT = leaf("int");

        Function f = new Function(
            Arrays.asList(tuple(T1, FLOAT), T2, T3),
            tuple(T3, T1)
        );

        List<Node> args = Arrays.asList(
            tuple(STR, FLOAT),
            tuple(INT, STR),
            INT
        );

        Node result = getReturnType(args, f);
        assertEquals("[int,str]", result.toStr());
    }

    @Test
    public void testGenericConflict() {
        Node T1 = leaf("T1");
        Function f = new Function(Arrays.asList(T1, T1), T1);

        try {
            getReturnType(Arrays.asList(leaf("int"), leaf("str")), f);
            fail("Expected Exception for generic conflict");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Conflict")
                    || e.getMessage().contains("T1"));
        }
    }

    @Test
    public void testArgumentCountMismatch() {
        Function f = new Function(
            Arrays.asList(leaf("int"), leaf("str")),
            leaf("bool")
        );

        try {
            getReturnType(Collections.singletonList(leaf("int")), f);
            fail("Expected Exception for count mismatch");
        } catch (Exception e) {
            assertTrue(e.getMessage().toLowerCase().contains("count")
                    || e.getMessage().toLowerCase().contains("mismatch"));
        }
    }

    @Test
    public void testConcreteTypeMismatch() {
        Function f = new Function(
            Arrays.asList(leaf("int")),
            leaf("bool")
        );

        try {
            getReturnType(Collections.singletonList(leaf("str")), f);
            fail("Expected Exception for type mismatch");
        } catch (Exception e) {
            assertTrue(e.getMessage().toLowerCase().contains("mismatch"));
        }
    }

    @Test
    public void testIdentityFunction() throws Exception {
        Node T1 = leaf("T1");
        Function f = new Function(Collections.singletonList(T1), T1);

        Node result = getReturnType(Collections.singletonList(leaf("float")), f);
        assertEquals("float", result.toStr());
    }

    @Test
    public void testNoGenerics() throws Exception {
        Function f = new Function(
            Arrays.asList(leaf("int"), leaf("str")),
            leaf("bool")
        );

        Node result = getReturnType(
            Arrays.asList(leaf("int"), leaf("str")), f);
        assertEquals("bool", result.toStr());
    }

    @Test
    public void testReturnTupleWithMultipleGenerics() throws Exception {
        Node T1 = leaf("T1");
        Node T2 = leaf("T2");
        Function f = new Function(
            Arrays.asList(T1, T2),
            tuple(T2, T1, T2)
        );

        Node result = getReturnType(
            Arrays.asList(leaf("bool"), leaf("int")), f);
        assertEquals("[int,bool,int]", result.toStr());
    }
}