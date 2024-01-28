package com.nicepayment.paypro.ui.payment

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicepayment.paypro.model.NicePayment
import com.nicepayment.paypro.model.argument.BarcodeType
import com.nicepayment.paypro.model.argument.PaymentMethod
import com.nicepayment.paypro.model.protocol.Protocol
import com.nicepayment.paypro.order.Goods
import com.nicepayment.paypro.order.Order
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

        class PaymentViewModel<T : NicePayment> : ViewModel() {

            private lateinit var protocol:  Protocol

            private val _amount = MutableStateFlow(0L)
            val amount = _amount.asStateFlow()

            private val _barcode = MutableStateFlow("")
            val barcode = _barcode.asStateFlow()

            private val _barcodeType = MutableStateFlow(BarcodeType.Barcode)
            val barcodeType = _barcodeType.asStateFlow()


            private val _payMethod = MutableStateFlow(PaymentMethod.PayPro)
            val payMethod = _payMethod.asStateFlow()

            fun setAmount(amount: String?) {
                _amount.value = if (amount.isNullOrEmpty()) 0L else amount.toLong()
            }

            fun setOrder(order: Order) {
                order.totalAmount?.let { _amount.value = it.toLong() } ?: 0L
            }
            fun setBarcode(code : String , type: BarcodeType) {
                _barcode.value = code
            }


    fun requestAuthorization(order: Order) {

    }

    fun requestCancellation(order: Order) {

    }
}