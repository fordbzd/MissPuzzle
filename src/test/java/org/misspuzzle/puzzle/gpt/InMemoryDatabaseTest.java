package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class InMemoryDatabaseTest {

    private InMemoryDatabase db;

    @BeforeEach
    public void setUp() {
        db = new InMemoryDatabase();
        db.createTable("users", List.of("id", "name", "birthday", "age"));

        db.insert("users", Map.of("id", "1", "name", "Alice",   "birthday", "1990-05-15", "age", 34));
        db.insert("users", Map.of("id", "2", "name", "Bob",     "birthday", "1985-08-20", "age", 39));
        db.insert("users", Map.of("id", "3", "name", "Charlie", "birthday", "1992-03-10", "age", 32));
        db.insert("users", Map.of("id", "4", "name", "Alice",   "birthday", "1988-11-01", "age", 36));
    }

    // ------------------------------------------------------------------
    // Part 1 – Projection
    // ------------------------------------------------------------------
    @Test
    public void testProjection() {
        List<Map<String, Object>> result = db.query("users", List.of("id", "name"));

        assertEquals(4, result.size());
        assertEquals(Set.of("id", "name"), result.get(0).keySet());
        assertEquals("Alice", result.get(0).get("name"));
    }

    @Test
    public void testProjectionSingleColumn() {
        List<Map<String, Object>> result = db.query("users", List.of("name"));

        assertEquals(4, result.size());
        assertTrue(result.get(0).containsKey("name"));
        assertFalse(result.get(0).containsKey("id"));
    }

    // ------------------------------------------------------------------
    // Part 2 & 3 – WHERE filtering
    // ------------------------------------------------------------------
    @Test
    public void testWhereSimple() {
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("name", "age"),
                row -> (Integer) row.get("age") > 35
        );

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(r -> (Integer) r.get("age") > 35));
    }

    @Test
    public void testWhereMultipleConditions() {
        // id > 1 AND name starts with "C"
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("id", "name"),
                row -> Integer.parseInt((String) row.get("id")) > 1
                        && ((String) row.get("name")).startsWith("C")
        );

        assertEquals(1, result.size());
        assertEquals("Charlie", result.get(0).get("name"));
    }

    @Test
    public void testWhereNoMatch() {
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("name"),
                row -> (Integer) row.get("age") > 100
        );

        assertTrue(result.isEmpty());
    }

    // ------------------------------------------------------------------
    // Part 4 – ORDER BY single column
    // ------------------------------------------------------------------
    @Test
    public void testOrderByNameAscending() {
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("name", "age"),
                null,
                "name"
        );

        assertEquals("Alice", result.get(0).get("name"));
        assertEquals("Alice", result.get(1).get("name"));
        assertEquals("Bob", result.get(2).get("name"));
        assertEquals("Charlie", result.get(3).get("name"));
    }

    @Test
    public void testOrderByAge() {
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("name", "age"),
                null,
                "age"
        );

        assertEquals(32, result.get(0).get("age")); // Charlie
        assertEquals(34, result.get(1).get("age")); // Alice
        assertEquals(36, result.get(2).get("age")); // Alice
        assertEquals(39, result.get(3).get("age")); // Bob
    }

    // ------------------------------------------------------------------
    // Part 5 – ORDER BY multiple columns + direction
    // ------------------------------------------------------------------
    @Test
    public void testOrderByMultipleDescending() {
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("name", "birthday"),
                null,
                List.of("name", "birthday"),
                false   // descending
        );

        // name DESC, then birthday DESC
        assertEquals("Charlie", result.get(0).get("name"));
        assertEquals("Bob",     result.get(1).get("name"));

        // Two Alices – later birthday first
        assertEquals("Alice", result.get(2).get("name"));
        assertEquals("1990-05-15", result.get(2).get("birthday"));

        assertEquals("Alice", result.get(3).get("name"));
        assertEquals("1988-11-01", result.get(3).get("birthday"));
    }

    @Test
    public void testOrderByMultipleAscending() {
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("name", "age"),
                null,
                List.of("name", "age"),
                true
        );

        assertEquals("Alice", result.get(0).get("name"));
        assertEquals(34, result.get(0).get("age"));
        assertEquals("Alice", result.get(1).get("name"));
        assertEquals(36, result.get(1).get("age"));
    }

    // ------------------------------------------------------------------
    // Combined WHERE + ORDER BY
    // ------------------------------------------------------------------
    @Test
    public void testWhereAndOrderBy() {
        List<Map<String, Object>> result = db.query(
                "users",
                List.of("name", "age"),
                row -> (Integer) row.get("age") > 33,
                List.of("age"),
                true
        );

        assertEquals(3, result.size());
        assertEquals(34, result.get(0).get("age"));
        assertEquals(36, result.get(1).get("age"));
        assertEquals(39, result.get(2).get("age"));
    }

    // ------------------------------------------------------------------
    // Error cases
    // ------------------------------------------------------------------
    @Test
    public void testUnknownTable() {
        assertThrows(IllegalArgumentException.class,
                () -> db.query("unknown", List.of("id")));
    }

    @Test
    public void testUnknownColumnInSelect() {
        assertThrows(IllegalArgumentException.class,
                () -> db.query("users", List.of("salary")));
    }

    @Test
    public void testUnknownColumnInOrderBy() {
        assertThrows(IllegalArgumentException.class,
                () -> db.query("users", List.of("name"), null, List.of("salary"), true));
    }

    @Test
    public void testInsertUnknownColumn() {
        assertThrows(IllegalArgumentException.class,
                () -> db.insert("users", Map.of("id", "5", "salary", 100)));
    }

    @Test
    public void testCreateDuplicateTable() {
        assertThrows(IllegalArgumentException.class,
                () -> db.createTable("users", List.of("id")));
    }
}