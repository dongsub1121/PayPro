package com.nicepayment.paypro.interfaces

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


sealed interface NicePaymentResult{
    @Parcelize
    class Success(
        val paymentKey: String,
        val orderId: String,
        val amount: Number,
        val additionalParameters: Map<String, String>
    ) : NicePaymentResult, Parcelable

    @Parcelize
    class Fail(
        val errorCode: String,
        val errorMessage: String,
        val orderId: String?
    ) : NicePaymentResult, Parcelable

    @Parcelize
    class Progress(
        val status : String
    ) : NicePaymentResult, Parcelable
}