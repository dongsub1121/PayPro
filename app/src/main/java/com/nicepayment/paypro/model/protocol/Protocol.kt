package com.nicepayment.paypro.model.protocol

import android.os.Build.VERSION_CODES.P
import com.nicepayment.paypro.model.argument.PaymentArgument
import com.nicepayment.paypro.model.argument.PaymentMethod
import com.nicepayment.paypro.model.argument.PaymentStatus
import com.nicepayment.paypro.model.argument.ProtocolState
import com.nicepayment.paypro.utils.setArgs

class Protocol {
    companion object {
        var argument: PaymentArgument? = null
        val state = ProtocolState.Authorization

        var stx: Byte = 0x02
        var totalLen = setArgs(4, "", true)
        var identity: Int = 0x1212
        var specVersion = setArgs(3, "PFC", false)
        var dllVersion = setArgs(8, "1.01.001", false)
        var cancelTransaction = setArgs(1, "0", false)
        var filler = setArgs(1, " ", false)
        var header = ProtocolHeader
        var body: BaseProtocolBody? = null
        var etx: Byte = 0x03

        fun setArgument(argument: PaymentArgument) {
            this.argument = argument
            this.body = setBody(argument)
        }

        fun setState(protocolState: ProtocolState) {
            argument?.method?.let { setJobCode(it,protocolState ) }
        }

        private fun setJobCode(method: PaymentMethod , state: ProtocolState) {
            if (method == PaymentMethod.PayPro && state == ProtocolState.Authorization) {
                header.setJobCode("0000")
            } else if (method == PaymentMethod.PayPro && state == ProtocolState.Inquiry) {
                header.setJobCode("0010")
            } else if (method == PaymentMethod.PayPro && state == ProtocolState.NetCancel) {
                header.setJobCode("0020")
            }
        }

        private fun setBody(argument: PaymentArgument): BaseProtocolBody? {
            return when(argument.method) {
                PaymentMethod.PayPro -> {
                    PayProBody()
                }
                PaymentMethod.Link -> {
                    LinkBody()
                }

                else -> {PayProBody()}
            }
        }
    }

}

