package com.nicepayment.paypro.model.argument

import java.lang.StringBuilder

data class PaymentData(
    var issuerCode: String = "",
    var issuer: String = "",
    var orderNumber: String = "",
    var barcodeType: String = "",
    var barcode: String? = "",
    var authDate: String = "",
    var authNum: String = "",
    var authOrderNumber: String = "",
    var totPrice: Int = 0,
    var resCode: String = "",
    var msg: String ="",
    var status: PaymentStatus? = null,
    var service: PaymentMethod? = null){

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("issuer = $issuer")
        sb.append("orderNumber = $orderNumber")
        sb.append("barcodeType = $barcodeType")
        sb.append("barcode = $barcode")
        sb.append("authDate = $authDate")
        sb.append("authNum = $authNum")
        sb.append("authOrderNumber = $authOrderNumber")
        sb.append("totPrice = $totPrice")
        sb.append("resCode = $resCode")
        sb.append("msg = $msg")
        return sb.toString()
    }
}