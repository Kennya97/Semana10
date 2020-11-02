package com.example.mysql;

public class dto_producto {
    int id_pro;
    String nom_pro;
    String des_pro;
    double stock;
    double precio;
    int unidad_medida;
    int estado_pro;
    int categoria;

    public dto_producto() {
    }

    public dto_producto(int id_pro, String nom_pro, String des_pro, double stock, double precio, int unidad_medida, int estado_pro, int categoria) {
        this.id_pro = id_pro;
        this.nom_pro = nom_pro;
        this.des_pro = des_pro;
        this.stock = stock;
        this.precio = precio;
        this.unidad_medida = unidad_medida;
        this.estado_pro = estado_pro;
        this.categoria = categoria;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getNom_pro() {
        return nom_pro;
    }

    public void setNom_pro(String nom_pro) {
        this.nom_pro = nom_pro;
    }

    public String getDes_pro() {
        return des_pro;
    }

    public void setDes_pro(String des_pro) {
        this.des_pro = des_pro;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(int unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public int getEstado_pro() {
        return estado_pro;
    }

    public void setEstado_pro(int estado_pro) {
        this.estado_pro = estado_pro;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
