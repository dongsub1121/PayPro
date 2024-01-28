@file:Suppress("UNREACHABLE_CODE")

package com.nicepayment.paypro.model.protocol

import com.nicepayment.paypro.model.argument.PaymentData
import com.nicepayment.paypro.utils.getDate12
import com.nicepayment.paypro.utils.getDate6
import com.nicepayment.paypro.utils.getTime6
import com.nicepayment.paypro.utils.setArgs
import java.util.Random

class PayProBody: BaseProtocolBody() {

    private var barcodeType = setArgs(1,"Q",false)
    private var barcode = setArgs(30,"",false)
    private var amount =setArgs(12,"0",true)
    private var tax = setArgs(12,"0",true)
    private var tip = setArgs(12,"0",true)
    private var service = setArgs(3,"",false) // "WXP": 위챗, "ALP": 알리페이, "LI Q"리퀴드페이
    private var catType = setArgs(1,"P", false)
    private var currency = setArgs(3,"KRW",false)
    private var orderNumber = setArgs(12,"",false)
    private var noTax = setArgs(12,"0",true)
    private var exchangeRate = setArgs(24,"0",true)
    private var secondBusinessNumber = setArgs(10,"",false)
    private var authorizationDate = setArgs(6,"",false)
    private var authorizationNumber = setArgs(12,"",false)
    private var cancelType = setArgs(1,"",false)
    private var cancelReason = setArgs(2,"",false)
    private var goodsItem = setArgs(256,"",false)
    private var reserved = setArgs(512,"",false)

        override fun setAmount(value: Int) {
            value.toString().also { amount = it }
        }

        override fun setGoodsName(value: String) {
            TODO("Not yet implemented")
        }

        override fun setTax(value: Int) {
            value.toString().also { tax = it }
    }

    override fun setNoTax(value: Int) {
        value.toString().also { noTax = it }
    }

    override fun setTip(value: Int) {
        value.toString().also { tip = it }
    }

    override fun setBarcode(value: String) {
        value.also { barcode = it }
    }

    override fun setBarcodeType(value: String) {
        value.also { barcodeType = it }
    }

    override fun setCurrency(value: String) {
        value.also { currency = it }
    }

    override fun setAuthorizationDate(value: String) {
        value.also { authorizationDate = it }
    }

    override fun setAuthorizationNumber(value: String) {
        value.also { authorizationNumber = it }
    }

    override fun toByteData(): ByteArray {
        val stringBuffer = StringBuffer()

        stringBuffer.append(barcodeType)
            .append(barcode)
            .append(amount)
            .append(tax)
            .append(tip)
            .append(service)
            .append(catType)
            .append(currency)
            .append(orderNumber)
            .append(noTax)
            .append(exchangeRate)
            .append(secondBusinessNumber)
            .append(authorizationDate)
            .append(authorizationNumber)
            .append(cancelType)
            .append(cancelReason)
            .append(goodsItem)
            .append(reserved)

        return stringBuffer.toString().encodeToByteArray()
    }

    override fun refreshOrderNumber() {
        setOrderNumber()
    }

    private fun setOrderNumber() {
        val random = Random(System.currentTimeMillis()).nextInt(5)
        orderNumber = "M".plus(getTime6()).plus(random)
    }

    override fun toPaymentData(res: ByteArray): PaymentData {
        val point = 116
        val paymentData = PaymentData()

        paymentData.resCode =
            res.sliceArray(point+0 until point+4).toString(Charsets.UTF_8)
        paymentData.msg =
            res.sliceArray(point+4 until point+40).toString(Charsets.UTF_8)
        paymentData.authDate =
            res.sliceArray(point+4 until point+16).toString(Charsets.UTF_8)
        paymentData.authNum =
            res.sliceArray(point+16 until point+28).toString(Charsets.UTF_8)
        paymentData.authOrderNumber =
            res.sliceArray(point+28 until point+40).toString(Charsets.UTF_8)
        paymentData.totPrice =
            res.sliceArray(point+52 until point+64).toString(Charsets.UTF_8).toInt()
        paymentData.issuerCode = res.sliceArray(point+148 until point+151).toString(Charsets.UTF_8)

        paymentData.issuer = when(paymentData.issuerCode){
            "WXP" -> { "WeChat" }
            "ALP" -> { "AliPay" }
            "LIQ" -> { "Liquid" }
            else -> {
                ({}).toString()
            }

        }

        paymentData.orderNumber = res.sliceArray(point+136 until point+148).toString(Charsets.UTF_8)

        return paymentData
    }
}