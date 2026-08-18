package org.misspuzzle.puzzle.gpt;

import java.util.*;
import java.util.function.Predicate;

public class InMemoryDatabase {

    // ------------------------------------------------------------------
    // Table
    // ------------------------------------------------------------------
    public static class Table {
        private final String name;
        private final Map<String, Integer> columnIndex = new LinkedHashMap<>();
        private final List<Object[]> rows = new ArrayList<>();

        public Table(String name, List<String> columns) {
            this.name = name;
            int idx = 0;
            for (String col : columns) {
                columnIndex.put(col, idx++);
            }
        }

        public void insert(Map<String, Object> rowData) {
            Object[] row = new Object[columnIndex.size()];
            for (Map.Entry<String, Object> e : rowData.entrySet()) {
                Integer idx = columnIndex.get(e.getKey());
                if (idx == null) {
                    throw new IllegalArgumentException("Unknown column: " + e.getKey());
                }
                row[idx] = e.getValue();
            }
            rows.add(row);
        }

        /**
         * Full query supporting:
         * - Projection
         * - WHERE (Predicate – supports any complex logic / multiple conditions)
         * - ORDER BY (multiple columns + direction)
         */
        public List<Map<String, Object>> query(List<String> selectColumns,
                                               Predicate<Map<String, Object>> where,
                                               List<String> orderByColumns,
                                               boolean ascending) {

            // Validate select columns
            int[] selectIdx = new int[selectColumns.size()];
            for (int i = 0; i < selectColumns.size(); i++) {
                Integer idx = columnIndex.get(selectColumns.get(i));
                if (idx == null) throw new IllegalArgumentException("Unknown column: " + selectColumns.get(i));
                selectIdx[i] = idx;
            }

            // Validate order-by columns
            if (orderByColumns != null) {
                for (String col : orderByColumns) {
                    if (!columnIndex.containsKey(col)) {
                        throw new IllegalArgumentException("Unknown order by column: " + col);
                    }
                }
            }

            // 1. Filter
            List<Object[]> filtered = new ArrayList<>();
            for (Object[] row : rows) {
                if (where != null) {
                    Map<String, Object> mapRow = toMap(row);
                    if (!where.test(mapRow)) continue;
                }
                filtered.add(row);
            }

            // 2. Sort
            if (orderByColumns != null && !orderByColumns.isEmpty()) {
                filtered.sort((r1, r2) -> {
                    for (String col : orderByColumns) {
                        int idx = columnIndex.get(col);
                        Comparable v1 = (Comparable) r1[idx];
                        Comparable v2 = (Comparable) r2[idx];

                        if (v1 == null && v2 == null) continue;
                        if (v1 == null) return ascending ? -1 : 1;
                        if (v2 == null) return ascending ? 1 : -1;

                        int cmp = v1.compareTo(v2);
                        if (cmp != 0) {
                            return ascending ? cmp : -cmp;
                        }
                    }
                    return 0;
                });
            }

            // 3. Project
            List<Map<String, Object>> result = new ArrayList<>();
            for (Object[] row : filtered) {
                Map<String, Object> projected = new LinkedHashMap<>();
                for (int i = 0; i < selectColumns.size(); i++) {
                    projected.put(selectColumns.get(i), row[selectIdx[i]]);
                }
                result.add(projected);
            }
            return result;
        }

        private Map<String, Object> toMap(Object[] row) {
            Map<String, Object> map = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> e : columnIndex.entrySet()) {
                map.put(e.getKey(), row[e.getValue()]);
            }
            return map;
        }
    }

    // ------------------------------------------------------------------
    // Database
    // ------------------------------------------------------------------
    private final Map<String, Table> tables = new HashMap<>();

    public void createTable(String tableName, List<String> columns) {
        if (tables.containsKey(tableName)) {
            throw new IllegalArgumentException("Table already exists: " + tableName);
        }
        tables.put(tableName, new Table(tableName, columns));
    }

    public void insert(String tableName, Map<String, Object> row) {
        getTable(tableName).insert(row);
    }

    // ---------- Convenience overloads ----------

    // Part 1 – projection only
    public List<Map<String, Object>> query(String tableName, List<String> columns) {
        return query(tableName, columns, null, null, true);
    }

    // Part 2/3 – with WHERE
    public List<Map<String, Object>> query(String tableName,
                                           List<String> columns,
                                           Predicate<Map<String, Object>> where) {
        return query(tableName, columns, where, null, true);
    }

    // Part 4 – single column ORDER BY (ascending)
    public List<Map<String, Object>> query(String tableName,
                                           List<String> columns,
                                           Predicate<Map<String, Object>> where,
                                           String orderBy) {
        List<String> orderCols = orderBy == null ? null : List.of(orderBy);
        return query(tableName, columns, where, orderCols, true);
    }

    // Part 5 – full power: multiple columns + direction
    public List<Map<String, Object>> query(String tableName,
                                           List<String> columns,
                                           Predicate<Map<String, Object>> where,
                                           List<String> orderByColumns,
                                           boolean ascending) {
        return getTable(tableName).query(columns, where, orderByColumns, ascending);
    }

    private Table getTable(String tableName) {
        Table t = tables.get(tableName);
        if (t == null) throw new IllegalArgumentException("Table does not exist: " + tableName);
        return t;
    }
}