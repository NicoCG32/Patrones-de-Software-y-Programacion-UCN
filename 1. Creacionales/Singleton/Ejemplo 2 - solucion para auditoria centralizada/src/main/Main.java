package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    AuditLog.getInstance().record("usuario autenticado");
    AuditLog.getInstance().record("orden aprobada");
}
}
