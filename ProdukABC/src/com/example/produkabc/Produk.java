package com.example.produkabc;

public class Produk {
	private int id_produk;
	private String nama_barang;
	private String merk_barang;
	private long harga;
	
	public Produk(){
	}

	public int getId_produk() {
		return id_produk;
	}

	public void setId_produk(int id_produk) {
		this.id_produk = id_produk;
	}

	public String getNama_barang() {
		return nama_barang;
	}

	public void setNama_barang(String nama_barang) {
		this.nama_barang = nama_barang;
	}

	public String getMerk_barang() {
		return merk_barang;
	}

	public void setMerk_barang(String merk_barang) {
		this.merk_barang = merk_barang;
	}

	public long getHarga() {
		return harga;
	}

	public void setHarga(long harga) {
		this.harga = harga;
	}
	
	
}
