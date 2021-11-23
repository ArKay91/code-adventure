// You are building an application that consists of many different services that can depend on each other. One of these services is the entrypoint which receives user requests and then makes requests to each of its dependencies, which will in turn call each of their dependencies and so on before returning.

// Given a directed acyclic graph that contains these dependencies, you are tasked with determining the "load factor" for each of these services to handle this load. The load factor of a service is defined as the number of units of load it will receive if the entrypoint receives a 1 unit of load. Note that we are interested in the worst case capacity. For a given downstream service, its load factor is the number of units of load it is required to handle if all upstream services made simultaneous requests. For example, in the following dependency graph where A is the entrypoint:

// Each query to A will generate one query to B which will pass it on to C and from there to D. A will also generate a query to C which will pass it on to D, so the worst case (maximum) load factors for each service is A:1, B:1, C:2, D:2.
// (Important: make sure you've fully understood the above example before proceeding!)

// Problem Details

// service_list: An array of strings of format service_name=dependency1,dependency2. Dependencies can be blank (e.g. dashboard=) and non-existent dependency references should be ignored (e.g. prices=users,foobar and foobar is not a service defined in the graph). Each service is defined only once in the graph.
// entrypoint: An arbitrary service that is guaranteed to exist within the graph
// Output: A list of all services depended by (and including) entrypoint as an array of strings with the format service_name*load_factor sorted by service name.
// Example


// RobinHood Software Engineer, Platform & Infrastructure
// # Input:
// service_list = ["logging=", 
//  "user=logging", 
//  "orders=user,foobar", 
//  "recommendations=user,orders", 
//  "dashboard=user,orders,recommendations"]
// entrypoint = "dashboard"

// # Output (note sorted by service name)
// ["dashboard*1", 
//  "logging*4", 
//  "orders*2", 
//  "recommendations*1", 
//  "user*4"]
// [execution time limit] 3 seconds (java)

// [input] array.string service_list

// [input] string entrypoint

// [output] array.string

// [Java] Syntax Tips



package Interviews;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ServiceLoadFactor {

    public static void main(String[] args) {

    }

    String[] solution(String[] service_list, String entrypoint) {
        Map<String, List<String>> adjList = new HashMap<>();
        for(String adjlistEntry : service_list) {
            String[] keyPair = adjlistEntry.split("=");
            String src = keyPair[0];
            //List<String> dependencies = map.getOrDefault(src, new ArrayList<>());
            String[] dependencies;
            if(keyPair.length > 1) {
                dependencies = keyPair[1].split(",");   
                adjList.put(src, Arrays.asList(dependencies));
            } else {
                adjList.put(src, new ArrayList<>());
            }
        }
        Map<String, Integer> service_count = new HashMap<>();
        dfs(entrypoint, service_count, adjList); 
        
        String[] result = new String[service_count.size()];
        int i= 0;
        for(Map.Entry<String, Integer> entry : service_count.entrySet()) {
            result[i++] = entry.getKey() +  "*" + entry.getValue();
        }
        Arrays.sort(result);
        return result;
    }
    
    private void dfs(String node, Map<String, Integer> service_count,  Map<String, List<String>> adjList) {
        if(adjList.containsKey(node)) {
            int final_count = service_count.getOrDefault(node, 0) + 1;
            service_count.put(node, final_count);
            for(String dependency : adjList.get(node)) {
                dfs(dependency, service_count, adjList);
            }    
        }
    }
}
