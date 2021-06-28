package com.example.productlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {
    //a list to store all the products
    var productList: MutableList<Product>? = null

    //the recyclerview
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting the recyclerview from xml
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        //initializing the productlist
        productList = ArrayList<Product>()


        //adding some items to our list
        (productList as ArrayList<Product>).add(
            Product(
                1,
                "Arroz",
                "Ref: 001",
                "Valor: R$20,00",
                "Marca: Vasconcelos",
                "Qtd: 12",
                "Leve 5 pague 4",
                "10% desconto",
                R.drawable.rice))
        (productList as ArrayList<Product>).add(
            Product(
                1,
                "Feijão",
                "Ref: 002",
                "Valor: R$10,00",
                "Marca: Vasconcelos",
                "Qtd: 15",
                "Leve 6 pague 5",
                "5% desconto",
                R.drawable.bean))
        (productList as ArrayList<Product>).add(
            Product(
                1,
                "Detergente",
                "Ref: 003",
                "Valor: R$1,99",
                "Marca: Ypê",
                "Qtd: 100",
                "Leve 10 pague 9",
                "20% desconto",
                R.drawable.bleach))

        //creating recyclerview adapter
        val adapter = ProductAdapter(this, productList as ArrayList<Product>)

        //setting adapter to recyclerview
        recyclerView!!.adapter = adapter
    }
}