package org.misspuzzle.puzzle.gpt;

import java.util.*;

public class ClusterTopology {

    class Node {
        String id;
        Node parent;
        List<Node> children;

        // ===== idempotency =====
        Set<String> processedRequests;

        // ===== state for counting =====
        int totalCount = 0;
        Set<String> pendingCountChildren;
        Map<String, Integer> cachedCount;

        // ===== state for counting =====
        List<String> topologyStrings;
        Set<String> pendingTopologyChildren;

        Node(String id, Node parent) {
            this.id = id;
            this.parent = parent;

            children = new ArrayList<>();
            processedRequests = new HashSet<>();

            pendingCountChildren = new HashSet<>();
            cachedCount = new HashMap<>();

            topologyStrings = new ArrayList<>();
            pendingTopologyChildren = new HashSet<>();
        }

        public void sendAsyncMessage(Node node, String message) {
            // runtime will call the target’s receiveMessage
            node.receiveMessage(id, message);
        }

        // message = "command?param1=value&param2=value"
        public void receiveMessage(String fromNodeId, String message) {
            String command;
            Map<String, String> params = new HashMap<>();

            int split = message.indexOf('?');
            if (split == -1) {
                command = message;
            } else {
                command = message.substring(0, split);
                parseParam(params, message.substring(split + 1));
            }

            String requestId = params.get("requestId");

            switch (command) {
                case "count":
                    handleCountRequest(requestId);
                    break;
                case "countResponse":
                    handleCountResponse(fromNodeId, params);
                    break;
                case "topology":
                    handleTopologyRequest();
                    break;
                case "topologyResponse":
                    handleTopologyResponse(fromNodeId, params);
                    break;
                default:
                    break;
            }
        }

        private void handleCountRequest(String requestId) { 
            // ===== Idempotency check =====
            if (requestId != null && processedRequests.contains(requestId)) {
                // Already processed this request.
                // Optionally resend the cached answer.
                if (cachedCount.containsKey(requestId) && parent != null) {
                    sendAsyncMessage(parent,
                        "countResponse?requestId=" + requestId + "&value=" + cachedCount.get(requestId));
                }
                return;
            }
            if (requestId != null) {
                processedRequests.add(requestId);
            }
            
            // Reset state for a new count request
            // count myself
            totalCount = 1;
            pendingCountChildren.clear();

            if (children.isEmpty()) {
                replyCount(requestId);
                return;
            }

            // 1. Register all children first
            for (Node child : children) {
                pendingCountChildren.add(child.id);
            }

            // 2. Now send the requests
            for (Node child : children) {
                sendAsyncMessage(child, "count?requestId=" + requestId);
            }
        }

        private void handleCountResponse(String fromNodeId, Map<String, String> params) {
            if (!pendingCountChildren.contains(fromNodeId)) {
                return;
            }

            int childCount = Integer.parseInt(params.getOrDefault("value", "0"));
            totalCount += childCount;
            pendingCountChildren.remove(fromNodeId);

            // All children have answered
            if (pendingCountChildren.isEmpty()) {
                replyCount(params.get("requestId"));
            }
        }

        private void replyCount(String requestId) {
            // Cache the result for possible retransmissions
            if (requestId != null) {
                cachedCount.put(requestId, totalCount);
            }

            if (parent == null) {
                // Root: print the final result
                System.out.println(totalCount);
            } else {
                // Internal/leaf: send result to parent
                sendAsyncMessage(parent, "countResponse?requestId=" + requestId + "&value=" + totalCount);
            }

            // Optional: reset state so the node can be reused
            totalCount = 0;
            pendingCountChildren.clear();
        }

        private void handleTopologyRequest() {            
            // Reset state for a new count request
            // count myself
            topologyStrings.clear();
            pendingTopologyChildren.clear();

            if (children.isEmpty()) {
                replyTopology();
                return;
            }

            // 1. Register all children first
            for (Node child : children) {
                pendingCountChildren.add(child.id);
            }

            // 2. Now send the requests
            for (Node child : children) {
                sendAsyncMessage(child, "topology");
            }
        }

        private void handleTopologyResponse(String fromNodeId, Map<String, String> params) {
            String childStr = params.getOrDefault("value", fromNodeId + "()");
            topologyStrings.add(childStr);
            pendingCountChildren.remove(fromNodeId);

            // All children have answered
            if (pendingCountChildren.isEmpty()) {
                replyTopology();
            }
        }

        private void replyTopology() {
            String result = this.id + "(" + String.join(",", topologyStrings) + ")";

            if (parent == null) {
                // Root: print the final result
                System.out.println(result);
            } else {
                // Internal/leaf: send result to parent
                sendAsyncMessage(parent, "topologyResponse?value=" + result);
            }

            // Optional: reset state so the node can be reused
            totalCount = 0;
            pendingCountChildren.clear();
        }

        private void parseParam(Map<String, String> params, String paramStr) {
            for (String pair : paramStr.split("&")) {
                String[] kv = pair.split("=", 2);

                if (kv.length == 2) {
                    params.put(kv[0], kv[1]);
                }
            }
        }
    }







    
}