package com.nicepayment.paypro.interfaces

interface NicePaymentCallback {
    fun onSuccess(success: NicePaymentResult.Success)
    fun onFailed(fail: NicePaymentResult.Fail)
    fun onProgress(progress : NicePaymentResult.Progress)

}