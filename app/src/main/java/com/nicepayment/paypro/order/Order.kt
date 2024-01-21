package com.nicepayment.paypro.order

import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import kotlin.random.Random

data class Order(
    var orderId: String?,
    var orderName: String?,
    var totalAmount: Number?,
    var goods: MutableList<Goods>?
) {

    companion object {
        fun create(newGoods: Goods): Order {
            val id = "nice${formatYyMmDdHhMmSs()}${Random(4)}"
            val amount = newGoods.price.toLong() * newGoods.quantity
            val mutableList = mutableListOf<Goods>()
            mutableList.add(newGoods)

            return Order(id, newGoods.name, amount, mutableList)
        }
    }

    fun add(newGoods: Goods) {
        val amount = newGoods.price.toDouble() * newGoods.quantity

        orderName = orderName?.let {
            "${goods?.get(0)?.name} 외 ${goods?.size?.minus(1)} 건 "
        } ?: newGoods.name

        orderId = orderId?.let {
            orderId
        } ?: "nice${formatYyMmDdHhMmSs()}${Random(4)}"

        totalAmount = totalAmount?.let {
            it.toDouble() + amount
        } ?: amount

        goods?.add(newGoods)
    }
}

fun formatYyMmDdHhMmSs(): String {
    val date = Date()
    val dateFormat = SimpleDateFormat("yyMMddHHmmss")
    return dateFormat.format(date)
}

data class Goods (
    val name: String,
    val price: Number,
    val quantity: Int
)
