package com.example.productlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import java.lang.String


class ProductAdapter(
    //this context we will use to inflate the layout
    private val mCtx: Context,
    productList: List<Product>
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    //we are storing all the products in a list
    private val productList: List<Product>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        //inflating and returning our view holder
        val inflater = LayoutInflater.from(mCtx)
        val view = inflater.inflate(R.layout.layout_products, null)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        //getting the product of the specified position
        val product: Product = productList[position]

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.title)
        holder.textViewValue.setText(product.price)
        holder.textViewRef.setText(String.valueOf(product.ref))
        holder.textViewBrand.setText(String.valueOf(product.brand))
        holder.textViewQtd.setText(String.valueOf(product.qtd))
        holder.buttonDiscount.setText(String.valueOf(product.discount))
        holder.buttonSale.setText(String.valueOf(product.sale))
        holder.imageView.setImageDrawable(mCtx.resources.getDrawable(product.image))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView
        var textViewValue: TextView
        var textViewRef: TextView
        var textViewBrand: TextView
        var textViewQtd: TextView
        var buttonDiscount: Button
        var buttonSale: Button
        var imageView: ImageView

        init {
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            textViewValue = itemView.findViewById(R.id.textViewValue)
            textViewRef = itemView.findViewById(R.id.textViewRef)
            textViewBrand = itemView.findViewById(R.id.textViewBrand)
            textViewQtd = itemView.findViewById(R.id.textViewQtd)
            buttonDiscount = itemView.findViewById(R.id.buttonDiscount)
            buttonSale = itemView.findViewById(R.id.buttonSale)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    //getting the context and product list with constructor
    init {
        this.productList = productList
    }
}