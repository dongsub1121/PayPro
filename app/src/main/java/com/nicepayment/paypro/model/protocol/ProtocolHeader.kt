package com.nicepayment.paypro.model.protocol

import android.os.Build
import androidx.annotation.RequiresApi
import com.nicepayment.paypro.model.argument.ProtocolState
import com.nicepayment.paypro.model.protocol.Protocol.Companion.state


import java.nio.ByteBuffer
import com.nicepayment.paypro.utils.setArgs
import com.nicepayment.paypro.utils.getDate12

class ProtocolHeader {

    companion object {

        private var jobCode = setArgs(4, "", false)
        private var tid = setArgs(10, "", false)
        private var protocolVersion = setArgs(12, "", false)
        private var swVersion = setArgs(10, "1000100001", false)
        private var hwUniqueId = setArgs(10, "Mpas", false)
        private var ktc = setArgs(32, "", false)
        private var sendDate = setArgs(12, "", false)
        private var filler = setArgs(5, "", false)
        private var packet = "R"


        private fun setMerchant() {
            //TODO implement getMerchant
            "1802100001".also { tid = setArgs(10, it, false) }
        }

        private fun setDate() {
            getDate12().also { sendDate = setArgs(12, it, false) }
        }

        fun setJobCode(value: String) {
            value.also { jobCode = it }
        }

        fun toByteData(): ByteArray {

            setDate()
            setMerchant()

            val buffer = ByteBuffer.allocate(96)
            buffer.put(jobCode.toByteArray(Charsets.UTF_8))
            buffer.put(tid.toByteArray())
            buffer.put(protocolVersion.toByteArray())
            buffer.put(swVersion.toByteArray())
            buffer.put(hwUniqueId.toByteArray())
            buffer.put(ktc.toByteArray())
            buffer.put(sendDate.toByteArray())
            buffer.put(filler.toByteArray())
            buffer.put(packet.toByteArray())

            return buffer.rewind().array() as ByteArray
        }
    }
}