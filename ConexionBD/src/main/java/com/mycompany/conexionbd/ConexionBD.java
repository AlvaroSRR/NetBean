package com.mycompany.conexionbd;

import java.sql.*;
import java.util.*;

public class ConexionBD {

    public static void main(String[] args) {
        
        // MOSTRAR DATOS
        
        //agrega una columna a la tabla en la bd
        /*String sql = "ALTER TABLE Clientes ADD coLumn apellido VARCHAR(45)";
            stmt.executeUpdate(sql);*/
        
        try { // abrir conexion
            Class.forName("com.mysql.cj.jdbc.Driver"); // conexion con el driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_jdbc", "root", "33411494"); //conexion a la BD
            Statement stmt = con.createStatement(); //instancia un statement
            // sentencia para buscar la info
            ResultSet rs = stmt.executeQuery("select * from clientes");

            //creo coleccion para guardar los datos
            List<Cliente> clientesOrdenados = new ArrayList<>();
            TreeSet<Cliente> clienteOrdenado = new TreeSet<>();
            while (rs.next()) //guardamos los datos que leemos en la coleccion
            {
                clienteOrdenado.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3)));
                clientesOrdenados.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            con.close();
            System.out.println(clientesOrdenados);
            System.out.println(clienteOrdenado);
        } catch (Exception e) {
            System.out.println(e);
        }

 
        // REGISTRAR DATOS 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_jdbc", "root", "33411494");
            //Statement stmt = con.createStatement();
            /* Scanner sc = new Scanner(System.in);
            sc.nextLine(); // genera error
            System.out.print("nombre: ");
            String nombre = sc.nextLine();
            System.out.println("apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Id: ");
            int id = sc.nextInt();
            String sql = "INSERT into Cliente (codCliente,nombre,apellido) VALUES ("+id+",'"+nombre+"','"+apellido+"')";
            stmt.executeUpdate(sql);
            con.close();*/

            //prepare statement
            Scanner sc = new Scanner(System.in);
            System.out.print("nombre: ");
            String nombre = sc.nextLine();
            System.out.println("apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Id: ");
            int id = sc.nextInt();
            Cliente c = new Cliente(id, nombre, apellido);

            String sql = "INSERT INTO clientes (codCliente, nombre, apellido) VALUES (?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, c.getCodigo());
                ps.setString(2, c.getNombre());
                ps.setString(3, c.getApellido());
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
