package com.nicepayment.paypro.model.argument

import android.os.Parcelable
import com.nicepayment.paypro.order.Order
import kotlinx.parcelize.Parcelize
@Parcelize
data class PaymentArgument(
    var method: PaymentMethod? = PaymentMethod.PayPro,
    val totalAmount: Int?= 0,
    val barcode: String? = "",
    val barcodeType: BarcodeType? = BarcodeType.Barcode
) : Parcelable