package com.nicepayment.paypro.model.protocol

import com.nicepayment.paypro.model.argument.PaymentData

class LinkBody: BaseProtocolBody() {
    override fun setAmount(value: Int) {
        TODO("Not yet implemented")
    }

    override fun setGoodsName(value: String) {
        TODO("Not yet implemented")
    }

    override fun setTax(value: Int) {
        TODO("Not yet implemented")
    }

    override fun setNoTax(value: Int) {
        TODO("Not yet implemented")
    }

    override fun setTip(value: Int) {
        TODO("Not yet implemented")
    }

    override fun setBarcode(value: String) {
        TODO("Not yet implemented")
    }

    override fun setBarcodeType(value: String) {
        TODO("Not yet implemented")
    }

    override fun setCurrency(value: String) {
        TODO("Not yet implemented")
    }

    override fun setAuthorizationDate(value: String) {
        TODO("Not yet implemented")
    }

    override fun setAuthorizationNumber(value: String) {
        TODO("Not yet implemented")
    }

    override fun toByteData(): ByteArray {
        TODO("Not yet implemented")
    }

    override fun refreshOrderNumber() {
        TODO("Not yet implemented")
    }

    override fun toPaymentData(res: ByteArray): PaymentData {
        TODO("Not yet implemented")
    }
}