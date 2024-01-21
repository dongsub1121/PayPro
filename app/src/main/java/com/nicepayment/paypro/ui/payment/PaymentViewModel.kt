package com.nicepayment.paypro.ui.payment

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicepayment.paypro.model.NicePayment
import com.nicepayment.paypro.order.Goods
import com.nicepayment.paypro.order.Order
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class PaymentViewModel<T : NicePayment> : ViewModel() {

    private val _amount = MutableStateFlow(0L)
    val amount = _amount.asStateFlow()

    protected val _barcode = MutableStateFlow("")
    val barcode = _barcode.asStateFlow()

    protected val _payMethod = MutableStateFlow("PAYPRO")
    val payMethod = _payMethod.asStateFlow()

    fun setAmount(amount: String?) {
        _amount.value = if (amount.isNullOrBlank()) 0L else amount.toLong()
    }

    fun setOrder(order: Order) {
        order.totalAmount?.let { _amount.value = it.toLong() } ?: 0L
    }
    fun setBarcode(code : String) {
         _barcode.value = code
    }

    fun setPayMethod(method: String) {
        _barcode.value = method
    }

    fun requestAuthorization(order: Order) {

    }

    fun requestCancellation(order: Order) {

    }
}