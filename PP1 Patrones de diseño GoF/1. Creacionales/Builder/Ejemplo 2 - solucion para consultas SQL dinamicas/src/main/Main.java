package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    SqlQuery query = new SqlQueryBuilder()
        .select("id, total, status")
        .from("orders")
        .where("status = 'OPEN'")
        .orderBy("created_at")
        .build();
    System.out.println(query);
}
}
