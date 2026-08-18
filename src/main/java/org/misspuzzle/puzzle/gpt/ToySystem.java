package org.misspuzzle.puzzle.gpt;

import java.util.*;

public class ToySystem {

    public static class Node {
        public final String name;
        public final List<Node> children;

        public Node(String name) {
            this.name = name;
            children = null;
        }

        public Node(List<Node> children) {
            this.name = null;
            this.children = children;
        }

        @SuppressWarnings("unchecked")
        public Node(Object o) {
            if (o instanceof String) {
                this.name = (String) o;
                this.children = null;
            } else if (o instanceof List) {
                this.name = null;
                this.children = (List<Node>) o;
            } else {
                throw new IllegalArgumentException("...");
            }
        }

        public boolean isLeaf() {
            return children == null;
        }

        public boolean isGeneric() {
            return isLeaf() && name.length() > 0 && Character.isUpperCase(name.charAt(0));
        }

        public String toStr() {
            if (isLeaf()) {
                return name;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');

            for (Node node : children) {
                sb.append(node.toStr());
                sb.append(',');
            }

            // Remove tailing ","
            if (sb.length() > 1) {
                sb.setLength(sb.length() - 1);
            }

            sb.append(']');

            return sb.toString();
        }

        @Override
        public String toString() {
            return toStr();
        }
    }

    public static class Function {
        public final List<Node> params;
        public final Node returnType;

        public Function(List<Node> params, Node returnType) {
            this.params = params;
            this.returnType = returnType;
        }

        public String toStr() {
            StringBuilder sb = new StringBuilder();

            // Params
            sb.append('(');
            for (Node node : params) {
                sb.append(node.toStr());
                sb.append(',');
            }

            // Remove tailing ","
            if (sb.length() > 1) {
                sb.setLength(sb.length() - 1);
            }

            sb.append(')');

            // ->
            sb.append(" -> ");

            // Return type
            sb.append(returnType.toStr());

            return sb.toString();
        }
    }

    public static Node getReturnType(List<Node> params, Function func) throws Exception {

        Map<String, String> match = new HashMap<>();

        dfs(match, params, func.params);

        return buildReturnNode(match, func.returnType);
    }

    private static void dfs(Map<String, String> match, List<Node> params, List<Node> paramsExpected) throws Exception {
        if (params.size() != paramsExpected.size()) {
            throw new Exception("Argument Count Mismatch");
        }

        for (int i = 0; i < params.size(); i++) {
            Node node1 = params.get(i);
            Node node2 = paramsExpected.get(i);

            if (node2.isLeaf()) {
                if (node1.isLeaf()) {
                    if (node2.isGeneric()) {
                        if (match.containsKey(node2.name)) {
                            if (!node1.name.equals(match.get(node2.name))) {
                                throw new Exception("Generic Conflict");        
                            }
                        } else {
                            match.put(node2.name, node1.name);
                        }
                    } else if (!node1.name.equals(node2.name)) {
                        throw new Exception("Type Mismatch");
                    }
                } else {
                    String node1Str = node1.toStr();
                    if (match.containsKey(node2.name)) {
                        if (!node1Str.equals(match.get(node2.name))) {
                            throw new Exception("Generic Conflict");        
                        }
                    } else {
                        match.put(node2.name, node1Str);
                    }
                }
            } else {
                if (node1.isLeaf()) {
                    throw new Exception("Type Mismatch");
                }

                dfs(match, node1.children, node2.children);
            }
        }
    }

    private static Node buildReturnNode(Map<String, String> match, Node node) {
        if (node.isLeaf()) {
            String name = node.isGeneric() ? match.get(node.name) : node.name;
            
            return new Node(name);
        } else {
            List<Node> result = new ArrayList<>();

            for (Node n : node.children) {
                result.add(buildReturnNode(match, n));
            }

            return new Node(result);
        }
    }
}